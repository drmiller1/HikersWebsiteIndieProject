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
<script src="/scripts/snippet-javascript-console.min.js?v=1"></script>

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

            <div class="tableFixHead">
                <%--<table class="table table-scroll">--%>
                <table>
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
                                <%--<td class="col-xs-5">${hikingTrail.trailDescription}</td>--%>
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

<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript" >
    var $th = $('.tableFixHead').find('thead th')
    $('.tableFixHead').on('scroll', function() {
        $th.css('transform', 'translateY('+ this.scrollTop +'px)');
    });
</script>

</body>
</html