/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2; //This is the package where this clss is located

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mikel
 */
public class Doctor extends Employee {// This class will extends Employee, it mening will inherrits properties and methods from the class employee

    private String medicalSpecialty; //This is a private attribute that have the type string to store the doctor specialty
    private String licenseNumber; //This variable will store the license of the doctor 

//  This constructor for manually entering salary 
    public Doctor(String name, LocalDate dateOfBirth, String address, BigDecimal salary, DepartmentType.DepartmentOption departmentOption, RoleType.ManagerOption managerOption, PositionType.PositionOption positionOption, String medicalSpecialty, String licenseNumber) {
//      This calls the constructor of the employee superclass to initialize inherited fields
        super(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption);
        this.medicalSpecialty = medicalSpecialty; //This initializes the medicalSpeciality attributes with the provided value
        this.licenseNumber = licenseNumber; //For this initializes the licenseNumber attribute with the provided value
    }
//  This constructor for calculated salary

    public Doctor(String name, LocalDate dateOfBirth, String address, Salary calculatedSalary, DepartmentType.DepartmentOption departmentOption, RoleType.ManagerOption managerOption, PositionType.PositionOption positionOption, String medicalSpecialty, String licenseNumber) {
//      This calls the constructor of the Employee superclass to initialize inherited fields
        super(name, dateOfBirth, address, calculatedSalary, departmentOption, managerOption, positionOption);
        this.medicalSpecialty = medicalSpecialty;//Initializes the medicalSpecialty attribute with the provided value
        this.licenseNumber = licenseNumber; //and this attribute with the provided value.
    }
//  This getter for the medicalSpecialty attribute

    public String getMedicalSpecialty() {
        return medicalSpecialty;//Will returns the value for this attribute
    }
//  This getter for the second attribute

    public String getLicenseNumber() {
        return licenseNumber;//and will returns the value of this variable
    }

    @Override //This indicates that method overrides a method in the employees superclass
    public String getType() {
//        now will returns the string Doctor indicating the employee type is Doctor
        return "Doctor";
    }

    @Override//Indicates that this method overrides a method in the employee superclass
    public String toString() {
//      Calls the toString() method of the employee superclass and appends the doctors medical specialty and also the license number
        return super.toString() + "\nSpecialty: " + medicalSpecialty + "\nLicense: " + licenseNumber;
    }
}
