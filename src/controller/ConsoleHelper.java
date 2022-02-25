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

import model.Console;

/**
 * @author Bobby
 *
 */
public class ConsoleHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Project");
	
	public void insertConsole(Console con) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.persist(con); 
		em.getTransaction().commit(); 
		em.close(); 
	}
	
	public List<Console> showAllConsoles(){ 
		EntityManager em = emfactory.createEntityManager(); 
		List<Console> allConsoles = em.createQuery("SELECT i FROM Console i").getResultList(); 
		return allConsoles; 
	}
}
