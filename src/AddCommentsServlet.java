import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCommentsServlet extends HttpServlet
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
		String[] comment = column[2].split("=");
		String[] d = {pid[1], uid[1], comment[1], "1"};
		if(vdb.addComment(d)) {
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
