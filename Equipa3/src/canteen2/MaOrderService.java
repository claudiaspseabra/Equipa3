package canteen2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * This class provides services for managing and interacting with orders in the system.
 */

public class MaOrderService {
    protected EntityManager em;

    /**
     * Constructor for creating a MaOrderService instance with an EntityManager.
     *
     * @param em The EntityManager to be used for database interactions.
     */
    
    public MaOrderService(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Update an existing order or create a new one if it doesn't exist.
     *
     * @param cost        
     * @param orderId       
     * @param paymentMethod
     * @param menu          
     * @return The updated or newly created MaOrder instance.
     */

    public MaOrder updateOrder(double cost, int orderId, String paymentMethod, MenuOptions menu) {
        MaOrder newOrder = em.find(MaOrder.class, orderId);
        if (newOrder == null) {
            newOrder = new MaOrder();
            em.persist(newOrder);
        }
        newOrder.setCost(cost);
        newOrder.setOrderId(orderId);
        newOrder.setNewMenu(menu);
        newOrder.setPaymentMethod(paymentMethod);
        em.persist(newOrder);
        
        return newOrder;
    }
    
    
    /**
     * Remove an order from the database by the unique order identifier.
     *
     * @param orderId The unique identifier of the order to be removed.
     */
    

    public void removeOrder(int orderId) {
        MaOrder newOrder = findOrder(orderId);
        if (newOrder != null) {
            em.remove(newOrder);
        }
    }

    /**
     * Find an order by its unique order identifier.
     *
     * @param orderId The unique order identifier to search for.
     * @return The found MaOrder instance, or null if not found.
     */
    
    public MaOrder findOrder(int orderId) {
        return em.find(MaOrder.class, orderId);
    }

    /**
     * Retrieve a list of all orders in the system, ordered by order identifier.
     *
     * @return A list of all MaOrder instances in the database, ordered by order identifier.
     */
    
    @SuppressWarnings("unchecked")
    public List<MaOrder> findAllOrders() {
    	Query qd = em.createQuery("SELECT a FROM MaOrder a ORDER BY a.orderId");
        return qd.getResultList();
    }
}

