import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OtherProfileHeaderServlet extends HttpServlet
{
	ViajeDatabase vdb;
	UserCollection uc;
	FollowingCollection fwc;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		uc = UserCollection.instance();
		fwc = FollowingCollection.instance();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		StringBuilder bf = new StringBuilder("");
		String query = request.getQueryString();
		String[] column = query.split("&");
		String[] name = column[0].split("=");
		String[] userid = column[1].split("=");
		int uid = uc.getUserID(name[1]);
		String relation = "notok";
		if(uid == Integer.parseInt(userid[1])) {
			relation = "me";
		}
		for(int i=0; i<uc.getUserCount(); i++) {
			Users user = uc.getUserByIndex(i);
			if(name[1].equals(user.getUsername())) {
				if("notok".equals(relation)) {
					for(int j=0; j<fwc.getFollowingCount(); j++) {
						Following fll = fwc.getFollowingByIndex(i);
						if(Integer.parseInt(userid[1]) == fll.getUserId()) {
							if(uid == fll.getFollowingId()) {
								relation = "ok";
							}
						}
					}
				}
				bf.append("{\"image\" : \"" + user.getImage() + "\", \"fullname\" : \"" + user.getFirstname() + " " + user.getLastname() + "\", \"username\" : \"" + user.getUsername() + "\", \"followers\" : \"" + user.getFollowers() + "\", \"following\" : \"" + user.getFollowing() + "\", \"relation\" : \"" + relation + "\", \"uid\" : \"" + user.getID() + "\"}");
			}
		}
		out.write(bf.toString());
	}

	public void destroy() {
		vdb = null;
		uc = null;
		fwc = null;
	}
}
