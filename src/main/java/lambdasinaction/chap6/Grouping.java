package lambdasinaction.chap6;

import java.util.*;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.dishTags;
import static lambdasinaction.chap6.Dish.menu;
//Clase Collectors
// groupingBy() Devuelve un Colector implementando una operación en cascada "group by" en los 
//elementos de entrada del tipo T, agrupando los elementos según una función de 
//clasificación, y luego realizando una operación de reducción en los valores 
//asociados a una clave dada utilizando el Colector especificado

public class Grouping {

    enum CaloricLevel { DIET, NORMAL, FAT };

    public static void main(String ... args) {
       // System.out.println("Dishes grouped by type: " + groupDishesByType());
        //System.out.println("Dish names grouped by type: " + groupDishNamesByType());
        //System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
       // System.out.println("Caloric dishes grouped by type: " + groupCaloricDishesByType());
       // System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
       // System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
       // System.out.println("Count dishes in groups: " + countDishesInGroups());
       // System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
      //  System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals());
       // System.out.println("Sum calories by type: " + sumCaloriesByType());
       // System.out.println("Caloric levels by type: " + caloricLevelsByType());
    }

    
    //Platos agrupados por tipo.................escribir......................
    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }
//Platos agrupados por el nombre y su tipo...............escribir.....................
    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        //mapping devuelve un colector con elementos agrupados en una lista
        //grouppingBy devuelve un colector implementando una operacion en cascda
        // y hace una reduccion
        
        return menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    /*private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
        return menu.stream().collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get( dish.getName() ).stream(), toSet())));
    }
*/
    //Platos agrupados por calorias y tipo con filtro de predicado...escribir...
    private static Map<Dish.Type, List<Dish>> groupCaloricDishesByType() {
     return menu.stream().filter(dish -> dish.getCalories() > 500).collect(groupingBy(Dish::getType));
       // return menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
    }
//Platos agrupados por nivel de calorias..................escribir.......................
    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));
    }
//Agrupacion de agrupacion de calorias y nivel de calorias.....escribir.........
    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream().collect(
                groupingBy(Dish::getType,groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        } )
                )
        );
    }
//Operaciones de conteo....
    private static Map<Dish.Type, Long> countDishesInGroups() {
        return menu.stream().collect(groupingBy(Dish::getType, counting()));
    }
//reducing() es un metodo mas generico para reducir un stream a un valor...escribir
    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }
//sin Optional y con collectionAndThen
    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOprionals() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(
                                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                                Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
    }
//Agrupacion por nivel de caloria con funcion mapping
    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT; },
                        toSet() )));
    }
}
