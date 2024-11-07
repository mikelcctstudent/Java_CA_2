/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Mikel
 */
public class EmployeeManager {
    
// Define a constant for the filename where employee data is stored
private static final String EMPLOYEE_FILE = "employees.txt";

// Main method to manage all employee-related operations
public static void manageEmployees(Scanner scanner, List<Employee> employees, List<String> applicants, String applicantsFormFile) {
    // Flag to control when to exit the submenu
    boolean exitSubMenu = false;

    // Loop that continues to show options until the user chooses to exit
    while (!exitSubMenu) {
        // Get the option selected by the user from the employee submenu
        HospitalMenu.SubMenuEmployee employeeOption = HospitalMenuHandler.getEmployeeOption(scanner);

        // Use switch to handle each possible menu option for employee management
        switch (employeeOption) {
            // If the user chooses to sort employees
            case SORT:
                handleSortEmployees(scanner, employees, applicants, applicantsFormFile);
                break;

            // If the user chooses to search for employees
            case SEARCH:
                handleSearchEmployees(scanner, employees);
                break;

            // If the user chooses to add a new employee
            case ADD_EMPLOYEE:
                addEmployee(scanner, employees);
                // Reload the employee list from file after adding a new employee to update the in-memory list
                try {
                    employees = HospitalFileManager.readEmployeesFile(EMPLOYEE_FILE);
                } catch (IOException e) {
                    // Display an error message if reading the file fails
                    System.out.println("Error reading employee file: " + e.getMessage());
                }
                break;

            // If the user chooses to generate random employees
            case GENERATE_RANDOM_EMPLOYEE:
                System.out.print("Enter the number of employees to generate: ");
                int limit = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after number input
                generateAndSaveRandomEmployees(employees, limit, applicantsFormFile);
                break;

            // If the user chooses to view the list of employees
            case SHOW_EMPLOYEE_LIST:
                handleShowEmployeeList(scanner, employees);
                break;

            // If the user wants to go back to the main menu
            case BACK:
                System.out.println("Going back to main menu...");
                exitSubMenu = true; // Sets the flag to true to exit the loop
                break;

            // Default case if an invalid option is selected
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

// Created the method to add a new employee
public static void addEmployee(Scanner scanner, List<Employee> employees) {
    System.out.println("ADD EMPLOYEE Selected: ");

    // Prompt the user to choose the employee type using the enum EmployeeType.EmployeeOption
    EmployeeType.EmployeeOption employeeEmployeeOption = null;
    while (employeeEmployeeOption == null) { // Loop until a valid choice is made
        System.out.println("Select the employee type:");
        EmployeeType.EmployeeOption[] employeeEmployeeOptions = EmployeeType.EmployeeOption.values();
        for (int i = 0; i < employeeEmployeeOptions.length; i++) {
            System.out.println((i + 1) + ". " + employeeEmployeeOptions[i].name());
        }
        System.out.print("Please enter your choice: ");
        String choice = scanner.nextLine();
        try {
            int selectedIndex = Integer.parseInt(choice) - 1; // Convert input to index
            if (selectedIndex >= 0 && selectedIndex < employeeEmployeeOptions.length) {
                // Valid index: assign to employeeEmployeeOption
                employeeEmployeeOption = employeeEmployeeOptions[selectedIndex];
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input format, e.g., non-numeric input
            System.out.println("Invalid choice. Please enter a valid number.");
        }
    }

    // Prompt the user to choose the department type using DepartmentType.DepartmentOption
    DepartmentType.DepartmentOption departmentDepartmentOption = null;
    while (departmentDepartmentOption == null) { // Loop until a valid choice is made
        System.out.println("Select the department type:");
        DepartmentType.DepartmentOption[] departmentDepartmentOptions = DepartmentType.DepartmentOption.values();
        for (int i = 0; i < departmentDepartmentOptions.length; i++) {
            System.out.println((i + 1) + ". " + departmentDepartmentOptions[i].name());
        }
        System.out.print("Please enter your choice: ");
        String deptChoiceStr = scanner.nextLine();
        try {
            int deptChoice = Integer.parseInt(deptChoiceStr) - 1; // Convert input to index
            if (deptChoice >= 0 && deptChoice < departmentDepartmentOptions.length) {
                // Valid index: assign to departmentDepartmentOption
                departmentDepartmentOption = departmentDepartmentOptions[deptChoice];
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input format, e.g., non-numeric input
            System.out.println("Invalid choice. Please enter a valid number.");
        }
    }

    // Prompt the user to choose the manager type using RoleType.ManagerOption
    RoleType.ManagerOption managerManagerOption = null;
    while (managerManagerOption == null) { // Loop until a valid choice is made
        System.out.println("Select the manager type:");
        RoleType.ManagerOption[] managerManagerOptions = RoleType.ManagerOption.values();
        for (int i = 0; i < managerManagerOptions.length; i++) {
            System.out.println((i + 1) + ". " + managerManagerOptions[i].name());
        }
        System.out.print("Please enter your choice: ");
        String typeChoiceStr = scanner.nextLine();
        try {
            int typeChoice = Integer.parseInt(typeChoiceStr) - 1; // Convert input to index
            if (typeChoice >= 0 && typeChoice < managerManagerOptions.length) {
                // Valid index: assign to managerManagerOption
                managerManagerOption = managerManagerOptions[typeChoice];
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input format, e.g., non-numeric input
            System.out.println("Invalid choice. Please enter a valid number.");
        }
    }

    // Prompt the user to choose the position type using PositionType.PositionOption
    PositionType.PositionOption positionPositionOption = null;
    while (positionPositionOption == null) { // Loop until a valid choice is made
        System.out.println("Select the position type:");
        PositionType.PositionOption[] positionPositionOptions = PositionType.PositionOption.values();
        for (int i = 0; i < positionPositionOptions.length; i++) {
            System.out.println((i + 1) + ". " + positionPositionOptions[i].name());
        }
        System.out.print("Please enter your choice: ");
        String posChoiceStr = scanner.nextLine();
        try {
            int posChoice = Integer.parseInt(posChoiceStr) - 1; // Convert input to index
            if (posChoice >= 0 && posChoice < positionPositionOptions.length) {
                // Valid index: assign to positionPositionOption
                positionPositionOption = positionPositionOptions[posChoice];
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input format, e.g., non-numeric input
            System.out.println("Invalid choice. Please enter a valid number.");
        }
    }

    // Collect additional data for the new employee from user input
    System.out.print("What is the name of the employee: ");
    String name = scanner.nextLine();

    System.out.print("What is the Date of Birth of the Employee (Please use format yyyy-MM-dd): ");
    LocalDate dateOfBirth = null;
    while (dateOfBirth == null) {
        try {
            String dob = scanner.nextLine();
            dateOfBirth = LocalDate.parse(dob); // Parse date string to LocalDate object
        } catch (DateTimeParseException e) {
            // Handle invalid date format input
            System.out.print("Invalid date format. Please use format yyyy-MM-dd: ");
        }
    }

    System.out.print("What is the address of the employee: ");
    String address = scanner.nextLine();

    System.out.print("What is the employee salary: ");
    BigDecimal salary = null;
    while (salary == null) {
        try {
            String salaryStr = scanner.nextLine();
            salary = new BigDecimal(salaryStr); // Parse string to BigDecimal for precise salary storage
        } catch (NumberFormatException e) {
            // Handle invalid salary format input
            System.out.print("Invalid salary format. Please enter a valid number: ");
        }
    }

    // Create a new employee based on the selected employee type
    Employee newEmployee;
    switch (employeeEmployeeOption) {
        case DOCTOR:
            System.out.print("Enter medical specialty: ");
            String medicalSpecialty = scanner.nextLine();
            String licenseNumber;
            do {
                System.out.print("Enter license number (digits only): ");
                licenseNumber = scanner.nextLine();
                if (!licenseNumber.matches("\\d+")) {
                    // Validate that the license number contains only digits
                    System.out.println("Invalid license number. Please enter digits only.");
                }
            } while (!licenseNumber.matches("\\d+"));
            // Create a Doctor instance with specific attributes
            newEmployee = new Doctor(name, dateOfBirth, address, salary, departmentDepartmentOption, managerManagerOption, positionPositionOption, medicalSpecialty, licenseNumber);
            break;
        case NURSE:
            System.out.print("Enter shift: ");
            String shift = scanner.nextLine();
            System.out.print("Enter specialization: ");
            String specialization = scanner.nextLine();
            // Create a Nurse instance with specific attributes
            newEmployee = new Nurse(name, dateOfBirth, address, salary, departmentDepartmentOption, managerManagerOption, positionPositionOption, shift, specialization);
            break;
        case ADMINISTRATIVE_ASSISTANT:
            System.out.print("Enter role: ");
            String role = scanner.nextLine();
            // Create an AdministrativeAssistant instance with specific attributes
            newEmployee = new AdministrativeAssistant(name, dateOfBirth, address, salary, departmentDepartmentOption, managerManagerOption, positionPositionOption, role);
            break;
        case GENERAL_STAFF:
            System.out.print("Enter job description: ");
            String jobDescription = scanner.nextLine();
            // Create a GeneralStaff instance with specific attributes
            newEmployee = new GeneralStaff(name, dateOfBirth, address, salary, departmentDepartmentOption, managerManagerOption, positionPositionOption, jobDescription);
            break;
        default:
            // Create a generic Employee instance if no specific type is chosen
            newEmployee = new Employee(name, dateOfBirth, address, salary, departmentDepartmentOption, managerManagerOption, positionPositionOption);
            break;
    }

    // Display the new employee's details
    System.out.println(newEmployee);

    // Save the new employee's details to the file
    try {
        HospitalFileManager.writeEmployeeToFile(newEmployee, EMPLOYEE_FILE);
        employees.add(newEmployee); // Add to in-memory list for consistency
        System.out.println("Employee details saved successfully.");
    } catch (IOException e) {
        // Display an error message if file writing fails
        System.out.println("Error saving employee details: " + e.getMessage());
    }
}

// Created the method to display sorting options for employees
public static void sortOptionsEmployees(Scanner scanner, List<Employee> employees) {
    // Get the sorting option chosen by the user
    HospitalMenu.SortOption sortOption = HospitalMenuHandler.getSortOptions(scanner);

    // Check if the user wants to sort the list alphabetically
    if (sortOption == HospitalMenu.SortOption.SORT_LIST_IN_ALPHABETICAL_ORDER) {
        // Perform sorting of the employee list
        employees = SortingAlgorithm.mergeSort(employees);
        displaySortedEmployees(employees, 20);

        // Ask the user if they would like to export the sorted list
        System.out.print("\nWould you like to export the sorted list of employees to 'sorted_employees.txt'? (yes/no): ");
        String exportResponse = HospitalApp.getValidResponse(scanner);

        if (exportResponse.equalsIgnoreCase("yes")) {
            // If user chooses to export, save the sorted list to file
            HospitalFileManager.exportSortedEmployeesToFile(employees);
        } else {
            System.out.println("Export operation cancelled.");
        }
    } else {
        // Display message if sorting option is invalid
        System.out.println("Invalid option. Please try again.");
    }
}

// Created the method to display search options for employees
public static void searchOptionsEmployees(Scanner scanner, List<Employee> employees) {
    // Get the search option chosen by the user
    HospitalMenu.SearchOption searchOption = HospitalMenuHandler.getSearchOptions(scanner);

    // Check if the user wants to search employees by name
    if (Objects.requireNonNull(searchOption) == HospitalMenu.SearchOption.SEARCH_BY_NAME) {
        try {
            System.out.print("Enter name to search: ");
            String employeeSearchName = scanner.nextLine().trim();

            // Sort the employee list first to ensure a faster and more accurate search
            employees = SortingAlgorithm.mergeSort(employees);

            // Perform search by name and display results
            String result = SearchingAlgorithm.searchEmployeeByName(employees, employeeSearchName);
            System.out.println(result);
        } catch (Exception e) {
            // Handle any errors during the search process
            System.out.println("Error searching for employee: " + e.getMessage());
        }
    } else {
        // Display message if search option is invalid
        System.out.println("Invalid option. Please try again.");
    }
}

    
}
