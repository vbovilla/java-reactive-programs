package in.dminc;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;

public class SimpleReactiveProgram {
    public static void main(String[] args) {
        Instant start = Instant.now();

        Flux<Integer> numbers = Flux.range(1, 10);
        numbers.subscribe(integer -> System.out.print(integer + " "));

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\n" + "Time taken: " + timeElapsed.toMillis() + " milliseconds ");
    }
}
