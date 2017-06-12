import java.util.Scanner;
import java.util.Random;

public class Ch3Ex10
{
	public static void main(String []argv)
	{
		Scanner input = new Scanner(System.in);
		Random randomGenerator = new Random();

		int score = 0;
		int C_score = 0;
		int win = 0;

		while(win < 1)
		{
			int next = 0;
			int roll_points = 0;
			while(next < 1)
			{
				System.out.println("Would you like to roll again?");
				System.out.println("Type (0) to keep rolling");
				System.out.println("Type (1) to end your turn and let me roll");
				System.out.println("You: " + score + ", Comp: " + C_score);
				System.out.println("The current amount you could add to your score by ending your turn is " + roll_points);

				next = input.nextInt();

				if(next == 0)
				{
					int dice1 = randomGenerator.nextInt(7);
					while(dice1 == 0)
					{
						dice1 = randomGenerator.nextInt(7);
					}

					if(dice1 == 1)
					{
						System.out.println("You rolled a 1");
						System.out.println("Sorry, you lose the points accumulated this turn. Now its my turn!");
						roll_points = 0;
						next = 2;
					}

					else
					{
						System.out.println("You rolled a " + dice1);
						roll_points = roll_points + dice1;
					}
				}

				else if (next == 1)
				{
					System.out.println("Alright, I will add " + roll_points + " points to your score");
					score = score + roll_points;
					System.out.println("Now it's my turn!");
				}

				else
				{
					System.out.println("Please follow the on-screen instructions");
					next = 0;
				}
			}

			next = 0;
			roll_points = 0;

			while(next < 1)
			{
				int dice2 = randomGenerator.nextInt(7);

				if(dice2 == 1)
				{
					System.out.println("Rats! I rolled a 1! No new points for me this turn!");
					System.out.println(" ");
					roll_points = 0;
					next = 1;
				}

				else if (roll_points >= 20)
				{
					System.out.println("Alright, I scored " + roll_points + " points this turn");
					System.out.println(" ");
					C_score = C_score + roll_points;
					next = 1;
				}

				else
				{
					roll_points = roll_points + dice2;
				}
			}

			if(score >= 100)
			{
				System.out.println("You win with a score of " + score + " points");
				win = 1;
			}

			else if (C_score >= 100)
			{
				System.out.println("I win with a score of " + C_score + " points");
				win = 1;
			}

			else
			{
				win = 0;
			}
		}
	}
}
