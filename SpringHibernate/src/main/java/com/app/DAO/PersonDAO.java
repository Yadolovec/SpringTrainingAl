package com.app.DAO;

import com.app.models.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {
    private final EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void nPlusOnePr(){
        Session session = entityManager.unwrap(Session.class);
//        //Big 1+N problem
//        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
//        //for every get there is DB action
//        for (Person p : people)
//            System.out.println(p.getName()+" have "+p.getItems());
        //Solution
        Set<Person> people = new HashSet<Person>(session.createQuery("select p from Person p left join fetch p.items", Person.class).getResultList());
        for (Person p : people)
            System.out.println(p.getName()+" have "+p.getItems());

    }
}
