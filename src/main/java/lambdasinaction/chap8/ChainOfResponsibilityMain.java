package lambdasinaction.chap8;

import java.util.function.Function;
import java.util.function.UnaryOperator;


public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        //Seteamos un nuevo sucesos
        p1.setSuccessor(p2);
        String result1 = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result1);

// A traves de Lamdbas, la Interfaz Function, metodo andThen podemos mejorar
//el patron Chain of Responsability...escribir............................
      /*  UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);*/
    }//main()
//Clase abstracta que procesa el objeto
    static private abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }
//metodo manejador 
        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }
//Metodo abstracto 
        abstract protected T handleWork(T input);
    }
//Clases para generar la cadena de responsabilidad
    static private class HeaderTextProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }
    }

    static private class SpellCheckerProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}


