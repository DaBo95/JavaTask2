package com.epam.darya_bogomolova.java.lesson6.model;

public class FruitCandy extends Candy {
    double fruitWeihgt;

    public FruitCandy(int number, String name, double weight) {
        super(number, name, weight);
        this.fruitWeihgt = 9.2;
        this.type = "Fruit";
    }
}
