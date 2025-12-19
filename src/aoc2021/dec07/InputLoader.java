package aoc2021.dec07;

import framework.InputLoaderParent;

import java.util.Arrays;
import java.util.List;

public class InputLoader extends InputLoaderParent {
    public static List<Integer> loadPositions() {
        String[] parts = loadLines().getFirst().split(",");
        return Arrays.stream(parts).map(Integer::parseInt).toList();
    }
}
