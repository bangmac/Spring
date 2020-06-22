package com.codegym.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedback;
    private String author;
    private String rating;
    private String date;
    private int likes;

    public Comment(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        this.date = today.format(formatter);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
