package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Problem019 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem019().getSolution());
    }

    @Override
    public String getSolution() {
        int total = 0;
        for(int year = 1901; year <= 2000; year++) {
            for(int month = 0; month < 12; month++) {
                if(isDateOnASunday(year, month, 1)) total++;
            }
        }
        return Integer.toString(total);
    }

    private boolean isDateOnASunday(int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }
}
