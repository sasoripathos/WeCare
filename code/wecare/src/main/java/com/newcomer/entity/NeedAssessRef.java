package com.newcomer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="NeedAssessRef")
public class NeedAssessRef {
	
	// Identifier
	@Id
	private String id;
	private String identifierValue;

	// Record info
	private String procDetail;
	private String updateRecordID;
	private String startDate;
	private String serviceLanguage;
	private String institutionType;
	private String referredBy;
	private Boolean completedAndShared;
	private String endDate;

	
	// Normal Needs
	private Boolean knowledge_Life;
	private Boolean knowledge_LifeRef;
	private Boolean knowledge_ComAndGov;
	private Boolean knowledge_ComAndGovRef;
	private Boolean knowledge_Work;
	private Boolean knowledge_WorkRef;
	private Boolean knowledge_Education;
	private Boolean knowledge_EducationRef;
	private Boolean increase_SocialNetwork;
	private Boolean increase_SocialNetworkRef;
	private Boolean increase_ProfessionalNetwork;
	private Boolean increase_ProfessionalNetworkRef;
	private Boolean increase_localCommunityService;
	private Boolean increase_localCommunityServiceRef;
	private Boolean increase_CommunityInvolv;
	private Boolean increase_CommunityInvolvRef;
	private Boolean improveLanguage;
	private Boolean improveLanguageRef;
	private String improveLanguageTo;
	private Boolean improveOther;
	private Boolean improveOtherRef;
	private String improveOtherTo;
	private Boolean findEmployment;
	private Boolean findEmploymentRef;
	private String findEmploymentTimeFrame;
	private Boolean minimumWorkExperience;
	private String occupation;
	private Boolean obtainCredential;
	private Boolean citizen;
	private Boolean supportServiceRequired;
	private Boolean childrenCare;
	private Boolean transportation;
	private Boolean disability;
	private Boolean translation;
	private Boolean interpretation;
	private Boolean crisisCounselling;

	// Non-IRCC program services needed
	private Boolean nonIRCCServiceNeeded;
	private Boolean food;
	private Boolean foodRef;
	private Boolean housing;
	private Boolean housingRef;
	private Boolean health;
	private Boolean healthRef;
	private Boolean financial;
	private Boolean financialRef;
	private Boolean family;
	private Boolean familyRef;
	private Boolean languageNonIRCC;
	private Boolean languageNonIRCCRef;
	private Boolean educationSkill;
	private Boolean educationSkillRef;
	private Boolean employmentRelated;
	private Boolean employmentRelatedRef;
	private Boolean legalInfo;
	private Boolean legalInfoRef;
	private Boolean community;
	private Boolean CommunityRef;
	
