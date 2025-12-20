package aoc2021.dec11;

import framework.AOCParent;
import framework.utils.Coordinate;
import framework.utils.Grid;

import java.util.HashSet;
import java.util.Set;

public class Dec11 extends AOCParent {

    private Grid<Integer> gridPt1;
    private Grid<Integer> gridPt2;

    @Override
    public void loadInput() {
        gridPt1 = InputLoader.loadGrid();
        gridPt2 = InputLoader.loadGrid();
    }

    @Override
    public void part1() {
        long sum = 0;
        for (int _i = 0; _i < 100; _i++) {
            gridPt1.applyToAll(octopus -> octopus + 1);
            Set<Coordinate> flashes = new HashSet<>();
            Set<Coordinate> flashing = new HashSet<>(gridPt1.findAllMatchingValue(value -> value > 9));
            do  {
                for (Coordinate toFlash : flashing) {
                    toFlash.adjacent().stream().filter(gridPt1::isInBounds).forEach(location -> {
                        gridPt1.applyToLocation(num -> num + 1, location);
                    });
                }
                flashes.addAll(flashing);
                flashing = new HashSet<>(gridPt1.findAllMatchingValue(value -> value > 9));
                flashing.removeAll(flashes);
            } while (!flashing.isEmpty());
            sum += flashes.size();
            for (Coordinate location : flashes) {
                gridPt1.set(0, location);
            }
        };
        printSolution(gridPt1);
        printSolution(sum);
    }

    @Override
    public void part2() {
        int step = 1;
        while (true) {
            gridPt2.applyToAll(octopus -> octopus + 1);
            Set<Coordinate> flashes = new HashSet<>();
            Set<Coordinate> flashing = new HashSet<>(gridPt2.findAllMatchingValue(value -> value > 9));
            do  {
                for (Coordinate toFlash : flashing) {
                    toFlash.adjacent().stream().filter(gridPt2::isInBounds).forEach(location -> {
                        gridPt2.applyToLocation(num -> num + 1, location);
                    });
                }
                flashes.addAll(flashing);
                flashing = new HashSet<>(gridPt2.findAllMatchingValue(value -> value > 9));
                flashing.removeAll(flashes);
            } while (!flashing.isEmpty());

            for (Coordinate location : flashes) {
                gridPt2.set(0, location);
            }

            if (flashes.size() == gridPt2.size()) {
                break;
            }
            step++;
        }
        printSolution(step);
    }
}
