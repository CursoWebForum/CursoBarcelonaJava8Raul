package lambdasinaction.chap8;

import java.util.ArrayList;
import java.util.List;
//Patron observer con lambdas 
//Supuesto. Varias agencias de noticias se subscriben a un Fedd

public class ObserverMain {

    public static void main(String[] args) {
        //Creamos un nuevo Fed
        Feed f = new Feed();
        //registramos los observadores
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

 //Con lambdas registramos los observer escribir...............................
        Feed feedLambda = new Feed();
//Nos permite parametrizar el comportamiento, la lambda hace referencia a la 
//firma de la interfaz Observe....................escribir....................
        feedLambda.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet); }
        });
        feedLambda.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet); }
        });
//recorremos la lista y vamos notificando...........escribir...............
        feedLambda.notifyObservers("Money money money, give me money!");

    }

//Primero necesitamos crear la interfaz donde las agencias se subscribiran..escribir
    interface Observer{
        void inform(String tweet);
    }
//Tercero diseñamos la interfaz sujeto...
    interface Subject{
        //Esta clase puede registrar obsevadores
        void registerObserver(Observer o);
        // Notificar obsevadores
        void notifyObservers(String tweet);
    }
//Diferentes observadores que se subcriben  nuestro Feed y que tienen distintos
    //comportamientos (comentados)
    static private class NYTimes implements Observer{
        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY!" + tweet);
            }
        }
    }
//Diferentes observadores que se subcriben  nuestro Feed y que tienen distintos
    //comportamientos e implementan Observer
    static private class Guardian implements Observer{
        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        }
    }
//Diferentes observadores que se subcriben  nuestro Feed y que tienen distintos
    //comportamientos
    static private class LeMonde implements Observer{
        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("wine")){
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }

    //
    static private class Feed implements Subject{
        private final List<Observer> observers = new ArrayList<>();
        //este metodo recibe un observer de tal manera que le pasamos un
        //predicado (true-false) de la intefaz Observer
        public void registerObserver(Observer o) {
            this.observers.add(o);
        }
        public void notifyObservers(String tweet) {
            //metodo inform
            observers.forEach(o -> o.inform(tweet));
        }
    }

}
