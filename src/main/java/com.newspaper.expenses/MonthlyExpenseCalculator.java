package com.newspaper.expenses;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MonthlyExpenseCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] subscriptionList = sc.nextLine().split(",");
        System.out.println("Start Time :" + new Date().getTime());
        Long start =  new Date().getTime();
        System.out.println("no of news paper subscribed : " + subscriptionList.length);
        Double totalNewsPaperExpense = 0.0;
        for (String newsPaper : subscriptionList) {
            Double price = 0.0;
            Double newsPaperExpense = 0.0;
            try {
                Calendar c = Calendar.getInstance();
                Date d = new Date();
                Month m = Month.of(LocalDate.now().getMonthValue());
                int noOfDays = m.maxLength();
                NewsPaperPriceEnum NewsPaper = Enum.valueOf(NewsPaperPriceEnum.class, newsPaper.trim().toUpperCase());
                for (int i = 1; i <= noOfDays; i++) {
                    LocalDate localDate = LocalDate.of(2020, m, i);
                    DayOfWeek dayOfWeek1 = DayOfWeek.from(localDate);
                    String dayOfWeek = dayOfWeek1.name();
                    switch (dayOfWeek) {
                        case "SATURDAY":
                            price = NewsPaper.getSaturdayPrice();
                            break;
                        case "SUNDAY":
                            price = NewsPaper.getSundayPrice();
                            break;
                        default:
                            price = NewsPaper.getWeekDayPrice();
                            break;
                    }
                    newsPaperExpense = newsPaperExpense + price;
                }
                System.out.println(NewsPaper+" expense "+newsPaperExpense);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            totalNewsPaperExpense = totalNewsPaperExpense + newsPaperExpense;
        }
        System.out.println("Total expense :"+totalNewsPaperExpense);
        System.out.println("End Time :" + new Date().getTime());
        Long end =  new Date().getTime();
        System.out.println(" Time difference:" + (end-start));
    }
}
