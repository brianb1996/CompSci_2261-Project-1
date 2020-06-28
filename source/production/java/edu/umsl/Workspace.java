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
        //First message to User
        System.out.println("Enter the Time You need to get out of Bed\nEnter the Hour and Minutes separated by a space");
        System.out.println("Hours: 0 to 23, Minutes: 0 to 59");

        //Variable Declaration and initialization
        int [] time = new int[2];                   // Array of integers used to store the time: time[0] = hours , time[1] = minutes
        String [] hourError = {""};                 // Array of Strings used to store the invalid input for hours as a string
        String [] minuteError = {""};               // Array of Strings used to store the invalid input for minutes as a string
        boolean valid;                      // boolean used to continue the do-while loop till true

        //This do-while loop is used to keep asking the user for input till integers are correctly entered;
        do {
            valid = inputTime(time, hourError, minuteError);
            displayErrorMessages(valid,hourError,minuteError);
        }while(!valid);
        //call the the newAlarmTime Method
        newAlarmTime(time);
    }

    // Method used to accept user input and check if input is the correct data type, then the method calls on the timeCheck method to check for valid input
    public static boolean inputTime(int[] time, String[] hourError, String[] minuteError){
        Scanner userInput = new Scanner (System.in);    // new scanner class object named userInput
        int hour;                                       // used to store the users input for hours
        int minute;                                     // used to store the users input for minutes

        //try-catch block used to catch InputMismatchExceptions if the user doesn't enter a integer
        try {
            hour = userInput.nextInt();                 // user inputs hours
            minute = userInput.nextInt();               // user inputs minutes
        }catch (InputMismatchException ex) {
            userInput.nextLine();                       // if the input is incorrect the scanner class will accept it as a string to clear the input buffer
            System.out.println("Error: " + ex);         // displays error message to user about the exception
            return false;
        }

        // if-else statements used to either return error messages and a boolean false to the main method or the users input time and a boolean true
        if(timeCheck(hour,minute,hourError,minuteError)){
            time[0] = hour;
            time[1] = minute;
            return true;
        }else{
            return false;
        }
    }

    //Method used to check if user input is within a correct range of values
    public static boolean timeCheck(int hour, int minute, String[] hourError, String[] minuteError){
        //if both the hours and minutes input by the user are out of the accepted range their corresponding error string will store the invalid input
        if((hour < 0 || hour > 23) && (minute < 0 || minute > 59)){
            hourError[0] = hour + "";
            minuteError[0] = minute + "";
            return false;
        }
        //if the user input an hour out of the accepted range the hourError string will store the invalid input
        if(hour < 0 || hour > 23){
            hourError[0] = hour + "";
            return false;
        }
        //if the user input for minutes is out of the accepted range the minuteError string will store the invalid input
        if(minute < 0 || minute > 59){
            minuteError[0] = minute + "";
            return false;
        }
        return true;
    }

    //Method used to display unique error messages to the user depending on their input
    public static void displayErrorMessages(boolean userError, String[] hourError, String[] minuteError){
        // if the user input an invalid int for hours, the invalid input will be displayed here
        if(hourError[0].length() > 0){
            System.out.println("Invalid input: Hour = " + hourError[0]);
            hourError[0]="";
        }
        // if the user input a invalid int for minutes the invalid input will display here
        if(minuteError[0].length() > 0){
            System.out.println("Invalid input: Minute = " + minuteError[0]);
            minuteError[0]="";
        }
        // if the user input any invalid data the user will be asked to input valid integers for the time
        if(!userError){
            System.out.println("\nTRY AGAIN\n");
            System.out.println("Enter the Hour and Minutes separated by a space");
            System.out.println("Hours: 0 to 23, Minutes: 0 to 59");
        }
    }

    // newAlarmTime Method: Method used to calculate and display the new alarm time
    public static void newAlarmTime(int[] time){

        if(time[1] < 45){
            time[1] = time[1] + 15;
            time[0]--;
            if(time[0] < 0){
                time[0] = 23;
            }
        }else{
            time[1] = time[1] - 45;
        }

        //used to format output to the user
        if(time[0] < 10){
            System.out.print("Your New Alarm Time is: 0" + time[0]);
        }else{
            System.out.print("Your New Alarm Time is: " + time[0]);
        }
        if(time[1] < 10){
            System.out.println(":0" + time[1]);
        }else{
            System.out.println(":" + time[1]);
        }

    }
}
