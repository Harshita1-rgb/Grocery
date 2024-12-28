package com.example.grocery;

public class GroceryItem {
    private String name;
    private int imageResourceId;

    public GroceryItem(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
