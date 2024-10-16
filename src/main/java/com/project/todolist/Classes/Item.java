package com.project.todolist.Classes;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;


public class Item {
    private String name;
    private String category;
    private ObjectProperty<LocalDate> date;


    public Item(String name, String category, LocalDate date) {
        this.name = name;
        this.category = category;
        this.date = new SimpleObjectProperty<>(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public ObjectProperty<LocalDate> dateProperty() {  
        return date;
    }
}
