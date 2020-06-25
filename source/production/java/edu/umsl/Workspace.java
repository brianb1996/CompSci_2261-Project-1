package edu.umsl;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
* Project 1 - CMPSCI 2261
*
* Every school morning Steve is woken up by the sound of his alarm clock. Since he is a bit forgetful, quite often he
* leaves the alarm on Saturday morning too. That’s not too bad though, since he feels good when he realizes he doesn’t
* have to get up from his warm and cozy bed.
*
* He likes that so much that he would like to experience that on other days of the week too! His friend Justin offered
* this simple solution: set his alarm clock 45 minutes early, and he can enjoy the comfort of his bed, fully awake, for
* 45 minutes each day.
*
* Steve decided to heed Justin’s advice, however Steve’s alarm clock uses 24-hour notation and Steve has issues with
* adjusting the time. Help Steve and write a program that will take one time stamp, in 24-hour notation, and print out a
* new time stamp, 45 minutes earlier, also in 24-hour notation.
*
* If you are unfamiliar with 24-hour time notation yourself, you might be interested to know it starts with 0:00
* (midnight) and ends with 23:59 (one minute before midnight).
*
* Input:
* The first and only line of input will contain exactly two integers H and M (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) separated by a
* single space, the input time in 24-hour notation. H denotes hours and M minutes. Ensure your program does not
* terminate if there is bad input and can recover gracefully.
*
*
* */
public class Workspace {

    //Main Method
    public static void main(String[] args){
        Scanner userInput = new Scanner (System.in);                                                                    //new scanner object

        System.out.println("Enter the Time You need to get out of Bed\nEnter the Hour and Minutes separated by a space");
        System.out.println("Hours: 0 to 23, Minutes: 0 to 59");

        final int NO_INPUT = -9999;
        int hour = NO_INPUT;                                                                                            //used to store the hour input by the user
        int minute = NO_INPUT;                                                                                          //used to store the minute input by the user
        String errorCatcher;                                                                                            //used to store store the users incorrect input
        //This do while loop is used to catch input from the user outside the accepted range
        do {

            // This if statement is used to get input from the user if the last value input is outside the accepted range
            if(hour < 0 || hour > 24) {
                // this try catch block is used to catch exceptions thrown if the user inputs invalid data
                try {
                    hour = userInput.nextInt();                                                                         //accepts input from the user
                } catch (InputMismatchException ex) {
                    errorCatcher = userInput.next();
                    System.out.println("Error: " + ex + "\nInvalid Input: Hour = " + errorCatcher);
                }
            }
            //// This if statement is used to get input from the user if the last value input is outside the accepted range
            if(minute < 0 || minute > 59) {
                // this try catch block is used to catch exceptions thrown if the user inputs invalid data
                try {
                    minute = userInput.nextInt();                                                                       //accepts input from the user
                } catch (InputMismatchException ex) {
                    errorCatcher = userInput.next();
                    System.out.println("Error: " + ex + "\nInvalid Input: Minute = " + errorCatcher);
                }
            }

            // if both the hours and minutes were input incorrectly the user is notified of the mistake
            if((hour < 0 || hour > 24) && (minute < 0 || minute > 59)){
                if(hour != NO_INPUT && minute != NO_INPUT){ // if the user entered an integer but it was incorrect
                    System.out.println("Invalid input: Hour = " + hour + " Minute = " + minute );
                }
                System.out.println("Please enter a valid Hour between 0 and 23\nPlease enter a valid Minute between 0 and 59");
            }else{// if the user only made one mistake in their input this else statement will execute
                //if the user entered a hour outside the accepted value they will be notified
                if (hour < 0 || hour > 24 ) {
                    if( hour != NO_INPUT){ // if the user entered an integer but it was incorrect
                        System.out.println("Invalid input: Hour = " + hour);
                    }
                    System.out.println("Please enter a valid hour between 0 and 23");
                }
                //if the user entered a minute outside the accepted value they will be notified
                if (minute < 0 || minute > 59) {
                    if(minute != NO_INPUT){ // if the user entered an integer but it was incorrect
                        System.out.println("Invalid input: Minute = " + minute);
                    }
                    System.out.println("Please enter a valid minute between 0 and 59");
                }
            }
        }while((hour < 0 || hour >= 24) || (minute < 0 || minute > 59));

        //call the the newAlarmTime Method
        newAlarmTime(hour,minute);
    }
    // newAlarmTime Method: Method used to calculate and display the new alarm time
    public static void newAlarmTime(int hour, int minute){

        if(minute < 45){
            minute = minute + 15;
            hour--;
            if(hour < 0){
                hour = 23;
            }
        }else{
            minute = minute - 45;
        }

        //used to format output to the user
        if(hour < 10){
            System.out.print("Your New Alarm Time is: 0" + hour);
        }else{
            System.out.print("Your New Alarm Time is: " + hour);
        }
        if(minute < 10){
            System.out.println(":0" + minute);
        }else{
            System.out.println(":" + minute);
        }

    }
}
