package lambdasinaction.chap8;


import java.util.*;
//Codigo que falla
//solo comentar
public class Debugging{
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        //codigo que falla
        //points.stream().map(p -> p.getX()).forEach(System.out::println);
        //codigo que falla
       // points.stream().map(Point::getX).forEach(System.out::println);
    }


    private static class Point{
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
// Exception in thread "main" java.lang.NullPointerException 
//at lambdasinaction.chap8.Debugging.lambda$main$0(Debugging.java:9)
//estos nos dice que el error se produjo en una lambda
        