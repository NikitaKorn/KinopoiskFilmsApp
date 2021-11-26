package ru.kinopoisk.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import ru.kinopoisk.rating.service.impl.KinopoiskServiceImpl;

import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class KinopoiskRatingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(KinopoiskRatingApplication.class, args);
		KinopoiskServiceImpl kinopoiskService = ctx.getBean(KinopoiskServiceImpl.class);
		try {
			kinopoiskService.loadFilmsFromKinopoisk();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
