package com.aharoo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double rating;
    private double mainRating;
    private double sideRating;

    public Rating(){}

    public Rating(String name, double rating, double mainRating, double sideRating) {
        this.name = name;
        this.rating = rating;
        this.mainRating = mainRating;
        this.sideRating = sideRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getMainRating() {
        return mainRating;
    }

    public void setMainRating(double mainRating) {
        this.mainRating = mainRating;
    }

    public double getSideRating() {
        return sideRating;
    }

    public void setSideRating(double sideRating) {
        this.sideRating = sideRating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", mainRating=" + mainRating +
                ", sideRating=" + sideRating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Double.compare(rating1.rating, rating) == 0 && Double.compare(rating1.mainRating, mainRating) == 0 && Double.compare(rating1.sideRating, sideRating) == 0 && id.equals(rating1.id) && Objects.equals(name, rating1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating, mainRating, sideRating);
    }
}
