import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import redis.clients.jedis.Jedis;

public class EndSessionServlet extends HttpServlet
{
	Jedis jedis;

	public void init() throws ServletException {
		jedis = new Jedis("localhost");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		String query = request.getQueryString();
		String[] column = query.split("=");
		endSession(column[1]);
		out.write("{\"message\" : \"logout\"}");
	}

	public void endSession(String key) {
		jedis.del(key);
	}

	public void destroy() {
		jedis = null;
	}
}
