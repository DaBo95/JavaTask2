package com.epam.darya_bogomolova.java.lesson5.interfaces;

import com.epam.darya_bogomolova.java.lesson5.model.Candy;

import java.util.List;

public interface GiftCreator {
    public void putCandy(Candy candy);
    public void removeCandy(Candy candy);
    public double getWeightOfGift();
    public List<Candy> getCandiesByType(String type);
    public List<Candy> getCandiesByName(String name);

}
