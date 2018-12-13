<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/8/18
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<%@ include file="head_tag.jsp"%>

<head>
    <meta name="generator" content="HTML Tidy, see www.w3.org">
    <title> HTML Forms Lab</title>
</head>

<body>

<%@ include file="menu_tag.jsp"%>

<div id="container">

    <%@ include file="header_tag.jsp"%>

    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h1>
                Employee Search Results
            </h1>
            <%--
            <c:choose>

                <c:when test = "${hikingTrailList.isEmpty()}" >
            --%>
                    <table style="width:75%" border="1">

                        <th>Trail Head Name</th>
                        <th>Trail Head Location</th>
                        <th>Trail Length</th>
                        <th>Trail Difficulty</th>
                        <th>Trail Rating</th>
                        <th>Trail Features</th>
                        <th>Trail Details</th>
                        <th>Trail Description</th>

                        <c:forEach var="hikingTrail" items="${hikingTrailList}">
                            <tr>
                                <td>${hikingTrail.trailHeadName}</td>
                                <td>${hikingTrail.trailHeadLocation}</td>
                                <td>${hikingTrail.trailLength}</td>
                                <td>${hikingTrail.trailDifficulty}</td>
                                <td>${hikingTrail.trailRating}</td>
                                <td>${hikingTrail.trailFeatures}</td>
                                <td>${hikingTrail.trailDetails}</td>
                                <td>${hikingTrail.trailDescription}</td>
                            </tr>
                        </c:forEach>
                    </table>
                <%--
                </c:when>

                <c:otherwise>
                    <h3>
                        <strong style="color: red;">No Employees Found For Your Search.</strong>
                        <br />
                        <br />
                        <strong style="color: red;">Please Enter A New Search Term.</strong>
                    </h3>
                </c:otherwise>

            </c:choose>
            --%>
        </div>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>