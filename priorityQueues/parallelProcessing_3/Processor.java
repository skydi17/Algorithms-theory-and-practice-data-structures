public class Processor {
    private long time;
    private int procNumber;

    Processor(long time, int procNumber) {
        this.time = time;
        this.procNumber = procNumber;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getProcNumber() {
        return procNumber;
    }

    public void setProcNumber(int procNumber) {
        this.procNumber = procNumber;
    }
}
