package com.mediscreen.patient.controller;


import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.services.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;
import java.util.Objects;

@EnableSwagger2WebMvc
@Api(description = "Gestion des patients")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    // GET
    @ApiOperation(value = "Récupère tous les patients")
    @GetMapping(value = "/patientList")
    public List<Patient> findAllPatient() {
        List<Patient> patientList = patientService.findAllPatient();

        if(patientList.isEmpty()){
            throw new PatientNotFoundException("Aucun patients dans la base de donnée");
        }
        return patientList;
    }

    @ApiOperation(value = "Récupère un patient selon son ID")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Patient with id { id } doesn't exist in database")})
    @GetMapping(value = "/patientById/{id}")
    public Patient findPatientById(@PathVariable("id") Long id) {
        Patient patient = patientService.findPatientById(id);
        if(Objects.isNull(patient)){
            throw new PatientNotFoundException("Le patient avec l'id " + id + "n'existe pas");
        }
        return patient;
    }

    @ApiOperation(value = "Récupère un patient selon son prénom et son nom")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Patient { firstName lastName } doesn't exist in database")})
    @GetMapping(value = "/patientByName/{familyName}")
    public Patient findPatientByFamilyName(@PathVariable("familyName") String familyName) {
        Patient patient = patientService.findPatientByFamilyName(familyName);

        if(Objects.isNull(patient)){
            throw new PatientNotFoundException("Le Patient " + familyName +" n'existe pas");
        }
        return patient;
    }

    // POST
    @ApiOperation(value = "Sauvegarde un patient")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Patient { firstName lastName } already exist in database")})
    @PostMapping(value = "/patientSave", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient patientSave(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        Patient newPatient = patientService.findPatientByFamilyName(patient.getFamilyName());

        return newPatient;
    }

    // DELETE
    @ApiOperation(value = "Supprimer un patient selon son ID")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Patient with id { id } to delete doesn't exist")})
    @DeleteMapping(value = "/patientDelete/{id}")
    public Boolean patientDelete(@PathVariable Long id) {
        return patientService.deletePatient(patientService.findPatientById(id));

    }

    // PUT
    @ApiOperation(value = "Met à jour un patient selon son ID")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Patient with id { id } to update doesn't exist")})
    @PutMapping(value = "/patientUpdate/{id}")
    public void patientUpdate(@PathVariable Long id, @RequestBody Patient patient) {

        patientService.updatePatient(id, patient);

    }

}
