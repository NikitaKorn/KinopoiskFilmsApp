package ru.kinopoisk.rating.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import ru.kinopoisk.rating.model.Films;
import ru.kinopoisk.rating.utils.HibernateSessionFactoryUtil;

import javax.persistence.Query;
import java.util.List;

@Component
public class FilmDao {

    public void save(Films film) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(film);
        tx1.commit();
        session.close();
    }

    public void saveAll(List<Films> films){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        for(Films film : films){
            session.save(film);
        }
        tx.commit();
        session.close();
    }

    @Cacheable("findFilmCache")
    public List<Films> findFilmsOnDate(int date){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String str = "FROM Films where year = :paramYear";

        Query query = session.createQuery(str);
        query.setParameter("paramYear", date);
        List<Films> films = query.getResultList();

        session.close();
        return films;
    }

    public List<Films> getAllFilms(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String str = "FROM Films";

        Query query = session.createQuery(str);

        List<Films> films = query.getResultList();

        session.close();
        return films;
    }
}
