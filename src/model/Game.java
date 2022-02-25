/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Bobby
 *
 */
@Entity
@Table(name="games")
public class Game {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="PUBLISHER")
	private String publisher;
	@JoinColumn(name="PLATFORM")
	@ManyToOne
	private Console platform;
	@Column(name="YEAR")
	private int year;
	/**
	 * 
	 */
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param title
	 * @param publisher
	 * @param platform
	 * @param year
	 */
	public Game(String title, String publisher, Console platform, int year) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.platform = platform;
		this.year = year;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the platform
	 */
	public Console getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(Console platform) {
		this.platform = platform;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	

	@Override
	public String toString() {
		return "Game [title=" + title + ", publisher=" + publisher + ", platform=" + platform.toString() + ", year=" + year + "]";
	}

	/**
	 * @return
	 */
	public String returnGameDetails() {
		// TODO Auto-generated method stub
		return title + " (" + year + ", " + platform + ") by " + publisher;
	}
	
	
}
