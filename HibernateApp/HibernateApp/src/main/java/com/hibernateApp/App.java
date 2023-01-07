package com.hibernateApp;

import com.hibernateApp.model.Item;
import com.hibernateApp.model.Passport;
import com.hibernateApp.model.Person;
import com.hibernateApp.model.Personp;
import org.hibernate.Hibernate;
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
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Personp.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//GET OWNER`S ITMES
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//            List<Item> ownerItems = person.getItems();
//            System.out.println(ownerItems.toString());

//GET OWNER OF ITEM
//            Item item = session.get(Item.class, 3);
//            System.out.println(item);
//            Person person = item.getOwner();
//            System.out.println(person);

//NEW ITEM
//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("helicopter", person);
//            // ITS NOT NECCESARY IF YOU JUST SAVE,
//            // BUT NEED TO BE DONE IF YOU WILL CONTINUE WORK WITH THIS TRANSACTION,
//            // COZ HIBERNATE CASHIRUET (NOT CALL DB ALL THE TIME)
//            //            person.getItems().add(newItem); NOT MAKE ANE SQL
//            session.save(newItem);

//NEW ITEM NEW PERSON
//            Person person = new Person("Masha", 12);
//            Item newItem = new Item("Praska", person);
//            person.setItems(new ArrayList<Item>(Collections.singletonList(newItem)));
//            session.save(person);
//            session.save(newItem); //SECOND SAVE COZ WE DONT MADE CASCAD

//DELETE ITEMS
//            Person person = session.get(Person.class, 1);
//            List<Item> items = person.getItems();
//            items.forEach(i -> session.remove(i));
//
//            person.getItems().clear();// JUST GOOD MANERS

//DELETE PERSON
//            Person person = session.get(Person.class, 4);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null));

//CHANGE OWNER

//            Person person = session.get(Person.class, 3);
//            Item item = session.get(Item.class, 3);
//
//            item.getOwner().getItems().remove(item);
//
//            item.setOwner(person);
//            person.getItems().add(item);

//            Person person = new Person("JulianAa", 343);
//////            Item item = new Item("ItemMM", person);
////            person.setItems(new ArrayList<>(Collections.singletonList(item)));
////            item.setOwner(person);
//            person.addItem(new Item("IteM1"));
//            person.addItem(new Item("IteM2"));
//            person.addItem(new Item("IteM3"));
//
//
//            session.save(person);
//            session.save(item);
//            Personp person = new Personp("Test chel", 123 );
//            Passport passport = new Passport( 12345);
//            person.setPassport(passport);

//            Personp person = session.get(Personp.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());

//            Passport passport = session.get(Passport.class, 1);
//            System.out.println(passport.getPersonp().getName());

//            Personp personp = session.get(Personp.class, 1);
//            personp.getPassport().setPassportNumber(777677);

//            Personp personp = session.get(Personp.class, 4);
//            personp.setPassport(new Passport(6654321));




//            session.save(person);


            // LAZY AND EAGER LOADING

            Person person = session.get(Person.class, 2);
            System.out.println("We get a person");

            session.getTransaction().commit();
            System.out.println("Out of session");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            person = (Person) session.merge(person);
//            Hibernate.initialize(person.getItems());

            List<Item> items = session.createQuery("select j from Item j where j.owner.id = :personIdd", Item.class)
                    .setParameter("personIdd", person.getId()).getResultList();

            session.getTransaction().commit();
            System.out.println("Out of second session");
//            System.out.println(person.getItems());
            System.out.println(items);
        } finally {
            sessionFactory.close();
        }
    }
}
