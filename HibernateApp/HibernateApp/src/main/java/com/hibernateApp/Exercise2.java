package com.hibernateApp;

import com.hibernateApp.model.Director;
import com.hibernateApp.model.Movie;
import com.hibernateApp.model.Principal;
import com.hibernateApp.model.School;
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
public class Exercise2
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Principal principal = session.get(Principal.class, 1);
//            System.out.println(principal.getSchool().getSchoolNumber());

//            School school = session.get(School.class,3);
//            System.out.println(school.getPrincipal().getName());

//            Principal principal = new Principal("Tomas Edison", 113);
//            School school = new School(21212, principal);
//            principal.setSchool(school);
//            session.save(principal);

//            Principal principal = session.get(Principal.class, 3);
//            School school = session.get(School.class, 5);
//            principal.getSchool().setPrincipal(null);
//            principal.setSchool(school);
//            school.setPrincipal(principal);


//            Principal principal = session.get(Principal.class, 1);
//            School school = session.get(School.class, 3);
//            principal.setSchool(school);
//            school.setPrincipal(principal);//EERRROORR

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
