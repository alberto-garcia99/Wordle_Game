/**
 * @author Alberto García Castaño
 */

public class WordleFeedBack {
    private static final int WORD_LENGTH=5;
    public static final String ANSI_RESET= "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";


    /**
     *
     * @param letter
     * @param color
     * @return la palabra con los colores
     */
    private static String applyColor(String letter, String color){
        return color+letter+ ANSI_RESET;
    }

    /**
     *
     * @param guess
     * @param secretWord
     * @return devuelve las letras ya con su color respectivo y las convierte en String
     */
    public static String feedBackString(String guess, String secretWord){
        StringBuilder feedback = new StringBuilder();
        for(int i=0; i<WORD_LENGTH;i++){
            char guessletter = guess.charAt(i);

            if (guessletter == secretWord.charAt(i)){
                feedback.append(applyColor(Character.toString(guessletter), ANSI_GREEN));
            }else if(secretWord.contains(Character.toString(guessletter))){
                feedback.append(applyColor(Character.toString(guessletter), ANSI_YELLOW));
            } else {
                feedback.append(applyColor(Character.toString(guessletter), ANSI_WHITE));
            }
        }
        return feedback.toString();
    }
}
