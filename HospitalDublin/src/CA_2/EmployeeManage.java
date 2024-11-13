/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Mikel
 */
public class EmployeeManage {

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
                    // Calls the method to handle searching for employees based on user input.
                    // This will perform the actual search operation using the updated employee list.
                    handleSearchEmployees(scanner, employees);
                    break;

                // If the user chooses to add a new employee
                case ADD_EMPLOYEE:
                    addEmployee(scanner, employees);
                    break;
                // If the user chooses to generate random employees
                case GENERATE_RANDOM_EMPLOYEE:
                    // Get the valid number of employees to generate without specifying a maximum
                    int limit = getValidNumberOfEmployees(scanner);
                    // Generate and save random employees with the valid limit obtained
                    generateAndSaveRandomEmployees(employees, limit, applicantsFormFile);
                    break;
                // If the user chooses to view the list of employees
                case SHOW_EMPLOYEE_LIST:
                    handleShowEmployeeList(scanner, employees);
                    break;

                // If the user wants to go back to the main menu
                case BACK_TO_MAIN_MENU:
                    System.out.println("Going back to main menu...");
                    exitSubMenu = true; // Sets the flag to true to exit the loop
                    break;

                // Default case if an invalid option is selected
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6!");
            }
        }
    }

// Method to add a new employee
    public static void addEmployee(Scanner scanner, List<Employee> employees) {
        System.out.println("ADD EMPLOYEE Selected: ");

        // Prompt the user to choose the employee type using the enum EmployeeType.EmployeeOption
        EmployeeType.EmployeeOption employeeType = null;
        while (employeeType == null) { // Loop until a valid choice is made
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
                    // Valid index: assign to employeeType
                    employeeType = employeeEmployeeOptions[selectedIndex];
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4!");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input format, e.g., non-numeric input
                System.out.println("Invalid choice. Please enter a number between 1 and 4!");
            }
        }

        // Prompt the user to choose the department type using DepartmentType.DepartmentOption
        DepartmentType.DepartmentOption departmentOption = null;
        while (departmentOption == null) { // Loop until a valid choice is made
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
                    // Valid index: assign to departmentOption
                    departmentOption = departmentDepartmentOptions[deptChoice];
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 8!");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input format, e.g., non-numeric input
                System.out.println("Invalid choice. Please enter a number between 1 and 8!");
            }
        }

        // Prompt the user to choose the manager type using RoleType.RoleOption
        RoleType.RoleOption roleOption = null;
        while (roleOption == null) { // Loop until a valid choice is made
            System.out.println("Select the role type:");
            RoleType.RoleOption[] roleOptions = RoleType.RoleOption.values();
            for (int i = 0; i < roleOptions.length; i++) {
                System.out.println((i + 1) + ". " + roleOptions[i].name());
            }
            System.out.print("Please enter your choice: ");
            String typeChoiceStr = scanner.nextLine();
            try {
                int typeChoice = Integer.parseInt(typeChoiceStr) - 1; // Convert input to index
                if (typeChoice >= 0 && typeChoice < roleOptions.length) {
                    // Valid index: assign to roleOption
                    roleOption = roleOptions[typeChoice];
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5!");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input format, e.g., non-numeric input
                System.out.println("Invalid choice. Please enter a number between 1 and 5!");
            }
        }

        // Prompt the user to choose the position type using PositionType.PositionOption
        PositionType.PositionOption positionPositionOption = null;
        while (positionPositionOption == null) { // Loop until a valid choice is made
            System.out.print("Select the position type:");
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
                    System.out.println("Invalid choice. Please enter a number between 1 and 6!");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input format, e.g., non-numeric input
                System.out.println("Invalid choice. Please enter a number between 1 and 6!");
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
                System.out.print("Invalid salary format. Please enter a valid salary: ");
            }
        }

        // Initialize the Employee object with basic details
        Employee newEmployee = new Employee(name, dateOfBirth, address, salary, departmentOption, roleOption, positionPositionOption, employeeType);

        // Set additional attributes based on the specific employee type
        if (employeeType == EmployeeType.EmployeeOption.NURSE) {
            System.out.print("Enter shift: ");
            String shift = scanner.nextLine();
            newEmployee.setShift(shift); // Set shift for nurse
        }
        // show the details for the confirmation
        System.out.println("\nPlease review the new employee details:");
        displayEmployeeDetails(newEmployee);
        System.out.print("Are these details correct? (yes/no): ");
        // getting the confirmation form the use using the method the I created in the main menu for validate others parts also
        String confirmation = HospitalApp.getValidResponse(scanner);
        //if the confirmation equals with yes will save the new employee
        if (confirmation.equals("yes")) {
            // Save the new employee's details to the file
            employees.add(newEmployee);
            // Display the new employee's details
            System.out.println("The new employee details confirmed!");
            try {
                HospitalFileManage.writeEmployeeToFile(newEmployee, EMPLOYEE_FILE);
                employees.add(newEmployee); // Add to in-memory list for consistency
                System.out.println("\nEmployee details saved successfully.");
            } catch (IOException e) {
                // Display an error message if file writing fails
                System.out.println("Error saving employee details: " + e.getMessage());
            }
        } else {
            System.out.println("Employee details not saved.");
        }
    }

