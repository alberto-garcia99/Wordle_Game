import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*LOGICA PRINCIPAL DE JUEGO*/

/**
 * @author Alberto Garcia Castaño
 */
public class WordleGame{
    private static final int MAX_TRIES=6;
    private String[] palabras;
    private String secretWord;
    private int remainingAttemepts;
    private List<String> triesHistory;

    /**
     *
     * @param fileWords Array de palabras previamente extraidas del .TXT
     */
    public WordleGame(String[] fileWords) {
        this.palabras = fileWords;
        this.secretWord = selectRandomWord(fileWords);
        this.remainingAttemepts = MAX_TRIES;
        this.triesHistory = new ArrayList<>();

    }

    /**
     *
     * @param words un Array de palabras donde selecciona una aleatoria
     * @return palabra aleatoria
     */
    //Del array indicado nos devuelve una palabra aleatoria
    public String selectRandomWord(String [] words){
        int numRandom = (int) (Math.random()*10);
        String[] palabras = words;
        return words[numRandom];

    }


    //Muestra los intentos por el usuario
    public void showTriesHistory(){
        System.out.println("*******Palabra utilizadas************ ");
        for (String list : triesHistory){
            System.out.println(WordleFeedBack.feedBackString(list, secretWord));
        }
        System.out.println("*************************************");
    }

    /**
     *
     * @param scanner palabra introducia por el usuario
     * @return devuelve la palabra ingresada si es válida
     */
   public String getUserInput(Scanner scanner){
        String palabra;
       while(true){
           System.out.println("Introducir palabra:");
           palabra = scanner.nextLine().toUpperCase();
           if (palabra.length()==5){
               return palabra;
           }else{
               System.out.println("¡ERROR, Esta palabra no tiene 5 letras!");
           }
       }
    }


    //Ciclo principal del juego
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("************Bienvenido a Wordle**************" + "\n"+
        "REGLAS:"+ "\n"+ "Introducir una palabra de 5 letras" + "\n"+
                "Tienes 6 intentos para adiviinar la palabra, " + "\n"+
                "Si la letra es verde, será la correcta en el lugar indicado, " + "\n" +
                "Si la letra es amarilla, estará en la palabra pero en el lugar erroneo, " + "\n"+
                "y gris, no la contiene." + "\n"+
                "********************************");

    //Bucle que permite al usuario realizar intentos hasta que adivine la palabra o se quede sin intentos
        while(remainingAttemepts>0){
            System.out.println("Intentos disponibles: "+ remainingAttemepts);
            String palabrause = getUserInput(scanner);
            triesHistory.add(palabrause);


            if (palabrause.equalsIgnoreCase(secretWord)) {
                showTriesHistory();
                System.out.println("¡CORRECTO! Adivinase la palabra.");
                break;
            }else {
                String feeback = WordleFeedBack.feedBackString(palabrause, secretWord);
                remainingAttemepts--;
                showTriesHistory();
                System.out.println("❌ PALABRA INCORRECTA ❌");
            }
        }
        WordleFileManager.almacenarPalabras(triesHistory);
        if (remainingAttemepts==0){
            System.out.println("Se acabaron los intentos... la palabra correcta era: "+ secretWord);
        }
    }
}
