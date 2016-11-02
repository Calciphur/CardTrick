package CardTrick;

public class Main {
    /* INSTANCE VARIABLES */
    public static ThreeRemain game = new ThreeRemain("token", 1278);
    //public static ThreeRemain game = new ThreeRemain();

    /* METHODS */
    public static void main(String[] args) {
        //game.play(game.getCardDeck().getTokens());
        game.play();
    }
}
