package lambdasinaction.chap6;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

//Operaciones de reducción

public class Reducing {

    public static void main(String ... args) {
        //System.out.println("Total calories in menu: " + calculateTotalCalories());
        //System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        //System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        //System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }
//Total de calorias.................................escribir...................
    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }
//Total de calorias con referencias a metodos........escribir..................
    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }
//Total de calorias sin collector...................escribir....................
    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }
//Total de calorias con sum............................escribir.................
    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }
}