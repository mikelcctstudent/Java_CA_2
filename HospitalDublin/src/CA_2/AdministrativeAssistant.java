/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;//This is the package where this class belongs

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mikel
 */
public class AdministrativeAssistant extends Employee { // Declares the class that extender Employees

    private final String responsibility; //This a private attribute called responsibility of type String

    public AdministrativeAssistant(String name, LocalDate dateOfBirth, String address, BigDecimal salary, DepartmentType.DepartmentOption departmentOption, ManagerType.ManagerOption managerOption, PositionType.PositionOption positionOption, String responsibility) {
//        Calls the constructor of the base class Employee to initialize inherited attributes
        super(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption);
        this.responsibility = responsibility; // Initializes the responsability attribute with the provided value
    }
//  Getter for the responsibility attribute

    public String getResponsibility() {
        return responsibility; //Returns the value of responsibility
    }

    @Override//This indicates that this method overrides a method in the base class
    public String getType() {
        return "AdministrativeAssistant"; //Returns the string "AdministrativeAssitent" indicating the employee type.
    }

    @Override
    public String toString() {
//     This part calls the toString() method of the base Employee class and appends the responsibility 
        return super.toString() + ", Responsibility: " + responsibility;
    }
}
