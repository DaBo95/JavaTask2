package com.epam.darya_bogomolova.java.lesson4.model;

public class ChocolateCandy extends Candy {

    double chocoWiight;
    public ChocolateCandy(int number, String name, double weight) {
        super(number, name, weight);
        this.chocoWiight = 12.5;
        this.type = "Chocolate";
    }
}
