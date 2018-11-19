package com.newcomer.fileprocessor.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcomer.dbservice.NeedAssessRefRepository;
import com.newcomer.dbservice.NewcomerRepository;
import com.newcomer.dbservice.SupportServiceRepository;
import com.newcomer.entity.NeedAssessRef;
import com.newcomer.entity.Newcomer;
import com.newcomer.entity.SupportService;
import com.newcomer.fileprocessor.ValueTranslator;

@Service("Needs Assessment and Referrals Service")
public class NeedAssessRefLoader implements TemplateLoader {
	
	@Autowired
	private NeedAssessRefRepository narRepo;
	
	@Autowired
	private NewcomerRepository newcomerRepo;
	
	@Autowired
	private SupportServiceRepository supservRepo;
	
	@Autowired
	private ValueTranslator trans;

	@Override
	public void load(List<String> row) {
		Newcomer newcomer = loadNewcomer(row);
		SupportService supserv = loadSupportService(row);
		NeedAssessRef rec = loadNeedAssessRef(row);
		newcomerRepo.save(newcomer);
		supservRepo.save(supserv);
		narRepo.save(rec);
		
	}

	@Override
	public int getTemplateColumnNumber() {
		return 92;
	}
	
	private Newcomer loadNewcomer(List<String> row) {
		Newcomer newcomer = new Newcomer();
		newcomer.setIdentifierName(row.get(2));
		newcomer.setIdentifierValue(row.get(3));
		newcomer.setBirthday(row.get(4));
		newcomer.setPostcode(row.get(5));
		newcomer.setLanguagePreference(row.get(8));
		return newcomer;
	}
	
	private SupportService loadSupportService(List<String> row) {
		SupportService supserv = new SupportService();
		// identifier
		supserv.setIdentifierValue(row.get(3));
		
		// Support Service data
		supserv.setReceived(trans.toBool(row.get(68)));
		supserv.setChildCare(trans.toBool(row.get(69)));
		supserv.setChild1Age(row.get(70));
		supserv.setChild1CareType(row.get(71));
		supserv.setChild2Age(row.get(72));
		supserv.setChild2CareType(row.get(73));
		supserv.setChild3Age(row.get(74));
		supserv.setChild3CareType(row.get(75));
		supserv.setChild4Age(row.get(76));
		supserv.setChild4CareType(row.get(77));
		supserv.setChild5Age(row.get(78));
		supserv.setChild5CareType(row.get(79));
		supserv.setTransportation(trans.toBool(row.get(80)));
		supserv.setDisabilities(trans.toBool(row.get(81)));
		supserv.setTranslateBetween(row.get(83));
		supserv.setTranslateAnd(row.get(84));
		supserv.setInterpreteBetween(row.get(86));
		supserv.setInterpreteAnd(row.get(87));
		supserv.setCrisisCounselling(trans.toBool(row.get(88)));
		supserv.setUpdateReason(row.get(91));
		return supserv;
	}
	
