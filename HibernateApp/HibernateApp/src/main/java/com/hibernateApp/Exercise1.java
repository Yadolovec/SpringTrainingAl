package com.hibernateApp;

import com.hibernateApp.model.Director;
import com.hibernateApp.model.Movie;
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
public class Exercise1
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Director director = session.get(Director.class, 1);
//            System.out.println(director.getName());

//            Movie movie = new Movie(director, "New FILMM", 2099);
//            session.save(movie);
//            director.getMovies().add(movie);

//            List<Movie> movies = director.getMovies();
//            movies.forEach(m -> System.out.println(m.getName()));

//NEW DIR NEW MOVIE
//            Director director = new Director("Test director", 18);
//            Movie movie = new Movie(director, "Test director`s film", 2018);
//            director.setMovies(Collections.singletonList(movie));
////            director.getMovies().add(movie); ERROR
//
//            session.save(director);
//            session.save(movie);


// delete some film
//            Director director = session.get(Director.class, 1);
//
//            director.getMovies().forEach(m -> System.out.println(m.getName()));
//            System.out.println("ppppppppppppppppppppppppppp");
//            Movie movie = session.get(Movie.class, 12);
//            session.remove(movie);
//            director.getMovies().remove(movie);
//
//            director.getMovies().forEach(m -> System.out.println(m.getName()));

            Director director = session.get(Director.class,7);
            Movie movie = session.get(Movie.class, 8);


            director.getMovies().forEach(m -> System.out.println(m.getName()));
            System.out.println("GGGGGGGGGGGGGGG");

            movie.getDirector().getMovies().remove(movie);
            movie.setDirector(director);
            director.getMovies().add(movie);

            session.save(director);
            session.save(movie);

            director.getMovies().forEach(m -> System.out.println(m.getName()));

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
