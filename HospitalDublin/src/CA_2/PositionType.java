/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CA_2;// This is the package to which the interface PositionType belongs

/**
 *
 * @author Mikel
 */
public interface PositionType {
    enum PositionOption{
//      These are the menu options we would like to present to the user for the positions types
        DOCTOR_ASSISTANT, //0
        RESIDENT_PHYSICIAN, //1
        HOSPITAL_ADMINISTRATIVE_ASSISTANT,//2
        DEPARTMENT_HEAD,//3
        RADIOLOGY_NURSE,//4
        CLEANING_STAFF//5
    }
    
}
