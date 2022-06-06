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
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css"
          rel="stylesheet"/>
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
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css"
          rel="stylesheet"/>
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
        background-color: #111;
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
        .sidenav {
            padding-top: 15px;
        }

        .sidenav a {
            font-size: 18px;
        }
    }
</style>
<div id="mySidenav" class="sidenav">
    <div id="openInPdf">
        <!--PDF open here-->
    </div>
</div>
<!--start page wrapper -->
<div id="main" class="page-content">
    <span>СПРАВОЧНИК /</span><span><b>БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ</b></span>
    <hr>
    <!--start email wrapper-->

    <!--end email wrapper-->
    <div class="col-12 col-lg-12 shadow">

        <div class="card">
            <div class="fm-search mt-2 mb-1 ml-3 mr-3">
                <div class="mb-0">
                    <div class="row m-3">
                        <div class="row">
                            <div class="col">
                                <label class="">Хат рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ҲББ томонидан юбоирлган хат рақами"></i>
                                <input class="result form-control shadow-sm" type="text" id="xbbMailNumS" name="xbbMailNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>
                            <div class="col">
                                <label class="">Санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                                 data-bs-placement="top"
                                                                 title="ҲББ томонидан юбоирлган хат санаси"></i>
                                <input class="result form-control shadow-sm" type="date" id="xbbMailDateS"
                                       name="xbbMailDateS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>
                            <div class="col">
                                <label class="">ТИФ ТН код</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                                     data-bs-placement="top" title="ТИФ ТН код"></i>
                                <input class="result form-control shadow-sm" type="text" id="hsCodeS" name="hsCodeS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>
                            <div class="col">
                                <label class="">Товар номи</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                                     data-bs-placement="top" title="Товар номи"></i>
                                <input class="result form-control shadow-sm" type="text" id="productNameS"
                                       name="productNameS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>
                            <div class="col">
                                <label class="">Сўровнома юборилган давлат</label><i class="bx bx-info-circle"
                                                                                     data-bs-toggle="tooltip"
                                                                                     data-bs-placement="top"
                                                                                     title="Сўровнома юборилган давлат"></i>
                                <select class="form-select shadow-sm" id="sendReqCountryCodeS"
                                        name="sendReqCountryCodeS" required="" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                    <option value="">--Танланг--</option>
                                    <c:forEach var="countr" items="${countryList}">
                                        <option value="${countr.code}">${countr.cdNm}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col mt-2">
                                <button type="button" id="izlash" class="btn btn-outline-primary btn-block mt-2"
                                        onclick="searchResultTableBYDHistory(0)"><i class='bx bx-refresh'></i>Излаш
                                </button>
                                <button type="reset" class="btn btn-outline-primary btn-block mt-2" onclick="reset(1)">
                                    <i class='bx bx-trash'></i>Тозалаш
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
                <div class="" id="divRowCount" style="display: none; padding-left:1rem; padding-right:1rem; width: 7%!important;">
                    <div class="text-primary">
                        <select class="form-select" id="size" name="size" onchange="searchResultTableBYDHistory(0)">
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="30">30</option>
                            <option value="50">50</option>
                        </select>
                    </div>
                </div>
            <div id="loaderII" class="col-md-12 position-absolute top-50 start-50 visually-hidden" role="status" style="z-index: 999999">
                <div class="spinner-border" style="width: 3rem; height: 3rem;" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>
            <div class="card-body" id="ListCMTable" style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important;">
            </div>
        </div>
    </div>
</div>
</div>
<script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.13.1/validate.min.js"></script>
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
    function searchResultTableBYDHistory(x, root = null) {
        $('#loaderII').removeClass('visually-hidden')
        if (root) root.preventDefault();
        var dataS = {
            "page": x,
            "size": $("#size").val()
        }
        $.ajax({
            type: "GET",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/ResultBYDHistory",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                setTimeout(()=>{
                    $('div#ListCMTable').html(res);
                    $('div#divRowCount').css({'display': ''});
                    $('#loaderII').addClass('visually-hidden');
                },1000)
            },
            error: function (res) {
                setTimeout(()=>{
                    $('#loaderII').addClass('visually-hidden')
                },1000)
            }
        });

    }

    function reset(x) {
        document.getElementById("xbbMailDateS").value = '';
        document.getElementById("xbbMailNumS").value = '';
        document.getElementById("hsCodeS").value = '';
        document.getElementById("productNameS").value = '';
        document.getElementById("sendReqCountryCodeS").value = '';
        document.getElementById("sendReqNumS").value = '';
        document.getElementById("reqDateS").value = '';
        document.getElementById("responseNumS").value = '';
        document.getElementById("responseDateS").value = '';
        document.getElementById("responseNumSendXbbNumS").value = '';
        document.getElementById("responseNumSendXbbDateS").value = '';
        document.getElementById("resultAnswerMailNumS").value = '';
        document.getElementById("resultAnswerMailDateS").value = '';
        document.getElementById("xbbVerdictNumS").value = '';
        document.getElementById("xbbVerdictDateS").value = '';
        document.getElementById("statusS").value = '';
    }
    function resetModal() {
        document.getElementById("xbbMailNum").value = '';
        document.getElementById("xbbMailDate").value = '';
        document.getElementById("orgName").value = '';
        document.getElementById("hsCode").value = '';
        document.getElementById("productName").value = '';
        document.getElementById("sendReqCountryCode").value = '';
    }
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>