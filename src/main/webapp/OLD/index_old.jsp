<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Website short description." />
    <meta name="keywords" content="website main keywords" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="../style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>

    <script>
        $(document).ready(function() {
            $('.nav-tabs > li > a').click(function(event){
                event.preventDefault();//stop browser to take action for clicked anchor

                //get displaying tab content jQuery selector
                var active_tab_selector = $('.nav-tabs > li.active > a').attr('href');

                //find actived navigation and remove 'active' css
                var actived_nav = $('.nav-tabs > li.active');
                actived_nav.removeClass('active');

                //add 'active' css into clicked navigation
                $(this).parents('li').addClass('active');

                //hide displaying tab content
                $(active_tab_selector).removeClass('active');
                $(active_tab_selector).addClass('hide');

                //show target tab content
                var target_tab_selector = $(this).attr('href');
                $(target_tab_selector).removeClass('hide');
                $(target_tab_selector).addClass('active');
            });
        });
    </script>

    <style>
        /** Start: to style navigation tab **/
        .nav {
            margin-bottom: 18px;
            margin-left: 0;
            list-style: none;
        }

        .nav > li > a {
            display: block;
        }

        .nav-tabs{
            *zoom: 1;
        }

        .nav-tabs:before,
        .nav-tabs:after {
            display: table;
            content: "";
        }

        .nav-tabs:after {
            clear: both;
        }

        .nav-tabs > li {
            float: left;
        }

        .nav-tabs > li > a {
            padding-right: 12px;
            padding-left: 12px;
            margin-right: 2px;
            line-height: 14px;
        }

        .nav-tabs {
            border-bottom: 1px solid #ddd;
        }

        .nav-tabs > li {
            margin-bottom: -1px;
        }

        .nav-tabs > li > a {
            padding-top: 8px;
            padding-bottom: 8px;
            line-height: 18px;
            border: 1px solid transparent;
            -webkit-border-radius: 4px 4px 0 0;
            -moz-border-radius: 4px 4px 0 0;
            border-radius: 4px 4px 0 0;
        }

        .nav-tabs > li > a:hover {
            border-color: #eeeeee #eeeeee #dddddd;
        }

        .nav-tabs > .active > a,
        .nav-tabs > .active > a:hover {
            color: #555555;
            cursor: default;
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-bottom-color: transparent;
        }

        li {
            line-height: 18px;
        }

        .tab-content.active{
            display: block;
        }

        .tab-content.hide{
            display: none;
        }


        /** End: to style navigation tab **/
    </style>

</head>


<%@ include file="/head_tag.jsp"%>

<body>


<%@ include file="header_tag.jsp"%>

<div>

    <ul class="nav nav-tabs">
        <li class="active">
            <a href="#tab1" >Home </a>
        </li>
        <li>
            <a href="#tab2" >Add a new trail </a>

        </li>
        <li>
            <a href="#tab3" >New Hiker Sign-up </a>
        </li>
        <li>

            <a href="#tab4" >About </a>
        </li>
    </ul>
</div>

<section id="tab1" class="tab-content active">
    <div>
        <%@ include file="homePage.jsp"%>
    </div>
</section>
<section id="tab2" class="tab-content hide">
    <div>
        <%@ include file="addHikingTrail.jsp"%>
    </div>
</section>
<section id="tab3" class="tab-content hide">
    <div>
        <%@ include file="addHiker.jsp"%>
    </div>
</section>
<section id="tab4" class="tab-content hide">
    <div>
        <%@ include file="about.jsp"%>
    </div>
</section>

<%--<div id="main_content_bottom"></div>--%>

<%@ include file="/footer_tag.jsp"%>

</body>
</html>