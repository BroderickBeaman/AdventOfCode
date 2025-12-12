package aoc2023.dec24;

public record Point(Float x, Float y) {

    public boolean isInBoundary(Long min, Long max) {
        return (x >= min && x <= max && y >= min && y <= max);
    }
}
