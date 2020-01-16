package com.newspaper.expenses;

import java.util.Date;

public enum NewsPaperPriceEnum {
    TOI("3","5","6"),
    Hindu("2.5","4","4"),
    ET("2","2","10"),
    BM("1.5","1.5","1.5"),
    HT("2","4","4");

    private final String[] values;
    NewsPaperPriceEnum(String... vals){
        values = vals;
    }
    double getWeekDayPrice(){
        return Double.valueOf(values[0]);
    }
    double getSaturdayPrice(){
        return Double.valueOf(values[1]);
    }
    double getSundayPrice(){
        return Double.valueOf(values[2]);
    }
}
