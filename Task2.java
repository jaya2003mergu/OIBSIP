import java.util.Scanner;
public class Task2 {

	public static void
	guessingNoGame()
	{
		Scanner sc = new Scanner(System.in);

		int no = 1 + (int)(100 * Math.random());
		int N = 5,Score=100,i, guess;

		System.out.println("#A number is chosen" + " between 1 to 100."	+ "\n#Guess the number"	+ " within 5 trials.");
		System.out.println("\n!!!!All THE BEST!!!!\n");
		for (i = 0; i < N; i++) {
            Score=Score-20;
			System.out.println("Guess the number:");

			// Take input for guessing
			guess = sc.nextInt();

			// If the number is guessed
			if (no == guess) {
				System.out.println("Congratulations!" + " You guessed the number."+"\n The score is:"+ Score);
                break;
			}

			else if (no > guess && i != N - 1) {
				System.out.println("The number is "	+ "greater than " + guess);
			}
            
			else if (no < guess	&& i != N - 1) {
				System.out.println("The number is" + " less than " + guess);
			}
		}

		if (i == N) {
			System.out.println("You have exhausted"	+ " trials.");

			System.out.println("The number was " + no);
            System.out.println("\nYour score is: 0 ");
		}
	}

	// Driver Code
	public static void main(String arg[])
	{
		// Function Call
		guessingNoGame();
	}
}
