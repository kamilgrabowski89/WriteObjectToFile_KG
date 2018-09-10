package WriteObjectToFile;

import WriteObjectToFile.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

     private String finalUrl;

    public WeatherService(String url, String key) {
        finalUrl = url + "?key=" + key;
    }

    public Weather getCityWeaher(String city)  {

        Weather weather = new Weather();
        String url = finalUrl + "&q=" + city;
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(
                    IOUtils.toString(new URL(url),
                            Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonObject.toString());

        System.out.println(jsonObject.getJSONObject("location").get("name"));
        System.out.println(jsonObject.getJSONObject("current").getJSONObject("condition").get("icon"));
        System.out.println(jsonObject.getJSONObject("current").get("temp_c"));
        System.out.println(jsonObject.getJSONObject("current").get("feelslike_c"));
        System.out.println(jsonObject.getJSONObject("current").getJSONObject("condition").get("text"));
        System.out.println(jsonObject.getJSONObject("location").get("lat"));
        System.out.println(jsonObject.getJSONObject("location").get("lon"));


        weather.setCity(jsonObject.getJSONObject("location").get("name").toString());
        weather.setIconUrl(jsonObject.getJSONObject("current").getJSONObject("condition").get("icon").toString());
        weather.setTemperature((Double) jsonObject.getJSONObject("current").get("temp_c"));
        weather.setFeelslikeC((Double) jsonObject.getJSONObject("current").get("feelslike_c"));
        weather.setConditionText(jsonObject.getJSONObject("current").getJSONObject("condition").get("text").toString());
        weather.setLon((Double) jsonObject.getJSONObject("location").get("lat"));
        weather.setLat ((Double) jsonObject.getJSONObject("location").get("lon"));



        return weather;
    }
}