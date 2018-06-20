import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import redis.clients.jedis.Jedis;

public class CheckSessionExistenceServlet extends HttpServlet
{
	Jedis jedis;

	public void init() throws ServletException {
		jedis = new Jedis("localhost");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		String query = request.getQueryString();
		String[] column = query.split("=");
		if(doesSessionExist(column[1])) {
			out.write("notzero");
		}
		else {
			out.write("zero");
		}
	}

	public boolean doesSessionExist(String key) {
		return(jedis.exists(key));
	}

	public void destroy() {
		jedis = null;
	}
}
