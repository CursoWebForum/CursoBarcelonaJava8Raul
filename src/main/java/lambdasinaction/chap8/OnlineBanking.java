package lambdasinaction.chap8;
//patron "template" method
//Creamos una clase que procesa una solicitud de un cliente y através de un
//metodo se comunica con el cliente y hace algo, otras sucursales pueden tener
//Problema : otras maneras de hacer felices a los clientes....patron template

abstract class OnlineBanking {
    
    public static void main(String[] args) {
        OnlineBanking java7= new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                //codigo aqui
            }
        };
    }
   
    //este metodo representa un diseño del algoritmo 
    //de tal manera que se pueden hacer diferentes implementaciones  
    //makeCustomerHappy(c);
    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }
    abstract void makeCustomerHappy(Customer c);


    // dummy Customer class
    static private class Customer {}
    // dummy Datbase class
    static private class Database{
        //metodo que devuelve un customer
        static Customer getCustomerWithId(int id){ return new Customer();}
    }
}
