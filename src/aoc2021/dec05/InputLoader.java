package aoc2021.dec05;

import framework.InputLoaderParent;
import framework.utils.Coordinate;

import java.util.List;

public class InputLoader extends InputLoaderParent {

    public static List<Line> loadRanges() {
        return loadLines().stream().map(line -> {
            String[] parts = line.split(" -> ");
            String[] left = parts[0].split(",");
            String[] right = parts[1].split(",");
            return new Line(
                    new Coordinate(Integer.parseInt(left[0]), Integer.parseInt(left[1])),
                    new Coordinate(Integer.parseInt(right[0]), Integer.parseInt(right[1]))
            );
        }).toList();
    }
}
