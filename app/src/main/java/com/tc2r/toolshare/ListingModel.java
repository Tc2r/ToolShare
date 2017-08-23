package com.tc2r.toolshare;

/**
 * Created by nudennie.white on 8/23/17.
 */

class ListingModel {
	int id;
	String sharerId;
	String title;
	String description;
	String location;
	String contact;

	public ListingModel(int id, String sharerId, String title, String description, String location, String contact) {
		this.id = id;
		this.sharerId = sharerId;
		this.title = title;
		this.description = description;
		this.location = location;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSharerId() {
		return sharerId;
	}

	public void setSharerId(String sharerId) {
		this.sharerId = sharerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
