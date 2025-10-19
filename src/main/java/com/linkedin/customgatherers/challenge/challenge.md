# Stream gatherers

## Task 1: Refactor loop to Stream with built-in Gatherer

### The problem
You have code that groups numbers into batches of 3 using a traditional loop:

```java
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
```

**Current Output:**
```
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
[10]
```

### Your task

Refactor this code to use streams with the **`Gatherers.windowFixed()`** gatherer.

1. Replace the entire loop with a stream pipeline
2. Use `Gatherers.windowFixed(3)` to create batches
3. Produce the exact same output

**Template:**
```java
import java.util.List;
import java.util.stream.Gatherers;

public class BatchingWithGatherer {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // TODO: Replace the loop with a stream pipeline using Gatherers.windowFixed(3)
        numbers.stream()
               // Your code here
               .forEach(System.out::println);
    }
}
```

---

## Task 2: Complete the custom Gatherer

### The problem
You need a gatherer that doubles each number **only if** it's larger than the previous number. This requires keeping track of the previous value.

**Example:**
- Input: `5, 10, 3, 8, 12`
- Process:
    - `5` → emit `5` (first element, no previous)
    - `10` → emit `20` (10 > 5, so double it)
    - `3` → emit `3` (3 < 10, don't double)
    - `8` → emit `16` (8 > 3, so double it)
    - `12` → emit `24` (12 > 8, so double it)
- Output: `5, 20, 3, 16, 24`

### Your task

Complete the missing parts of this custom gatherer:

```java
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class DoubleIfLarger {
    
    public static Gatherer<Integer, ?, Integer> doubleIfLarger() {
        class State {
            // TODO: Add fields to track if we've seen a previous element
            //       and what that previous value was
        }
        
        return Gatherer.ofSequential(
            State::new,
            Gatherer.Integrator.ofGreedy((state, elem, downstream) -> {
                // TODO: Implement the logic:
                // 1. If this is the first element, just emit it as-is
                // 2. If elem > previous, emit elem * 2
                // 3. Otherwise, emit elem as-is
                // 4. Update state to remember this element
                
                return true; // continue processing
            })
        );
    }
    
    public static void main(String[] args) {
        Stream.of(5, 10, 3, 8, 12)
              .gather(doubleIfLarger())
              .forEach(System.out::println);
    }
}
```

**Expected Output:**
```
5
20
3
16
24
```
