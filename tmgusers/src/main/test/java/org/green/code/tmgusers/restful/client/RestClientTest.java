package org.green.code.tmgusers.restful.client;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.green.code.tmgusers.domain.User;
import org.green.code.tmgusers.domain.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class RestClientTest.
 */
public class RestClientTest {

	/** The client. */
	private static RestfulClientSample client;

	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		client = new RestfulClientSample();
	}

	/**
	 * Close.
	 */
	@AfterClass
	public static void close() {
		client.closeContext();
	}

	/**
	 * Test delete.
	 */
	@Test
	public void testDelete() {
		client.delete("3");
	}

	/**
	 * Test put.
	 */
	@Test
	public void testPut() {
		User user = client.get("1");

		user.setName("MattiaUpdate");

		client.update(user);

		user = client.get("1");
		assertNotNull(user);
	}

	/**
	 * Test create.
	 */
	@Test
	public void testCreate() {
		User user = new User();
		user.setName("Test Rest");
		user.setDateOfBirthMills(System.currentTimeMillis());

		user = client.create(user);

		assertNotNull(user);
	}

	/**
	 * Test get.
	 */
	@Test
	public void testGet() {
		User user = client.get("2");

		System.out.println(user);

		assertNotNull(user);
	}

	/**
	 * Test get list.
	 */
	@Test
	public void testGetList() {
		Users users = client.list();
		System.out.println(Arrays.toString(users.getList().toArray()));
		assertNotNull(users);
	}
}
