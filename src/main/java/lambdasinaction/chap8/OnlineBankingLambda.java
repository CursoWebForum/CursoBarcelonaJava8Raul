package lambdasinaction.chap8;

import java.util.function.Consumer;

//Mismo patron "template method" que OnlineBanking pero con lambdas
//Escribir completa.
public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, 
                (Customer c) -> System.out.println("Hello!"));
    }
//Aqui presentamos un Consumer<> porque las signaturas de ambos metodos coinciden
   
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    // dummy Customer class
    static private class Customer {}
    // dummy Database class
    static private class Database{
        static Customer getCustomerWithId(int id){ return new Customer();}
    }
}
