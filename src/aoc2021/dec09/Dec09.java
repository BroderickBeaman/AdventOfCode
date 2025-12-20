package aoc2021.dec09;

import framework.AOCParent;
import framework.utils.Coordinate;
import framework.utils.Grid;

import java.util.*;

public class Dec09 extends AOCParent {

    private Grid<Integer> oceanFloor;

    @Override
    public void loadInput() {
        oceanFloor = InputLoader.loadMap();
    }

    @Override
    public void part1() {
        long sum = oceanFloor.findAllMatching(location -> {
            return location.orthogonal().stream()
                    .filter(oceanFloor::isInBounds)
                    .noneMatch(test -> oceanFloor.get(test) <= oceanFloor.get(location));
        }).stream().mapToLong(location -> oceanFloor.get(location) + 1).sum();
        printSolution(sum);
    }

    @Override
    public void part2() {
        List<Coordinate> lowPoints = oceanFloor.findAllMatching(location -> {
            return location.orthogonal().stream()
                    .filter(oceanFloor::isInBounds)
                    .noneMatch(test -> oceanFloor.get(test) <= oceanFloor.get(location));
        });

        Set<Set<Coordinate>> basins = new HashSet<>();
        for (Coordinate lowPoint : lowPoints) {
            Set<Coordinate> basin = new HashSet<>();
            basin.add(lowPoint);
            basins.add(computeBasin(basin, lowPoint));
        }

        List<Set<Coordinate>> orderedBasins = new ArrayList<>(basins);
        orderedBasins.sort(Comparator.comparingInt(Set::size));
        long total = orderedBasins.getLast().size();
        total *= orderedBasins.get(orderedBasins.size() - 2).size();
        total *= orderedBasins.get(orderedBasins.size() - 3).size();
        printSolution(total);
    }

    public Set<Coordinate> computeBasin(
            Set<Coordinate> visited,
            Coordinate current
    ) {
        for (Coordinate test : current.orthogonal().stream().filter(oceanFloor::isInBounds).toList()) {
            if (oceanFloor.get(test) != 9 && !visited.contains(test)) {
                visited.add(test);
                visited = computeBasin(visited, test);
            }
        }
        return visited;
    }
}
