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

    /**
     * Méthode renvoyant la liste de tous les patients
     * @return
     */
    @Override
    public List<Patient> findAllPatient() {
        return patientDAO.findAll();
    }

    /**
     * Méthode renvoyant les informations d'un Patient en le cherchant par son ID en base de donnée
     * @param id
     * @return
     */
    @Override
    public Patient findPatientById(Long id) {

        return patientDAO.findPatientById(id);
    }

    /**
     * Méthode renvoyant les informations d'un patient en le cherchant par son nom de famille
     * @param familyName
     * @return
     */
    @Override
    public Patient findPatientByFamilyName(String familyName) {
        return patientDAO.findPatientByFamilyName(familyName);
    }

    // CREATE - POST

    /**
     * Méthode pour créer un Patient en base de donnée
     * @param patient
     * @return
     */
    @Override
    public Patient savePatient(Patient patient) {
        return patientDAO.save(patient);
    }

    // DELETE - DELETE

    /**
     * Méthode pour supprimer un Patient de la base de donnée en utilisant son ID
     * @param patient
     * @return
     */
    @Override
    public Boolean deletePatient(Patient patient) {

        if (patientDAO.existsById(patient.getId())) {
            patientDAO.delete(patient);
            return true;
        }
        return false;
    }

    // UPDATE - PUT

    /**
     * Méthode pour mettre à jour un Patient, son ID étant requis.
     * @param id
     * @param patient
     * @return
     */
    @Override
    public Patient updatePatient(Long id, Patient patient) {

        patient.setId(id);

        return patientDAO.save(patient);
    }
}
