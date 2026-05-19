
/**
@author Alberto Garcia Castaño
 @version 1.0 Beta
*/
public class Main {
    public static void main(String[] args) {

        String [] palabras = WordleFileManager.sacarPalabras();
        WordleGame juego1 = new WordleGame(palabras);

        juego1.start();

    }
}