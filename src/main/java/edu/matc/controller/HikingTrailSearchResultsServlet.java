package edu.matc.controller;

import edu.matc.entity.HikingTrail;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The type Hiking trail search results servlet.
 *
 * @author Dan Miller
 */
@WebServlet(
        name = "trailSearchResultsServlet",
        urlPatterns = { "/trailSearchResults-servlet" }
)

/**
 * class HikingTrailSearchResultsServlet
 * This class is used to retrieve the Hiking Trail fields corresponding to the entered search text.
 *
 * @author Dan Miller
 */

public class HikingTrailSearchResultsServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao hikingTrailDao = new GenericDao(HikingTrail.class);
        List<HikingTrail> hikingTrails = new ArrayList<>();


        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        if (searchTerm == null || searchTerm.isEmpty()) {
            logger.debug("Empty Search Term1 - " + searchType + " " + searchTerm + " " + hikingTrails);
            //GenericDao hikingTrailDao = new GenericDao(HikingTrail.class);
            //List<HikingTrail> hikingTrailList = hikingTrailDao.getAll();
            hikingTrails = (List<HikingTrail>)hikingTrailDao.getAll();
            logger.debug("Empty Search Term2 - " + searchType + " " + searchTerm + " " + hikingTrails);
            request.setAttribute("hikingTrailList", hikingTrails);
            logger.debug("Empty Search Term3 - " + searchType + " " + searchTerm + " " + hikingTrails);
        } else {
            request.setAttribute("emptyTerm", null);

            //GenericDao hikingTrailDao = new GenericDao(HikingTrail.class);

            //List<HikingTrail> hikingTrailList = hikingTrailDao.getByPropertyLike(searchType, searchTerm);

            //session.setAttribute("hikingTrailList", hikingTrailList);
            hikingTrails = hikingTrailDao.getByPropertyLike(searchType, searchTerm);
            request.setAttribute("hikingTrailList", hikingTrails);
            logger.debug(" Search Term Found - "+ request.getAttribute("hikingTrailList"));
            //logger.debug("Made it this far 4 - " + hikingTrailList.toString());
            //String url = "/hikingTrailSearchResults.jsp";
            //logger.debug("Made it this far 5 - ");

            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            //logger.debug("Made it this far 6 - ");
            //dispatcher.forward(request, response);
        }

        String url = "/hikingTrailSearchResults.jsp";

        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        logger.debug("Forwarding search request and response");
        dispatcher.forward(request, response);
    }
}
