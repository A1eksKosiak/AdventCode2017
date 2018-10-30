package day1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arrayOfChars = input.toCharArray();
        int[] arrayOfInts = new int[arrayOfChars.length];
        for (int i = 0; i < arrayOfChars.length; i++) {
            arrayOfInts[i] = Integer.parseInt(String.valueOf(arrayOfChars[i]));
        }
        int sum = 0;
        for (int i = 0; i < arrayOfInts.length; i++) {
            if ((arrayOfInts.length / 2) + i >= arrayOfInts.length) {
                if (arrayOfInts[i] == arrayOfInts[i-arrayOfInts.length/2]) {
                    sum += arrayOfInts[i];
                }
                continue;
            }

            if (arrayOfInts[i] == arrayOfInts[(arrayOfInts.length / 2) + i]) {
                sum += arrayOfInts[i];
            }

        }
        System.out.println(sum);
    }
}