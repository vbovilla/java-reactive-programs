package in.dminc.reactive;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {
    public static void main(String[] args) throws IOException {
        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources
                .intNumbersFluxWithException()
                .doOnError(System.out::println)
                .subscribe(System.out::println);

        ReactiveSources
                .intNumbersFluxWithException()
                .subscribe(
                        System.out::println,
                        error -> System.out.println(error.getMessage())
                );

        ReactiveSources
                .intNumbersFluxWithException()
                .subscribe(
                        System.out::println
                );

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources
                .intNumbersFluxWithException()
                .onErrorContinue((error, item) -> System.out.println("Error!!! " + error.getMessage()))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources
                .intNumbersFlux()
                .onErrorResume(error -> Flux.just(-1, -2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
