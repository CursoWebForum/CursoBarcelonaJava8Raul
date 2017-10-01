package lambdasinaction.chap9;
//Problema; misma firma del metodo
public class Ambiguous{

    public static void main(String... args) {
        //Que saludo muestra??
        new C().hello();
    }

    static interface A{
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }
//En este ejemplo debemos explicitar que interfaz es la que ejecuta nuestro 
    //metodo hello, ya que aquí A y B son independientes.
    static class C implements B, A {
        public void hello(){
            //A.super.hello();
        }
    }
}
