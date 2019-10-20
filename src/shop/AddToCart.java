package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart")
public class AddToCart extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String bookISBN = request.getParameter("isbn");
        ShoppingCart cart = User.getCustomer().getCart();
        Book book = Persistence.getBook(bookISBN);


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Added to cart</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='../style.css'/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        if (book == null) {
            out.println("Sorry the book is not available anymore!");
            response.sendRedirect("books");
        } else {
            cart.addBook(book);
            out.println("Book was added successfully!");
            book.setCopies(book.getCopies() - 1);
        }
        out.println("</div>");
        out.println("<div class='container'>");
        out.print("<form action=\"cart/view\" method=\"post\">");
        out.print("<button types\"submit\" names\"isbn\" values\"" + bookISBN +
                  "\" class=\"btn btn-default\">Checkout</button>");
        out.print("</form>");
        out.println("</div>");
        out.println("<a href=\"books\">back to book List</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
