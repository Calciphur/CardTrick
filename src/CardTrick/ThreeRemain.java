package CardTrick;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeRemain extends Game {

    /** INSTANCE VARIABLES */
    private Deck cardDeck;
    private Player player;
    private ArrayList<Integer> keyPositions = new ArrayList<> ();

    /** CONSTRUCTORS */
    /* FOR TESTING PURPOSES, I PLACE ALL THE GAME
     * MECHANICS INTO THE CONSTRUCTORS OF THE
     * CLASS. IN THE FUTURE, THESE MECHANICS
     * WILL BE DISTRIBUTED AMONG COMPONENTS OF
     * THE GUI INTERFACE I IMPLEMENT.
     */
    public ThreeRemain() {
        populateDeckTypes();
        populateGameTypes();
        this.setGameType("threeRemain");
        this.setDeckType("standard");
        cardDeck = new Deck();
        player = new Player();
    }

    public ThreeRemain(String deckType, int deckCardCount) {
        populateDeckTypes();
        populateGameTypes();
        this.setGameType("threeRemain");
        this.setDeckType(deckType);
        cardDeck = new Deck(deckCardCount);
        player = new Player();
    }
    /** METHODS */
    /* GETTERS */
    public Deck getCardDeck() { return this.cardDeck; }
    public ArrayList getKeyPositions() { return this.keyPositions; }

    /* SETTERS */

    /** FINDS ALL KEY POSITIONS AND STORES
     *  THEM IN THE APPROPRIATE INSTANCE VARIABLE */
    private void setKeyPositions() {
        ArrayList<Integer> keys = new ArrayList<> ();
        Deck dummyTokens = new Deck(cardDeck.getDeckSize()); //create a placeholder token deck of the same size as cardDeck
        removeAllEvenElementsNoPrint(dummyTokens, dummyTokens.getTokens(), 0); //sets the 'tokens' list in dummyTokens == the key positions

        for (Object item : dummyTokens.getTokens()) {
            Token token = (Token) item; //cast 'item' as a Token, because I already know all of the 'item's are Token objects
            int keyValue = Integer.parseInt(token.getValue()) - 1;
            keys.add(keyValue);
        }

        this.keyPositions = keys;
    }

    /* ** PRINT METHODS ** */

    /**PRINTS THE CONTENTS OF ANY
     * LIST OF TOKENS */
    public void printTokenArray(ArrayList<Token> tokens) {
        for (Token token : tokens) {
            if (token instanceof StandardPlayingCard) {
                StandardPlayingCard card = (StandardPlayingCard) token;
                System.out.println(card);
            } else {
                System.out.println(token);
            }
        }
    }

    public void printKeyPositions() {
        for (Object pos : this.getKeyPositions()) {
            if (pos instanceof Integer) {
                Integer position = (Integer) pos;
                System.out.print(position + 1 + " ");
            }
        }
        System.out.println();
    }

    /* BREAD AND BUTTER METHODS */

    /** THIS FUNCTION DOES A LOT.
     *  IT PRINTS OUT HOW MANY CARDS
     *  ARE LEFT AFTER EACH CUT, AND
     *  THEN PRINTS OUT THE CARDS
     *  THAT REMAIN AT THE END.
     */
    public void removeAllEvenElements(Deck myDeck, ArrayList<Token> cardList, int numIterations) {
        ArrayList<Token> remainingTokens = new ArrayList<> ();

        if (numIterations == 0) {
            System.out.println("pass " + numIterations + " -> " + cardList.size() + " cards initially in deck");
            this.getCardDeck().printDeck();
        }

        if (cardList.size() > 3) {
            numIterations++;
            for (int position = 0; position < cardList.size(); position++) {
                if (position % 2 != 0) {
                    remainingTokens.add(cardList.get(position));
                }
            }

            System.out.println("\npass " + numIterations + " -> " + remainingTokens.size() + " cards left in deck");
            System.out.println("cards remaining:");
            printTokenArray(remainingTokens);
            Collections.reverse(remainingTokens);

            if (remainingTokens.size() > 3) {
                removeAllEvenElements(myDeck, remainingTokens, numIterations);
            } else {
                myDeck.setTokens(remainingTokens);
            }
        } else { myDeck.setTokens(cardList); }
    }

    private void removeAllEvenElementsNoPrint(Deck myDeck, ArrayList<Token> cardList, int numIterations) {
        ArrayList<Token> remainingTokens = new ArrayList<> ();

        if (cardList.size() > 3) {
            numIterations++;
            for (int position = 0; position < cardList.size(); position++) {
                if (position % 2 != 0) {
                    remainingTokens.add(cardList.get(position));
                }
            }

            Collections.reverse(remainingTokens);

            if (remainingTokens.size() > 3) {
                removeAllEvenElementsNoPrint(myDeck, remainingTokens, numIterations);
            } else {
                myDeck.setTokens(remainingTokens);
            }
        } else { myDeck.setTokens(cardList); }
    }

    public void play() {
        this.setKeyPositions();

        //System.out.println("CARDDECK CARDS AT THIS POINT: SIZE = " + cardDeck.getTokens().size()); cardDeck.printDeck();

        this.buildHand(player, getKeyPositions().size()); //should always be 2 or 3 cards
        this.player.printHand();
        System.out.print("\n***CARDS FROM PLAYER'S HAND ARE INSERTED AT INDICES: "); printKeyPositions(); System.out.println();

        //System.out.println("CARDDECK CARDS AT THIS POINT: SIZE = " + cardDeck.getTokens().size()); cardDeck.printDeck();

        cardDeck.insertTokens(this.player.getHand(), this.getKeyPositions());
        this.removeAllEvenElements(getCardDeck(), cardDeck.getTokens(), 0);
        System.out.println("\nCARDS REMAINING AFTER ALL ITERATIONS:");
        printTokenArray(cardDeck.getTokens());
    }

    public void buildHand(Player p, int numCardsToDeal) {
        p.setHand(cardDeck.dealTokens(cardDeck.getTokens(), numCardsToDeal));
    }
}