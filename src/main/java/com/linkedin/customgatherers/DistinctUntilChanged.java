package com.linkedin.customgatherers;
import java.util.Objects;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class DistinctUntilChanged {

    public static <T> Gatherer<T, ?, T> distinctUntilChanged() {
        class State {
            boolean hasPrev;
            T prev;
        }

        return Gatherer.ofSequential(
                State::new,
                Gatherer.Integrator.ofGreedy((state, elem, downstream) -> {
                    if (!state.hasPrev || !Objects.equals(state.prev, elem)) {
                        state.prev = elem;
                        state.hasPrev = true;
                        downstream.push(elem);
                    }
                    return true;
                }),
                (state, downstream) -> {}
        );
    }

    void main(String[] args) {
        Stream.of("b", "a","a","b","b","c")
                .gather(distinctUntilChanged())
                .forEach(System.out::println); // b, a, b, c
    }
}