package CardTrick;

import java.util.ArrayList;

abstract public class Game {
    /* INSTANCE VARIABLES */
    protected static final ArrayList<String> gameTypes = new ArrayList();
    protected static final ArrayList<String> deckTypes = new ArrayList();
    protected String gameType;
    protected String deckType;

    /* METHODS */
    /* ** GETTERS ** */
    public String getGameType() { return this.gameType; }
    public String getDeckType() { return this.deckType; }

    /* ** SETTERS ** */
    protected void populateGameTypes() { gameTypes.add("threeRemain"); gameTypes.add("threeRemainTest"); }
    protected void populateDeckTypes() { deckTypes.add("standard"); deckTypes.add("token");}

    public void setGameType(String type) {
        if (gameTypes.contains(type)) {
            this.gameType = type;
        } else {
            throw (new IllegalArgumentException("provided type is not member of gameTypes"));
        }
    }

    public void setDeckType(String type) {
        if (deckTypes.contains(type)) {
            this.deckType = type;
        } else {
            throw (new IllegalArgumentException("provided type is not a member of deckTypes"));
        }
    }
}
