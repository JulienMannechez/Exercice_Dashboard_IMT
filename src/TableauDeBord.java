public class TableauDeBord {

    private Compteur comp;
    private Chronometre chronometre;

    private Tachymetre tachy;
    private Odometre odo;
    private OdometreJour odoJour;

    public TableauDeBord(Compteur v_Comp, Chronometre v_Chrono) {
        this.comp = v_Comp;
        this.chronometre = v_Chrono;
        tachy = new Tachymetre(this.comp, this.chronometre);
        odo = new Odometre(this.comp);
        odoJour = new OdometreJour(this.comp);
        this.razODoJour();
    }

    public double getSpeed() {
        return tachy.getSpeed();
    }

    public double getDist() {
        return odo.getDist();
    }

    public double getLastDist() {
        return tachy.getLastDist();
    }

    public void razODoJour() {
        odoJour.raz();
    }
}
