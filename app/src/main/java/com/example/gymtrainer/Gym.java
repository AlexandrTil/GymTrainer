package com.example.gymtrainer;


public class Gym {

    private String name;
    private int image;
    public static final String POSITION = "position";
    public static final String TEXT = "text";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Gym(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Gym() {
    }
}
