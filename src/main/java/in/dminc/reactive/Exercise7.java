package in.dminc.reactive;

import java.io.IOException;

public class Exercise7 {
    public static void main(String[] args) throws IOException {
        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        ReactiveSources
                .intNumbersFlux()
                .log()
                .filter(integer -> integer > 5)
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux that's greater than 5
        ReactiveSources
                .intNumbersFlux()
                .log()
                .filter(integer -> integer > 5)
                .map(integer -> integer * 10)
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        ReactiveSources
                .intNumbersFlux()
                .filter(integer -> integer > 5)
                .take(3)
                .map(integer -> integer * 10)
                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        ReactiveSources
                .intNumbersFlux()
                .filter(integer -> integer > 10)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch integers from intNumbersFlux to the right user from userFlux
        ReactiveSources
                .intNumbersFlux()
                .flatMap(integer -> ReactiveSources.userFlux().filter(user -> user.getId() == integer))
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources
                .intNumbersFluxWithRepeat()
                .log()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources
                .intNumbersFluxWithRepeat()
                .log()
                .distinctUntilChanged()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
