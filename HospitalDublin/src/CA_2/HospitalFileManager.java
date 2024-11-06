/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// This is the package to which the class HospitalFileManager belongs

import java.io.BufferedReader; // This imports for efficient reading of text from an input stream.
import java.io.FileReader; // This imports for reading data from files.
import java.io.IOException; // This imports to handle input and output exceptions.
import java.math.BigDecimal; // This imports for precise calculations with decimal numbers, ideal for financial values.
import java.time.LocalDate; // This imports for date manipulation (without time).
import java.time.LocalTime; // This imports for time manipulation (without date).
import java.time.format.DateTimeParseException; // This imports to handle date/time format errors.
import java.util.ArrayList; // This imports to use a resizable list.
import java.util.List; // This imports the List interface to manage collections of objects.
    
/**
 ** Class for managing file operations such as reading 
 * data and creating lists of employees and patients.
 * @author Mikel
 */
public class HospitalFileManager {

    /**
     * This class Reads the employee file and returns a list of Employee objects.
     * @param fileName The name of the file to be read.
     * @return List of Employee objects.
     * @throws IOException If an I/O error occurs.
     */
    public static List<Employee> readEmployeesFile(String fileName) throws IOException {
        List<Employee> employees = new ArrayList<>(); // Create a list to store employees.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { // Open the file for reading.
            String line; // variable to store each line read from the file.

            // These variables to temporarily store employee data before creating an Employee object.
            String name = null;
            LocalDate dateOfBirth = null;
            String address = null;
            BigDecimal salary = null;
            DepartmentType.DepartmentOption departmentOption = null;
            ManagerType.ManagerOption managerOption = null;
            PositionType.PositionOption positionOption = null;
            String type = null;
            String specialty = null;
            String licenseNumber = null;
            String shift = null;
            String specialization = null;
            String role = null;
            String jobDescription = null;

            // Read each line of the file until the end.
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) { // Check if the line is empty (indicates the end of an employee record).
                    // If all mandatory fields are filled, create and add the corresponding Employee object.
                    if (name != null && dateOfBirth != null && address != null && salary != null && departmentOption != null && managerOption != null && positionOption != null) {
                        switch (type) { // Check the type of employee to create the specific object.
                            case "Doctor":
                                employees.add(new Doctor(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, specialty, licenseNumber));
                                break;
                            case "Nurse":
                                employees.add(new Nurse(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, shift, specialization));
                                break;
                            case "AdministrativeAssistant":
                                employees.add(new AdministrativeAssistant(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, role));
                                break;
                            case "GeneralStaff":
                                employees.add(new GeneralStaff(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, jobDescription));
                                break;
                            default: // If there is no specific type, create a generic Employee object.
                                employees.add(new Employee(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption));
                        }
                    }
                    // Reset the variables for the next employee record.
                    name = null;
                    dateOfBirth = null;
                    address = null;
                    salary = null;
                    departmentOption = null;
                    managerOption = null;
                    positionOption = null;
                    type = null;
                    specialty = null;
                    licenseNumber = null;
                    shift = null;
                    specialization = null;
                    role = null;
                    jobDescription = null;
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
                } else if (line.startsWith("Salary: ")) { // Check if the line starts with "Salary: ".
                    try {
                        String salaryStr = line.substring(8).trim().replace(" EUR", ""); // Remove currency, if present.
                        salary = new BigDecimal(salaryStr); // Convert and store the salary.
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format for line: " + line); // Error message for invalid salary format.
                    }
                } else if (line.startsWith("Department: ")) { // Check if the line starts with "Department: ".
                    try {
                        departmentOption = DepartmentType.DepartmentOption.valueOf(line.substring(11).trim().toUpperCase()); // Try to parse the department type.
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid department type for line: " + line); // Error message for invalid department type.
                    }
                } else if (line.startsWith("Manager: ")) { // Check if the line starts with "Manager: ".
                    try {
                        managerOption = ManagerType.ManagerOption.valueOf(line.substring(9).trim().toUpperCase()); // Try to parse the manager type.
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid manager type for line: " + line); // Error message for invalid manager type.
                    }
                } else if (line.startsWith("Position: ")) { // Check if the line starts with "Position: ".
                    try {
                        positionOption = PositionType.PositionOption.valueOf(line.substring(10).trim().toUpperCase()); // Try to parse the position type.
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid position type for line: " + line); // Error message for invalid position type.
                    }
                } else if (line.startsWith("Type: ")) { // Check if the line starts with "Type: ".
                    type = line.substring(6).trim(); // Extract and store the employee type.
                } else if (line.startsWith("Specialty: ")) { // Check if the line starts with "Specialty: ".
                    specialty = line.substring(11).trim(); // Extract and store the specialty.
                } else if (line.startsWith("License: ")) { // Check if the line starts with "License: ".
                    licenseNumber = line.substring(9).trim(); // Extract and store the license number.
                } else if (line.startsWith("Shift: ")) { // Check if the line starts with "Shift: ".
                    shift = line.substring(7).trim(); // Extract and store the shift.
                } else if (line.startsWith("Specialization: ")) { // Check if the line starts with "Specialization: ".
                    specialization = line.substring(16).trim(); // Extract and store the specialization.
                } else if (line.startsWith("Role: ")) { // Check if the line starts with "Role: ".
                    role = line.substring(6).trim(); // Extract and store the role.
                } else if (line.startsWith("Job Description: ")) { // Check if the line starts with "Job Description: ".
                    jobDescription = line.substring(17).trim(); // Extract and store the job description.
                }
            }

            // Add the last employee read from the file if all mandatory fields are present.
            if (name != null && dateOfBirth != null && address != null && salary != null && departmentOption != null && managerOption != null && positionOption != null) {
                switch (type) { // Check the type of employee to create the specific object.
                    case "Doctor":
                        employees.add(new Doctor(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, specialty, licenseNumber));
                        break;
                    case "Nurse":
                        employees.add(new Nurse(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, shift, specialization));
                        break;
                    case "AdministrativeAssistant":
                        employees.add(new AdministrativeAssistant(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, role));
                        break;
                    case "GeneralStaff":
                        employees.add(new GeneralStaff(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption, jobDescription));
                        break;
                    default: // If there is no specific type, create a generic Employee object.
                        employees.add(new Employee(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading employee file: " + e.getMessage()); // Print an error message if file reading fails.
            throw e; // Throw the exception to be handled by the caller of the method.
        }
        return employees; // Return the list of employees.
    }

    /**
     * Reads the patient file and returns a list of Patient objects.
     * @param filePath The path of the file to be read.
     * @return List of Patient objects.
     * @throws IOException If an I/O error occurs.
     */
    public static List<Patient> readPatientsFile(String filePath) throws IOException {
        List<Patient> patients = new ArrayList<>(); // Create a list to store patients.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Open the file for reading.
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
                    try {
                        consultationFee = new BigDecimal(line.substring(18).trim()); // Try to parse the consultation fee.
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid consultation fee format for line: " + line); // Error message for invalid consultation fee format.
                    }
                } else if (line.startsWith("Appointment Date: ")) { // Check if the line starts with "Appointment Date: ".
                    try {
                        appointmentDate = LocalDate.parse(line.substring(17).trim()); // Try to parse the appointment date.
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid appointment date format for line: " + line); // Error message for invalid appointment date format.
                    }
                } else if (line.startsWith("Appointment Time: ")) { // Check if the line starts with "Appointment Time: ".
                    try {
                        appointmentTime = LocalTime.parse(line.substring(17).trim()); // Try to parse the appointment time.
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid appointment time format for line: " + line); // Error message for invalid appointment time format.
                    }
                } else if (line.startsWith("Payment Status: ")) { // Check if the line starts with "Payment Status: ".
                    healthInsuranceStatus = line.substring(15).trim(); // Extract and store the health insurance status.
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

    /**
     * Reads the applicants_form.txt and returns the lines as a list of strings.
     * @param fileName The name of the file to be read.
     * @return List of strings, each representing a line from the file.
     * @throws IOException If an I/O error occurs.
     */
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
}
