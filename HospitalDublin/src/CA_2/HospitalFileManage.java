/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// This is the package to which the class HospitalFileManage belongs

import java.io.BufferedReader; // This imports for efficient reading of text from an input stream.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader; // This imports for reading data from files.
import java.io.FileWriter;
import java.io.IOException; // This imports to handle input and output exceptions.
import java.math.BigDecimal; // This imports for precise calculations with decimal numbers, ideal for financial values.
import java.time.LocalDate; // This imports for date manipulation (without time).
import java.time.LocalTime; // This imports for time manipulation (without date).
import java.time.format.DateTimeParseException; // This imports to handle date/time format errors.
import java.util.ArrayList; // This imports to use a resizable list.
import java.util.List; // This imports the List interface to manage collections of objects.

/**
 ** Class for managing file operations such as reading data and creating lists
 * of employees and patients.
 *
 * @author Mikel
 */
public class HospitalFileManage {
//  This file was created into the project folder to exported sorted exployees

    private static final String SORTED_EMPLOYEES_FILE = "sorted_employees.txt";
    //  This file was created into the project folder to exported sorted patients
    private static final String SORTED_PATIENTS_FILE = "sorted_patients.txt";

//  This class Reads the employee file and returns a list of Employee
    public static List<Employee> readEmployeesFile(String employeeFileName) throws IOException {
        List<Employee> employees = new ArrayList<>(); // Create a list to store employees.

        // Check if the file exists and create it if it doesn’t
        File file = new File(employeeFileName);
        if (!file.exists()) {
            System.out.println("File '" + employeeFileName + "' not found. \nCreating a new file....");
            file.createNewFile(); // Create a new empty file if it doesn’t exist
        }

        try (BufferedReader br = new BufferedReader(new FileReader(employeeFileName))) { // Open the file for reading.
            String line; // variable to store each line read from the file.

            // These variables to temporarily store employee data before creating an Employee object.
            String name = null;
            LocalDate dateOfBirth = null;
            String address = null;
            BigDecimal salary = null;
            DepartmentType.DepartmentOption departmentOption = null;
            RoleType.RoleOption managerOption = null;
            PositionType.PositionOption positionOption = null;
            EmployeeType.EmployeeOption employeeType = null;

            // Read each line of the file until the end.
            // Loop through each line of the file
            while ((line = br.readLine()) != null) {
                // Check for a blank line, indicating the end of an employee's data
                if (line.trim().isEmpty()) {
                    // If all mandatory fields are set, create a new Employee object
                    if (name != null && dateOfBirth != null && address != null && salary != null
                            && departmentOption != null && managerOption != null && positionOption != null && employeeType != null) {

                        // Create a basic Employee object with common attributes
                        Employee employee = new Employee(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, employeeType);

                        // Add the created Employee object to the employees list
                        employees.add(employee);
                    }

                    // Reset all variables for the next employee entry in the file
                    name = null;
                    dateOfBirth = null;
                    address = null;
                    salary = null;
                    departmentOption = null;
                    managerOption = null;
                    positionOption = null;
                    employeeType = null;
                    continue; // Move to the next line
                }

                // Check the prefix of the line to store the corresponding field value.
                if (line.startsWith("Name: ")) { // Check if the line starts with "Name: ".
                    name = line.substring(6).trim(); // Extract and store the name.
                } else if (line.startsWith("Date of Birth: ")) { // Check if the line starts with "Date of Birth: ".
                    try {
                        dateOfBirth = LocalDate.parse(line.substring(15).trim()); // Try to parse the birth date.
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format for line: " + line); // Error message for invalid date format.
                    }
                } else if (line.startsWith("Address: ")) {
                    address = line.substring(9).trim(); // Extract and trim address
                } else if (line.startsWith("Salary: ")) {
                    try {
                        String salaryStr = line.substring(8).trim().replace(" EUR", ""); // Remove currency symbol
                        salary = new BigDecimal(salaryStr); // Parse salary as BigDecimal
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format for line: " + line);
                    }
                } else if (line.startsWith("Department: ")) {
                    try {
                        departmentOption = DepartmentType.DepartmentOption.valueOf(line.substring(12).trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid department type for line: " + line);
                    }
                } else if (line.startsWith("Role: ")) {
                    try {
                        managerOption = RoleType.RoleOption.valueOf(line.substring(6).trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid role type for line: " + line);
                    }
                } else if (line.startsWith("Position: ")) {
                    try {
                        positionOption = PositionType.PositionOption.valueOf(line.substring(10).trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid position type for line: " + line);
                    }
                } else if (line.startsWith("Employee Type: ")) {
                    // Parse and set employee type
                    employeeType = EmployeeType.EmployeeOption.valueOf(line.substring(15).trim().toUpperCase());
                }
            }

            // Handle the last entry if the file does not end with a blank line
            if (name != null && dateOfBirth != null && address != null && salary != null
                    && departmentOption != null && managerOption != null && positionOption != null && employeeType != null) {

                // Create and add the last Employee object based on common attributes
                Employee employee = new Employee(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, employeeType);
                employees.add(employee); // Add last employee entry to list
            }

        } catch (IOException e) {
            // Print error message and rethrow exception to be handled by calling method
            System.out.println("Error reading employee file: " + e.getMessage());
            throw e;
        }

        return employees; // Return the list of Employee objects
    }

//This file reads the patient file and returns a list of Patient objects.
    public static List<Patient> readPatientsFile(String patientFileName) throws IOException {
        List<Patient> patients = new ArrayList<>(); // Create a list to store patients.

        // Check if the file exists and create it if it doesn’t
        File file = new File(patientFileName);
        if (!file.exists()) {
            System.out.println("File '" + patientFileName + "' not found. \nCreating a new file....");
            file.createNewFile(); // Create a new empty file if it doesn’t exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(patientFileName))) { // Open the file for reading.
            String line; // Variable to store each line read from the file.

            // Variables to temporarily store patient data before creating a Patient object.
            String name = null;
            LocalDate dateOfBirth = null;
            String address = null;
            String medicalIssue = null;
            DepartmentType.DepartmentOption departmentOption = null;
            String doctorName = null;
            BigDecimal consultationFee = null;
            LocalDate appointmentDate = null;
            LocalTime appointmentTime = null;
            String healthInsuranceStatus = "Active"; // Default status for health insurance.

            // Read each line of the file until the end.
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) { // Check if the line is empty (indicates the end of a patient record).
                    // If all mandatory fields are filled, create and add the corresponding Patient object.
                    if (name != null && dateOfBirth != null && address != null && medicalIssue != null && departmentOption != null) {
                        patients.add(new Patient(name, dateOfBirth, address, medicalIssue, departmentOption, doctorName, consultationFee != null ? consultationFee : BigDecimal.ZERO, appointmentDate, appointmentTime, healthInsuranceStatus));
                    }
                    // Reset the variables for the next patient record.
                    name = null;
                    dateOfBirth = null;
                    address = null;
                    medicalIssue = null;
                    departmentOption = null;
                    doctorName = null;
                    consultationFee = null;
                    appointmentDate = null;
                    appointmentTime = null;
                    healthInsuranceStatus = "Inactive"; // Reset the status for the next patient.
                    continue; // Continue to the next iteration of the loop.
                }

                // Check the prefix of the line to store the corresponding field value.
                if (line.startsWith("Name: ")) { // Check if the line starts with "Name: ".
                    name = line.substring(6).trim(); // Extract and store the name.
                } else if (line.startsWith("Date of Birth: ")) { // Check if the line starts with "Date of Birth: ".
                    try {
                        dateOfBirth = LocalDate.parse(line.substring(15).trim()); // Try to parse the birth date.
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format for line: " + line); // Error message for invalid date format.
                    }
                } else if (line.startsWith("Address: ")) { // Check if the line starts with "Address: ".
                    address = line.substring(9).trim(); // Extract and store the address.
                } else if (line.startsWith("Medical Issue: ")) { // Check if the line starts with "Medical Issue: ".
                    medicalIssue = line.substring(15).trim(); // Extract and store the medical issue.
                } else if (line.startsWith("Medical DepartmentOption: ")) { // Check if the line starts with "Medical DepartmentOption: ".
                    try {
                        departmentOption = DepartmentType.DepartmentOption.valueOf(line.substring(23).trim().toUpperCase()); // Try to parse the medical department type.
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid department type for line: " + line); // Error message for invalid department type.
                    }
                } else if (line.startsWith("Doctor: ")) { // Check if the line starts with "Doctor: ".
                    doctorName = line.substring(8).trim(); // Extract and store the doctor's name.
                } else if (line.startsWith("Consultation Fee: ")) { // Check if the line starts with "Consultation Fee: ".
                    String feeStr = line.substring(18).trim(); // Extract and trim the consultation fee
                    if (!feeStr.isEmpty() && !feeStr.equalsIgnoreCase("null")) { // Check if the string is not empty or "null" before attempting to parse
                        try {
                            consultationFee = new BigDecimal(feeStr); // Try to parse the consultation fee
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid consultation fee format for line: " + line); // Error message for invalid consultation fee format
                        }
                    }
                } else if (line.startsWith("Appointment Date: ")) { // Check if the line starts with "Appointment Date: ".
                    String dateStr = line.substring(17).trim(); // Extract and trim the appointment date
                    if (!dateStr.isEmpty() && !dateStr.equalsIgnoreCase("null")) { // Check if the string is not empty or "null" before attempting to parse
                        try {
                            appointmentDate = LocalDate.parse(dateStr); // Try to parse the appointment date
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid appointment date format for line: " + line); // Error message for invalid appointment date format
                        }
                    }
                } else if (line.startsWith("Appointment Time: ")) { // Check if the line starts with "Appointment Time: ".
                    String timeStr = line.substring(17).trim(); // Extract and trim the appointment time
                    if (!timeStr.isEmpty() && !timeStr.equalsIgnoreCase("null")) { // Check if the string is not empty or "null" before attempting to parse
                        try {
                            appointmentTime = LocalTime.parse(timeStr); // Try to parse the appointment time
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid appointment time format for line: " + line); // Error message for invalid appointment time format
                        }
                    }
                } else if (line.startsWith("Payment Status: ")) { // Check if the line starts with "Payment Status: ".
                    healthInsuranceStatus = line.substring(15).trim(); // Extract and store the health insurance status
                }

            }

            // Add the last patient read from the file if all mandatory fields are present.
            if (name != null && dateOfBirth != null && address != null && medicalIssue != null && departmentOption != null) {
                patients.add(new Patient(name, dateOfBirth, address, medicalIssue, departmentOption, doctorName, consultationFee != null ? consultationFee : BigDecimal.ZERO, appointmentDate, appointmentTime, healthInsuranceStatus));
            }

        } catch (IOException e) {
            System.out.println("Error reading patient file: " + e.getMessage()); // Print an error message if file reading fails.
            throw e; // Throw the exception to be handled by the caller of the method.
        }
        return patients; // Return the list of patients.
    }

//This method read the applicants_form.txt and returns the lines as a list of strings.
    public static List<String> readApplicantsForm(String fileName) throws IOException {
        List<String> lines = new ArrayList<>(); // Create a list to store the lines from the file.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { // Open the file for reading.
            String line; // Variable to store each line read from the file.

            // Read each line from the file and add it to the list.
            while ((line = br.readLine()) != null) {
                lines.add(line.trim()); // Trim whitespace from each line before adding.
            }
        } catch (IOException e) {
            System.out.println("Error reading applicants form: " + e.getMessage()); // Print an error message if file reading fails.
        }
        return lines; // Return the list of lines from the file.
    }

//  This method will read a file containing names and returns a list of names.
    public static List<String> readNamesForSorting(String fileName) throws IOException {
        List<String> names = new ArrayList<>(); // List to store names from the file.
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // Open the file for reading.
            String line; // Variable to store each line read from the file.
            while ((line = reader.readLine()) != null) { // Read each line of the file until the end.
                if (!line.trim().isEmpty()) { // Check if the line is not empty after trimming spaces.
                    names.add(line.trim()); // Add the trimmed line (name) to the list.
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading names for sorting: " + e.getMessage()); // Error message if the reading fails.
        }
        return names; // Return the list of names.
    }

//    Exports a sorted list of patients to a file.
    public static void exportSortedPatientsToFile(List<Patient> patients) {
        try {
            // Clears the content of the SORTED_PATIENTS_FILE before writing new data.
            clearAllFiles(SORTED_PATIENTS_FILE);

            // Iterate through each patient in the list.
            for (Patient patient : patients) {
                // Writes each patient's information to the SORTED_PATIENTS_FILE.
                writePatientToFile(patient, SORTED_PATIENTS_FILE);
            }

            // Print a success message after exporting the list.
            System.out.println("Sorted patient list exported successfully to 'sorted_patients.txt'.");
        } catch (IOException e) {
            // Print an error message if an I/O error occurs.
            System.out.println("Error exporting sorted patient list: " + e.getMessage());
        }
    }

//    Exports a sorted list of employees to a file.
    public static void exportSortedEmployeesToFile(List<Employee> employees) {
        try {
            // Clears the content of the SORTED_EMPLOYEES_FILE before writing new data.
            clearAllFiles(SORTED_EMPLOYEES_FILE);

            // Iterate through each employee in the list.
            for (Employee employee : employees) {
                // Writes each employee's information to the SORTED_EMPLOYEES_FILE.
                writeEmployeeToFile(employee, SORTED_EMPLOYEES_FILE);
            }

            // Print a success message after exporting the list.
            System.out.println("Sorted list of employees exported successfully to " + SORTED_EMPLOYEES_FILE);
        } catch (IOException e) {
            // Print an error message if an I/O error occurs.
            System.out.println("Error exporting sorted employees to file: " + e.getMessage());
        }
    }

//   Exports a sorted list of patient appointments to a file.
    public static void exportSortedAppointmentsToFile(List<Patient> appointments) {
        try {
            // Clears the content of the "sorted_appointments.txt" file before writing new data.
            clearAllFiles("sorted_appointments.txt");

            // Iterate through each appointment in the list.
            for (Patient appointment : appointments) {
                // Writes each appointment's information to the "sorted_appointments.txt" file.
                writeAppointmentToFile(appointment, "sorted_appointments.txt");
            }

            // Print a success message after exporting the list.
            System.out.println("Sorted appointment list exported successfully to 'sorted_appointments.txt'.");
        } catch (IOException e) {
            // Print an error message if an I/O error occurs.
            System.out.println("Error exporting sorted appointment list: " + e.getMessage());
        }
    }

//  In this method created will write the employee information to a file created into the project folder
    public static void writeEmployeeToFile(Employee employee, String filePath) throws IOException {
        // Use BufferedWriter to write employee data to a file, appending to existing content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Write general employee details common to all employees
            writer.write("Name: " + employee.getName() + "\n"); // Employee name
            writer.write("Date of Birth: " + employee.getDateOfBirth() + "\n"); // Date of birth
            writer.write("Address: " + employee.getAddress() + "\n"); // Employee address
            writer.write("Salary: " + employee.getSalary() + "\n"); // Salary with EUR currency symbol
            writer.write("Department: " + employee.getDepartmentType().name() + "\n"); // Department type
            writer.write("Role: " + employee.getManagerType().name() + "\n"); // Role within the department
            writer.write("Position: " + employee.getPositionType().name() + "\n"); // Job position
            writer.write("Type: " + employee.getEmployeeOption().name() + "\n"); // Write employee type

            // Check if the employee is a nurse and add shift details if available
            if (employee.getEmployeeOption() == EmployeeType.EmployeeOption.NURSE) {
                writer.write("Shift: " + (employee.getShift() != null ? employee.getShift() : "N/A") + "\n");
            }

            // Add a blank line after each employee entry to separate them in the file
            writer.write("\n");
        }
    }

// This method will write the patient information to a file created into the project folder
    public static void writePatientToFile(Patient patient, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Open the file for writing, appending new data.
            // Write general patient information to the file.
            writer.write("Name: " + patient.getName() + "\n");
            writer.write("Date of Birth: " + patient.getDateOfBirth() + "\n");
            writer.write("Address: " + patient.getAddress() + "\n");
            writer.write("Medical Issue: " + patient.getMedicalIssue() + "\n");
            writer.write("Medical Department: " + patient.getMedicalDepartment().name() + "\n");
            writer.write("Doctor: " + patient.getDoctorName() + "\n");
            writer.write("Consultation Fee: " + patient.getConsultationFee() + "\n");
            writer.write("Appointment Date: " + patient.getAppointmentDate() + "\n");
            writer.write("Appointment Time: " + patient.getAppointmentTime() + "\n");
            writer.write("Medical Insurance Status: " + patient.getMedicalInsurancetatus() + "\n");
            writer.write("\n"); // Add a blank line between patient entries.
        }
    }

// And this method will write the patient appointment to a file created into the project folder
    public static void writeAppointmentToFile(Patient patient, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Open the file for writing, appending new data.
            // Write patient appointment information to the file.
            writer.write("Name: " + patient.getName() + "\n");
            writer.write("Date of Birth: " + patient.getDateOfBirth() + "\n");
            writer.write("Address: " + patient.getAddress() + "\n");
            writer.write("Medical Issue: " + patient.getMedicalIssue() + "\n");
            writer.write("Medical Department: " + patient.getMedicalDepartment().name() + "\n");
            writer.write("Doctor: " + patient.getDoctorName() + "\n");
            writer.write("Consultation Fee: " + patient.getConsultationFee() + "\n");
            writer.write("Appointment Date: " + patient.getAppointmentDate() + "\n");
            writer.write("Appointment Time: " + patient.getAppointmentTime() + "\n");
            writer.write("Medical Insurance Status: " + patient.getMedicalInsurancetatus() + "\n");
            writer.write("\n"); // Add a blank line between appointment entries.
        }
    }

//    Clears the content of the specified file.
    public static void clearAllFiles(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("Error clearing the file: " + e.getMessage());
        }
    }
}
