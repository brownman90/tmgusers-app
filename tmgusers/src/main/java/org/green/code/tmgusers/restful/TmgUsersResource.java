/**
 * 
 */
package org.green.code.tmgusers.restful;

import java.math.BigDecimal;

import org.green.code.tmgusers.domain.User;
import org.green.code.tmgusers.domain.Users;
import org.green.code.tmgusers.service.TmgUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The Class TmgUsersResource.
 * RESTful service for performing CRUD operation with User
 * The content-type consumes and produces are application/json
 * 
 * @author mattia.mascia
 */
@Controller
@RequestMapping(value = "/user")
public class TmgUsersResource {

	/** The tmg users service. */
	@Autowired
	private transient TmgUsersService tmgUsersService;

	/**
	 * Return the Users object with the list of user.
	 *
	 * @return the users
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Users list() {
		return new Users(tmgUsersService.list());
	}

	/**
	 * Find User by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User findUserById(@RequestParam BigDecimal id) {
		return tmgUsersService.findById(id);
	}

	/**
	 * Create a new User.
	 *
	 * @param user the user
	 * @return the user
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User create(@RequestBody User user) {
		tmgUsersService.save(user);
		return user;
	}

	/**
	 * Update a existing User
	 *
	 * @param user the user
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody User user) {
		tmgUsersService.save(user);
	}

	/**
	 * Delete a existing User by id
	 *
	 * @param id the id
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestParam BigDecimal id) {
		User user = tmgUsersService.findById(id);
		tmgUsersService.delete(user);

	}

}