// Method to display sorting options for employees
    public static void sortOptionsEmployees(Scanner scanner, List<Employee> employees) {
        // Get the sorting option chosen by the user
        HospitalMenu.SortOption sortOption = HospitalMenuHandler.getSortOptions(scanner);

        // Check if the user wants to sort the list alphabetically
        if (sortOption == HospitalMenu.SortOption.SORT_BY_NAME) {
            // Perform sorting of the employee list
            employees = SortingAlgorithm.mergeSort(employees);
            displaySortedEmployees(employees, 20);

            // Ask the user if they would like to export the sorted list
            System.out.print("\nWould you like to export the sorted list of employees to 'sorted_employees.txt'? (yes/no): ");
            String exportResponse = HospitalApp.getValidResponse(scanner);

            if (exportResponse.equalsIgnoreCase("yes")) {
                // If user chooses to export, save the sorted list to file
                HospitalFileManage.exportSortedEmployeesToFile(employees);
            } else {
                System.out.println("Export operation cancelled.");
            }
        } else {
            // Display message if sorting option is invalid
            System.out.println("Invalid option. Please try again.");
        }
    }

// Method to display search options for employees
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
                String result = SearchingAlgorithm.searchEmployeesByName(employees, employeeSearchName);
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

// Method to handle sorting employees
    public static void handleSortEmployees(Scanner scanner, List<Employee> employees, List<String> applicants, String applicantsFormFile) {
        // Prints a message indicating the "Sort" option was selected
        System.out.println("SORT Selected: ");

        // Checks if the employee list is empty
        if (employees.isEmpty()) {
            System.out.print("The employee list is empty. Do you want to populate the system with initial data? (yes/no)");
            String response = HospitalApp.getValidResponse(scanner);

            // If the user wants to populate the system with data
            if (response.equalsIgnoreCase("yes")) {
                // Prompts the user for a valid number of employees to generate based on available applicant names
                int limit = getValidNumberOfEmployees(scanner);
                generateAndSaveRandomEmployees(employees, limit, applicantsFormFile);

                // Asks if the user wants to continue with sorting after generating employees
                System.out.print("\nWould you like to proceed with the sort options? (yes/no):");
                String proceedResponse = HospitalApp.getValidResponse(scanner);
                if (proceedResponse.equalsIgnoreCase("yes")) {
                    // If yes, calls the method to display sorting options
                    sortOptionsEmployees(scanner, employees);
                } else {
                    // Otherwise, cancels the sort operation
                    System.out.println("Sort operation cancelled.");
                }
            } else {
                // If the user doesn't want to populate, indicates that sorting is not possible
                System.out.println("Cannot sort an empty list.");
            }
        } else {
            // If the list is not empty, proceeds with sorting options directly
            sortOptionsEmployees(scanner, employees);
        }
    }

// Method to handle employee search
    public static void handleSearchEmployees(Scanner scanner, List<Employee> employees) {
        // Prints a message indicating the "Search" option was selected
        System.out.println("SEARCH Selected: ");

        // Checks if the list is empty and informs the user if there are no employees to search
        if (employees.isEmpty()) {
            System.out.println("Employee list is empty. Please add employees first.");
            return;
        }

        // Calls the method to handle search options and display search results
        searchOptionsEmployees(scanner, employees);
    }

// Method to display employee details
    public static void displayEmployees(List<Employee> employees) {
        // Iterates through each employee in the list and displays their details
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + employee.getDateOfBirth());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getDepartmentType().name());
            System.out.println("Role: " + employee.getManagerType().name());
            System.out.println("Position: " + employee.getPositionType().name());

            // Checks the specific type of the employee and displays additional information accordingly
            if (employee.getEmployeeOption() == EmployeeType.EmployeeOption.NURSE) {
                System.out.println("Shift: " + (employee.getShift() != null ? employee.getShift() : "N/A"));
            }
            System.out.println(); // Blank line between employees
        }
    }

