public class Tachymetre {

    private Compteur compteur;
    private Chronometre chronometre;
    private long lastTime;
    private double lastDist = 0;

    public Tachymetre(Compteur v_Comp, Chronometre v_Chrono) {
        this.chronometre = v_Chrono;
        this.compteur = v_Comp;
        lastTime = chronometre.getTime();
    }

    public double getSpeed() {
        double result = 0.0;
        double currentDist = compteur.getValue() * Roue.CIRCONF; // m
        long currentTime = chronometre.getTime(); // ms
        try {
            result = 3.6 * 1000 * (currentDist - this.lastDist) / (currentTime - this.lastTime); // km/h
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException  e) {
            System.out.println(e.getMessage());
        }
        this.lastTime = currentTime;
        this.lastDist = currentDist;
        return result;
    }

    public double getLastDist() {
        return this.lastDist;
    }

}
