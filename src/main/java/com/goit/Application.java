package com.goit;

import com.goit.dto.NameDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        String name = getJson();
        System.out.println(name);
    }

    public static String getJson() {
        try (Reader reader = new InputStreamReader(Application.class.getClassLoader()
                .getResourceAsStream("my_name.json"))) {

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

            NameDto name = new Gson().fromJson(reader, NameDto.class);

            String json = gson.toJson(name);

            return json;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
