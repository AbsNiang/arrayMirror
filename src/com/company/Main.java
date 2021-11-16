package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int MirrorCalc(int[] numbersTyped) {
        int mirrorLength = 0;
        int[] dupeLocation = new int[numbersTyped.length / 2];
        for (int i = 0; i < (numbersTyped.length / 2); i++) {
            for (int j = (numbersTyped.length - 1); j > i; j--) {
                //compares the first half of numbers in the array to the rest of the array and stores the positions in another array.
                if (numbersTyped[i] == numbersTyped[j]) {
                    dupeLocation[i] = j;
                    break;
                }
            }
        }
        //comparing the location of the consecutive locations in the array to see if the numbers count as mirrored
        for (int i = 0; i < (numbersTyped.length / 2) - 1; i++) {
            if (dupeLocation[i] == (dupeLocation[i + 1] + 1)) {
                mirrorLength++;
            }
        }
        return mirrorLength + 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("How many numbers do you want to type?");
                int[] numbers = new int[input.nextInt()];
                System.out.println("Type all the numbers.");
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = input.nextInt();
                }
                System.out.println(MirrorCalc(numbers));
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("You have not inputted a number");
                input.next();
            }
        }
    }
}
