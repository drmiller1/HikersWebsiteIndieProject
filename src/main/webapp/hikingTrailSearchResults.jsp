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
    <style type="text/css">

    </style>
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

        .table_outer {
            height: 9em;
            overflow: auto;
            width: 100%;
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

            <div>
                <table class="table_outer">
                    <thead>
                        <tr>
                            <th class="col-xs-3">Trail Head Name</th>
                            <th class="col-xs-3">Trail Head Location</th>
                            <th class="col-xs-1">Trail Length</th>
                            <th class="col-xs-1">Trail Difficulty</th>
                            <th class="col-xs-1">Trail Rating</th>
                            <th class="col-xs-5">Trail Features</th>
                            <th class="col-xs-5">Trail Details</th>
                            <th class="col-xs-5">Trail Description</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="hikingTrail" items="${hikingTrailList}">
                            <tr>
                                <td class="col-xs-3">${hikingTrail.trailHeadName}</td>
                                <td class="col-xs-3">${hikingTrail.trailHeadLocation}</td>
                                <td class="col-xs-1">${hikingTrail.trailLength}</td>
                                <td class="col-xs-1">${hikingTrail.trailDifficulty}</td>
                                <td class="col-xs-1">${hikingTrail.trailRating}</td>
                                <td class="col-xs-5">${hikingTrail.trailFeatures}</td>
                                <td class="col-xs-5">${hikingTrail.trailDetails}</td>
                                <td class="col-xs-5">${hikingTrail.trailDescription}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html