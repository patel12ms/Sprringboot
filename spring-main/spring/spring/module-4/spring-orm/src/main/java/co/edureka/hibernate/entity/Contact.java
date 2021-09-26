package co.edureka.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "CONTACT_MASTER")

public class Contact {
	//@Id
	//@Column(name = "CONTACT_ID")
	private Integer contactId;
	
	//@Column(name = "CONTACT_NAME")
	private String contactName;
	
	//@Column(name = "CONTACT_EMAIL")
	private String contactEmail;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Integer contactId, String contactName, String contactEmail) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ "]";
	}

}
