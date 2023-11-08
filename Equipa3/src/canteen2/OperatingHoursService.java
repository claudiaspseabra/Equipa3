package canteen2;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

/**
 * Service class for managing and interacting with operating hours in the system.
 */


public class OperatingHoursService {
    protected EntityManager em;

    /**
     * Constructor for creating an OperatingHoursService instance with an EntityManager.
     *
     * @param em The EntityManager to be used for database interactions.
     */
    
    public OperatingHoursService(EntityManager em) {
        this.em = em;
    }

    /**
     * Insert or update operating hours for a specific day of the week.
     *
     * @param dayOfWeek   
     * @param openingTime 
     * @param closingTime 
     * @param id         
     * @return The inserted or updated OperatingHours instance.
     */
    
    
    public OperatingHours insertOperatingHours(String dayOfWeek, Date openingTime, Date closingTime , int id) {
    	
    	OperatingHours newOperatingHours = em.find(OperatingHours.class, id);
		if(newOperatingHours == null) {
			newOperatingHours = new OperatingHours();			
			em.persist(newOperatingHours);
		}
    	
        newOperatingHours.setDayOfTheWeek(dayOfWeek);
        newOperatingHours.setOpeningTime(openingTime);
        newOperatingHours.setClosingTime(closingTime);

        em.persist(newOperatingHours);
        
        return newOperatingHours;
    }
    
    /**
     * Remove operating hours entry from the database by its unique identifier.
     *
     * @param id The unique identifier of the operating hours entry to be removed.
     */
    
   
    
    public void removeOperatingHours(int id) {
        OperatingHours operatingHours = findOperatingHours(id);
        if (operatingHours != null) {
            em.remove(operatingHours);
        }
    }

    /**
     * Find operating hours by its unique identifier.
     *
     * @param id The unique identifier of the operating hours entry to search for.
     * @return The found OperatingHours instance, or null if not found.
     */
    
    
    public OperatingHours findOperatingHours(int id) {
        return em.find(OperatingHours.class, id);
    }
	
    
    /**
     * Retrieve a list of all operating hours entries in the system.
     *
     * @return A list of all OperatingHours instances in the database.
     */
    
    @SuppressWarnings("unchecked")
	public List<OperatingHours> findAllOperatingHours() {
		Query oh = em.createQuery("SELECT oh FROM OperatingHours oh",OperatingHours.class);
		return oh.getResultList();
	}
    
    
    
}