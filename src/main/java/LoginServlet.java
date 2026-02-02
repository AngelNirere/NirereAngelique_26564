import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        
        if (password.length() < 8) {
            out.println("Hello " + username + ", your password is weak. Try a strong one.");
        } else {
            out.println("Welcome " + username);
        }
    }
}