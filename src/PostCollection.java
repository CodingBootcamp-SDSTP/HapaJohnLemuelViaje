import java.util.ArrayList;

public class PostCollection
{
	public static PostCollection _instance = null;

	public static PostCollection instance() {
		if(_instance == null) {
			_instance = new PostCollection();
		}
		return(_instance);
	}

	private ArrayList<Posts> posts;

	private PostCollection() {
		posts = new ArrayList<Posts>();
	}

	public void addPost(Posts post) {
		posts.add(post);
	}

	public void removePost(Posts post) {
		posts.add(post);
	}

	public Posts getPostByIndex(int n) {
		return(posts.get(n));
	}

	public int getPostCount() {
		return(posts.size());
	}

	public ArrayList<Posts> getAllPosts() {
		return(posts);
	}
}
