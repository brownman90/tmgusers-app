/**
 * 
 */
package org.green.code.tmgusers.domain;

import java.util.List;

import org.green.code.model.Model;

/**
 * The Class Users.
 * 
 * @author mattia.mascia
 */
public class Users implements Model {

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5982578863714892916L;

	/** The users. */
	private List<User> list;

	/**
	 * Instantiates a new users.
	 * 
	 * @param users
	 *            the users
	 */
	public Users(List<User> list) {
		super();
		this.list = list;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

}
