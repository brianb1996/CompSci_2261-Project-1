package edu.umsl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Workspace {
    public static void main(String[] args){
        Scanner userInput = new Scanner (System.in);

        System.out.println("Enter the Time You need to get out of Bed\nEnter the Hour and Minutes separated by a space");
        System.out.println("Hours: 0 to 23, Minutes: 0 to 59");

        int hour = -1;
        int minute = -1;
        do {
            if(hour < 0 || hour >= 24) {
                try {
                    hour = userInput.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input: " + ex + "\nPlease enter a valid hour between 0 and 23");
                }
            }
            if(minute < 0 || minute > 59) {
                try {
                    minute = userInput.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input: " + ex + "\nPlease enter a valid minute between 0 and 59");
                }
            }
            if((hour < 0 || hour >= 24) && (minute < 0 || minute > 59)){
                System.out.println("Invalid input - Hour: " + hour + " Minute: " + minute + "\nPlease enter a valid hour between 0 and 23\nPlease enter a valid minute between 0 and 59");
            }else{
                if (hour < 0 || hour >= 24) {
                    System.out.println("Invalid input - Hour: " + hour + "\nPlease enter a valid hour between 0 and 23");
                }
                if (minute < 0 || minute > 59) {
                    System.out.println("Invalid input - Minute: " + minute + "\nPlease enter a valid minute between 0 and 59");
                }
            }
        }while((hour < 0 || hour >= 24) || (minute < 0 || minute > 59));

        newAlarmTime(hour,minute);
    }

    public static void newAlarmTime(int hour, int minute){
        if(minute < 45){
            minute = minute + 15;
            hour--;
        }else{
            minute = minute - 45;
        }

        if(minute < 10){
            System.out.println("Your New Alarm Time is: " + hour + ":0" + minute);
        }else{
            System.out.println("Your New Alarm Time is: " + hour + ":" + minute);
        }


    }
}
