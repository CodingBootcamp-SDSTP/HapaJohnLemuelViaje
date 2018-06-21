import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;

public class AddUsersServlet extends HttpServlet
{
	ViajeDatabase vdb;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String query = br.readLine();
		String[] column = query.split("&");
		String[] fname = column[0].split("=");
		String[] lname = column[1].split("=");
		String[] email = column[2].split("=");
		String[] uname = column[3].split("=");
		String[] pass = column[4].split("=");
		String[] d = {fname[1], lname[1], email[1], "default.png", "0", "0", "1", uname[1], pass[1], "0"};
		if(vdb.checkAccount(uname[1])) {
			out.write("Account already been taken");
		}
		else {
			if(vdb.registerAccount(d)) {
				if(vdb.getUserByUsernameFromSql(uname[1])) {
					out.write("Successfully Registered");
				}
			}
			else {
				out.write("Registration Failed");
			}
		}
	}

	public void destroy() {
		vdb = null;
	}
}
