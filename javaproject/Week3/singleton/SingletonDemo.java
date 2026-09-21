public class SingletonDemo {

    public static void main(String[] args) {

        Resource studyRoom = new Resource(125, "Study Room");

        TimeSlot studentATime = new TimeSlot(14, 16); // 2:00-4:00 PM
        TimeSlot studentBTime = new TimeSlot(15, 17); // 3:00-5:00 PM

        demonstrateWithoutSingleton(studyRoom, studentATime, studentBTime);

        System.out.println();
        System.out.println("========================================");
        System.out.println();

        demonstrateWithSingleton(studyRoom, studentATime, studentBTime);
    }

    private static void demonstrateWithoutSingleton(
            Resource resource,
            TimeSlot studentATime,
            TimeSlot studentBTime) {

        System.out.println("=== WITHOUT SINGLETON ===");

        // Imagine these managers belong to two different parts of the app.
        NonSingletonBookingManager webClientManager =
                new NonSingletonBookingManager();

        NonSingletonBookingManager mobileClientManager =
                new NonSingletonBookingManager();

        System.out.println("Same manager object? "
                + (webClientManager == mobileClientManager));

        boolean studentABooked =
                webClientManager.reserve(resource, studentATime);

        System.out.println("Student A requests " + resource
                + " at " + studentATime);
        System.out.println("Student A reservation: "
                + result(studentABooked));

        // The mobile client's manager has its OWN reservation map.
        // It does not know that Student A already reserved the room.
        boolean studentBBooked =
                mobileClientManager.reserve(resource, studentBTime);

        System.out.println("Student B requests " + resource
                + " at " + studentBTime);
        System.out.println("Student B reservation: "
                + result(studentBBooked));

        if (studentABooked && studentBBooked) {
            System.out.println();
            System.out.println("PROBLEM: Both reservations were accepted!");
            System.out.println("The two BookingManager objects maintain");
            System.out.println("independent reservation states.");
        }
    }

    private static void demonstrateWithSingleton(
            Resource resource,
            TimeSlot studentATime,
            TimeSlot studentBTime) {

        System.out.println("=== WITH SINGLETON ===");

        BookingManager webClientManager =
                BookingManager.getInstance();

        BookingManager mobileClientManager =
                BookingManager.getInstance();

        System.out.println("Same manager object? "
                + (webClientManager == mobileClientManager));

        boolean studentABooked =
                webClientManager.reserve(resource, studentATime);

        System.out.println("Student A requests " + resource
                + " at " + studentATime);
        System.out.println("Student A reservation: "
                + result(studentABooked));

        // This reference points to the SAME BookingManager.
        // It can see Student A's reservation.
        boolean studentBBooked =
                mobileClientManager.reserve(resource, studentBTime);

        System.out.println("Student B requests " + resource
                + " at " + studentBTime);
        System.out.println("Student B reservation: "
                + result(studentBBooked));

        if (studentABooked && !studentBBooked) {
            System.out.println();
            System.out.println("SUCCESS: The overlapping reservation");
            System.out.println("was rejected because both clients share");
            System.out.println("the same BookingManager state.");
        }
    }

    private static String result(boolean accepted) {
        return accepted ? "ACCEPTED" : "REJECTED";
    }
}