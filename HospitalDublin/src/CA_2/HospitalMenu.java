/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CA_2;// This is the package to which the interface HospitalMenu belongs

/**
 * This interface class contains enums that define the menus options in the
 * system
 *
 * @author Mikel
 */
public interface HospitalMenu {
// These are the menu options we would like to present to the user for the main menu options

    enum MenuOption {
        Manage_Employees,//0
        Manage_Patients,//1
        Exit_Of_The_System//2
    }
//  These are the menu options we would like to present to the user for the sub menu employees

    enum SubMenuEmployee {
        Sort_Employees_List,//0
        Search_Employees_List,//1
        Add_A_New_Employee_In_The_System,//2
        Generate_Random_Employees,//3
        Display_Employee,//4
        Back_To_Main_Menu//5
    }
//  These are the menu options we would like to present to the user for the sub menu patients

    enum SubMenuPatient {
        Sort_Patients_List,//0
        Search_Patients_List,//1
        Add_A_New_Patient_In_The_System,//2
        Schedule_A_New_Patient_Appointment,//3
        Display_Patients,//4
        Back_To_Main_Menu//5
    }
//      These are the menu options we would like to present to the user for the sort option

    enum SortOption {

        Sort_By_Name//0
    }

//  These are the menu options we would like to present to the user for show list options patients
    enum SearchOption {
        Search_By_Name
    }

//  These are the menu options we would like to present to the user for show list options patients
    enum DisplayListOptionPatients {
        Display_Sorted_Patients_List,//0
        Display_Sorted_Patients_Schedules_List//1
    }
//  These are the menu options we would like to present to the user for the show list option

    enum DisplayListOptionEmployees {
        Display_Original_Employee_List,//0
        Display_Sorted_Employee_List//1
    }
}
