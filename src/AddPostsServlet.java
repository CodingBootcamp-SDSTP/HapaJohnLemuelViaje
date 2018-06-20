import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddPostsServlet extends HttpServlet
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
		String[] lid = column[1].split("=");
		String[] address = column[2].split("=");
		String[] image = column[3].split("=");
		String[] caption = column[4].split("=");
		String[] d = {uid[1], lid[1], address[1], image[1], caption[1], "1", "0", "0"};
		if(vdb.addPost(d)) {
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
