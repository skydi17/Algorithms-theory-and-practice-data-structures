package priorityQueues.parallelProcessing_3;

public class Processor {
    private long time;
    private int procNumber;
    private int i;

    Processor() {
        this.time = 0;
        this.procNumber = 0;
    }

    Processor(long time, int procNumber, int i) {
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

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
