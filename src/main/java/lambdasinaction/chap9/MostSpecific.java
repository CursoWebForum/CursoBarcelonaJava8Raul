package lambdasinaction.chap9;
//Regla del más especifico.....
public class MostSpecific{

    public static void main(String... args) {
        new C().hello();
        new E().hello();
        new G().hello();
    }

    static interface A{
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B extends A{
        public default void hello() {
            System.out.println("Hello from B");
        }
    }
//al crear un objeto de esta clase se toma la regla de la interfaz mas especifica
    //y
    static class C implements B, A {}

    static class D implements A{}
//Aqui se produce la colisión entre interfaces, gana la mas especifica
    static class E extends D implements B, A{}

    static class F implements B, A {
        public void hello() {
            System.out.println("Hello from F");
        }
    }
//Aqui gana la primera regla, se imprime el metodo de la clase
    static class G extends F implements B, A{}

}

