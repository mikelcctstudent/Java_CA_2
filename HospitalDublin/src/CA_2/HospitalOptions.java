package CA_2;

/**
 * This class consolidates all enums for department types, employee types,
 * position types, role types, and menu options. It provides a structured and
 * centralized way to handle these options, reducing the number of files and
 * improving code organization. By unifying these enums, the project becomes
 * easier to maintain, more readable, and eliminates redundancy.
 *
 * @author Mikel
 */
public class HospitalOptions {

//     Enum for department options These are the menu options we would like to
//     present to the user for the department option. Each department represents
//     a core functional unit in the hospital, ensuring employees and patients
//     are associated with the correct areas.
    public enum DepartmentOption {
        Cardiology, // 0 - Responsible for heart-related treatments
        Neurology, // 1 - Deals with brain and nervous system issues
        Oncology, // 2 - Focuses on cancer treatment
        Emergency, // 3 - Handles urgent and critical care cases
        Pediatrics, // 4 - Specialized in children's health
        Orthopedics, // 5 - Focuses on bone and muscle conditions
        Human_Resources, // 6 - Manages administrative HR tasks
        General_Services     // 7 - Includes support roles like cleaning and maintenance
    }

//     Enum for employee options These are the menu options we would like to
//     present to the user for the employee option. Employees are categorized by
//     their role in the hospital to streamline management and assignment.
    public enum EmployeeOption {
        General_Staff, // 0 - Includes support and administrative staff
        Doctor, // 1 - Medical professionals responsible for treatment
        Nurse, // 2 - Provides patient care and medical support
        Administrative_Assistant   // 3 - Handles clerical and administrative tasks
    }

//     Enum for position options These are the menu options we would like to
//     present to the user for the positions types. Each position is linked to
//     specific roles within the hospital departments, ensuring clarity in
//     assignments.
    public enum PositionOption {
        Surgeon, // 0 - Performs surgical procedures
        Geriatric_Medicine, // 1 - Specializes in elderly patient care
        Administrative_Assistant, // 2 - Supports hospital operations administratively
        Human_Resources_Manager, // 3 - Oversees HR functions and staff
        Radiology_Nurse, // 4 - Assists with radiological procedures
        Cleaner                    // 5 - Ensures cleanliness and sanitation
    }

//     Enum for role options These are the menu options we would like to present
//     to the user for the manager types. Roles define the hierarchy and
//     responsibilities of employees in the hospital system.
    public enum RoleOption {
        General_Manager, // 0 - Oversees overall hospital operations
        Nurse_Administrator, // 1 - Manages nursing staff and their schedules
        Medical_Director, // 2 - Responsible for medical decisions and policies
        HR_Manager, // 3 - Manages recruitment, training, and HR policies
        Clinical_Manager         // 4 - Supervises clinical operations and patient care
    }

//     Enum for main menu options These are the menu options we would like to
//     present to the user for the system's main menu. This helps navigate
//     between the core functionalities of the system.
    public enum MenuOption {
        Manage_Employees, // 0 - Allows the management of employee records
        Manage_Patients, // 1 - Enables patient record and appointment management
        Exit_Of_The_System   // 2 - Exits the hospital management system
    }

//    Enum for employee sub-menu options These are the menu options we would
//    like to present to the user for the employee sub-menu, providing detailed
//    actions related to employee management.
    public enum SubMenuEmployeeOption {
        Sort_Employees_List, // 0 - Sorts employees by name
        Search_Employees_List, // 1 - Searches employees by name
        Add_A_New_Employee_In_The_System, // 2 - Adds a new employee to the system
        Generate_Random_Employees, // 3 - Generates random employee data
        Display_Employee, // 4 - Displays employee records
        Back_To_Main_Menu               // 5 - Returns to the main menu
    }

//     Enum for patient sub-menu options These are the menu options we would
//     like to present to the user for the patient sub-menu, focusing on patient
//      record and appointment management.
    public enum SubMenuPatientOption {
        Sort_Patients_List, // 0 - Sorts patients by name
        Search_Patients_List, // 1 - Searches patients by name
        Add_A_New_Patient_In_The_System, // 2 - Adds a new patient to the system
        Schedule_A_New_Patient_Appointment, // 3 - Schedules a patient appointment
        Display_Patients, // 4 - Displays patient records
        Back_To_Main_Menu                    // 5 - Returns to the main menu
    }

//     Enum for sorting options These are the menu options we would like to
//     present to the user for sorting data, such as employee or patient lists.
    public enum SortOption {
        Sort_By_Name // 0 - Sorts lists alphabetically by name
    }

//     Enum for search options These are the menu options we would like to
//     present to the user for searching data, such as employees or patients.
    public enum SearchOption {
        Search_By_Name // 0 - Searches by name
    }

//     Enum for displaying patient lists These are the menu options we would
//     like to present to the user for displaying patient records.
    public enum DisplayListOptionPatientsOption {
        Display_Sorted_Patients_List, // 0 - Shows sorted patient list
        Display_Sorted_Patients_Schedules_List  // 1 - Shows sorted patient appointment schedules
    }

//     Enum for displaying employee lists These are the menu options we would
//     like to present to the user for displaying employee records.
    public enum DisplayListOptionEmployeesOption {
        Display_Original_Employee_List, // 0 - Displays the unsorted employee list
        Display_Sorted_Employee_List    // 1 - Displays the sorted employee list
    }
}
