package co.edureka.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.hibernate.dao.ContactDao;
import co.edureka.hibernate.entity.Contact;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-config-beans.xml");
		
		ContactDao dao = (ContactDao) context.getBean("contactdao");
		
		
		Contact contact = new Contact(107, "Srinivas", "srinu@gmail.com");
		dao.saveContact(contact);
		//dao.deleteContact(contact);
		
		
		/*
		Contact contact = dao.findContactById(101);
		System.out.println(contact);
		*/
		
		/*
		List<Contact> contacts = dao.findAll();
		for(Contact ct : contacts) {
			System.out.println(ct);
			Thread.sleep(200);
		}
		*/
	}
}
