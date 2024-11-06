/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CA_2;// This is the package to which the interface HospitalMenu belongs

/**
 *
 * @author Mikel
 */
public interface HospitalMenu {
// These are the menu options we would like to present to the user for the main menu options

    enum MenuOption {
        MANAGE_EMPLOYEES,//0
        MANAGE_PATIENTS,//1
        EXIT//2
    }
//  These are the menu options we would like to present to the user for the sub menu employees

    enum SubMenuEmployee {
        SORT,//0
        SEARCH,//1
        ADD_EMPLOYEE,//2
        GENERATE_RANDOM_EMPLOYEE,//3
        SHOW_EMPLOYEE_LIST,//4
        BACK//5
    }
//  These are the menu options we would like to present to the user for the sub menu patients

    enum SubMenuPatient {
        SORT,//0
        SEARCH,//1
        ADD_PATIENTS,//2
        SCHEDULE_CONSULTATION,//3
        SHOW_APPOINTMENT_LIST,//4
        BACK//5
    }
//      These are the menu options we would like to present to the user for the sort option

    enum SortOption {

        SEARCH_BY_NAME//0
    }
    
//  These are the menu options we would like to present to the user for show list options patients

     enum SearchOption {
        SEARCH_BY_NAME
    }
    
//  These are the menu options we would like to present to the user for show list options patients

    enum ShowListOptionPatient {
        SHOW_SORTED_PATIENTS,//0
        SHOW_SORTED_SCHEDULES//1
    }
//  These are the menu options we would like to present to the user for the show list option

    enum ShowListOption {
        SHOW_ORIGINAL_LIST,//0
        SHOW_SORTED_LIST//1
    }
}
