package com.hibernateApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="director_id")
    private int director_id;
    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;

    public Director(){}

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


}
