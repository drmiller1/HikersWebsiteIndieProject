package edu.matc.controller;

import edu.matc.entity.HikingTrail;
import edu.matc.entity.HikerAccount;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Dan Miller
 *
 */

@WebServlet(
        name = "addHikingTrailServlet",
        urlPatterns = { "/addHikingTrail-servlet" }
)

public class AddHikingTrailServlet extends HttpServlet {

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

        String queryResultMessage = null;

        GenericDao genericDAO = new GenericDao(HikingTrail.class);

        ServletContext context = getServletContext();
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

        if (trailHeadNameValid && trailHeadLocationValid) {

            GenericDao hikerAccountDAO = new GenericDao(HikerAccount.class);
            GenericDao hikingTrailDAO = new GenericDao(HikingTrail.class);

            List <HikerAccount> hikerAccountList = hikerAccountDAO.getByPropertyEqual("emailAddress", emailAddress);
            HikingTrail hikingTrail = new HikingTrail(trailHeadName, trailHeadLocation, Integer.parseInt(trailLength), Integer.parseInt(trailDifficulty), Integer.parseInt(trailRating), trailFeatures, trailDetails, trailDescription, hikerAccountList.get(0));
            hikerAccountList.get(0).addHikingTrail(hikingTrail);
            int id = genericDAO.insert(hikingTrail);

            HikingTrail insertedHikingTrail = (HikingTrail) genericDAO.getById(id);

            session.setAttribute("queryResultMessage", insertedHikingTrail);

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

        String url = "addHikingTrail-servlet";
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
