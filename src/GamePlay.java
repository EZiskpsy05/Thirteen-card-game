/**
 * GamePlay.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class handles the gameplay mechanics for a card game. It includes methods to:
 * - Manage the turn-based gameplay between a player and a bot
 * - Clear the console and introduce delays for better user experience
 * - Validate and process player's and bot's plays
 * - Determine if all players have passed and handle the pile clearing
 * - Format and display cards for readability
 * 
 * Usage:
 * - Use playTurn() to handle the player's turn, including card selection and play validation.
 * - Use botLogic() to manage the bot's turn and ensure valid plays.
 * - Use clear_sleep() to clear the console and add delays for smoother gameplay.
 * - Use formatCollection() to format card collections for display.
 * - Use displayHand() to show the player's hand with indices.
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class GamePlay {
   static ArrayList < Card > pile = new ArrayList < > ();
 
   private static ArrayList < Card > currentPlay = new ArrayList < > ();
   static boolean allPassed = false;
 
   public static int lastPlay = 2;
   /*  Set up lastplay, if the bot can't play and user can, user keep playing
	   If the user pass and last play is user, user keep playing*/
 
   // Method for clear console and delay
   public static void clear_sleep() {
	 try {
	   Thread.sleep(1000);
	 } catch (InterruptedException e) {
	   Thread.currentThread().interrupt();
	 }
 
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
   }
   // Method to determine player's turn
   @SuppressWarnings("resource")
   public static void playTurn(ArrayList < Card > playerHand,
	 ArrayList < Card > botHand) {
	 Scanner scanner = new Scanner(System.in);
	 clear_sleep();
	 displayHand(playerHand);
	 System.out.println("Current pile: " + formatCollection(pile));
 
	 // Player's turn
	 System.out.print(
	   "Enter the indices of the cards you want to play (e.g., 0 1 2), or 'pass' to pass: ");
	 try {
 
	   String input = scanner.nextLine();
 
	   if (input.equalsIgnoreCase("pass")) {
		 System.out.println("You passed.");
		 allPassed = true;
	   } else {
		 String[] indices = input.split(" "); // Split space
		 for (String index: indices) {
		   int cardIndex = Integer.parseInt(index); // parse each input to cardIndex
 
		   if (cardIndex >= 0 && cardIndex < playerHand.size()) { // Check if input is in valid range
			 currentPlay.add(playerHand.get(cardIndex)); // Add the card to the pile
		   } else {
			 System.out.println("Invalid card index: " + cardIndex);
		   }
		 }
 
		 // Check if the current play is valid according to game rules
		 if (ValidPlay.isValidPlay(currentPlay)) {
		   // If the pile is empty or the current play ranks higher than the top card of the pile,
		   // proceed with the play
		   if (pile.isEmpty() || ComparePlay.isHigherRanking(currentPlay, pile)) {
			 // Remove all cards from the current play from the player's hand
			 for (Card card: currentPlay) {
			   playerHand.remove(card);
			 }
 
			 // Clear the pile and add all cards from the current play to it
			 pile.clear();
			 pile.addAll(currentPlay);
 
			 // Clear the current play
			 currentPlay.clear();
 
			 // Reset the flag indicating if all players have passed
			 allPassed = false;
 
			 // Log a message indicating a valid play was made
			 System.out.println("Valid play!");
 
			 // Update the last play indicator
			 lastPlay = 1;
		   } else {
			 // If the current play does not rank higher than the top card of the pile, log an error message
			 System.out.println("Your play must be higher than the current pile.");
 
			 // Clear the current play since it doesn't meet the criteria
			 currentPlay.clear();
		   }
		 } else {
		   // If the current play is not valid according to game rules, log an error message
		   System.out.println("Invalid play!");
 
		   // Clear the current play since it's not valid
		   currentPlay.clear();
		 }
 
	   }
 
	   // Bot's turn
	   if (allPassed) {
		 System.out.println("All players passed. Clearing the pile.");
		 pile.clear();
		 allPassed = false;
 
		 if (lastPlay == 0) {
		   botLogic(playerHand, botHand);
		 }
	   } else {
		 // Implement bot's logic here
		 botLogic(playerHand, botHand);
	   }
	 } catch (Exception e) { // If String is null
	   System.out.println("That's the wrong input");
	 }
   }
 
   public static void botLogic(ArrayList < Card > playerHand,
	 ArrayList < Card > botHand) {
	 // Bot's turn
	 if (allPassed) {
	   System.out.println("All players passed. Clearing the pile.");
	   pile.clear();
	   allPassed = false;
	 } else {
 
	   // Implement bot's logic here
	   System.out.println("Bot's turn...");
	   ArrayList < Card > botPlay = GameFunction.findBestPlay(botHand);
 
	   if (botPlay.isEmpty()) {
		 System.out.println("Bot passed.");
		 allPassed = true;
	   } else {
		 if (pile.isEmpty() || ComparePlay.isHigherRanking(botPlay, pile)) {
		   for (Card card: botPlay) {
			 botHand.remove(card);
		   }
 
		   pile.clear();
		   pile.addAll(botPlay);
		   allPassed = false;
		   System.out.println("Bot played: " + formatCollection(botPlay));
		   lastPlay = 0;
		 } else {
		   System.out.println("Bot cannot play a higher combination.");
		   // The user play next if the last play was the user and the bot can't play
		   if (lastPlay == 1) {
			 playTurn(playerHand, botHand);
		   }
		 }
	   }
	 }
   }
 
   private static String formatCollection(ArrayList < Card > collection) {
	 StringBuilder sb = new StringBuilder();
	 sb.append("[");
 
	 for (int i = 0; i < collection.size(); i++) {
	   sb.append(collection.get(i).toString());
 
	   if (i < collection.size() - 1) {
		 sb.append(", ");
	   }
	 }
 
	 sb.append("]");
	 return sb.toString();
   }
 
   private static void displayHand(ArrayList < Card > hand) {
	 System.out.println("Your hand:");
 
	 for (int i = 0; i < hand.size(); i++) {
	   Card card = hand.get(i);
	   System.out.println(i + ": " + card.toString());
	 }
   }
 }