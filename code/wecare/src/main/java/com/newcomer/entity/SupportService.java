package com.newcomer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SupportService")
public class SupportService {
	
	@Id
	private String id;
	private String identifierValue;
	private Boolean received;
	private Boolean childCare;
	private String child1Age;
	private String child1CareType;
	private String child2Age;
	private String child2CareType;
	private String child3Age;
	private String child3CareType;
	private String child4Age;
	private String child4CareType;
	private String child5Age;
	private String child5CareType;
	private Boolean transportation;
	private Boolean disabilities;
	private String translateBetween;
	private String translateAnd;
	private String interpreteBetween;
	private String interpreteAnd;
	private Boolean crisisCounselling;
	private String updateReason;
	
	public SupportService() {
		
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

	public Boolean getReceived() {
		return received;
	}

	public Boolean getChildCare() {
		return childCare;
	}

	public void setChildCare(Boolean childCare) {
		this.childCare = childCare;
	}

	public void setReceived(Boolean received) {
		this.received = received;
	}

	public String getChild1Age() {
		return child1Age;
	}

	public void setChild1Age(String child1Age) {
		this.child1Age = child1Age;
	}

	public String getChild1CareType() {
		return child1CareType;
	}

	public void setChild1CareType(String child1CareType) {
		this.child1CareType = child1CareType;
	}

	public String getChild2Age() {
		return child2Age;
	}

	public void setChild2Age(String child2Age) {
		this.child2Age = child2Age;
	}

	public String getChild2CareType() {
		return child2CareType;
	}

	public void setChild2CareType(String child2CareType) {
		this.child2CareType = child2CareType;
	}

	public String getChild3Age() {
		return child3Age;
	}

	public void setChild3Age(String child3Age) {
		this.child3Age = child3Age;
	}

	public String getChild3CareType() {
		return child3CareType;
	}

	public void setChild3CareType(String child3CareType) {
		this.child3CareType = child3CareType;
	}

	public String getChild4Age() {
		return child4Age;
	}

	public void setChild4Age(String child4Age) {
		this.child4Age = child4Age;
	}

	public String getChild4CareType() {
		return child4CareType;
	}

	public void setChild4CareType(String child4CareType) {
		this.child4CareType = child4CareType;
	}

	public String getChild5Age() {
		return child5Age;
	}

	public void setChild5Age(String child5Age) {
		this.child5Age = child5Age;
	}

	public String getChild5CareType() {
		return child5CareType;
	}

	public void setChild5CareType(String child5CareType) {
		this.child5CareType = child5CareType;
	}

	public Boolean getTransportation() {
		return transportation;
	}

	public void setTransportation(Boolean transportation) {
		this.transportation = transportation;
	}

	public Boolean getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(Boolean disabilities) {
		this.disabilities = disabilities;
	}

	public String getTranslateBetween() {
		return translateBetween;
	}

	public void setTranslateBetween(String translateBetween) {
		this.translateBetween = translateBetween;
	}

	public String getTranslateAnd() {
		return translateAnd;
	}

	public void setTranslateAnd(String translateAnd) {
		this.translateAnd = translateAnd;
	}

	public String getInterpreteBetween() {
		return interpreteBetween;
	}

	public void setInterpreteBetween(String interpreteBetween) {
		this.interpreteBetween = interpreteBetween;
	}

	public String getInterpreteAnd() {
		return interpreteAnd;
	}

	public void setInterpreteAnd(String interpreteAnd) {
		this.interpreteAnd = interpreteAnd;
	}

	public Boolean getCrisisCounselling() {
		return crisisCounselling;
	}

	public void setCrisisCounselling(Boolean crisisCounselling) {
		this.crisisCounselling = crisisCounselling;
	}

	public String getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}
	
	

}
