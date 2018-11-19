package com.newcomer.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class NeedAssessRefTest {
	@Test
	public void testIdGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setId("abc");
	    assertEquals("abc", ins.getId());
	    ins.setId("def");
	    assertEquals("def", ins.getId());
	}

	@Test
	public void testIdentifierValueGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIdentifierValue("abc");
	    assertEquals("abc", ins.getIdentifierValue());
	    ins.setIdentifierValue("def");
	    assertEquals("def", ins.getIdentifierValue());
	}

	@Test
	public void testProcDetailGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setProcDetail("abc");
	    assertEquals("abc", ins.getProcDetail());
	    ins.setProcDetail("def");
	    assertEquals("def", ins.getProcDetail());
	}

	@Test
	public void testUpdateRecordIDGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setUpdateRecordID("abc");
	    assertEquals("abc", ins.getUpdateRecordID());
	    ins.setUpdateRecordID("def");
	    assertEquals("def", ins.getUpdateRecordID());
	}

	@Test
	public void testStartDateGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setStartDate("abc");
	    assertEquals("abc", ins.getStartDate());
	    ins.setStartDate("def");
	    assertEquals("def", ins.getStartDate());
	}

	@Test
	public void testServiceLanguageGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setServiceLanguage("abc");
	    assertEquals("abc", ins.getServiceLanguage());
	    ins.setServiceLanguage("def");
	    assertEquals("def", ins.getServiceLanguage());
	}

	@Test
	public void testInstitutionTypeGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setInstitutionType("abc");
	    assertEquals("abc", ins.getInstitutionType());
	    ins.setInstitutionType("def");
	    assertEquals("def", ins.getInstitutionType());
	}

	@Test
	public void testReferredByGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setReferredBy("abc");
	    assertEquals("abc", ins.getReferredBy());
	    ins.setReferredBy("def");
	    assertEquals("def", ins.getReferredBy());
	}

	@Test
	public void testCompletedAndSharedGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setCompletedAndShared(true);
	    assertTrue(ins.getCompletedAndShared());
	    ins.setCompletedAndShared(false);
	    assertFalse(ins.getCompletedAndShared());
	}

	@Test
	public void testEndDateGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setEndDate("abc");
	    assertEquals("abc", ins.getEndDate());
	    ins.setEndDate("def");
	    assertEquals("def", ins.getEndDate());
	}

	@Test
	public void testKnowledge_LifeGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_Life(true);
	    assertTrue(ins.getKnowledge_Life());
	    ins.setKnowledge_Life(false);
	    assertFalse(ins.getKnowledge_Life());
	}

	@Test
	public void testKnowledge_LifeRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_LifeRef(true);
	    assertTrue(ins.getKnowledge_LifeRef());
	    ins.setKnowledge_LifeRef(false);
	    assertFalse(ins.getKnowledge_LifeRef());
	}

	@Test
	public void testKnowledge_ComAndGovGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_ComAndGov(true);
	    assertTrue(ins.getKnowledge_ComAndGov());
	    ins.setKnowledge_ComAndGov(false);
	    assertFalse(ins.getKnowledge_ComAndGov());
	}

	@Test
	public void testKnowledge_ComAndGovRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_ComAndGovRef(true);
	    assertTrue(ins.getKnowledge_ComAndGovRef());
	    ins.setKnowledge_ComAndGovRef(false);
	    assertFalse(ins.getKnowledge_ComAndGovRef());
	}

	@Test
	public void testKnowledge_WorkGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_Work(true);
	    assertTrue(ins.getKnowledge_Work());
	    ins.setKnowledge_Work(false);
	    assertFalse(ins.getKnowledge_Work());
	}

	@Test
	public void testKnowledge_WorkRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_WorkRef(true);
	    assertTrue(ins.getKnowledge_WorkRef());
	    ins.setKnowledge_WorkRef(false);
	    assertFalse(ins.getKnowledge_WorkRef());
	}

	@Test
	public void testKnowledge_EducationGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_Education(true);
	    assertTrue(ins.getKnowledge_Education());
	    ins.setKnowledge_Education(false);
	    assertFalse(ins.getKnowledge_Education());
	}

	@Test
	public void testKnowledge_EducationRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setKnowledge_EducationRef(true);
	    assertTrue(ins.getKnowledge_EducationRef());
	    ins.setKnowledge_EducationRef(false);
	    assertFalse(ins.getKnowledge_EducationRef());
	}

	@Test
	public void testIncrease_SocialNetworkGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_SocialNetwork(true);
	    assertTrue(ins.getIncrease_SocialNetwork());
	    ins.setIncrease_SocialNetwork(false);
	    assertFalse(ins.getIncrease_SocialNetwork());
	}

	@Test
	public void testIncrease_SocialNetworkRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_SocialNetworkRef(true);
	    assertTrue(ins.getIncrease_SocialNetworkRef());
	    ins.setIncrease_SocialNetworkRef(false);
	    assertFalse(ins.getIncrease_SocialNetworkRef());
	}

	@Test
	public void testIncrease_ProfessionalNetworkGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_ProfessionalNetwork(true);
	    assertTrue(ins.getIncrease_ProfessionalNetwork());
	    ins.setIncrease_ProfessionalNetwork(false);
	    assertFalse(ins.getIncrease_ProfessionalNetwork());
	}

	@Test
	public void testIncrease_ProfessionalNetworkRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_ProfessionalNetworkRef(true);
	    assertTrue(ins.getIncrease_ProfessionalNetworkRef());
	    ins.setIncrease_ProfessionalNetworkRef(false);
	    assertFalse(ins.getIncrease_ProfessionalNetworkRef());
	}

	@Test
	public void testIncrease_localCommunityServiceGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_localCommunityService(true);
	    assertTrue(ins.getIncrease_localCommunityService());
	    ins.setIncrease_localCommunityService(false);
	    assertFalse(ins.getIncrease_localCommunityService());
	}

	@Test
	public void testIncrease_localCommunityServiceRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_localCommunityServiceRef(true);
	    assertTrue(ins.getIncrease_localCommunityServiceRef());
	    ins.setIncrease_localCommunityServiceRef(false);
	    assertFalse(ins.getIncrease_localCommunityServiceRef());
	}

	@Test
	public void testIncrease_CommunityInvolvGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_CommunityInvolv(true);
	    assertTrue(ins.getIncrease_CommunityInvolv());
	    ins.setIncrease_CommunityInvolv(false);
	    assertFalse(ins.getIncrease_CommunityInvolv());
	}

	@Test
	public void testIncrease_CommunityInvolvRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setIncrease_CommunityInvolvRef(true);
	    assertTrue(ins.getIncrease_CommunityInvolvRef());
	    ins.setIncrease_CommunityInvolvRef(false);
	    assertFalse(ins.getIncrease_CommunityInvolvRef());
	}

	@Test
	public void testImproveLanguageGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setImproveLanguage(true);
	    assertTrue(ins.getImproveLanguage());
	    ins.setImproveLanguage(false);
	    assertFalse(ins.getImproveLanguage());
	}

	@Test
	public void testImproveLanguageRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setImproveLanguageRef(true);
	    assertTrue(ins.getImproveLanguageRef());
	    ins.setImproveLanguageRef(false);
	    assertFalse(ins.getImproveLanguageRef());
	}

	@Test
	public void testImproveLanguageToGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setImproveLanguageTo("abc");
	    assertEquals("abc", ins.getImproveLanguageTo());
	    ins.setImproveLanguageTo("def");
	    assertEquals("def", ins.getImproveLanguageTo());
	}

	@Test
	public void testImproveOtherGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setImproveOther(true);
	    assertTrue(ins.getImproveOther());
	    ins.setImproveOther(false);
	    assertFalse(ins.getImproveOther());
	}

	@Test
	public void testImproveOtherRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setImproveOtherRef(true);
	    assertTrue(ins.getImproveOtherRef());
	    ins.setImproveOtherRef(false);
	    assertFalse(ins.getImproveOtherRef());
	}

	@Test
	public void testImproveOtherToGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setImproveOtherTo("abc");
	    assertEquals("abc", ins.getImproveOtherTo());
	    ins.setImproveOtherTo("def");
	    assertEquals("def", ins.getImproveOtherTo());
	}

	@Test
	public void testFindEmploymentGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFindEmployment(true);
	    assertTrue(ins.getFindEmployment());
	    ins.setFindEmployment(false);
	    assertFalse(ins.getFindEmployment());
	}

	@Test
	public void testFindEmploymentRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFindEmploymentRef(true);
	    assertTrue(ins.getFindEmploymentRef());
	    ins.setFindEmploymentRef(false);
	    assertFalse(ins.getFindEmploymentRef());
	}

	@Test
	public void testFindEmploymentTimeFrameGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFindEmploymentTimeFrame("abc");
	    assertEquals("abc", ins.getFindEmploymentTimeFrame());
	    ins.setFindEmploymentTimeFrame("def");
	    assertEquals("def", ins.getFindEmploymentTimeFrame());
	}

	@Test
	public void testMinimumWorkExperienceGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setMinimumWorkExperience(true);
	    assertTrue(ins.getMinimumWorkExperience());
	    ins.setMinimumWorkExperience(false);
	    assertFalse(ins.getMinimumWorkExperience());
	}

	@Test
	public void testOccupationGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setOccupation("abc");
	    assertEquals("abc", ins.getOccupation());
	    ins.setOccupation("def");
	    assertEquals("def", ins.getOccupation());
	}

	@Test
	public void testObtainCredentialGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setObtainCredential(true);
	    assertTrue(ins.getObtainCredential());
	    ins.setObtainCredential(false);
	    assertFalse(ins.getObtainCredential());
	}

	@Test
	public void testCitizenGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setCitizen(true);
	    assertTrue(ins.getCitizen());
	    ins.setCitizen(false);
	    assertFalse(ins.getCitizen());
	}

	@Test
	public void testSupportServiceRequiredGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setSupportServiceRequired(true);
	    assertTrue(ins.getSupportServiceRequired());
	    ins.setSupportServiceRequired(false);
	    assertFalse(ins.getSupportServiceRequired());
	}

	@Test
	public void testChildrenCareGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setChildrenCare(true);
	    assertTrue(ins.getChildrenCare());
	    ins.setChildrenCare(false);
	    assertFalse(ins.getChildrenCare());
	}

	@Test
	public void testTransportationGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setTransportation(true);
	    assertTrue(ins.getTransportation());
	    ins.setTransportation(false);
	    assertFalse(ins.getTransportation());
	}

	@Test
	public void testDisabilityGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setDisability(true);
	    assertTrue(ins.getDisability());
	    ins.setDisability(false);
	    assertFalse(ins.getDisability());
	}

	@Test
	public void testTranslationGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setTranslation(true);
	    assertTrue(ins.getTranslation());
	    ins.setTranslation(false);
	    assertFalse(ins.getTranslation());
	}

	@Test
	public void testInterpretationGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setInterpretation(true);
	    assertTrue(ins.getInterpretation());
	    ins.setInterpretation(false);
	    assertFalse(ins.getInterpretation());
	}

	@Test
	public void testCrisisCounsellingGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setCrisisCounselling(true);
	    assertTrue(ins.getCrisisCounselling());
	    ins.setCrisisCounselling(false);
	    assertFalse(ins.getCrisisCounselling());
	}

	@Test
	public void testNonIRCCServiceNeededGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setNonIRCCServiceNeeded(true);
	    assertTrue(ins.getNonIRCCServiceNeeded());
	    ins.setNonIRCCServiceNeeded(false);
	    assertFalse(ins.getNonIRCCServiceNeeded());
	}

	@Test
	public void testFoodGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFood(true);
	    assertTrue(ins.getFood());
	    ins.setFood(false);
	    assertFalse(ins.getFood());
	}

	@Test
	public void testFoodRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFoodRef(true);
	    assertTrue(ins.getFoodRef());
	    ins.setFoodRef(false);
	    assertFalse(ins.getFoodRef());
	}

	@Test
	public void testHousingGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setHousing(true);
	    assertTrue(ins.getHousing());
	    ins.setHousing(false);
	    assertFalse(ins.getHousing());
	}

	@Test
	public void testHousingRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setHousingRef(true);
	    assertTrue(ins.getHousingRef());
	    ins.setHousingRef(false);
	    assertFalse(ins.getHousingRef());
	}

	@Test
	public void testHealthGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setHealth(true);
	    assertTrue(ins.getHealth());
	    ins.setHealth(false);
	    assertFalse(ins.getHealth());
	}

	@Test
	public void testHealthRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setHealthRef(true);
	    assertTrue(ins.getHealthRef());
	    ins.setHealthRef(false);
	    assertFalse(ins.getHealthRef());
	}

	@Test
	public void testFinancialGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFinancial(true);
	    assertTrue(ins.getFinancial());
	    ins.setFinancial(false);
	    assertFalse(ins.getFinancial());
	}

	@Test
	public void testFinancialRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFinancialRef(true);
	    assertTrue(ins.getFinancialRef());
	    ins.setFinancialRef(false);
	    assertFalse(ins.getFinancialRef());
	}

	@Test
	public void testFamilyGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFamily(true);
	    assertTrue(ins.getFamily());
	    ins.setFamily(false);
	    assertFalse(ins.getFamily());
	}

	@Test
	public void testFamilyRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setFamilyRef(true);
	    assertTrue(ins.getFamilyRef());
	    ins.setFamilyRef(false);
	    assertFalse(ins.getFamilyRef());
	}

	@Test
	public void testLanguageNonIRCCGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setLanguageNonIRCC(true);
	    assertTrue(ins.getLanguageNonIRCC());
	    ins.setLanguageNonIRCC(false);
	    assertFalse(ins.getLanguageNonIRCC());
	}

	@Test
	public void testLanguageNonIRCCRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setLanguageNonIRCCRef(true);
	    assertTrue(ins.getLanguageNonIRCCRef());
	    ins.setLanguageNonIRCCRef(false);
	    assertFalse(ins.getLanguageNonIRCCRef());
	}

	@Test
	public void testEducationSkillGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setEducationSkill(true);
	    assertTrue(ins.getEducationSkill());
	    ins.setEducationSkill(false);
	    assertFalse(ins.getEducationSkill());
	}

	@Test
	public void testEducationSkillRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setEducationSkillRef(true);
	    assertTrue(ins.getEducationSkillRef());
	    ins.setEducationSkillRef(false);
	    assertFalse(ins.getEducationSkillRef());
	}

	@Test
	public void testEmploymentRelatedGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setEmploymentRelated(true);
	    assertTrue(ins.getEmploymentRelated());
	    ins.setEmploymentRelated(false);
	    assertFalse(ins.getEmploymentRelated());
	}

	@Test
	public void testEmploymentRelatedRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setEmploymentRelatedRef(true);
	    assertTrue(ins.getEmploymentRelatedRef());
	    ins.setEmploymentRelatedRef(false);
	    assertFalse(ins.getEmploymentRelatedRef());
	}

	@Test
	public void testLegalInfoGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setLegalInfo(true);
	    assertTrue(ins.getLegalInfo());
	    ins.setLegalInfo(false);
	    assertFalse(ins.getLegalInfo());
	}

	@Test
	public void testLegalInfoRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setLegalInfoRef(true);
	    assertTrue(ins.getLegalInfoRef());
	    ins.setLegalInfoRef(false);
	    assertFalse(ins.getLegalInfoRef());
	}

	@Test
	public void testCommunityGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setCommunity(true);
	    assertTrue(ins.getCommunity());
	    ins.setCommunity(false);
	    assertFalse(ins.getCommunity());
	}

	@Test
	public void testCommunityRefGetterSetter() {
	    NeedAssessRef ins = new NeedAssessRef();
	    ins.setCommunityRef(true);
	    assertTrue(ins.getCommunityRef());
	    ins.setCommunityRef(false);
	    assertFalse(ins.getCommunityRef());
	}


}
