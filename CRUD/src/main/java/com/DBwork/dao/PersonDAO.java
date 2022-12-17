package com.DBwork.dao;

import com.DBwork.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "VOVA"));
        people.add(new Person(++PEOPLE_COUNT, "MASHA"));
        people.add(new Person(++PEOPLE_COUNT, "DASHA"));
        people.add(new Person(++PEOPLE_COUNT, "DIMA"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
}
