package com.DBwork.dao;

import com.DBwork.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public static int PEOPLE_COUNT = 0;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index(){
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                person.setName(resultSet.getString("name"));

                people.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person show(int id){
//        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
        return null;
    }

    public void save(Person person){
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person VALUES("+1+",'"+person.getName()+"',"
                    +person.getAge()+",'"+person.getEmail()+"')";
            statement.executeUpdate(SQL); 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson){
//        Person personToUpdate = show(id);
//        personToUpdate.setName(updatedPerson.getName());
//        personToUpdate.setEmail(updatedPerson.getEmail());
//        personToUpdate.setAge(updatedPerson.getAge());
    }

    public void delete(int id){
//        people.removeIf(p -> p.getId()==id);
    }
}
