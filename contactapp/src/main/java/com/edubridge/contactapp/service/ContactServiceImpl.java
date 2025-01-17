package com.edubridge.contactapp.service;

import java.util.List;


import com.edubridge.contactapp.dao.ContactDao;
import com.edubridge.contactapp.dao.ContactDaoImpl;
import com.edubridge.contactapp.model.Contact;

public class ContactServiceImpl implements ContactService{
	 static ContactDao dao = new ContactDaoImpl();
	 
	 

	@Override
	public int addContact(Contact contact) {
		return dao.addContact(contact);
	
	}

	@Override
	public List<Contact> viewContacts() {
    return dao.viewContacts();
		
	}

	@Override
	public Contact findContactByName(String Name) {
	return dao.findContactByName(Name);
	
	}

	@Override
	public int updateContact(Contact contact) {
		return dao.updateContact(contact);
		
	}

	@Override
	public int deleteContact(String Name) {
		return dao.deleteContact(Name);

	}

	@Override
	public void deleteAllContacts() {
		dao.deleteAllContacts();
		
	}
}

