import models.User;
import play.GlobalSettings;
import play.Application;


public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		User.createUser("test@email.com", "1234567");
		
		
	}
}
