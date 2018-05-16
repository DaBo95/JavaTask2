package com.epam.darya_bogomolova.java.lesson6.model;

import com.epam.darya_bogomolova.java.lesson6.interfaces.GiftCreator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CandyGift implements GiftCreator, Serializable {

    private List<Candy> candies = new ArrayList<Candy>();

    @Override
    public void putCandy(Candy candy) {
        candies.add(candy);
    }

    @Override
    public void removeCandy(Candy candy) {
        candies.remove(candy);
    }

    @Override
    public double getWeightOfGift() {
        double weightOfGift = 0;
        for (int i = 0; i < candies.size(); i++) {
            weightOfGift += candies.get(i).getWeight();
        }
        return weightOfGift;
    }

    @Override
    public List<Candy> getCandiesByType(String type) {
        List<Candy> someCandies = new ArrayList<>();
        for (int i = 0; i < candies.size(); i++) {
            if (candies.get(i).getType().equals(type)) {
                someCandies.add(candies.get(i));
            }
        }
        return someCandies;
    }

    @Override
    public List<Candy> getCandiesByName(String name) {
        List<Candy> someCandies = new ArrayList<>();
        for (int i = 0; i < candies.size(); i++) {
            if (candies.get(i).getType().equals(name)) {
                someCandies.add(candies.get(i));
            }
        }
        return someCandies;
    }
}
