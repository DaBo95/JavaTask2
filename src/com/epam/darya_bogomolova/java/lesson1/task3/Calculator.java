package com.epam.darya_bogomolova.java.lesson1.task3;

import java.util.Scanner;

/**
 * Created by Dasha on 28.02.2018.
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.startProcessing();

    }

    public void startProcessing() {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println("«+» - addition" + "\n«-» - subtraction" +
                "\n«*» - multiplication\n«/» - division");
        String task = in.next();
        switch (task) {
            case "+": {
                System.out.println(addition(a,b));
            }
            break;
            case "-": {
                System.out.println(subtraction(a,b));
            }
            break;
            case "*": {
                System.out.println(multiplication(a, b));
            }
            break;
            case "/": {
                System.out.println(division(a,b));
            }
            break;

            default: {
                System.out.println("Enter the number of task");
            }
        }
    }

    private int addition (int a, int b) {
        return a+b;
    }
    private int subtraction (int a, int b) {
        return a-b;
    }
    private int multiplication (int a, int b) {
        return a*b;
    }
    private float division (int a, int b) {
        return a/b;
    }
}
