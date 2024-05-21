/*
Name:Jiesel T. Badayos
Date:April 23, 2024
Description: this activity is to reinforce understanding of 2D arrays in Java and practice basic array traversal and searching algorithms
*/
import java.util.Random;
import java.util.Scanner;

 class ArrayOperations {

   
    public static int[][] initializeArray() {
        int[][] array = new int[3][4];
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = rand.nextInt(100) + 1; 
            }
        }

        return array;
    }

    
    public static void displayArray(int[][] array) {
        System.out.println("Array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%4d ", array[i][j]);
            }
            System.out.println();
        }
    }

    
    public static void findMaxElement(int[][] array) {
        int max = array[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("\nMaximum Element: " + max);
        System.out.println("Row Index: " + maxRow);
        System.out.println("Column Index: " + maxCol);
    }

    // Main function
    public static void main(String[] args) {
        int[][] array = initializeArray();
        displayArray(array);
        findMaxElement(array);
    }
}
