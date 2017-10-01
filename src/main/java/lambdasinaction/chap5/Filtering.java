package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.stream.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

import static lambdasinaction.chap4.Dish.menu;
//Temas tocados: Diferentes operaciones de filtrado con Stream

public class Filtering {
    private static Dish miplato=new Dish();

    public static void main(String... args) {

        // Filtros con predicado------------------escribir-------------
        List<Dish> vegetarianMenu
                = menu.stream()
                        .filter(Dish::isVegetarian)
                        //Metodo collect
                        .collect(toList());

        vegetarianMenu.forEach(System.out::println);
 
    
        // Filtros con un solo elemento--------------escribir-----------------
        /* List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
                //metodo distinct
               .distinct()
               .forEach(System.out::println);*/
        // Truncando un Stream-----------------------escribir------------------
        //Filtramos aquellos platos de mas 300 calorias, pero solo 3
        List<Dish> dishesLimit3
                = menu.stream()
                        .filter(p -> p.getCalories() > 300)
                        .limit(3)
                        .collect(toList());

       // dishesLimit3.forEach(System.out::println);
        // Saltando elementos------------------------escribir-----------------
        List<Dish> dishesSkip2
                = menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        //metodo se salta los 2 primeros platos
                        .skip(2)
                        .collect(toList());

        //dishesSkip2.forEach(System.out::println);
        //Stream con el metodo map()que devuelve una lista de Stream de tipo String
        //....escribir----
        List<String> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        dishNameLengths.forEach(System.out::println);
        
        //Otra operacion de Stream pero en este caso con 2 map() de tipo Integer
        //escribir
        List<Integer> dishNameLengths2 = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .collect(toList());
        dishNameLengths2.forEach(System.out::println);

    
}

    
    
}
