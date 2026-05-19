import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * @author Alberto Garcia Castaño
 */
public class WordleFileManager {
    /**
     *
     * @return array de palabras extraidas del documento txt
     */
    public static String[] sacarPalabras(){
       List<String> palabras = new ArrayList<>();
        /* El bloque try intenta ejecutar el codigo, que podría lanzar una excepción*/
        try {
            /*Declaramos un objeto BufferedReader que lee el flujo de entrada de cada linea.
            Dentro de el otro objeto FileReader para abrir el documento en la ruta indicada*/
            BufferedReader entrada = new BufferedReader(new FileReader("palabras.txt"));
            //Declaramos una variable donde almacenará cada linea leida
            String linea= " ";
            /*En un bucle, tenemos que asignar cada linea leida a la variable "linea", con el metodo .readLine()
            cuando llega al final devuelve null, y se detiene el bucle*/
            while((linea=entrada.readLine())!=null){
                palabras.add(linea.trim());
            }
            //El bloque catch ejecuta el codigo de su interior, en caso de que el bloque try de error.
        } catch(IOException e) {
            System.out.println("No se encuentra el archivo");
        }
        return palabras.toArray(new String[0]);
    }

    /**
     *
     * @param palabras recoge las palabras usadas en cada partida por parametro
     */
    public static void almacenarPalabras(List<String> palabras){
        int partidas=0;

        try ( BufferedWriter bf1 = new BufferedWriter(new FileWriter("palabras-almacenadas.txt", true))){

            for (String list : palabras){
                bf1.write(list + "\n");
            }
            bf1.write("-----\n");
        }catch (Exception e){
            System.out.println("Error:" +e.getMessage());
        }
    }
}
