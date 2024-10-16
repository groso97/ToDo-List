package com.project.todolist.Classes;

import java.util.Arrays;
import java.util.List;

public class Category {
    private List<String> categories = Arrays.asList("Osobno","Posao", "Obitelj", "Kupovina", "Putovanja");

    public Category() {}

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
