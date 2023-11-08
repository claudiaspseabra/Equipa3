package canteen2;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
//@PrimaryKeyJoinColumn(referencedColumnName="id")
/**
 * This class represents a customer user in the system.
 */

@Entity
@Table(name = "CUSTOMER")	
public class Customer extends TypeUser{
	/**
	 * @param customersId
	 * @param orders
	 */


	/**
     * The list of orders associated with the customer.
     */


	@Column(name="Customer_Specific")
	private int customersId;
	
	@OneToMany (fetch=FetchType.LAZY) 
	List<MaOrder> orders = new ArrayList<MaOrder>();
	
	/**
	 * Default constructor for creating an instance of the Customer class.
	 */
	
	
	public Customer() {
		
	}


	/**
	 * @return the customersId
	 */
	public int getCustomersId() {
		return customersId;
	}



	/**
	 * @param customersId the customersId to set
	 */
	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}



	/**
	 * @return the orders
	 */
	public List<MaOrder> getOrders() {
		return orders;
	}



	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<MaOrder> orders) {
		this.orders = orders;
	}

	/**
     * Override of the toString method to provide a string representation of the Customer user.
     *
     * @return A string representation of the Customer user, including the customer-specific identifier and orders.
     */

	@Override
	public String toString() {
		return super.toString()+ ", customers Id=" + customersId + ", orders= " + orders;
	}

	


}