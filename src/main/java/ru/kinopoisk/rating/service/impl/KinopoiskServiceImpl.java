package ru.kinopoisk.rating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kinopoisk.rating.client.KinopoiskApiClient;
import ru.kinopoisk.rating.dao.FilmDao;
import ru.kinopoisk.rating.model.Films;
import ru.kinopoisk.rating.parser.GsonParser;
import ru.kinopoisk.rating.service.KinopoiskService;

import java.io.IOException;
import java.util.List;

@Service
public class KinopoiskServiceImpl implements KinopoiskService {
    private KinopoiskApiClient kinopoiskApiClient;
    private GsonParser parser;
    private FilmDao filmDao;

    @Autowired
    public KinopoiskServiceImpl(KinopoiskApiClient kinopoiskApiClient, GsonParser parser, FilmDao filmDao) {
        this.kinopoiskApiClient = kinopoiskApiClient;
        this.parser = parser;
        this.filmDao = filmDao;
    }

    @Override
    public void loadFilmsFromKinopoisk() throws IOException {
        String kinopoiskApiResponse = kinopoiskApiClient.getTopFilmsResponse();
        List<Films> films = parser.parse(kinopoiskApiResponse);

        filmDao.saveAll(films);
    }
}
