/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// This is the package to which the class Hospital belongs

import java.io.File;//This imports the file class, which is used to interact with files in the system.
import java.io.IOException;//Imports IOException for handling input and output erros when dealing with files.
import java.util.ArrayList; //Imports Arraylist a dynamic array that can grow as needed.
import java.util.List;//I used it for import a list, an interface for a group of objects
import java.util.Scanner;//This imports userInput to read user input from the console

/**
 * The main method will employ the logic to process the users choice by
 * providing Some menu options based on the enums in the interface.
 *
 * @author Mikel
 */
public class HospitalApp { //This is the name of the main class 

    private static final String EMPLOYEE_FILE = "employees.txt";//This file will store employee data.
    private static final String PATIENT_FILE = "patients.txt"; //This file will store patients data.
    private static final String SORTED_EMPLOYEES_FILE = "sorted_employees.txt"; //This file will store sorted employees
    private static final String SORTED_PATIENTS_FILE = "sorted_patients.txt"; // and this one will store the sorted patients
    private static final String APPOINTMENT_FILE = "patients_appointments.txt";//File to store employeedata

    public static void main(String[] args) { // The main method the entry point for the application
        Scanner userInput = new Scanner(System.in);//Now I created a userInput object to read user input from the console
        String applicantsFormFromFile = askForFileName(userInput);//Now I ask the user to input the name of the file containing application information
//      In this part I will call the method to clean the fle datawhen the program will be executed
        clearAllDataFiles();
//      Now I created a list to store data read from files and user inputs
        List<String> applicants = new ArrayList<>();//List for the names of the applicants that I stored 50 names and surnames to be used when I will generate randonmlly the employees
        List<Employee> employees = new ArrayList<>();//List to hold employee objects 
        List<Patient> patients = new ArrayList<>();//This list to hold patient objects
//      After reader the file the user can see on console the nameof the file it was selected
        System.out.println("\nSelected file: " + applicantsFormFromFile);
//      Now I created a try catch to check if the file name it was read successfuly in the system
        try {
//          Reads the applicant data from the file into the project folder called "applicants_form.txt"
            applicants = HospitalFileManage.readApplicantsForm(applicantsFormFromFile);
            System.out.println("File read successfully");//Informs the user that the file was read without issues
        } catch (IOException e) {// Handles any IOException that occur if the file if not found or cant be read.
            System.out.println("Error reading file: " + e.getMessage());//Prints an error message if somenthing goes wrong during try read the file name
            System.out.println("Please try again");//Ask the user to try again
            return; //Will exist the application if the file cant be read.
        }
//      The flag to control the main loop, indicating whether the user wants to exit
        boolean exit = false;
        while (!exit) { // This loop runs until the user chooses to exit.
//          Display main menu options to the user and gets their selection. 
//          This part will access the class HospitalMenu and select the MenuOption that have the enum and store into the variable
//          mainOption for use in the switch menu
            HospitalMenu.MenuOption mainOption = HospitalMenuHandler.getMainOptions(userInput);
            switch (mainOption) {//Perfoms actions based on the users menu selection
                case MANAGE_EMPLOYEES://If user selects to manage employees
//                 Thsi I will call the manager employees options
                   EmployeeManage.manageEmployees(userInput, employees, applicants, applicantsFormFromFile);
                    break;
                case MANAGE_PATIENTS://If user selects to manage patients.
                    try {
                        PatientManage.managePatients(userInput, patients);
                    } catch (IOException e) {
                        System.out.println("An error occurred while managing patients: " + e.getMessage());
                    }
                    break;
                case EXIT_OF_THE_SYSTEM://If user selects to exit the application
                    exit = confirmExit(userInput);// Calls a method to confirm the users intention to exit
                    break;
                default://If the user selects an invalid option
                    System.out.println("Invalid option. Please try again.");
//                  user of the invalid selection and ask to try again
            }
        }
        userInput.close();//This close the userInput object
    }
//  This method its to request and validate the file name from the user

    public static String askForFileName(Scanner scanner) {
        String filename;// Variable to hold the file name input by the user.
        while (true) { // Infite loop until a valid file name is provided
            System.out.print("Please enter the filename to read: ");//Prompts user input.
            filename = scanner.nextLine();//Reads the file name from the users input
            File file = new File(filename);//Creates a file object to check if the file exists.
            if (file.exists() && file.isFile()) { // Checks if the file indeed exists and is a file
                break;// now breaks the loop if a valid file is found
            } else {// If the file does not exist or is not valid
//              This part will prints an error message.
                System.out.println("Error: The file '" + filename + "' does not exist or is not a file. Please try again.");
            }
        }
        return filename;//Returns the validated file name.

    }
//  Method to confirm the user's intention to exit the application

    private static boolean confirmExit(Scanner scanner) {
        System.out.print("Are you sure you want to exit? (yes/no): ");// Prompts the user for confirmation to exit
        String response = getValidResponse(scanner);//Now will calls another method to get a valid yes or no response from the user
        if (response.equals("yes")) { // if the user confirms to exit
            System.out.println("Exiting...");// display an exit message
            return true;// and returns true to the caller to indicate the user wants to exit
        } else {//if the user decides not to exit
            System.out.println("Continuing in the system...");// informs the user that the program will continue running
            return false;// returns false to continue the main loop
        }
    }
//  Mthod to snsure valid yes or no response from the user

    public static String getValidResponse(Scanner scanner) {
        String response;// variable to hold the user response
        while (true) { //Loop until a valid response is received
            response = scanner.nextLine().trim().toLowerCase(); // Reads and trims the response, converting it to lowercase
            if (response.equals("yes") || response.equals("no")) { // checks if the response is yes or no
                break; // Break the loop if a valid response is provided
            } else { // If the response is invalid
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");//Asks the user to provide a valid response
            }
        }
        return response; // returns the valid response
    }
//  This method its for clean all data from the file when is executed the program
    public static void clearAllDataFiles() {
        HospitalFileManage.clearAllFiles(EMPLOYEE_FILE);
        HospitalFileManage.clearAllFiles(SORTED_EMPLOYEES_FILE);
        HospitalFileManage.clearAllFiles(PATIENT_FILE);
        HospitalFileManage.clearAllFiles(SORTED_PATIENTS_FILE);
        HospitalFileManage.clearAllFiles(APPOINTMENT_FILE);
    }

}
