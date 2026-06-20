import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Appointment {
    private String date;
    private String time;
    private String doctorName;

    private static final String[] doctors = {"Dr. Maiada", "Dr. Youssef Shawky", "Dr. Shehab Wael", "Dr. Omar Tamer"};
    private static final String[] times = {"4:30 PM", "6:30 PM", "8:30 PM", "10:00 PM"};
    private static final String[] dates = {"Sunday", "Tuesday", "Thursday"};

    // Array to track booked times per doctor
    private static final boolean[][] bookedTimes = new boolean[doctors.length][times.length];

    public Appointment(String date, String time, String doctorName) {
        this.date = date;
        this.time = time;
        this.doctorName = doctorName;
    }

    public static Appointment createAppointment() {
        Scanner scanner = new Scanner(System.in);

        // Display available doctors
        System.out.println("Choose a doctor:");
        for (int i = 0; i < doctors.length; i++) {
            System.out.println((i + 1) + ". " + doctors[i]);
        }
        int doctorChoice;
        do {
            System.out.print("Enter the number of the doctor (1-" + doctors.length + "): ");
            doctorChoice = scanner.nextInt();
        } while (doctorChoice < 1 || doctorChoice > doctors.length);

        // Display available dates
        System.out.println("\nChoose a date:");
        for (int i = 0; i < dates.length; i++) {
            System.out.println((i + 1) + ". " + dates[i]);
        }
        int dateChoice;
        do {
            System.out.print("Enter the number of the date (1-" + dates.length + "): ");
            dateChoice = scanner.nextInt();
        } while (dateChoice < 1 || dateChoice > dates.length);

        // Display available times for the selected doctor
        int timeChoice = -1;
        while (true) {
            System.out.println("\nChoose a time:");
            for (int i = 0; i < times.length; i++) {
                if (!bookedTimes[doctorChoice - 1][i]) { // Only show available times for the selected doctor
                    System.out.println((i + 1) + ". " + times[i]);
                }
            }
            System.out.print("Enter the number of the time (1-" + times.length + "): ");
            timeChoice = scanner.nextInt() - 1;

            // Check if the selected time is booked for the selected doctor
            if (timeChoice >= 0 && timeChoice < times.length && !bookedTimes[doctorChoice - 1][timeChoice]) {
                bookedTimes[doctorChoice - 1][timeChoice] = true; // Mark the time as booked for the selected doctor
                break; // Exit the loop if a valid time is chosen
            } else {
                System.out.println("The selected time is already booked for this doctor. Please choose another time.");
            }
        }

        // Create and return the appointment
        return new Appointment(dates[dateChoice - 1], times[timeChoice], doctors[doctorChoice - 1]);
    }

    public String getDate() {
        return date;
    }

    public void displayAppointment() {
        System.out.println("\nAppointment Details:");
        System.out.println("Doctor: " + doctorName);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
    }
    public String getDoctorName() {
        return doctorName;
    }
    public String getTime() {
        return time;
    }

}