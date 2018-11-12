package com.newcomer.dbservice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.entity.NeedAssessRef;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class NeedAssessRefTest {
	
	@Autowired
	private NeedAssessRefRepository repo;
	
	@Before
	public void init() {
		NeedAssessRef ins = new NeedAssessRef();
		ins.setIdentifierValue("123456789");
		ins.setProcDetail("detail");
		ins.setUpdateRecordID("up rc");
		ins.setStartDate("2018-10-06");
		ins.setServiceLanguage("English");
		ins.setInstitutionType("Library");
		ins.setReferredBy("Jerry");
		ins.setCompletedAndShared(true);
		ins.setEndDate("2018-11-01");
		ins.setKnowledge_Life(true);
		ins.setKnowledge_LifeRef(true);
		ins.setKnowledge_ComAndGov(true);
		ins.setKnowledge_ComAndGovRef(true);
		ins.setKnowledge_Work(true);
		ins.setKnowledge_WorkRef(true);
		ins.setKnowledge_Education(false);
		ins.setKnowledge_EducationRef(false);
		ins.setIncrease_SocialNetwork(true);
		ins.setIncrease_SocialNetworkRef(true);
		ins.setIncrease_ProfessionalNetwork(true);
		ins.setIncrease_ProfessionalNetworkRef(true);
		ins.setIncrease_localCommunityService(true);
		ins.setIncrease_localCommunityServiceRef(true);
		ins.setIncrease_CommunityInvolv(true);
		ins.setIncrease_CommunityInvolvRef(true);
		ins.setImproveLanguage(true);
		ins.setImproveLanguageRef(true);
		ins.setImproveLanguageTo("Be a teacher");
		ins.setImproveOther(true);
		ins.setImproveOtherRef(true);
		ins.setImproveOtherTo("Get jobs");
		ins.setFindEmployment(true);
		ins.setFindEmploymentRef(true);
		ins.setFindEmploymentTimeFrame("less than 1 year");
		ins.setMinimumWorkExperience(false);
		ins.setOccupation("Saler");
		ins.setObtainCredential(true);
		ins.setCitizen(true);
		ins.setSupportServiceRequired(true);
		ins.setChildrenCare(true);
		ins.setTransportation(false);
		ins.setDisability(false);
		ins.setTranslation(false);
		ins.setInterpretation(false);
		ins.setCrisisCounselling(false);
		ins.setNonIRCCServiceNeeded(false);
		ins.setFood(false);
		ins.setFoodRef(false);
		ins.setHousing(false);
		ins.setHousingRef(false);
		ins.setHealth(false);
		ins.setHealthRef(false);
		ins.setFinancial(false);
		ins.setFinancialRef(false);
		ins.setFamily(false);
		ins.setFamilyRef(false);
		ins.setLanguageNonIRCC(false);
		ins.setLanguageNonIRCCRef(false);
		ins.setEducationSkill(false);
		ins.setEducationSkillRef(false);
		ins.setEmploymentRelated(false);
		ins.setEmploymentRelatedRef(false);
		ins.setLegalInfo(false);
		ins.setLegalInfoRef(false);
		ins.setCommunity(false);
		ins.setCommunityRef(false);
		
		repo.save(ins);
	}
	
	@Test
	public void testSaveRecord() {
		NeedAssessRef a = new NeedAssessRef();
		a.setIdentifierValue("123456798");
		a.setProcDetail("detail");
		a.setUpdateRecordID("up rc");
		a.setStartDate("2017-10-06");
		a.setServiceLanguage("English");
		a.setInstitutionType("Library");
		a.setReferredBy("Joey");
		a.setCompletedAndShared(true);
		a.setEndDate("2017-11-01");
		a.setKnowledge_Life(true);
		a.setKnowledge_LifeRef(true);
		a.setKnowledge_ComAndGov(true);
		a.setKnowledge_ComAndGovRef(true);
		a.setKnowledge_Work(true);
		a.setKnowledge_WorkRef(true);
		a.setKnowledge_Education(false);
		a.setKnowledge_EducationRef(false);
		a.setIncrease_SocialNetwork(true);
		a.setIncrease_SocialNetworkRef(true);
		a.setIncrease_ProfessionalNetwork(true);
		a.setIncrease_ProfessionalNetworkRef(true);
		a.setIncrease_localCommunityService(true);
		a.setIncrease_localCommunityServiceRef(true);
		a.setIncrease_CommunityInvolv(true);
		a.setIncrease_CommunityInvolvRef(true);
		a.setImproveLanguage(true);
		a.setImproveLanguageRef(true);
		a.setImproveLanguageTo("Be a teacher");
		a.setImproveOther(true);
		a.setImproveOtherRef(true);
		a.setImproveOtherTo("Get jobs");
		a.setFindEmployment(true);
		a.setFindEmploymentRef(true);
		a.setFindEmploymentTimeFrame("less than 1 year");
		a.setMinimumWorkExperience(false);
		a.setOccupation("Saler");
		a.setObtainCredential(true);
		a.setCitizen(true);
		a.setSupportServiceRequired(true);
		a.setChildrenCare(true);
		a.setTransportation(false);
		a.setDisability(false);
		a.setTranslation(false);
		a.setInterpretation(false);
		a.setCrisisCounselling(false);
		a.setNonIRCCServiceNeeded(false);
		a.setFood(false);
		a.setFoodRef(false);
		a.setHousing(false);
		a.setHousingRef(false);
		a.setHealth(false);
		a.setHealthRef(false);
		a.setFinancial(false);
		a.setFinancialRef(false);
		a.setFamily(false);
		a.setFamilyRef(false);
		a.setLanguageNonIRCC(false);
		a.setLanguageNonIRCCRef(false);
		a.setEducationSkill(false);
		a.setEducationSkillRef(false);
		a.setEmploymentRelated(false);
		a.setEmploymentRelatedRef(false);
		a.setLegalInfo(false);
		a.setLegalInfoRef(false);
		a.setCommunity(false);
		a.setCommunityRef(false);
		
		assertTrue(repo.save(a)!=null);
	}
	
	@Test
	public void testCanFindRecord() {
		NeedAssessRef a = repo.findByIdentifierValue("123456789");
		assertEquals("123456789", a.getIdentifierValue());
		assertEquals("2018-10-06", a.getStartDate());
		assertEquals("Jerry", a.getReferredBy());
	}
	
	@Test
	public void testCannotFindRecord() {
		NeedAssessRef a = repo.findByIdentifierValue("123456798");
		assertEquals(null, a);
	}
	
	@After
	public void clean() {
		repo.deleteAll();
	}
}
