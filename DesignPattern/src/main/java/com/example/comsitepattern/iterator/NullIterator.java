package com.example.comsitepattern.iterator;

import com.example.comsitepattern.other.MenuComponent;

import java.util.Iterator;

public class NullIterator implements Iterator<MenuComponent> {

    @Override
    public boolean hasNext() {
        return false;
    }


    @Override
    public MenuComponent next() {
        return null;
    }
}
