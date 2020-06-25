package edu.umsl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Workspace {

    //Main Method
    public static void main(String[] args){
        Scanner userInput = new Scanner (System.in);                                                                    //new scanner object

        // Output to the user
        System.out.println("Enter the Time You need to get out of Bed\nEnter the Hour and Minutes separated by a space");
        System.out.println("Hours: 0 to 23, Minutes: 0 to 59");

        int hour = -1;                                                                                                  //used to store the hour input by the user
        int minute = -1;                                                                                                //used to store the minute input by the user

        //This do while loop is used to catch input from the user outside the accepted range
        do {
            // This if statement is used to get input from the user if the last value input is outside the accepted range
            if(hour < 0 || hour >= 24) {
                // this try catch block is used to catch exceptions thrown if the user inputs invalid data
                try {
                    hour = userInput.nextInt();                                                                         //accepts input from the user
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input: " + ex + "\nPlease enter a valid hour between 0 and 23");
                }
            }
            //// This if statement is used to get input from the user if the last value input is outside the accepted range
            if(minute < 0 || minute > 59) {
                // this try catch block is used to catch exceptions thrown if the user inputs invalid data
                try {
                    minute = userInput.nextInt();                                                                       //accepts input from the user
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input: " + ex + "\nPlease enter a valid minute between 0 and 59");
                }
            }
            // if both the hours and minutes were input incorrectly the user is notified of the mistake
            if((hour < 0 || hour >= 24) && (minute < 0 || minute > 59)){
                System.out.println("Invalid input - Hour: " + hour + " Minute: " + minute + "\nPlease enter a valid hour between 0 and 23\nPlease enter a valid minute between 0 and 59");
            }else{// if the user only made one mistake in their input this else statement will execute
                //if the user entered a hour outside the accepted value they will be notified
                if (hour < 0 || hour >= 24) {
                    System.out.println("Invalid input - Hour: " + hour + "\nPlease enter a valid hour between 0 and 23");
                }
                //if the user entered a minute outside the accepted value they will be notified
                if (minute < 0 || minute > 59) {
                    System.out.println("Invalid input - Minute: " + minute + "\nPlease enter a valid minute between 0 and 59");
                }
            }
        }while((hour < 0 || hour >= 24) || (minute < 0 || minute > 59));

        //call the the newAlarmTime Method
        newAlarmTime(hour,minute);
    }
    // newAlarmTime Method: Method used to calculate and display the new bed time
    public static void newAlarmTime(int hour, int minute){

        if(minute < 45){
            minute = minute + 15;
            hour--;
        }else{
            minute = minute - 45;
        }

        //used to format output to the user
        if(minute < 10){
            System.out.println("Your New Alarm Time is: " + hour + ":0" + minute);
        }else{
            System.out.println("Your New Alarm Time is: " + hour + ":" + minute);
        }


    }
}
