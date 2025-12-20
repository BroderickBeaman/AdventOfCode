package aoc2021.dec11;

import framework.InputLoaderParent;
import framework.utils.Grid;

import java.util.List;

public class InputLoader extends InputLoaderParent {

    public static Grid<Integer> loadGrid() {
        List<String> lines = loadLines();
        final int rows = lines.size();
        final int cols = lines.getFirst().length();
        Grid<Integer> grid = new Grid<>(Integer.class, rows, cols);

        for (int row = 0; row < rows; row++) {
            String line = lines.get(row);
            for (int col = 0; col < cols; col++) {
                grid.set(Integer.parseInt(line.charAt(col) + ""), row, col);
            }
        }

        return grid;
    }
}
