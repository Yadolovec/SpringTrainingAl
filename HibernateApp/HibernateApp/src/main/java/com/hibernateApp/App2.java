package com.hibernateApp;

import com.hibernateApp.model.*;
import com.hibernateApp.model2.Actor;
import com.hibernateApp.model2.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Film film = new Film("Pulp fict", 1994);
//            Actor actor1 = new Actor("Harvey Keitl", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            film.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setFilms(new ArrayList<>(List.of(film)));
//            actor2.setFilms(new ArrayList<>(List.of(film)));
//
//            session.save(film);
//            session.save(actor1);
//            session.save(actor2);

//            Film film = session.get(Film.class, 2);
//            System.out.println(film.getActors());

//            Actor actor = session.get(Actor.class, 3);
//            System.out.println(actor.getFilms());

//            Film film = new Film("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 3);
//            film.setActors(new ArrayList<>(List.of(actor)));
//            actor.getFilms().add(film);
//
//            session.save(film);

            Actor actor = session.get(Actor.class, 3);
            System.out.println(actor.getFilms());

            Film filmToRemove = actor.getFilms().get(0);

            actor.getFilms().remove(0);
            filmToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
