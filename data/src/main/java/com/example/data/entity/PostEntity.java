package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jfuentesa on 27/10/2016.
 */

public class PostEntity {

    private String title;
    private String author;
    private String thumbnail;
    @SerializedName("num_comments")
    private int numComments;
    private int score;

    @SerializedName("created_utc")
    private long date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getNum_comments() {
        return numComments;
    }

    public void setNum_comments(int numComments) {
        this.numComments = numComments;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
