/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.time.LocalDate;

/**
 *
 * @author Mikel
 */
public abstract class Person { // Declares anabstract class called person that cant be instantiated irectly
//  For this class I declared three protected variables
//  protected because these variables can be accessed by subclasses and otherclasses in the same package

    protected String name;
    protected LocalDate dateOfBirth;
    protected String address;

    public Person(String name, LocalDate dateOfBirth, String address) { //This construct that responsible initialize name, dateOfBirth, and address for a Person object
        this.name = name; // will sets the instance variable name with the prvided value
        this.dateOfBirth = dateOfBirth; // will sets the instance variable dateOfBirth with the provided value
        this.address = address; // will sets the instance variable address with the provided value
    }
    
//    this public method to get the value of name
    public String getName(){
        return name;
    }
//    this public method to get the value of dateOfBirth
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
//   this method to get the value of address
    public String getAdress(){
        return address;
    }
//  This abstract method to ensure that subclasses define their type
    public abstract String getType();
//  Overrides the toString() method from the object class
    @Override
    public String toString(){
//   return a string for representation of the Person object, including name, date of birth, and address.
     return "Name: " + name +
            "\nDate of Birth: " + dateOfBirth +
             "\nAddress: " + address;
            
             }
}
