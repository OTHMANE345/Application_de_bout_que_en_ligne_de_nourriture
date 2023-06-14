package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class patientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointementService appointmentService;
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private billingService billingService;
    @GetMapping("/p")
    public String viewHomePage() {

        return "patients";
    }

    @PostMapping("/store")
    public String addP(@ModelAttribute("Patient") Patient patient) throws IOException {
        patientService.addPatient(patient);
        return "allPatients";
    }
    @PostMapping("/verify_user")
    public String saveUser(User user) {
        List<User> existingUsers = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(!existingUsers.isEmpty()) {

            return "login"; // return an appropriate error page or message
        }

        return "allPatients";
    }

    @GetMapping("/")
    public String login(){

        return "login";


    }

   @GetMapping("/doctors")
    public String getDoctors(Model model){
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors";


    }
    @GetMapping("/h")
    public String getheadera(){

        return "header";


    }
    @GetMapping("/allpatients")
    public String getPatients(Model model){
        List<Patient> p = patientService.getAllPatients();
        model.addAttribute("patients", p);
        return "allPatients";


    }
    @GetMapping("/Appointement")
    public String viewappointementform(Model model) {

        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patients", patientService.getAllPatients());
        return "appointement";
    }
    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "appointement";

      }

    @GetMapping("/addMedicalRecord")
    public String showAddMedicalRecordForm(Model model) {
        model.addAttribute("medicalRecord", new MedicalRecord());
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "medicalRecord";
    }
    @PostMapping("/saveMedicalRecord")
    public String addMedicalRecord(@ModelAttribute("MedicalRecord") MedicalRecord medicalRecord) {
        medicalRecordService.addMedicalRecord(medicalRecord);
        return "medicalRecord";
    }
    @GetMapping("/ShowMedicalRecord")
    public String getRecord(Model model) {
        List<MedicalRecord> medicalRecordList = medicalRecordService.getAllMedicallRecord();
        model.addAttribute("medicalRecords", medicalRecordList);

        return "ShowMedicalRecord";
    }
    @GetMapping("/showBilling")
    public String getbillin(Model model) {
        List<Billing> BillingList = billingService.getAllBillings();
        model.addAttribute("BillingList", BillingList);

        return "k";
    }
    @GetMapping("/billing")
    public String showBillingForm(Model model) {

        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "billing";
    }
    @PostMapping("/addBilling")
    public String submitBillingForm(@ModelAttribute("billing") Billing billing, Model model) {
        billingService.addBilling(billing);
        List<Appointment> a = appointmentService.getAppointmentByPatientId(billing.getPatient());
        for(Appointment appointment : a) {
            appointment.setBilling(billing);
            appointmentService.saveAppointment(appointment);
        }

        model.addAttribute("patients", patientService.getAllPatients());

        return "billing";
    }
    @PostMapping("/billing/delete/{id}")
    public String deleteBilling(@PathVariable("id") Long id) {
        billingService.deleteBillingById(id);
        return "k";
    }
    @GetMapping("/updatebilling/{id}")
    public String updateBilling(@PathVariable("id") Long id, @ModelAttribute("billing") Billing billing,Model model) {
       // billing.setId(id);
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("appointments", appointmentService.getAllAppointments());

        model.addAttribute("billing", billingService.getBillingById(id));

        return "formupdatebilling";
    }
    @PostMapping("/doctor/delete/{id}")
    public String delete_doctor(@PathVariable("id") Long id) {
        doctorService.delete_doctor_ById(id);
        return "doctors";
    }
    @GetMapping("/update_doctor/{id}")
    public String update_doctor(@PathVariable("id") Long id, @ModelAttribute("doctor") Billing doctor,Model model) {
        // billing.setId(id);
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);


        model.addAttribute("doctor", doctorService.getDoctorById(id));

        return "UpdateDoctors";
    }
    @PostMapping("/store_d")
    public String addd(@ModelAttribute("doctor") Doctor doctor) throws IOException {
        doctorService.addDoctor(doctor);
        return "doctors";
    }

    @PostMapping("/patient/delete/{id}")
    public String delete_patient(@PathVariable("id") Long id) {
        patientService.delete_patient_ById(id);
        return "allPatients";
    }
    @GetMapping("/update_patient/{id}")
    public String update_patient(@PathVariable("id") Long id, @ModelAttribute("doctor") Billing doctor,Model model) {
        // billing.setId(id);
        List<Patient> p = patientService.getAllPatients();
        model.addAttribute("patients", p);


        model.addAttribute("patient", patientService.getPatientById(id));

        return "patients";
    }


    /*@RequestMapping("/updatebilling/{id}")
    public ModelAndView updateBilling(@PathVariable(name = "id") Long id) {
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        ModelAndView mav = new ModelAndView("billing");
        Billing billing = billingService.getBillingById(id);
        mav.addObject("billing", billing);
        return mav;

    }*/

}
    /*PostMapping("/updatebilling/{id}")
    public String showbillingformtoupdate(@PathVariable("id") Long id, @ModelAttribute("billing") Billing billing, Model model) {


        model.addAttribute("billing", billingService.getBillingById(id);
        return "formupdatebilling";*/


