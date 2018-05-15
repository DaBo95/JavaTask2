package com.epam.darya_bogomolova.java.lesson2.task2;

import com.epam.darya_bogomolova.java.lesson2.task2.model.Candy;
import com.epam.darya_bogomolova.java.lesson2.task2.model.CandyGift;
import com.epam.darya_bogomolova.java.lesson2.task2.model.ChocolateCandy;
import com.epam.darya_bogomolova.java.lesson2.task2.model.FruitCandy;

import java.io.IOException;
import java.text.DecimalFormat;
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
        if (numTypeCandies == 1) {
            Candy[] candies = candyGift.getCandiesByType("Chocolate");
            printCandies(candies);
        }
        if (numTypeCandies == 2) {
            Candy[] candies = candyGift.getCandiesByType("Fruit");
            printCandies(candies);
        }
        String weightOfGift = new DecimalFormat("#0.00").format(candyGift.getWeightOfGift());
        System.out.println("The weight of gift is " + weightOfGift);

    }

    public void printCandies (Candy [] candies) {
        for (int i = 0; i < candies.length; i++) {
            System.out.println(candies[i].toString());
        }
    }
}
