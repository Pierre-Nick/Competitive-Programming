/**
 * Created by NickPierre on 12/16/16.
 */
public class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int newStart) {
        start = newStart;
    }

    public void setEnd(int newEnd) {
        end = newEnd;
    }

    @Override
    public String toString() {
        return "{ " + this.getStart() + ", " + this.getEnd() + " } ";
    }

}
