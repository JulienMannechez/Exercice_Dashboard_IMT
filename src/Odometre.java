public class Odometre {

    protected Compteur comp;

    public Odometre(Compteur v_Comp) {
        this.comp = v_Comp;
    }

    public double getDist() {
        return comp.getValue() * Roue.CIRCONF; // m
    }
}
