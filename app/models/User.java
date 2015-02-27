package models;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import helpers.*;

@Entity
public class User extends Model{
	
	@Id
	public long id;
	
	@Email
	public String email;
	
	@MinLength(6)
	public String password;
	
	static Finder<Long, User> find = new Finder<Long, User>(long.class, User.class);
	
	public User() {
		this.email = null;
		this.password = null;
		this.id = -1;
		
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = HashHelper.createPassword(password);
		
	}
	
	public static long createUser(String email, String password) {
		User newUser = new User(email, password);
		newUser.save();
		return newUser.id;
		
	}
	
	public static User find(long id) {
		return find.byId(id);
	}

}
