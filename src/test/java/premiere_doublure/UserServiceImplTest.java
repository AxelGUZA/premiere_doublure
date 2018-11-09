package premiere_doublure;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class UserServiceImplTest {

	
	@Test
	public void Should_create_user_with_hashed_password() {
		
		HashProvider hashProvider = mock(HashProvider.class);
		when(hashProvider.hash("secret")).thenReturn("secret");
		
		UserService userService = new UserServiceImpl(hashProvider);
     	
		User user = userService.createUser("Bob", "secret");

 		assertEquals(user.firstName(), "Bob"); 
 		assertEquals(user.hashedPassword(), "secret"); 
	}
}
