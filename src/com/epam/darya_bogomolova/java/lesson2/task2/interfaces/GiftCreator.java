package com.epam.darya_bogomolova.java.lesson2.task2.interfaces;
import com.epam.darya_bogomolova.java.lesson2.task2.model.Candy;

public interface GiftCreator {
    public void putCandy(Candy candy);
    public void removeCandy(Candy candy);
    public double getWeightOfGift();
    public Candy[] getCandiesByType(String type);
    public Candy[] getCandiesByName(String name);

}
