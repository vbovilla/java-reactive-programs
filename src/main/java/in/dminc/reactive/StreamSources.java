package in.dminc.reactive;

import java.util.stream.Stream;

/**
 * This class is a source of collection streams used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author Vishnu Bovilla
 */
public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> (i + 2))
                .limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Diego", "Mara dona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Kinsman"),
                new User(6, "Gareth", "Bale")
        );
    }
}