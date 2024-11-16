/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

// Packges that we areusing in this class
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class will managing al patient operations, that will include adding a
 * new patient, sorting, scheduling , search an also we will display any
 * information related
 *
 * @author Mikel
 */
public class PatientManage {// Defines the PatientManage class, which handles the management of patient information, including adding, sorting, and scheduling consultations.

    // Constants for patient file names
//    private static final String PATIENT_FILE = "patients.txt"; // Filename for storing patient details
    private static final String PATIENT_APPOINTMENTS_FILE = "patients_appointments.txt"; // Filename for storing appointment details

    // Method to manage patient-related operations through a sub-menu
    public static void managePatients(Scanner scanner, List<Patient> patients) throws IOException {
        boolean exitSubMenu = false; // Flag to control when to exit the patient management submenu
        while (!exitSubMenu) { // Loop until user chooses to exit
            // Display patient sub-menu options and get user's choice
            HospitalMenu.SubMenuPatient patientOption = HospitalMenuHandler.getPatientOption(scanner);

            // Process the chosen option using a switch statement
            switch (patientOption) {
                case Sort_Patients_List:
                    // Sorts the patients
                    handleSortPatients(scanner, patients);
                    break;
                case Search_Patients_List:
                    // Searches for patients based on user criteria
                    handleSearchPatients(scanner, patients);
                    break;
                case Add_A_New_Patient_In_The_System:
                    // Adds a new patient to the list
                    addPatient(scanner, patients);
                    break;
                case Schedule_A_New_Patient_Appointment:
                    // Schedules a consultation for a patient
                    scheduleConsultation(scanner);
                    break;
                case Display_Patients:
                    // Displays a list of scheduled appointments
                    handleShowPatientList(scanner, patients);
                    break;
                case Back_To_Main_Menu:
                    // Exits the submenu and returns to the main menu
                    System.out.println("Going back to main menu...");
                    exitSubMenu = true;
                    break;
                default:
                    // Error handling for invalid menu selection
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a new patient to the system
    public static void addPatient(Scanner scanner, List<Patient> patients) {
        System.out.println("ADD PATIENT Selected:"); // Notify user of action
        System.out.print("What is the name of the patient: ");
        String name = scanner.nextLine().trim(); // Collects patient name input

        // Get the patient's birthdate and validate its format
        System.out.print("What is the Date of Birth of the patient (Please use format yyyy-MM-dd): ");
        LocalDate dateOfBirth = null;
        while (dateOfBirth == null) { // Loop until a valid date is entered
            try {
                dateOfBirth = LocalDate.parse(scanner.nextLine().trim()); // Parses date input
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please use format yyyy-MM-dd: "); // Error prompt
            }
        }

        // Get patient address
        System.out.print("What is the address of the patient: ");
        String address = scanner.nextLine().trim(); // Trims extra spaces from input

        // Get patient's medical issue
        System.out.print("What is the medical issue of the patient: ");
        String medicalIssue = scanner.nextLine().trim();

        // Prompt for and select the medical department for the patient
        DepartmentType.DepartmentOption departmentOption = null;
        while (departmentOption == null) { // Loop until a valid option is selected
            System.out.println("Select the medical department:");
            DepartmentType.DepartmentOption[] departmentDepartmentOptions = DepartmentType.DepartmentOption.values();
            for (int i = 0; i < departmentDepartmentOptions.length; i++) {
                System.out.println((i + 1) + ". " + departmentDepartmentOptions[i].name()); // Display options
            }
            System.out.print("Please enter your choice: ");
            try {
                int deptChoice = Integer.parseInt(scanner.nextLine().trim()); // Convert input to integer
                departmentOption = departmentDepartmentOptions[deptChoice - 1]; // Selects option
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid choice. Please enter a valid number."); // Error prompt
            }
        }

        // Get the doctor’s name for the patient
        System.out.print("Enter the doctor name: ");
        String doctorName = scanner.nextLine().trim();
        // Create a new Patient object using provided information
        Patient newPatient = new Patient(name, dateOfBirth, address, medicalIssue, departmentOption, doctorName, null, null, null, "Unpaid");

        // Show patient details for confirmation
        System.out.println("\nPlease review the patient details:");
        displayPatientDetails(newPatient); // Display patient details before confirmation
        System.out.print("Are these details correct? (yes/no): ");
        // getting the confirmation form the use using the method the I created in the main menu for validate others parts also
        String confirmation = HospitalApp.getValidResponse(scanner);

        if (confirmation.equalsIgnoreCase("yes")) {
            patients.add(newPatient); // Add new patient to the list only after confirmation
            System.out.println("\nThe new patient details confirmed!");

            // Ask if the user wants to schedule a consultation immediately for the new patient
            System.out.print("Would you like to schedule a consultation for this patient now? (yes/no): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("yes")) {
                // Schedule consultation if user says "yes"
                scheduleConsultationForPatient(scanner, newPatient);
            } else {
                // Save patient details to the file if no consultation is scheduled
                try {
                    HospitalFileManage.writePatientToFile(newPatient, "patients.txt");
                    System.out.println("Patient details saved to patient file.");
                } catch (IOException e) {
                    System.out.println("Error saving patient details to file: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Patient details not saved.");
        }

    }

    // Method to handle scheduling a new consultation for any patient
    public static void scheduleConsultation(Scanner scanner) {
        System.out.println("Schedule Appointment Selected:"); // Notify user of action

        // Prompt and retrieve patient details needed for scheduling
        System.out.print("Enter the name of the patient: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter the Date of Birth of the patient (format yyyy-MM-dd): ");
        LocalDate dateOfBirth = null;
        while (dateOfBirth == null) {
            try {
                dateOfBirth = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please use format yyyy-MM-dd: ");
            }
        }

        System.out.print("Enter the address of the patient: ");
        String address = scanner.nextLine().trim();

        System.out.print("Enter the medical issue of the patient: ");
        String medicalIssue = scanner.nextLine().trim();

        // Select medical department for the consultation
        DepartmentType.DepartmentOption departmentDepartmentOption = null;
        while (departmentDepartmentOption == null) {
            System.out.println("Select the medical department:");
            DepartmentType.DepartmentOption[] departmentDepartmentOptions = DepartmentType.DepartmentOption.values();
            for (int i = 0; i < departmentDepartmentOptions.length; i++) {
                System.out.println((i + 1) + ". " + departmentDepartmentOptions[i].name());
            }
            System.out.print("Please enter your choice: ");
            try {
                int deptChoice = Integer.parseInt(scanner.nextLine().trim());
                departmentDepartmentOption = departmentDepartmentOptions[deptChoice - 1];
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }

        // Enter doctor’s name
        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine().trim();

        // Get and validate the date of consultation
        LocalDate appointmentDate = null;
        while (appointmentDate == null) {
            System.out.print("Enter the date of the consultation (format yyyy-MM-dd): ");
            try {
                appointmentDate = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use format yyyy-MM-dd.");
            }
        }

        // Get and validate the time of consultation
        LocalTime appointmentTime = null;
        while (appointmentTime == null) {
            System.out.print("Enter the time of the consultation (format HH:mm): ");
            try {
                appointmentTime = LocalTime.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use format HH:mm.");
            }
        }

        // Get and validate the consultation fee
        System.out.print("Enter consultation fee: ");
        BigDecimal consultationFee = null;
        while (consultationFee == null) {
            try {
                consultationFee = new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input, please enter a valid consultation fee: ");
            }
        }

        // Get and validate the patient's health insurance status
        String healthInsuranceStatus = "";
        while (!healthInsuranceStatus.equalsIgnoreCase("Active") && !healthInsuranceStatus.equalsIgnoreCase("Inactive")) {
            System.out.print("Enter the medical insurance status (Active/Inactive): ");
            healthInsuranceStatus = scanner.nextLine().trim();
            if (!healthInsuranceStatus.equalsIgnoreCase("Active") && !healthInsuranceStatus.equalsIgnoreCase("Inactive")) {
                System.out.println("Invalid input. Please enter 'Active' or 'Inactive'.");
            }
        }

        // Create a new Patient object with consultation details
        Patient newPatient = new Patient(name, dateOfBirth, address, medicalIssue, departmentDepartmentOption, doctorName, consultationFee, appointmentDate, appointmentTime, healthInsuranceStatus);

        // Display confirmation of scheduled consultation
        System.out.println("\nConsultation scheduled successfully!\n");
        displayPatientDetails(newPatient);

        // Save consultation details to appointment file
        try {
            HospitalFileManage.writeAppointmentToFile(newPatient, "patients_appointments.txt");
            System.out.println("Consultation appointment saved to appointment file.");
        } catch (IOException e) {
            System.out.println("Error saving appointment details to file: " + e.getMessage());
        }
    }

    // Method to handle scheduling a consultation specifically for an existing patient
    public static void scheduleConsultationForPatient(Scanner scanner, Patient patient) {
        System.out.println("SCHEDULING CONSULTATION FOR EXISTING PATIENT:");
        System.out.println("Patient Name: " + patient.getName());

        // Get and validate the date of consultation
        LocalDate appointmentDate = null;
        while (appointmentDate == null) {
            System.out.print("Enter the date of the consultation (format yyyy-MM-dd): ");
            try {
                appointmentDate = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use format yyyy-MM-dd.");
            }
        }

        // Get and validate the time of consultation
        LocalTime appointmentTime = null;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        while (appointmentTime == null) {
            System.out.print("Enter the time of the consultation (format HH:mm): ");
            try {
                appointmentTime = LocalTime.parse(scanner.nextLine().trim(), timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use format HH:mm.");
            }
        }

        // Get and validate the consultation fee
        BigDecimal consultationFee = null;
        while (consultationFee == null) {
            System.out.print("Enter the consultation fee: ");
            try {
                consultationFee = new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid consultation fee.");
            }
        }

        // Get and validate the payment status
        String medicalInsuranceStatus = "";
        while (!medicalInsuranceStatus.equalsIgnoreCase("Active") && !medicalInsuranceStatus.equalsIgnoreCase("Inactive")) {
            System.out.print("Enter the medical insurance status (Active/Inactive): ");
            medicalInsuranceStatus = scanner.nextLine().trim();
            if (!medicalInsuranceStatus.equalsIgnoreCase("Active") && !medicalInsuranceStatus.equalsIgnoreCase("Inactive")) {
                System.out.println("Invalid input. Please enter 'Active' or 'Inactive'.");
            }
        }

        // Update patient with consultation details
        patient.setAppointmentDate(appointmentDate);
        patient.setAppointmentTime(appointmentTime);
        patient.setConsultationFee(consultationFee);
        patient.setMedicalInsuranceStatus(medicalInsuranceStatus);

        System.out.println("\nConsultation scheduled successfully for " + patient.getName() + "!\n");

        // Save consultation details to the appointment file
        try {
            HospitalFileManage.writeAppointmentToFile(patient, PATIENT_APPOINTMENTS_FILE);
            System.out.println("Consultation appointment saved to appointment file.");
        } catch (IOException e) {
            System.out.println("Error saving appointment details to file: " + e.getMessage());
        }
    }

    // Method to display a list of sorted patients and prompt to export them
    public static void sortOptionsPatients(Scanner scanner, List<Patient> patients, boolean showExportPrompt) {
        // Display sorting options and get user choice
        HospitalMenu.SortOption sortOption = HospitalMenuHandler.getSortOptions(scanner);

        if (sortOption == HospitalMenu.SortOption.Sort_By_Name) {
            patients = SortingAlgorithm.mergeSortPatients(patients); // Sort_Patients_List patients alphabetically
            displaySortedPatients(patients, 20, scanner); // Display sorted list

            if (showExportPrompt) { // Optionally prompt for exporting sorted list
                System.out.println("Would you like to export the sorted list of patients to 'sorted_patients.txt'? (yes/no)");
                String exportResponse = HospitalApp.getValidResponse(scanner);
                if (exportResponse.equalsIgnoreCase("yes")) {
                    HospitalFileManage.exportSortedPatientsToFile(patients); // Export if user confirms
                } else {
                    System.out.println("Export operation cancelled.");
                }
            }
        } else {
            System.out.println("Invalid option. Please try again."); // Invalid choice handler
        }
    }

    // Method to handle search options for patients and display results
    public static void searchOptionsPatients(Scanner scanner, List<Patient> patients) {
        HospitalMenu.SearchOption searchOption = HospitalMenuHandler.getSearchOptions(scanner);
        if (Objects.requireNonNull(searchOption) == HospitalMenu.SearchOption.Search_By_Name) {
            try {
                System.out.print("Enter name to search: ");
                String patientSearchName = scanner.nextLine().trim();

                patients = SortingAlgorithm.mergeSortPatients(patients); // Sort_Patients_List patients to enable efficient search

                String result = SearchingAlgorithm.searchPatientsByName(patients, patientSearchName); // Search result

                System.out.println(result); // Display search result
            } catch (Exception e) {
                System.out.println("Error searching for patient: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid option. Please try again."); // Invalid choice handler
        }
    }

// Method to sort patients and handle user responses to sorted patient list
    public static void handleSortPatients(Scanner scanner, List<Patient> patients) {
        System.out.println("SORT PATIENTS Selected:");

        if (patients.isEmpty()) { // Check if list is empty
            System.out.println("The patient list is empty. Do you want to populate the system with initial data? (yes/no)");
            String response = HospitalApp.getValidResponse(scanner);

            if (response.equalsIgnoreCase("yes")) {
                addPatient(scanner, patients); // Adds data if user agrees
                System.out.print("\nWould you like to proceed with the sort options? (yes/no): ");
                String proceedResponse = HospitalApp.getValidResponse(scanner);
                if (proceedResponse.equalsIgnoreCase("yes")) {
                    sortOptionsPatients(scanner, patients, true);
                } else {
                    System.out.println("Sort operation cancelled.");
                }
            } else {
                System.out.println("Cannot sort an empty list."); // Alert for empty list
            }
        } else {
            // Sort_Patients_List and display options directly on the list in memory
            sortOptionsPatients(scanner, patients, false);
        }
    }

    // Method to search for patients and manage search results
    public static void handleSearchPatients(Scanner scanner, List<Patient> patients) {
        System.out.println("SEARCH PATIENTS Selected:");

        if (patients.isEmpty()) {
            System.out.println("Patient list is empty. Please add patients first.");
            return;
        }

        searchOptionsPatients(scanner, patients); // Perform the search

    }

    // Method to handle showing different patient lists, like sorted patient lists or appointment lists
    public static void handleShowPatientList(Scanner scanner, List<Patient> patients) {
        HospitalMenu.DisplayListOptionPatients showListOptionPatient = HospitalMenuHandler.getShowListOptionsPatients(scanner);
        switch (showListOptionPatient) {
            case Display_Sorted_Patients_List:

                if (patients.isEmpty()) {
                    System.out.println("\nThe patient list is empty.");
                } else {
                    patients = SortingAlgorithm.mergeSortPatients(patients); // Sort_Patients_List patients
                    System.out.println("\nSorted Patient list: ");
                    displaySortedPatients(patients, 20, scanner);
                }
                break;
            case Display_Sorted_Patients_Schedules_List:
                if (patients.isEmpty()) {
                    System.out.println("\nThe patient list is empty.");
                } else {
                    patients = SortingAlgorithm.mergeSortPatients(patients);
                    System.out.println("\nSorted Patient list: ");
                    displaySortedAppointment(patients, 20, scanner);
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

// Method to display the details of a specific patient
    public static void displayPatientDetails(Patient patient) {
        System.out.println("Name: " + patient.getName());
        System.out.println("Date of Birth: " + patient.getDateOfBirth());
        System.out.println("Address: " + patient.getAddress());
        System.out.println("Medical Issue: " + patient.getMedicalIssue());
        System.out.println("Medical Department: " + patient.getMedicalDepartment().name());
        System.out.println("Doctor: " + patient.getDoctorName());

        // Print appointment details only if the appointment is scheduled
        if (patient.getAppointmentDate() != null) {
            System.out.println("Appointment Date: " + patient.getAppointmentDate());
            System.out.println("Appointment Time: " + patient.getAppointmentTime());
            System.out.println("Consultation Fee: " + patient.getConsultationFee());
            System.out.println("Medical Insurance Status: " + patient.getMedicalInsuranceStatus());
        }
    }

    // Method to display a list of sorted patients and prompt for file export
    public static void displaySortedPatients(List<Patient> patients, int limit, Scanner scanner) {
        System.out.println("\nSorted patients: \n");
        for (int i = 0; i < limit && i < patients.size(); i++) { // Loop to limit displayed patients
            Patient patient = patients.get(i);
            System.out.println("Name: " + patient.getName());
            System.out.println("Date of Birth: " + patient.getDateOfBirth());
            System.out.println("Address: " + patient.getAddress());
            System.out.println("Medical Issue: " + patient.getMedicalIssue());
            System.out.println("Medical Department: " + patient.getMedicalDepartment().name());
            System.out.println("Doctor: " + (patient.getDoctorName() != null ? patient.getDoctorName() : "N/A"));

            // Only display appointment details if they are available
            if (patient.getAppointmentDate() != null) {
                System.out.println("Appointment Date: " + patient.getAppointmentDate());
                System.out.println("Appointment Time: " + patient.getAppointmentTime());
                System.out.println("Consultation Fee: " + patient.getConsultationFee());
                System.out.println("Medical Insurance Status: " + (patient.getMedicalInsuranceStatus() != null ? patient.getMedicalInsuranceStatus() : "Not available"));
            }

            System.out.println(); // Empty line for readability between patients
        }

        System.out.print("Would you like to export the sorted patient list to 'sorted_patients.txt'? (yes/no): ");
        String response = scanner.nextLine().trim();
        if (response.equalsIgnoreCase("yes")) {
            HospitalFileManage.exportSortedPatientsToFile(patients); // Exports the list if user confirms
        } else {
            System.out.println("Export operation cancelled.");
        }
    }

    // Method to display a list of sorted appointment schedules
    public static void displaySortedAppointment(List<Patient> patients, int limit, Scanner scanner) {
        System.out.println("\nAppointment list: \n");
        for (int i = 0; i < limit && i < patients.size(); i++) { // Loop to display up to specified limit
            Patient patient = patients.get(i);
            System.out.println("Name: " + patient.getName());
            System.out.println("Date of Birth: " + patient.getDateOfBirth());
            System.out.println("Address: " + patient.getAddress());
            System.out.println("Medical Issue: " + patient.getMedicalIssue());
            System.out.println("Medical Department: " + patient.getMedicalDepartment().name());
            System.out.println("Doctor: " + patient.getDoctorName());

            if (patient.getAppointmentDate() != null) {
                System.out.println("Appointment Date: " + patient.getAppointmentDate());
                System.out.println("Appointment Time: " + patient.getAppointmentTime());
                System.out.println("Medical Insurance Status: " + patient.getMedicalInsuranceStatus());
            }

            System.out.println(); // Empty line for readability between appointments
        }

        System.out.print("Would you like to export the sorted appointment list to 'sorted_appointments.txt'? (yes/no): ");
        String response = scanner.nextLine().trim();
        while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            response = scanner.nextLine().trim();
        }
        if (response.equalsIgnoreCase("yes")) {
            HospitalFileManage.exportSortedAppointmentsToFile(patients); // Export appointments if confirmed
        } else {
            System.out.println("Export operation cancelled.");
        }
    }

}
