package com.mediscreen.patient.services;

import com.mediscreen.patient.DAO.PatientDAO;
import com.mediscreen.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Override
    public List<Patient> findAllPatient() {
        return null;
    }

    @Override
    public Patient findPatientById(Long id) {
        return null;
    }

    @Override
    public Patient findPatientByGivenNameAndFamilyName(String givenName, String familyName) {
        return null;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return null;
    }

    @Override
    public Boolean deletePatient(Patient patient) {
        return null;
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        return null;
    }
}
