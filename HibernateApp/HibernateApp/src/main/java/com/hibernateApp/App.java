package com.hibernateApp;

import com.hibernateApp.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person personToSave1 = new Person("Test11", 10);
//            Person personToSave2 = new Person("Test11", 11);
//            Person personToSave3 = new Person("Test11", 12);
//
//            session.save(personToSave1);
//            session.save(personToSave3);
//            session.save(personToSave2);

            Person person = session.get(Person.class, 4);
            System.out.println(person.getName() + ", " + person.getAge());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
