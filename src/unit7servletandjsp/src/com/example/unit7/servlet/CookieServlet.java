package com.example.unit7.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookieDemo")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create a new cookie
        Cookie userCookie = new Cookie("usernameCookie", "testUser");
        userCookie.setMaxAge(60 * 60 * 24); // Set cookie to expire in 24 hours
        response.addCookie(userCookie);

        // Create another cookie
        Cookie lastVisitCookie = new Cookie("lastVisit", new java.util.Date().toString().replace(" ", "_"));
        lastVisitCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
        response.addCookie(lastVisitCookie);

        out.println("<!DOCTYPE html>\n");
        out.println("<html>\n");
        out.println("<head><title>Cookie Demo</title></head>\n");
        out.println("<body>\n");
        out.println("<h2>Cookies Set!</h2>\n");
        out.println("<p>Two cookies have been set: 'usernameCookie' and 'lastVisit'.</p>\n");
        out.println("<p>You can view them in your browser's developer tools.</p>\n");

        out.println("<h3>Existing Cookies:</h3>\n");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<p><strong>Name:</strong> " + cookie.getName() + ", <strong>Value:</strong> " + cookie.getValue() + ", <strong>Max Age:</strong> " + cookie.getMaxAge() + "</p>\n");
            }
        } else {
            out.println("<p>No cookies found.</p>\n");
        }
        out.println("<br><a href=\"index.jsp\">Go to Home</a>");
        out.println("</body>\n");
        out.println("</html>\n");
    }
}
