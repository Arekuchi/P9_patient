package com.mediscreen.patient.controller;


import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    // GET
    @GetMapping(value = "/patientList")
    public List<Patient> findAllPatient() {
        List<Patient> patientList = patientService.findAllPatient();

        return patientList;
    }

    @GetMapping(value = "/patientById/{id}")
    public Patient findPatientById(@PathVariable("id") Long id) {
        Patient patient = patientService.findPatientById(id);

        return patient;
    }

    @GetMapping(value = "/patientByName")
    public Patient findPatientByGivenNameAndFamilyName(@RequestParam String givenName,@RequestParam String familyName) {
        Patient patient = patientService.findPatientByGivenNameAndFamilyName(givenName, familyName);

        return patient;
    }

    // POST
    @PostMapping(value = "/patientSave", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient patientSave(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        Patient newPatient = patientService.findPatientByGivenNameAndFamilyName(patient.getGivenName(), patient.getFamilyName());

        return newPatient;
    }

    // DELETE
    @DeleteMapping(value = "/patientDelete/{id}")
    public Boolean patientDelete(@PathVariable Long id) {
        return patientService.deletePatient(patientService.findPatientById(id));

    }

    // PUT
    @PutMapping(value = "/patientUpdate/{id}")
    public void patientUpdate(@RequestBody Patient patient) {

        patientService.updatePatient(patient);

    }

}
