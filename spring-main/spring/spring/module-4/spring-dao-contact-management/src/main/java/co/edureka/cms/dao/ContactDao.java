package co.edureka.cms.dao;

import java.util.List;
import java.util.Map;

import co.edureka.cms.entity.Contact;

public interface ContactDao {
  public Integer saveContact(Contact contact);
  public Integer updateContact(Contact contact);
  public Integer deleteContact(Integer cid);
  
  public Contact findContactByContactId(Integer cid);
  public List<Contact> findAllContacts();
  
  public Integer findContactsCount();
  
  public Map<String, Object> findContactAsMap(Integer cid);
  public List<Map<String, Object>> findAllContactsAsMap();
  
  public void batchInsertionOfContacts(List<Contact> contacts);
}
