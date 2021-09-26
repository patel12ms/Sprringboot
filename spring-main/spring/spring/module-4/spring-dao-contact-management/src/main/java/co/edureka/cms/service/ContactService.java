package co.edureka.cms.service;

import java.util.List;

import co.edureka.cms.entity.Contact;

public interface ContactService {
 public void newContact(Contact contact);
 public void updateContact(Contact contact);
 public void deleteContactById(Integer cid);
 
 public Contact getContactByContactId(Integer cid);
 public List<Contact> getAllContacts();
 
 public void getNoOfContacts();
 
 public void getContactAsMap(Integer cid);
 public void getContactsAsMap();
 
 public void batchInsertion(List<Contact> contacts);
}
