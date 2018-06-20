import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import redis.clients.jedis.Jedis;

public class LoginServlet extends HttpServlet
{
	ViajeDatabase vdb;
	UserCollection uc;
	Jedis jedis;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		uc = UserCollection.instance();
		jedis = new Jedis("localhost");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		String query = request.getQueryString();
		String[] column = query.split("&");
		String[] uname = column[0].split("=");
		String[] upass = column[1].split("=");
		if(vdb.login(uname[1], upass[1])) {
			int id = 0;
			for(int i=0; i<uc.getUserCount(); i++) {
				Users user = uc.getUserByIndex(i);
				if(uname[1].equals(user.getUsername())) {
					id = user.getID();
				}
			}
			out.write("{\"reply\" : \"" + startSession(uname[1]) + "\", \"userid\" : \"" + String.valueOf(id) + "\"}");
		}
		else {
			out.write("{\"reply\" : \"failed\"}");
		}
	}

	public String startSession(String uname) {
		int val = new java.util.Random().nextInt();
		String hex = Integer.toHexString(val);
		jedis.set(hex, uname);
		return(hex);
	}

	public void destroy() {
		vdb = null;
		uc = null;
	}
}
