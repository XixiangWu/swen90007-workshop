package authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XMLServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public XMLServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("Hello from GET method");
        PrintWriter writer = response.getWriter();
        writer.println("<h3> Hello in html XML Servlet </h3>");
    }
}
