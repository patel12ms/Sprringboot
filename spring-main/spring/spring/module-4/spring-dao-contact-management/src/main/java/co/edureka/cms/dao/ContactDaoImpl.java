package co.edureka.cms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.edureka.cms.entity.Contact;

public class ContactDaoImpl implements ContactDao {
	@Autowired
	private JdbcTemplate jt;
	
	public Integer saveContact(Contact contact) {
		String sql = "insert into CONTACT_MASTER(CONTACT_ID, CONTACT_NAME, CONTACT_EMAIL) values ("
				+ contact.getContactId()+",'"+contact.getContactName()+"', '"+contact.getContactEmail()+"')";
		
		Integer rowsInserted = jt.update(sql);
		return rowsInserted;
	}

	public Integer updateContact(Contact contact) {
		String sql = "update CONTACT_MASTER set CONTACT_NAME=' "+contact.getContactName()+"', CONTACT_EMAIL='"
				+ contact.getContactEmail()+"' where CONTACT_ID="+contact.getContactId();
		
		Integer rowsUpdated = jt.update(sql);
		return rowsUpdated;
	}

	public Integer deleteContact(Integer cid) {
		String sql = "delete from CONTACT_MASTER where CONTACT_ID="+cid;
		return jt.update(sql);
	}

	public Contact findContactByContactId(final Integer cid) {
		
		String sql = "select CONTACT_NAME, CONTACT_EMAIL from CONTACT_MASTER where CONTACT_ID="+cid;
		
		Contact contact = jt.queryForObject(sql, new RowMapper<Contact>() {

			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {			 
				String name = rs.getString(1);
				String email = rs.getString(2);
				
				Contact contact = new Contact(cid, name, email);
				return contact;
			}			
		});				
		return contact;		
		
		/*
		//---- approach-2 --> to overcome SQL Injection		
		String sql = "select CONTACT_NAME, CONTACT_EMAIL from CONTACT_MASTER where CONTACT_ID = ?";
		Contact contact = jt.queryForObject(sql, new Object[] {cid}, new RowMapper<Contact>() {

			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				String name = rs.getString(1);
				String email = rs.getString(2);
				
				Contact contact = new Contact(cid, name, email);
				return contact;
			}			
		});
		return contact;
		*/
	}

	public List<Contact> findAllContacts() {
		String sql = "select * from CONTACT_MASTER";
		
		List<Contact> contacts = jt.query(sql, new ResultSetExtractor<List<Contact>>() {
			
			List<Contact> cts = new ArrayList<Contact>();
			
			public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
			  while(rs.next()) {	
				Integer cid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				
				Contact ct = new Contact(cid, name, email);
				cts.add(ct);
			  }//while
			  return cts;			  
			}			
		});
		
		return contacts;
	}

	
	public Integer findContactsCount() {
		String sql = "select count(*) from CONTACT_MASTER";
		Integer contactCount = jt.queryForObject(sql, Integer.class);
		return contactCount;
	}

	public List<Map<String, Object>> findAllContactsAsMap() {
		String sql = "select * from CONTACT_MASTER";
		
		List<Map<String, Object>> contactsMap = jt.queryForList(sql);
		return contactsMap;
	}

	public Map<String, Object> findContactAsMap(Integer cid) {
		String sql = "select * from CONTACT_MASTER where CONTACT_ID="+cid;
		Map<String, Object> contactMap = jt.queryForMap(sql); 
		return contactMap;
	}

	public void batchInsertionOfContacts(final List<Contact> contactsList) {
		String sql = "insert into CONTACT_MASTER(CONTACT_ID, CONTACT_NAME, CONTACT_EMAIL) values(?,?,?)";
		
		jt.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Contact contact = contactsList.get(i);
				
				ps.setInt(1, contact.getContactId());
				ps.setString(2, contact.getContactName());
				ps.setString(3, contact.getContactEmail());
				
				//System.out.println(contact);
			}
			
			public int getBatchSize() {
				return contactsList.size();
			}
		});
	}

}
