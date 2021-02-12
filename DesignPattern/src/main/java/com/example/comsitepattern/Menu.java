package com.example.comsitepattern;

import com.example.comsitepattern.iterator.CompositeIterator;
import com.example.comsitepattern.other.MenuComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    private String Name,Description;
    List<MenuComponent> menus;

    public Menu(String name, String description) {
        this.Name = name;
        this.Description = description;
        this.menus = new ArrayList<>();
    }

    public void add(MenuComponent menuComponent){
        menus.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent){
        menus.remove(menuComponent);
    }
    public MenuComponent getChild(int position){
        return menus.get(position);
    }
    public void print(){
        System.out.println("Menu name:"+ getName());
        System.out.println("Menu description:"+ getDescription());
        System.out.println("---------------------------");
        for (MenuComponent menuComponent : menus){
            menuComponent.print();
        }
    }
    public void printItem() {
        System.out.println("---------------------------");
        System.out.println("Menu name:"+ getName());
        System.out.println("Menu description:"+ getDescription());

    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menus.iterator());
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getDescription() {
        return Description;
    }
}
