/**
 * Message.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class provides methods for displaying various messages and menus to the user. It includes functionality to:
 * - Display the main menu and handle user input for navigating the game options
 * - Show tutorials explaining the game rules and valid plays
 * - Display the leaderboard showing the scores of the player and the bot
 * 
 * Methods:
 * - displayMenu(): 
 *   Shows the main menu and handles user input for selecting game options.
 *   - Options include starting the game, viewing tutorials, displaying the leaderboard, and exiting the game.
 * 
 * - tutorial(): 
 *   Displays a step-by-step tutorial explaining the game rules, card ranking, setup, valid plays, and gameplay mechanics.
 * 
 * - displayLeaderboard(): 
 *   Displays the current scores of the player and the bot.
 * 
 * Usage:
 * - Use displayMenu() to present the main menu and navigate through the game options.
 * - Use tutorial() to provide players with a comprehensive guide on how to play the game.
 * - Use displayLeaderboard() to show the current scores and track progress.
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

 import java.util.Scanner;


 public class Message {
	 static Scanner cin = new Scanner(System.in); // Initialize the scanner
	 static int run;
 
	 // This method displays the main menu and handles user input for navigating the game options
	 public static int displayMenu() {
		 GamePlay.clear_sleep();
		 System.out.println(ANSIColors.GRN_BG +
			 "Welcome to the Thirteen Card Game!" + ANSIColors.RESET);
		 System.out.println(ANSIColors.CYN_B + "╔═══════════════════════╗");
		 System.out.println("║        Main Menu      ║");
		 System.out.println("╚═══════════════════════╝" + ANSIColors.RESET);
		 System.out.println("1. Start Game");
		 System.out.println("2. Tutorials");
		 System.out.println("3. Leaderboard");
		 System.out.println("4. Exit");
		 System.out.print("Enter your choice: ");
		 int choice = cin.nextInt();
		 cin.nextLine(); // Take user input
		 switch (choice) {
			 case 1:
				 GameFunction.playGame();
				 displayMenu();
				 break;
			 case 2:
				 tutorial();
				 displayMenu();
				 break;
			 case 3:
				 displayLeaderboard();
				 displayMenu();
				 break;
			 case 4:
				 System.out.println("Thanks for playing our game!");
				 break;
			 default:
				 System.out.println("Invalid choice. Please try again.");
				 displayMenu();
		 }
 
		 return run = 0;
	 }
 
	 // This method displays a step-by-step tutorial explaining the game rules, card ranking, setup, valid plays, and gameplay mechanics
	 private static void tutorial() {
		 @SuppressWarnings("resource") Scanner scanner = new Scanner(System.in);
 
		 System.out.println(
			 ANSIColors.WHT_BR +
			 "Thirteen is a strategic card game played with a standard 52-card deck and four players. The objective is to be the first player to get rid of all cards in their hand.");
		 scanner.nextLine();
 
		 System.out.println(ANSIColors.CYN_B + "\n## Card Ranking");
		 System.out.println(
			 ANSIColors.RESET +
			 "2 is the highest rank, followed by Ace, King, Queen, Jack, 10, 9, 8, 7, 6, 5, 4, 3.");
		 System.out.println(
			 "Suit ranking from highest to lowest: Hearts, Diamonds, Clubs, Spades.");
		 scanner.nextLine();
 
		 System.out.println(ANSIColors.CYN_B + "\n## Setup");
		 System.out.println(ANSIColors.RESET +
			 "Each player is dealt 13 cards, one at a time.");
		 System.out.println(
			 "The player with the 3 of spades leads the first round and must include it in their opening play.");
		 scanner.nextLine();
 
		 System.out.println(ANSIColors.CYN_B + "\n## Valid Plays");
		 System.out.println(ANSIColors.RESET +
			 "Cards can be played in the following combinations:");
		 System.out.println("- Single card");
		 System.out.println("- Pair (two of the same rank)");
		 System.out.println("- Three-of-a-kind");
		 System.out.println("- Four-of-a-kind");
		 System.out.println(
			 "- Sequence of 3 or more cards in ascending rank (suits don't matter)");
		 System.out.println(
			 "- Double sequence (two identical sequences played together)");
		 scanner.nextLine();
 
		 System.out.println(ANSIColors.CYN_B + "\n## Gameplay");
		 System.out.println(ANSIColors.RESET + "Play moves clockwise.");
		 System.out.println(
			 "Each player must match the previous combination and play a higher-ranking one.");
		 System.out.println(
			 "If unable to play, the player must pass and cannot play again until the pile is cleared.");
		 System.out.println(
			 "Once all players consecutively pass, the player who played the last combination clears the pile and leads the next round.");
		 System.out.println(
			 "Four-of-a-kind and double sequences are \"bombs\" that clear the pile when played. The player who played the bomb leads the next round.");
		 scanner.nextLine();
	 }
 
	 // This method displays the current scores of the player and the bot
	 private static void displayLeaderboard() {
		 System.out.println(ANSIColors.PUR_B + "\n## Leaderboard ##" +
			 ANSIColors.RESET);
		 System.out.println("You: " + Thirteen_main.youPoint);
		 System.out.println("Bot: " + Thirteen_main.botPoint);
		 // Add more players if needed
	 }
 
 }