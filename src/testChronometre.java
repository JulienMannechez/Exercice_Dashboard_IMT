import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testChronometre {

    @Test
    public void testRAZ() {
        Chronometre c1 = new Chronometre(new HorlogeFictive());
        c1.raz();
        assertEquals(0, c1.getTime());
        assertEquals(Chronometre.State.INIT, c1.currentSate);
    }

    @Test
    public void testStart() {
        Chronometre c1 = new Chronometre();
        Chronometre c2= new Chronometre(new HorlogeFictive());

        c1.start();
        c2.start();

        c1.horloge.delay(10);
        assertEquals(10, c1.getTime(), 10);
        assertEquals(Chronometre.State.RUNNING, c1.currentSate);

        c1.stop();
        c2.horloge.delay(45186181618186L);
        c2.stop();
        c2.horloge.delay(45186181618186L);
        assertEquals(45186181618186L, c2.getTime());
        assertEquals(Chronometre.State.STOPPED, c2.currentSate);
    }

    @Test
    public void testStop() {
        Chronometre c1 = new Chronometre(new HorlogeFictive());

        c1.start();
        c1.horloge.delay(10);
        c1.stop();
        c1.horloge.delay(100);
        assertEquals(10, c1.getTime());
        assertEquals(Chronometre.State.STOPPED, c1.currentSate);
    }



}
