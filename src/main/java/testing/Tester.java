package testing;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, i -> i + 1);

       System.out.println(stream.anyMatch(i -> i > 1));
         System.out.println(stream.collect(Collectors.toList()));
    }
}
