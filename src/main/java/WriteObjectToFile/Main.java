package WriteObjectToFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List <Weather> weatherList = new ArrayList <Weather>();

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
                "Torun",
                "www",
                0,
                0,
                "Leje",
                0.0,
                0.0
        );

        Weather weather3 = new Weather(
                "Gdansk",
                "www",
                30,
                50,
                "Deszcz",
                20.20,
                20.20
        );
        weatherList.add(weather);
        weatherList.add(weather2);
        weatherList.add(weather3);

        ObjectMapper objectMapper = new ObjectMapper();
        File filename = new File("weather.json");
        try {
            objectMapper.writeValue(filename, weatherList);

        } catch (IOException e) {


        }



    }
}
