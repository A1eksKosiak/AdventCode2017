package day1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        BigInteger inputNumber = scanner.nextBigInteger();
        List<BigInteger[]> numbers = new ArrayList<>();
        while (!(inputNumber.equals(BigInteger.ZERO))) {
            numbers.add(inputNumber.divideAndRemainder(BigInteger.TEN));
            inputNumber = inputNumber.divide(BigInteger.TEN);
        }
//        for (int i = numbers.size() - 1; i >= 0; i--) {
//            numbers.add(numbers.get(i));
//            numbers.remove(i);
//        }
//        int sum = 0;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i)[1].equals(numbers.get(i + 1)[1])) {
                sum = sum.add(numbers.get(i)[1]);
            }
        }
        if (numbers.get(numbers.size() - 1)[1].equals(numbers.get(0)[1])) {
            sum = sum.add(numbers.get(numbers.size() - 1)[1]);
        }
        System.out.println(sum);
    }
}