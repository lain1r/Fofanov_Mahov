package org.example;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String city;
    private ArrayList<Eat> arr  = new ArrayList<>();
    private ArrayList<Drinks> arrDrink  = new ArrayList<>();

    public Restaurant(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addEat(Eat eat) {
        arr.add(eat);
    }

    public void delEat(int i) {
        arr.remove(i);
    }

    public ArrayList<Eat> getArrEat() {
        return arr;
    }
    public ArrayList<Drinks> getArrDrink() {
        return arrDrink;
    }

    public void addDrinks(Drinks drinks) {
        arrDrink.add(drinks);
    }

    public Eat getMenu(int i) {
        return arr.get(i);
    }

    public Drinks getDrinksMenu(int i) {
        return arrDrink.get(i);
    }

    public String getCity() {
        return city;
    }



    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
