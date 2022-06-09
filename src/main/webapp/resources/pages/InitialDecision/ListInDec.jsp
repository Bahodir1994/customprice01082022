<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String userId = (String) request.getSession().getAttribute("userId");
    String userName = (String) request.getSession().getAttribute("userName");
    Integer userRole = (Integer) request.getSession().getAttribute("userRole");
    String userRoleName = (String) request.getSession().getAttribute("userRoleName");
    String userLocation = (String) request.getSession().getAttribute("userLocation");
    String userLocationName = (String) request.getSession().getAttribute("userLocationName");
    String userPost = (String) request.getSession().getAttribute("userPost");
%>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--favicon-->
    <link href="<%=request.getContextPath()%>/resources/assets2/images/favicon-32x32.png" type="image/png"/>
    <!--plugins-->
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>
    <!-- loader-->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/pace.min.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>
    <!-- Bootstrap CSS -->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/app.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/icons.css" rel="stylesheet">
    <!-- Theme Style CSS -->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css"/>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet"/>
    <!-- loader-->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
</head>

<body>
<!--wrapper-->
<style>
    .sidenav {
        height: 100%;
        width: 0;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: #ffffff;
        overflow-x: hidden;
        transition: 0.5s;
        padding-top: 120px;
    }

    .sidenav a {
        padding: 8px 80px 8px 32px;
        text-decoration: none;
        font-size: 25px;
        color: #818181;
        display: block;
        transition: 0.3s;
    }

    .sidenav a:hover {
        color: #f1f1f1;
    }

    .sidenav .closebtn {
        position: absolute;
        top: 0;
        right: 25px;
        font-size: 36px;
        margin-left: 50px;
    }

    #main {
        transition: margin-left .5s;
        padding: 16px;
    }

    @media screen and (max-height: 450px) {
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 18px;}
    }
</style>
<style>
    .loader {
        color: #0929d7;
        font-size: 20px;
        margin: 100px auto;
        width: 1em;
        height: 1em;
        border-radius: 50%;
        position: relative;
        text-indent: -9999em;
        -webkit-animation: load4 1.3s infinite linear;
        animation: load4 1.3s infinite linear;
        -webkit-transform: translateZ(0);
        -ms-transform: translateZ(0);
        transform: translateZ(0);
    }
    @-webkit-keyframes load4 {
        0%,
        100% {
            box-shadow: 0 -3em 0 0.2em, 2em -2em 0 0em, 3em 0 0 -1em, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 -1em, -3em 0 0 -1em, -2em -2em 0 0;
        }
        12.5% {
            box-shadow: 0 -3em 0 0, 2em -2em 0 0.2em, 3em 0 0 0, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 -1em, -3em 0 0 -1em, -2em -2em 0 -1em;
        }
        25% {
            box-shadow: 0 -3em 0 -0.5em, 2em -2em 0 0, 3em 0 0 0.2em, 2em 2em 0 0, 0 3em 0 -1em, -2em 2em 0 -1em, -3em 0 0 -1em, -2em -2em 0 -1em;
        }
        37.5% {
            box-shadow: 0 -3em 0 -1em, 2em -2em 0 -1em, 3em 0em 0 0, 2em 2em 0 0.2em, 0 3em 0 0em, -2em 2em 0 -1em, -3em 0em 0 -1em, -2em -2em 0 -1em;
        }
        50% {
            box-shadow: 0 -3em 0 -1em, 2em -2em 0 -1em, 3em 0 0 -1em, 2em 2em 0 0em, 0 3em 0 0.2em, -2em 2em 0 0, -3em 0em 0 -1em, -2em -2em 0 -1em;
        }
        62.5% {
            box-shadow: 0 -3em 0 -1em, 2em -2em 0 -1em, 3em 0 0 -1em, 2em 2em 0 -1em, 0 3em 0 0, -2em 2em 0 0.2em, -3em 0 0 0, -2em -2em 0 -1em;
        }
        75% {
            box-shadow: 0em -3em 0 -1em, 2em -2em 0 -1em, 3em 0em 0 -1em, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 0, -3em 0em 0 0.2em, -2em -2em 0 0;
        }
        87.5% {
            box-shadow: 0em -3em 0 0, 2em -2em 0 -1em, 3em 0 0 -1em, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 0, -3em 0em 0 0, -2em -2em 0 0.2em;
        }
    }
    @keyframes load4 {
        0%,
        100% {
            box-shadow: 0 -3em 0 0.2em, 2em -2em 0 0em, 3em 0 0 -1em, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 -1em, -3em 0 0 -1em, -2em -2em 0 0;
        }
        12.5% {
            box-shadow: 0 -3em 0 0, 2em -2em 0 0.2em, 3em 0 0 0, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 -1em, -3em 0 0 -1em, -2em -2em 0 -1em;
        }
        25% {
            box-shadow: 0 -3em 0 -0.5em, 2em -2em 0 0, 3em 0 0 0.2em, 2em 2em 0 0, 0 3em 0 -1em, -2em 2em 0 -1em, -3em 0 0 -1em, -2em -2em 0 -1em;
        }
        37.5% {
            box-shadow: 0 -3em 0 -1em, 2em -2em 0 -1em, 3em 0em 0 0, 2em 2em 0 0.2em, 0 3em 0 0em, -2em 2em 0 -1em, -3em 0em 0 -1em, -2em -2em 0 -1em;
        }
        50% {
            box-shadow: 0 -3em 0 -1em, 2em -2em 0 -1em, 3em 0 0 -1em, 2em 2em 0 0em, 0 3em 0 0.2em, -2em 2em 0 0, -3em 0em 0 -1em, -2em -2em 0 -1em;
        }
        62.5% {
            box-shadow: 0 -3em 0 -1em, 2em -2em 0 -1em, 3em 0 0 -1em, 2em 2em 0 -1em, 0 3em 0 0, -2em 2em 0 0.2em, -3em 0 0 0, -2em -2em 0 -1em;
        }
        75% {
            box-shadow: 0em -3em 0 -1em, 2em -2em 0 -1em, 3em 0em 0 -1em, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 0, -3em 0em 0 0.2em, -2em -2em 0 0;
        }
        87.5% {
            box-shadow: 0em -3em 0 0, 2em -2em 0 -1em, 3em 0 0 -1em, 2em 2em 0 -1em, 0 3em 0 -1em, -2em 2em 0 0, -3em 0em 0 0, -2em -2em 0 0.2em;
        }
    }
