//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.Assert.*;
import org.junit.Test;

public class ProblemSetTest {
    @Test
    public void testCardCreation() {
        Card card = new Card("Ace", "Spades", 1);
        assertEquals("Ace", card.getName());
        assertEquals("Spades", card.getSuit());
        assertEquals(1, card.getValue());
    }

    @Test
    public void testCardToString() {
        Card card = new Card("King", "Hearts", 13);
        assertEquals("King of Hearts", card.toString());
    }

    @Test
    public void testCardEquality() {
        Card card1 = new Card("Queen", "Diamonds", 12);
        Card card2 = new Card("Queen", "Diamonds", 12);
        Card card3 = new Card("Queen", "Clubs", 12);
        assertTrue(card1.equals(card2));
        assertFalse(card1.equals(card3));
    }

    @Test
    public void testNullCard() {
        Card nullCard = new Card(null, null, 0);
        assertEquals("null of null", nullCard.toString());
    }

    // Deck Tests
    @Test
    public void testEmptyDeck() {
        Deck deck = new Deck(new Card[0]);
        assertEquals(0, deck.size());
        assertNull(deck.draw());
    }

    @Test
    public void testDeckWithCards() {
        Card[] cards = {
            new Card("Ace", "Spades", 1),
            new Card("King", "Hearts", 13)
        };
        Deck deck = new Deck(cards);
        assertEquals(2, deck.size());
        assertEquals(cards[0], deck.draw());
    }

    @Test
    public void testDefaultDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.size());
        Card firstCard = deck.draw();
        assertEquals("Ace", firstCard.getName());
        assertEquals("Hearts", firstCard.getSuit());
    }

    @Test
    public void testDeckShuffle() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck2.shuffle();
        
        boolean different = false;
        for (int i = 0; i < 52; i++) {
            if (!deck1.draw().equals(deck2.draw())) {
                different = true;
                break;
            }
        }
        assertTrue("Deck should be shuffled", different);
    }

    // DiscardPile Tests
    @Test
    public void testEmptyDiscardPile() {
        DiscardPile pile = new DiscardPile();
        assertEquals(0, pile.size());
        assertEquals("", pile.toString());
    }

    @Test
    public void testDiscardPileWithCards() {
        Card[] cards = {
            new Card("Ace", "Spades", 1),
            new Card("King", "Hearts", 13)
        };
        DiscardPile pile = new DiscardPile(cards);
        assertEquals(2, pile.size());
        assertEquals("Ace of Spades, King of Hearts", pile.toString());
    }

    @Test
    public void testRemoveCard() {
        Card card = new Card("Queen", "Diamonds", 12);
        DiscardPile pile = new DiscardPile();
        pile.addCard(card);
        assertEquals(card, pile.removeCard(card));
        assertEquals(0, pile.size());
    }

    @Test
    public void testRemoveAll() {
        Card[] cards = {
            new Card("Ace", "Spades", 1),
            new Card("King", "Hearts", 13)
        };
        DiscardPile pile = new DiscardPile(cards);
        Card[] removed = pile.removeAll();
        assertEquals(2, removed.length);
        assertEquals(0, pile.size());
    }

    // Player Tests
    @Test
    public void testPlayerCreation() {
        Player player = new Player("John", 25);
        assertEquals("John", player.getName());
        assertEquals(25, player.getAge());
        assertEquals(0, player.size());
    }

    @Test
    public void testPlayerWithHand() {
        Card[] cards = {
            new Card("Ace", "Spades", 1),
            new Card("King", "Hearts", 13)
        };
        Player player = new Player("John", 25, cards);
        assertEquals(2, player.size());
        assertArrayEquals(cards, player.getHand());
    }

    @Test
    public void testPlayerDraw() {
        Player player = new Player("John", 25);
        Deck deck = new Deck();
        player.draw(deck);
        assertEquals(1, player.size());
        assertEquals("Ace of Hearts", player.getHand()[0].toString());
    }

    @Test
    public void testPlayerDiscard() {
        Player player = new Player("John", 25);
        Deck deck = new Deck();
        DiscardPile pile = new DiscardPile();
        player.draw(deck);
        Card card = player.getHand()[0];
        assertTrue(player.discardCard(card, pile));
        assertEquals(0, player.size());
        assertEquals(1, pile.size());
    }

    @Test
    public void testPlayerReturnCard() {
        Player player = new Player("John", 25);
        Deck deck = new Deck();
        player.draw(deck);
        Card card = player.getHand()[0];
        assertTrue(player.returnCard(card, deck));
        assertEquals(0, player.size());
        assertEquals(52, deck.size());
    }

    @Test
    public void testPlayerToString() {
        Card[] cards = {
            new Card("Ace", "Spades", 1),
            new Card("King", "Hearts", 13)
        };
        Player player = new Player("John", 25, cards);
        assertEquals("John, 25, Ace of Spades, King of Hearts", player.toString());
    }
}
