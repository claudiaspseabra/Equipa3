package canteen2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class Test {
	private static final String PERSISTANCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory emf;
	private static EntityManager em = null;
	

	
	public static void fill() {
		
		
        EntityManager em = getEM();

        List<Customer> customers = null;
		List<MaOrder> orders = null;
		List<MenuOptions> menus = null;
		List<Admin> admins = null;
		List<OperatingHours> hours = null;
		
		em.getTransaction().begin();

        AdminService adminServ = new AdminService(getEM());
        List<Admin> adminList = adminServ.findAllAdmins();
		for (Admin a : adminList) {
			adminServ.removeAdmin(a.getAdminNumber());
		}
        
		
        MenuOptionsService menuOptionsServ = new MenuOptionsService(getEM());
        List<MenuOptions> menuOptionsList = menuOptionsServ.findAllMenuOptions();
		for (MenuOptions m : menuOptionsList) {
			menuOptionsServ.removeMenuOption(m.getMenuNumber());;
		}
        
		
		CustomerService customerServ = new CustomerService(getEM());
		List<Customer> customerList = customerServ.findAllCustomers();
		if (customerList != null) {
		    for (Customer c : customerList) {
		        customerServ.removeCustomer(c.getCustomersId());
		    }
		}
        
		
        MaOrderService orderServ = new MaOrderService(getEM());
        List<MaOrder> orderList = orderServ.findAllOrders();
		for (MaOrder o : orderList) {
			orderServ.removeOrder(o.getOrderId());;
		}
		
		
		OperatingHoursService opS = new OperatingHoursService(getEM());
		List<OperatingHours> opSList = opS.findAllOperatingHours();
		for (OperatingHours op : opSList) {
		    opS.removeOperatingHours(op.getId());
		}

		
		
		em.getTransaction().commit();
		// clean data base
		
        // Start adding data to our data base
		em.getTransaction().begin();
        
        // Add admin
        
        Admin admin1 = adminServ.updateAdmin("Joao", "Antonio", "admin","123", 1, 100);
        Admin admin2 = adminServ.updateAdmin("Manuel","Luis","admin1","123",2,101);
        System.out.println("Admins added successfully!\n");
        
        // Only admins can add/change Operating hours
        
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm'h'");
            Date openingTimeDate = timeFormat.parse("8:00h");
            Date closingTimeDate = timeFormat.parse("19:00h");
            OperatingHours operatingH = opS.insertOperatingHours("Monday", openingTimeDate, closingTimeDate, 1);
            System.out.println("Operating hours added successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error!");
        }

        
        
        // Add menu
        MenuOptions menu1 = menuOptionsServ.updateMenuOptions("Fish", "Fish and chips", "Ice cream", "Water",1);
        MenuOptions menu2 = menuOptionsServ.updateMenuOptions("Meat", "Meat and potatos", "Apple", "Orange Juice",2);
        MenuOptions menu3 = menuOptionsServ.updateMenuOptions("Vegetarian", "Salad with cheese", "Cake", "Wine",3);
        System.out.println("Menus added successfully!\n");
        
        
        // Add customer
        Customer customer1 = customerServ.updateCustomer("Antonio", "Joao", "customer","123", 2,new ArrayList<>(), 132);
        Customer customer2 = customerServ.updateCustomer("Luis", "Manuel", "customer1","123", 3, new ArrayList<>(), 133);
        Customer customer3 = customerServ.updateCustomer("Telmo", "Joaquim", "customer2","123", 4, new ArrayList<>(), 134);
        System.out.println("Customers added successfully!\n");
        
        // Add order
        MaOrder order1 = orderServ.updateOrder(2, 1,"Credit Card",menu1);
        MaOrder order2 = orderServ.updateOrder(1.50,2,"Cash",menu2);
        MaOrder order3 = orderServ.updateOrder(4, 3,"Cash",menu3);
        System.out.println("Orders added successfully!\n");
        
        // Add order to customer
        
        customer1.getOrders().add(order1);
        customer2.getOrders().add(order2);
        customer3.getOrders().add(order3);
        System.out.println("Orders added successfully to customers!\n");
        
		em.getTransaction().commit();

		
		
		
		// print the data in the database  : Customers , Admins , MenuOptions and Orders.
		
		
		
		//Admins
		System.out.println("------------------------");	
		admins = adminServ.findAllAdmins();
		System.out.println("Admins table:");
		for (Admin a : admins) {
			System.out.println(a);				}
		System.out.println("------------------------");	
		
		
		//Customers
		
		customers = customerServ.findAllCustomers();
		System.out.println("Customers table:");
		for (Customer c : customers) {
			System.out.println(c);
		}
		System.out.println("------------------------");
		
		
		//MenuOptions
			
		menus = menuOptionsServ.findAllMenuOptions();
		System.out.println("Menu table:");
		for (MenuOptions m : menus) {
			System.out.println(m);
		}
		System.out.println("------------------------");
		
		
		// Orders
		
		orders = orderServ.findAllOrders();
		System.out.println("Orders table:");
		for (MaOrder o : orders) {
			System.out.println(o);
		}
		System.out.println("------------------------");
		
		
		// Operating hours
		
		hours = opS.findAllOperatingHours();
		System.out.println("Operating hours: ");
		for (OperatingHours oh : hours) {
			System.out.println(oh);
		}
		System.out.println("------------------------");
        
    }
	
	
	
  
    
    
	public static EntityManager getEM() {
		if(em == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
			em = emf.createEntityManager();
		}
		return em;
	}
	

	
	
	   // main test
    public static void main(String[] args) {
    	// principal
    	System.setProperty("derby.language.sequence.preallocator", "1");
    	fill();
    }
	
}