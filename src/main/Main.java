package main;

import classes.Calendar;
import interfaces.CalendarInterface;

import java.time.Year;
import java.util.Scanner;

/**
 * Created by Vit on 05.01.2017.
 */

public class Main {
    public static void main(String[] args) {
        int year, month;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Введіть рік: ");
            year = sc.nextInt();
        }
        while (year < Year.MIN_VALUE || year>Year.MAX_VALUE);

        do{
            System.out.println("Введіть місяць: ");
            month = sc.nextInt();
        }
        while (month < 1 || month > 12);

        CalendarInterface calendar = new Calendar(year, month);
        calendar.calendarGenerator();
    }
}
