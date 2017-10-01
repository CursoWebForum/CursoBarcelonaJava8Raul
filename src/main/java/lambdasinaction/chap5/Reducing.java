package lambdasinaction.chap5;
import lambdasinaction.chap4.*;

import java.util.stream.*;
import java.util.*;

import static lambdasinaction.chap4.Dish.menu;
//Temas tratados, operaciones de reduccion
//Se les llama operaciones de reducción porque reducen un flujo a un valor entero
//Escribir completa
public class Reducing{

    public static void main(String...args){

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        //Aqui utilizamos dos elementos , el valor inicial que es 0, y a través
        //de la interfaz BinaryOperator<T> que toma dos argumentos y devuelve
        //un resultado
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        //Metodo sum()
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);
        //Metodo max -> Utilizamos el metodo de referencia de la clase Integer
        
        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);
        
        //Metodo min + Clase Optional + Metodos de referencia----------------
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                           .map(Dish::getCalories)
                //Sumamos de nuevo todos los elementos
                           .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
