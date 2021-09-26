package co.edureka.cms.entity;

public class Contact {
	private Integer contactId;
	private String contactName;
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
		return "Contact [" + contactId + " | " + contactName + " | " + contactEmail + "]";
	}
}
