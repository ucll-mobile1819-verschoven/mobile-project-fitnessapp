package com.example.fitnessapp.Model;

public class Exercise {

    private int image_id;
    private String name;
    private String desc;
    private String howTo;

    public Exercise(int image_id, String name, String desc, String howTo) {
        this.image_id = image_id;
        this.name = name;
        this.desc = desc;
        this.howTo = howTo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHowTo() {
        return howTo;
    }

    public void setHowTo(String howTo) {
        this.howTo = howTo;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
