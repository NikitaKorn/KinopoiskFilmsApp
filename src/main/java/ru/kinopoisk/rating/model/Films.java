package ru.kinopoisk.rating.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "films")
public class Films implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int id;

    @SerializedName("nameEn")
    @Column(name = "film_name")
    private String name;

    @Column(name = "film_year")
    private int year;

    @Column(name = "film_rating")
    private double rating;

    @SerializedName("ratingVoteCount")
    @Column(name = "film_vote")
    private int vote;

    public Films(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return name + " " + year +
                " " + rating +
                " " + vote;
    }
}
