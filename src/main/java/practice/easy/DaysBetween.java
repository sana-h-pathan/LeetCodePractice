package practice.easy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DaysBetween {
    public int daysBetweenDates(String date1, String date2) {
        try {
            LocalDate localDate1 = LocalDate.parse(date1);
            LocalDate localDate2 = LocalDate.parse(date2);

            long noOfDaysBetween = ChronoUnit.DAYS.between(localDate1, localDate2);
            return (int) noOfDaysBetween;
        }
        catch (Exception e){
            System.out.println("Exception Occurred"+e);
            return -1;
        }
    }

    public static void main(String[] args) {
        DaysBetween daysBetween=new DaysBetween();
        System.out.println(daysBetween.daysBetweenDates("2019-06-29","2019-06-31"));
    }
}
