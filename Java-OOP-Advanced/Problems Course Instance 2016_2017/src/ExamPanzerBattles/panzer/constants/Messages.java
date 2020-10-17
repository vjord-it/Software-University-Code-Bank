package ExamPanzerBattles.panzer.constants;

public final class Messages {


    public static final String VEHICLE_CREATED = "Created %s Vehicle - %s";
    public static final String ADDED_PART_TO_VEHICLE = "Added %s - %s to Vehicle - %s";
    public static final String VICTORY = "%s versus %s -> %s Wins! Flawless Victory!";
    public static final String NONE = "None";
    public static final String REMAINING_VEHICLES = "Remaining Vehicles: ";
    public static final String DEFEATED_VEHICLES = "Defeated Vehicles: ";
    public static final String CURRENTLY_USED_PARTS = "Currently Used Parts: ";
    public static final String VEHICLES_FORMAT = "%s - %s%n" +
            "Total Weight: %.3f%n" +
            "Total Price: %.3f%n" +
            "Attack: %d%n" +
            "Defense: %d%n" +
            "HitPoints: %d%n" +
            "Parts: %s";

    private Messages() {
    }
}
