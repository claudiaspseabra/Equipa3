package canteen2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Service class for managing and interacting with admin users in the system.
 */

public class AdminService {
	protected EntityManager em;

	/**
     * Constructor for creating an AdminService instance with an EntityManager
     *
     * @param em The EntityManager to be used for database interactions
     */
	
	public AdminService(EntityManager em) {
		this.em = em;
	}
	
	/**
     * Update an existing admin user or create a new one if it doesn't exist.
     *
     * @param firstName    
     * @param surname      
     * @param username     
     * @param password   
     * @param adminNumber  
     * @return The updated or newly created Admin instance.
     */
	
	public Admin updateAdmin( String FirstName, String surname, String username, String password,int id,int adminNumber) {
		Admin newAdmin = em.find(Admin.class, adminNumber);
		if(newAdmin == null) {
			newAdmin = new Admin(FirstName, surname,username, password, id, adminNumber);
			em.persist(newAdmin);
		}
		newAdmin.setFirstName(FirstName);
		newAdmin.setSurname(surname);
		newAdmin.setUsername(username);
		newAdmin.setPassword(password);
		newAdmin.setAdminNumber(adminNumber);
		newAdmin.setId(adminNumber);
		em.persist(newAdmin);
		
		return newAdmin;
	}
	
	/**
     * Remove an admin user from the database by admin number.
     *
     * @param adminNumber The admin number of the admin user to be removed.
     */
	
	
	public void removeAdmin(int adminNumber) {
		Admin newAdmin = findAdmin(adminNumber);
		if(newAdmin != null) {
			em.remove(newAdmin);
		}
	}
	
	/**
     * Find an admin user by admin number.
     *
     * @param adminNumber 
     * @return The found Admin instance, or null if not found.
     */
	
	public Admin findAdmin(int adminNumber) {
		return em.find(Admin.class, adminNumber);
	}
	
	/**
     * Retrieve a list of all admin users in the system.
     *
     * @return A list of all Admin instances in the database.
     */
	
	@SuppressWarnings("unchecked")
	public List<Admin> findAllAdmins() {
		Query qd = em.createQuery("SELECT a FROM Admin a ORDER BY a.adminNumber");
		return qd.getResultList();
	}
}
