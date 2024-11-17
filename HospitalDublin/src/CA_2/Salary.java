package CA_2;// This is the package to which the class Salary belongs

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

/**
 * This class will represent the salary in this system, and also we have some
 * methods for calculating the total salary for employees. It also stores the
 * hourly rates for different departments.
 *
 * @author Mikel
 */
public class Salary {// This class will be responsible for calculation of a salary based on an hourly rate and hours worked

    private static final int workedHoursPerYear = 2080; // This is a constant for the default number of hours worked per year 
    private final BigDecimal hourlyRate; // This final instance variable stores the hourly rate
    private final int hoursWorked; // This variable stores the number of hours worked

    // Map to store hourly rates for each department
    private static final Map<HospitalOptions.DepartmentOption, BigDecimal> departmentHourlyRates = new EnumMap<>(HospitalOptions.DepartmentOption.class);

    static {
        // Initializing the departmentHourlyRates map with predefined hourly rates
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Cardiology, BigDecimal.valueOf(50));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Neurology, BigDecimal.valueOf(45));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Oncology, BigDecimal.valueOf(55));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Emergency, BigDecimal.valueOf(60));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Pediatrics, BigDecimal.valueOf(40));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Orthopedics, BigDecimal.valueOf(56));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.Human_Resources, BigDecimal.valueOf(50));
        departmentHourlyRates.put(HospitalOptions.DepartmentOption.General_Services, BigDecimal.valueOf(45));
    }

    public Salary(BigDecimal hourlyRate) { // This constructor sets the hourly rate with default hours
        this(hourlyRate, workedHoursPerYear);
    }

    public Salary(BigDecimal hourlyRate, int hoursWorked) { // This constructor sets the hourly rate and hours worked
        this.hourlyRate = hourlyRate; // Sets the hourly rate
        this.hoursWorked = hoursWorked; // Sets the hours worked
    }

    // This method calculates the total salary based on hourly rate and hours worked
    public BigDecimal calculateTotalSalary() {
        return hourlyRate.multiply(BigDecimal.valueOf(hoursWorked)).setScale(2, RoundingMode.HALF_UP); // Multiplying hourly rate by hours worked
    }

    // Method to get hourly rate for a specific department
    public static BigDecimal getHourlyRateFromDepartment(HospitalOptions.DepartmentOption department) {
        return departmentHourlyRates.getOrDefault(department, BigDecimal.ZERO); // Retrieves the hourly rate for the department or returns zero if not found
    }

    @Override
    public String toString() {
        return calculateTotalSalary() + " EUR"; // Returns a string representation of the total salary including the Euro symbol
    }
}
