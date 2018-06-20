import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProfilePostsServlet extends HttpServlet
{
	ViajeDatabase vdb;
	PostCollection pc;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		pc = PostCollection.instance();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		StringBuilder bf = new StringBuilder("");
		String query = request.getQueryString();
		String[] userid = query.split("=");
		bf.append("[");
		for(int i=0; i<pc.getPostCount(); i++) {
			Posts p = pc.getPostByIndex(i);
			if(Integer.parseInt(userid[1]) == p.getUserId()) {
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
		pc = null;
	}
}
