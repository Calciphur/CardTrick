package CardTrick;

public class Token {

    /* INSTANCE VARIABLES */
    protected String value;

    /* CONSTRUCTORS */
    public Token() {}

    public Token(String value) {
        this.setValue(value);
    }

    /* METHODS */

    /* ** OVERRIDDEN METHODS ** */
    @Override
    public String toString() {
        /*return "Token{" +
                "value='" + value + '\'' +
                '}';
                */
        return "Token: " + value;
    }

    /* ** GETTERS ** */
    public String getValue() { return this.value; }

    /* ** SETTERS ** */
    public void setValue(String value) { this.value = value; }

}
