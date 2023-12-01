package com.alcon.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alcon.patient.dto.card.PatientCardResponseDTO;
import com.alcon.patient.dto.card.PatientRequestDTO;
import com.alcon.patient.dto.list.PatientListRequestDTO;
import com.alcon.patient.dto.list.PatientListResponseDTO;
import com.alcon.patient.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/api/patient/list", method = RequestMethod.POST)
	PatientListResponseDTO patientList(@RequestBody PatientListRequestDTO reqBody) throws Exception {
		PatientListResponseDTO response =  patientService.getPatientList(reqBody);
		return response;
	}

//	@RequestMapping(value = "/api/patient/card", method = RequestMethod.POST)
//	PatientCardResponseDTO patientDetails(@RequestBody PatientRequestDTO reqBody) throws Exception {
//		PatientCardResponseDTO response =  patientService.getPatientDetails(reqBody);
//		return response;
//	}

	@RequestMapping(value = "/api/patient/card", method = RequestMethod.POST)
	PatientCardResponseDTO patientLabel(@RequestBody PatientRequestDTO reqBody) throws Exception {
		PatientCardResponseDTO response =  patientService.sortCards(reqBody);
		return response;
	}
}
