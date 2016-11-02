package CardTrick;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /* Class goals
        create an arraylist of card objects
        shuffle card objects
        deal cards to a player
        set the size of the deck
        return the size of the deck
     */

    /* INSTANCE VARIABLES ***********************************************/
    private ArrayList<Token> tokens = new ArrayList();

    /* CONSTRUCTORS *****************************************************/
    /* ** FOR TESTING LARGE DECK SIZES ** */
    public Deck(int count) {
        this.populateTokens(count);
    }

    /* ** FOR RUNNING THE GAME WITH A SINGLE DECK ** */
    public Deck() {
        this.populateStandardCards();
    }

    /* METHODS **********************************************************/
    /* ** OVERRIDDEN METHODS ** */

    /* ** GETTERS ** */
    public int getDeckSize() { return this.getTokens().size(); }
    public ArrayList<Token> getTokens() { return this.tokens; }

    /* ** SETTERS ** */
    //public void setDeckSize(int size) { this.deckSize = size; }
    public void setTokens(ArrayList<Token> tokenList) { this.tokens = tokenList; }

    /* ** PRINT METHODS ** */
    public void printDeck() {
        for (Token token : tokens) {
                System.out.println(token.toString());
        }


    }
    /* ** BREAD AND BUTTER METHODS ** */
    public void populateStandardCards() {
        String[] values = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
        String[] suits = {"hearts", "diamonds", "spades", "clubs"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                tokens.add(new StandardPlayingCard(values[j], suits[i]));
            }
        }
    }

    public void populateTokens(int count) {
        for (int i = 1; i <= count; i++) {
            tokens.add(new Token(Integer.toString(i)));
        }
    }

    //Must always run AFTER deck has been built
    public ArrayList dealTokens(ArrayList<Token> tokens, int count) {
        ArrayList<Token> dealtTokens = new ArrayList();
        Random randomIndex = new Random();

        for (int i = 0; i < count; i++) {
            int index = randomIndex.nextInt(tokens.size());
            dealtTokens.add(tokens.get(index));
            tokens.remove(index);
        }

        this.setTokens(tokens);
        return dealtTokens;
    }

    public void insertTokens(ArrayList<Token> myTokens, ArrayList<Integer> positions) {
        ArrayList<Token> tokensCopy = this.getTokens();
        for (int i = 0; i < positions.size(); i++) {
            tokensCopy.add(positions.get(i), myTokens.get(i));
        }
        this.setTokens(tokensCopy);
    }

}


