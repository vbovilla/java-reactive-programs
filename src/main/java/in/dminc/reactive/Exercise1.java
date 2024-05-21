package in.dminc.reactive;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) {
        // Use StreamSources.intNumbersStream() and StreamSources.userStream()


        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(number -> System.out.print(number + " "));
        System.out.println("1st Task Completed");


        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(integer -> integer < 5).forEach(number -> System.out.print(number + " "));
        System.out.println("2nd Task Completed");


        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(integer -> integer > 5).skip(1).limit(2).forEach(number -> System.out.print(number + " "));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer result = StreamSources.intNumbersStream().filter(integer -> integer > 5).findFirst().orElse(-1);
        System.out.println(result);
        System.out.println("4th Task Completed");


        // Print first names of all users in userStream
        StreamSources.userStream().map(User::getFirstName).forEach(firstName -> System.out.print(firstName + " "));
        System.out.println("5th Task Completed");


        // Print first names in userStream for users that have IDs from number stream
//        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().collect(Collectors.toList()).contains(user.getId())).map(User::getFirstName).forEach(firstName -> System.out.print(firstName + " "));
        StreamSources
                .intNumbersStream()
                .flatMap(integer -> StreamSources.userStream().filter(user -> user.getId() == integer))
                .map(User::getFirstName)
                .forEach(name -> System.out.print(name + " "));
        System.out.println("6th Task Completed");
    }
}
