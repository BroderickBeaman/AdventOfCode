package dec09;

import framework.utils.Coordinate;

import java.util.List;

public record Polygon(List<Coordinate> points) {

    public boolean contains(Coordinate test) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
            if ((points.get(i).col() > test.col()) != (points.get(j).col() > test.col()) &&
                    (test.row() < (points.get(j).row() - points.get(i).row()) * (test.col() - points.get(i).col()) / (points.get(j).col()-points.get(i).col()) + points.get(i).row())) {
                result = !result;
            }
        }
        return result;
    }
}
