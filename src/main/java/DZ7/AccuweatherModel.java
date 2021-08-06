package DZ7;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
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
    private static final String API_KEY = "pXJd8MokcZCdrd2MsoGl2DBZAyCa0zvv";//"RqAiF0YGmkBysgUHm6wjXakLKqGMvgIL";// "1KSWsbwEl01iKnNrUUWAiwZBXgrAixm8";    //
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
    private final List<List<String>> weatherWeek = new ArrayList<>();


    public void getWeather(String selectedCity, Period period) throws IOException {


        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC_QUERY_DECEL)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE_QUERY_RU)
                        .build();


                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение

                Response ForecastResponse = okHttpClient.newCall(request).execute();
                weatherResponse = ForecastResponse.body().string();
                //    System.out.println(weatherResponse);

                outData = objectMapper2.readTree(weatherResponse).get("DailyForecasts").at("/0").at("/Date").asText();
                outData = outData.substring(0, 10);
                outTemp = objectMapper2.readTree(weatherResponse).get("DailyForecasts").at("/0").at("/Temperature")
                        .at("/Maximum").at("/Value").asText();

                outRain = objectMapper2.readTree(weatherResponse).get("DailyForecasts").at("/0").at("/Day")
                        .at("/IconPhrase").asText();


                System.out.println(selectedCity);
                System.out.println(outData);
                System.out.print(outTemp);
                System.out.println(" \u2103");
                System.out.println(outRain);
                System.out.println();
                break;


            case FIVE_DAYS:

                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
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
        }


        //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
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

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}