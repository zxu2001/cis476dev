import java.util.HashMap;
import java.util.Map;

/*
 * AFTER: Singleton version of BookingManager.
 *
 * All clients obtain the same BookingManager object and therefore
 * share the same reservation state.
 */
public class BookingManager {

    private static BookingManager instance;

    private final Map<Integer, TimeSlot> reservations = new HashMap<>();

    // Private constructor prevents clients from using "new BookingManager()".
    private BookingManager() {
    }

    // Provides one global access point to the single object.
    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
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