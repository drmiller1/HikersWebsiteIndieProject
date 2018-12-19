package edu.matc.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author Dan Miller
 *
 */

@WebServlet(
        name = "HikingTrailSearchDisplayServlet",
        urlPatterns = { "/trailSearchDisplay-servlet" }
)

/**
 * class HIkingTrailSearchDisplayServlet
 * This class is used to call the hikingTrailSearch jsp.
 *
 * @author Dan Miller
 */

public class HikingTrailSearchDisplayServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = "/hikingTrailSearch.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}