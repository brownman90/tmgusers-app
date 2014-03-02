/**
 * 
 */
package org.green.code.tmgusers.service;

import java.math.BigDecimal;
import java.util.List;

import org.green.code.tmgusers.domain.User;
import org.green.code.tmgusers.persistence.TmgUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class TmgUsersService.
 * 
 * @author mattia.mascia
 */
@org.springframework.stereotype.Service("tmgUsersService")
@Transactional
@Repository
public class TmgUsersServiceImpl implements TmgUsersService {

	/** The user case mapper. */
	@Autowired
	private transient TmgUsersMapper tmgUsersMapper;

	/**
	 * List.
	 * 
	 * @return the list
	 */
	@Transactional(readOnly = true)
	public List<User> list() {
		return tmgUsersMapper.selectAll();
	}

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the user
	 */
	@Transactional(readOnly = true)
	public User findById(BigDecimal id) {
		return tmgUsersMapper.selectById(id);
	}

	/**
	 * Save.
	 * 
	 * @param user
	 *            the user
	 */
	@Transactional
	public void save(User user) {
		if (user.getId() == null) {
			insert(user);
		} else {
			update(user);
		}

	}

	/**
	 * Update.
	 * 
	 * @param user
	 *            the user
	 */
	@Transactional
	private void update(User user) {
		tmgUsersMapper.update(user);
	}

	/**
	 * Insert.
	 * 
	 * @param user
	 *            the user
	 */
	@Transactional
	private void insert(User user) {
		tmgUsersMapper.insert(user);
	}

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 */
	@Transactional
	public void delete(User user) {
		BigDecimal id = user.getId();
		tmgUsersMapper.delete(id);
	}

}