// Method to display details of a single employee
    public static void displayEmployeeDetails(Employee employee) {
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of Birth: " + employee.getDateOfBirth());
        System.out.println("Address: " + employee.getAddress());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Department: " + employee.getDepartmentType().name());
        System.out.println("Role: " + employee.getManagerType().name());
        System.out.println("Position: " + employee.getPositionType().name());

        // Checks if the employee is a Nurse and displays the shift if applicable
        if (employee.getEmployeeOption() == EmployeeType.EmployeeOption.NURSE) {
            System.out.println("Shift: " + (employee.getShift() != null ? employee.getShift() : "N/A"));
        }
    }
// Method to display sorted employee details with a limit on the number of displayed employees

    public static void displaySortedEmployees(List<Employee> employees, int limit) {
        // Displays a header indicating that sorted employees are being listed
        System.out.println("\nSorted employees: \n");

        // Loops through employees up to the specified limit or list size
        for (int i = 0; i < limit && i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + employee.getDateOfBirth());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Salary: " + employee.getSalary()); // Displays salary
            System.out.println("DepartmentOption: " + employee.getDepartmentType().name());
            System.out.println("Role: " + employee.getManagerType().name());
            System.out.println("Position: " + employee.getPositionType().name());

            // Checks the specific type of the employee and displays additional information accordingly
            if (employee.getEmployeeOption() == EmployeeType.EmployeeOption.NURSE) {
                System.out.println("Shift: " + (employee.getShift() != null ? employee.getShift() : "N/A"));
            }
            // Prints a blank line to separate each employee's details
            System.out.println();
        }
    }

// Method to handle displaying employee list options
    public static void handleShowEmployeeList(Scanner scanner, List<Employee> employees) {
        // Prompts the user to choose between showing the original or sorted list of employees
        HospitalMenu.ShowListOption showListOption = HospitalMenuHandler.getShowListOptions(scanner);

        // Uses a switch statement to display the list based on user's choice
        switch (showListOption) {
            case SHOW_ORIGINAL_LIST:

                if (employees.isEmpty()) {
                    // If the list is empty, displays a message
                    System.out.println("\nThe employee list is empty.");
                } else {
                    // Otherwise, displays the original list of employees
                    System.out.println("\nOriginal Employee list: ");
                    displayEmployees(employees);
                }
                break;
            case SHOW_SORTED_LIST:
                if (employees.isEmpty()) {
                    // If the list is empty, displays a message
                    System.out.println("\nThe employee list is empty.");
                } else {
                    // Sorts the list and displays sorted employees
                    employees = SortingAlgorithm.mergeSort(employees);
                    System.out.println("\nSorted Employee list: ");
                    displaySortedEmployees(employees, 20);
                }
                break;
            default:
                // If an invalid option is chosen, prompts the user to try again
                System.out.println("Invalid option. Please try again.");
        }
    }

// Method to get a valid number of employees from the user for generation
    public static int getValidNumberOfEmployees(Scanner scanner) {
        int limit = 0; // Variable to store the number of employees the user wants to generate
        boolean validInput = false;

        // Loop until a valid input is obtained
        while (!validInput) {
            System.out.print("Enter the number of employees to generate: ");
            while (!scanner.hasNextInt()) {
                // If input is not an integer, prompt the user to enter a valid number
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Discard the invalid input
            }
            limit = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after input

            // Checks if the requested number of employees is within the available names limit
            if (limit > 0) {
                validInput = true; // Exit loop if the input is valid
            } else {
                // Inform the user if the requested number exceeds available names
                System.out.println("Invalid input. Please enter a positive number!");
            }
        }
        return limit; // Return the valid number of employees to be generated
    }

// Method to generate and save a specified number of random employees
    public static void generateAndSaveRandomEmployees(List<Employee> employees, int limit, String applicantsFormFile) {
        try {
            // Reads a list of applicant names from the specified file
            List<String> applicantNames = HospitalFileManage.readNamesForSorting(applicantsFormFile);
            List<Employee> newEmployees = new ArrayList<>(); // List to store newly generated employees

            // Generates random employees based on the available names and the specified limit
            HospitalDataGenerator.generateRandomEmployees(newEmployees, applicantNames, limit);

            // Loops through each generated employee and saves them to the file
            for (Employee employee : newEmployees) {
                employees.add(employee); // Adds each new employee to the main employee list
                HospitalFileManage.writeEmployeeToFile(employee, EMPLOYEE_FILE);
            }

            // Displays the newly generated employees to the user
            System.out.println("\nGenerated employees: \n");
            displayEmployees(newEmployees); // Calls method to display details of new employees

            // Prints a success message with the count of generated employees
            System.out.println("Generated " + newEmployees.size() + " new employees successfully.");
        } catch (IOException e) {
            // If an error occurs, prints an error message
            System.out.println("Error generating and saving random employees: " + e.getMessage());
        }
    }

}
