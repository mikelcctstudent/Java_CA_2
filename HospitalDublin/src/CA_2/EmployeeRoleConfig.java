/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;// Declares the package name where this class belongs

import java.util.Map; // Import statement for using the Map interface

/**
 * This class will be responsible for defining mapping between employee types,
 * departments, positions, and roles, and this will help ensure that each
 * employee type is associated with the appropriate type in the system.
 *
 * @author Mikel
 */
public class EmployeeRoleConfig {// Class to map coherent combinations between EmployeeType, Department, Position, and Role

    // A public static final Map that links each EmployeeType.EmployeeOption to an array of appropriate DepartmentType.DepartmentOption(s)
    public static final Map<EmployeeType.EmployeeOption, DepartmentType.DepartmentOption[]> DEPARTMENT_OPTIONS = Map.of(// For EmployeeType Doctor, associate the departments: Cardiology, Neurology, Oncology
            EmployeeType.EmployeeOption.Doctor, new DepartmentType.DepartmentOption[]{
                DepartmentType.DepartmentOption.Cardiology,
                DepartmentType.DepartmentOption.Neurology,
                DepartmentType.DepartmentOption.Oncology,
                DepartmentType.DepartmentOption.Emergency
            },
            // For EmployeeType Nurse, associate the departments: Pediatrics, Emergency, Orthopedics
            EmployeeType.EmployeeOption.Nurse, new DepartmentType.DepartmentOption[]{
                DepartmentType.DepartmentOption.Pediatrics,
                DepartmentType.DepartmentOption.Emergency,
                DepartmentType.DepartmentOption.Orthopedics
            },
            // For EmployeeType Administrative_Assistant, associate the department: Human_Resources
            EmployeeType.EmployeeOption.Administrative_Assistant, new DepartmentType.DepartmentOption[]{
                DepartmentType.DepartmentOption.Human_Resources
            },
            // For EmployeeType General_Staff, associate the departments: Emergency, Human_Resources, SUPPORT_SERVICES
            EmployeeType.EmployeeOption.General_Staff, new DepartmentType.DepartmentOption[]{
                DepartmentType.DepartmentOption.Human_Resources,
                DepartmentType.DepartmentOption.General_Services
            }
    );

    // A public static final Map that links each EmployeeType.EmployeeOption to an array of appropriate PositionType.PositionOption(s)
    public static final Map<EmployeeType.EmployeeOption, PositionType.PositionOption[]> POSITION_OPTIONS = Map.of(// For EmployeeType Doctor, associate the positions: Surgeon, Geriatric_Medicine
            EmployeeType.EmployeeOption.Doctor, new PositionType.PositionOption[]{
                PositionType.PositionOption.Surgeon,
                PositionType.PositionOption.Geriatric_Medicine
            },
            // For EmployeeType Nurse, associate the position: Radiology_Nurse
            EmployeeType.EmployeeOption.Nurse, new PositionType.PositionOption[]{
                PositionType.PositionOption.Radiology_Nurse
            },
            // For EmployeeType Administrative_Assistant, associate the position: Administrative_Assistant
            EmployeeType.EmployeeOption.Administrative_Assistant, new PositionType.PositionOption[]{
                PositionType.PositionOption.Administrative_Assistant
            },
            // For EmployeeType General_Staff, associate the position: Cleaner
            EmployeeType.EmployeeOption.General_Staff, new PositionType.PositionOption[]{
                PositionType.PositionOption.Cleaner
            }
    );

    // A public static final Map that links each EmployeeType.EmployeeOption to a specific RoleType.RoleOption (manager role)
    public static final Map<EmployeeType.EmployeeOption, RoleType.RoleOption> ROLE_OPTIONS = Map.of(// For EmployeeType Doctor, the manager is Medical_Director
            EmployeeType.EmployeeOption.Doctor, RoleType.RoleOption.Medical_Director,
            // For EmployeeType Nurse, the manager is Nurse_Administrator
            EmployeeType.EmployeeOption.Nurse, RoleType.RoleOption.Nurse_Administrator,
            // For EmployeeType Administrative_Assistant, the manager is HR_Manager
            EmployeeType.EmployeeOption.Administrative_Assistant, RoleType.RoleOption.HR_Manager,
            // For EmployeeType General_Staff, the manager is General_Manager
            EmployeeType.EmployeeOption.General_Staff, RoleType.RoleOption.General_Manager
    );

}
