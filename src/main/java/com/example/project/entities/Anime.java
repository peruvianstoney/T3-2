package com.example.project.entities;

public class Anime {
    private String name;
    private String description;
    private String urlImage;
    private String imageRate;


    public Anime() {
    }

    public Anime(String name, String description, String urlImage, String imageRate) {
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
        this.imageRate = imageRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getImageRate() {
        return imageRate;
    }

    public void setImageRate(String imageRate) {
        this.imageRate = imageRate;
    }
}
