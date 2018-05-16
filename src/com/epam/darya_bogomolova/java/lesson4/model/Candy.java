package com.epam.darya_bogomolova.java.lesson4.model;

import java.util.Objects;

public abstract class Candy {
    private int number;
    private String name;
    public String type;
    private double weight;

    public Candy(int number, String name, String type, double weight) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public Candy(int number, String name, double weight) {
        this.number = number;
        this.name = name;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "com.epam.darya_bogomolova.java.lesson2.task2.model.Candy{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return number == candy.number &&
                Double.compare(candy.weight, weight) == 0 &&
                Objects.equals(name, candy.name) &&
                Objects.equals(type, candy.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, name, type, weight);
    }
}
