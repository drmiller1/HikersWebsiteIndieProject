package edu.matc.controller;

import edu.matc.entity.HikerAccount;
import edu.matc.entity.Role;
import edu.matc.persistence.GenericDao;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The type Add hiker servlet.
 *
 * @author Dan Miller
 */
@WebServlet(
        name = "addHikerServlet",
        urlPatterns = { "/addHiker-servlet" }
)

/**
 * class AddHikerServlet
 * This class is used to populate and validate the hiker account fields.
 *
 * @author Dan Miller
 */

public class AddHikerServlet extends HttpServlet {

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

        boolean firstNameValid = false;
        boolean lastNameValid = false;
        boolean cityValid = false;
        boolean stateValid = false;
        boolean emailAddressValid = false;
        boolean passwordValid = false;

        String queryResultMessage = null;

        GenericDao hikerAccountDao = new GenericDao(HikerAccount.class);
        GenericDao roleDao = new GenericDao(Role.class);

        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");

        String roleName = "user";

        firstNameValid = validateFormField(firstName);
        if (!firstNameValid) {
            session.setAttribute("emptyFirstName", "Please enter a valid first name.");
        } else {
            session.setAttribute("emptyFirstName", null);
        }

        lastNameValid = validateFormField(lastName);
        if (!lastNameValid) {
            session.setAttribute("emptyLastName", "Please enter a valid last name.");
        } else {
            session.setAttribute("emptyLastName", null);
        }

        cityValid = validateFormField(city);
        if (!cityValid) {
            session.setAttribute("emptyCity", "Please enter a valid city.");
        } else {
            session.setAttribute("emptyCity", null);
        }

        stateValid = validateFormField(state);
        if (!stateValid) {
            session.setAttribute("emptyState", "Please enter a valid state.");
        } else {
            session.setAttribute("emptyState", null);
        }

        emailAddressValid = validateFormField(emailAddress);
        if (!emailAddressValid) {
            session.setAttribute("emptyEmailAddress", "Please enter a valid email address.");
        } else {
            session.setAttribute("emptyEmailAddress", null);
        }

        passwordValid = validateFormField(password);
        if (!passwordValid) {
            session.setAttribute("emptyPassword", "Please enter a valid password.");
        } else {
            session.setAttribute("emptyPassword", null);
        }

        session.setAttribute("queryResultMessage", null);

        if (firstNameValid && lastNameValid && cityValid && stateValid && emailAddressValid && passwordValid) {

            HikerAccount hiker = new HikerAccount(firstName, lastName, city, state, emailAddress, password);
            int id = hikerAccountDao.insert(hiker);
            HikerAccount insertedHikerAccount = (HikerAccount) hikerAccountDao.getById(id);

            Role hiker_role = new Role(roleName, emailAddress, hiker);
            int role_id = roleDao.insert(hiker_role);
            Role insertedRole = (Role) roleDao.getById(role_id);
            session.setAttribute("queryResultMessage", "NEW HIKER INSERTED SUCCESSFULLY");

            session.setAttribute("firstName", null);
            session.setAttribute("lastName", null);
            session.setAttribute("city", null);
            session.setAttribute("state", null);
            session.setAttribute("emailAddress", null);
            session.setAttribute("password", null);

        } else {
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("city", city);
            session.setAttribute("state", state);
            session.setAttribute("emailAddress", emailAddress);
            session.setAttribute("password", password);
        }

        String url = "addHikerDisplay-servlet";
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
