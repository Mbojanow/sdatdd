package pl.sdacademy.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListUtil {

    // ["A", "B", "C"] -> ["A"] ["B"], ["C"]
    public static List<String> createSingletonListWithRandomElement(final List<String> source) {
        if (source.isEmpty()) {
            return Collections.emptyList();
        }

        final int size = source.size();
        final int index = new Random().nextInt(size);

        return Collections.singletonList(source.get(index));
    }

    // ["a", "b", "c"] -> ["c", "b", "a"]
    public static List<String> getReversedList(final List<String> source) {
        final List<String> copiedList = new ArrayList<>(source);
        Collections.reverse(copiedList);
        return copiedList;
    }

    public static List<Integer> doubleValues(final List<Integer> valueListToDouble) {
        return valueListToDouble.stream()
                .map(value -> value * 2)
                .collect(Collectors.toList());
    }

    public static List<Integer> doubleInputValue(final List<Integer> valueListToDouble) {
        for (int index = 0; index < valueListToDouble.size(); index++) {
            valueListToDouble.set(index, valueListToDouble.get(index) * 2);
        }
        return valueListToDouble;
    }
}
