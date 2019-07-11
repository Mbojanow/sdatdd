package pl.sdacademy.util;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntegerUtils {

    public List<Integer> filter(int toFilter, final List<Integer> filters) {
        return toFilteredDigitsList(toFilter, digit -> !filters.contains(abs(digit)));
    }

    public List<Integer> filterDigitsGreaterThan(int toFilter, final int lowerBoundExclusive) {
        return toFilteredDigitsList(toFilter, digit -> digit > lowerBoundExclusive);
    }

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
        while (abs(number) > 10) {
            digits.add(number % 10);
            number = number / 10;
        }
        digits.add(abs(number));
        return digits;
    }

    private List<Integer> toFilteredDigitsList(int number, final Predicate<? super Integer> filterPredicate) {
        return toDigitsList(number).stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());
    }
}
