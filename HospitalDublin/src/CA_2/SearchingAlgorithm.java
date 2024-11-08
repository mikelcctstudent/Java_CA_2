/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.List;

/**
 * Method to perform a binary search on a sorted list of Employee objects by
 * name. If the name is found (even partially), it returns a formatted string of
 * the Employee details. If no match is found, it returns a message indicating
 * that the employee was not found. This method does not use StringBuilder and
 * allows partial name matches.
 *
 * @author Mikel
 */
// Class that defines searching algorithms for finding employees and patients by name
public class SearchingAlgorithm {

    public static String searchEmployeeByName(List<Employee> employees, String name) {
        int low = 0; // Start of the search range
        int high = employees.size() - 1; // End of the search range
        String result = ""; // Variable to store the search result (details of found employee(s))
        boolean found = false; // Flag to track if any matching employee was found

        // Binary search loop continues while there are items in the search range
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index of the search range
            Employee midEmployee = employees.get(mid); // Retrieve the employee at the middle index

            // Check if the middle employee's name contains the search term (case-insensitive)
            if (midEmployee.getName().toLowerCase().contains(name.toLowerCase())) {
                result += employeeDetails(midEmployee) + "\n\n"; // Append the employee details to the result string
                found = true; // Set found flag to true, indicating a match

                // Expand search to adjacent entries to check if they also match the search term
                int left = mid - 1; // Initialize left index one step before the middle
                int right = mid + 1; // Initialize right index one step after the middle

                // Check employees to the left of the middle index for partial matches
                while (left >= low && employees.get(left).getName().toLowerCase().contains(name.toLowerCase())) {
                    result += employeeDetails(employees.get(left)) + "\n\n"; // Append details of each left match
                    left--; // Move to the next employee on the left
                }

                // Check employees to the right of the middle index for partial matches
                while (right <= high && employees.get(right).getName().toLowerCase().contains(name.toLowerCase())) {
                    result += employeeDetails(employees.get(right)) + "\n\n"; // Append details of each right match
                    right++; // Move to the next employee on the right
                }
                break; // Exit the loop after finding all matching employees
            }

            // Binary search adjustment: compares search term with the middle employee's name to narrow the search range
            int comparison = name.compareToIgnoreCase(midEmployee.getName());
            if (comparison < 0) {
                high = mid - 1; // If search term is alphabetically before the mid name, adjust high to mid - 1
            } else {
                low = mid + 1; // If search term is alphabetically after the mid name, adjust low to mid + 1
            }
        }

        // If no match was found, return a not-found message
        if (!found) {
            return "Employee not found.";
        }
        return result; // Return the compiled result string with employee details
    }

    /**
     * Method to perform a binary search on a sorted list of Patient objects by
     * name. If the name is found (even partially), it returns a formatted
     * string with Patient details. If no match is found, it returns a message
     * indicating that the patient was not found. This method uses StringBuilder
     * for efficiency and allows partial name matches.
     *
     * @param patients List of Patient objects sorted by name.
     * @param name Name or part of the name to search for.
     * @return A formatted string with Patient details or a message if not
     * found.
     */
    public static String searchPatientByName(List<Patient> patients, String name) {
        int low = 0; // Start of the search range
        int high = patients.size() - 1; // End of the search range
        StringBuilder result = new StringBuilder(); // Efficient string builder to store the search result
        boolean found = false; // Flag to track if any matching patient was found

        // Binary search loop continues while there are items in the search range
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index of the search range
            Patient midPatient = patients.get(mid); // Retrieve the patient at the middle index

            // Check if the middle patient's name contains the search term (case-insensitive)
            if (midPatient.getName().toLowerCase().contains(name.toLowerCase())) {
                result.append(patientDetails(midPatient)).append("\n\n"); // Append patient details to the result
                found = true; // Set found flag to true, indicating a match

                // Expand search to adjacent entries to check if they also match the search term
                int left = mid - 1; // Initialize left index one step before the middle
                int right = mid + 1; // Initialize right index one step after the middle

                // Check patients to the left of the middle index for partial matches
                while (left >= low && patients.get(left).getName().toLowerCase().contains(name.toLowerCase())) {
                    result.append(patientDetails(patients.get(left))).append("\n\n"); // Append left match details
                    left--; // Move to the next patient on the left
                }

                // Check patients to the right of the middle index for partial matches
                while (right <= high && patients.get(right).getName().toLowerCase().contains(name.toLowerCase())) {
                    result.append(patientDetails(patients.get(right))).append("\n\n"); // Append right match details
                    right++; // Move to the next patient on the right
                }
                break; // Exit the loop after finding all matching patients
            }

            // Binary search adjustment: compares search term with the middle patient's name to narrow the search range
            int comparison = name.compareToIgnoreCase(midPatient.getName());
            if (comparison < 0) {
                high = mid - 1; // If search term is alphabetically before the mid name, adjust high to mid - 1
            } else {
                low = mid + 1; // If search term is alphabetically after the mid name, adjust low to mid + 1
            }
        }

        // If no match was found, return a not-found message
        if (!found) {
            return "Patient not found.";
        }
        return result.toString(); // Convert StringBuilder to a string and return the result
    }

    // Helper method to format and return patient details as a string
    private static String patientDetails(Patient patient) {
        return "Name: " + patient.getName()
                + "\nDate of Birth: " + patient.getDateOfBirth()
                + "\nAddress: " + patient.getAddress()
                + "\nMedical Issue: " + patient.getMedicalIssue()
                + "\nMedical DepartmentOption: " + patient.getMedicalDepartment()
                + "\nDoctor: " + (patient.getDoctorName() != null && !patient.getDoctorName().isEmpty() ? patient.getDoctorName() : "N/A")
                + "\nConsultation Fee: " + patient.getConsultationFee();
    }

    // Helper method to format and return employee details as a string
    private static String employeeDetails(Employee employee) {
        return "\nName: " + employee.getName() + "\n"
                + "Date of Birth: " + employee.getDateOfBirth() + "\n"
                + "Address: " + employee.getAddress() + "\n"
                + "Salary: " + employee.getSalary() + "\n"
                + "DepartmentOption: " + employee.getDepartmentType() + "\n"
                + "Role: " + employee.getManagerType() + "\n"
                + "Position: " + employee.getPositionType();
    }

}
