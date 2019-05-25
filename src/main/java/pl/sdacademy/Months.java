package pl.sdacademy;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Months {

  private static Map<Month, Integer> MONTHS_TO_DAYS_NUM = new HashMap<>();

  static {
    MONTHS_TO_DAYS_NUM.put(Month.JANUARY, 31);
    MONTHS_TO_DAYS_NUM.put(Month.FEBRUARY, 28);
    MONTHS_TO_DAYS_NUM.put(Month.MARCH, 31);
    MONTHS_TO_DAYS_NUM.put(Month.APRIL, 30);
    MONTHS_TO_DAYS_NUM.put(Month.MAY, 31);
    MONTHS_TO_DAYS_NUM.put(Month.JUNE, 30);
    MONTHS_TO_DAYS_NUM.put(Month.JULY, 31);
    MONTHS_TO_DAYS_NUM.put(Month.AUGUST, 31);
    MONTHS_TO_DAYS_NUM.put(Month.SEPTEMBER, 30);
    MONTHS_TO_DAYS_NUM.put(Month.OCTOBER, 31);
    MONTHS_TO_DAYS_NUM.put(Month.NOVEMBER, 30);
    MONTHS_TO_DAYS_NUM.put(Month.DECEMBER, 31);
  }

  public boolean has31days(final Month month) {
    return MONTHS_TO_DAYS_NUM.get(month) == 31;
  }
}
