import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            AccountManager accountManager = new AccountManager();
            System.out.println("Welcome to the System!");
            System.out.println("1. Sign Up\n2. Log In\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter a username: ");
                String username = scanner.nextLine();

                if (accountManager.isUsernameTaken(username)) {
                    System.out.println("Username is already taken. Please try another username.");
                    return;
                }

                System.out.print("Enter a password: ");
                String password = scanner.nextLine();

                User user = new User(username, password);
                accountManager.saveUser(user);

                System.out.println("Account created successfully!");

            } else if (choice == 2) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();

                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                if (accountManager.validateUser(username, password)) {
                    System.out.println("Login successful! Welcome back, " + username + "!");
                } else {

                    System.out.println("Invalid username or password. Please try again.");
                continue;
                }
            } else {
                System.out.println("Invalid choice. Exiting...");
            }

            ArrayList<User> users = new ArrayList<>();

            System.out.println("=== User Information ===");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            boolean gender;
            while (true) {
                System.out.print("Enter your gender (1 for Male, 0 for Female): ");
                int genderInput = scanner.nextInt();
                if (genderInput == 1 || genderInput == 0) {
                    gender = genderInput == 1; // Convert to boolean
                    break; // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please enter 1 for Male or 0 for Female.");
                }
            }



            System.out.print("Enter your contact number: ");
            int contactNo = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after nextInt()

            System.out.print("Enter your address: ");
            String address = scanner.nextLine();

            User user = new User(name, age, gender, contactNo, address, null);
            users.add(user);


            Sport selectedSport = chooseSport(scanner);

            System.out.println("\n=== Injury Selection ===");
            Injury injury = Injury.chooseInjury();

            // Get the treatment for the selected injury
            Treatment treatment = Treatment.getTreatment(injury.getType());

            // Create an appointment
            Appointment appointment = Appointment.createAppointment();

            // Generate the report
            Report report = new Report(user, injury, treatment, appointment, selectedSport) {
                @Override
                public void generateCustomReport() {
                    // Custom report logic if needed
                }
            };
            report.generateReport();

            // Ask if the user wants to add another user
            System.out.print("Do you want to add another user? (yes/no): ");
            String response = scanner.nextLine();  // Consume the newline character and then get the response

            if (!response.equalsIgnoreCase("yes")) {
                break;  // Exit the loop if the answer is not "yes"
            }
        accountManager.saveAllUsers();
        }

        scanner.close();
    }

    private static Sport chooseSport(Scanner scanner) {
        SportsCollection sportsCollection = new SportsCollection();
        ArrayList<Sport> sportsList = sportsCollection.getSportsList();

        System.out.println("\n=== Choose a Sport ===");
        for (int i = 0; i < sportsList.size(); i++) {
            System.out.println((i + 1) + ". " + sportsList.get(i).getName());
        }

        int sportChoice;
        do {
            System.out.print("Enter the number of the sport (1-3): ");
            sportChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
        } while (sportChoice < 1 || sportChoice > 3);

        return sportsList.get(sportChoice - 1); // Return the selected sport
    }
}