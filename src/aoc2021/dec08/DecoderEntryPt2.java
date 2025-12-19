package aoc2021.dec08;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record DecoderEntryPt2(List<Set<Character>> inputs, List<Set<Character>> outputs) {

    public long computeOutput() {
        Set<Character>
                ONE = null,
                TWO = null,
                THREE = null,
                FOUR = null,
                FIVE = null,
                SIX = null,
                SEVEN = null,
                EIGHT = null,
                NINE = null,
                ZERO = null;
        Set<Set<Character>> fiveCharacters = new HashSet<>();
        Set<Set<Character>> sixCharacters = new HashSet<>();
        for (Set<Character> input : inputs) {
            int size = input.size();
            if (size == 2) {
                ONE = input;
            } else if (size == 4) {
                FOUR = input;
            } else if (size == 3) {
                SEVEN = input;
            } else if (size == 7) {
                EIGHT = input;
            } else if (size == 5) {
                fiveCharacters.add(input);
            } else if (size == 6) {
                sixCharacters.add(input);
            }
        }

        for (Set<Character> input : fiveCharacters) {
            if (input.containsAll(SEVEN)) {
                THREE = input;
            }
        }

        for (Set<Character> input : fiveCharacters) {
            if (input.equals(THREE)) {
                continue;
            }
            Set<Character> temp = new HashSet<>(input);
            temp.removeAll(FOUR);
            if (temp.size() == 3) {
                TWO = input;
            } else  {
                FIVE = input;
            }
        }

        for (Set<Character> input : sixCharacters) {
            if (input.containsAll(THREE)) {
                NINE = input;
            } else if (input.containsAll(FIVE)) {
                SIX = input;
            } else {
                ZERO = input;
            }
        }

        Map<Set<Character>, Integer> digitMap = Map.of(
                ZERO, 0,
                ONE, 1,
                TWO, 2,
                THREE, 3,
                FOUR, 4,
                FIVE, 5,
                SIX, 6,
                SEVEN, 7,
                EIGHT, 8,
                NINE, 9
        );

        long multiplier = 1;
        long sum = 0;
        for (int i = outputs.size() - 1; i >= 0; i--) {
            sum += digitMap.get(outputs.get(i)) * multiplier;
            multiplier *= 10;
        }

        return sum;

    }
}
