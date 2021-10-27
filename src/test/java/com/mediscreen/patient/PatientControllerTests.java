package com.mediscreen.patient;

import com.mediscreen.patient.DAO.PatientDAO;
import com.mediscreen.patient.controller.PatientController;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.services.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	PatientService patientService;

	@MockBean
	PatientDAO patientDAO;

	@MockBean
	PatientController patientController;


	Long idTest = 1L;
	Date dateTest = Date.valueOf(LocalDate.now());

	List<Patient> patientList = new ArrayList<>();
	Patient patientTest = new Patient(idTest,"givenTest", "familyTest", dateTest, "M", "addressTest", "555222222");



	@Test
	public void findAllTest() {

	when(patientController.findAllPatient()).thenReturn(patientList);
	patientController.findAllPatient();
	verify(patientController, times(1)).findAllPatient();


	}

	@Test
	public void findPatientByIdTest() {

		when(patientController.findPatientById(idTest)).thenReturn(patientTest);
		patientController.findPatientById(idTest);
		verify(patientController, times(1)).findPatientById(idTest);

	}

	@Test
	public void findPatientByGivenNameAndFamilyNameTest() {

		when(patientController.findPatientByGivenNameAndFamilyName(patientTest.getGivenName(), patientTest.getFamilyName())).thenReturn(patientTest);
		patientController.findPatientByGivenNameAndFamilyName("givenTest", "familyTest");
		verify(patientController, times(1)).findPatientByGivenNameAndFamilyName("givenTest", "familyTest");
	}

	@Test
	public void patientSaveTest() {

		when(patientController.patientSave(patientTest)).thenReturn(any());
		patientController.patientSave(patientTest);
		verify(patientController, times(1)).patientSave(any());
	}

	@Test
	public void patientDeleteTest() {

		when(patientController.patientDelete(any())).thenReturn(true);
		patientController.patientDelete(any());
		verify(patientController, times(1)).patientDelete(any());
	}



}
