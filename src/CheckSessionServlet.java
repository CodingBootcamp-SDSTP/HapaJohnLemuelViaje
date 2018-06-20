import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import redis.clients.jedis.Jedis;

public class CheckSessionServlet extends HttpServlet
{
	Jedis jedis;

	public void init() throws ServletException {
		jedis = new Jedis("localhost");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		if(checksessioncount() > 0) {
			out.write("notzero");
		}
		else {
			out.write("zero");
		}
	}

	public int checksessioncount() {
		int len = jedis.dbSize().intValue();
		return(len);
	}

	public void destroy() {
		jedis = null;
	}
}
