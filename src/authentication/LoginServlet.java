package authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usernameI = getServletConfig().getInitParameter("usernameI");
        String passwordI = getServletConfig().getInitParameter("passwordI");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        System.out.println("Hello from POST method");

        PrintWriter writer = response.getWriter();

        if (username.equals(usernameI) && password.equals(passwordI)) {
            response.sendRedirect("success.jsp");
            writer.println("<h3> Admin Username: [" +
                    username +
                    "] Password: [" +
                    password +
                    "]. </h3>");
        } else {
            writer.println("<h3> Hello from POST Username: [" +
                    username +
                    "] Password: [" +
                    password +
                    "]. </h3>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        System.out.println("Hello from GET method");
        PrintWriter writer = response.getWriter();
        writer.println("<h3> Hello from Get Username: [" +
                        username +
                        "] Password: [" +
                        password +
                        "]. </h3>");
    }
}
