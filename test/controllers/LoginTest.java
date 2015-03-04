package controllers;

import org.junit.*;




import com.google.common.collect.ImmutableMap;

import play.mvc.*;
import play.test.WithApplication;
import static org.junit.Assert.*;
import static play.test.Helpers.*;
import models.*;

public class LoginTest extends WithApplication {
	
	@Before
	public void setUp() {
		fakeApplication(inMemoryDatabase(), fakeGlobal()); //lažna verzija naše aplikacije
		User.createUser("test@email.com", "1234567");
	}
	
	@Test
	public void authenticateSuccess() {
		Result result = callAction(
				controllers.routes.ref.Application.signin(),
				fakeRequest().withFormUrlEncodedBody(
						ImmutableMap.of("email", "test@email.com", "password", "1234567")));
		assertEquals(303, status(result));
		assertEquals("1", session(result).get("user_id"));
				
	}
	
	@Test
	public void authenticateFail() {
		Result result = callAction(
				controllers.routes.ref.Application.signin(),
				fakeRequest().withFormUrlEncodedBody(
						ImmutableMap.of("email", "test@email.com", "password", "1234567")));
		assertEquals(200, status(result));
		assertEquals("1", session(result).get("user_id"));
				
	}

}
