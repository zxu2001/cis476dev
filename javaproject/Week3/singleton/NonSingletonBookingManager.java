package singleton;

import java.util.HashMap;
import java.util.Map;

/*
 * BEFORE: A normal class that allows multiple BookingManager objects.
 *
 * Each object has its own reservations map. Therefore, two clients using
 * different BookingManager objects do not see each other's reservations.
 */
public class NonSingletonBookingManager {

    private final Map<Integer, TimeSlot> reservations = new HashMap<>();

    public NonSingletonBookingManager() {
    }

    public boolean reserve(Resource resource, TimeSlot requestedTime) {
        if (!isAvailable(resource, requestedTime)) {
            return false;
        }

        reservations.put(resource.getId(), requestedTime);
        return true;
    }

    public boolean isAvailable(Resource resource, TimeSlot requestedTime) {
        TimeSlot existingReservation = reservations.get(resource.getId());

        return existingReservation == null
                || !existingReservation.overlaps(requestedTime);
    }
}