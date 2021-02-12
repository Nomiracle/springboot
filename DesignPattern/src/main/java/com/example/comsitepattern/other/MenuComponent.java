package com.example.comsitepattern.other;

import java.util.Iterator;

public abstract class MenuComponent {



    public void print(){
        throw new UnsupportedOperationException("dont support print method");
    }
    public void printItem(){
        throw new UnsupportedOperationException("dont support printItem method");
    }

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException("dont support add method");
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException("dont support remove method");
    }
    public MenuComponent getChild(int position){
        throw new UnsupportedOperationException("dont support getChild method");
    }
    public Iterator<MenuComponent> createIterator(){
        throw new UnsupportedOperationException("dont support createIterator method");
    }


    public String getName() {
        throw new UnsupportedOperationException("dont support getName method");
    }

    public String getDescription() {
        throw new UnsupportedOperationException("dont support getDescription method");
    }

    public Float getPrice() {
        throw new UnsupportedOperationException("dont support getPrice method");
    }

    public Boolean getVegetarian() {
        throw new UnsupportedOperationException("dont support getVegetarian method");
    }
}
