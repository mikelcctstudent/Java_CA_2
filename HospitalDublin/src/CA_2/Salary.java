/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
//Impots that will be used in this class

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

/**
 * This class handles salary calculations and stores hourly rates for different
 * departments. And the intention is centralizing salary-related logic. Thinking
 * in avoid salary calculation redundancy, all related logic is managed in this
 * class, and hourly rates are associated with departments to ensure roles are
 * compensated appropriately. 
 * Author: Mikel
 */
public class Salary {

    // Default working hours in a year for full-time employees
    private static final int WORKED_HOURS_PER_YEAR = 2080;

    // Instance variables for storing an employee's hourly rate and total hours worked
    private final BigDecimal hourlyRate; // Each employee's base hourly rate
    private final int hoursWorked; // Total hours worked by the employee (can vary in part-time roles)

    // This map stores hourly rates for each department, enabling quick and consistent access
    private static final Map<HospitalOptions.DepartmentOption, BigDecimal> departmentHourlyRates = new EnumMap<>(HospitalOptions.DepartmentOption.class);

    // This is static block to initialize hourly rates for each department
    static {
        // By defining rates in a centralized location, we ensure consistency in salary calculations
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Cardiology, BigDecimal.valueOf(50));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Neurology, BigDecimal.valueOf(45));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Oncology, BigDecimal.valueOf(55));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Emergency, BigDecimal.valueOf(60));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Pediatrics, BigDecimal.valueOf(40));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Orthopedics, BigDecimal.valueOf(56));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Human_Resources, BigDecimal.valueOf(50));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.General_Services, BigDecimal.valueOf(45));
    }

    /**
     * This constructor simplifies cases where employees work standard hours
     * (2080 hours/year). It delegates to the more generic constructor to avoid
     * duplication of initialization logic.
     */
    public Salary(BigDecimal hourlyRate) {
        this(hourlyRate, WORKED_HOURS_PER_YEAR);
    }

    /**
     * Constructor for employees with custom hours worked to handle cases like
     * part-time or contract employees who may work fewer hours.
     */
    public Salary(BigDecimal hourlyRate, int hoursWorked) {
        this.hourlyRate = hourlyRate; // Initialize the employee's hourly rate
        this.hoursWorked = hoursWorked; // Initialize the total hours worked
    }

    /**
     * Calculates total salary based on hourly rate and hours worked. This
     * method allows calculating salaries of individual employees. It also
     * ensures precision by rounding results to two decimal places and will
     * return total salary as BigDecimal
     */
    public BigDecimal calculateTotalSalary() {
        return hourlyRate.multiply(BigDecimal.valueOf(hoursWorked)) // Multiply hourly rate by hours worked
                .setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places for financial calculations
    }

    /**
     * Calculates the annual salary for an employee based on department and role
     * and this method encapsulates the logic for dynamic it ensures salary
     * calculations remain consistent and centralized.
     */
    public static BigDecimal calculateSalary(HospitalOptions.DepartmentOption department, HospitalOptions.RoleOption role) {
        BigDecimal baseHourlyRate = getHourlyRateFromDepartment(department); // Retrieve base hourly rate for the department
        BigDecimal adjustedHourlyRate = applyRoleBonus(baseHourlyRate, role); // Adjust hourly rate based on role

        // Calculate annual salary by multiplying adjusted rate with default hours
        return adjustedHourlyRate.multiply(BigDecimal.valueOf(WORKED_HOURS_PER_YEAR))
                .setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places
    }

    /**
     * This method will adjusts the hourly rate based on role-specific bonuses
     * and role bonuses are defined here to maintain separation of concerns.
     * This avoids hard coding bonuses in unrelated parts of the system.
     */
    private static BigDecimal applyRoleBonus(BigDecimal baseHourlyRate, HospitalOptions.RoleOption role) {
        if (role == HospitalOptions.RoleOption.Medical_Director) {
            return baseHourlyRate.add(BigDecimal.valueOf(20)); // Bonus for Medical Director
        } else if (role == HospitalOptions.RoleOption.Nurse_Administrator) {
            return baseHourlyRate.add(BigDecimal.valueOf(10)); // Bonus for Nurse Administrator
        }
        return baseHourlyRate; // No bonus for other roles
    }

    /**
     * This will retrieves the hourly rate for a specific department and the
     * hourly rate retrieval here ensures consistent values are used across the
     * system. Defaulting to zero prevents unexpected errors when a department
     * is missing.
     */
    public static BigDecimal getHourlyRateFromDepartment(HospitalOptions.DepartmentOption department) {
        return departmentHourlyRates.getOrDefault(department, BigDecimal.ZERO); // Retrieve hourly rate or default to 0
    }

    @Override
    public String toString() {
        return calculateTotalSalary() + " EUR"; // Return the calculated total salary as a formatted string with the currency
    }
}
