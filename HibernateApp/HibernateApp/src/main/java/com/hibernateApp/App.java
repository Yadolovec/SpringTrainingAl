package com.hibernateApp;

import com.hibernateApp.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

//            Person person = session.get(Person.class, 4);
//            session.delete(person);
//            person.setName("Test22");
//            Person person = new Person("Tomas", 144);
//            session.save(person);

//            session.getTransaction().commit();
//            System.out.println("Id is "+person.getId());

            List<Person> people1 = session.createQuery("FROM Person").getResultList();
            for (Person p : people1)
                System.out.println(p.getName()+", "+p.getAge());

            List<Person> people = session.createQuery("FROM Person WHERE age>=12").getResultList();
            for (Person p : people)
                System.out.println(p.getName()+", "+p.getAge());
            people = session.createQuery("FROM Person WHERE name LIKE '%St%'").getResultList();
            for (Person p : people)
                System.out.println(p.getName()+", "+p.getAge());

//            session.createQuery("UPDATE Person SET name='HOLO' WHERE name LIKE '%st%'").executeUpdate();
            session.createQuery("DELETE FROM Person WHERE age>11").executeUpdate();
            
            for (Person p : people1)

                System.out.println(p.getName()+", "+p.getAge());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
