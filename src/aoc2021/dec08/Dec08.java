package aoc2021.dec08;

import framework.AOCParent;

import java.util.List;

public class Dec08 extends AOCParent {

    List<DecoderEntryPt1> entriesPt1;
    List<DecoderEntryPt2> entriesPt2;

    @Override
    public void loadInput() {
        entriesPt1 = InputLoader.loadEntriesPt1();
        entriesPt2 = InputLoader.loadEntriesPt2();
    }

    @Override
    public void part1() {
        long sum = entriesPt1.stream().mapToLong(DecoderEntryPt1::count1478).sum();
        printSolution(sum);
    }

    @Override
    public void part2() {
        long sum = entriesPt2.stream().mapToLong(DecoderEntryPt2::computeOutput).sum();
        printSolution(sum);
    }
}
