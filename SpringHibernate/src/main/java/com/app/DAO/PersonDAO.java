package com.app.DAO;

import com.app.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {
    private final SessionFactory sessionFactory;

    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index(){
        Session session = sessionFactory.getCurrentSession();
        List<Person> people = session.createQuery("SELECT i FROM Person i", Person.class).getResultList();
        return people;

    }

    public Person show(int id){ return null;}
    public void save(Person person){}
    public void update(int id, Person updatedPerson){}
    public void delete(int id){}
}
