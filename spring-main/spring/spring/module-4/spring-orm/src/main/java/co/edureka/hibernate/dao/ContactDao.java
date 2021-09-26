package co.edureka.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import co.edureka.hibernate.entity.Contact;

public class ContactDao {
	@Autowired
	private HibernateTemplate template;
	
	@Transactional(readOnly = false)
	public void saveContact(Contact contact) {
		template.save(contact);
		System.out.println("###--- Contact Saved ---###");
	}
	
	@Transactional(readOnly = false)
	public void updateContact(Contact contact) {
		template.update(contact);
		System.out.println("###--- Contact Updated ---###");
	}	
	
	@Transactional(readOnly = false)
	public void deleteContact(Contact contact) {
		template.delete(contact);
		System.out.println("###--- Contact Delete ---###");
	}
	
	public Contact findContactById(Integer contactId) {
		Contact contact = template.get(Contact.class, contactId);
		return contact;
	}
	
	public List<Contact> findAll(){
		return template.loadAll(Contact.class);
	}
}
