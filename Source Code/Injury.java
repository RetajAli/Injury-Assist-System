import java.util.Date;
import java.util.Scanner;

public class Injury {
    private String type; // Use this field as the injury's name
    private int severity;
    private BodyPart bodyPart;

    // Static array of predefined injuries
    private static final Injury[] INJURIES;

    static {
        // Initialize the static INJURIES array
        BodyPart[] bodyParts = {
                new BodyPart("Arm"),
                new BodyPart("Hand"),
                new BodyPart("Ankle"),
                new BodyPart("Finger"),
                new BodyPart("Leg"),
                new BodyPart("Shoulder"),
                new BodyPart("Face")
        };

        INJURIES = new Injury[]{
                new Injury("Broken bones", 4, new Date(), bodyParts[0]),
                new Injury("Burn", 4, new Date(), bodyParts[1]),
                new Injury("Ankle Sprain", 4, new Date(), bodyParts[2]),
                new Injury("Wrist sprain", 4, new Date(), bodyParts[1]),
                new Injury("Bruise", 2, new Date(), bodyParts[4]),
                new Injury("Shoulder Dislocation", 4, new Date(), bodyParts[5]),
                new Injury("Muscle Cramps", 1, new Date(), bodyParts[4]),
                new Injury("Finger Dislocation", 3, new Date(), bodyParts[3]),
                new Injury("ACL", 5, new Date(), bodyParts[4]),
                new Injury("Torn Muscles", 5, new Date(), bodyParts[0]),
                new Injury("Nose Fracture", 3, new Date(), bodyParts[6]),
                new Injury("Achilles Tendon Tear", 5, new Date(), bodyParts[2])
        };
    }

    // Constructor for Injury class
    public Injury(String type, int severity, Date dateOfInjury, BodyPart bodyPart) {
        this.type = type;
        this.severity = severity;
        this.bodyPart = bodyPart;
    }

    // Static method to retrieve all injuries
    public static Injury[] getAllInjuries() {
        return INJURIES;
    }

    // Method to display severity level
    public void severityLevel() {
        System.out.println("Severity Level: " + severity);
        switch (severity) {
            case 1 -> System.out.println("1 = Trivial - Cosmetic issue, no impact");
            case 2 -> System.out.println("2 = Low - Minimal impact, non-urgent");
            case 3 -> System.out.println("3 = Medium - Minor issue, can be addressed in a reasonable timeframe");
            case 4 -> System.out.println("4 = High - Major issue, needs urgent resolution");
            case 5 -> System.out.println("5 = Critical - System failure, immediate action required");
            default -> System.out.println("Invalid severity level. Please enter a value between 1 and 5.");
        }
    }

    // Method to display injury details
    public void displayInjuryDetails() {
        System.out.println("Injury Type: " + type);
        System.out.println("Body Part: " + bodyPart.getName());
        severityLevel();
    }

    // Method to choose an injury
    public static Injury chooseInjury() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to choose an injury
        System.out.println("Choose an injury:");
        for (int i = 0; i < INJURIES.length; i++) {
            System.out.println((i + 1) + ". " + INJURIES[i].type);
        }

        int choice;
        do {
            System.out.print("Enter the number of the injury (1-12): ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 12); // Allow choices from 1 to 12

        return INJURIES[choice - 1]; // Return the selected injury
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public String getType() {
        return type;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return type;
    }
}
