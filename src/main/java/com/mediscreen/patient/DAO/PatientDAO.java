package com.mediscreen.patient.DAO;

import com.mediscreen.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Long> {


    Patient findPatientByFamilyName(String familyName);
    Patient findPatientById(Long id);

}
