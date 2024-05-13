package Array;

import java.util.Scanner;

public class TemperatureRecorder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] temps;
        int tempCount;
        double tempSum = 0;

        // 1. Get the number of temperatures from the user
        System.out.print("Enter the number of temperatures to record: ");
        tempCount = input.nextInt();
        temps = new double[tempCount];

        // 2. Get each temperature from the user
        for (int i = 0; i < tempCount; i++) {
            System.out.print("Temperature " + (i + 1) + ": ");

            // Add the value supplied by the user to the temps array.
            // Also, add the new value to the running total
            temps[i] = input.nextDouble();
            tempSum += temps[i];
        }

        // 3. Show the average temperature
        double averageTemp = tempSum / tempCount;
        System.out.println("Average temperature: " + averageTemp);

        // 4. Show the number of temperatures in the array which are above average
        int aboveAverageCount = 0;
        for (double i : temps) {
            if (i > averageTemp)
                aboveAverageCount++;
        }
        System.out.println("Number of temperatures above the average: " + aboveAverageCount);
    }
}
