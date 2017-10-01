package lambdasinaction.chap8;

//Patron Strategy... Varios algoritmos pasados a un método
//En este caso estamos pasando diferentes implementaciones a un metodo validador
// 
public class StrategyMain {

    public static void main(String[] args) {
        // Vieja escuela
        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaaa"));
        Validator v2 = new Validator(new IsAllLowerCase ());
        System.out.println(v2.validate("bbbb"));


        // con lambdas
        Validator v3 = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(v3.validate("aaaa"));
        Validator v4 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(v4.validate("bbbb"));
    }
//lo primero es crear la interfaz.............................escribir..........
    interface ValidationStrategy {
        //el metodo matches hace las veces de execute, le podemos pasar lambdas
        //porque las signatura coinciden...
        public boolean execute(String s);
    }
//Lo segundo es crear las dos implementaciones para la interfaz....escribir.....
    static private class IsAllLowerCase implements ValidationStrategy {
        //nos devuelve si la cadena coincide con el String s....
        public boolean execute(String s){
            return s.matches("[a-z]+");
        }
    }
//Lo segundo es crear las dos implementaciones para la interfaz....escribir....
    static private class IsNumeric implements ValidationStrategy {
        public boolean execute(String s){
            return s.matches("\\d+");
        }
    }
//Creamos la clase Validator para que reciba distintas estrategias...
    static private class Validator{
        //tiene un atributo 
        private final ValidationStrategy strategy;
        public Validator(ValidationStrategy v){
            this.strategy = v;
        }
        //metodo booleanos
        //llama a execute
        public boolean validate(String s){
            
            return strategy.execute(s); }
    }
}
