package ru.kinopoisk.rating.model;

import java.util.List;

public class Root {
    private String name;
    private List<Films> films;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Films> getFilms() {
        return films;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
    }
}
