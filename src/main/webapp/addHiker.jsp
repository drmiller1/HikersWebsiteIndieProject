<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/5/18
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="head_tag.jsp"%>

<body>

<%@ include file="menu_tag.jsp"%>

<div id="container">

    <%@ include file="header_tag.jsp"%>

    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h1 align="center">
                Add New Hiker
            </h1>

            <h3 style="color: red;">${queryResultMessage}</h3>
            <c:remove var="queryResultMessage" scope="session" />

            <form method="POST" action="addHiker-servlet" align="right">

                <label for="first_name">First Name: </label>
                <strong style="color: red;">${emptyFirstName}</strong>
                <c:remove var="emptyFirstName" scope="session" />
                <br />
                <input type="text" name="firstName" id="first_name" value = ${firstName} >
                <br /><br />

                <label for="last_name">Last Name: </label>
                <strong style="color: red;">${emptyLastName}</strong>
                <c:remove var="emptyLastName" scope="session" />
                <br />
                <input type="text" name="lastName" id="last_name"value = ${lastName}>
                <br /> <br />

                <label for="city">City: </label>
                <strong style="color: red;">${emptyCity}</strong>
                <c:remove var="emptyCity" scope="session" />
                <br />
                <input type="text" name="city" id="city" value = ${city}>
                <br /><br />

                <label for="state">State: </label>
                <strong style="color: red;">${emptyState}</strong>
                <c:remove var="emptyState" scope="session" />
                <br />
                <input type="text" name="state" id="state" value = ${state}>
                <br /><br />

                <label for="email_address">Email Address: </label>
                <strong style="color: red;">${emptyEmailAddress}</strong>
                <c:remove var="emptyEmailAddress" scope="session" />
                <br />
                <input type="text" name="emailAddress" id="email_address" value = ${emailAddress}>
                <br /><br />

                <label for="password">Password: </label>
                <strong style="color: red;">${emptyPassword}</strong>
                <c:remove var="emptyPassword" scope="session" />
                <br />
                <input type="password" name="password" id="password" value = ${password}>
                <br /><br />

                <br />
                <input type="submit" value="Add Hiker" align="right"/>

            </form>

        </div>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>
