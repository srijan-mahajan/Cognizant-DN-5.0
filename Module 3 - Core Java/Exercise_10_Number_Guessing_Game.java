import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {

        Random random = new Random();
        int secret = random.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);

        int guess;

        do {
            System.out.print("Enter guess: ");
            guess = sc.nextInt();

            if(guess > secret)
                System.out.println("Too High");
            else if(guess < secret)
                System.out.println("Too Low");
            else
                System.out.println("Correct!");
        }
        while(guess != secret);
    }
}