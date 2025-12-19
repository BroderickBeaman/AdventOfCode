package aoc2021.dec07;

import framework.AOCParent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Dec07 extends AOCParent {

    List<Integer> positions;

    @Override
    public void loadInput() {
        positions = InputLoader.loadPositions();
    }

    @Override
    public void part1() {
        long minSum = Long.MAX_VALUE;

        for (Integer first : positions) {
            long tempSum = 0;
            for (Integer second : positions) {
                tempSum += Math.abs(first - second);
            }
            minSum = Math.min(minSum, tempSum);
        }

        printSolution(minSum);
    }

    @Override
    public void part2() {
        Map<Integer, Long> distanceToFuel = new HashMap<>();
        int max = positions.stream().max(Integer::compareTo).get();
        distanceToFuel.put(0, 0L);
        IntStream.range(1, max + 1).forEachOrdered(num -> {
            distanceToFuel.put(num, distanceToFuel.get(num - 1) + num);
        });

        long minSum = Long.MAX_VALUE;

        for (int i = 0; i < max + 1; i++) {
            long tempSum = 0;
            for (Integer position : positions) {
                tempSum += distanceToFuel.get(Math.abs(i - position));
            }
            minSum = Math.min(minSum, tempSum);
        }

        printSolution(minSum);
    }
}
