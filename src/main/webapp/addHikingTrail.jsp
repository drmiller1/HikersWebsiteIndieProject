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
                Add New Hiking Trail
            </h1>

            <h3 style="color: red;">${queryResultMessage}</h3>
            <c:remove var="queryResultMessage" scope="session" />

            <form method="POST" action="addHikingTrail-servlet" align="right">

                <label for="trail_head_name">Trailhead Name: </label>
                <strong style="color: red;">${emptyTrailHeadName}</strong>
                <c:remove var="emptyTrailHeadName" scope="session" />
                <br />
                <input type="text" name="trailHeadName" id="trail_head_name" value = ${trailHeadName}>
                <br /><br />

                <label for="trail_head_location">Trail Head Location: </label>
                <strong style="color: red;">${emptyTrailHeadLocation}</strong>
                <c:remove var="emptyTrailHeadLocation" scope="session" />
                <br />
                <input type="text" name="trailHeadLocation" id="trail_head_location"value = ${trailHeadLocation}>
                <br /> <br />

                <label for="trail_length">Trail Length: </label>
                <br />
                <input type="text" name="trailLength" id="trail_length" value = ${trailLength}>
                <br /><br />

                <label for="trail_difficulty">Trail Difficulty: </label>
                <br />
                <select name="trailDifficulty" id="trail_difficulty" value = ${trailDifficulty}>
                    <option value=1>1 - Easy</option>
                    <option value=2>2 - Moderate</option>
                    <option value=3>3 - Difficult</option>
                </select>

                <br /><br />

                <label for="trail_rating">Trail Rating: </label>
                <br />
                <select name="trailRating" id="trail_rating" value = ${trailRating}>
                    <option value=1>1 - Favorite</option>
                    <option value=2>2 - Worth Hiking</option>
                    <option value=3>3 - Ok</option>
                    <option value=4>4 - Boring</option>
                    <option value=5>5 - Don't Bother</option>
                </select>

                <br /><br />

                <label for="trail_features">Trail Features: </label>
                <br />
                <input type="text" name="trailFeatures" id="trail_features" value = ${trailFeatures}>
                <br /><br />

                <label for="trail_details">Trail Details: </label>
                <br />
                <input type="text" name="trailDetails" id="trail_details" value = ${trailDetails}>
                <br /><br />

                <label for="trail_description">Other Trail Description: </label>
                <br />
                <input type="text" name="trailDescription" id="trail_description" value = ${trailDescription}>
                <br /><br />

                <br />
                <input type="submit" value="Add Trail" align="right"/>

            </form>

        </div>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>
