package CardTrickTest;

import CardTrick.Deck;
import CardTrick.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static junit.framework.TestCase.assertEquals;


public class DeckTest {

    Deck testTokenDeck;
    Deck testStandardDeck;
    @Before
    public void setUp() {
        int numberOfTokens = 100;
        testTokenDeck = new Deck(numberOfTokens);
        testStandardDeck = new Deck();
    }

    /** populateTokens() TESTS */
    @Test
    public void testPopulateTokensAllTokensUnique() {
        Set<Token> tokens = new HashSet<>(testTokenDeck.getTokens());
        assertEquals("All token values must be unique", 100, testTokenDeck.getDeckSize());
    }

    @Test
    public void testPopulateTokensCorrectFirstMember() {
        Token firstToken = testTokenDeck.getTokens().get(0);
        assertEquals("First token must have a value of 1", "1", firstToken.getValue());
    }

    @Test
    public void testPopulateTokensCorrectLastMember() {
        Token lastToken = testTokenDeck.getTokens().get(99);
        assertEquals("Last token must have a value of 100", "100", lastToken.getValue());
    }

    /** populateStandardCards() TESTS */
    @Test
    public void testPopulateStandardCardsCorrectDeckSize() {
        assertEquals("Standard Playing Card Decks must contain 52 cards", 52, testStandardDeck.getDeckSize());
    }

    @Test
    public void testPopulateStandardCardsAllCardsUnique() {
        Set<Token> testCards = new HashSet<>(testStandardDeck.getTokens());
        assertEquals("Number of unique cards in deck must be 52", 52, testCards.size());
    }

    /** dealTokens() TESTS */
    @Test
    public void testDealTokensConfirmRemoveTokens() {
        ArrayList<Token> tokens = new ArrayList<Token>();
        Token a = new Token();
        Token b = new Token();
        Token c = new Token();
        Token d = new Token();
        tokens.add(a); tokens.add(b); tokens.add(c); tokens.add(d);

        testTokenDeck.dealTokens(tokens, 3);
        assertEquals("dealTokens must remove elements from original list", 1, tokens.size());
    }

    @Test
    public void testDealTokensReturnsCorrectTokens() {
        ArrayList<Token> tokens = new ArrayList<Token>();
        Token a = new Token();
        Token b = new Token();
        Token c = new Token();
        Token d = new Token();
        tokens.add(a); tokens.add(b); tokens.add(c); tokens.add(d);

        assertEquals("dealTokens must return 3 Token objects", 3, testTokenDeck.dealTokens(tokens, 3).size());
    }

    /** insertTokens() TESTS */
    @Test
    public void testInsertTokensCorrectPositions() {
        ArrayList<Integer> testPositions = new ArrayList<Integer>();
        ArrayList<Token> testTokens = new ArrayList<Token>();

        int pos1 = 5; int pos2 = 21; int pos3 = 37;
        testPositions.add(pos1); testPositions.add(pos2); testPositions.add(pos3);

        Token token1 = new Token("test1"); Token token2 = new Token("test2"); Token token3 = new Token("test3");
        testTokens.add(token1); testTokens.add(token2); testTokens.add(token3);

        testTokenDeck.insertTokens(testTokens, testPositions);

        assertEquals("The Token array 'testTokenDeck.tokens' should contain a test value at index 5", "test1", testTokenDeck.getTokens().get(5).getValue());
        assertEquals("The Token array 'testTokenDeck.tokens' should contain a test value at index 21", "test2", testTokenDeck.getTokens().get(21).getValue());
        assertEquals("The Token array 'testTokenDeck.tokens' should contain a test value at index 37", "test3", testTokenDeck.getTokens().get(37).getValue());

    }

    @After
    public void tearDown() {
        testTokenDeck = null;
        testStandardDeck = null;
    }
}