package DZ8;


import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccuweatherModel implements WeatherModel {

    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String METRIC_QUERY_PARAM = "metric";
    private static final String METRIC_QUERY_DECEL = "true";
    private static final String LANGUAGE_QUERY_PARAM = "language";
    private static final String LANGUAGE_QUERY_RU = "ru";

    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "RqAiF0YGmkBysgUHm6wjXakLKqGMvgIL";//"pXJd8MokcZCdrd2MsoGl2DBZAyCa0zvv";// "1KSWsbwEl01iKnNrUUWAiwZBXgrAixm8";    //
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";


    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectMapper objectMapper1 = new ObjectMapper();
    private static final ObjectMapper objectMapper2 = new ObjectMapper();
    private static final ObjectMapper objectMapper3 = new ObjectMapper();
    private String outData;
    private String outTemp;
    private String outRain;
    private String weatherResponse;
    private String buffer;
    private String cityKey;
    private String responseCityKey;
    private final List<List<String>> weatherWeek = new ArrayList<>();


    public void getWeather(String selectedCity, Period period) throws IOException {





        switch (period) {
            case NOW:
                responseCityKey = detectCityKey(selectedCity);
                if (responseCityKey == "Nan") return;
                /* Эту проверку надо проводить в момент пользовательского ввода,
                * но для этого придется перебирать всю логику. Влом, ну честно.
                * И в таком виде проходят названия городов в виде чисел. Есть ответ до города № 304 включительно.
                *
                *   301
                *   2021-08-07
                *   25.3 ℃
                *  Переменная облачность
                * */
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(responseCityKey)
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC_QUERY_DECEL)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE_QUERY_RU)
                        .build();


                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();


                Response ForecastResponse = okHttpClient.newCall(request).execute();
                weatherResponse = ForecastResponse.body().string();

                outData = objectMapper2.readTree(weatherResponse).get("DailyForecasts").at("/0").at("/Date").asText();
                outData = outData.substring(0, 10);
                outTemp = objectMapper2.readTree(weatherResponse).get("DailyForecasts").at("/0").at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                outTemp = outTemp + " \u2103";
                outRain = objectMapper2.readTree(weatherResponse).get("DailyForecasts").at("/0").at("/Day")
                        .at("/IconPhrase").asText();

                System.out.println(selectedCity);
                System.out.println(outData);
                System.out.println(outTemp);
                //    System.out.println(" \u2103");
                System.out.println(outRain);
                System.out.println();
                writeInBaze(selectedCity, responseCityKey, outData,
                        outTemp, outRain);

                break;


            case FIVE_DAYS:
                responseCityKey = detectCityKey(selectedCity);
                if (responseCityKey == "Nan") return;
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(responseCityKey)
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC_QUERY_DECEL)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE_QUERY_RU)
                        .build();


                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение

                Response ForecastResponse1 = okHttpClient.newCall(request1).execute();
                weatherResponse = ForecastResponse1.body().string();
                //    System.out.println(weatherResponse);

                for (int i = 0; i < 5; i++) {
                    buffer = "/" + i;
                    outData = objectMapper1.readTree(weatherResponse).get("DailyForecasts").at(buffer).at("/Date").asText();
                    outData = outData.substring(0, 10);
                    outTemp = objectMapper1.readTree(weatherResponse).get("DailyForecasts").at(buffer).at("/Temperature")
                            .at("/Maximum").at("/Value").asText();
                    outTemp = outTemp + " \u2103";
                    outRain = objectMapper1.readTree(weatherResponse).get("DailyForecasts").at(buffer).at("/Day").at("/IconPhrase").asText();
                    weatherWeek.add(Arrays.asList(selectedCity, outData, outTemp, outRain));

                }

                for (List<String> row : weatherWeek) {
                    System.out.println(row.toString());
                }
                weatherWeek.clear();
                break;
            case ARCHIVE:
                readInBaze(selectedCity);
                break;

        }

    }


    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseString = response.body().string();

        try {
            cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        } catch (NullPointerException e) {
            System.out.println("В базе нет города с таким названием.");
            cityKey = "Nan";
        }

        return cityKey;
    }

    private void readInBaze(String selectCity) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lerner.db");
            Statement statement = connection.createStatement();

            String buff = "select * from weatherCity where city = \"" + selectCity + "\"";

            ResultSet resultSet = statement.executeQuery(buff);
          //  System.out.println("resultSet.next: " + resultSet.next());


            int cnt = 0;
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("city"));
                System.out.print(" ");
                System.out.print(resultSet.getInt("cityKey"));
                System.out.print(" ");
                System.out.print(resultSet.getString("data"));
                System.out.print(" ");
                System.out.print(resultSet.getString("temp"));
                System.out.print(" ");
                System.out.print(resultSet.getString("rain"));
                System.out.println();
                cnt += 1;
            }
            if (cnt == 0){
                System.out.println("В архиве нет данных о погоде в городе с таким названием.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    private void writeInBaze(String selectCity, String responseCityKey, String outData,
                             String outTemp, String outRain) {
        int cityKey = Integer.parseInt(responseCityKey);
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lerner.db");
            Statement statement = connection.createStatement();

            String buff = "insert into weatherCity (city, cityKey, data, temp, rain ) values (\"" + selectCity + "\",\"" + cityKey + "\",\"" + outData + "\",\"" + outTemp + "\",\"" + outRain + "\")";
         //   System.out.println("buff: " + buff);
            statement.executeUpdate(buff);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}