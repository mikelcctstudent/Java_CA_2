/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

/**
 * This lass will managing salary polices for different departments in the
 * system
 *
 * @author Mikel
 */
public class HospitalSalaryPolicy { //This class its responsible for the salary policies of the differents departments in the hospital

    private final Map<DepartmentType.DepartmentOption, BigDecimal> departmentHourlyRates;//This declares a private final instance variable which is a map to store the hourly rates for diffent departments
//  The keys are of type department and the values are BigDecimal for pricise rates

    public HospitalSalaryPolicy() { //This constructor for the class

        departmentHourlyRates = new EnumMap<>(DepartmentType.DepartmentOption.class);// This initialize the departmentHourlyRates map with an EnumMap
//      In this case I decided use EnumMap because is more efficient than other Map implementatitons when using enum keys

//        Fills the map with predefined hourly rates for each departments that I created into the class Department type
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Cardiology, BigDecimal.valueOf(50));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Neurology, BigDecimal.valueOf(45));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Oncology, BigDecimal.valueOf(55));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Emergency, BigDecimal.valueOf(60));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Pediatrics, BigDecimal.valueOf(40));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Orthopedics, BigDecimal.valueOf(56));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.Human_Resources, BigDecimal.valueOf(50));
        departmentHourlyRates.put(DepartmentType.DepartmentOption.General_Services, BigDecimal.valueOf(45));

    }
//  This method to get the hourly rate for a given department

    public BigDecimal getHourlyRate(DepartmentType.DepartmentOption departmentOption) {
        return departmentHourlyRates.getOrDefault(departmentOption, BigDecimal.ZERO);//This retrieves the hourly rate for the specified department from the map
//      If the department is not found in the map, it returns BigDecimal.ZERO by default value  
    }
}
