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

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId()==id);
    }
}
