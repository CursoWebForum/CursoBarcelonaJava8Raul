package lambdasinaction.chap5;
import lambdasinaction.chap4.*;

import java.util.stream.*;
import java.util.*;
//Temas tratados. Estudio de los metodos del Api Stream: anyMatch, allMatch, 
//noneMacht y findAny()
//Clase Optional -> Representa la ausencia o presencia de un valor. Chap 10 +
//Principles metodo en pagina 131 Java in action. 
//Escribir completa

import static lambdasinaction.chap4.Dish.menu;

public class Finding{

    public static void main(String...args){
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }
    //anyMatch devuelve verdadero si todos los elementos cumplen la condicion
    private static boolean isVegetarianFriendlyMenu(){
        return menu.stream().anyMatch(Dish::isVegetarian);
    }
    
    private static boolean isHealthyMenu(){
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }
    
    private static boolean isHealthyMenu2(){
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }
    
    private static Optional<Dish> findVegetarianDish(){
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
    
}
