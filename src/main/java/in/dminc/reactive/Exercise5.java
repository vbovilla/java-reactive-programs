package in.dminc.reactive;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) throws IOException {
        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono().subscribe(
                System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Done")
        );
        ReactiveSources.userMono().subscribe(
                System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Done")
        );


        // Use ReactiveSources.intNumberFlux()
        ReactiveSources.intNumberMono().subscribe(
                System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Done")
        );


        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }
}


class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(5);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(2);
    }
}