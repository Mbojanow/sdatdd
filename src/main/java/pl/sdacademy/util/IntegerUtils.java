package pl.sdacademy.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntegerUtils {
    //                              12345       [2, 4] -> [1, 3, 5]
    public List<Integer> filter(int toFilter, final List<Integer> filters) {
        return toFilteredDigitsList(toFilter, digit -> !filters.contains(digit));
    }
    // 124356  3 -> [4, 5, 6]
    public List<Integer> filterDigitsGreaterThan(int toFilter, final int lowerBoundExclusive) {
        return toFilteredDigitsList(toFilter, digit -> digit > lowerBoundExclusive);
    }

    // 12345 -> 4, 1357 -> []
    public Optional<Integer> getLastEvenDigit(int number) {
        return toDigitsList(number).stream()
                .filter(digit -> digit % 2 == 0)
                .findFirst();
    }

    public boolean isEven(final int number) {
        return number % 2 == 0;
    }

    private List<Integer> toDigitsList(int number) {
        final List<Integer> digits = new ArrayList<>();
        while (number > 10) {
            digits.add(number % 10);
            number = number / 10;
        }
        digits.add(number);
        return digits;
    }

    private List<Integer> toFilteredDigitsList(int number, final Predicate<? super Integer> filterPredicate) {
        return toDigitsList(number).stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());
    }
}
