package Lect_07;

public class RangeClass {
    private double from;
    private double to;

    public RangeClass(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getRangeLength() {
        return from - to;
    }

    public boolean isInside(double point) {
        return point >= from && point <= to;
    }
}