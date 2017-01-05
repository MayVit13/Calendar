package classes;

import interfaces.CalendarInterface;

import java.time.LocalDate;

/**
 * Created by Vit on 05.01.2017.
 */
public class Calendar implements CalendarInterface {
    private LocalDate date;
    private StringBuffer calendar = new StringBuffer();
    private int daysInMonth;
    private int firstDayOfMonth;
    private LocalDate today = LocalDate.now();

    public Calendar(int year, int month) {
        date = LocalDate.of(year, month, 1);
    }

    public void calendarGenerator(){
        int dayNumber = 0;
        LocalDate pointer = date;

        calendar.append("Пн"+"\t"+"Вт"+"\t"+"Ср"+"\t"+"Чт"+"\t"+"Пт"+"\t"+"\033[31m"+"Сб"+"\033[0m"+"\t"+"\033[31m"+"Нд"+"\033[0m"+"\n");
        daysInMonth = date.lengthOfMonth();
        firstDayOfMonth = date.getDayOfWeek().getValue();

        if (firstDayOfMonth != 1){
            for (int k = 0; k<firstDayOfMonth-1; k++){
            calendar.append("\t");
            }
        }

        while (dayNumber < daysInMonth){

            if (pointer.isEqual(today)) {
                calendar.append("\033[34m" + pointer.getDayOfMonth()+ "\033[0m" + "\t");

                if (pointer.getDayOfWeek().getValue() == 7){
                    calendar.append("\n");
                }
            }

            else{

                if (pointer.getDayOfWeek().getValue() == 7 || pointer.getDayOfWeek().getValue() == 6){
                    calendar.append("\033[31m" + pointer.getDayOfMonth()+ "\033[0m" + "\t");

                    if (pointer.getDayOfWeek().getValue() == 7){
                        calendar.append("\n");
                    }
                }

                else {
                    calendar.append(pointer.getDayOfMonth() + "\t");
                }
            }
            dayNumber++;
            pointer = pointer.plusDays(1);
        }
        System.out.println("Поточна дата: " + today);
        System.out.println(date.getMonth() + " " + date.getYear());
        System.out.println(calendar);
    }




}
