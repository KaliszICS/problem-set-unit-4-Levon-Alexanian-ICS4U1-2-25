/*
 * File: DiscardPile.java
 * Author: Levon Alexanian
 * Create Date: May 9, 2025
 * Last Edit Date: May 9, 2025
 * Description: A discard pile class for a card game.
 */

import java.util.ArrayList;

/**
 * Represents a pile of discarded cards.
 */
public class DiscardPile {
    private ArrayList<Card> cards;

    /**
     * Constructs a new DiscardPile with the specified initial cards.
     * @param initialCards Array of cards to initialize the discard pile with
     */
    public DiscardPile(Card[] initialCards) {
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
     * Constructs an empty DiscardPile.
     */
    public DiscardPile() {
        cards = new ArrayList<>();
    }

    /**
     * Gets all cards in the discard pile.
     * @return Array of cards in the discard pile
     */
    public Card[] getDiscardPile() {
        Card[] handArray = new Card[cards.size()];
        for (int i = 0; i < cards.size(); i++) {
            handArray[i] = cards.get(i);
        }
        return handArray;
    }

    /**
     * Gets the number of cards in the discard pile.
     * @return The size of the discard pile
     */
    public int size() {
        return cards.size();
    }

    /**
     * Adds a card to the discard pile.
     * @param card The card to add
     */
    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    /**
     * Removes a specific card from the discard pile.
     * @param card The card to remove
     * @return The removed card, or null if the card wasn't found
     */
    public Card removeCard(Card card) {
        if (card != null && cards.contains(card)) {
            cards.remove(card);
            return card;
        }
        return null;
    }

    /**
     * Removes all cards from the discard pile.
     * @return Array of all removed cards
     */
    public Card[] removeAll() {
        Card[] removedCards = new Card[cards.size()];
        for (int i = 0; i < cards.size(); i++) {
            removedCards[i] = cards.get(i);
        }
        cards.clear();
        return removedCards;
    }

    /**
     * Returns a string representation of all cards in the discard pile.
     * @return Comma-separated list of cards
     */
    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "";
        }
        StringBuilder strbuild = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            strbuild.append(cards.get(i).toString());
            if (i < cards.size() - 1) {
                strbuild.append(", ");
            }
        }
        return strbuild.toString();
    }
} 