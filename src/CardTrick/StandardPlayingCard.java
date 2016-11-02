package CardTrick;

public class StandardPlayingCard extends Token {

    /** INSTANCE VARIABLES */
    private String suit;
    private int points;

    /** CONSTRUCTORS */
    public StandardPlayingCard() {}

    public StandardPlayingCard(String value, String suit) {
        this.setValue(value);
        this.setSuit(suit);
    }

    public StandardPlayingCard(String value, String suit, int points) {
        this.setValue(value);
        this.setSuit(suit);
        this.setPoints(points);
    }

    /** METHODS */

    /* ** GETTERS ** */
    public String getSuit() { return this.suit; }
    public int getPoints() { return this.points; }

    /* ** SETTERS ** */
    public void setSuit(String suitName) { this.suit = suitName; } //hearts, diamonds, spades, clubs
    public void setPoints(int pointValue) { this.points = pointValue; }

    @Override
    public String toString() {
        /*return "StandardPlayingCard{" +
                "value='" + value + '\'' +
                ", suit='" + suit + '\'' +
                ", points=" + points +
                '}';
                */
        return value + " of " + suit;
    }
}
