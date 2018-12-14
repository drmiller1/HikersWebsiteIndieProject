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

<head>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

    </style>

</head>

<body>

<%@ include file="menu_tag.jsp"%>

<div id="container">

    <%@ include file="header_tag.jsp"%>

    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h1>
                Hiking Trail Search Results
            </h1>

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

        </div>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>