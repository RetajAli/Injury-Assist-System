import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainGUI {
    private JFrame frame;
    private JPanel panel;
    private AccountManager accountManager;
    private User currentUser;
    private Sport selectedSport;        // To store the selected sport
    private Injury selectedInjury;     // To store the selected injury
    private Appointment appointment;   // To store the created appointment
    private Treatment treatment;

    public MainGUI() {
        accountManager = new AccountManager();
        frame = new JFrame("Sports Injury Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(231, 207, 253)); // Light gray for main panel
        panel.setBackground(new Color(231, 207, 253)); // Light peach for sign-up form
        panel.setBackground(new Color(231, 207, 253)); // Light cyan for login form


        initializeGUI();

        frame.add(panel);
        frame.setVisible(true);
    }

    private void initializeGUI() {
        panel.removeAll();

        JLabel welcomeLabel = new JLabel("Welcome to the Sports Injury Management System!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(25, 25, 112)); // Midnight blue
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcomeLabel);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.addActionListener(e -> openSignUpForm());
        panel.add(signUpButton);

        JButton loginButton = new JButton("Log In");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(e -> openLoginForm());
        panel.add(loginButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openSignUpForm() {
        panel.removeAll();

        JLabel usernameLabel = new JLabel("Enter a username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Enter a password:");
        JTextField passwordField = new JPasswordField(20);
        JButton submitButton = new JButton("Sign Up");

        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (accountManager.isUsernameTaken(username)) {
                JOptionPane.showMessageDialog(frame, "Username is already taken. Please try another.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                User user = new User(username, password);
                accountManager.saveUser(user);
                JOptionPane.showMessageDialog(frame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                initializeGUI();
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openLoginForm() {
        panel.removeAll();

        JLabel usernameLabel = new JLabel("Enter your username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Enter your password:");
        JTextField passwordField = new JPasswordField(20);
        JButton submitButton = new JButton("Log In");

        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (accountManager.validateUser(username, password)) {
                currentUser = accountManager.getUser(username);
                JOptionPane.showMessageDialog(frame, "Login successful! Welcome back, " + username + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                openUserDashboard();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openUserDashboard() {
        panel.removeAll();

        JLabel dashboardLabel = new JLabel("Welcome to your dashboard!");
        dashboardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(dashboardLabel);

        JButton enterDetailsButton = new JButton("Enter User Details");
        enterDetailsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterDetailsButton.addActionListener(e -> openUserDetailsForm());
        panel.add(enterDetailsButton);

        JButton selectSportButton = new JButton("Select Sport");
        selectSportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectSportButton.addActionListener(e -> openSportSelectionForm());
        panel.add(selectSportButton);

        JButton selectInjuryButton = new JButton("Select Injury");
        selectInjuryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectInjuryButton.addActionListener(e -> openInjurySelectionForm());
        panel.add(selectInjuryButton);

        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        scheduleAppointmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scheduleAppointmentButton.addActionListener(e -> openAppointmentForm());
        panel.add(scheduleAppointmentButton);

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateReportButton.addActionListener(e -> generateReport());
        panel.add(generateReportButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openUserDetailsForm() {
        panel.removeAll();

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Enter your age:");
        JTextField ageField = new JTextField(5);
        JLabel genderLabel = new JLabel("Select your gender:");
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});
        JLabel contactLabel = new JLabel("Enter your contact number:");
        JTextField contactField = new JTextField(15);
        JLabel addressLabel = new JLabel("Enter your address:");
        JTextField addressField = new JTextField(30);
        JButton saveButton = new JButton("Save Details");

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            boolean gender = genderComboBox.getSelectedItem().equals("Male");
            int contact = Integer.parseInt(contactField.getText());
            String address = addressField.getText();

            currentUser = new User(name, age, gender, contact, address, null);
            JOptionPane.showMessageDialog(frame, "Details saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            openUserDashboard();
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderComboBox);
        panel.add(contactLabel);
        panel.add(contactField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(saveButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openSportSelectionForm() {
        panel.removeAll();

        SportsCollection sportsCollection = new SportsCollection();
        JLabel sportLabel = new JLabel("Choose a sport:");
        JComboBox<Sport> sportsComboBox = new JComboBox<>(
                sportsCollection.getSportsList().toArray(new Sport[0])
        );
        JButton selectButton = new JButton("Select Sport");

        selectButton.addActionListener(e -> {
            selectedSport = (Sport) sportsComboBox.getSelectedItem(); // Save the selected sport
            JOptionPane.showMessageDialog(frame, "You selected: " + selectedSport.getName(), "Sport Selected", JOptionPane.INFORMATION_MESSAGE);
            openUserDashboard();
        });

        panel.add(sportLabel);
        panel.add(sportsComboBox);
        panel.add(selectButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openInjurySelectionForm() {
        panel.removeAll();

        JLabel injuryLabel = new JLabel("Choose an injury:");
        JComboBox<Injury> injuriesComboBox = new JComboBox<>(Injury.getAllInjuries());
        JButton selectButton = new JButton("Select Injury");

        selectButton.addActionListener(e -> {
            selectedInjury = (Injury) injuriesComboBox.getSelectedItem(); // Save the selected injury
            JOptionPane.showMessageDialog(frame, "You selected: " + selectedInjury.getType(), "Injury Selected", JOptionPane.INFORMATION_MESSAGE);
            openUserDashboard();
        });

        panel.add(injuryLabel);
        panel.add(injuriesComboBox);
        panel.add(selectButton);

        panel.revalidate();
        panel.repaint();
    }

    private void openAppointmentForm() {
        panel.removeAll();

        JLabel appointmentLabel = new JLabel("Schedule an appointment:");
        JLabel doctorLabel = new JLabel("Choose a doctor:");
        JComboBox<String> doctorComboBox = new JComboBox<>(new String[]{"Dr. Maiada", "Dr. Youssef Shawky", "Dr. Shehab Wael"});
        JLabel dateLabel = new JLabel("Choose a date:");
        JComboBox<String> dateComboBox = new JComboBox<>(new String[]{"Sunday", "Tuesday", "Thursday"});
        JLabel timeLabel = new JLabel("Choose a time:");
        JComboBox<String> timeComboBox = new JComboBox<>(new String[]{"4:30 PM", "6:30 PM", "8:30 PM"});
        JButton scheduleButton = new JButton("Schedule Appointment");

        scheduleButton.addActionListener(e -> {
            String doctor = (String) doctorComboBox.getSelectedItem();
            String date = (String) dateComboBox.getSelectedItem();
            String time = (String) timeComboBox.getSelectedItem();

            // Save the appointment details in the appointment variable
            appointment = new Appointment(date, time, doctor);

            JOptionPane.showMessageDialog(frame, "Appointment scheduled with " + doctor + " on " + date + " at " + time, "Appointment Scheduled", JOptionPane.INFORMATION_MESSAGE);
            openUserDashboard();
        });

        panel.add(appointmentLabel);
        panel.add(doctorLabel);
        panel.add(doctorComboBox);
        panel.add(dateLabel);
        panel.add(dateComboBox);
        panel.add(timeLabel);
        panel.add(timeComboBox);
        panel.add(scheduleButton);

        panel.revalidate();
        panel.repaint();
    }

    private void generateReport() {
        panel.removeAll();

        if (currentUser == null) {
            JOptionPane.showMessageDialog(frame, "No user details found. Please enter user details first.", "Error", JOptionPane.ERROR_MESSAGE);
            openUserDashboard();
            return;
        }

        JLabel reportTitle = new JLabel("Generated Report");
        reportTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportTitle.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(reportTitle);

        StringBuilder reportContent = new StringBuilder();
        reportContent.append("<html><body>");
        reportContent.append("<h2>User Information:</h2>");
        reportContent.append("Name: ").append(currentUser.getName()).append("<br>");
        reportContent.append("Age: ").append(currentUser.getAge()).append("<br>");
        reportContent.append("Gender: ").append(currentUser.isGender() ? "Male" : "Female").append("<br>");
        reportContent.append("Contact Number: ").append(currentUser.getContact_no()).append("<br>");
        reportContent.append("Address: ").append(currentUser.getAddress()).append("<br><br>");

        if (selectedSport != null) {
            reportContent.append("<h2>Sport Information:</h2>");
            reportContent.append("Selected Sport: ").append(selectedSport.getName()).append("<br><br>");
        } else {
            reportContent.append("<h2>Sport Information:</h2>");
            reportContent.append("No sport selected.<br><br>");
        }

        if (selectedInjury != null) {
            reportContent.append("<h2>Injury Details:</h2>");
            reportContent.append("Type: ").append(selectedInjury.getType()).append("<br>");
            reportContent.append("Severity: ").append(selectedInjury.getSeverity()).append("<br>");
            reportContent.append("Affected Body Part: ").append(selectedInjury.getBodyPart().getName()).append("<br><br>");

            // Fetch treatment for the selected injury
            treatment = Treatment.getTreatment(selectedInjury.getType());
            reportContent.append("<h2>Treatment Details:</h2>");
            reportContent.append("Suggested Treatment: ").append(treatment.getTreatmentSuggestion()).append("<br><br>");
        } else {
            reportContent.append("<h2>Injury Details:</h2>");
            reportContent.append("No injury selected.<br><br>");
        }

        if (appointment != null) {
            reportContent.append("<h2>Appointment Details:</h2>");
            reportContent.append("Doctor: ").append(appointment.getDoctorName()).append("<br>");
            reportContent.append("Date: ").append(appointment.getDate()).append("<br>");
            reportContent.append("Time: ").append(appointment.getTime()).append("<br><br>");
        } else {
            reportContent.append("<h2>Appointment Details:</h2>");
            reportContent.append("No appointment scheduled.<br><br>");
        }

        reportContent.append("</body></html>");

        JLabel reportDetails = new JLabel(reportContent.toString());
        reportDetails.setVerticalAlignment(SwingConstants.TOP);
        panel.add(reportDetails);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> openUserDashboard());
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
