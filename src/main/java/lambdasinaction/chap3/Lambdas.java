package lambdasinaction.chap3;

import java.util.*;
// Temas Cubiertos: Expresiones Lambda
// Predicados
// Expresiones Lambdas y Interfaces Funcionales ( Solo especifican un método )
//Problema.. Ordenar la lista de Manzanas

public class Lambdas {
	public static void main(String ...args){

		// Ejemplo sencillo de utilización de Lambdas
               // Runnable r = () -> System.out.println("Hello!");
		//r.run();
                //Implementación de interfaz runnable sin lambdas
                 /*Runnable r2 = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Hola Mundo");
                    }
                };*/
                 
                
//-----------------------------------------------------------------------------
		// Filtering with lambdas e interfaz Predicate
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), 
                        new Apple(155, "green"), new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]	
		List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println(greenApples);
//------------------------------------------------------------------------------
                //ORDENACION DE LISTA
                //Utilizamos la interfaz funcional Comparator
                // y vemos que la firma del metodo coincide con una expresion lambda
		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
              
		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
                
		inventory.sort(c);
		System.out.println(inventory);
	}
//------------------------------------------------------------------------------
        //Implementacion de la interfaz Predicado en funcion de lo que recibe
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}   

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
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

	interface ApplePredicate{
		public boolean test(Apple a);
	}
}