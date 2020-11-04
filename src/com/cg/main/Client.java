package com.cg.main;


import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.cg.entity.Broker;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.service.BrokerServiceImpl;
import com.cg.service.CustomerServiceImpl;
import com.cg.service.DealServiceimpl;
import com.cg.service.PropertyServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int userChoice;
		Customer customer=new Customer();
		Broker broker=new Broker();
		Deal deal=new Deal();
		Property property=new Property();
		PropertyCriteria criteria=new PropertyCriteria(); 
		CustomerServiceImpl customerService=new CustomerServiceImpl();
		BrokerServiceImpl brokerService=new BrokerServiceImpl();
		PropertyServiceImpl propertyService=new PropertyServiceImpl(); 
		DealServiceimpl dealService=new DealServiceimpl();
		
		System.out.println("------------REAL ESTATE APPLICATION-----------");
		System.out.println("1.Broker");
		System.out.println("2.Customer");
		userChoice=sc.nextInt();
		sc.nextLine();
		if(userChoice==1) { // This case is for broker role
			System.out.println("1.New Broker");
			System.out.println("2.Existing Broker");
			int brokerChoice=sc.nextInt();
			sc.nextLine();
			if(brokerChoice==1) { // This case collects the details of broker to create broker profile
				System.out.println("Enter Broker Id");
				int broId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name");
				String name=sc.nextLine();
				System.out.println("Enter password");
				String password=sc.next();
				System.out.println("Enter Mobile Number");
				String mobile=sc.next();
				System.out.println("Enter Email Address");
				String email=sc.next();
				System.out.println("Enter city");
				String city=sc.next();
				broker.setBroId(broId);
				broker.setBroName(name);
				broker.setPassword(password);
				broker.setRole("Broker");
				broker.setMobile(mobile);
				broker.setEmail(email);
				broker.setCity(city);
				try {
				brokerService.addBroker(broker);//This method will add the broker into database
				System.out.println("Broker Added Successfully..");
				}catch(Exception ex) {
					System.err.println("ID Already Exists!!!");
					System.out.println("Try with another ID...");
				}
				

			}else { //This case provides existing broker to add, delete and update properties
				System.out.println("Welcome Broker!!!!");
				System.out.println("Select Your Preference:");
				System.out.println("1: Add Properties");
				System.out.println("2: Delete Properties");
				System.out.println("3: Update Properties");
				int propertyPreference=sc.nextInt();
				switch(propertyPreference) {  
				case 1: System.out.println("Enter the Property Details: ");
						System.out.println("Enter the configuration of the property from the below choice: ");
						System.out.println("Flat");
						System.out.println("Shop");
						System.out.println("Plot");
						String configuration=sc.next();
						System.out.println("Enter Offer Type: Sell or Rent ");
						String offerType=sc.next();
						System.out.println("Enter the Offer Cost ");
						double offerCost=sc.nextDouble();
						System.out.println("Enter the Property Area Square Feet: ");
						double areaSqft=sc.nextDouble();
						sc.nextLine();
						System.out.println("Enter the City: ");
						String city=sc.nextLine();
						System.out.println("Enter the address of property: ");
						String address=sc.nextLine();
						System.out.println("Enter the Street: ");
						String street=sc.nextLine();
						System.out.println("Enter the status of your Property");
						System.out.println("Available-----> True");
						System.out.println("Sold-----> False");
						boolean status=sc.nextBoolean();	// Available(true)/ Sold(false)
						property.setConfiguration(configuration);
						property.setOfferType(offerType);
						property.setOfferCost(offerCost);
						property.setAreaSqft(areaSqft);
						property.setCity(city);
						property.setAddress(address);
						property.setStreet(street);
						property.setStatus(status);
						propertyService.addProperty(property); // This method will add the property into database
						System.out.println("Property Added Successfully!!!");
						break;
				case 2: System.out.println("Enter the ID of the property to be deleted: ");
				 		int propId=sc.nextInt();
				 		property.setPropId(propId);
					try {
						propertyService.removeProperty(propId); // This method will delete the property from database
						System.out.println("Property Deleted Successfully!!!");
					} catch (PropertyNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Property Not Found!!!!");
						e.printStackTrace();
					}
						break;
				case 3: System.out.println("Enter the ID of the property to be updated: ");	// In this case property details can be edited	
						int propId1=sc.nextInt();
						property.setPropId(propId1);
					try {
						property=propertyService.viewProperty(propId1); // This method will view the property with the help of property Id
						System.out.println("Your Property Details:");
						System.out.println(property);
					} catch (PropertyNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Property Not Found!!!!");
						e.printStackTrace();
					}
						System.out.println("Please enter the detail which you want to Update: ");
						System.out.println("1.Configuration \n 2.OfferType \n 3.Offer Cost \n 4.AreaSqFt. \n 5.City \n 6.Address \n 7.Street");
						int choice=sc.nextInt();
						switch(choice) {
						case 1: System.out.println("Enter the configuration of the property to be updated from the below choice: ");
								System.out.println("Flat");
								System.out.println("Shop");
								System.out.println("Plot");
								String configuration1=sc.next();
								property.setConfiguration(configuration1);
								propertyService.editProperty(property);
								break;
						case 2: System.out.println("Enter the Offer Type of the property to be updated: \n Rent \n Sale ");
								String offerType1=sc.next();
								property.setOfferType(offerType1);
								propertyService.editProperty(property);// This method will edit the property according to the details
								break;
						case 3: System.out.println("Enter the OfferCost of the property to be updated");
								double offerCost1=sc.nextDouble();
								property.setOfferCost(offerCost1);
								propertyService.editProperty(property);
						case 4: System.out.println("Enter the Area Square Feet of the property to be updated");
								double areaSqft1=sc.nextDouble();
								sc.nextLine();
								property.setAreaSqft(areaSqft1);
								propertyService.editProperty(property);
								break;
						case 5: System.out.println("Enter the City of the property to be updated");	
								String city1=sc.nextLine();
								property.setCity(city1);
								propertyService.editProperty(property);
								break;
						case 6: System.out.println("Enter the Address of the property to be updated");	
								String address1=sc.nextLine();
								property.setAddress(address1);
								propertyService.editProperty(property);
								break;
						case 7: System.out.println("Enter the Street of the property to be updated");	
								String street1=sc.nextLine();
								property.setStreet(street1);
								propertyService.editProperty(property);
								break;
						
								
						}
						System.out.println("Property Updated Successfully!!!!");
						
				}
			}

		}else {  // This case is for customer role
			System.out.println("1.New Customer");
			System.out.println("2.Existing Customer");
			int customerChoice=sc.nextInt();
			sc.nextLine();
			if(customerChoice==1) {  // This case collects the details of customer to create customer profile
				System.out.println("Enter Customer Id");
				int custId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name");
				String custName=sc.nextLine();
				System.out.println("Enter password");
				String password=sc.next();
				System.out.println("Enter Mobile Number");
				String mobile=sc.next();
				System.out.println("Enter Email Address");
				String email=sc.next();
				System.out.println("Enter city");
				String city=sc.next();
				customer.setCustId(custId);
				customer.setCustName(custName);
				customer.setPassword(password);
				customer.setRole("Customer");
				customer.setMobile(mobile);
				customer.setEmail(email);
				customer.setCity(city);
				try { 
				customerService.addCustomer(customer); // This method will add the customer into data base
				System.err.println("Customer Added Successfully..");
				}catch(Exception ex) {
					System.err.println("ID Already Exists!!!");
					System.out.println("Try with another ID...");
				}
			}else { // This case will help the customer to search the properties with criteria
					//such as configuration, offer, city, minimum cost and maximum cost.
				//Also this case help the customer to buy or rent the property.
				System.out.println("Welcome Customer!!!!");
				System.out.println("What would you like to do today: Buy/Rent: ");
				String offer=sc.next();
				System.out.println("Enter the choice of your configuration: ");
				System.out.println("\n Flat \n Shop \n Plot");
				String config=sc.next();
				sc.nextLine();
				System.out.println("Enter the city: ");
				String city=sc.nextLine();
				System.out.println("Enter your Minimum cost and Maximum Cost: ");
				double minCost=sc.nextDouble();
				double maxCost=sc.nextDouble();
				criteria.setOffer(offer);
				criteria.setConfig(config);
				criteria.setCity(city);
				criteria.setMinCost(minCost);
				criteria.setMaxCost(maxCost);
				System.out.println("Results based on your choice is: ");
				List<Property> list=propertyService.listPropertyByCriteria(criteria); // This method will list properties according to choice of the customer
				if(list.size()==0) {
					System.out.println("Sorry!!! No Properties found as of your choice!! Try with other search...");
					System.exit(0);
				}else {
				for (Property property2 : list) {
					System.out.println(property2);
				}
			}
				System.out.println("Do you want to buy or rent any of the properties in above list: Yes / No ");
				String ok=sc.next();
				if(ok.equalsIgnoreCase("Yes")) { // If customer choose yes, then it will be the deal between customer and broker
					System.out.println("Enter your User Id");
					int userId=sc.nextInt();
					Customer customer2=new Customer();
					customer2.setUserid(userId);
					System.out.println("Enter the Property Id you want to buy");
					int propertyId=sc.nextInt();
					Property property2=new Property();
					property2.setPropId(propertyId);
					try {
						property2=propertyService.viewProperty(propertyId);
					} catch (PropertyNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Property not found");
						e.printStackTrace();
					}
					double dealCost=property2.getOfferCost();
					deal.setProperty(property2);
					deal.setCustomer(customer2);
					deal.setDealCost(dealCost);
					LocalDate date = LocalDate.now();
					deal.setDealDate(date);
					dealService.addDeal(deal);// This method will add the deal in the database
					System.out.println("Deal Done Successfully!!! ");
					System.out.println("Completed Deals are: ");
					List<Deal> deals=dealService.listAllDeals();
					for (Iterator<Deal> iterator = deals.iterator(); iterator.hasNext();) {
						Deal deal2 = (Deal) iterator.next();
						System.out.println(deal2);	
					}
					
				}else {
					System.out.println("Thank You!!!");
					System.exit(0);
				}
		}
		
		}
		sc.close();

	}

}