</style>
<div id="mySidenav" class="sidenav">

<div id="openInPdf">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="loader text-center" id="preloaderGenerating">Loading...</div>
    <!--PDF open here-->
</div>
</div>
<!--start page wrapper -->
<div id="main" class="page-content">
    <!--start email wrapper-->
    <div class="row">
        <%if (userRole == 7 || userRole == 8) {%>
        <div class="col" style="cursor: pointer;" onclick="javascript:ListInDecApp('100')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-primary text-primary mb-3"><i class="bx bx-news"></i>
                        </div>
                        <h4 class="my-1">
                            <%
                                if (userRole == 7) {
                            %>
                            ${notSortedListSize} та
                            <%
                                }
                                if (userRole == 8) {
                            %>
                            ${sortedListSize} та
                            <%}%>
                        </h4>
                        <p class="mb-0 text-secondary">Янги ариза</p>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
        <%if (userRole == 7) {%>
        <%--        <c:if test="userRole == 7">--%>
        <div class="col my-button" style="cursor: pointer;" onclick="javascript:ListInDecRaspTable('110')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-danger text-danger mb-3"><i class="bx bx-send"></i>
                        </div>
                        <h4 class="my-1">${sortedListSize} та</h4>
                        <p class="mb-0 text-secondary">Tақсимланган</p>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
        <%--        </c:if>--%>
        <%if (userRole == 1 || userRole == 7 || userRole == 8) {%>
        <div class="col" style="cursor: pointer;" onclick="javascript:ListInDecProcessApp('115')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-info text-info mb-3"><i class="bx bxl-linkedin-square"></i>
                        </div>
                        <h4 class="my-1">${listProcessAppSize} та</h4>
                        <p class="mb-0 text-secondary">Кўриб чиқилмоқда</p>
                    </div>
                </div>
            </div>
        </div>
        <%--        <%}%>--%>

        <%--        <%if (userRole == 1 || userRole == 7 || userRole == 8) {%>--%>
        <div class="col" style="cursor: pointer;" onclick="javascript:ListInDecSubmittedApp('145')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-success text-success mb-3"><i class="bx bx-captions"></i>
                        </div>
                        <h4 class="my-1">${listSubmittedAppSize} та</h4>
                        <p class="mb-0 text-secondary">Тасдиқлашга киритилган</p>
                    </div>
                </div>
            </div>
        </div>
        <%}%>

        <%if (userRole == 1 || userRole == 6 || userRole == 7) {%>
        <div class="col" style="cursor: pointer;" onclick="javascript:ListInDecSignedApp('160')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-success text-success mb-3"><i class="bx bx-captions"></i>
                        </div>
                        <h4 class="my-1">${listSignedAppSize} та</h4>
                        <p class="mb-0 text-secondary">Имзога киритилган</p>
                    </div>
                </div>
            </div>
        </div>
        <%}%>

        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="javascript:ListInDecTermstTable('170')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <h4 class="my-1">${termsListSize} та</h4>
                        <p class="mb-0 text-secondary">Дастлабки қарор</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="javascript:ListAppReturned('125')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-danger text-danger mb-3"><i class="bx bx-repeat"></i>
                        </div>
                        <h4 class="my-1">${listAppReturnedSize} та</h4>
                        <p class="mb-0 text-secondary">Тузатишга қайтарилган</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="javascript:ListInDecTermsRollBack('175')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-info text-info mb-3"><i class="bx bx-reset"></i>
                        </div>
                        <h4 class="my-1">${termsRollBackListSize} та</h4>
                        <p class="mb-0 text-secondary">Бекор қилинган</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--end email wrapper-->
    <div class="col-12 col-lg-12 shadow">
        <div class="card">
            <div class="card-body" id="ListInDecTable" style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important;">
                <!--end row-->
            </div>
        </div>
    </div>
</div>
<!--end page wrapper -->
<!--end wrapper -->
<script>
    (function ($) {
        function getTimer(obj) {
            return obj.data('swd_timer');
        }

        function setTimer(obj, timer) {
            obj.data('swd_timer', timer);
        }

        $.fn.showWithDelay = function (delay) {
            var self = this;
            if (getTimer(this)) {
                window.clearTimeout(getTimer(this)); // prevents duplicate timers
            }
            setTimer(this, window.setTimeout(function () {
                setTimer(self, false);
                $(self).show();
            }, delay));
        };
        $.fn.hideWithDelay = function () {

            if (getTimer(this)) {
                window.clearTimeout(getTimer(this));
                setTimer(this, false);
            }
            $(this).hide();
        }
    })(jQuery);

    function ListInDecApp(status) {
        if (status == '100') {
        }
        if (status == '110') {
        }
        // var inspectorName = $('#userIdF_' + rowNum + ' option:selected').text();
        var x = '0';
        var dataS = {
            "id": x,
            "status": status
        }
        document.body.style.cursor = "wait";
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecTable",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                document.body.style.cursor = "default";
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    $(document).ready(function () {
        ListInDecApp('100');
    });

    function ListInDecRaspTable(status) {
        var x = '0';
        var dataS = {
            "id": x,
            "status": status
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecRasp",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function ListInDecProcessApp(status) {
        var x = '0';
        var dataS = {
            "id": x,
            "status": status
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecProcessApp",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function ListInDecSubmittedApp(status) {
        var x = '0';
        var dataS = {
            "id": x,
            "status": status
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecSubmittedApp",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function ListInDecSignedApp(status) {
        var x = '0';
        var dataS = {
            "id": x,
            "status": status
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecSignedApp",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function ListInDecTermstTable(status) {
        if (status == '100') {
        }
        if (status == '110') {
        }
        // var inspectorName = $('#userIdF_' + rowNum + ' option:selected').text();
        var x = '0';
        var dataS = {
            "id": x/*,
            "status": status*/
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecTermsTable",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function ListInDecTermsRollBack(status) {
        if (status == '100') {
        }
        if (status == '110') {
        }
        // var inspectorName = $('#userIdF_' + rowNum + ' option:selected').text();
        var x = '0';
        var dataS = {
            "id": x/*,
            "status": status*/
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecTermsRollBack",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function ListAppReturned(status) {
        var x = '0';
        var dataS = {
            "id": x,
            "status": status
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListAppReturned",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListInDecTable').html(res);
            },
            error: function (res) {
            }
        });
    }

</script>
</body>
