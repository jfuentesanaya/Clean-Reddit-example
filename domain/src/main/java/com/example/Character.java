package com.example;

public class Character implements Comparable<Character>{

    private int id;
    private String name;
    private String thumbnail;
    private int age;
    private float weight;
    private float height;
    private String hair_color;
    private String[] professions;
    private String[] friends;

    private String TAG;
    public final String TAG_ORDERBY_NAME = "NAME";
    public final String TAG_ORDERBY_AGE = "AGE";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String[] getProfessions() {
        return professions;
    }

    public void setProfessions(String[] professions) {
        this.professions = professions;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public void compareByName(Character character){
        compareTo(character);
    }

    @Override
    public int compareTo(Character o) {
        switch (TAG){
            case TAG_ORDERBY_NAME:
                return this.getName().compareTo(o.getName());
            case TAG_ORDERBY_AGE:
                return o.getAge() - this.getAge();
            default:
                return 0;
        }
    }

    public void orderBy(Character character, String TAG){
        this.TAG = TAG;
        compareTo(character);
    }
}
