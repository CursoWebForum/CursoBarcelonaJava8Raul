package lambdasinaction.chap8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
//Patron factory

public class FactoryMain {

    public static void main(String[] args) {
        //< 1.8
        Product p1 = ProductFactory.createProduct("loan");
        // Java 8...escribir..................................................
        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();
        System.err.println(p2);
        //Con el metodo de factoria createProductLambda..escribir.........
        Product p3 = ProductFactory.createProductLambda("loan");
        System.err.println(p3);

    }
//Clase Factory. Se encarga de instanciar diferentes tipos de productos
    static private class ProductFactory {
        public static Product createProduct(String name){
            switch(name){
                case "loan": return new Loan();
                case "stock": return new Stock();
                case "bond": return new Bond();
                default: throw new RuntimeException("No such product " + name);
            }
        }
//Metodo que retorna el nombre, Notar el uso de lambdas y funciones..escribir.
        public static Product createProductLambda(String name){
            //Hace uso del HashMap recuperamos del map el tipo de producto a instanciar
            Supplier<Product> p = map.get(name);
            if(p != null) return p.get();
            throw new RuntimeException("No such product " + name);
        }
    }//Fin clase ProductFactory

    static private interface Product {}
    static private class Loan implements Product {}
    static private class Stock implements Product {}
    static private class Bond implements Product {}

    //Mapa que hace las veces de suministrado de Productos
    final static private Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
}
