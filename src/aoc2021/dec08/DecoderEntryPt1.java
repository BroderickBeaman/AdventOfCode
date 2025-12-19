package aoc2021.dec08;

import java.util.List;

public record DecoderEntryPt1(List<String> inputs, List<String> outputs) {
    public long count1478() {
        return outputs.stream().filter(output -> {
            int size = output.length();
            return size == 2 || size == 3 || size == 4 || size == 7;
        }).count();
    }
}
