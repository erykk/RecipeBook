package com.projects.recipebook.models;

public class Amount {
    public String measure;
    public String quantity;

    public Amount(String quantity, String measure) {
        this.measure = measure;
        this.quantity = quantity;
    }
}