	public NeedAssessRef() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentifierValue() {
		return identifierValue;
	}

	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}

	public String getProcDetail() {
		return procDetail;
	}

	public void setProcDetail(String procDetail) {
		this.procDetail = procDetail;
	}

	public String getUpdateRecordID() {
		return updateRecordID;
	}

	public void setUpdateRecordID(String updateRecordID) {
		this.updateRecordID = updateRecordID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getServiceLanguage() {
		return serviceLanguage;
	}

	public void setServiceLanguage(String serviceLanguage) {
		this.serviceLanguage = serviceLanguage;
	}

	public String getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public Boolean getCompletedAndShared() {
		return completedAndShared;
	}

	public void setCompletedAndShared(Boolean completedAndShared) {
		this.completedAndShared = completedAndShared;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Boolean getKnowledge_Life() {
		return knowledge_Life;
	}

	public void setKnowledge_Life(Boolean knowledge_Life) {
		this.knowledge_Life = knowledge_Life;
	}

	public Boolean getKnowledge_LifeRef() {
		return knowledge_LifeRef;
	}

	public void setKnowledge_LifeRef(Boolean knowledge_LifeRef) {
		this.knowledge_LifeRef = knowledge_LifeRef;
	}

	public Boolean getKnowledge_ComAndGov() {
		return knowledge_ComAndGov;
	}

	public void setKnowledge_ComAndGov(Boolean knowledge_ComAndGov) {
		this.knowledge_ComAndGov = knowledge_ComAndGov;
	}

	public Boolean getKnowledge_ComAndGovRef() {
		return knowledge_ComAndGovRef;
	}

	public void setKnowledge_ComAndGovRef(Boolean knowledge_ComAndGovRef) {
		this.knowledge_ComAndGovRef = knowledge_ComAndGovRef;
	}

	public Boolean getKnowledge_Work() {
		return knowledge_Work;
	}

	public void setKnowledge_Work(Boolean knowledge_Work) {
		this.knowledge_Work = knowledge_Work;
	}

	public Boolean getKnowledge_WorkRef() {
		return knowledge_WorkRef;
	}

	public void setKnowledge_WorkRef(Boolean knowledge_WorkRef) {
		this.knowledge_WorkRef = knowledge_WorkRef;
	}

	public Boolean getKnowledge_Education() {
		return knowledge_Education;
	}

	public void setKnowledge_Education(Boolean knowledge_Education) {
		this.knowledge_Education = knowledge_Education;
	}

	public Boolean getKnowledge_EducationRef() {
		return knowledge_EducationRef;
	}

	public void setKnowledge_EducationRef(Boolean knowledge_EducationRef) {
		this.knowledge_EducationRef = knowledge_EducationRef;
	}

	public Boolean getIncrease_SocialNetwork() {
		return increase_SocialNetwork;
	}

	public void setIncrease_SocialNetwork(Boolean increase_SocialNetwork) {
		this.increase_SocialNetwork = increase_SocialNetwork;
	}

	public Boolean getIncrease_SocialNetworkRef() {
		return increase_SocialNetworkRef;
	}

	public void setIncrease_SocialNetworkRef(Boolean increase_SocialNetworkRef) {
		this.increase_SocialNetworkRef = increase_SocialNetworkRef;
	}

	public Boolean getIncrease_ProfessionalNetwork() {
		return increase_ProfessionalNetwork;
	}

	public void setIncrease_ProfessionalNetwork(Boolean increase_ProfessionalNetwork) {
		this.increase_ProfessionalNetwork = increase_ProfessionalNetwork;
	}

	public Boolean getIncrease_ProfessionalNetworkRef() {
		return increase_ProfessionalNetworkRef;
	}

	public void setIncrease_ProfessionalNetworkRef(Boolean increase_ProfessionalNetworkRef) {
		this.increase_ProfessionalNetworkRef = increase_ProfessionalNetworkRef;
	}

	public Boolean getIncrease_localCommunityService() {
		return increase_localCommunityService;
	}

	public void setIncrease_localCommunityService(Boolean increase_localCommunityService) {
		this.increase_localCommunityService = increase_localCommunityService;
	}

	public Boolean getIncrease_localCommunityServiceRef() {
		return increase_localCommunityServiceRef;
	}

	public void setIncrease_localCommunityServiceRef(Boolean increase_localCommunityServiceRef) {
		this.increase_localCommunityServiceRef = increase_localCommunityServiceRef;
	}

	public Boolean getIncrease_CommunityInvolv() {
		return increase_CommunityInvolv;
	}

	public void setIncrease_CommunityInvolv(Boolean increase_CommunityInvolv) {
		this.increase_CommunityInvolv = increase_CommunityInvolv;
	}

	public Boolean getIncrease_CommunityInvolvRef() {
		return increase_CommunityInvolvRef;
	}

	public void setIncrease_CommunityInvolvRef(Boolean increase_CommunityInvolvRef) {
		this.increase_CommunityInvolvRef = increase_CommunityInvolvRef;
	}

	public Boolean getImproveLanguage() {
		return improveLanguage;
	}

	public void setImproveLanguage(Boolean improveLanguage) {
		this.improveLanguage = improveLanguage;
	}

	public Boolean getImproveLanguageRef() {
		return improveLanguageRef;
	}

	public void setImproveLanguageRef(Boolean improveLanguageRef) {
		this.improveLanguageRef = improveLanguageRef;
	}

	public String getImproveLanguageTo() {
		return improveLanguageTo;
	}

	public void setImproveLanguageTo(String improveLanguageTo) {
		this.improveLanguageTo = improveLanguageTo;
	}

	public Boolean getImproveOther() {
		return improveOther;
	}

	public void setImproveOther(Boolean improveOther) {
		this.improveOther = improveOther;
	}

	public Boolean getImproveOtherRef() {
		return improveOtherRef;
	}

	public void setImproveOtherRef(Boolean improveOtherRef) {
		this.improveOtherRef = improveOtherRef;
	}

	public String getImproveOtherTo() {
		return improveOtherTo;
	}

	public void setImproveOtherTo(String improveOtherTo) {
		this.improveOtherTo = improveOtherTo;
	}

	public Boolean getFindEmployment() {
		return findEmployment;
	}

	public void setFindEmployment(Boolean findEmployment) {
		this.findEmployment = findEmployment;
	}

	public Boolean getFindEmploymentRef() {
		return findEmploymentRef;
	}

	public void setFindEmploymentRef(Boolean findEmploymentRef) {
		this.findEmploymentRef = findEmploymentRef;
	}

	public String getFindEmploymentTimeFrame() {
		return findEmploymentTimeFrame;
	}

	public void setFindEmploymentTimeFrame(String findEmploymentTimeFrame) {
		this.findEmploymentTimeFrame = findEmploymentTimeFrame;
	}

	public Boolean getMinimumWorkExperience() {
		return minimumWorkExperience;
	}

	public void setMinimumWorkExperience(Boolean minimumWorkExperience) {
		this.minimumWorkExperience = minimumWorkExperience;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Boolean getObtainCredential() {
		return obtainCredential;
	}

	public void setObtainCredential(Boolean obtainCredential) {
		this.obtainCredential = obtainCredential;
	}

	public Boolean getCitizen() {
		return citizen;
	}

	public Boolean getSupportServiceRequired() {
		return supportServiceRequired;
	}

	public void setSupportServiceRequired(Boolean supportServiceRequired) {
		this.supportServiceRequired = supportServiceRequired;
	}

	public Boolean getChildrenCare() {
		return childrenCare;
	}

	public void setChildrenCare(Boolean childrenCare) {
		this.childrenCare = childrenCare;
	}

	public Boolean getTransportation() {
		return transportation;
	}

	public void setTransportation(Boolean transportation) {
		this.transportation = transportation;
	}

	public Boolean getDisability() {
		return disability;
	}

	public void setDisability(Boolean disability) {
		this.disability = disability;
	}

	public Boolean getTranslation() {
		return translation;
	}

	public void setTranslation(Boolean translation) {
		this.translation = translation;
	}

	public Boolean getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(Boolean interpretation) {
		this.interpretation = interpretation;
	}

	public Boolean getCrisisCounselling() {
		return crisisCounselling;
	}

	public void setCrisisCounselling(Boolean crisisCounselling) {
		this.crisisCounselling = crisisCounselling;
	}

	public void setCitizen(Boolean citizen) {
		this.citizen = citizen;
	}

	public Boolean getNonIRCCServiceNeeded() {
		return nonIRCCServiceNeeded;
	}

	public void setNonIRCCServiceNeeded(Boolean nonIRCCServiceNeeded) {
		this.nonIRCCServiceNeeded = nonIRCCServiceNeeded;
	}

	public Boolean getFood() {
		return food;
	}

	public void setFood(Boolean food) {
		this.food = food;
	}

	public Boolean getFoodRef() {
		return foodRef;
	}

	public void setFoodRef(Boolean foodRef) {
		this.foodRef = foodRef;
	}

	public Boolean getHousing() {
		return housing;
	}

	public void setHousing(Boolean housing) {
		this.housing = housing;
	}

	public Boolean getHousingRef() {
		return housingRef;
	}

	public void setHousingRef(Boolean housingRef) {
		this.housingRef = housingRef;
	}

	public Boolean getHealth() {
		return health;
	}

	public void setHealth(Boolean health) {
		this.health = health;
	}

	public Boolean getHealthRef() {
		return healthRef;
	}

	public void setHealthRef(Boolean healthRef) {
		this.healthRef = healthRef;
	}

	public Boolean getFinancial() {
		return financial;
	}

	public void setFinancial(Boolean financial) {
		this.financial = financial;
	}

	public Boolean getFinancialRef() {
		return financialRef;
	}

	public void setFinancialRef(Boolean financialRef) {
		this.financialRef = financialRef;
	}

	public Boolean getFamily() {
		return family;
	}

	public void setFamily(Boolean family) {
		this.family = family;
	}

	public Boolean getFamilyRef() {
		return familyRef;
	}

	public void setFamilyRef(Boolean familyRef) {
		this.familyRef = familyRef;
	}

	public Boolean getLanguageNonIRCC() {
		return languageNonIRCC;
	}

	public void setLanguageNonIRCC(Boolean languageNonIRCC) {
		this.languageNonIRCC = languageNonIRCC;
	}

	public Boolean getLanguageNonIRCCRef() {
		return languageNonIRCCRef;
	}

	public void setLanguageNonIRCCRef(Boolean languageNonIRCCRef) {
		this.languageNonIRCCRef = languageNonIRCCRef;
	}

	public Boolean getEducationSkill() {
		return educationSkill;
	}

	public void setEducationSkill(Boolean educationSkill) {
		this.educationSkill = educationSkill;
	}

	public Boolean getEducationSkillRef() {
		return educationSkillRef;
	}

	public void setEducationSkillRef(Boolean educationSkillRef) {
		this.educationSkillRef = educationSkillRef;
	}

	public Boolean getEmploymentRelated() {
		return employmentRelated;
	}

	public void setEmploymentRelated(Boolean employmentRelated) {
		this.employmentRelated = employmentRelated;
	}

	public Boolean getEmploymentRelatedRef() {
		return employmentRelatedRef;
	}

	public void setEmploymentRelatedRef(Boolean employmentRelatedRef) {
		this.employmentRelatedRef = employmentRelatedRef;
	}

	public Boolean getLegalInfo() {
		return legalInfo;
	}

	public void setLegalInfo(Boolean legalInfo) {
		this.legalInfo = legalInfo;
	}

	public Boolean getLegalInfoRef() {
		return legalInfoRef;
	}

	public void setLegalInfoRef(Boolean legalInfoRef) {
		this.legalInfoRef = legalInfoRef;
	}

	public Boolean getCommunity() {
		return community;
	}

	public void setCommunity(Boolean community) {
		this.community = community;
	}

	public Boolean getCommunityRef() {
		return CommunityRef;
	}

	public void setCommunityRef(Boolean communityRef) {
		CommunityRef = communityRef;
	}

}
