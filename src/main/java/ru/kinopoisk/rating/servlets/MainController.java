package ru.kinopoisk.rating.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kinopoisk.rating.dao.FilmDao;
import ru.kinopoisk.rating.model.Films;

import java.util.List;


@Controller
public class MainController {
    private FilmDao filmDao;

    public MainController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @GetMapping("/films")
    public String main(Model model){
        List<Films> films = filmDao.getAllFilms();
        model.addAttribute("films", films);
        return "main";
    }

    @PostMapping("/films")
    public String getFilms(@RequestParam("date") String date, Model model){
        try{
            int dateValue = Integer.parseInt(date);
            List<Films> films = filmDao.findFilmsOnDate(dateValue);
            model.addAttribute("films", films);
        } catch (Exception e){

        }
        return "main";
    }

}
