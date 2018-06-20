import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddUpServlet extends HttpServlet
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
		String[] pid = column[0].split("=");
		String[] uid = column[1].split("=");
		LocalTime lt = LocalTime.now();
		String date = LocalDate.now().toString() + " " + lt.getHour() + ":" + lt.getMinute() + ":" + lt.getSecond();
		String[] d = {pid[1], uid[1], date, "1"};
		if(vdb.addUp(d)) {
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
