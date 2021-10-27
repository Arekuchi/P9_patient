package com.mediscreen.patient.services;

import com.mediscreen.patient.DAO.PatientDAO;
import com.mediscreen.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @PersistenceContext
    protected EntityManager entityManager;


    // READ - GET

    @Override
    public List<Patient> findAllPatient() {
        return patientDAO.findAll();
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientDAO.findPatientById(id);
    }

    @Override
    public Patient findPatientByGivenNameAndFamilyName(String givenName, String familyName) {
        return patientDAO.findPatientByGivenNameAndFamilyName(givenName, familyName);
    }

    // CREATE - POST
    @Override
    public Patient savePatient(Patient patient) {
        return patientDAO.save(patient);
    }

    // DELETE - DELETE
    @Override
    public Boolean deletePatient(Patient patient) {

        if (patientDAO.existsById(patient.getId())) {
            patientDAO.delete(patient);
            return true;
        }
        return false;
    }

    // UPDATE - PUT
    @Override
    public Patient updatePatient(Patient patient) {

        return patientDAO.save(patient);
    }
}
