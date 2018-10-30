package day3;

public class Main {
    private static final int spiralLength = 325489;
    private static final int spiralSize = (int) (Math.sqrt(spiralLength) + 1);
    private static int[][] array = new int[spiralSize][spiralSize];
    private static int value = 1;
    private static int startPoint = (array.length / 2);
    private static int xPosition = startPoint;
    private static int yPosition = startPoint;

    public static void main(String[] args) {

        array[xPosition][yPosition] = value;
        boolean left = false;
        boolean right = false;
        boolean top = false;
        boolean down = false;
        while (value <= spiralLength) {
            // check if this is starting point
            if ((xPosition == startPoint) && (yPosition == startPoint)) {
                left = true;
            }

            // check left
            if (left && array[xPosition][yPosition - 1] == 0) {
                yPosition--;
                array[xPosition][yPosition] = countSumValue();
                left = right = down = false;
                top = true;
            } else if (left) {
                xPosition++;
                array[xPosition][yPosition] = countSumValue();
            }

            // check top
            if (top && array[xPosition - 1][yPosition] == 0) {
                xPosition--;
                array[xPosition][yPosition] = countSumValue();
                left = top = down = false;
                right = true;
            } else if (top) {
                yPosition--;
                array[xPosition][yPosition] = countSumValue();
            }

            // check right
            if (right && array[xPosition][yPosition + 1] == 0) {
                yPosition++;
                array[xPosition][yPosition] = countSumValue();
                top = left = right = false;
                down = true;
            } else if (right) {
                xPosition--;
                array[xPosition][yPosition] = countSumValue();
            }

            // check down
            if (down && array[xPosition + 1][yPosition] == 0) {
                xPosition++;
                array[xPosition][yPosition] = countSumValue();
                top = right = down = false;
                left = true;
            } else if (down) {
                yPosition++;
                array[xPosition][yPosition] = countSumValue();
            }
            if (array[xPosition][yPosition] > spiralLength) {
                System.out.println(array[xPosition][yPosition]);
                break;
            }
        }

//        // print array
//        for (
//                int i = 0;
//                i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("|" + startPoint + " - " + xPosition + "| + |" + startPoint + " - " + yPosition + "|");
        System.out.println(Math.abs(startPoint - xPosition) + Math.abs(startPoint - yPosition));
    }

    public static int countSumValue() {
        int sumValue = 0;
        if (xPosition - 1 >= 0) {
            sumValue += array[xPosition - 1][yPosition];
            if (yPosition + 1 <= spiralSize) {
                sumValue += array[xPosition - 1][yPosition + 1];
            }
            if (yPosition - 1 >= 0) {
                sumValue += array[xPosition - 1][yPosition - 1];
            }
        }
        if (xPosition + 1 <= spiralSize) {
            sumValue += array[xPosition + 1][yPosition];
            if (yPosition + 1 <= spiralSize) {
                sumValue += array[xPosition + 1][yPosition + 1];
            }
            if (yPosition - 1 >= 0) {
                sumValue += array[xPosition + 1][yPosition - 1];
            }
        }
        if (yPosition + 1 <= spiralSize) {
            sumValue += array[xPosition][yPosition + 1];
        }
        if (yPosition - 1 >= 0) {
            sumValue += array[xPosition][yPosition - 1];
        }
        return sumValue;
    }
}
