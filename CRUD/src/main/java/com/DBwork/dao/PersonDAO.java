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
        Person person = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM person WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));
            person.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void save(Person person){

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO person VALUES(1, ?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE person SET name=?, email=?, age=? WHERE id=?");
            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setString(2, updatedPerson.getEmail());
            preparedStatement.setInt(3, updatedPerson.getAge());
            preparedStatement.setInt(4, id);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
//        people.removeIf(p -> p.getId()==id);
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM person WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
