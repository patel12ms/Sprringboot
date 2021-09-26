package co.edureka.cms.service;

import java.util.List;
import java.util.Map;

import co.edureka.cms.dao.ContactDao;
import co.edureka.cms.entity.Contact;

public class ContactServiceImpl implements ContactService {
	//@Autowired
	private ContactDao dao;	
	
	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	public void newContact(Contact contact) {
		Integer contactsSaved = dao.saveContact(contact);
		if(contactsSaved > 0){
			System.out.println("###--- Contact Saved ---###");
		}else {
			System.out.println("###--- Contact could not be Saved ---###");
		}
	}

	public void updateContact(Contact contact) {
		Integer contactsUpdated = dao.updateContact(contact);
		if(contactsUpdated > 0){
			System.out.println("###--- Contact Updated ---###");
		}else {
			System.out.println("###--- No Matching Contact for Updation ---###");
		}
	}

	public void deleteContactById(Integer cid) {
		Integer contactsDeleted = dao.deleteContact(cid);
		if(contactsDeleted > 0){
			System.out.println("###--- Contact with Contact ID: "+cid+" Deleted ---###");
		}else {
			System.out.println("###--- No Matching Contact found for Deletion ---###");
		}
	}

	public Contact getContactByContactId(Integer cid) {
		Contact contact = dao.findContactByContactId(cid);
		return contact;
	}

	public List<Contact> getAllContacts() {
		List<Contact> contacts = dao.findAllContacts();
		return contacts;
	}

	public void getNoOfContacts() {
		Integer no = dao.findContactsCount();
		System.out.println("No of Contacts in Data Store = " + no);
	}

	public void getContactsAsMap() {
		List<Map<String, Object>> contacts = dao.findAllContactsAsMap();
		//System.out.println(contacts);
		for(Map<String, Object> contact : contacts) {
			System.out.println(contact);
		}
	}

	public void getContactAsMap(Integer cid) {
		Map<String, Object> contact = dao.findContactAsMap(cid);
		System.out.println(contact);	
	}

	public void batchInsertion(List<Contact> contacts) {
		dao.batchInsertionOfContacts(contacts);		
	}

}
