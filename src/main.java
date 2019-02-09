import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class main {
    LinkedList<Integer> matriz= new LinkedList<>();
    boolean prop1, prop2, prop3;

    public static void main(String[] args) {
        main m=new main();
        m.prop1 = m.prop2 = m.prop3 = false;
        m.readMatriz();
    }

    public int[][] readMatriz(){

        try {
             //para que se almacene
                int[][] Matriz = new int[4][4];
                //para que lea el archivo
                BufferedReader bf = new BufferedReader(new FileReader("archivo/matriz.txt"));

                int longitud=0;
                String Linea = bf.readLine();
                while(Linea != null && longitud<4){
                    String[] tmp = Linea.split(" ");
                    for(int x=0;x<4;x++)
                        Matriz[longitud][x] = Integer.valueOf(tmp[x]);
                    System.out.println(Linea);
                    Linea = bf.readLine();
                    longitud++;

                }
                return Matriz;
        } catch (IOException ex) {

        }
        return null;
    }


}
