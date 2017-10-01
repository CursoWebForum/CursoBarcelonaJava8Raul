package lambdasinaction.chap3;

import java.io.*;

//Patron execute Around con Lambdas--
//Refactorización de codigo
public class ExecuteAround {

	public static void main(String ...args) throws IOException{

        // metodo que queremos refactorizar para hacerlo mas flexibe.
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

		//String oneLine = processFile((BufferedReader b) -> b.readLine());
		//System.out.println(oneLine);
//Al estar refactorizado podemos utilizar distintas lambdas en un solo metodo
		//String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		//System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Java8InAction\\src\\main\\resources\\lambdasinaction\\chap3\\data.txt"))) {
            return br.readLine();
        }
    }

//Metodo que va a utilizar las lambdas
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Java8InAction\\src\\main\\resources\\lambdasinaction\\chap3\\data.txt"))){
			return p.process(br);
		}

	}
//Interfaz que nos sirve para utilizar el patron execute around con Java 8
        //La interfaz tiene un metodo que recibe un BufferedReader y dispara
        //una excepcion.
	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}
