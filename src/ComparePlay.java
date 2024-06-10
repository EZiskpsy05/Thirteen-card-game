/**
 * ComparePlay.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class provides methods to compare card plays in a card game. It includes functionality to:
 * - Determine if one play has a higher ranking than another
 * - Identify special plays known as "bombs"
 * - Retrieve the highest card value from a play
 * 
 * Methods:
 * - isHigherRanking(ArrayList<Card> currentPlay, ArrayList<Card> previousPlay): 
 *   Compares the current play to the previous play to determine if it has a higher ranking.
 *   - Plays must have the same number of cards to be comparable.
 *   - Single cards are compared by value.
 *   - Bombs (four-of-a-kind or double sequences) have special rules.
 *   - Non-bomb plays are compared by the highest card value.
 * 
 * - isBomb(ArrayList<Card> play): 
 *   Checks if a play is a bomb, which can be either four-of-a-kind or a sequence of six or more cards.
 * 
 * - getHighestValue(ArrayList<Card> play): 
 *   Retrieves the highest card value from a play.
 * 
 * Usage:
 * - Use isHigherRanking() to determine if a player's current play beats the previous play.
 * - Use isBomb() to identify special bomb plays.
 * - Use getHighestValue() to find the highest card in a given play.
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ComparePlay {

	public static boolean isHigherRanking(ArrayList<Card> currentPlay, ArrayList<Card> previousPlay) {
		if (currentPlay.size() != previousPlay.size()) {
			return false; // Plays must have the same number of cards
		}

		if (currentPlay.size() == 1) {
			// Compare single cards
			return currentPlay.get(0).getCardValue() > previousPlay.get(0).getCardValue();
		}

		// Check for four-of-a-kind and double sequence (bombs)
		if (isBomb(currentPlay) && !isBomb(previousPlay)) {
			return true; // Bomb beats any non-bomb play
		} else if (!isBomb(currentPlay) && isBomb(previousPlay)) {
			return false; // Non-bomb play cannot beat a bomb
		}

		// Compare values of the highest card in each play
		int currentHighestValue = getHighestValue(currentPlay);
		int previousHighestValue = getHighestValue(previousPlay);

		return currentHighestValue > previousHighestValue;
	}

	private static boolean isBomb(ArrayList<Card> play) {
		Map<Integer, Integer> cardCounts = new HashMap<>();

		for (Card card: play) {
			int value = card.getCardValue();
			cardCounts.put(value, cardCounts.getOrDefault(value, 0) + 1);
		}

		return cardCounts.size() == 1 && (cardCounts.values().iterator().next() == 4 || play.size() >= 6);
	}

	private static int getHighestValue(ArrayList<Card> play) {
		int highestValue = 0;

		for (Card card: play) {
			highestValue = Math.max(highestValue, card.getCardValue());
		}

		return highestValue;
	}
}