<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/26/18
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<%@ include file="head_tag.jsp"%>

<body>
<div id="container">

    <%@ include file="header_tag.jsp"%>

    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h1>
                Add New Hiking Trail
            </h1>

            <h3 style="color: red;">${queryResultMessage}</h3>
            <c:remove var="queryResultMessage" scope="session" />

            <form method="POST" action="addHikingTrail-servlet" align="right">

                <label for="trail_head_name">Trailhead Name: </label>
                <strong style="color: red;">${emptyTrailHeadName}</strong>
                <c:remove var="emptyTrailHeadName" scope="session" />
                <br />
                <input type="text" name="trailHeadName" id="first_name" value = ${trailHeadName} >
                <br /><br />

                <label for="last_name">Last Name: </label>
                <strong style="color: red;">${emptyLastName}</strong>
                <c:remove var="emptyLastName" scope="session" />
                <br />
                <input type="text" name="lastName" id="last_name"value = ${lastName}>
                <br /> <br />

                <label for="city">City: </label>
                <br />
                <input type="text" name="city" id="city" value = ${city}>
                <br /><br />

                <label for="state">State: </label>
                <br />
                <input type="text" name="state" id="state" value = ${state}>
                <br /><br />

                <label for="email_address">Email Address: </label>
                <br />
                <input type="text" name="emailAddress" id="email_address" value = ${emailAddress}>
                <br /><br />

                <label for="password">Password: </label>
                <br />
                <input type="text" name="password" id="password" value = ${password}>
                <br /><br />

                <br />
                <input type="submit" value="Add Hiker" align="right"/>

            </form>

        </div>

        <%@ include file="menu_tag.jsp"%>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>
