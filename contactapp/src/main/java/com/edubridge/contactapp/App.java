package com.edubridge.contactapp;

import java.util.List;




import java.util.Scanner;


import com.edubridge.contactapp.model.Contact;
import com.edubridge.contactapp.service.ContactServiceImpl;

public class App{

 public static void main(String[] args) {
	
}
    	Scanner in = new Scanner(System.in);
    	
    	int option = 0;
    	String name = null;
		String email = null;
    	long mobile = 0L;
    	int id = 0;
    	
    	ContactServiceImpl service = new ContactServiceImpl();
    	
    	do {
    		System.out.println("CONTACT APPLICATION");
    		System.out.println("--------------------");
    		System.out.println("1.Add Contact");
    		System.out.println("2.View Contact");
    		System.out.println("3.Search Contact");
    		System.out.println("4.Update Contact");
    		System.out.println("5.Delete Contact");
    		System.out.println("6.Delete All Contacts");
    		System.out.println("0.Exit");
    		System.out.println("please choose option");
    		option = in.nextInt();
    		
    		switch(option) {
    		case 1:
    			System.out.println("please enter name");
    			name = in.next();
    			System.out.println("please enter email");
    			email = in.next();
    			System.out.println("please enter mobile");
    			mobile = in.nextLong();
    			Contact newContact = new Contact();
    			newContact.setName(name);
    			newContact.setEmail(email);
    			newContact.setMobile(mobile);
    			
    			int status = service.addContact(newContact);
    			if(status>=1) {
    				System.out.println("new contact added successfully..!!");
    			}else {
    				System.out.println("Something went wrong..!!");
    			}
    			
    			
    			break;
    		case 2:
    			List<Contact> contacts = service.viewContacts();
    			if(contacts.size()!=0) {
    				System.out.println("ID\tNAME\tEMAIL\tMOBILE");
    			
    				for(Contact c : contacts) {
    					System.out.println(c.getName()+"\t"+c.getEmail()+"\t"+c.getMobile());
    			}	
    				}else {
    					System.out.println("No Contacts Found!!");
    					
    			}
    			break;
    		case 3:
    			System.out.println("search contact by name: ");
    			name = in.next();
    			Contact searchContact = service.findContactByName(name);
    			if(searchContact != null) {
    				System.out.println("ID: "+searchContact.getId());
    				System.out.println("NAME: "+searchContact.getName());
    				System.out.println("EMAIL: "+searchContact.getEmail());
    				System.out.println("MOBILE: "+searchContact.getMobile());
    			}else {
    				System.out.println("No Contacts Found..!!");
    				
    			}
    			
    			break;
    		case 4:
    			System.out.println("please enter id:");
    			id = in.nextInt();
    			System.out.println("please enter name:");
    			name = in.next();
    			System.out.println("please enter email:");
    			email = in.next();
    			System.out.println("please enter mobile:");
    			mobile = in.nextLong();
    			
    			Contact updateContact = new Contact();
    			updateContact.setId(id);
    			updateContact.setName(name);
    			updateContact.setEmail(email);
    			updateContact.setMobile(mobile);
    			
    			status = service.updateContact(updateContact);
    			if(status >= 1) {
    				System.out.println("contact details are updated..!!");
    			}else {
    				System.out.println("Something went wrong..!!");
    			}
    			
    			break;
    		case 5:
    			System.out.println("please enter the name");
    			name=in.next();
    			if(service.findContactByName(name) != null) {
       			 status = service.deleteContact(name);
       			if(status>=1) {
       				System.out.println("Employee is Deleted");
       			}else {
       				System.out.println("Something is wrong");
       			}
       			}else {
       				System.out.println("no contact Found!!");
       			}
       			
       			
       			break;
       		case 6:
       			System.out.println("delete all contacts");
       			if(status>=1) {
       				System.out.println("deleteallcontacts from contacts");
       			}else {
       				System.out.println("deleted contacts successfully");
       			}
       			break;
       		case 0:
       			System.out.println("BYE..!!");
       			System.exit(0);
       		
       		default:
       			System.out.println("Invalid option.please choose correct option.");
       			
       			break;
       			
       		}
    	}while (option !=0);
  
    	
      }
       }



