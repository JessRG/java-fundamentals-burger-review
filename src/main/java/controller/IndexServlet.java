package controller;

import model.Burger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="IndexServlet", urlPatterns = "/home")
public class IndexServlet extends HttpServlet {
    // we want to display our 'home page' using this servlet, when someone loads
    // 'http://localhost:8080/'

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // this is where we want to tell the Tomcat server to display the webapp/index.jsp
        // template file (as a webpage)

        // The BORING way
//        res.setContentType("text/html");

//        res.getWriter().println("<h1>Welcome to Burger 'R Us!</h1>");
        // END: The BORING way

        // Let's make some burgers, add them all to a list, and send them to index.jsp for looping
        // through
        Burger bigMac = new Burger("Big Mac", 3, 7, 2, true);
        Burger homeStyle =  new Burger("Homestyle", 2, 3, 1, false);
        Burger quarterPounder = new Burger("Quarter Pounder", 2, 3, 1, true);

        // Add all the burgers to a list
        List<Burger> allBurgers = new ArrayList<>();
        allBurgers.add(bigMac);
        allBurgers.add(homeStyle);
        allBurgers.add(quarterPounder);

        // Send that list to our JSP page, as a parameter
        // Name in "quotes" is the variable name we'll use in our JSP,
        // and the second argument is the actual value we are sending to JSP
        req.setAttribute("completeBurgerList", allBurgers);
        req.setAttribute("truthiness", false);

        // The FUN way!!
        // we want to load the index.jsp template, when this Servlet is called upon
        req.getRequestDispatcher("/index.jsp").forward(req, res);
        // END: The FUN way!!
    }
}
