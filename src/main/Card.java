/*
 * File: Card.java
 * Author: Levon Alexanian
 * Create Date: May 9, 2025
 * Last Edit Date: May 9, 2025
 * Description: A card class for a card game.
 */


/**
 * Represents a playing card with a name, suit, and value.
 */
public class Card {
    private String name;
    private String suit;
    private int value;

    /**
     * Constructs a new Card with the specified name, suit, and value.
     * @param name The name of the card (e.g., "Ace", "King", "2")
     * @param suit The suit of the card (e.g., "Hearts", "Spades")
     * @param value The numerical value of the card
     */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Gets the name of the card.
     * @return The card's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the suit of the card.
     * @return The card's suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Gets the value of the card.
     * @return The card's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card.
     * @return The card in the format "name of suit"
     */
    @Override
    public String toString() {
        return name + " of " + suit;
    }

    /**
     * Compares this card with another object for equality.
     * @param obj The object to compare with
     * @return true if the cards have the same name, suit, and value
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value == card.value &&
               name.equals(card.name) &&
               suit.equals(card.suit);
    }
} 