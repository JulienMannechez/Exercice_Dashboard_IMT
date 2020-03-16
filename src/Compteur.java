public class Compteur {

    protected int value;

    public Compteur() {
        this.raz();
    }

    public void up() {
        this.value ++;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "" + this.value;
    }

    public void raz() {
        this.value = 0;
    }
}
