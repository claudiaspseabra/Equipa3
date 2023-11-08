/**
 * 
 */
package canteen2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Service class for managing and interacting with menu options in the system.
 */


public class MenuOptionsService {
	
	protected EntityManager em;
	
	/**
     * Constructor for creating a MenuOptionsService instance with an EntityManager.
     *
     * @param em The EntityManager to be used for database interactions.
     */
	
	
	public MenuOptionsService(EntityManager em) {
		this.em = em;
	}
	
	/**
     * Update an existing menu option or create a new one if it doesn't exist.
     *
     * @param typeFood     
     * @param plateName    
     * @param dessertName  
     * @param drinkName    
     * @param menuNumber   
     * @return The updated or newly created MenuOptions instance.
     */
	
	
	public MenuOptions updateMenuOptions(String typeFood,String plateName,String dessertName,String drinkName, int menuNumber) {
		MenuOptions newMenuOption = em.find(MenuOptions.class, menuNumber);
		if(newMenuOption == null) {
			newMenuOption = new MenuOptions();			
			em.persist(newMenuOption);
		}
		newMenuOption.setTypeFood(typeFood);
		newMenuOption.setPlateName(plateName);;
		newMenuOption.setDessertName(dessertName);
		newMenuOption.setDrinkName(drinkName);
		newMenuOption.setMenuNumber(menuNumber);
		em.persist(newMenuOption);
		
		
		return newMenuOption;
	}
	
	/**
     * Remove a menu option from the database by the unique menu number.
     *
     * @param menuNumber The unique identifier of the menu option to be removed.
     */
	
	public void removeMenuOption(int menuNumber) {
		MenuOptions newMenuOption = findMenuOption(menuNumber);
		if(newMenuOption != null) {
			em.remove(newMenuOption);
		}
	}

	 /**
     * Find a menu option by its unique menu number.
     *
     * @param menuNumber The unique menu number to search for.
     * @return The found MenuOptions instance, or null if not found.
     */

	public MenuOptions findMenuOption(int menuNumber) {
		return em.find(MenuOptions.class, menuNumber);
	}
	
	 /**
     * Retrieve a list of all menu options in the system.
     *
     * @return A list of all MenuOptions instances in the database.
     */
	
	@SuppressWarnings("unchecked")
	public List<MenuOptions> findAllMenuOptions() {
		Query qd = em.createQuery("SELECT a FROM MenuOptions a ORDER BY a.menuNumber",MenuOptions.class);
		return qd.getResultList();
	}
}

