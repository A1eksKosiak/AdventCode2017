package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        String[] stringArray;
        int[][] intArray = new int[20][20];
        int i = 0;
        while ((str = br.readLine()) != null) {
            stringArray = str.split("\t");
            for (int j = 0; j < stringArray.length; j++) {
                intArray[i][j] = Integer.parseInt(stringArray[j]);
            }
            i++;
        }

        int sum = 0;
        for (i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                if (intArray[i][j] == 0) {
                    break;
                }
                for (int k = 0; k < intArray[i].length; k++) {
                    if ((intArray[i][k] == 0) || (intArray[i][j] == 0)){
                        break;
                    }
                    if ((intArray[i][j] % intArray[i][k] == 0) && (j != k) ) {
                        sum += intArray[i][j] / intArray[i][k];
                        break;
                    }
                }
            }
        }
        System.out.println(sum);


    }
}
