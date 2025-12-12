package aoc2024.dec03;

record Instruction(long x, long y) {
    long multiply() {
        return x * y;
    }
}
