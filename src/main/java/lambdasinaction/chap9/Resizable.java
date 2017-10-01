package lambdasinaction.chap9;
//un ejemplo donde definimos una interfaz con estos metodos
//Existe una implementacion de nuestra interfaz en 
public interface Resizable extends Drawable{
    public int getWidth();
    public int getHeight();
    public void setWidth(int width);
    public void setHeight(int height);
    public void setAbsoluteSize(int width, int height);
  //  public void setRelativeSize(int widthFactor, int heightFactor);

   /*  public default void setRelativeSize(int widthFactor, int heightFactor){
         System.err.println(widthFactor+""+heightFactor);
     };*/
}

