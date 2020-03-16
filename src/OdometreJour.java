public class OdometreJour extends Odometre {

    public OdometreJour(Compteur v_Comp) {
        super(v_Comp);
        this.raz();
    }

    @Override
    public double getDist() {
        return super.getDist();
    }

    public void raz() {
        this.comp.raz();
    }

}
