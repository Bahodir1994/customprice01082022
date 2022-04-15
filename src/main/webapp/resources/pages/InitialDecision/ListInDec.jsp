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

<!--start page wrapper -->
<div class="page-content">
    <!--start email wrapper-->
    <div class="row">
        <div class="col" style="cursor: pointer;" onclick="javascript:ListInDecApp('100')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-primary text-primary mb-3"><i class="bx bx-news"></i>
                        </div>
                        <h4 class="my-1">30 та</h4>
                        <p class="mb-0 text-secondary">Янги ариза</p>
                    </div>
                </div>
            </div>
        </div>
        <%if (userRole == 7) {%>
        <%--        <c:if test="userRole == 7">--%>
        <div class="col my-button" style="cursor: pointer;" onclick="javascript:ListInDecRaspTable('110')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-danger text-danger mb-3"><i class="bx bx-send"></i>
                        </div>
                        <h4 class="my-1">29 та</h4>
                        <p class="mb-0 text-secondary">Tақсимланган</p>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
        <%--        </c:if>--%>
        <div class="col">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-info text-info mb-3"><i class="bx bxl-linkedin-square"></i>
                        </div>
                        <h4 class="my-1">15 та</h4>
                        <p class="mb-0 text-secondary">Жараёнда</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-success text-success mb-3"><i class="bx bx-captions"></i>
                        </div>
                        <h4 class="my-1">38 та</h4>
                        <p class="mb-0 text-secondary">Имзога киритилган</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="javascript:ListInDecTermstTable('170')">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <h4 class="my-1">30 та</h4>
                        <p class="mb-0 text-secondary">Дастлабки қарор</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-danger text-danger mb-3"><i class="bx bx-repeat"></i>
                        </div>
                        <h4 class="my-1">29 та</h4>
                        <p class="mb-0 text-secondary">Тузатиш учун қайтарилган</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-info text-info mb-3"><i class="bx bx-reset"></i>
                        </div>
                        <h4 class="my-1">5 та</h4>
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

    function ListInDecTermstTable(status) {
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

</script>
</body>
