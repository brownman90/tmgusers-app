package org.green.code.tmgusers.restful.client;

import org.green.code.tmgusers.domain.User;
import org.green.code.tmgusers.domain.Users;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 * The Class RestfulClientSample.
 * 
 * @author mattia.mascia
 */
public class RestfulClientSample {

	/** The Constant URL_GET_ALL_USERS. */

	private static final String URL_GET_ALL_USERS = "http://localhost:8080/tmgusers/api/user/list";

	/** The Constant URL_GET_UP_DEL_USER_BY_ID. */
	private static final String URL_GET_DEL_USER_BY_ID = "http://localhost:8080/tmgusers/api/user?id={id}";

	/** The Constant URL_CREATE_USER. */
	private static final String URL_CREATE_USER_UP = "http://localhost:8080/tmgusers/api/user";

	private GenericXmlApplicationContext ctx;
	private RestTemplate restTemplate;

	public RestfulClientSample() {
		this.ctx = new GenericXmlApplicationContext();
		this.ctx.load("classpath:restful-client-context.xml");
		this.ctx.refresh();
		this.restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
	}

	public void closeContext() {
		this.ctx.close();
	}

	public Users list() {
		return restTemplate.getForObject(URL_GET_ALL_USERS, Users.class);
	}

	public User get(String id) {
		return restTemplate
				.getForObject(URL_GET_DEL_USER_BY_ID, User.class, id);
	}

	public void update(User user) {
		restTemplate.put(URL_CREATE_USER_UP, user);
	}

	public void delete(String id) {
		restTemplate.delete(URL_GET_DEL_USER_BY_ID, id);
	}

	public User create(User user) {
		return restTemplate.postForObject(URL_CREATE_USER_UP, user, User.class);
	}

}
