package dec09;

import framework.InputLoaderParent;
import framework.utils.Coordinate;

import java.util.List;

public class InputLoader extends InputLoaderParent {

    public static List<Coordinate> loadRedTiles() {
        return loadLines().stream().map(line -> {
            String[] parts = line.split(",");
            return new Coordinate(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
        }).toList();
    }
}
