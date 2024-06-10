/**
 * GameFunction.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class provides essential game functions for a card game. It includes functionality to:
 * - Determine the best play for a player based on the cards in hand
 * - Group cards by their value for easier analysis
 * - Handle the main game logic including dealing cards, alternating turns, and determining the winner
 * 
 * Methods:
 * - findBestPlay(ArrayList<Card> hand): 
 *   Analyzes the player's hand to find the best possible play.
 *   - Checks for single cards, pairs, three-of-a-kind, and four-of-a-kind
 *   - Identifies valid sequences of cards
 *   - Randomly selects and returns a valid play if found
 * 
 * - groupCardsByValue(ArrayList<Card> hand): 
 *   Groups cards in the hand by their value to facilitate analysis.
 *   - Returns a map with card values as keys and lists of cards as values
 * 
 * - playGame(): 
 *   Manages the main game logic.
 *   - Deals 13 cards to the player and the bot
 *   - Alternates turns between player and bot
 *   - Determines and announces the winner
 * 
 * Usage:
 * - Use findBestPlay() to identify the best play from a given hand of cards.
 * - Use playGame() to initiate and manage the game flow, from dealing cards to determining the winner.
 * - Use groupCardsByValue() internally within other methods for organizing cards by their value.
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GameFunction {
	// Function to find the best play for the player
	public static ArrayList<Card> findBestPlay(ArrayList<Card> hand) {
		ArrayList < ArrayList<Card>> validPlays = new ArrayList<>();

		// Check for single cards
		for (Card card: hand) {
			ArrayList<Card> singleCard = new ArrayList<>();
			singleCard.add(card);

			if (ValidPlay.isValidPlay(singleCard)) {
				validPlays.add(singleCard);
			}
		}

		// Check for pairs, three-of-a-kind, and four-of-a-kind
		Map < Integer, ArrayList<Card>> groupedCards = groupCardsByValue(hand);

		for (ArrayList<Card> group: groupedCards.values()) {
			if (group.size() >= 2 && ValidPlay.isValidPlay(group)) {
				validPlays.add(group);
			}
		}

		// Check for sequences
		ArrayList<Card> sortedHand = new ArrayList<>(hand);
		Collections.sort(sortedHand, (c1, c2) -> Integer.compare(c1.getCardValue(), c2.getCardValue()));

		for (int i = 0; i < sortedHand.size() - 2; i++) {
			for (int j = i + 2; j < sortedHand.size(); j++) {
				if (sortedHand.get(j).getCardValue() - sortedHand.get(i).getCardValue() == j - i) {
					ArrayList<Card> sequence = new ArrayList<>(sortedHand.subList(i, j + 1));

					if (ValidPlay.isValidPlay(sequence)) {
						validPlays.add(sequence);
					}
				}
			}
		}

		// If no valid plays found, return an empty list
		if (validPlays.isEmpty()) {
			return new ArrayList<>();
		}

		// Randomly select a valid play
		Collections.shuffle(validPlays);
		return validPlays.get(0);
	}

	// Helper function to group cards by their value
	private static Map < Integer, ArrayList<Card>> groupCardsByValue(ArrayList<Card> hand) {
		Map < Integer, ArrayList<Card>> groupedCards = new HashMap<>();

		for (Card card: hand) {
			int value = card.getCardValue();

			if (!groupedCards.containsKey(value)) {
				groupedCards.put(value, new ArrayList<>());
			}

			groupedCards.get(value).add(card);
		}

		return groupedCards;
	}

	// Function to handle game logic
	public static void playGame() {
		ArrayList<Card> deck = Card.createDeck();
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> botHand = new ArrayList<>();

		// Deal cards to player and bot
		for (int i = 0; i < 13; i++) {
			playerHand.add(deck.remove(0));
			botHand.add(deck.remove(0));
		}

		// Play the game
		boolean playerTurn = true;

		while (!playerHand.isEmpty() && !botHand.isEmpty()) {
			if (playerTurn) {
				GamePlay.playTurn(playerHand, botHand);
				playerTurn = false;

				if (GamePlay.lastPlay == 1) {
					playerTurn = true;
				}

				if (GamePlay.lastPlay == 0) {
					GamePlay.playTurn(playerHand, botHand);
				}
			} else {
				// Implement bot's logic here
				playerTurn = true;
			}
		}

		// Determine the winner
		if (playerHand.isEmpty()) {
			Thirteen_main.youPoint++;
			System.out.println("You win!");
		} else {
			Thirteen_main.botPoint++;
			System.out.println("Bot wins!");
		}

		GamePlay.pile.clear();
	}
}