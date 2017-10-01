package lambdasinaction.chap6;

import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

//operaciones de sumarizacion

public class Summarizing {

    public static void main(String ... args) {
       // System.out.println("Nr. of dishes: " + howManyDishes());
       // System.out.println("The most caloric dish is: " + findMostCaloricDish());
       // System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
       // System.out.println("Total calories in menu: " + calculateTotalCalories());
       // System.out.println("Average calories in menu: " + calculateAverageCalories());
       // System.out.println("Menu statistics: " + calculateMenuStatistics());
        //System.out.println("Short menu: " + getShortMenu());
       // System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

//Contar el numero de platos...escribir..................escribir................
    private static long howManyDishes() {
        return menu.stream().collect(counting());
    }
//Encontrar el plato con mas calorias....................escribir..............
    private static Dish findMostCaloricDish() {
        return menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }
//Usando un comparador..................................escribir...............
    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().collect(reducing(moreCaloricOf)).get();
    }
//Con summingInt
    private static int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }
//Calculo de la media.....................................escribir..........
    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }
//Con IntSummaryStatistics .............................escribir............
    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }
//Con joining......................................escribir....................
    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining());
    }
//Separados por comas................................escribir..................
    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
