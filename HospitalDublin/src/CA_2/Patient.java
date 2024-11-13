/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2; // This is the package to which the class Patient belongs 

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Mikel
 */
public class Patient extends Person { //This class called Patient thta will extends the abstract class Person

    private String medicalIssue;// This private instance variable to store the medical issue of the patient
    private DepartmentType.DepartmentOption medicalDepartmentOption; //this variable to store the department option from the enum option
    private String doctorName; // For this private variable to store the name of the doctor.
    private BigDecimal consultationFee;//this private variable to store the date of the appoitment
    private LocalDate appointmentDate;//This private instance variable to store the date of the patient appointment
    private LocalTime appointmentTime;//To store the time of the patient appointment
    private String medicalInsurancetatus;//variable to store the payment status(paid/unpaid)

//   This Constructor 
    public Patient(String name, LocalDate dateOfBirth, String address, String medicalIssue, DepartmentType.DepartmentOption medicalDepartmentOption, String doctorName, BigDecimal consultationFee, LocalDate appointmentDate, LocalTime appointmentTime, String paymentStatus) {
        super(name, dateOfBirth, address);// This calls the parent class Person constructor to initialize name, date of birth, and address
//      Initializes the medical issue
        this.medicalIssue = medicalIssue;
//      Initializes the medical department option
        this.medicalDepartmentOption = medicalDepartmentOption;
//      Initializes the doctor name
        this.doctorName = doctorName;
//      Initializes the consultation fee
        this.consultationFee = consultationFee;
//      Initializes the appointment date
        this.appointmentDate = appointmentDate;
//      Initialize the appointment time
        this.appointmentTime = appointmentTime;
//      Initializes the payment status
        this.medicalInsurancetatus = paymentStatus;
    }
//  this method to get the medical issue

    public String getMedicalIssue() {
        return medicalIssue;
    }
//  this method to get the medical department

    public DepartmentType.DepartmentOption getMedicalDepartment() {
        return medicalDepartmentOption;
    }
//  This method to get the doctors name

    public String getDoctorName() {
        return doctorName;
    }
//  This method to get the consultation fee

    public BigDecimal getConsultationFee() {
        return consultationFee;
    }
//  public method to get the appointment date

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
//  this method to get the appointment time

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }
//  This method to get the payment status

    public String getMedicalInsuranceStatus() {
        return medicalInsurancetatus;
    }
//   This method to set the consultation fee

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.consultationFee = consultationFee;
    }
//  This method to set the appointment date

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
//  This public method to set the payment status

    public void setMedicalInsuranceStatus(String paymentStatus) {
        this.medicalInsurancetatus = paymentStatus;
    }
//  This public method to set the consultation fee 
       public void setConsultationFee(BigDecimal consultationFee) {
        this.consultationFee = consultationFee;
    }

//  This implements the getType() method from the Person class to return "Patient"    

    @Override
    public String getType() {
        return "Patient";
    }

    @Override //Overrides the toString() method to return a string representation of the Patient object
    public String toString() {
//      Now I return all relevant details such as name, etc..
        return "\nName: " + name
                + "\nDate of Birth: " + dateOfBirth
                + "\nAddress: " + address
                + "\nMedical Issue: " + address
                + "\nMedical Issue: " + medicalIssue
                + "\nMedical Department: " + medicalDepartmentOption
                + "\nDoctor: " + (doctorName != null && !doctorName.isEmpty() ? doctorName
                : "N/A")
                + "\nConsultation Fee: " + (consultationFee != null ? consultationFee : "N/A")
                + "\nAppointment Date: " + (appointmentDate != null ? appointmentDate : "N/A")
                + "\nAppointment Time: " + (appointmentTime != null ? appointmentTime : "N/A")
                + "\nPayment Status: " + medicalInsurancetatus + "\n";
    }
}
