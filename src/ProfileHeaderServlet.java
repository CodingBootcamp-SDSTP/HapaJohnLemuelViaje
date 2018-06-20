import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProfileHeaderServlet extends HttpServlet
{
	ViajeDatabase vdb;
	UserCollection uc;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		uc = UserCollection.instance();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		StringBuilder bf = new StringBuilder("");
		String query = request.getQueryString();
		String[] userid = query.split("=");
		for(int i=0; i<uc.getUserCount(); i++) {
			Users user = uc.getUserByIndex(i);
			if(Integer.parseInt(userid[1]) == user.getID()) {
				bf.append("{\"image\" : \"" + user.getImage() + "\", \"fullname\" : \"" + user.getFirstname() + " " + user.getLastname() + "\", \"username\" : \"" + user.getUsername() + "\", \"followers\" : \"" + user.getFollowers() + "\", \"following\" : \"" + user.getFollowing() + "\"}");
			}
		}
		out.write(bf.toString());
	}

	public void destroy() {
		vdb = null;
		uc = null;
	}
}
