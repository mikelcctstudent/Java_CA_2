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
public class SearchingAlgorithm {

// Public method to start the recursive search for employees by name, allowing partial matches
    public static String searchEmployeesByName(List<Employee> employees, String name) {
        String result = searchEmployeesByNameRecursive(employees, name, 0, employees.size() - 1).trim();
        return result.isEmpty() ? "Employee not found." : result;
    }

    private static String searchEmployeesByNameRecursive(List<Employee> employees, String name, int low, int high) {
        // Base case: if range is invalid, return an empty string indicating no match found in this path
        if (low > high) {
            return "";
        }

        int mid = (low + high) / 2;
        Employee midEmployee = employees.get(mid);
        String result = "";

        // Check if the middle employee's name contains the search term (case-insensitive, partial match)
        if (midEmployee.getName().toLowerCase().contains(name.toLowerCase())) {
            result += employeeDetails(midEmployee) + "\n\n";
        }

        // Recursively search the left and right sides to gather all potential matches
        result += searchEmployeesByNameRecursive(employees, name, low, mid - 1);
        result += searchEmployeesByNameRecursive(employees, name, mid + 1, high);

        return result;
    }

// Public method to start the recursive search for a patient by name
    public static String searchPatientsByName(List<Patient> patients, String name) {
        String result = searchPatientsByNameRecursive(patients, name, 0, patients.size() - 1).trim();
        return result.isEmpty() ? "Patient not found." : result;
    }

// Private recursive method to perform the binary search with partial match accumulation
    public static String searchPatientsByNameRecursive(List<Patient> patients, String name, int low, int high) {
        // Base case: if the search range is invalid, return an empty string
        if (low > high) {
            return "";
        }

        int mid = (low + high) / 2; // Calculate the middle index
        Patient midPatient = patients.get(mid); // Get the patient at the middle index
        String result = "";

        // Check if the middle patient's name contains the search term (case-insensitive, partial match)
        if (midPatient.getName().toLowerCase().contains(name.toLowerCase())) {
            result += patientDetails(midPatient) + "\n\n"; // Accumulate patient details for this match
        }

        // Recursively search both left and right halves to find all matches
        result += searchPatientsByNameRecursive(patients, name, low, mid - 1);
        result += searchPatientsByNameRecursive(patients, name, mid + 1, high);

        return result;
    }

// Helper method to format and return patient details as a string
    public static String patientDetails(Patient patient) {
        return "Name: " + patient.getName()
                + "\nDate of Birth: " + patient.getDateOfBirth()
                + "\nAddress: " + patient.getAddress()
                + "\nMedical Issue: " + patient.getMedicalIssue()
                + "\nMedical DepartmentOption: " + patient.getMedicalDepartment()
                + "\nDoctor: " + (patient.getDoctorName() != null && !patient.getDoctorName().isEmpty() ? patient.getDoctorName() : "N/A")
                + (patient.getConsultationFee() != null ? "\nConsultation Fee: " + patient.getConsultationFee() : "");
    }

    // Helper method to format and return employee details as a string
    public static String employeeDetails(Employee employee) {
        return "\nName: " + employee.getName() + "\n"
                + "Date of Birth: " + employee.getDateOfBirth() + "\n"
                + "Address: " + employee.getAddress() + "\n"
                + "Salary: " + employee.getSalary() + "\n"
                + "DepartmentOption: " + employee.getDepartmentType() + "\n"
                + "Role: " + employee.getManagerType() + "\n"
                + "Position: " + employee.getPositionType();
    }

}
