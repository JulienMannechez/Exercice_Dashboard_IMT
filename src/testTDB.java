import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class testTDB {

    @Test
    public void testGetDist() {
        System.out.println("GET DIST \n");
        Chronometre chrono = new Chronometre();
        Compteur comp = new Compteur();
        TableauDeBord tdb = new TableauDeBord(comp, chrono);

        System.out.println(" Compteur valeur * Circonf Roue \n");
        comp.up(); //1
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(2.14, tdb.getDist(), 0.5);

        comp.up(); //2
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(4.28, tdb.getDist(), 0.5);

        comp.raz(); //0
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(0.0, tdb.getDist(), 0.0);
        System.out.println("----------------------------------------------------------- \n");

    }

    @Test
    public void testGetLastDist() {
        System.out.println("GET LAST DIST \n");
        Chronometre chrono = new Chronometre();
        Compteur comp = new Compteur();
        TableauDeBord tdb = new TableauDeBord(comp, chrono);

        System.out.println(" Compteur valeur * Circonf Roue \n");
        tdb.getSpeed();
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(0.0, tdb.getLastDist(), 0.5);

        comp.up();
        tdb.getSpeed(); // appel de getSpeed avec compteur à 1
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(2.14, tdb.getLastDist(), 0.5);

        comp.up();
        tdb.getSpeed(); // appel de getSpeed avec compteur à 2
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(4.28, tdb.getLastDist(), 0.5);

        comp.up(); // compteur à 3 mais sans appel de getSpeed
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(4.28, tdb.getLastDist(), 0.5);

        comp.raz();
        tdb.getSpeed(); // appel de getSpeed avec compteur à 0 (RAZ)
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(0.0, tdb.getLastDist(), 0.0);
        System.out.println("----------------------------------------------------------- \n");

    }


    @Test
    public void testGetSpeed() {
        System.out.println("GET SPEED \n");
        Chronometre chrono = new Chronometre(new HorlogeFictive());
        Compteur comp = new Compteur();
        TableauDeBord tdb = new TableauDeBord(comp, chrono);
        chrono.start();
        chrono.horloge.delay(10);
        // lastDist && lastTime = 0
        comp.up();
        System.out.println(" 3,6 * 1000 *  ( " + tdb.getDist() + " - " + tdb.getLastDist() + ") / (" + chrono.getTime() + " - lastTime) \n");
        System.out.println(" Premier test basique avec delay : 10ms et compteur : 1 \n");
        assertEquals(770, tdb.getSpeed(), 0.5);

        chrono.horloge.delay(20);
        comp.up();
        // lastDist = 2.14
        // lastTime = 10
        System.out.println(" 3,6 * 1000 *  ( " + tdb.getDist() + " - " + tdb.getLastDist() + ") / (" + chrono.getTime() + " - lastTime) \n");
        System.out.println(" Second test avec delay : 30ms (10+20) et compteur : 2 \n");
        assertEquals(385, tdb.getSpeed(), 0.5);

        chrono.horloge.delay(5);
        chrono.stop();
        // lastDist = 4.28
        // lastTime = 20
        System.out.println(" 3,6 * 1000 *  ( " + tdb.getDist() + " - " + tdb.getLastDist() + ") / (" + chrono.getTime() + " - lastTime) \n");
        System.out.println(" Test avec delay : 35ms et compteur toujours : 2 \n");
        assertEquals(0.0, tdb.getSpeed(), 0.5);

        chrono.raz();
        // lastDist = 4.28
        // lastTime = 20
        System.out.println(" 3,6 * 1000 *  ( " + tdb.getDist() + " - " + tdb.getLastDist() + ") / (" + chrono.getTime() + " - lastTime) \n");
        System.out.println(" Test avec chrono RAZ et compteur toujours : 2 \n");
        assertEquals(0.0, tdb.getSpeed(), 0.5);

        comp.raz();
        // lastDist = 4.28
        // lastTime = 20
        System.out.println(" 3,6 * 1000 *  ( " + tdb.getDist() + " - " + tdb.getLastDist() + ") / (" + chrono.getTime() + " - lastTime) \n");
        System.out.println(" Test avec chrono RAZ et compteur RAZ, assert NOT equals (infinity) \n");
        assertNotEquals(0.0, tdb.getSpeed(), 0.5);

        System.out.println("----------------------------------------------------------- \n");

    }

    @Test
    public void testRazOdoJour() {
        System.out.println("RAZ ODO JOUR \n");
        Chronometre chrono = new Chronometre(new HorlogeFictive());
        Compteur comp = new Compteur();
        TableauDeBord tdb = new TableauDeBord(comp, chrono);
        chrono.start();
        chrono.horloge.delay(10);

        System.out.println(" Compteur valeur * Circonf Roue \n");
        comp.up(); //1
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(2.14, tdb.getDist(), 0.5);
        comp.up(); //2
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(4.28, tdb.getDist(), 0.5);

        System.out.println(" RAZ odometre journalier \n");
        tdb.razODoJour();
        comp.up(); //1 (reset)
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(2.14, tdb.getDist(), 0.5);

        comp.raz();
        System.out.println(comp.toString() + " * 2.14 \n");
        assertEquals(0.0, tdb.getDist(), 0.0);

        System.out.println("----------------------------------------------------------- \n");

    }


}