	private NeedAssessRef loadNeedAssessRef(List<String> row) {
		NeedAssessRef rec = new NeedAssessRef();
		// identifier
		rec.setIdentifierValue(row.get(3));
		// Record info
		rec.setProcDetail(row.get(0));
		rec.setUpdateRecordID(row.get(1));
		rec.setStartDate(row.get(6));
		rec.setServiceLanguage(row.get(7));
		rec.setInstitutionType(row.get(9));
		rec.setReferredBy(row.get(10));
		rec.setCompletedAndShared(trans.toBool(row.get(89)));
		rec.setEndDate(row.get(90));
		// Normal Needs
		rec.setKnowledge_Life(trans.toBool(row.get(11)));
		rec.setKnowledge_LifeRef(trans.toBool(row.get(12)));
		rec.setKnowledge_ComAndGov(trans.toBool(row.get(13)));
		rec.setKnowledge_ComAndGovRef(trans.toBool(row.get(14)));
		rec.setKnowledge_Work(trans.toBool(row.get(15)));
		rec.setKnowledge_WorkRef(trans.toBool(row.get(16)));
		rec.setKnowledge_Education(trans.toBool(row.get(17)));
		rec.setKnowledge_EducationRef(trans.toBool(row.get(18)));
		rec.setIncrease_SocialNetwork(trans.toBool(row.get(19)));
		rec.setIncrease_SocialNetworkRef(trans.toBool(row.get(20)));
		rec.setIncrease_ProfessionalNetwork(trans.toBool(row.get(21)));
		rec.setIncrease_ProfessionalNetworkRef(trans.toBool(row.get(22)));
		rec.setIncrease_localCommunityService(trans.toBool(row.get(23)));
		rec.setIncrease_localCommunityServiceRef(trans.toBool(row.get(24)));
		rec.setIncrease_CommunityInvolv(trans.toBool(row.get(25)));
		rec.setIncrease_CommunityInvolvRef(trans.toBool(row.get(26)));
		rec.setImproveLanguage(trans.toBool(row.get(27)));
		rec.setImproveLanguageRef(trans.toBool(row.get(28)));
		rec.setImproveLanguageTo(row.get(29));
		rec.setImproveOther(trans.toBool(row.get(30)));
		rec.setImproveOtherRef(trans.toBool(row.get(31)));
		rec.setImproveOtherTo(row.get(32));
		rec.setFindEmployment(trans.toBool(row.get(33)));
		rec.setFindEmploymentRef(trans.toBool(row.get(34)));
		rec.setFindEmploymentTimeFrame(row.get(35));
		rec.setMinimumWorkExperience(trans.toBool(row.get(36)));
		rec.setOccupation(row.get(37));
		rec.setObtainCredential(trans.toBool(row.get(38)));
		rec.setCitizen(trans.toBool(row.get(39)));
		rec.setSupportServiceRequired(trans.toBool(row.get(40)));
		rec.setChildrenCare(trans.toBool(row.get(41)));
		rec.setTransportation(trans.toBool(row.get(42)));
		rec.setDisability(trans.toBool(row.get(43)));
		rec.setTranslation(trans.toBool(row.get(44)));
		rec.setInterpretation(trans.toBool(row.get(45)));
		rec.setCrisisCounselling(trans.toBool(row.get(46)));
		//Non-IRCC program services needed
		rec.setNonIRCCServiceNeeded(trans.toBool(row.get(47)));
		rec.setFood(trans.toBool(row.get(48)));
		rec.setFoodRef(trans.toBool(row.get(49)));
		rec.setHousing(trans.toBool(row.get(50)));
		rec.setHousingRef(trans.toBool(row.get(51)));
		rec.setHealth(trans.toBool(row.get(52)));
		rec.setHealthRef(trans.toBool(row.get(53)));
		rec.setFinancial(trans.toBool(row.get(54)));
		rec.setFinancialRef(trans.toBool(row.get(55)));
		rec.setFamily(trans.toBool(row.get(56)));
		rec.setFamilyRef(trans.toBool(row.get(57)));
		rec.setLanguageNonIRCC(trans.toBool(row.get(58)));
		rec.setLanguageNonIRCCRef(trans.toBool(row.get(59)));
		rec.setEducationSkill(trans.toBool(row.get(60)));
		rec.setEducationSkillRef(trans.toBool(row.get(61)));
		rec.setEmploymentRelated(trans.toBool(row.get(62)));
		rec.setEmploymentRelatedRef(trans.toBool(row.get(63)));
		rec.setLegalInfo(trans.toBool(row.get(64)));
		rec.setLegalInfoRef(trans.toBool(row.get(65)));
		rec.setCommunity(trans.toBool(row.get(66)));
		rec.setCommunityRef(trans.toBool(row.get(67)));
		return rec;
	}

}
