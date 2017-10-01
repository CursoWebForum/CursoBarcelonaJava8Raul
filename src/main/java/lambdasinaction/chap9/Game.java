package lambdasinaction.chap9;


import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String...args){
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(),
                        new Triangle(), new Ellipse());
        //Llama al metodo paint de la clase Utils que hemos definido
        Utils.paint(resizableShapes);
    }
}

