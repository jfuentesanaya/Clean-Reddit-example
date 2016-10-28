package com.example;

public class Post implements Comparable<Post>{

    private String title;
    private String author;
    private String thumbnail;
    private long date;
    private int num_comments;
    private int score;

    private String TAG;
    public final String TAG_ORDERBY_NAME = "NAME";
    public final String TAG_ORDERBY_AGE = "AGE";

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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void compareByName(Post post){
        compareTo(post);
    }

    @Override
    public int compareTo(Post o) {
        switch (TAG){
            case TAG_ORDERBY_NAME:
                return this.getAuthor().compareTo(o.getAuthor());
            case TAG_ORDERBY_AGE:
                return (int)(o.getDate() - this.getDate());
            default:
                return 0;
        }
    }

    public void orderBy(Post post, String TAG){
        this.TAG = TAG;
        compareTo(post);
    }
}
