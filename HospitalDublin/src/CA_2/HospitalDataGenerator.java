/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
//In this part it was import that we are going to use in this class

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is responsible for generating random employees based on predefined
 * configurations. It ensures consistency by utilizing mappings and methods
 * defined in EmployeeRoleConfig.
 *
 * @author Mikel
 */
public class HospitalDataGenerator {

    // A single instance of Random for generating random values
    private static final Random random = new Random();

    /**
     * This method will generates a list of random employees based on provided
     * names and a specified limit.
     */
    public static void generateRandomEmployees(List<Employee> employees, List<String> names, int limit) {
        // Copy of names to ensure unique selection
        List<String> availableNames = new ArrayList<>(names);

        // Generate employees up to the specified limit or until names run out
        for (int i = 0; i < limit && !availableNames.isEmpty(); i++) {
            // Randomly select and remove a name
            String name = availableNames.remove(random.nextInt(availableNames.size()));

            // Generate a random date of birth (age between 20 and 50)
            LocalDate dob = LocalDate.now().minusYears(20 + random.nextInt(30));

            // Generate a simple address for the employee
            String address = "Dublin " + (employees.size() + 1);

            // Randomly determine the type of employee
            HospitalOptions.EmployeeOption employeeType = getRandomEmployeeType();

            // Select a random department for the employee
            HospitalOptions.DepartmentOption department = getRandomElement(EmployeeRoleConfig.DEPARTMENT_OPTIONS.get(employeeType));

            // Select a random position for the employee
            HospitalOptions.PositionOption position = getRandomElement(EmployeeRoleConfig.POSITION_OPTIONS.get(employeeType));

            // Retrieve the manager role for the employee type
            HospitalOptions.RoleOption manager = EmployeeRoleConfig.ROLE_OPTIONS.get(employeeType);

            // Calculate the salary based on department and manager role
            BigDecimal hourlyRate = Salary.getHourlyRateFromDepartment(department);
            Salary calculatedSalary = new Salary(hourlyRate);

            // Create the Employee object
            Employee employee = new Employee(name, dob, address, calculatedSalary, department, manager, position, employeeType);

            // Set additional attributes for specific employee types (e.g., Nurses)
            if (employeeType == HospitalOptions.EmployeeOption.Nurse) {
                String shift = getRandomShift();
                employee.setShift(shift);
            }

            // Add the generated employee to the list
            employees.add(employee);
        }
    }

    // Private method to randomly select an employee type
    private static HospitalOptions.EmployeeOption getRandomEmployeeType() {
        HospitalOptions.EmployeeOption[] employeeTypes = HospitalOptions.EmployeeOption.values();
        return employeeTypes[random.nextInt(employeeTypes.length)];
    }

    // Generic method to select a random element from an array
    private static <T> T getRandomElement(T[] options) {
        return options[random.nextInt(options.length)];
    }

    // Method to randomly select a shift
    private static String getRandomShift() {
        String[] shifts = {"Morning", "Afternoon", "Night"};
        return shifts[random.nextInt(shifts.length)];
    }
}
