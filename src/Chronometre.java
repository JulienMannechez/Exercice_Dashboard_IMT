
public class Chronometre {

    public Horloge horloge;
    public long lastStartDate;
    public long sum;

    public enum State{
        INIT,
        RUNNING,
        STOPPED
    };
    public State currentSate;

    public Chronometre() {
        this.horloge = new HorlogeStandart();
        this.lastStartDate = this.horloge.currentTimeMillis();
        this.raz();
    }

    public Chronometre(Horloge v_Horloge) {
        this.horloge = v_Horloge;
        this.lastStartDate = this.horloge.currentTimeMillis();
        this.raz();
    }

    public void start() {
        if(this.currentSate == State.RUNNING)
            return;
        else {
            this.lastStartDate = this.horloge.currentTimeMillis();
            this.currentSate = State.RUNNING;
        }
    }

    public void stop() {
        if(this.currentSate == State.STOPPED || this.currentSate == State.INIT)
            return;
        else {
            this.currentSate = State.STOPPED;
            sum += this.horloge.currentTimeMillis() - this.lastStartDate;
        }
    }

    public void raz() {
        if(this.currentSate == State.INIT || this.currentSate == State.RUNNING)
            return;
        else {
            sum = 0;
            this.currentSate = State.INIT;
        }
    }

    public long getTime() {

        switch(this.currentSate) {
            case INIT:
            default:
                return 0L; // force a LONG
            case RUNNING:
                return this.horloge.currentTimeMillis() - this.lastStartDate + sum;
            case STOPPED:
                return sum;
        }
    }

}
