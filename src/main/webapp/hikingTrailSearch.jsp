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
<%@ include file="menu_tag.jsp"%>

<div id="container">

    <%@ include file="header_tag.jsp"%>

    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h1>
                Hiking Trail Search
            </h1>

            <form method="GET" action="trailSearchResults-servlet" />

            <br />

            <label for="search_term">Search String: </label>
            <strong style="color: red;">${emptyTerm}</strong>
            <c:remove var="emptyTerm" scope="session" />
            <br />
            <input type="text" name="searchTerm" id="search_term" value = "" />
            <br /><br />

            <input type="radio" id="searchTrailHeadName" name="searchType"
                   value="trailHeadName" checked>
            <label for="searchTrailHeadName">Search by Trail Head Name</label>
            <br />

            <input type="radio" id="searchTrailLocation" name="searchType"
                   value="trailHeadLocation">
            <label for="searchTrailLocation">Search by Location</label>
            <br />

            <br />
            <br />

            <input type="submit" value="Search" />

            </form>

        </div>
        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>
