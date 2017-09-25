package crackingTheCodingInterview.interval;

public class Interval {
    private int start;
    private int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return start;
    }

    int getEnd() {
        return end;
    }

    public void setStart(int newStart) {
        start = newStart;
    }

    void setEnd(int newEnd) {
        end = newEnd;
    }

    @Override
    public String toString() {
        return "{ " + this.getStart() + ", " + this.getEnd() + " } ";
    }
}
