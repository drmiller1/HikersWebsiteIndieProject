package edu.matc.controller;

import edu.matc.entity.HikingTrail;
import edu.matc.entity.HikerAccount;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Add hiking trail servlet.
 *
 * @author Dan Miller
 */
@WebServlet(
        name = "addHikingTrailServlet",
        urlPatterns = { "/addHikingTrail-servlet" }
)

/**
 * class AddHikingTrailServlet
 * This class is used to populate and validate the hiking trail fields.
 *
 * @author Dan Miller
 */

public class AddHikingTrailServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean trailHeadNameValid = false;
        boolean trailHeadLocationValid = false;

        HttpSession session = request.getSession();

        String emailAddress = request.getParameter ("emailAddress");
        String trailHeadName = request.getParameter("trailHeadName");
        String trailHeadLocation = request.getParameter("trailHeadLocation");
        String trailLength = request.getParameter("trailLength");
        String trailDifficulty = request.getParameter("trailDifficulty");
        String trailRating = request.getParameter("trailRating");
        String trailFeatures = request.getParameter("trailFeatures");
        String trailDetails = request.getParameter("traildetails");
        String trailDescription = request.getParameter("trailDescription");

        trailHeadNameValid = validateFormField(trailHeadName);
        if (!trailHeadNameValid) {
            session.setAttribute("emptyTrailHeadName", "Please enter a valid trailhead name.");
            session.setAttribute("tabName", "tab2");
        } else {
            session.setAttribute("emptyTrailHeadName", null);
        }

        trailHeadLocationValid = validateFormField(trailHeadLocation);
        if (!trailHeadLocationValid) {
            session.setAttribute("emptyTrailHeadLocation", "Please enter a valid trailhead location.");
        } else {
            session.setAttribute("emptyTrailHeadLocation", null);
        }

        session.setAttribute("emptyTrailLength", null);
        session.setAttribute("emptyTrailDifficulty", null);
        session.setAttribute("emptyTrailRating", null);
        session.setAttribute("emptyTrailFeatures", null);
        session.setAttribute("emptyTrailDetails", null);
        session.setAttribute("emptyTrailDescription", null);
        session.setAttribute("queryResultMessage", null);

        if (trailHeadNameValid && trailHeadLocationValid) {

            GenericDao hikerAccountDAO = new GenericDao(HikerAccount.class);
            GenericDao hikingTrailDAO = new GenericDao(HikingTrail.class);

            List<HikerAccount> hikerAccountList = hikerAccountDAO.getByPropertyEqual("emailAddress", emailAddress);

            HikingTrail hikingTrail = new HikingTrail(trailHeadName, trailHeadLocation, Integer.valueOf(trailLength), Integer.valueOf(trailDifficulty), Integer.valueOf(trailRating), trailFeatures, trailDetails, trailDescription, hikerAccountList.get(0));
            hikerAccountList.get(0).addHikingTrail(hikingTrail);
            int id = hikingTrailDAO.insert(hikingTrail);

            /*HikingTrail insertedHikingTrail = (HikingTrail) hikingTrailDAO.getById(id);*/

            session.setAttribute("queryResultMessage", "NEW HIKING TRAIL INSERTED SUCCESSFULLY");

            session.setAttribute("trailHeadName", null);
            session.setAttribute("trailHeadLocation", null);
            session.setAttribute("trailLength", null);
            session.setAttribute("trailDifficulty", null);
            session.setAttribute("trailRating", null);
            session.setAttribute("trailFeatures", null);
            session.setAttribute("trailDetails", null);
            session.setAttribute("trailDescription", null);

        } else {
            session.setAttribute("trailHeadName", trailHeadName);
            session.setAttribute("trailHeadLocation", trailHeadLocation);
            session.setAttribute("trailLength", trailLength);
            session.setAttribute("trailDifficulty", trailDifficulty);
            session.setAttribute("trailRating", trailRating);
            session.setAttribute("trailFeatures", trailFeatures);
            session.setAttribute("trailDetails", trailDetails);
            session.setAttribute("trailDesctiption", trailDescription);
        }

        String url = "addHikingTrailDisplay-servlet";
        response.sendRedirect(url);
        return;
    }

    /**
     * This method is used to validate that something has been entered in
     * the form field.
     * @param fieldValue the entered value to validate
     * @return the boolean for fieldValueValid
     */
    private boolean validateFormField(String fieldValue) {

        boolean fieldValueValid;

        if (fieldValue == null || fieldValue.isEmpty()) {
            fieldValueValid = false;
        } else {
            fieldValueValid = true;
        }

        return fieldValueValid;
    }

}
