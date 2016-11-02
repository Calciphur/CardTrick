package CardTrick;

import java.util.ArrayList;

public class Player {

    /* INSTANCE VARIABLES */
    private static int playerCount;
    private ArrayList<Token> hand = new ArrayList();

    /* CONSTRUCTORS */
    public Player() {
        playerCount++;

    }

    /* METHODS */

    /* ** GETTERS ** */
    public int getPlayerCount() { return playerCount; }
    public ArrayList getHand() { return this.hand; } //returns an arraylist object of card objects

    /* ** SETTERS ** */
    public void setHand(ArrayList<Token> tokens) { this.hand = tokens; } //copies the contents of a Token arraylist into the hand arraylist

    /* ** PRINT METHODS ** */
    public void printHand() {
        System.out.println("Cards dealt to player: ");
        for (Token token : hand) {
            if (token instanceof StandardPlayingCard) {
                StandardPlayingCard card = (StandardPlayingCard) token;
                System.out.println(card.toString()); }
            else {
                System.out.println(token.toString()); }
        }
        System.out.println();
    }
}
