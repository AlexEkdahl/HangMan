import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String word = "Alexander"; // word to be guessed
        int life = 5; // number of chanses
        guess(word, life);
    }

    static public void guess(String word, int life) {
        char[] filler = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            filler[i] = '_';
            if (word.charAt(i) == ' ') {
                filler[i] = ' ';
            }
        }
        System.out.println(filler);
        System.out.println("        Life remaining = " + life);
        Scanner input = new Scanner(System.in);

        ArrayList<Character> list = new ArrayList<>();

        while (life > 0) {
            char x = input.next().charAt(0); // char input by user
            if (list.contains(x)) {
                System.out.println("Already enterd ");
                continue; // While loop continue
            }
            list.add(x);

            if (word.contains(x + "")) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == x) {
                        filler[j] = x;
                    }
                }
            } else {
                life--; // lose one life if char enterd is wrong
            }

            if (word.equals(String.valueOf(filler))) { // check if filler equals word
                System.out.println(filler);
                System.out.println("You won!");
                break;
            }

            System.out.println(filler);
            System.out.println("        Life remaining = " + life);

        }

        if (life == 0) {
            System.out.println("You lose");
        }

    }

}
