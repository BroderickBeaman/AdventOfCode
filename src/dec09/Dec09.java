package dec09;

import framework.AOCParent;
import framework.utils.Coordinate;

import java.util.List;

public class Dec09 extends AOCParent {

    private List<Coordinate> redTiles;
    private Polygon polygon;

    @Override
    public void loadInput() {
        redTiles = InputLoader.loadRedTiles();
        polygon = new Polygon(redTiles);
    }

    @Override
    public void part1() {
        long largestRect = 0;
        for (int i = 0; i < redTiles.size() - 1; i++) {
            Coordinate a = redTiles.get(i);
            for (int j = i + 1; j < redTiles.size(); j++) {
                Coordinate b = redTiles.get(j);
                long rect = area(a, b);
                largestRect = Math.max(largestRect, rect);
            }
        }
        printSolution(largestRect);
    }

    @Override
    public void part2() {
        long largestRect = 0;
        for (int i = 0; i < redTiles.size() - 1; i++) {
            Coordinate a = redTiles.get(i);
            for (int j = i + 1; j < redTiles.size(); j++) {
                Coordinate b = redTiles.get(j);
                long rect = area(a, b);
                if (rect > largestRect && rectSpotCheck(a, b)) {
                    largestRect = rect;
                }
            }
        }
        printSolution(largestRect);
    }

    private long area(Coordinate a, Coordinate b) {
        long rowDiff = a.row() - b.row();
        long colDiff = a.col() - b.col();
        return Math.abs((rowDiff + 1) * (colDiff + 1));
    }

    private boolean rectSpotCheck(Coordinate a, Coordinate b) {
        int halfRow = (a.row() + b.row()) / 2;
        int halfCol = (a.col() + b.col()) / 2;

        for (int i = Math.min(a.col(), b.col()); i <= Math.max(a.col(), b.col()); i++) {
            if (!polygon.contains(new Coordinate(halfRow, i))) {
                return false;
            }
        }

        for (int i = Math.min(a.row(), b.row()); i <= Math.max(a.row(), b.row()); i++) {
            if (!polygon.contains(new Coordinate(i, halfCol))) {
                return false;
            }
        }

        return true;
    }
}
