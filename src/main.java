import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class main {
    LinkedList<Integer> matriz = new LinkedList<>();
    boolean prop1, prop2, prop3;
    int[][] Matriz = new int[4][4];

    int dimension=1, i=2;

    public static void main(String[] args) {
        main m=new main();
        m.prop1 = m.prop2 = m.prop3 = false;
        m.readMatriz();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m.matriz.add(m.Matriz[i][j]);
            }
        }

        if(m.propiedad2() && m.propiedad3())
            System.out.println("Es equivalente");
        else
            System.out.println("No es equivalente");
    }

    public boolean propiedad2(){
        dimension=(int)Math.sqrt(matriz.size());
        LinkedList<Integer> simetrica = new LinkedList<>();
        int posicion=0, patron=0;
        for (int j = 0; j < matriz.size(); j++) {
            simetrica.add(matriz.get(j));
        }

        for (i = 0; i < matriz.size(); i++) {
            simetrica.set(posicion, matriz.get(i));
            posicion+=dimension;
            if (posicion>(matriz.size()-1))
                if (patron<matriz.size()){
                    patron++;
                    posicion=patron;
                }
        }
        for (i = 0; i < matriz.size(); i++) {
            if (simetrica.get(i) != matriz.get(i)) {
                prop2 = false;
                break;
            }
            else
                prop2 = true;
        }
        return prop2;
    }

    public boolean propiedad3(){
        LinkedList<Integer> matriz2 = new LinkedList<>();
        LinkedList<Integer> transitiva = new LinkedList<>();
        for (i = 0; i < matriz.size(); i++)
            matriz2.add(matriz.get(i));

        for (int j = 0; j < matriz.size(); j++)
            transitiva.add(matriz.get(j)*matriz2.get(j));

        for (i = 0; i < matriz.size(); i++) {
            if (transitiva.get(i) != matriz.get(i)) {
                prop3 = false;
                break;
            }
            else
                prop3 = true;
        }

        return prop3;
    }

    public int[][] readMatriz(){

        try {
             //para que se almacene
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
