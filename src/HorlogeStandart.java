public class HorlogeStandart implements Horloge {

    public HorlogeStandart() { }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException e) {  }
    }

}
