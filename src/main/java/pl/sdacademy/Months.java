package pl.sdacademy;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Months {

  private static Map<Month, Integer> monthsToNumberOfDays = new HashMap<>();

  static {
    monthsToNumberOfDays.put(Month.JANUARY, 31);
    monthsToNumberOfDays.put(Month.FEBRUARY, 28);
    monthsToNumberOfDays.put(Month.MARCH, 31);
    monthsToNumberOfDays.put(Month.APRIL, 30);
    monthsToNumberOfDays.put(Month.MAY, 31);
    monthsToNumberOfDays.put(Month.JUNE, 30);
    monthsToNumberOfDays.put(Month.JULY, 31);
    monthsToNumberOfDays.put(Month.AUGUST, 31);
    monthsToNumberOfDays.put(Month.SEPTEMBER, 30);
    monthsToNumberOfDays.put(Month.OCTOBER, 31);
    monthsToNumberOfDays.put(Month.NOVEMBER, 30);
    monthsToNumberOfDays.put(Month.DECEMBER, 31);
  }

  public static boolean has31Days(final Month month) {
    return monthsToNumberOfDays.entrySet().stream()
        .filter(entry -> entry.getKey().equals(month))
        .findFirst()
        .map(entry -> entry.getValue().equals(31))
        .orElseThrow(() -> new RuntimeException("Did not find requested month"));
  }
}
