/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Mikel
 */
public class Salary {// This class will be responsible for calculation of a salary based on an hourly rate and hours worked

    private static final int workedHoursPerYear = 2080;// This a constant for the default number of hours worked per year 
//    that will represent full-time employees
    private final BigDecimal hourlyRate;// this final instance variable to store the hourly rate
    private final int hoursWorked; // and this one to store the number of hours worked

    public Salary(BigDecimal hourlyRate){//This constructor that sets the hourly with default hours, this will help generate randomlly the employees
        this(hourlyRate, workedHoursPerYear);
    }
    
    public Salary(BigDecimal hourlyRate, int hoursWorked) {//This constructor that will sets the hourly rate with default hours
        this.hourlyRate = hourlyRate; // Sets the hourly rate with the provided value
        this.hoursWorked = hoursWorked; // Sets the hours worked with the 
    }
// this method calculates the total salary based on hourly rate and hours worked
    public BigDecimal calculateTotalSalary() {
        return hourlyRate.multiply(BigDecimal.valueOf(hoursWorked)).setScale(2, RoundingMode.HALF_UP);//now we multiples the hourly rate by the hours
//      worked to get the total salary
//      sets the scale to 2 decimal places and rounds the result to the nearest value using half_up rounding mode
       
    }
//
    @Override
    public String toString() {
        return calculateTotalSalary() + " EUR";// now was returns a string representation of the total salary including the euro syymbol
    }
}
