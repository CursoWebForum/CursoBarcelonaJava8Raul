package lambdasinaction.chap1;

import java.util.*;
import java.util.function.Predicate;
//Aspectos, tocados en este código. 
//-Predicados-> - Expresiones Lambda ->  - Referencias a metodos
//Es importante destacar que si las lambdas necesitan mucho código es mejor
//usar referencias a metodos....es mejor CLARIDAD DE CODIGO. 

public class FilteringApples {

    public static void main(String... args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

//filterApples-> referencia a los demas, es el metodo que contiene el predicado
//Tambien introducimos el concepto de referencia a metodos...ESCRIBIR...........
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

//Con expresiones Lambda mejoramos la referencia a metodos------ESCRIBIR--------

        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);


        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80
                || "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }// Fin metodo main()

    //Metodos que necesitariamos para hacer distintos filtros Java 7------------
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //Metodos que necesitariamos para hacer distintos filtros Java 7------------
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    //Metodos que necesitariamos para hacer distintos filtros para Java 8 ------
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    //Metodos que necesitariamos para hacer distintos filtros para Java 8-------
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

//Java. 8.PREDICADOS: Un predicado es una funcion que devuelve verdadero o false
//Este metodo Introduce las manzanas en la lista.....y devuelve true o false
    //escribir
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            //test evalua el predicado
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
        }
    }
    
    
}
