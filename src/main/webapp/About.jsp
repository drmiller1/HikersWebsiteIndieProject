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
            <h2>
                About
            </h2>

            <h3>
                Created by: Dan Miller
                <br />
                Home Town: Madison, WI
                <br />
                Favorite Trail: Parfey's Glen, Merrimac WI
                <br />
                Favorite National Park for hiking: Glacier National Park, Montana
                <br />
                Favorite National Park for Backpacking: Smokey Mountain National Park, Tennessee
                <br />
                This site was created to give outdoor enthusiasts a way to find new trails
                as well as keep track of their favorite trails.  These trails may be close
                to home or close to a fast approaching vacation destination.

            </h3>

        </div>

        <%@ include file="menu_tag.jsp"%>

        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>

    <%@ include file="footer_tag.jsp"%>

</div>
</body>
</html>