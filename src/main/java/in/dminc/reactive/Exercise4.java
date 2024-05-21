package in.dminc.reactive;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Integer number = ReactiveSources.intNumberMono().block();
        System.out.println(number);
        Optional<Integer> numberOptional = ReactiveSources.intNumberMono().blockOptional();
        System.out.println(numberOptional.isPresent() ? numberOptional.get() : "Empty");

        // Get the value from the Mono into an User variable
        User user = ReactiveSources.userMono().block();
        System.out.println("User " + user);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
