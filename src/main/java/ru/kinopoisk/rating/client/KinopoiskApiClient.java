package ru.kinopoisk.rating.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/*
    Получаем данные с сайта через API и возвращаем их в виде строки
 */

@Service
public class KinopoiskApiClient {
    private static final String KEY = "e2d1f4b8-6ae2-43a9-9082-6d82e2deef37";
    private static final String HOST = "https://kinopoiskapiunofficial.tech";
    private static final String PATH = "/api/v2.2/films/top";
    private static final String ARG = "X-API-KEY";

    public String getTopFilmsResponse() throws IOException {
        URLConnection connection = new URL(HOST + PATH).openConnection();
        connection.setRequestProperty(ARG, KEY);

        InputStream is = connection.getInputStream();
        String response = new Scanner(is).useDelimiter("\\A").next();

        return response;
    }
}
