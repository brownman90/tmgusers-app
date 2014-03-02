/**
 * 
 */
package org.green.code.tmgusers.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.green.code.tmgusers.domain.User;
import org.green.code.tmgusers.service.TmgUsersService;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mattia.mascia
 * 
 */

public class TmgUsersServiceTest extends AbstractServiceTest {

	private final List<User> users = new ArrayList<User>();

//	@Autowired use real service
	private TmgUsersService tmgUsersService;
	
	

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		User user = new User();
		user.setName("JUnit");
		user.setDateOfBirthMills(System.currentTimeMillis());

		users.add(user);
	}

	@Test
	public void testList() throws Exception {

		tmgUsersService = mock(TmgUsersService.class); //mock
		when(tmgUsersService.list()).thenReturn(users);

		assertEquals(1, users.size());
	}

}
