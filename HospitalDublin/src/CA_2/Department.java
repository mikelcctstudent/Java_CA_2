/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// This is the package to which the abstract class Department belongs

/**
 * This class for department attributes, etc.
 *
 * @author Mikel
 */
public abstract class Department { //I declared one abstract class called department, 
//    in this case this classe cant be instaciate directry
//  For this class I will have two variables and final instance variables id and name final 
//  that will indicates these variables can not be altered after being initialized

    private final String name;

    public Department(HospitalOptions.DepartmentOption departmentOption) { //Constructor using department type that was created and this constructor  will
//     accepter those parameters 
        departmentOption.name(); // This will initializes the instance variables id using the name of the provided enum
        this.name = departmentOption.name(); // This will initializes the intance for variable name using the name of the provided enum
    }
//  Public method to get the value of name

    public String getName() {
//        this will return the name
        return name;
    }

}
