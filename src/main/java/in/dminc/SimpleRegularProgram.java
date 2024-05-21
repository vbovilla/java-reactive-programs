package in.dminc;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SimpleRegularProgram {
    public static void main(String[] args) {
        Instant start = Instant.now();

        IntStream.range(1, 10).forEach(integer -> System.out.print(integer + " "));

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\n" + "Time taken: " + timeElapsed.toMillis() + " milliseconds ");
    }
}
