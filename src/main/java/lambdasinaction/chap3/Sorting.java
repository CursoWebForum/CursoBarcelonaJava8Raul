package lambdasinaction.chap3;

import java.util.*;
import static java.util.Comparator.comparing;
//Distintas maneras de comparar una lista
//terminado con una referencia a metodos

public class Sorting {

    public static void main(String...args){

        // 1
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), 
                new Apple(120, "red")));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        //Le pasamos al metodo sort() una interfaz
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, "green"));
        ///.....................................................................
        // 2 Con clase Anonima..................................................
        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight()); 
        }});
        System.out.println(inventory);
        //......................................................................
        // reshuffling things a little
        inventory.set(1, new Apple(20, "red"));
        
        // 3 Con expresion Lambda.............................................. 
        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        
        // reshuffling things a little
        inventory.set(1, new Apple(10, "red"));
        //.....................................................................
        // 4 Manera mejorada de realizar la comparacion, referencia a metodos
        // [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory); 
        //5 Metodo reversed//
        inventory.sort(comparing(Apple::getWeight).reversed());
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color){
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
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
