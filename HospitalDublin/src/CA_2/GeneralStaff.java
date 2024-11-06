/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2; // This package where the class will be alocated 

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mikel
 */
public class GeneralStaff extends Employee {//This class will extends employee class that meaning it inherits properties and methods from the class employee

    private final String jobDescription; //This is a private attribute called jobDescriptiion of type Stringto store the job description 
//  This constructor of the class that will receive some parameters
    public GeneralStaff(String name, LocalDate dateOfBirth, String address, BigDecimal salary, DepartmentType.DepartmentOption departmentOption, ManagerType.ManagerOption managerOption, PositionType.PositionOption positionOption, String jobDescription) {
//      This callsthe constructor of the employee superclass to initialize inherited fields
        super(name, dateOfBirth, address, salary, departmentOption, managerOption, positionOption);
        this.jobDescription = jobDescription; // This initializes the jobDescription attribute with the provided value
    }

    // This getter for the jobDescription
    public String getJobDescription() {
//      Will returns the value of description
        return jobDescription;
    }

    @Override // this indicates this method overrides a method in the employee superclass
    public String getType() {
        return "GeneralStaff";//now returns the string genral staff that will indicates which is the employee type
    }

    @Override //Indicates that this method overrides a method in the employees superclass
    public String toString() {
//    now callsthe tostring method of the employee superclass and appends the jobdescription
        return super.toString() + ", Job Description: " + jobDescription;
    }
}
