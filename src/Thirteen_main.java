/**
 * Thirteen_main.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class represents the main entry point for the Thirteen card game. It includes methods to:
 * - Initialize and manage the main game flow
 * - Create decks of cards for the player and the bot
 * - Track points scored by the player and the bot
 * 
 * Static Variables:
 * - youPoint: Keeps track of the player's points
 * - botPoint: Keeps track of the bot's points
 * 
 * Methods:
 * - Thirteen_main(int value, String name, String suit): 
 *   Constructor to initialize card details with a specific value, name, and suit.
 * 
 * - bot(): 
 *   Creates and returns a deck of 13 cards for the bot, then displays the deck.
 * 
 * - you(): 
 *   Creates and returns a deck of 13 cards for the player, then displays the deck.
 * 
 * - main(String[] args): 
 *   The main function that starts the game, displays the menu, and handles exiting the game based on user input.
 * 
 * Usage:
 * - Use bot() to create and display a deck for the bot.
 * - Use you() to create and display a deck for the player.
 * - Use the main() method to start the game and handle menu navigation.
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

import java.io.IOException;
import java.util.ArrayList;


public class Thirteen_main {
	// Static variables to keep track of points
	static int youPoint = 0;
	static int botPoint = 0;

	// Attributes for card details
	int value;
	String name;
	String suit;

	// Constructor to initialize card details
	Thirteen_main(int value, String name, String suit) {
		this.value = value;
		this.name = name;
		this.suit = suit;
	}

	// Create a deck of 13 cards for the bot
	static ArrayList<Card> bot() {
		ArrayList<Card> hands = Card.beginDeck();
		Card.displayDeck(hands);
		return hands;
	}

	// Create a deck of 13 cards for the player
	static ArrayList<Card> you() {
		ArrayList<Card> hand = Card.beginDeck();
		Card.displayDeck(hand);
		return hand;
	}

	// Main function
	public static void main(String[] args) throws IOException {
		while (true) {
			Message.displayMenu();

			if (Message.run == 0) {
				break; // Exit the game if the user chooses the "Exit" option
			}
		}
	}

}