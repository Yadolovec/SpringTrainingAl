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
        people.add(new Person(++PEOPLE_COUNT, "VOVA", "vova@gmail.com", 15));
        people.add(new Person(++PEOPLE_COUNT, "MASHA", "mshsaa@gmail.com", 18));
        people.add(new Person(++PEOPLE_COUNT, "DASHA", "daryna@gmail.com", 65));
        people.add(new Person(++PEOPLE_COUNT, "DIMA", "Dimon@gmail.com", 55));
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
        personToUpdate.setEmail(updatedPerson.getEmail());
        personToUpdate.setAge(updatedPerson.getAge());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId()==id);
    }
}
