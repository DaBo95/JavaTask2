package com.epam.darya_bogomolova.java.lesson5;

import com.epam.darya_bogomolova.java.lesson5.exceptions.ExceptionOfType;
import com.epam.darya_bogomolova.java.lesson5.exceptions.ExceptionOfWeight;
import com.epam.darya_bogomolova.java.lesson5.model.Candy;
import com.epam.darya_bogomolova.java.lesson5.model.CandyGift;
import com.epam.darya_bogomolova.java.lesson5.model.ChocolateCandy;
import com.epam.darya_bogomolova.java.lesson5.model.FruitCandy;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class MainGift {
    Scanner in;

    public static void main(String[] args) throws IOException {
        new MainGift().run();
    }

    public void run() throws IOException {
        in = new Scanner(System.in);
        CandyGift candyGift = new CandyGift();
        System.out.println("How match chocolate candies do you want to put in gift?");
        int countChocoCandies = in.nextInt();
        int numberOfCandy = 1;
        for (int i = 0; i < countChocoCandies; i++) {
            Candy chocoCandy = new ChocolateCandy(numberOfCandy, "Choco", 12.5);
            candyGift.putCandy(chocoCandy);
            numberOfCandy++;
        }

        System.out.println("How match fruit candies do you want to put in gift?");
        int countFruitCandies = in.nextInt();
        for (int i = 0; i < countFruitCandies; i++) {
            Candy fruitCandy = new FruitCandy(numberOfCandy, "Strawberry", 9.2);
            candyGift.putCandy(fruitCandy);
            numberOfCandy++;
        }


        System.out.println("Enter type of candies:\n1 - chocolate\n2 - fruit");
        int numTypeCandies = in.nextInt();

        try {
            checkType(numTypeCandies);
            checkExistenceOfCandies(candyGift.getWeightOfGift());
            if (numTypeCandies == 1) {
                List<Candy> candies = candyGift.getCandiesByType("Chocolate");
                printCandies(candies);
            }
            if (numTypeCandies == 2) {
                List<Candy> candies = candyGift.getCandiesByType("Fruit");
                printCandies(candies);
            }
        } catch (ExceptionOfType | ExceptionOfWeight e ) {
            System.out.println(e.getMessage());
        }
        String weightOfGift = new DecimalFormat("#0.00").format(candyGift.getWeightOfGift());
        System.out.println("The weight of gift is " + weightOfGift);

    }

    public void printCandies (List<Candy> candies) {
        for (int i = 0; i < candies.size(); i++) {
            System.out.println(candies.get(i).toString());
        }
    }

    public void checkType (int type) throws ExceptionOfType {
        if (type != 1 && type != 2) {
            throw new ExceptionOfType();
        }
    }

    public void checkExistenceOfCandies (double weight) throws ExceptionOfWeight {
        if (weight == 0.0) {
            throw new ExceptionOfWeight();
        }
    }
}
