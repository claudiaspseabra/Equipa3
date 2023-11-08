package canteen2;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")


/**
 * This class represents an admin user in the system.
 */

public class Admin extends TypeUser{
	/**
	 * @param password
	 * @param FirstName
	 * @param surname
	 * @param username
	 * @param idNumber
	 */
	@Column(name="Admin_Specific")
	private int adminNumber;
	
	/**
	 * Default constructor for creating an instance of the Admin class.
	 */
	
	public Admin() {
		
	}
	 /**
	 * constructor to create an Admin
     * @param password  
     * @param firstName 
     * @param surname  
     * @param username 
     * @param idNumber  
     */
	
	
	public Admin(String password, String first_Name, String surname, String username, int id,int idNumber) {
		super(password, first_Name, surname, username,id);
		this.adminNumber = idNumber;
	}

	/**
	 * @return the adminNumber
	 */
	public int getAdminNumber() {
		return adminNumber;
	}

	/**
	 * @param adminNumber the adminNumber to set
	 */
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	/**
     * Override of the toString method to provide a string representation of the Admin user.
     *
     * @return A string representation of the Admin user, including the admin number.
     */
	
	@Override
	public String toString() {
		return super.toString() + ", admin id: " + adminNumber;
	}
	
}


	