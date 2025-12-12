package aoc2024.dec09;

import framework.InputLoaderParent;

import java.util.ArrayList;
import java.util.List;

class InputLoader extends InputLoaderParent {

    static List<Integer> loadDiskMap() {
        String line = loadLines().get(0);
        List<Integer> diskMap = new ArrayList<>();
        for (Character character : line.toCharArray()) {
            diskMap.add(Integer.parseInt(character.toString()));
        }
        return diskMap;
    }
}
