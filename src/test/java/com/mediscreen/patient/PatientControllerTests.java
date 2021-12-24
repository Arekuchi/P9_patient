package com.mediscreen.patient;

import com.mediscreen.patient.DAO.PatientDAO;
import com.mediscreen.patient.controller.PatientController;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.services.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MockMvc mockMvc;

	@Autowired
	PatientService patientService;

	@MockBean
	PatientDAO patientDAO;

	@MockBean
	PatientController patientController;


	Long idTest = 1L;
	String dateTest = "2022-08-15";

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

		when(patientController.findPatientByFamilyName(patientTest.getFamilyName())).thenReturn(patientTest);
		patientController.findPatientByFamilyName("familyTest");
		verify(patientController, times(1)).findPatientByFamilyName("familyTest");
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

	@Test
	public void findAllMock() throws Exception {
		this.mockMvc.perform(get("/patientList")).andExpect(status().isOk());
	}

	@Test
	public void findPatientByIdMock() throws Exception {
		this.mockMvc.perform(get("/patientById/1")).andExpect(status().isOk());
	}

	@Test
	public void findPatientByGivenNameAndFamilyNameMock() throws Exception {
//		this.mockMvc.perform(get("/patientByName")
//				.param("givenName", patientTest.getGivenName())
//				.param("familyName", patientTest.getFamilyName())
//		).andExpect(status().isOk());
	}


}
