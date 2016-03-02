/*

   Christian Cheng
   Last Updated: March 2, 2016
   A simple tool for tracking the usage of Dining Dollars at UC San Diego.

 */

import java.util.Scanner;
import java.lang.*;

public class DiningDollars {

    private static final double TOTAL_AMOUNT = 3255;
    private static final double DAILY_ALLOWANCE = 14.08;
    private static final double QUARTER_WEEKS = 11;

    public static void main(String[] args) {

        int currentQuarter = 1;
        double currentTotal = 0;
        double currentTarget = 0;
        double currentWeek;
        double day;        
        double buffer;        
        boolean extra = false;
        Scanner inputStream = new Scanner(System.in);

        // Prompt for current quarter
        System.out.println("Please enter the current quarter (1 - Fall, 2 - "
            + "Winter, 3 - Spring: ");
        currentQuarter = inputStream.nextInt();

        // Prompt for current Week
        System.out.println("Please enter the current Week (1-11): ");
        currentWeek = inputStream.nextDouble();

        // Prompt for the day of the week
        System.out.println("Please enter the day of the Week (1 (Sun) - 7 (" +
                "Sat)): ");
        day = inputStream.nextDouble();
        
        // Prompt for current Dining Dollars amount
        System.out.println("Please enter your current Dining Dollars amount:" +
                " ");
        currentTotal = inputStream.nextDouble();

        // Determine the current Week of the year (out of 33)
        if (currentQuarter > 1) {
            currentWeek = (currentQuarter == 2) ? (currentWeek + QUARTER_WEEKS)
                : (currentWeek + (2 * QUARTER_WEEKS));
        }

        // Calculate the current target and whether the user has extra
        day = ((currentWeek - 1) * 7) + day;
        currentTarget = TOTAL_AMOUNT - (DAILY_ALLOWANCE * day);
        extra = currentTotal > currentTarget;

        // Difference between the current total and current target, rounded
        buffer = (!extra) ?  (currentTarget - currentTotal) : (currentTotal -
                currentTarget);
        buffer = buffer * 100;
        buffer = (double)((int)buffer);
        buffer = buffer / 100;

        System.out.println("\nYou are currently at $" + currentTotal);
        System.out.println("Your current target is $" + currentTarget);
      
        if (extra) { 
            System.out.println("You have $" + buffer + " extra Dining " +
                    "Dollars!");
        } else { 
            System.out.println("You are using too many Dining Dollars! You " +
                    "are $" + buffer + " over your limit!");
        }
    }
}

