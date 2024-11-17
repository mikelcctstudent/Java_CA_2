/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// This is the package to which the class Employee belongs

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * This class its for employee and extender Person, this will contain all logic
 * for employee in the system, also the constructors, and the to string for
 * represent a obj employee
 *
 * @author Mikel
 */
public class Employee extends Person { //This class employee will extends the abstract class Person

    private BigDecimal salary; // This variable its for manually entered salary
    private Salary calculatedSalary; //This the salary calculated using hourly rates the type will salary object
//  This will declare private instance variables for department, manager, and position options, likely enums for predefinedoptions
    private final HospitalOptions.DepartmentOption departmentOption;
    private final HospitalOptions.RoleOption managerOption;
    private final HospitalOptions.PositionOption positionOption;
    private final HospitalOptions.EmployeeOption employeeOption; // Type of rule of the employee

//    Specific field for certain employee roles
    private String shift; // Shift for nurses, for xample morning, night

//  Now I created two type os constructor one for manually entered salary for the user and another one for calculated salary
//  using the Salary object
    public Employee(String name, LocalDate dateOfBirth, String address, BigDecimal salary, HospitalOptions.DepartmentOption departmentOption, HospitalOptions.RoleOption managerOption, HospitalOptions.PositionOption positionOption, HospitalOptions.EmployeeOption employeeOption) {
        super(name, dateOfBirth, address); // This part will calls the parent Person class constructor to initialize name, date of birth, and address
        this.salary = salary; // Initializes the salary with the manually entered value.
        this.departmentOption = departmentOption; //Initializes the department options with the values that was provided
        this.managerOption = managerOption;//Initializes the manager options with the values that was provided
        this.positionOption = positionOption;//Initializes the position options with the values that was provided
        this.employeeOption = employeeOption;
    }
//This one I will use just for calculated salary

    public Employee(String name, LocalDate dateOfBirth, String address, Salary calculatedSalary, HospitalOptions.DepartmentOption departmentOption, HospitalOptions.RoleOption managerOption, HospitalOptions.PositionOption positionOption, HospitalOptions.EmployeeOption employeeOption) {
        super(name, dateOfBirth, address); //In this part we calls the parent PErson class constructor to initialize name, date of birth,address
        this.calculatedSalary = calculatedSalary;// Initializes the salary with the manually entered value.
        this.departmentOption = departmentOption;//Initializes the department options with the values that was provided
        this.managerOption = managerOption;//Initializes the manager options with the values that was provided
        this.positionOption = positionOption;//Initializes the position options with the values that was provided
        this.employeeOption = employeeOption;

    }
    // Getter for shift (specific to nurses)

    public String getShift() {
        return shift;
    }
//  This method returns the salary that can be manual or calculated

    public String getSalary() {
//      Will returns a string representation of the salary for both ways manual or calculated value
        return (salary != null ? salary + " EUR" : calculatedSalary.toString());
    }
//  This method is to get the department option

    public HospitalOptions.DepartmentOption getDepartmentType() {
        return departmentOption;
    }
//  This method to get the manager option

    public HospitalOptions.RoleOption getManagerType() {
        return managerOption;
    }
//  This method is to get the position option

    public HospitalOptions.PositionOption getPositionType() {
        return positionOption;
    }

    // This method for employee role type
    public HospitalOptions.EmployeeOption getEmployeeOption() {
        return employeeOption;
    }

    @Override
    public String getType() { // This method implements the abstract method from the Person class, returning the type of this class as employee
        return employeeOption.name();
    }

    // Setter for shift
    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override // will provide a string representation of the employee obejct
    public String toString() {
        return "\nName: " + getName()
                + "\nDate of Birth: " + getDateOfBirth()
                + "\nAddress: " + getAddress()
                + "\nDepartment: " + getDepartmentType()
                + "\nSalary: " + getSalary()
                + "\nManager: " + getManagerType()
                + "\nPosition: " + getPositionType()
                + "\nEmployee: " + getEmployeeOption();
    }

}
