package org.green.code.tmgusers.service;

import java.math.BigDecimal;
import java.util.List;

import org.green.code.service.Service;
import org.green.code.tmgusers.domain.User;
import org.springframework.util.StringUtils;

/**
 * The Interface TmgUsersService.
 */
public interface TmgUsersService extends Service {

	/** The Constant BEAN. */
	public static final String BEAN = StringUtils
			.uncapitalize(TmgUsersService.class.getSimpleName());

	/**
	 * List.
	 * 
	 * @return the list
	 */
	public List<User> list();

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the user
	 */
	public User findById(BigDecimal id);

	/**
	 * Save.
	 * 
	 * @param user
	 *            the user
	 */
	public void save(User user);

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 */
	public void delete(User user);

}
