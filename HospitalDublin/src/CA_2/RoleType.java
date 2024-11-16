/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CA_2;// This is the package to which the interface RoleType belongs

/**
 * This interface will have the roles for employees in the hospital system, and
 * will provide a structured way to handler the types of roles employees can
 * assume in a hospital
 *
 * @author Mikel
 */
public interface RoleType {
//      These are the menu options we would like to present to the user for the manager types

    enum RoleOption {
        General_Manager, //0
        Nurse_Administrator,//1
        Medical_Director,//2
        HR_Manager,//3
        Clinical_Manager//4
    }

}
