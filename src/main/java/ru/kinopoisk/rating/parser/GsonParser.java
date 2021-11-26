package ru.kinopoisk.rating.parser;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.kinopoisk.rating.model.Films;
import ru.kinopoisk.rating.model.Root;

import java.util.List;

/*
    Парсим json response от кинопосик API и преобразуем в POJO.
 */

@Service
public class GsonParser {

    public List<Films> parse(String jsonString){
        Gson gson = new Gson();
        Root root = gson.fromJson(jsonString, Root.class);
        return root.getFilms();
    }

}
