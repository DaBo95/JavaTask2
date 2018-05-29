package com.epam.darya_bogomolova.java.lesson1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dasha on 28.02.2018.
 */
public class StringProcessing {
    public static void main(String[] args) {
        StringProcessing strApp = new StringProcessing();
        strApp.startProcessing();

    }

    public void startProcessing() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter parameter n");
        int n = Integer.parseInt(in.nextLine());

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            strings.add(s);
        }

        int task = in.nextInt();

        switch (task) {
            case 1: {
                String minStr = strings.get(0);
                int minLen = strings.get(0).length();
                String maxStr = strings.get(0);
                int maxLen = strings.get(0).length();
                for (int i = 1; i < n; i++) {
                    if (strings.get(i).length() > maxLen) {
                        maxLen = strings.get(i).length();
                        maxStr = strings.get(i);
                    }
                    if (strings.get(i).length() < minLen) {
                        minLen = strings.get(i).length();
                        minStr = strings.get(i);
                    }
                }
                System.out.println(maxStr + " : " + maxLen);
                System.out.println(minStr + " : " + minLen);

            }
            break;
            case 2: {
                float avgLen = avgLen(strings);
                System.out.println("AvgLen : " + avgLen);
                for (int i = 1; i < n; i++) {
                    if (strings.get(i).length() > avgLen) {
                        System.out.println(strings.get(i) + " : " + strings.get(i).length());
                    }
                }

            }
            break;
            case 3: {
                float avgLen = avgLen(strings);
                System.out.println("AvgLen : " + avgLen);
                for (int i = 1; i < n; i++) {
                    if (strings.get(i).length() < avgLen) {
                        System.out.println(strings.get(i) + " : " + strings.get(i).length());
                    }
                }
            }
            break;
            case 4: {
                String minWord = strings.get(0);
                int minNumOfDiffChars = numOfDiffChars(strings.get(0));
                for (int i = 1; i < n; i++) {
                    if (numOfDiffChars(strings.get(i)) < minNumOfDiffChars) {
                        minNumOfDiffChars = numOfDiffChars(strings.get(i));
                        minWord = strings.get(i);
                    }
                }
                System.out.println(minWord);
            }
            break;
            case 5: {
                for (int i = 1; i < n; i++) {
                    if (numOfDiffChars(strings.get(i)) == strings.get(i).length()) {
                        System.out.println(strings.get(i));
                        break;
                    }
                }

            }
            break;
            case 6: {
                int flag = 1;
                for (int i = 0; i < n; i++) {
                    if (numOfDigits(strings.get(i)) == strings.get(i).length()) {
                        flag ++;
                        if (flag == 2) {
                            System.out.println(strings.get(i));
                            break;
                        }
                    }
                }
            }
            break;
            default: {
                System.out.println("Enter the number of task");
            }
        }
    }

    private float avgLen(List<String> list) {
        float avg = 0;
        for (int i = 0; i < list.size(); i++) {
            avg+= list.get(i).length();
        }
        return avg/list.size();
    }

    private int numOfDiffChars (String s) {
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!chars.contains(s.charAt(i))) {
                chars.add(s.charAt(i));
            }
        }
        return chars.size();
    }

    private int numOfDigits (String s) {
        int numDigits = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numDigits ++;
            }
        }
        return numDigits;
    }
}