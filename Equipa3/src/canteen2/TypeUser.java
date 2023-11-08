/**
 * 
 */
package canteen2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


import org.eclipse.persistence.annotations.ClassExtractor;

@ClassExtractor(UserClassExtractor.class)

@Entity
@Table(name = "TYPEUSER")
@Inheritance(strategy = InheritanceType.JOINED)

/**
 * Abstract base class for representing different types of users in the system.
 */

public abstract class TypeUser {
	/**
	 * @param password
	 * @param FirstName
	 * @param surname
	 */

	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String password;
	private String FirstName;
	private String surname;
	private String username;
	
	
	public TypeUser() {
		
	}

	
	public TypeUser(String first_Name, String surname, String username,String password,int id) {
		this.password = password;
		this.FirstName = first_Name;
		this.surname = surname;
		this.username = username;
		this.id = id;
		// remove id from here
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the first_Name
	 */
	public String getFirstName() {
		return FirstName;
	}
	/**
	 * @param first_Name the first_Name to set
	 */
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
     * Override of the toString method to provide a string representation of the user.
     *
     * @return A string representation of the user, including first name, surname, ID, username, and password.
     */
	
	
	@Override
	public String toString() {
		return "First name = " + FirstName + ", surname = " + surname + ", id : " + id +", username = " + username + ", password = " + password;
	}


	
	

}
