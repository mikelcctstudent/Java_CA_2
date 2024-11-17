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
    public static final Map<HospitalOptions.EmployeeOption, HospitalOptions.DepartmentOption[]> DEPARTMENT_OPTIONS = Map.of(// For EmployeeType Doctor, associate the departments: Cardiology, Neurology, Oncology
            HospitalOptions.EmployeeOption.Doctor, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Cardiology,
                HospitalOptions.DepartmentOption.Neurology,
                HospitalOptions.DepartmentOption.Oncology,
                HospitalOptions.DepartmentOption.Emergency
            },
            // For EmployeeType Nurse, associate the departments: Pediatrics, Emergency, Orthopedics
            HospitalOptions.EmployeeOption.Nurse, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Pediatrics,
                HospitalOptions.DepartmentOption.Emergency,
                HospitalOptions.DepartmentOption.Orthopedics
            },
            // For EmployeeType Administrative_Assistant, associate the department: Human_Resources
            HospitalOptions.EmployeeOption.Administrative_Assistant, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Human_Resources
            },
            // For EmployeeType General_Staff, associate the departments: Emergency, Human_Resources, SUPPORT_SERVICES
            HospitalOptions.EmployeeOption.General_Staff, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Human_Resources,
                HospitalOptions.DepartmentOption.General_Services
            }
    );

    // A public static final Map that links each EmployeeType.EmployeeOption to an array of appropriate PositionType.PositionOption(s)
    public static final Map<HospitalOptions.EmployeeOption, HospitalOptions.PositionOption[]> POSITION_OPTIONS = Map.of(// For EmployeeType Doctor, associate the positions: Surgeon, Geriatric_Medicine
            HospitalOptions.EmployeeOption.Doctor, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Surgeon,
                HospitalOptions.PositionOption.Geriatric_Medicine
            },
            // For EmployeeType Nurse, associate the position: Radiology_Nurse
            HospitalOptions.EmployeeOption.Nurse, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Radiology_Nurse
            },
            // For EmployeeType Administrative_Assistant, associate the position: Administrative_Assistant
            HospitalOptions.EmployeeOption.Administrative_Assistant, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Administrative_Assistant
            },
            // For EmployeeType General_Staff, associate the position: Cleaner
            HospitalOptions.EmployeeOption.General_Staff, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Cleaner
            }
    );

    // A public static final Map that links each EmployeeType.EmployeeOption to a specific RoleType.RoleOption (manager role)
    public static final Map<HospitalOptions.EmployeeOption, HospitalOptions.RoleOption> ROLE_OPTIONS = Map.of(// For EmployeeType Doctor, the manager is Medical_Director
            HospitalOptions.EmployeeOption.Doctor, HospitalOptions.RoleOption.Medical_Director,
            // For EmployeeType Nurse, the manager is Nurse_Administrator
            HospitalOptions.EmployeeOption.Nurse, HospitalOptions.RoleOption.Nurse_Administrator,
            // For EmployeeType Administrative_Assistant, the manager is HR_Manager
            HospitalOptions.EmployeeOption.Administrative_Assistant, HospitalOptions.RoleOption.HR_Manager,
            // For EmployeeType General_Staff, the manager is General_Manager
            HospitalOptions.EmployeeOption.General_Staff, HospitalOptions.RoleOption.General_Manager
    );

}
