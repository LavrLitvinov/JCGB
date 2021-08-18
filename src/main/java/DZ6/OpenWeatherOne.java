package DZ6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OpenWeatherOne {


    public static void main(String[] args) throws IOException {



    /*
    *    *
    * api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}
    *  "id": 498817,
        "name": "Saint Petersburg",
        "state": "",
        "country": "RU",
        "coord": {
            "lon": 30.264168,
            "lat": 59.894444
    *
    * */


        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.openweathermap.org")
                .addPathSegment("/data/2.5/forecast")
                .addQueryParameter("q","Saint Petersburg")
                .addQueryParameter("appid","24e7cac0c4085b183ce23a68a34fcc0c")
                .addQueryParameter("lang", "ru")
                .addQueryParameter("units", "metric")
                .addQueryParameter("cnt", "1")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        String body = response.body().string();
        System.out.println(body);

    }
}
