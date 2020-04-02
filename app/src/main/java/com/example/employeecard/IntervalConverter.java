package com.example.employeecard;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Years;

public class IntervalConverter {
    public static String getWorkExp(LocalDate startDate){
        LocalDate  now = new LocalDate ();
        int monthsBetween = Months.monthsBetween(startDate, now).getMonths();
        int yearsBetween = Years.yearsBetween(startDate, now).getYears();
        int daysBetween = Days.daysBetween(startDate, now).getDays();
        String yearString ="";
        String monthString ="";
        String dayString ="";
        if(yearsBetween == 0) {
            yearString = "Year";
        }
        else yearString = "Years";
        if(monthsBetween == 0) {
            monthString = "Month";
        }
        else monthString = "Months";
        if(daysBetween == 0) {
            dayString = "Day";
        }
        else dayString = "Days";

        return yearString + ": " + yearsBetween + " " + monthString + ": " +  monthsBetween%12 + " " + dayString + ": " + (daysBetween%365)%30;
    }
}
