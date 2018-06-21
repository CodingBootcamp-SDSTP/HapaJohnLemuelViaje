import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OtherProfilePostsServlet extends HttpServlet
{
	ViajeDatabase vdb;
	UserCollection uc;
	PostCollection pc;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		uc = UserCollection.instance();
		pc = PostCollection.instance();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		StringBuilder bf = new StringBuilder("");
		String query = request.getQueryString();
		String[] name = query.split("=");
		int uid = uc.getUserID(name[1]);
		bf.append("[");
		for(int i=0; i<pc.getPostCount(); i++) {
			Posts p = pc.getPostByIndex(i);
			if(uid == p.getUserId()) {
				bf.append("{\"image\" : \"" + p.getImage() + "\"}");
			}
			if(i != pc.getPostCount()-1) {
				bf.append(",");
			}
		}
		bf.append("]");
		out.write(bf.toString());
	}

	public void destroy() {
		vdb = null;
		uc = null;
		pc = null;
	}
}
