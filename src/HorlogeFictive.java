public class HorlogeFictive implements Horloge {

    private long currentTime;

    public HorlogeFictive() { }

    public long currentTimeMillis() {
        return this.currentTime;
    }

    public void delay(long ms) {
        this.currentTime += ms;
    }

}

