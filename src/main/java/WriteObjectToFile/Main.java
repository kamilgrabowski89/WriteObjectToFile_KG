package WriteObjectToFile;

import WriteObjectToFile.Weather;
import WriteObjectToFile.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "d48c0d5e40054b6a9e571834181808"
        );
        weatherService.getCityWeaher("Paris");


        List<Weather> weathers = new ArrayList<Weather>();

        Weather weather = new Weather(
                "Bydgoszcz",
                "www",
                40,
                60,
                "Slonecznie",
                54.54,
                21.23
        );
        Weather weather2 = new Weather(
                "Gdansk",
                "www",
                40,
                60,
                "Slonecznie",
                54.54,
                21.23
        );

        weathers.add(weather);
        weathers.add(weather2);

        ObjectMapper objectMapper = new ObjectMapper();
        File filename = new File("weather.json");
        try {
            objectMapper.writeValue(filename, weathers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Weather[] readWeather = objectMapper.readValue(filename, Weather[].class);

            for (Weather w: readWeather){
                System.out.println(w.getCity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



