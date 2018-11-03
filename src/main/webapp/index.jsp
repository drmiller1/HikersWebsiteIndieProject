<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <jsp:include page="head_tag.jsp"/>

    <body>
        <jsp:include page="header_tag.jsp"/>

        <div id="container">

        <div id="main_content_top"></div>
            <div id="main_content">
                <div class="content">
                    <h2>
                        <img src="images/Helena_Hike.jpg" width="100%" height="100%" alt="image"/>
                    </h2>
                </div>

                <%-- <%@ include file="login.jsp"%> --%>

                <%--<%@ include file="jsp/menu_tag.jsp"%>--%>

                <div id="clear"></div>
            </div>

            <div id="main_content_bottom"></div>


            <jsp:include page="footer_tag.jsp"/>

        </div>
    </body>
</html>



