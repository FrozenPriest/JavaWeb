package com.example.School;

/**
 * Song POJO class
 */
public class Song {
    public String name, author;
    public int listenTime, duration;

    public Song(String name, String author, int listenTime, int duration) {
        this.name = name;
        this.author = author;
        this.listenTime = listenTime;
        this.duration = duration;
    }
}
