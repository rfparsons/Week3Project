/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Console;
import model.Game;

/**
 * @author Bobby
 *
 */
public class ConsoleHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Project");
	
	public boolean insertConsole(Console con) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		
		TypedQuery<Console> typedQuery = em.createQuery("select con from Console con where con.consoleName = :Name", Console.class); 
		 
	    //Substitute parameter with actual data from the con item 
	    typedQuery.setParameter("Name", con.getConsoleName()); 
		
	    boolean consoleDoesNotExist = typedQuery.getResultList().isEmpty(); // check if console already exists
	    
	    if (consoleDoesNotExist) {
	    	em.persist(con); 
			em.getTransaction().commit();
	    }
		
		em.close(); 
		
		return !consoleDoesNotExist; //returns true if successful
	}
	
	public List<Console> showAllConsoles(){ 
		EntityManager em = emfactory.createEntityManager(); 
		List<Console> allConsoles = em.createQuery("SELECT i FROM Console i").getResultList(); 
		return allConsoles; 
	}
	
	public Console findConsole(String consoleName) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		
		TypedQuery<Console> typedQuery = em.createQuery("select con from Console con where con.consoleName = :Name", Console.class); 
		 
	    //Substitute parameter with actual data
	    typedQuery.setParameter("Name", consoleName); 
	    
	    Console con = typedQuery.getSingleResult();
	    
	    return con;
	}
}
