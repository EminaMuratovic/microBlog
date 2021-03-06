package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

public class Post extends Model {

	@Id
	public long id;
	
	@MinLength(2)
	@MaxLength(144)
	public String content;
	
	@ManyToOne
	public User author;
	
	public Post(String content, User author) {
		this.content = content;
		this.author = author;
	}
	
	public static void create(String content, User author) {
		new Post(content, author).save();
	}
}
