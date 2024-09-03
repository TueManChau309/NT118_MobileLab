package com.example.lab02_5;

public class Dish {
    private String name;
    private boolean promt;
    private Thumbnail thumb;
    public Dish(){}
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public boolean isPromt(){
        return promt;
    }

    public void setPromt(boolean promt) {
        this.promt = promt;
    }

    public Thumbnail getThumb() {
        return thumb;
    }

    public void setThumb(Thumbnail thumb) {
        this.thumb = thumb;
    }
}
