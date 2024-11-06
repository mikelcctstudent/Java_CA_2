/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;//This the package belongs this class, this will help organize the related classes and amange the project structure

import java.util.Scanner; // Impots the Scanner class to read ser input from the console

/**
 * Class to handler the various menu options in the Hospital application
 * Provides methods to get and display menu options for users to select
 *
 * @author Mikel
 */
public class HospitalMenuHandler {
//      This is generic method that was created to display a menu and get the user selection
//      <T extends Enum<T>> mens this method works with any enum type.

    private static <T extends Enum<T>> T getOption(Scanner scanner, T[] options, String menuName) {
        System.out.println("\n" + menuName + ":");// Displays the menu name
//      Loop trpugh and display each option in the enum.
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d - %s\n", i + 1, options[i].name());//Display each option with a corresponding number.
        }
        System.out.print("Please enter your choice: "); //Prompts the user for their choice

        int choice = -1;// variable to store the users choice
        while (true) { //Loop until a valid choice is made
            if (scanner.hasNextInt()) { // Checks if the next input is an interger.
                choice = scanner.nextInt(); //Reeds the users choice
                scanner.nextLine(); // Consumes the newline character.
                if (choice > 0 && choice <= options.length) { // Checks if the choice is within valid range
                    choice--; // Adjusts the choice to match array indexing  0 based
                    break; // Breaks the loop if the choice is valid
                } else {
                    System.out.printf("Invalid choice. Please enter a number between 1 and %d: ", options.length);// prompts the user for a valid choice
                }
            } else {
                System.out.print("Invalid input. Please enter a number: "); // Prompts the user to enter a valid number.
                scanner.next(); // Clears the invalid input
            }
        }
        return options[choice];// now we are going to return the select option
    }
//This method to get the main menu options from the user

    public static HospitalMenu.MenuOption getMainOptions(Scanner scanner) {
//      Calls the generic getOption method with the main menu options
        return getOption(scanner, HospitalMenu.MenuOption.values(), "Main Options");
    }
//This method to get the main sub menu options from the user

    public static HospitalMenu.SubMenuEmployee getEmployeeOption(Scanner scanner) {
//      Calls the generic getOption method with the submenu options
        return getOption(scanner, HospitalMenu.SubMenuEmployee.values(), "Employee Options");
    }

// Method to get the patient submenu options from the user
    public static HospitalMenu.SubMenuPatient getPatientOption(Scanner scanner) {
// Calls the generic getOption method with the patient submenu options
        return getOption(scanner, HospitalMenu.SubMenuPatient.values(), "Patient Options");
    }

// Method to get the sort options from the user
    public static HospitalMenu.SortOption getSortOptions(Scanner scanner) {
// Calls the generic getOption method with the sort options
        return getOption(scanner, HospitalMenu.SortOption.values(), "Sort Options");
    }

// Method to get the search options from the user
    public static HospitalMenu.SearchOption getSearchOptions(Scanner scanner) {
// Calls the generic getOption method with the search options
        return getOption(scanner, HospitalMenu.SearchOption.values(), "Search Options");
    }

// Method to get the show list options for patients from the user
    public static HospitalMenu.ShowListOptionPatient getShowListOptionsPatients(Scanner scanner) {
// Calls the generic getOption method with the show list options for patients
        return getOption(scanner, HospitalMenu.ShowListOptionPatient.values(), "Show List Options for Patients");
    }

// Method to get the show list options from the user
    public static HospitalMenu.ShowListOption getShowListOptions(Scanner scanner) {
// Calls the generic getOption method with the show list options
        return getOption(scanner, HospitalMenu.ShowListOption.values(), "Show List Options");
    }

// Method to get the employee type options from the user
    public static EmployeeType.EmployeeOption getEmployeeTypeOption(Scanner scanner) {
// Calls the generic getOption method with the employee type options
        return getOption(scanner, EmployeeType.EmployeeOption.values(), "Employee Department Options");
    }

// Method to get the manager type options from the user
    public static RoleType.ManagerOption getManagerTypeOption(Scanner scanner) {
// Calls the generic getOption method with the manager type options
        return getOption(scanner, RoleType.ManagerOption.values(), "Manager Department Options");
    }

// Method to get the position type options from the user
    public static PositionType.PositionOption getPositionTypeOption(Scanner scanner) {
// Calls the generic getOption method with the position type options
        return getOption(scanner, PositionType.PositionOption.values(), "Position Department Options");
    }

// Method to get the department type options from the user
    public static DepartmentType.DepartmentOption getDepartmentTypeOption(Scanner scanner) {
// Calls the generic getOption method with the department type options
        return getOption(scanner, DepartmentType.DepartmentOption.values(), "Department Options");
    }

}