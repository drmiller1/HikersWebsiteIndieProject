package edu.matc.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The type Add hiker display servlet.
 *
 * @author Dan Miller
 */
@WebServlet(
        name = "AddHikerDisplayServlet",
        urlPatterns = { "/addHikerDisplay-servlet" }
)

/**
 * class AddHikerDisplayServlet
 * This class is used to call the addHiker jsp.
 *
 * @author Dan Miller
 */
public class AddHikerDisplayServlet extends HttpServlet {

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


        String url = "/addHiker.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
