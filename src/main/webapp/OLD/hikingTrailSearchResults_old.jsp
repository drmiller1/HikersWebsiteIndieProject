<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/5/18
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<%@ include file="head_tag.jsp"%>

<head>
    <%--<meta charset="utf-8">
    <title>Dynamic Editable HTML Table using Javascript, Jquery and Bootstrap with add, edit, and Delete Options</title>--%>
    <!-- CSS files-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>

<%@ include file="menu_tag.jsp"%>

<div id="container">

    <%@ include file="header_tag.jsp"%>

    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h1 align="center">
                Hiking Trail Search Results
            </h1>

            <br>
            <br>

            <div class="table-responsive col-md-10">
                <table class="table table-bordered table-striped table-hover text-center" id="DyanmicTable" >
                    <thead>
                    <tr>

                        <th>Trail Head Name</th>
                        <th>Trail Head Location</th>
                        <th>Trail Length</th>
                        <th>Trail Difficulty</th>
                        <th>Trail Rating</th>
                        <th>Trail Features</th>
                        <th>Trail Details</th>
                        <th>Trail Description</th>
                        <th class="text-center">
                            <button id="addNewRow" class="btn btn-primary btn-sm">Add New Row</button>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
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
                    </tbody>
                </table>
            </div>
        </div>
        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

    <!--JS Files-->
    <script  src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
    <script src="bootstable.min.js"></script>
    <script>
        $('#DyanmicTable').SetEditable({ $addButton: $('#addNewRow')});
    </script>
</body>
</html>