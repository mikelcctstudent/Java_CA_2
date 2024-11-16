/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CA_2;// This is the package to which the enum interface DepartmentType belongs

/**
 * This class is responsible for department enums
 *
 * @author Mikel
 */
public interface DepartmentType {
//  These are the menu options we would like to present to the user for the department option

    enum DepartmentOption {
        // These are the menu options we would like to present to the user
        Cardiology,//0
        Neurology,//1
        Oncology,//2
        Emergency,//3
        Pediatrics,//4
        Orthopedics,//5
        Human_Resources,//6
        General_Services//7
    }
}
