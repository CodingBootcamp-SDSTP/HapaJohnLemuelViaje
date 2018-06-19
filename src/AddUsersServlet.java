import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;

public class AddUsersServlet extends HttpServlet
{
	ViajeDatabase vdb;
	UserCollection uc;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		uc = UserCollection.instance();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		String query = request.getQueryString();
		String[] column = query.split("&");
		String[] fname = column[0].split("=");
		String[] lname = column[1].split("=");
		String[] email = column[2].split("=");
		String[] uname = column[3].split("=");
		String[] pass = column[4].split("=");
		String datetime = LocalDate.now().toString();
		String[] d = {fname[1], lname[1], email[1], "default.png", "0", "0", "1", uname[1], pass[1], datetime};
		if(vdb.registerAccount(d)) {
			out.write("Successfully Registered");
		}
		else {
			out.write("Registration Failed");
		}
	}

	public void destroy() {
		vdb = null;
		uc = null;
	}
}
