/**
 * ValidPlay.java
 * 
 * Author: Howard Tran
 * Date: June 09 2024
 * 
 * Description: 
 * This class contains a method to determine if a given ArrayList of cards represents a valid play in a card game.
 * A valid play can be a single card, a pair, three-of-a-kind, four-of-a-kind, or a sequence of consecutive cards.
 * 
 * Copyright @2024 Howard Tran. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ValidPlay {
    public static boolean isValidPlay(ArrayList<Card> play) {
        if (play.size() == 1) {
            // Single card is always valid
            return true;
        }

        // Check for pair, three-of-a-kind, and four-of-a-kind
        Map<Integer, Integer> cardCounts = new HashMap<>();
        for (Card card : play) {
            int value = card.getCardValue();
            cardCounts.put(value, cardCounts.getOrDefault(value, 0) + 1);
        }

        if (cardCounts.size() == 1) {
            int count = cardCounts.values().iterator().next();
            return count == 2 || count == 3 || count == 4; // Pair, three-of-a-kind, or four-of-a-kind
        }

        // Check for sequence
        ArrayList<Integer> values = new ArrayList<>();
        for (Card card : play) {
            values.add(card.getCardValue());
        }
        Collections.sort(values);

        int prevValue = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            int currentValue = values.get(i);
            if (currentValue != prevValue + 1) {
                return false; // Not a sequence
            }
            prevValue = currentValue;
        }

        return true; // Valid sequence
    }
}