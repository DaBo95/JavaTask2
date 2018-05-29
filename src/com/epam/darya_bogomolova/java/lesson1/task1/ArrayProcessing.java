package com.epam.darya_bogomolova.java.lesson1.task1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dasha on 28.02.2018.
 */
public class ArrayProcessing {
    public static void main(String[] args) {
        ArrayProcessing arrayProcessing = new ArrayProcessing();
        arrayProcessing.startProcessing();
    }

    public void startProcessing() {
        int[] array = genArray(20);

        Scanner in = new Scanner(System.in);
        int task = in.nextInt();
        switch (task) {
            case 1: {
                int maxMinus = findPosOfMaxMinus(array);
                int minPlus = findPosOfMinPlus(array);
                printArr(array);
                int tmp = array[maxMinus];
                array[maxMinus] = array[minPlus];
                array[minPlus] = tmp;
                printArr(array);
            }
            break;
            case 2: {
                int sum = 0;
                int arrayLength = array.length;

                for (int i = 0; i < arrayLength; i += 2) {
                    sum += array[i];
                }
                printArr(array);
                System.out.println(sum);
            }
            break;
            case 3: {
                int[] newArray = new int[array.length];
                for (int i = 0; i < array.length; i++) {
                    if (array[i] < 0)
                        newArray[i] = 0;
                    else newArray[i] = array[i];

                }
                printArr(array);
                printArr(newArray);
            }
            break;
            case 4: {
                printArr(array);
                int[] newArray = new int[array.length];
                for (int i = 0; i < array.length - 1; i++) {

                    if (array[i] > 0 && array[i + 1] < 0)
                        newArray[i] = array[i] * 3;
                    else newArray[i] = array[i];

                }
                newArray[array.length - 1] = array[array.length - 1];
                printArr(newArray);

            }
            break;
            case 5: {
                int min = array[findPosOfMaxMinus(array)];
                printArr(array);
                float avg = avgOfArr(array);
                System.out.println(avg - min);

            }
            break;
            case 6: {
                int n = array.length;
                printArr(array);
                for (int i = 1; i + 2 < n; i += 2) {
                    for (int j = 0; j < n; j++) {
                        if (array[i] == array[j] && i != j) {
                            System.out.println(array[i]);
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

    public int[] genArray(int n) {
        Random rnd = new Random(System.currentTimeMillis());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(21) - 10;
            ;
        }
        return arr;
    }

    private int findPosOfMaxMinus(int[] arr) {
        int idx = -1;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (idx < 0) {
                    max = arr[i];
                    idx = i;
                } else {
                    if (arr[i] > max) {
                        max = arr[i];
                        idx = i;
                    }
                }
            }
        }
        return idx;
    }

    private int findPosOfMinPlus(int[] arr) {
        int idx = -1;
        int min = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (idx < 0) {
                    min = arr[i];
                    idx = i;
                } else {
                    if (arr[i] < min) {
                        min = arr[i];
                        idx = i;
                    }
                }
            }
        }
        return idx;
    }

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private float avgOfArr(int[] arr) {
        float avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        return avg / arr.length;
    }
}
