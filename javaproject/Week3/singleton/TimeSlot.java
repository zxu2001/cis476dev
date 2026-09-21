package singleton;

public class TimeSlot {
    private final int startHour;
    private final int endHour;

    public TimeSlot(int startHour, int endHour) {
        if (startHour >= endHour) {
            throw new IllegalArgumentException(
                "Start time must be earlier than end time."
            );
        }
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public boolean overlaps(TimeSlot other) {
        return this.startHour < other.endHour
                && other.startHour < this.endHour;
    }

    @Override
    public String toString() {
        return startHour + ":00-" + endHour + ":00";
    }
}