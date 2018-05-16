package com.epam.darya_bogomolova.java.lesson4.model;

import com.epam.darya_bogomolova.java.lesson4.interfaces.GiftCreator;

public class CandyGift implements GiftCreator {

    private Candy[] candies = new Candy[500];

    @Override
    public void putCandy(Candy candy) {
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] == null) {
                candies[i] = candy;
                break;
            }
        }
    }

    @Override
    public void removeCandy(Candy candy) {
        for (int i = 0; i < candies.length; i++) {
            if (candies[i].equals(candy)) {
                candies[i] = null;
                for (int j = i; j < candies.length; j++) {
                    candies[j] = candies[j + 1];
                    if (candies[j + 1] == null)
                        break;
                }
            }
        }
    }

    @Override
    public double getWeightOfGift() {
        double weightOfGift = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] != null)
                weightOfGift += candies[i].getWeight();
            else break;

        }
        return weightOfGift;
    }

    @Override
    public Candy[] getCandiesByType(String type) {
        Candy[] someCandies = new Candy[500];
        int idxCandy = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] != null) {
                if (candies[i].getType().equals(type)) {
                    someCandies[idxCandy] = candies[i];
                    idxCandy++;
                }
            }

        }
        Candy[] candiesByType = new Candy[idxCandy];
        for (int i = 0; i < idxCandy; i++) {
            candiesByType[i] = someCandies[i];
        }
        return candiesByType;
    }

    @Override
    public Candy[] getCandiesByName(String name) {
        Candy[] someCandies = new Candy[500];
        int idxCandy = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] != null) {
                if (candies[i].getName().equals(name)) {
                    someCandies[idxCandy] = candies[i];
                    idxCandy++;
                }
            }

        }
        Candy[] candiesByName = new Candy[idxCandy];
        for (int i = 0; i < idxCandy; i++) {
            candiesByName[i] = someCandies[i];
        }
        return candiesByName;
    }
}
