package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.*;
import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap4.Dish.menu;

public class Mapping{

    public static void main(String...args){

        // map que nos devuelve la lista de nombres.....escribir................
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .collect(toList());
        System.out.println(dishNames);

        // map que nos devuelve la longitud de las palabras....escribir.........
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        // flatMap, ........................................escribir...........
        //El uso del método flatMap tiene el efecto de asignar cada matriz 
        //no con un flujo, sino con el contenido de ese flujo. 
        //Todos los flujos separados que se generaron al usar
        //map (Arrays :: stream) se fusionan en una solo Stream
        //El metodo Arrays.stream toma un array y lo convierte en un flujo
        //ver pag..125 libro Java in Action
        words.stream()
                 .flatMap((String line) -> Arrays.stream(line.split("")))
                 .distinct()
                 .forEach(System.out::println);

        // flatMap que nos devuelve los numeros divisibles por 3...escribir....
       /* List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));*/
    }
}
