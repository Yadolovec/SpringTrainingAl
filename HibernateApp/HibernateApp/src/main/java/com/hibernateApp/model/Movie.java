package com.hibernateApp.model;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int movie_id;

    @ManyToOne
    @JoinColumn(name="director_id", referencedColumnName = "director_id")
    private Director director;

    public Movie(Director director, String name, int yearOfProducrion) {
        this.director = director;
        this.name = name;
        this.yearOfProducrion = yearOfProducrion;
    }

    public Movie(){}

    @Column(name="name")
    private String name;

    @Column(name="year_of_production")
    private int yearOfProducrion;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProducrion() {
        return yearOfProducrion;
    }

    public void setYearOfProducrion(int yearOfProducrion) {
        this.yearOfProducrion = yearOfProducrion;
    }


}
