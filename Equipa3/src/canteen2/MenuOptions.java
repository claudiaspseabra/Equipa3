/**
 * 
 */
package canteen2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents menu options for dishes, desserts, and drinks in the system.
 */

@Entity
public class MenuOptions{ // create a dish/drink/desert

	/**
	 * @param typeFood
	 * @param plateName
	 * @param dessertName
	 * @param drinkName
	 * @param id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int menuNumber;
	private String typeFood;
	private String plateName;
	private String dessertName;
	private String drinkName;
	
	
	public MenuOptions() {
		
	}

	/**
	 * @return the typeFood
	 */
	public String getTypeFood() {
		return typeFood;
	}

	/**
	 * @param typeFood the typeFood to set
	 */
	public void setTypeFood(String typeFood) {
		this.typeFood = typeFood;
	}

	/**
	 * @return the plateName
	 */
	public String getPlateName() {
		return plateName;
	}

	/**
	 * @param plateName the plateName to set
	 */
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	/**
	 * @return the dessertName
	 */
	public String getDessertName() {
		return dessertName;
	}

	/**
	 * @param dessertName the dessertName to set
	 */
	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}

	/**
	 * @return the drinkName
	 */
	public String getDrinkName() {
		return drinkName;
	}

	/**
	 * @param drinkName the drinkName to set
	 */
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	/**
	 * @return the menuNumber
	 */
	public int getMenuNumber() {
		return menuNumber;
	}

	/**
	 * @param menuNumber the menuNumber to set
	 */
	public void setMenuNumber(int menuNumber) {
		this.menuNumber = menuNumber;
	}

	/**
     * Override of the toString method to provide a string representation of the menu option.
     *
     * @return A string representation of the menu option, including type of food, plate name, dessert name, drink name, and menu number.
     */

	@Override
	public String toString() {
		return typeFood + ", description = " + plateName + ", dessert= " + dessertName + ", drink = " + drinkName + ", menu number: = " + menuNumber;
	}





}