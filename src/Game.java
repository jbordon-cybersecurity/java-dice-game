import javax.swing.JOptionPane;

import java.util.Random;

public class Game {
	private int rounds = 5;// Number of rounds in the game
	private int money = 3;// Initial amount of money the user has
	private int betAmount = 1;// Initial bet amount

	public void start() {
		String userName;
		int userBet;
		int betDouble = 0;
		int age = requireAgeValidated();
		int userAnswer;
		String betResult = null;// Result of the bet (Yes/No)
		int betBooster = 1;// Multiplier for the bet amount

		// Check if user is under 18
		if (age < 18) {
			JOptionPane.showMessageDialog(null, " Sorry, you are under 18 ");

			return;
		}

		// Get user name and welcome message
		userName = JOptionPane.showInputDialog(" Please enter your name ");
		JOptionPane.showMessageDialog(null, " Hello " + userName + " \n Welcome to Under/Over game ");

		// Ask user if they want to start the game
		userAnswer = JOptionPane.showConfirmDialog(null, " Do you want to start the game? " + "\n" + userName);

		// If user wants to start the game, show initial game rounds and credit
		if (userAnswer == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, " That's great! \n You have 5 rounds and £3 in your account! ");

		} else if (userAnswer == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, " Great!, see you next time ");

		}

		// Ask user if they want to double their bet
		betDouble = JOptionPane.showConfirmDialog(null, " Do you want to double up your bets?", " Double Bet ",
				JOptionPane.YES_NO_OPTION);

		// If user wants to double their bet, increase betBooster to 2
		if (betDouble == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, " Great! We have increased your bet to £2 ");
			betBooster = betBooster * 2;
		}

		// If user does not want to double their bet, keep betBooster as 1
		else if (betDouble == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, " No worries, you play £1 ");
			betBooster = 1;

		}

		// Create a new object to keep track of bets
		BetStatistics betStatics = new BetStatistics();

		// Loop for each round of the game
		for (int i = 1; i <= rounds; i++) {
			money -= betAmount * betBooster;

			// If user has no money left, end the game
			if (money <= 0) {
				JOptionPane.showMessageDialog(null, " Sorry you have not enough credit left to play ");

				break;
			}

			// Show the current round and remaining money
			JOptionPane.showMessageDialog(null,
					" Round " + (i) + " of " + rounds + ". You have " + money + " pounds left ");

			// Get user's bet
			userBet = -1;
			while(userBet == -1){
				userBet = showMessage();
			}

			JOptionPane.showMessageDialog(null, " Let's roll the dice ");

			// Generate a random number
			int randNumber = random();
			JOptionPane.showMessageDialog(null, randNumber);

			// Check the result of the bet
			int moneyPrice = checkBet(userBet, randNumber);

			// If the user wins, add the winnings to the money
			if (moneyPrice > 0) {
				money += moneyPrice * betBooster;
				betResult = " Win ";
				JOptionPane.showMessageDialog(null, " You WIN ");
			} else {
				betResult = " Lost ";
				JOptionPane.showMessageDialog(null, " You have LOST ");

			}

			// Convert the user's bet to a string
			String userBetString = Integer.toString(userBet);

			// Create a new BetPlay object to keep track of this bet
			BetPlay bet = new BetPlay(userName, money, userBetString, betResult, i, randNumber);
			betStatics.addBet(bet);

		}
		// To avoid showing negative credit
		if(money < 0){money = 0;

		}

		JOptionPane.showMessageDialog(null, " Game over! You have " + money + " pounds and no goes left ");
		JOptionPane.showMessageDialog(null, betStatics.fullSummary());
	}

	// Method to check the result of a bet
	public int checkBet(int userBet, int randNumber) {
		if (userBet == 1) {
			JOptionPane.showMessageDialog(null, " You played Under Seven ");

			if (randNumber < 7) {
				return 2;
			}

			return 0;
		}

		if (userBet == 2) {
			JOptionPane.showMessageDialog(null, " You play Seven ");

			if (randNumber == 7) {
				return 5;
			}

			return 0;
		}

		if (userBet == 3) {
			JOptionPane.showMessageDialog(null, " You play Over Seven");

			if (randNumber > 7) {
				return 2;
			}

			return 0;
		}

		return 0;
	}

	// Method to validate the user's age
	public int requireAgeValidated() {
		int age = 0;
		String userAge;
		do {
			userAge = JOptionPane.showInputDialog("Please enter your age");
			try {
				age = Integer.parseInt(userAge);
				return age;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please only numbers allowed! Please enter your age again");
			}
			requireAgeValidated();
		} while (age < 0 || userAge == null);

		return age;
	}

	// Method to generate a random number
	private int random() {
		Random random = new Random();

		// Generate a random number between 2 -12 both inclusive
		return random.nextInt(11) + 2;
	}

	// Method to display the betting options to the user and return the user's
	// choice
	private int showMessage() {

		// Create a string to display the betting options
		String text = "Your options: \n";
		text += "1- Under Seven \n ";
		text += "2- Seven \n ";
		text += "3- Over Seven \n ";

		// Display the betting options to the user and return their choice as an
		// integer
		// Declare a variable to store the user's bet
		int userBetInput = -1;

		// Declare a boolean to check if the input is valid
		boolean inputAccepted = false;

		// Keep asking for input until user enters a valid option
		while(!inputAccepted) {
			try {
				// Get the user's input
				userBetInput = Integer.parseInt(JOptionPane.showInputDialog(text));

				// Check if the input is a valid option
				if (userBetInput < 1 || userBetInput > 3) {
					// If the input is not a valid option, display an error message
					JOptionPane.showMessageDialog(null, "Invalid option. Please enter a number between 1 and 3.");
				} else {
					// If the input is a valid option, set inputAccepted to true
					inputAccepted = true;
				}
			} catch(NumberFormatException e) {
				// If the input is not a valid integer, display an error message
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
			}
		}
		try{
			return Integer.parseInt(text);
		}catch(NumberFormatException e) {
			return userBetInput;
		}
	}
}
