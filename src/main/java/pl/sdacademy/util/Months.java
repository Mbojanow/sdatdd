package pl.sdacademy.util;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Months {

  private static final Map<Month, Integer> MONTHS_TO_DAYS = new HashMap<>();

  static {
    MONTHS_TO_DAYS.put(Month.JANUARY, 31);
    MONTHS_TO_DAYS.put(Month.FEBRUARY, 28);
    MONTHS_TO_DAYS.put(Month.MARCH, 31);
    MONTHS_TO_DAYS.put(Month.APRIL, 30);
    MONTHS_TO_DAYS.put(Month.MAY, 31);
    MONTHS_TO_DAYS.put(Month.JUNE, 30);
    MONTHS_TO_DAYS.put(Month.JULY, 31);
    MONTHS_TO_DAYS.put(Month.AUGUST, 31);
    MONTHS_TO_DAYS.put(Month.SEPTEMBER, 30);
    MONTHS_TO_DAYS.put(Month.OCTOBER, 31);
    MONTHS_TO_DAYS.put(Month.NOVEMBER, 30);
    MONTHS_TO_DAYS.put(Month.DECEMBER, 31);
  }

  public boolean has31days(final Month month) {
    return MONTHS_TO_DAYS.get(month) == 31;
  }
}
