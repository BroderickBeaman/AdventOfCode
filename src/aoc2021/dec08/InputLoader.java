package aoc2021.dec08;

import framework.InputLoaderParent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLoader extends InputLoaderParent {
    public static List<DecoderEntryPt1> loadEntriesPt1() {
        return loadLines().stream().map(line -> {
            String[] parts = line.split(" \\| ");
            return new DecoderEntryPt1(List.of(parts[0].split(" ")), List.of(parts[1].split(" ")));
        }).toList();
    }

    public static List<DecoderEntryPt2> loadEntriesPt2() {
        return loadLines().stream().map(line -> {
            String[] parts = line.split(" \\| ");
            List<String> inputsRaw = List.of(parts[0].split(" "));
            List<String> outputsRaw = List.of(parts[1].split(" "));
            List<Set<Character>> inputs = inputsRaw.stream().map(inputRaw -> {
                Set<Character> input = new HashSet<>();
                char[] characters = inputRaw.toCharArray();
                for (int i = 0; i < characters.length; i++) {
                    input.add(characters[i]);
                }
                return input;
            }).toList();
            List<Set<Character>> outputs = outputsRaw.stream().map(outputRaw -> {
                Set<Character> output = new HashSet<>();
                char[] characters = outputRaw.toCharArray();
                for (int i = 0; i < characters.length; i++) {
                    output.add(characters[i]);
                }
                return output;
            }).toList();

            return new DecoderEntryPt2(inputs, outputs);
        }).toList();
    }
}
