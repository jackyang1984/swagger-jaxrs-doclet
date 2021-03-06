package fixtures.issue30b;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.annotate.JsonView;

@Path("issue30b")
@Produces({ MediaType.APPLICATION_JSON })
@SuppressWarnings("javadoc")
public class IssueResource {

	@GET
	@JsonView(User.UserView.class)
	public User getUser() {
		User u = new User();
		u.name = "Name";
		u.comments = new ArrayList<Comment>(1);

		CommentThread t = new CommentThread();
		t.name = "Name";
		t.comments = new ArrayList<Comment>(1);

		Comment c = new Comment();
		c.text = "Text";
		// c.user = u;
		// c.commentThread = t;

		u.comments.add(c);
		t.comments.add(c);

		return u;
	}
}
