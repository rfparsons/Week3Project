/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bobby
 *
 */

@Entity
@Table(name="console")
public class Console {
	@Id
	@GeneratedValue
	private int id;
	private String consoleName;
	/**
	 * 
	 */
	public Console() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param consoleName
	 */
	public Console(int id, String consoleName) {
		super();
		this.id = id;
		this.consoleName = consoleName;
	}
	/**
	 * @param consoleName
	 */
	public Console(String consoleName) {
		super();
		this.consoleName = consoleName;
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
	 * @return the consoleName
	 */
	public String getConsoleName() {
		return consoleName;
	}
	/**
	 * @param consoleName the consoleName to set
	 */
	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}
	@Override
	public String toString() {
		return "Console [id=" + id + ", consoleName=" + consoleName + "]";
	}
	
	
}
