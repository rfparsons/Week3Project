/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Game;

/**
 * @author Bobby
 *
 */
public class GameHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Project");
	
	public void insertGame(Game gm) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.persist(gm); 
		em.getTransaction().commit(); 
		em.close(); 
	}
	
	public List<Game> showAllGames(){ 
		EntityManager em = emfactory.createEntityManager(); 
		List<Game> allGames = em.createQuery("SELECT i FROM Game i").getResultList(); 
		return allGames; 
	}
	
	public void deleteGame(Game toDelete) { 
	    EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    TypedQuery<Game> typedQuery = em.createQuery("select gm from Game gm where gm.title = :selectedTitle and gm.publisher = :selectedPublisher and gm.platform = :selectedPlatform and gm.year = :selectedYear", Game.class); 
	 
	    //Substitute parameter with actual data from the toDelete item 
	    typedQuery.setParameter("selectedTitle", toDelete.getTitle()); 
	    typedQuery.setParameter("selectedPublisher", toDelete.getPublisher()); 
	    typedQuery.setParameter("selectedPlatform", toDelete.getPlatform()); 
	    typedQuery.setParameter("selectedYear", toDelete.getYear()); 
	 
	    //we only want one result 
	    typedQuery.setMaxResults(1); 
	 
	    //get the result and save it into a new list item 
	    Game result = typedQuery.getSingleResult(); 
	 
	    //remove it 
	    em.remove(result); 
	    em.getTransaction().commit(); 
	    em.close(); 
	     
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Game searchForGameById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    Game found = em.find(Game.class, idToEdit); 
	    em.close(); 
	    return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateGame(Game toEdit) {
		EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    em.merge(toEdit); 
	    em.getTransaction().commit(); 
	    em.close();
	}

	/**
	 * @param gameName
	 * @return
	 */
	public List<Game> searchForGameByTitle(String gameName) {
		EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    TypedQuery<Game> typedQuery = em.createQuery("select gm from Game gm where gm.title = :selectedGame", Game.class); 
	    typedQuery.setParameter("selectedGame", gameName); 
	 
	    List<Game> foundGames = typedQuery.getResultList(); 
	    em.close(); 
	    return foundGames;
	}
	
	/**
	 * @param publisher
	 * @return
	 */
	public List<Game> searchForGameByPublisher(String publisher) {
		EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    TypedQuery<Game> typedQuery = em.createQuery("select gm from Game gm where gm.publisher = :selectedGame", Game.class); 
	    typedQuery.setParameter("selectedGame", publisher); 
	 
	    List<Game> foundGames = typedQuery.getResultList(); 
	    em.close(); 
	    return foundGames;
	}
	
	/**
	 * @param platform
	 * @return
	 */
	public List<Game> searchForGameByPlatform(String platform) {
		EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    TypedQuery<Game> typedQuery = em.createQuery("select gm from Game gm where gm.platform = :selectedGame", Game.class); 
	    typedQuery.setParameter("selectedGame", platform); 
	 
	    List<Game> foundGames = typedQuery.getResultList(); 
	    em.close(); 
	    return foundGames;
	}
	
	/**
	 * @param releaseYear
	 * @return
	 */
	public List<Game> searchForGameByYear(int releaseYear) {
		EntityManager em = emfactory.createEntityManager(); 
	    em.getTransaction().begin(); 
	    TypedQuery<Game> typedQuery = em.createQuery("select gm from Game gm where gm.year = :selectedGame", Game.class); 
	    typedQuery.setParameter("selectedGame", releaseYear); 
	 
	    List<Game> foundGames = typedQuery.getResultList(); 
	    em.close(); 
	    return foundGames;
	}
	
	public void cleanUp(){ 
	    emfactory.close(); 
	}
}
