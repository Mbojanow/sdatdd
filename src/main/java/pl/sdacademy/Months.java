package pl.sdacademy;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.params.provider.EnumSource;

public class Months {

  private static final Map<Month, Integer> MONTHS_TO_INTEGER_MAP = new HashMap<>();

  static {
    MONTHS_TO_INTEGER_MAP.put(Month.JANUARY, 31);
    MONTHS_TO_INTEGER_MAP.put(Month.FEBRUARY, 28);
    MONTHS_TO_INTEGER_MAP.put(Month.MARCH, 31);
    MONTHS_TO_INTEGER_MAP.put(Month.APRIL, 30);
    MONTHS_TO_INTEGER_MAP.put(Month.MAY, 31);
    MONTHS_TO_INTEGER_MAP.put(Month.JUNE, 30);
    MONTHS_TO_INTEGER_MAP.put(Month.JULY, 31);
    MONTHS_TO_INTEGER_MAP.put(Month.AUGUST, 31);
    MONTHS_TO_INTEGER_MAP.put(Month.SEPTEMBER, 30);
    MONTHS_TO_INTEGER_MAP.put(Month.OCTOBER, 31);
    MONTHS_TO_INTEGER_MAP.put(Month.NOVEMBER, 30);
    MONTHS_TO_INTEGER_MAP.put(Month.DECEMBER, 31);
  }

  public static boolean has31Days(final Month month) {
    return MONTHS_TO_INTEGER_MAP.get(month) == 31;
  }
}
