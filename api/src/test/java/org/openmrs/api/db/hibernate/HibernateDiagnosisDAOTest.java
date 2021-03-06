/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api.db.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmrs.CodedOrFreeText;
import org.openmrs.Concept;
import org.openmrs.ConceptName;
import org.openmrs.Condition;
import org.openmrs.ConditionVerificationStatus;
import org.openmrs.Diagnosis;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.User;
import org.openmrs.Visit;
import org.openmrs.api.db.DiagnosisDAO;
import org.openmrs.test.jupiter.BaseContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateDiagnosisDAOTest extends BaseContextSensitiveTest {

	private static final String DIAGNOSIS_XML = "org/openmrs/api/include/HibernateDiagnosisDAOTestDataset.xml";

	@Autowired
	DiagnosisDAO diagnosisDAO;

	@BeforeEach
	public void setUp() {
		executeDataSet(DIAGNOSIS_XML);

	}

	@Test
	public void shouldSaveDiagnosis() {
		CodedOrFreeText codedOrFreeText = new CodedOrFreeText(new Concept(4),
			new ConceptName(5089), "non coded");
		int diagnosisId = 5;
		
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setEncounter(new Encounter(3));
		diagnosis.setRank(2);
		diagnosis.setId(diagnosisId);
		diagnosis.setCertainty(ConditionVerificationStatus.CONFIRMED);
		diagnosis.setPatient(new Patient(2));
		diagnosis.setCondition(new Condition());
		diagnosis.setDiagnosis(codedOrFreeText);
		diagnosis.setUuid("4e663d96-6b78-11e0-93c3-18a9b5e044dc");
		diagnosis.setCreator(new User(1));
		diagnosis.setVoided(false);
		diagnosis.setDateCreated(new Date());

		diagnosisDAO.saveDiagnosis(diagnosis);

		Diagnosis savedDiagnosis = diagnosisDAO.getDiagnosisById(diagnosisId);
		
		assertEquals(diagnosis.getUuid(), savedDiagnosis.getUuid());
		assertEquals(diagnosis.getVoided(), savedDiagnosis.getVoided());
		assertEquals(diagnosis.getRank(), savedDiagnosis.getRank());
		assertEquals(diagnosis.getCertainty(), savedDiagnosis.getCertainty());
		assertEquals(diagnosis.getCreator(), savedDiagnosis.getCreator());
		assertEquals(diagnosis.getCondition(), savedDiagnosis.getCondition());
		assertEquals(diagnosis.getPatient(), savedDiagnosis.getPatient());
		assertEquals(diagnosis.getEncounter(), savedDiagnosis.getEncounter());
	}

	@Test
	public void shouldGetDiagnosisByUuid() {
		Diagnosis diagnosis = diagnosisDAO.getDiagnosisByUuid("4e663d66-6b78-11e0-93c3-18a905e044dc");
		assertEquals(1, (int) diagnosis.getId());
	}

	@Test
	public void shouldGetDiagnosisById() {
		Diagnosis diagnosis = diagnosisDAO.getDiagnosisById(1);
		assertEquals("4e663d66-6b78-11e0-93c3-18a905e044dc", diagnosis.getUuid());
	}

	@Test
	public void shouldGetActiveDiagnosesWithFromDate() {
		Calendar calendar = new GregorianCalendar(2014,1,1,13,24,56);
		assertEquals(1, diagnosisDAO.getActiveDiagnoses(new Patient(2), calendar.getTime()).size()); 
	}

	@Test
	public void shouldGetActiveDiagnosesWithDifferentFromDate() {
		Calendar calendar = new GregorianCalendar(2012,1,3,13,32,36);
		assertEquals(2, diagnosisDAO.getActiveDiagnoses(new Patient(2), calendar.getTime()).size());
	}

	@Test
	public void shouldGetActiveDiagnosesWithoutFromDate() {
		assertEquals(2, diagnosisDAO.getActiveDiagnoses(new Patient(2), null).size());
	}

	@Test
	public void shouldGetDiagnosesByEncounter() {
		assertEquals(2, diagnosisDAO.getDiagnosesByEncounter(new Encounter(3), false, false).size());
		assertEquals(0, diagnosisDAO.getDiagnosesByEncounter(new Encounter(9), false, false).size());
	}

	@Test
	public void shouldGetPrimaryDiagnosesByEncounter() {
		assertEquals(2, diagnosisDAO.getDiagnosesByEncounter(new Encounter(3), true, false).size());
		assertEquals(0, diagnosisDAO.getDiagnosesByEncounter(new Encounter(4), true, false).size());
	}
	
	@Test
	public void shouldGetConfirmedDiagnosesByEncounter() {
		assertEquals(0, diagnosisDAO.getDiagnosesByEncounter(new Encounter(3), false, true).size());
		assertEquals(1, diagnosisDAO.getDiagnosesByEncounter(new Encounter(4), false, true).size());
	}
	
	@Test 
	public void shouldGetDiagnosesByVisit() {
		assertEquals(2, diagnosisDAO.getDiagnosesByVisit(new Visit(7), false, false).size());
		assertEquals(2, diagnosisDAO.getDiagnosesByVisit(new Visit(8), false, false).size());
		assertEquals(0, diagnosisDAO.getDiagnosesByVisit(new Visit(9), false, false).size());
	}
	
	@Test
	public void shouldGetPrimaryDiagnosesByVisit() {
		assertEquals(2, diagnosisDAO.getDiagnosesByVisit(new Visit(7), true, false).size());
		assertEquals(0, diagnosisDAO.getDiagnosesByVisit(new Visit(8), true, false).size());
	}
	
	@Test
	public void shouldGetConfirmedDiagnosesByVisit() {
		assertEquals(0, diagnosisDAO.getDiagnosesByVisit(new Visit(7), false, true).size());
		assertEquals(1, diagnosisDAO.getDiagnosesByVisit(new Visit(8), false, true).size());
	}

	@Test
	public void shouldDeleteDiagnosis() {
		String uuid = "4e663d66-6b78-11e0-93c3-18a905e044dc";
		Diagnosis diagnosis = diagnosisDAO.getDiagnosisByUuid(uuid);
		assertNotNull(diagnosis);
		diagnosisDAO.deleteDiagnosis(diagnosis);
		assertNull(diagnosisDAO.getDiagnosisByUuid(uuid)); 
	}
}
