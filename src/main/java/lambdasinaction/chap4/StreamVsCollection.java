package lambdasinaction.chap4;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        // Stream<String> s = names.stream();
        //con metodo de referencia
        // s.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
        for (String name : names) {
            System.err.println(names);
        }
    }
}