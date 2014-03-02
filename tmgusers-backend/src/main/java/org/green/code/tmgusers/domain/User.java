/**
 * 
 */
package org.green.code.tmgusers.domain;

import java.math.BigDecimal;

import org.green.code.model.Model;


/**
 * The Class User.
 * 
 * @author mattia.mascia
 */
public class User implements Model {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6590320245143610267L;

	/** The id. */
	private BigDecimal id;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirthMills="
				+ dateOfBirthMills + "]";
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/** The name. */
	private String name;

	/** The date of birth mills. */
	private long dateOfBirthMills;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the date of birth mills.
	 * 
	 * @return the date of birth mills
	 */
	public long getDateOfBirthMills() {
		return dateOfBirthMills;
	}

	/**
	 * Sets the date of birth mills.
	 * 
	 * @param dateOfBirthMills
	 *            the new date of birth mills
	 */
	public void setDateOfBirthMills(long dateOfBirthMills) {
		this.dateOfBirthMills = dateOfBirthMills;
	}

}
