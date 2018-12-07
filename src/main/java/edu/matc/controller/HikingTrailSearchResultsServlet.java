package edu.matc.controller;

import edu.matc.entity.HikerAccount;
import edu.matc.entity.HikingTrail;
import edu.matc.persistence.GenericDao;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author Dan Miller
 *
 */

@WebServlet(
        name = "trailSearchResultsServlet",
        urlPatterns = { "/trailSearchResults-servlet" }
)

public class HikingTrailSearchResultsServlet extends HttpServlet {

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

        GenericDao genericDAO = new GenericDao(HikingTrail.class);

        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        if (searchTerm == null || searchTerm.isEmpty()) {
            session.setAttribute("emptyTerm", "Please enter a Search Term.");

            String url = "/java112/searchdisplay-servlet";
            response.sendRedirect(url);
            return;

        } else {
            session.setAttribute("emptyTerm", null);

            GenericDao hikingTrailDAO = new GenericDao(HikingTrail.class);

            List<HikingTrail> hikingTrailList = hikingTrailDAO.getByPropertyLike(searchType, searchTerm);
            session.setAttribute("hikingTrailList", hikingTrailList);

            String url = "/hikingTrailSearchResults.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
}
