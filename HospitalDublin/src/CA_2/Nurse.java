/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2; //This package where this class is located, so the package CA_2 will help usorganize the classes this class.

import java.math.BigDecimal; // this imports BigDecimal for precise decimal number operations
import java.time.LocalDate; // this import LocalDate for date operations

/**
 *
 * @author Mikel
 */
public class Nurse extends Employee {// this class which extends employee class

    private final String shift;//This declare a private attribute named shift of type string to store the nurse shift
    private final String specialization; // this private attribute will contains the specialization of type string to store the nurse specialization

//  This is the constructor of the  class
    public Nurse(String name, LocalDate dateOfBirth, String address, BigDecimal salary, DepartmentType.DepartmentOption departmentOption, ManagerType.ManagerOption managerOption, PositionType.PositionOption positionOption, String shift, String specialization) {
//       Now this super callsthe constructor of the superclass employee to initialize inherited attributes
        super(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption);
        this.shift = shift; //now initializes the shift attribute with the value provided
        this.specialization = specialization;//Initializes the specialization attribute with the value provided
    }

//    This gtter for the shift attribute
    public String getShift() {
        return shift; // returns the value of the shift 
    }
//  this is getter forthe specialization attribute
    public String getSpecialization() {
        return specialization; // will returns the value for specialization
    }

    @Override // This indicates that this method overrides a method in the superclass employee
    public String getType() {
        return "Nurse"; // returns the string nurse 
    }

    @Override// This indicates that this method overrides a method in the superclass employee
    public String toString() {
//      now calls the method of the superclass employee and appends the shift and specialization
        return super.toString() + ", Shift: " + shift + ", Specialization: " + specialization;
    }

}
