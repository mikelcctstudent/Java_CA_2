/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CA_2;// This is the package to which the interface PositionType belongs

/**
 *
 * This class will have all the enums for position type
 *
 * @author Mikel
 */
public interface PositionType {

    enum PositionOption {
//      These are the menu options we would like to present to the user for the positions types
        Surgeon, //0
        Geriatric_Medicine, //1
        Administrative_Assistant,//2
        Human_Resources_Manager,//3
        Radiology_Nurse,//4
        Cleaner//5
    }

}
