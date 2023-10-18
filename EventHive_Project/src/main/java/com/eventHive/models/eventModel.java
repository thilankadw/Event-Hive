package com.eventHive.models;

public class eventModel {

	private int eventId;
	private String eventName;
	private String eventOrganization;
	private String eventVenue;
	private String eventDistrict;
	private String eventCategory;
	private String eventStartTime;
	private String eventEndTime;
	private String eventStartDate;
	private String eventEndDate;
	private String eventType;
	private String eventPaymentType;
	private String vipPackagePrice;
	private String premiumPackagePrice;
	private String standardPackagePrice;
	private String eventRefundAvailable;
	private String eventVisibility;
	private String maxParticipants;
	private String eventDescription;
	private String eventImage;
	
	public eventModel(int eventId, String eventName, String eventOrganization, String eventVenue, String eventDistrict,
			String eventCategory, String eventStartTime, String eventEndTime, String eventStartDate,
			String eventEndDate, String eventType, String eventPaymentType, String vipPackagePrice,
			String premiumPackagePrice, String standardPackagePrice, String eventRefundAvailable,
			String eventVisibility, String maxParticipants, String eventDescription, String eventImage) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventOrganization = eventOrganization;
		this.eventVenue = eventVenue;
		this.eventDistrict = eventDistrict;
		this.eventCategory = eventCategory;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.eventType = eventType;
		this.eventPaymentType = eventPaymentType;
		this.vipPackagePrice = vipPackagePrice;
		this.premiumPackagePrice = premiumPackagePrice;
		this.standardPackagePrice = standardPackagePrice;
		this.eventRefundAvailable = eventRefundAvailable;
		this.eventVisibility = eventVisibility;
		this.maxParticipants = maxParticipants;
		this.eventDescription = eventDescription;
		this.eventImage = eventImage;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventOrganization() {
		return eventOrganization;
	}

	public void setEventOrganization(String eventOrganization) {
		this.eventOrganization = eventOrganization;
	}

	public String getEventVenue() {
		return eventVenue;
	}

	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}

	public String getEventDistrict() {
		return eventDistrict;
	}

	public void setEventDistrict(String eventDistrict) {
		this.eventDistrict = eventDistrict;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventPaymentType() {
		return eventPaymentType;
	}

	public void setEventPaymentType(String eventPaymentType) {
		this.eventPaymentType = eventPaymentType;
	}

	public String getVipPackagePrice() {
		return vipPackagePrice;
	}

	public void setVipPackagePrice(String vipPackagePrice) {
		this.vipPackagePrice = vipPackagePrice;
	}

	public String getPremiumPackagePrice() {
		return premiumPackagePrice;
	}

	public void setPremiumPackagePrice(String premiumPackagePrice) {
		this.premiumPackagePrice = premiumPackagePrice;
	}

	public String getStandardPackagePrice() {
		return standardPackagePrice;
	}

	public void setStandardPackagePrice(String standardPackagePrice) {
		this.standardPackagePrice = standardPackagePrice;
	}

	public String getEventRefundAvailable() {
		return eventRefundAvailable;
	}

	public void setEventRefundAvailable(String eventRefundAvailable) {
		this.eventRefundAvailable = eventRefundAvailable;
	}

	public String getEventVisibility() {
		return eventVisibility;
	}

	public void setEventVisibility(String eventVisibility) {
		this.eventVisibility = eventVisibility;
	}

	public String getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(String maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getEventREescription() {
		return eventDescription;
	}

	public void setEventREescription(String eventREescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	
	
	
	
	
}