package pl.sdacademy;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Months {

  private static Map<Month, Integer> monthToNumberOfDays;

  static {
    monthToNumberOfDays = new HashMap<>();
    monthToNumberOfDays.put(Month.JANUARY, 31);
    monthToNumberOfDays.put(Month.FEBRUARY, 28);
    monthToNumberOfDays.put(Month.MARCH, 31);
    monthToNumberOfDays.put(Month.APRIL, 30);
    monthToNumberOfDays.put(Month.MAY, 31);
    monthToNumberOfDays.put(Month.JUNE, 30);
    monthToNumberOfDays.put(Month.JULY, 31);
    monthToNumberOfDays.put(Month.AUGUST, 31);
    monthToNumberOfDays.put(Month.SEPTEMBER, 30);
    monthToNumberOfDays.put(Month.OCTOBER, 31);
    monthToNumberOfDays.put(Month.NOVEMBER, 30);
    monthToNumberOfDays.put(Month.DECEMBER, 31);
  }

  public boolean has31days(final Month month) {
    if (monthToNumberOfDays.containsKey(month)) {
      return monthToNumberOfDays.get(month) == 31;
    }
    return false;
  }
}
