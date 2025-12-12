package aoc2023.dec25;

import java.util.Set;

public record NodeTraversalState(String currentNode, Set<Set<String>> seenWires) {

}
