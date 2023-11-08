package canteen2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Service class for managing and interacting with customer users in the system.
 */

public class CustomerService {
	protected EntityManager em;

	/**
     * Constructor for creating a CustomerService instance with an EntityManager.
     *
     * @param em The EntityManager to be used for database interactions.
     */
	
	public CustomerService(EntityManager em) {
		this.em = em;
	}
	
	/**
     * Update an existing customer user or create a new one if it doesn't exist.
     *
     * @param firstName    
     * @param surname       
     * @param username      
     * @param password     
     * @param orders        
     * @param customersId   
     * @return The updated or newly created Customer instance.
     */
	
	public Customer updateCustomer(String FirstName, String surname, String username,String password, int id,List<MaOrder>orders,int customersId) {
		Customer newCustomer = em.find(Customer.class, customersId);
		if(newCustomer == null) {
			newCustomer = new Customer();			
			em.persist(newCustomer);
		}
		newCustomer.setFirstName(FirstName);
		newCustomer.setSurname(surname);
		newCustomer.setUsername(username);
		newCustomer.setPassword(password);
		newCustomer.setId(id);
		newCustomer.setCustomersId(customersId);
		newCustomer.getOrders().clear();
		newCustomer.getOrders().addAll(orders);
		em.persist(newCustomer);
		
		return newCustomer;
	}

	/**
     * Remove a customer user from the database by customer-specific identifier.
     *
     * @param customersId The customer-specific identifier of the customer user to be removed.
     */
	
	public void removeCustomer(int customersId) {
		Customer newCustomer = findCustomer(customersId);
		if(newCustomer != null) {
			em.remove(newCustomer);
		}
	}
	
	/**
     * Find a customer user by customer-specific identifier.
     *
     * @param customersId The customer-specific identifier to search for.
     * @return The found Customer instance, or null if not found.
     */
	
	
	public Customer findCustomer(int customersId) {
		return em.find(Customer.class, customersId);
	}
	
	/**
     * Retrieve a list of all customer users in the system.
     *
     * @return A list of all Customer instances in the database.
     */
	
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers() {
		Query qd = em.createQuery("SELECT a FROM Customer a");
		return qd.getResultList();
	}
	
}
