/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mikel
 */
// Defines a class to generate random hospital employee data
public class HospitalDataGenerator {

    // A single instance of Random for generating random numbers throughout the class
    private static final Random random = new Random();

    // Instance of HospitalSalaryPolicy for setting employee salaries based on hospital policies
    private static final HospitalSalaryPolicy salaryPolicy = new HospitalSalaryPolicy();

    // Method to generate a list of random employees based on provided names and a specified limit
    public static void generateRandomEmployees(List<Employee> employees, List<String> names, int limit) {
        // Make a copy of the provided names list to avoid modifying the original
        List<String> availableNames = new ArrayList<>(names);

        // Loop until we reach the limit or run out of names
        for (int i = 0; i < limit && !availableNames.isEmpty(); i++) {
            // Randomly select a name from the available names list and remove it to prevent reuse
            String name = availableNames.remove(random.nextInt(availableNames.size()));

            // Generate a random date of birth, assigning an age between 20 and 50 years
            LocalDate dob = LocalDate.now().minusYears(20 + random.nextInt(30));

            // Generate a basic address for the employee with a unique identifier
            String address = "Address" + (employees.size() + 1);

            // Randomly choose the type of employee (e.g., doctor, nurse, admin, etc.)
            EmployeeType.EmployeeOption employeeType = getRandomEmployeeType();

            // Randomly select a department for the employee based on the chosen employee type
            DepartmentType.DepartmentOption department = getRandomElement(EmployeeRoleConfig.DEPARTMENT_OPTIONS.get(employeeType));

            // Randomly select a position for the employee based on the chosen employee type
            PositionType.PositionOption position = getRandomElement(EmployeeRoleConfig.POSITION_OPTIONS.get(employeeType));

            // Get a manager role for the employee type to assign a reporting structure
            RoleType.ManagerOption manager = EmployeeRoleConfig.MANAGER_OPTIONS.get(employeeType);

            // Calculate an hourly rate for the employee based on the chosen department
            BigDecimal hourlyRate = salaryPolicy.getHourlyRate(department);

            // Use the hourly rate to create a Salary object which will calculate the employee's salary
            Salary calculatedSalary = new Salary(hourlyRate);

            // Create a new Employee with the generated attributes and calculated salary
            Employee employee = new Employee(name, dob, address, calculatedSalary, department, manager, position, employeeType);

            // Set additional attributes if the employee type is Nurse
            if (employeeType == EmployeeType.EmployeeOption.NURSE) {
                String shift = getRandomShift(); // Randomly select a shift
                employee.setShift(shift);
            }
            // Add the generated employee to the list of employees
            employees.add(employee);
        }
    }

    // Private helper method to randomly select an employee type from available types
    private static EmployeeType.EmployeeOption getRandomEmployeeType() {
        // Get an array of all possible employee types
        EmployeeType.EmployeeOption[] employeeTypes = EmployeeType.EmployeeOption.values();

        // Randomly select and return one employee type from the array
        return employeeTypes[random.nextInt(employeeTypes.length)];
    }

    // Generic method to randomly select an element from an array of options
    private static <T> T getRandomElement(T[] options) {
        // Randomly select and return an element from the array provided
        return options[random.nextInt(options.length)];
    }

    private static String getRandomShift() {
        String[] shifts = {"Morning", "Afternoon", "Night"};
        return shifts[random.nextInt(shifts.length)];
    }

}
