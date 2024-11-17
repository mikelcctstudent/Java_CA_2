/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.Map;

/**
 * This class defines mappings between employee types, departments, positions,
 * and roles. It acts as a configuration class to ensure that only valid
 * combinations of these attributes are used within the system.
 *
 * Author: Mikel
 */
public class EmployeeRoleConfig {

    // Map defining valid department options for each employee type
    public static final Map<HospitalOptions.EmployeeOption, HospitalOptions.DepartmentOption[]> DEPARTMENT_OPTIONS = Map.of(
            // For doctors, the valid departments include Cardiology, Neurology, Oncology, and Emergency
            HospitalOptions.EmployeeOption.Doctor, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Cardiology,
                HospitalOptions.DepartmentOption.Neurology,
                HospitalOptions.DepartmentOption.Oncology,
                HospitalOptions.DepartmentOption.Emergency
            },
            // For nurses, the valid departments include Pediatrics, Emergency, and Orthopedics
            HospitalOptions.EmployeeOption.Nurse, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Pediatrics,
                HospitalOptions.DepartmentOption.Emergency,
                HospitalOptions.DepartmentOption.Orthopedics
            },
            // For administrative assistants, the only valid department is Human Resources
            HospitalOptions.EmployeeOption.Administrative_Assistant, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.Human_Resources
            },
            // For general staff, the only valid department is General Services
            HospitalOptions.EmployeeOption.General_Staff, new HospitalOptions.DepartmentOption[]{
                HospitalOptions.DepartmentOption.General_Services
            }
    );

    // Map defining valid role options (managerial roles) for each employee type
    public static final Map<HospitalOptions.EmployeeOption, HospitalOptions.RoleOption> ROLE_OPTIONS = Map.of(
            // Doctors are managed by a Medical Director
            HospitalOptions.EmployeeOption.Doctor, HospitalOptions.RoleOption.Medical_Director,
            // Nurses are managed by a Nurse Administrator
            HospitalOptions.EmployeeOption.Nurse, HospitalOptions.RoleOption.Nurse_Administrator,
            // Administrative assistants are managed by an HR Manager
            HospitalOptions.EmployeeOption.Administrative_Assistant, HospitalOptions.RoleOption.HR_Manager,
            // General staff are managed by a Supervisor
            HospitalOptions.EmployeeOption.General_Staff, HospitalOptions.RoleOption.Supervisor
    );

    // Map defining valid position options for each employee type
    public static final Map<HospitalOptions.EmployeeOption, HospitalOptions.PositionOption[]> POSITION_OPTIONS = Map.of(
            // Doctors can take on positions like Surgeon or Geriatric Medicine specialist
            HospitalOptions.EmployeeOption.Doctor, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Surgeon,
                HospitalOptions.PositionOption.Geriatric_Medicine
            },
            // Nurses can only hold the position of Radiology Nurse
            HospitalOptions.EmployeeOption.Nurse, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Radiology_Nurse
            },
            // Administrative assistants can only hold the position of Administrative Assistant
            HospitalOptions.EmployeeOption.Administrative_Assistant, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Administrative_Assistant
            },
            // General staff can only hold the position of Cleaner
            HospitalOptions.EmployeeOption.General_Staff, new HospitalOptions.PositionOption[]{
                HospitalOptions.PositionOption.Cleaner
            }
    );
}
