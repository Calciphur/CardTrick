package CardTrickTest;

import CardTrick.Deck;
import CardTrick.Player;
import CardTrick.ThreeRemain;
import CardTrick.Token;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

import java.util.*;

public class ThreeRemainTest {

    /** removeAllEvenElements() TESTS */
    @Test
    public void testOddNumSafePosRemoveAllEvenElementsKeepsCorrectSafeLocations() {
        ThreeRemain test52TokensGame = new ThreeRemain("token", 52);
        Deck testDeck = test52TokensGame.getCardDeck();
        test52TokensGame.removeAllEvenElements(testDeck, testDeck.getTokens(), 0);

        ArrayList<Integer> safePositions = new ArrayList<>(Arrays.asList(6, 22, 38));
        ArrayList<Integer> actual = new ArrayList<>();

        for (Token token : testDeck.getTokens()) {
            actual.add(Integer.parseInt(token.getValue()));
        }

        Collections.sort(actual);

        assertEquals("Deck size of 52 must return positions 6, 22, and 38", safePositions, actual);
    }

    @Test
    public void testEvenNumSafePosRemoveAllEvenElementsKeepsCorrectSafeLocations() {
        ThreeRemain test17TokensGame = new ThreeRemain("token", 17);
        Deck testDeck = test17TokensGame.getCardDeck();
        test17TokensGame.removeAllEvenElements(testDeck, testDeck.getTokens(), 0);

        ArrayList<Integer> safePositions = new ArrayList<>(Arrays.asList(6, 14));
        ArrayList<Integer> actual = new ArrayList<>();

        for (Token token : testDeck.getTokens()) {
            actual.add(Integer.parseInt(token.getValue()));
        }

        Collections.sort(actual);

        assertEquals("Deck size of 52 must return positions 6, 22, and 38", safePositions, actual);
    }

    /** buildHand() TESTS */
    @Test
    public void testBuildHandCorrectSize() {
        ThreeRemain testGame = new ThreeRemain("token", 5);
        int numCards = 3;
        Player p = new Player();

        assertEquals("Player's hand should initially be empty", 0, p.getHand().size());

        testGame.buildHand(p, numCards);
        assertEquals("Deck size should be 2 after dealing cards to player", 2, testGame.getCardDeck().getTokens().size());
        assertEquals("Player's hand size should be 3 after deal", 3, p.getHand().size());

    }
}
