package lambdasinaction.chap5;

import lambdasinaction.chap5.*;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/*
 
Responder a estas preguntas: 
1. Encuentre todas las transacciones en el año 2011 y clasifíquelas por valor 
(de menor a mayor).
2. ¿Cuáles son todas las ciudades únicas donde trabajan los comerciantes?
3. Encuentre a todos los comerciantes de Cambridge y clasifíquelos por nombre.
4. Devuelva una cadena de nombres de todos los operadores ordenados alfabéticamente.
5. ¿Hay comerciantes en Milán?
6. Imprima todos los valores de las transacciones de los comerciantes que viven en Cambridge.
7. ¿Cuál es el valor más alto de todas las transacciones?
8. Encuentre la transacción con el valor más pequeño.
*/

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Pregunta 1: Encuentre todas las transacciones del año 2011 y ordénelas por valor (menor a mayor).
        List<Transaction> tr2011 = transactions.stream()
                                               .filter(transaction -> transaction.getYear() == 2011)
                                               .sorted(comparing(Transaction::getValue))
                                               .collect(toList());
        System.out.println(tr2011);
        
        // Pregunta 2: ¿Cuáles son todas las ciudades únicas donde trabajan los comerciantes?
        List<String> cities = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);

        // Pregunta 3: Encuentre a todos los comerciantes de Cambridge y ordénelos por nombre.
        
        List<Trader> traders = 
            transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
        
        
        // Pregunta 4: Devuelve una cadena de nombres de todos los operadores ordenados alfabéticamente.
        
        String traderStr = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        
        // Pregunta 5: ¿Hay algún comerciante con sede en Milán?
        
        boolean milanBased =
            transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                                            .getCity()
                                                            .equals("Milan")
                                 );
        System.out.println(milanBased);
        
        
        // Pregunta 6: Actualizar todas las transacciones para que los operadores de Milán estén en Cambridge.
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Milan"))
                    .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);
        
        
        // pregunta 7:¿Busca el valor más alto en todas las transacciones? 7: 
        int highestValue = 
            transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);      
    }
}