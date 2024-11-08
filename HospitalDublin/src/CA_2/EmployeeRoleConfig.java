/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// Declares the package name where this class belongs

import java.util.Map; // Import statement for using the Map interface

/**
 *
 * @author Mikel
 */
public class EmployeeRoleConfig {// Class to map coherent combinations between EmployeeType, Department, Position, and Role


    // A public static final Map that links each EmployeeType.EmployeeOption to an array of appropriate DepartmentType.DepartmentOption(s)
    public static final Map<EmployeeType.EmployeeOption, DepartmentType.DepartmentOption[]> DEPARTMENT_OPTIONS = Map.of(
            // For EmployeeType DOCTOR, associate the departments: CARDIOLOGY, NEUROLOGY, ONCOLOGY
            EmployeeType.EmployeeOption.DOCTOR, new DepartmentType.DepartmentOption[]{
                    DepartmentType.DepartmentOption.CARDIOLOGY,
                    DepartmentType.DepartmentOption.NEUROLOGY,
                    DepartmentType.DepartmentOption.ONCOLOGY
            },
            // For EmployeeType NURSE, associate the departments: PEDIATRICS, EMERGENCY, ORTHOPEDICS
            EmployeeType.EmployeeOption.NURSE, new DepartmentType.DepartmentOption[]{
                    DepartmentType.DepartmentOption.PEDIATRICS,
                    DepartmentType.DepartmentOption.EMERGENCY,
                    DepartmentType.DepartmentOption.ORTHOPEDICS
            },
            // For EmployeeType ADMINISTRATIVE_ASSISTANT, associate the department: ADMINISTRATION
            EmployeeType.EmployeeOption.ADMINISTRATIVE_ASSISTANT, new DepartmentType.DepartmentOption[]{
                    DepartmentType.DepartmentOption.ADMINISTRATION
            },
            // For EmployeeType GENERAL_STAFF, associate the departments: EMERGENCY, ADMINISTRATION, SUPPORT_SERVICES
            EmployeeType.EmployeeOption.GENERAL_STAFF, new DepartmentType.DepartmentOption[]{
                    DepartmentType.DepartmentOption.EMERGENCY,
                    DepartmentType.DepartmentOption.ADMINISTRATION,
                    DepartmentType.DepartmentOption.SUPPORT_SERVIVES
            }
    );

    // A public static final Map that links each EmployeeType.EmployeeOption to an array of appropriate PositionType.PositionOption(s)
    public static final Map<EmployeeType.EmployeeOption, PositionType.PositionOption[]> POSITION_OPTIONS = Map.of(
            // For EmployeeType DOCTOR, associate the positions: DOCTOR_ASSISTANT, RESIDENT_PHYSICIAN
            EmployeeType.EmployeeOption.DOCTOR, new PositionType.PositionOption[]{
                    PositionType.PositionOption.DOCTOR_ASSISTANT,
                    PositionType.PositionOption.RESIDENT_PHYSICIAN
            },
            // For EmployeeType NURSE, associate the position: RADIOLOGY_NURSE
            EmployeeType.EmployeeOption.NURSE, new PositionType.PositionOption[]{
                    PositionType.PositionOption.RADIOLOGY_NURSE
            },
            // For EmployeeType ADMINISTRATIVE_ASSISTANT, associate the position: HOSPITAL_ADMINISTRATIVE_ASSISTANT
            EmployeeType.EmployeeOption.ADMINISTRATIVE_ASSISTANT, new PositionType.PositionOption[]{
                    PositionType.PositionOption.HOSPITAL_ADMINISTRATIVE_ASSISTANT
            },
            // For EmployeeType GENERAL_STAFF, associate the position: CLEANING_STAFF
            EmployeeType.EmployeeOption.GENERAL_STAFF, new PositionType.PositionOption[]{
                    PositionType.PositionOption.CLEANING_STAFF
            }
    );

    // A public static final Map that links each EmployeeType.EmployeeOption to a specific RoleType.ManagerOption (manager role)
    public static final Map<EmployeeType.EmployeeOption, RoleType.ManagerOption> MANAGER_OPTIONS = Map.of(
            // For EmployeeType DOCTOR, the manager is MEDICAL_DIRECTOR
            EmployeeType.EmployeeOption.DOCTOR, RoleType.ManagerOption.MEDICAL_DIRECTOR,
            // For EmployeeType NURSE, the manager is NURSE_MANAGER
            EmployeeType.EmployeeOption.NURSE, RoleType.ManagerOption.NURSE_MANAGER,
            // For EmployeeType ADMINISTRATIVE_ASSISTANT, the manager is HR_MANAGER
            EmployeeType.EmployeeOption.ADMINISTRATIVE_ASSISTANT, RoleType.ManagerOption.HR_MANAGER,
            // For EmployeeType GENERAL_STAFF, the manager is GENERAL_MANAGER
            EmployeeType.EmployeeOption.GENERAL_STAFF, RoleType.ManagerOption.GENERAL_MANAGER
    );
    
}
