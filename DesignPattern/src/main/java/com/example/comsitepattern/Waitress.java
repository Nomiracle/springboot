package com.example.comsitepattern;

import com.example.comsitepattern.other.MenuComponent;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancakeHouseMenu","breakfast");
        MenuComponent dinerMenu = new Menu("dinerMenu","lunch");
        MenuComponent cafeMenu = new Menu("cafeMenu","diner");
        MenuComponent dessertMenu = new Menu("dessertMenu","dessert");
//--------------------------------------------------------------------------------------------
        MenuComponent allMenu = new Menu("allMenu","allMenu");
//        allMenu.add(pancakeHouseMenu);
//        allMenu.add(dinerMenu);
        allMenu.add(cafeMenu);

//        pancakeHouseMenu.add(new MenuItem("apple pie",
//                "delicious",
//                3.8F,
//                true));
//        pancakeHouseMenu.add(dessertMenu);

        cafeMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("apple pie",
                "delicious",
                3.8F,
                true));
        MenuComponent dessertMenu2 = new Menu("dessertMenu","dessert");
        dessertMenu2.add(new MenuItem("pine apple pie",
                "delicious",
                1000F,
                true));
        cafeMenu.add(dessertMenu2);
//        cafeMenu.add(new MenuItem("cafe",
//                "delicious",
//                3.8F,
//                true));
//        Waitress beautifulWaitress = new Waitress(allMenu);
//        beautifulWaitress.printMenu();

        System.out.println("________________________________________");
        Iterator<MenuComponent> iterator =  allMenu.createIterator();
        MenuComponent component;
        while(iterator.hasNext()){
            iterator.next().printItem();
        }


    }

}
