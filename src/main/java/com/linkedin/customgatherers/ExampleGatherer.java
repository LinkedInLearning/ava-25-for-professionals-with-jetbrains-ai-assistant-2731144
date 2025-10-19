package com.linkedin.customgatherers;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class ExampleGatherer {
    void main() {
        Stream.of(1, 2, 3, 4, 5, 6, 7)
                .gather(Gatherers.windowFixed(3))
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4)
                .gather(Gatherers.scan(() -> 0, (sum, next) -> sum + next))
                .forEach(System.out::println);


    }
}
