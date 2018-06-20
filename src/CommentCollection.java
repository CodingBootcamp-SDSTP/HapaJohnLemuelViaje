import java.util.ArrayList;

public class CommentCollection
{
	public static CommentCollection _instance = null;

	public static CommentCollection instance() {
		if(_instance == null) {
			_instance = new CommentCollection();
		}
		return(_instance);
	}

	private ArrayList<Comments> comments;

	private CommentCollection() {
		comments = new ArrayList<Comments>();
	}

	public void addComment(Comments comment) {
		comments.add(comment);
	}

	public void removeComment(Comments comment) {
		comments.remove(comment);
	}

	public Comments getCommentByIndex(int n) {
		return(comments.get(n));
	}

	public int getCommentCount() {
		return(comments.size());
	}

	public ArrayList<Comments> getAllComments() {
		return(comments);
	}
}
