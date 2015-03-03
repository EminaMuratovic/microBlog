package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import models.*;
import play.data.Form;

public class PostController extends Controller {

	public static Result create() {
		Form<Post> postForm = new Form<Post>(Post.class).bindFromRequest();
		if(postForm.hasErrors())
			return ok(showUser.render(Session.getCurrentUser(ctx()), postForm));
		Post newPost = postForm.get();
		Post.create(newPost.content, Session.getCurrentUser(ctx()));
		return redirect("/user/" + Session.getCurrentUser(ctx()).id);
	}
}
