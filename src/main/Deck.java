/*
 * File: Deck.java
 * Author: Levon Alexanian
 * Create Date: May 9, 2025
 * Last Edit Date: May 9, 2025
 * Description: A deck class for a card game.
 */

import java.util.ArrayList;

/**
 * Represents a deck of playing cards.
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * Constructs a new Deck with the specified initial cards.
     * @param initialCards Array of cards to initialize the deck with
     */
    public Deck(Card[] initialCards) {
        cards = new ArrayList<>();
        if (initialCards != null) {
            for (Card card : initialCards) {
                if (card != null) {
                    cards.add(card);
                }
            }
        }
    }

    /**
     * Constructs a new Deck with a standard set of 52 playing cards.
     * Cards are ordered by suit (Hearts, Clubs, Diamonds, Spades) and then by value.
     */
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                cards.add(new Card(names[i], suit, i + 1));
            }
        }
    }

    /**
     * Gets the number of cards in the deck.
     * @return The size of the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Draws a card from the top of the deck.
     * @return The drawn card, or null if the deck is empty
     */
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    /**
     * Shuffles the deck by randomly reordering the cards.
     */
    public void shuffle() {
        // Simple shuffle implementation without Collections
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * Adds a card to the deck.
     * @param card The card to add
     */
    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    /**
     * Adds all cards from the provided array to the deck and shuffles it.
     * @param cards Array of cards to add to the deck
     */
    public void reshuffle(Card[] cards) {
        if (cards != null) {
            for (Card card : cards) {
                if (card != null) {
                    this.cards.add(card);
                }
            }
            shuffle();
        }
    }
} 