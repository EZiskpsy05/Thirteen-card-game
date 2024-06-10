/**
 * Card.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class represents a card in a deck of cards. Each card has a suit and a value.
 * The class provides methods to:
 * - Randomly assign a suit and value to a card
 * - Retrieve the card's suit, value, and name
 * - Create and shuffle a deck of cards
 * - Display the deck of cards
 * 
 * Constants:
 * - CARD_SUITS: Array of card suits (Spades, Clubs, Diamonds, Hearts) with ANSI color codes
 * - CARD_NAMES: Array of card names (3 through 2)
 * - CARD_VALUES: Array of card values (1 through 13)
 * 
 * Methods:
 * - setSuit(): Randomly assigns a suit to the card
 * - setCardNo(): Randomly assigns a value to the card
 * - getCardSuit(): Returns the card's suit
 * - getCardValue(): Returns the card's value
 * - getCardName(): Returns the card's name
 * - beginDeck(): Creates and shuffles a hand of 13 cards
 * - createDeck(): Creates and shuffles a deck of 1000 cards
 * - displayDeck(): Displays all cards in the deck
 * 
 * Usage:
 * - Use beginDeck() to create a standard hand of 13 cards.
 * - Use createDeck() to create a large deck of 1000 cards for testing or extended gameplay.
 * - Use displayDeck() to print out the cards in a deck.
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;


public class Card {

	private int cardNo;

	private String suit;

	private static final String[] CARD_SUITS = {
		ANSIColors.BLK_BR + "♠" + ANSIColors.RESET, ANSIColors.BLK_BR + "♣" + ANSIColors.RESET, ANSIColors.RED_BR + "♦" + ANSIColors.RESET, ANSIColors.RED_BR + "♥" + ANSIColors.RESET
	};

	private static final String[] CARD_NAMES = {
		"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
	};

	private static final int[] CARD_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	Card() {
		setSuit();
		setCardNo();
	}
	@Override

	public String toString() {
		return getCardName() + " of " + getCardSuit();
	}

	// Randomly determine the suit
	private void setSuit() {
		this.suit = CARD_SUITS[(int)(Math.random() * 4)];
	}

	// Randomly determine the card value
	private void setCardNo() {
		this.cardNo = (int)(Math.random() * 13);
	}

	public String getCardSuit() {
		return this.suit;
	}

	public int getCardValue() {
		return CARD_VALUES[this.cardNo];
	}

	public String getCardName() {
		return CARD_NAMES[this.cardNo];
	}

	// Method to create an ArrayList of cards
	public static ArrayList<Card> beginDeck() {
		ArrayList<Card> hand = new ArrayList<>();

		for (int i = 0; i < 13; i++) {
			Card card = new Card();
			hand.add(card);
		}

		Collections.shuffle(hand);
		return hand;
	}

	public static ArrayList<Card> createDeck() {
		ArrayList<Card> deck = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			Card card = new Card();
			deck.add(card);
		}

		Collections.shuffle(deck);
		return deck;
	}

	// Method to display all cards in the deck
	public static void displayDeck(ArrayList<Card> deck) {
		System.out.println("Cards in your hand:");

		for (Card card: deck) {
			System.out.println(card.getCardName() + " of " + card.getCardSuit());
		}
	}
}