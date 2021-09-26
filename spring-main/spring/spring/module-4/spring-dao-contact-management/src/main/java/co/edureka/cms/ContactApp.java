package co.edureka.cms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.cms.entity.Contact;
import co.edureka.cms.service.ContactService;

public class ContactApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("contact-beans.xml");
		
		ContactService contactService = (ContactService) context.getBean("contactservice");
		
		/*
		//--saving a contact
		Contact contact = new Contact(101, "Sunil Joseph", "sunil@hotmail.com");		
		contactService.newContact(contact);
		*/
		
		/*
		//--updating a contact
		Contact contact = new Contact(101, "Sunil Joseph", "sunil@edureka.com");
		contactService.updateContact(contact);		
		*/
		
		//--deleting a contact based on contactId
		//contactService.deleteContactById(101);
		
		/*
		//get all contacts
		List<Contact> contacts = contactService.getAllContacts();
		for(Contact ct : contacts) {
			System.out.println(ct);
		}
		*/
		
		/*
		//get a Contact by Contact ID
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a contact id: ");
		int cid = sc.nextInt();
		Contact contact = contactService.getContactByContactId(cid);
		if(contact != null) {
			System.out.println(contact);
		}else {
			System.out.println("No Macthing Contact for CONTACT_ID : " + cid);
		}
		
		sc.close();
		*/
		
		
		contactService.getNoOfContacts();
		
		
		/*
		contactService.getContactsAsMap();
		*/
		
		/*
		contactService.getContactAsMap(102);
		*/
		/*
		List<Contact> contacts = new ArrayList<Contact>();
		for(int i=1001;i<=2000;i++) {
			Contact ct = new Contact();
			ct.setContactId(i);
			ct.setContactName("edureka-"+i);
			ct.setContactEmail("ct."+i+"@edureka.co");
			
			contacts.add(ct);
		}
		contactService.batchInsertion(contacts);
		*/
	}
}
