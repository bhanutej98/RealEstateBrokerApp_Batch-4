package com.cg.main;

import java.util.List;
import java.util.Scanner;

import com.cg.entity.Broker;
import com.cg.entity.Customer;
import com.cg.entity.Property;
import com.cg.exception.BrokerNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.service.BrokerServiceImpl;
import com.cg.service.CustomerServiceImpl;
import com.cg.service.PropertyServiceImpl;

public class Admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Customer customer=new Customer();
		Broker broker=new Broker();
		CustomerServiceImpl customerService=new CustomerServiceImpl();
		BrokerServiceImpl brokerService=new BrokerServiceImpl();
		PropertyServiceImpl propertyService=new PropertyServiceImpl(); 
		
		System.out.println("Welcome Admin!!!");
		System.out.println("Which task you want perform: ");
		System.out.println(" 1. Delete Broker \n 2. Edit Broker \n 3. View Broker \n 4. List All Brokers \n 5. Delete Customer \n 6. Edit Customer \n"
				+ " 7. View Customer \n 8. List All Customers \n 9. List All Properties ");
		int adminChoice=sc.nextInt();
		switch(adminChoice) { 
		case 1: System.out.println("Enter the Broker Id to be deleted: ");
		  		int broId=sc.nextInt();
		  		broker.setBroId(broId);
			try {
				brokerService.removeBroker(broId); // This method will remove the broker from database
			} catch (BrokerNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Broker Not Found");
				e.printStackTrace();
			}
		  		System.out.println("Broker removed successfully....");
		  		break;
		case 2: System.out.println("Enter the Broker Id to be edited: ");
  				int broId1=sc.nextInt();
  				broker.setBroId(broId1);
			try {
				broker=brokerService.viewBroker(broId1); // This method will view the broker with help of broker id
			} catch (BrokerNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Broker Not Found");
				e.printStackTrace();
			}
  				System.out.println("Enter the details you want to update: 1.City / 2.Mobile Number ");
  				int ch =sc.nextInt();
  				if(ch==1) {
  					String city=sc.nextLine();
  					broker.setCity(city);
  					try {
						brokerService.editBroker(broker); // This method will edit the broker details 
					} catch (BrokerNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Broker Not Found");
						e.printStackTrace();
					}
  					System.out.println("Broker edited successfully.....");
  					try {
						broker=brokerService.viewBroker(broId1);
					} catch (BrokerNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Broker Not Found");
						e.printStackTrace();
					}
  					System.out.println(broker);
  				}else {
  					String mobile=sc.next();
  					broker.setMobile(mobile);
  					try {
						brokerService.editBroker(broker);
					} catch (BrokerNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Broker Not Found");
						e.printStackTrace();
					}
  					System.out.println("Broker edited successfully.....");
  					try {
						broker=brokerService.viewBroker(broId1);
					} catch (BrokerNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
  					System.out.println(broker);
  	
  				}
  				break;
		case 3: System.out.println("Enter the Broker Id to be viewed: ");
				int broId2=sc.nextInt();
				broker.setBroId(broId2);
				try {
					broker=brokerService.viewBroker(broId2);// This method will view the broker with the help of broker id.
				} catch (BrokerNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Broker Not Found");
					e.printStackTrace();
				}	
				System.out.println(broker);
				break;
		case 4: List<Broker> brokerList	= brokerService.listAllBrokers(); // This method will list all the brokers available in the database
				for (Broker broker2 : brokerList) {
					System.out.println(broker2);
				}
				break;
		case 5: System.out.println("Enter the Customer Id to be deleted: ");
  				int custId=sc.nextInt();
  				customer.setCustId(custId);
  				try {
  					customerService.removeCustomer(customer); // This method will remove the customer from database
  				} catch (CustomerNotFoundException e) {
  					// TODO Auto-generated catch block
  					System.err.println("Customer Not Found");
  					e.printStackTrace();
  				}
  				System.out.println("Customer removed successfully....");
  				break;
		case 6: System.out.println("Enter the Customer Id to be edited: ");
				int custId1=sc.nextInt();
				customer.setCustId(custId1);
				try {
					customer=customerService.viewCustomer(custId1); // This method will view the customer according to the customer Id
				} catch (CustomerNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Customer Not Found");
					e.printStackTrace();
				}
				System.out.println("Enter the details you want to update: 1.City / 2.Mobile Number ");
				int ch1 =sc.nextInt();
				if(ch1==1) {
				String city=sc.nextLine();
				customer.setCity(city);
				customerService.editCustomer(customer); // This method will edit the customer details
				System.out.println("Customer edited successfully.....");
				try {
					customer=customerService.viewCustomer(custId1);
				} catch (CustomerNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Customer Not Found");
					e.printStackTrace();
				}
				System.out.println(customer);
			}else {
				String city=sc.nextLine();
				customer.setCity(city);
				customerService.editCustomer(customer);
				System.out.println("Customer edited successfully.....");
				try {
					customer=customerService.viewCustomer(custId1);
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Customer Not Found");
				e.printStackTrace();
			}
				System.out.println(customer);			
			}
			break;
		case 7: System.out.println("Enter the Customer Id to be viewed: ");
				int custId2=sc.nextInt();
				customer.setCustId(custId2);
				try {
					customer=customerService.viewCustomer(custId2);
				} catch (CustomerNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Customer Not Found");
					e.printStackTrace();
				}	
				System.out.println(customer);
				break;
		case 8: List<Customer> customerList	= customerService.listAllCustomers(); // This method will list all the customers available in the database
				for (Customer customer2 : customerList) {
					System.out.println(customer2);
				}
				break;
		case 9: List<Property> propertyList = propertyService.listAllProperties(); // This method will list all the properties available in the database
				for (Property property2 : propertyList) {
					System.out.println(property2);
				}
				break;
		}
		sc.close();
		

	}

}
