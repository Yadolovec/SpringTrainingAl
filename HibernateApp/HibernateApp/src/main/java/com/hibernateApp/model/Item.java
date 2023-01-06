package com.hibernateApp.model;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person owner;
    @Column (name="itemname")
    private String itemname;

    public Item(String itemname) {
        this.itemname = itemname;
    }
    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Override
    public String toString() {
        return "\n"+"Item{" +
                "id=" + id +
                ", owner=" + owner +
                ", itemname='" + itemname + '\'' +
                '}';
    }
}
