package Arrays;
import java.util.Scanner;
import java.util.*;

public class AvgTempProject {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("How many days' temperature");
        int numDays = console.nextInt();

        int[] temperature = new int[numDays];
        int sum = 0;
        for(int i = 0; i < numDays; i++){
            System.out.println("Days " + (i+1) + "'s high temp: ");
            temperature[i] = console.nextInt();
            sum += temperature[i];
        }

        double average = sum/numDays;
        System.out.println("\n Average temp = " + average);

        int countAboveAvg = 0;
        for(int i =0; i<temperature.length; i++){
            if(temperature[i] > average){
                countAboveAvg++;
            }
        }
    }
}
