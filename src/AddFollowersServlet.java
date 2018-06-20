import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddFollowersServlet extends HttpServlet
{
	ViajeDatabase vdb;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		String query = request.getQueryString();
		String[] column = query.split("&");
		String[] uid = column[0].split("=");
		String[] fid = column[1].split("=");
		LocalTime lt = LocalTime.now();
		String date = LocalDate.now().toString() + " " + lt.getHour() + ":" + lt.getMinute() + ":" + lt.getSecond();
		String[] d = {uid[1], date, "1", fid[1]};
		if(vdb.addFollowingAndFollowers("follower", d)) {
			out.write("Successfully Added");
		}
		else {
			out.write("Insertion Failed");
		}
	}

	public void destroy() {
		vdb = null;
	}
}
