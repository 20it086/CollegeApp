package com.krish.collageapp.ui.about;

public class BranchModel {
    private int img;
    private String title,description;

    public BranchModel() {
    }

    public BranchModel(int img, String title, String description) {
        this.img = img;
        this.title = title;
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titel) {
        this.title = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
