package com.example.comsitepattern;

import com.example.comsitepattern.iterator.NullIterator;
import com.example.comsitepattern.other.MenuComponent;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    private String Name,Description;
    private Float Price;
    private Boolean isVegetarian;
    public MenuItem(String name, String description, Float price, Boolean isVegetarian) {
        this.Name = name;
        this.Description = description;
        this.Price = price;
        this.isVegetarian = isVegetarian;
    }

    public void print() {
        System.out.println("MenuItem name:" + getName());
        System.out.println("         description:" + getDescription());
        System.out.println("         price:" + getPrice());
        System.out.println("         isVegetarian:" + getVegetarian());
    }

    public void printItem() {
        System.out.println("-----------------------");
        System.out.println("         name:" + getName());
        System.out.println("         description:" + getDescription());
        System.out.println("         price:" + getPrice());
        System.out.println("         isVegetarian:" + getVegetarian());
    }

    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public Float getPrice() {
        return Price;
    }

    @Override
    public Boolean getVegetarian() {
        return isVegetarian;
    }
}
