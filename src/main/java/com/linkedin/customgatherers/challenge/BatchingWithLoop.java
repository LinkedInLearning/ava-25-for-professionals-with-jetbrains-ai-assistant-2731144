package com.linkedin.customgatherers.challenge;

import java.util.ArrayList;
import java.util.List;

public class BatchingWithLoop {
    void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> batch = new ArrayList<>();
        for (int num : numbers) {
            batch.add(num);

            if (batch.size() == 3) {
                System.out.println(batch);
                batch = new ArrayList<>();
            }
        }

        // Print remaining items if any
        if (!batch.isEmpty()) {
            System.out.println(batch);
        }
    }
}