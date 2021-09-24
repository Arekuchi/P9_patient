package com.mediscreen.patient.services;

import com.mediscreen.patient.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {


    // CRUD
    // R - Read
    List<Patient> findAllPatient();
    Patient findPatientById(Long id);
    Patient findPatientByGivenNameAndFamilyName(String givenName, String familyName);

    // CUD - Create, Update, Delete
    Patient savePatient(Patient patient);
    Boolean deletePatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);



}
