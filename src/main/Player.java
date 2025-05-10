/*
 * File: Player.java
 * Author: Levon Alexanian
 * Create Date: May 9, 2025
 * Last Edit Date: May 9, 2025
 * Description: A player class for a card game.
 */

import java.util.ArrayList;

/**
*Represents a player in a card game with a name, age, and hand of cards.
*/ 
public class Player {
    private String name;
    private int age;
    private ArrayList<Card> hand;

    /**
     * Constructs a new Player with the specified name, age, and initial hand.
     * @param name The player's name
     * @param age The player's age
     * @param initialHand Array of cards to initialize the player's hand with
     */
    public Player(String name, int age, Card[] initialHand) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
        if (initialHand != null) {
            for (Card card : initialHand) {
                if (card != null) {
                    hand.add(card);
                }
            }
        }
    }

    /**
     * Constructs a new Player with the specified name and age, and an empty hand.
     * @param name The player's name
     * @param age The player's age
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    /**
     * Gets the player's name.
     * @return The player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's age.
     * @return The player's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets all cards in the player's hand.
     * @return Array of cards in the player's hand
     */
    public Card[] getHand() {
        Card[] handArray = new Card[hand.size()];
        for (int i = 0; i < hand.size(); i++) {
            handArray[i] = hand.get(i);
        }
        return handArray;
    }

    /**
     * Gets the number of cards in the player's hand.
     * @return The size of the player's hand
     */
    public int size() {
        return hand.size();
    }

    /**
     * Draws a card from the deck and adds it to the player's hand.
     * @param deck The deck to draw from
     */
    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    /**
     * Discards a card from the player's hand to the discard pile.
     * @param card The card to discard
     * @param discardPile The discard pile to add the card to
     * @return true if the card was successfully discarded, false otherwise
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (card != null && hand.contains(card)) {
            hand.remove(card);
            discardPile.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Returns a card from the player's hand to the deck.
     * @param card The card to return
     * @param deck The deck to add the card to
     * @return true if the card was successfully returned, false otherwise
     */
    public boolean returnCard(Card card, Deck deck) {
        if (card != null && hand.contains(card)) {
            hand.remove(card);
            deck.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the player.
     * @return The player's name, age, and hand of cards
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ").append(age);
        if (!hand.isEmpty()) {
            sb.append(", ");
            for (int i = 0; i < hand.size(); i++) {
                sb.append(hand.get(i).toString());
                if (i < hand.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
} 