import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.BufferedReader;

public class AddFollowingServlet extends HttpServlet
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
		String[] uid = column[0].split("=");
		String[] fid = column[1].split("=");
		LocalTime lt = LocalTime.now();
		String date = LocalDate.now().toString() + " " + lt.getHour() + ":" + lt.getMinute() + ":" + lt.getSecond();
		String[] d = {uid[1], date, "1", fid[1]};
		if(vdb.addFollowingAndFollowers("following", d)) {
			if(vdb.addFollowingAndFollowerCount("following", Integer.parseInt(uid[1]))) {
				out.write("ok");
			}
		}
		else {
			out.write("failed");
		}
	}

	public void destroy() {
		vdb = null;
	}
}
