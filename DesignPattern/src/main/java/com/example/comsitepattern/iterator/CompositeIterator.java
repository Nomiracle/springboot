package com.example.comsitepattern.iterator;

import com.example.comsitepattern.Menu;
import com.example.comsitepattern.other.MenuComponent;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
    private  Stack<Iterator<MenuComponent>> iteratorStack;

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        iteratorStack = new Stack<>();
        iteratorStack.push(iterator);
    }
//there is bug
    @Override
    public boolean hasNext() {
        if (iteratorStack.empty()) {
            return false;
        } else {
            Iterator<MenuComponent> iterator = iteratorStack.peek();
            if (!iterator.hasNext()) {
                iteratorStack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }
    @Override
    public MenuComponent next() {
            Iterator<MenuComponent> iterator = iteratorStack.peek();
            MenuComponent component = iterator.next();
            if (component instanceof Menu) {
                iteratorStack.push(component.createIterator());
            }
            return component;
    }

}
