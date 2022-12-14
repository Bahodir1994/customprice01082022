<%@ page import="uz.customs.customsprice.utils.Utils" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
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

    String startDate = Utils.tecDate00();
    String endDate = Utils.tecDate00();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    GregorianCalendar gc = new GregorianCalendar();
    java.util.Date d = new Date();
    gc.setTime(d);
    int dayBefore = gc.get(Calendar.DAY_OF_YEAR);
    gc.roll(Calendar.DAY_OF_YEAR, -1);
    int dayAfter = gc.get(Calendar.DAY_OF_YEAR);
    if (dayAfter > dayBefore) {
        gc.roll(Calendar.YEAR, -1);
    }
    gc.get(Calendar.DATE);
    java.util.Date yesterday = gc.getTime();
    startDate = Utils.toDate00(yesterday);
%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=request.getContextPath()%>/resources/assets2/images/favicon-32x32.png" type="image/png"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/pace.min.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/app.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/icons.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/select2/css/select2-bootstrap4.css" rel="stylesheet" />
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
<!-- Latest compiled and minified CSS -->

<div id="main" class="page-content">
    <span style="cursor: pointer"><a href="#" class="text-success">?????? ????????????</a> / </span></span><span class=""><b>?????????????? ??????????????????</b></span>
    <hr>

    <div class="row">
        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <c:set var = "AllInSurveys" value = "${AllInSurvey}"/>
                        <h4 class="my-1"><fmt:formatNumber value = "${AllInSurveys}" maxFractionDigits="3" /> ????</h4>
                        <p class="mb-0 text-secondary">???????? ?????????????? ????????????????????????</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <h4 id="mmm" class="my-1">${AllSumProbability} ??????</h4>
                        <p class="mb-0 text-secondary">?????????????????? ?????????????????????? ??????????</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <h4 class="my-1">${AllSumDef} ??????</h4>
                        <p class="mb-0 text-secondary">?????????????? ??????????????</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <h4 class="my-1">${AllSum??pproved} ??????</h4>
                        <p class="mb-0 text-secondary">???????????????????? ??????????</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col" style="opacity: 0.9; cursor: pointer;" onclick="">
            <div class="card radius-10 shadow">
                <div class="card-body">
                    <div class="text-center">
                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class="bx bx-award"></i>
                        </div>
                        <h4 class="my-1">${AllSumOnControl} ??????</h4>
                        <p class="mb-0 text-secondary">?????????????????????? ??????????</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="col-12 col-lg-12 shadow">
    <div class="card">
        <div class="fm-search mt-2 mb-1 ml-3 mr-3">
            <div class="mb-0">
                <div class="row m-3">
                    <div class="row">
                        <div class="col-md-3">
                            <label class="">??????????????</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="?????????????? ?????????????????? ?????????????? ????????"></i>
                            <select class="form-select" type="text" id="directionTypeCode" name="directionTypeCode">
                                <option class="font-italic" selected value="">--- ?????????????? ---</option>
                                <c:forEach var="dirTyp" items="${directionType}" varStatus="i">
                                    <option value="${dirTyp.code}">${dirTyp.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>C???????????????? ????????????</label>
                            <select class="form-select" id="statusS" name="statusS"/>
                            <option value="">--??????????????--</option>
                            <option value="100">????????</option>
                            <option value="200">????????????????</option>
                            <option value="300">????????????????????</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label class="">?????????????????? ?????????????????? ????????????</label>
                            <i class="bx bx-info-circle"
                               data-bs-toggle="tooltip"
                               data-bs-placement="top"
                               title="?????????????????? ?????????????????? ????????????">
                            </i>
                            <select class="form-select shadow-sm" id="sendReqCountryCodeS"
                                    name="sendReqCountryCodeS" required=""/>
                            <option value="">--??????????????--</option>
                            <c:forEach var="countr" items="${countryList}">
                                <option value="${countr.code}">${countr.cdNm}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <c:if test="${userLocation == '1701'}">
                            <div class="col-md-3">
                                <label class="">???????????????? ??????????????</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="???????????????? ????????????????????"></i>
                                <select class="result form-select shadow-sm" type="text" id="userLocationCodeS1" name="userLocationCodeS1">
                                    <option class="font-italic" selected value="">--- ?????????????? ---</option>
                                    <c:forEach var="usrLoc" items="${location}" varStatus="i">
                                        <option value="${usrLoc.id}">${usrLoc.name1}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="">???????????? ??????????</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="???????????? ??????????"></i>
                                <select class="result form-select shadow-sm" type="text" id="executiveTerritoryCodeS" name="executiveTerritoryCodeS">
                                    <option class="font-italic" selected value="">--- ?????????????? ---</option>
                                    <c:forEach var="usrLoc" items="${location}" varStatus="i">
                                        <option value="${usrLoc.id}">${usrLoc.name1}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </c:if>
                        <div class="col-md-3">
                            <button type="button" class="btn btn-primary btn-block mt-3"
                                    onclick="searchResultTableISFirst(0)"><i class='bx bx-refresh'></i>??????????
                            </button>
                            <c:if test="${userLocation != '1701'}">
                                <button type="reset" class="btn btn-primary btn-block mt-3" onclick="reset(1)">
                                    <i class='bx bx-trash'></i>
                                </button>
                            </c:if>
                            <c:if test="${userLocation == '1701'}">
                                <button type="reset" class="btn btn-primary btn-block mt-3" onclick="resetS(1)">
                                    <i class='bx bx-trash'></i>
                                </button>
                            </c:if>
                            <c:if test="${userRole == '8' || userRole == '7' || userRole == '6' || userRole == '4'}">
                                <button type="button" class="btn btn-primary btn-block mt-3"
                                        class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                        onclick="resetModal()"><i class='bx bx-plus'></i>????????
                                </button>
                            </c:if>
                            <button type="reset" class="btn btn-outline-dark btn-block mt-3" data-bs-toggle="modal" data-bs-target="#reportExport">
                                <i class='bx bx-line-chart-down'></i>??????????????
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="reportExport" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="">?????????????? ??????????</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body row">
                                            <div class="col">
                                                <label for="FromStart" class="text-dark m-1">??????</label>
                                                <input class="form-control" id="FromStart" name="FromStart" type="date" value="<%=startDate%>"/>
                                                <label for="FromStart" id="FromStartValid" class="m-1"></label>
                                            </div>
                                            <div class="col">
                                                <label for="ToEnd" class="text-dark m-1">????????</label>
                                                <input class="form-control"  id="ToEnd" name="ToEnd" type="date" value="<%=endDate%>"/>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <style>
                                                .imgs:hover {
                                                    border:2px solid white;
                                                    transform: scale(1.1);
                                                }
                                                .imgs {
                                                    cursor: pointer;
                                                }
                                                .imgs:active {
                                                    border-color: blue;
                                                }
                                            </style>
                                            <div class="text-center">
                                                <img class="m-3 imgs"  src="<%=request.getContextPath()%>/resources/images/excel.png" width="15%" height="15%" alt="" onclick="report('exel')"/>
                                                <img class="m-3 imgs"  src="<%=request.getContextPath()%>/resources/images/pdf.png" width="15%" height="15%" alt=""  onclick="report('pdf')"/>
                                                <img class="m-3 imgs"  src="<%=request.getContextPath()%>/resources/images/html.png" width="15%" height="15%" alt=""  onclick="report('htmls')"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="target" name="target"></div>
                    </div>
                    <div class="row">
                    </div>
                    <div class="row">
                    </div>
                    <div class="row">
                    </div>
                    <!-- Modal 1-qadam-->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-xl col-md-12">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">?????????????? ?????????????????? ??????????????</h5>
                                    <button type="button" class="btn-close" id="closeModalSave"
                                            data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body row">
                                    <!--todo 1-bosqich-->
                                    <form class="row g-3 needs-validation">
                                        <c:if test="${userLocation != '1701'}">
                                            <div class="form-group col-md-3">
                                                <label for="xbbMailNum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>?????? ?????????????????? ?????????????????? ?????? ????????????:</label>
                                                <input class="form-control" type="text" id="xbbMailNum" name="xbbMailNum">
                                                <div class="valid-feedback">????????????????????</div>
                                                <div class="" id="xbbMailNumValid"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="xbbMailNum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>?????? ?????????????????? ?????????????????? ?????? ????????????:</label>
                                                <input class="form-control" type="date" id="xbbMailDate" name="xbbMailDate">
                                                <div class="valid-feedback">????????????????????</div>
                                                <div class="" id="xbbMailDateValid"></div>
                                            </div>
                                        </c:if>

                                        <div class="form-group col-md-3">
                                            <label for="orgName" class="form-label text-primary"><span class="text-danger">&#x2734;</span>????????????????
                                                ????????:</label>
                                            <input class="form-control was-validated" type="text" id="orgName"
                                                   name="orgName">
                                            <div class="valid-feedback">????????????????????</div>
                                            <div class="" id="orgNameValid"></div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="hsCode" class="form-label text-primary"><span class="text-danger">&#x2734;</span>?????? ???? ??????:</label>
                                            <input class="form-control" type="text" id="hsCode" name="hsCode">
                                            <div class="valid-feedback">????????????????????</div>
                                            <div class="" id="hsCodeValid"></div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="productName" class="form-label text-primary"><span class="text-danger">&#x2734;</span>??????????
                                                ????????:</label>
                                            <input class="form-control" type="text" id="productName"
                                                   name="productName">
                                            <div class="valid-feedback">????????????????????</div>
                                            <div class="" id="productNameValid"></div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="sendReqCountryCode" class="form-label text-primary"><span class="text-danger">&#x2734;</span>?????????????????? ?????????????????? ????????????:</label>
                                            <select class="form-control" type="text" id="sendReqCountryCode" name="sendReqCountryCode">
                                                <option class="font-italic" selected value="">--- ?????????????? ---</option>
                                                <c:forEach var="vals" items="${countryList}" varStatus="i">
                                                    <option value="${vals.code}">${vals.code}- ${vals.cdNm}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="valid-feedback">????????????????????</div>
                                            <div class="" id="sendReqCountryCodeValid"></div>
                                        </div>

                                        <div class="form-group col-md-3">
                                            <label for="sendReqCountryCode" class="form-label text-primary"><span class="text-danger">&#x2734;</span>??????????????:</label>
                                            <select class="form-control" type="text" id="directionTypeSave" name="sendReqCountryCode">
                                                <option class="font-italic" selected value="">--- ?????????????? ---</option>
                                                <c:forEach var="dirTyp" items="${directionType}" varStatus="i">
                                                    <option value="${dirTyp.code}">${dirTyp.name}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="valid-feedback">????????????????????</div>
                                            <div class="" id="directionTypeSaveValid"></div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="productName" class="form-label text-primary"><span class="text-danger">&#x2734;</span>??????????????.?????????? ?????????????????????? (c????????):</label>
                                            <input class="form-control" type="text" id="sumProbability"
                                                   name="sumProbability">
                                            <div class="valid-feedback">????????????????????</div>
                                            <div class="" id="sumProbabilityValid"></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary"
                                                    onclick="saveValueFromInputS()">????????????
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="col-sm-8" id="divRowCount" style="display: none; margin-left: 15px!important;">
            <div class="col-md-1 text-primary">
                <select class="form-select" id="size" name="size" onchange="searchResultTableIS(0)">
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
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/select2/js/select2.min.js"></script>
<%--<script>--%>
<%--    $('.single-select').select2({--%>
<%--        theme: 'bootstrap',--%>
<%--        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100 form-control') ? '100%' : 'style',--%>
<%--        placeholder: $(this).data('placeholder'),--%>
<%--        allowClear: Boolean($(this).data('allow-clear')),--%>
<%--    });--%>
<%--</script>--%>
<script>
    (function($){
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
    function searchResultTableISFirst(x, root = null) {
        $('#loaderII').removeClass('visually-hidden')
        if (root) root.preventDefault();
        var dataS = {
            "userLocationCode": $("#userLocationCodeS1").val(),
            "directionTypeCode": $("#directionTypeCode").val(),
            // "xbbMailDate": $("#xbbMailDateS").val().toString(),
            // "xbbMailNum": $("#xbbMailNumS").val(),
            // "hsCode": $("#hsCodeS").val(),
            // "productName": $("#productNameS").val(),
            "sendReqCountryCode": $("#sendReqCountryCodeS").val(),
            // "sendReqNum": $("#sendReqNumS").val(),
            // "reqDate": $("#reqDateS").val(),
            // "responseNum": $("#responseNumS").val(),
            // "responseDate": $("#responseDateS").val(),
            // "responseNumSendXbbNum": $("#responseNumSendXbbNumS").val(),
            // "responseNumSendXbbDate": $("#responseNumSendXbbDateS").val(),
            // "resultAnswerMailNum": $("#resultAnswerMailNumS").val(),
            // "resultAnswerMailDate": $("#resultAnswerMailDateS").val(),
            // "xbbVerdictNum": $("#xbbVerdictNumS").val(),
            // "xbbVerdictDate": $("#xbbVerdictDateS").val(),
            "executiveTerritoryCode": $("#executiveTerritoryCodeS").val(),
            "status": $("#statusS").val(),
            "page": x,
            "size": $("#size").val()
        }
        $.ajax({
            type: "GET",
            data: dataS,
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/ResultIS",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListCMTable').html(res);
                $('div#divRowCount').css({'display': ''});
                $('#loaderII').addClass('visually-hidden');
            },
            error: function (res) {
            }
        });

    }
    function searchResultTableIS(x, root = null) {
        $('#loaderII').removeClass('visually-hidden')
        if (root) root.preventDefault();
        var dataS = {
            "userLocationCode": $("#userLocationCodeS").val(),
            "savedUserFirst": $("#savedUserFirstS").val(),
            "xbbMailDate": $("#xbbMailDateS").val().toString(),
            "xbbMailNum": $("#xbbMailNumS").val(),
            "orgName": $("#orgNameS").val(),
            "hsCode": $("#hsCodeS").val(),
            "productName": $("#productNameS").val(),
            "sendReqCountryCode": $("#sendReqCountryCodeS").val(),
            "sumProbability": $("#sumProbabilityS").val(),
            "sendReqNum": $("#sendReqNumS").val(),
            "reqDate": $("#reqDateS").val(),
            "responseNum": $("#responseNumS").val(),
            "responseDate": $("#responseDateS").val(),
            "responseNumSendXbbNum": $("#responseNumSendXbbNumS").val(),
            "responseNumSendXbbDate": $("#responseNumSendXbbDateS").val(),
            "resultAnswerMailNum": $("#resultAnswerMailNumS").val(),
            "resultAnswerMailDate": $("#resultAnswerMailDateS").val(),
            "xbbVerdictNum": $("#xbbVerdictNumS").val(),
            "xbbVerdictDate": $("#xbbVerdictDateS").val(),
            "executiveTerritoryCode": $("#executiveTerritoryCode").val(),
            "status": $("#statusS").val(),
            "comment": $("#commentS").val(),
            "fabula": $("#fabulaS").val(),
            "page": x,
            "size": $("#size").val()
        }
        $.ajax({
            type: "GET",
            data: dataS,
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/ResultIS",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListCMTable').html(res);
                $('div#divRowCount').css({'display': ''});
                $('#loaderII').addClass('visually-hidden');
            },
            error: function (res) {
                setTimeout(()=>{
                    $('#loaderII').addClass('visually-hidden')
                },1000)
            }
        });

    }
    function saveValueFromInputS() {
        let userLocation = '<%=userLocation%>';
        if (userLocation == '1701') {
            xbbMailNum2 = '1701';
            xbbMailDate2 =  '1111-11-11';
        } else {
            xbbMailNum2 = $("#xbbMailNum").val();
            xbbMailDate2 = $("#xbbMailDate").val();
        }
        var dataS = {
            "xbbMailNum": xbbMailNum2,
            "xbbMailDate": xbbMailDate2,
            "orgName": $('#orgName').val(),
            "hsCode": $('#hsCode').val(),
            "productName": $('#productName').val(),
            "sendReqCountryCode": $('#sendReqCountryCode').val(),
            "directionTypeSave": $('#directionTypeSave').val(),
            "sumProbability": $('#sumProbability').val()
            /*
            "sendReqNum": $('#sendReqNum').val(),
            "reqDate": $('#reqDate').val(),
            "responseNum": $('#responseNum').val(),
            "responseDate": $('#responseDate').val(),
            "responseNumSendXbbNum": $('#responseNumSendXbbNum').val(),
            "responseNumSendXbbDate": $('#responseNumSendXbbDate').val(),
            "resultAnswerMailNum": $('#resultAnswerMailNum').val(),
            "resultAnswerMailDate": $('#resultAnswerMailDate').val(),
            "xbbVerdictNum": $('#xbbVerdictNum').val(),
            "xbbVerdictDate": $('#xbbVerdictDate').val(),
            "sum": $('#sum').val(),
            "comment": $('#comment').val()*/
        }
        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveIS1",
            dataType: "json",
            async: true,
            contentType: 'application/json',
            success: function (res) {
                $('#closeModalSave').trigger('click');
                searchResultTableIS();
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: '?????????????????? ?????????????????????? ????????????????',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (response) {
                if (typeof response.responseJSON.xbbMailNum != "undefined" && response.responseJSON.xbbMailNum != null && response.responseJSON.xbbMailNum != "" && response.responseJSON.xbbMailNum != "undefined") {
                    $('#xbbMailNumValid').html(response.responseJSON.xbbMailNum).addClass('text-danger');
                    $('#xbbMailNum').addClass('border border-danger')
                } else {
                    $('#xbbMailNum').removeClass('border border-danger');
                    $('#xbbMailNumValid').html('');
                    $('#xbbMailNum').addClass('border border-success');
                }

                if (typeof response.responseJSON.xbbMailDate != "undefined" && response.responseJSON.xbbMailDate != null && response.responseJSON.xbbMailDate != "" && response.responseJSON.xbbMailDate != "undefined") {
                    $('#xbbMailDateValid').html(response.responseJSON.xbbMailDate).addClass('text-danger');
                    $('#xbbMailDate').addClass('border border-danger')
                } else {
                    $('#xbbMailDate').removeClass('border border-danger');
                    $('#xbbMailDateValid').html('');
                    $('#xbbMailDate').addClass('border border-success');
                }

                if (typeof response.responseJSON.orgName != "undefined" && response.responseJSON.orgName != null && response.responseJSON.orgName != "" && response.responseJSON.orgName != "undefined") {
                    $('#orgNameValid').html(response.responseJSON.orgName).addClass('text-danger');
                    $('#orgName').addClass('border border-danger')
                } else {
                    $('#orgName').removeClass('border border-danger');
                    $('#orgNameValid').html('');
                    $('#orgName').addClass('border border-success');
                }

                if (typeof response.responseJSON.hsCode != "undefined" && response.responseJSON.hsCode != null && response.responseJSON.hsCode != "" && response.responseJSON.hsCode != "undefined") {
                    $('#hsCodeValid').html(response.responseJSON.hsCode).addClass('text-danger');
                    $('#hsCode').addClass('border border-danger')
                } else {
                    $('#hsCode').removeClass('border border-danger');
                    $('#hsCodeValid').html('');
                    $('#hsCode').addClass('border border-success');
                }

                if (typeof response.responseJSON.productName != "undefined" && response.responseJSON.productName != null && response.responseJSON.productName != "" && response.responseJSON.productName != "undefined") {
                    $('#productNameValid').html(response.responseJSON.productName).addClass('text-danger');
                    $('#productName').addClass('border border-danger')
                } else {
                    $('#productName').removeClass('border border-danger');
                    $('#productNameValid').html('');
                    $('#productName').addClass('border border-success');
                }

                if (typeof response.responseJSON.sendReqCountryCode != "undefined" && response.responseJSON.sendReqCountryCode != null && response.responseJSON.sendReqCountryCode != "" && response.responseJSON.sendReqCountryCode != "undefined") {
                    $('#sendReqCountryCodeValid').html(response.responseJSON.sendReqCountryCode).addClass('text-danger');
                    $('#sendReqCountryCode').addClass('border border-danger')
                } else {
                    $('#sendReqCountryCode').removeClass('border border-danger');
                    $('#sendReqCountryCodeValid').html('');
                    $('#sendReqCountryCode').addClass('border border-success');
                }

                if (typeof response.responseJSON.directionTypeSave != "undefined" && response.responseJSON.directionTypeSave != null && response.responseJSON.directionTypeSave != "" && response.responseJSON.directionTypeSave != "undefined") {
                    $('#directionTypeSaveValid').html(response.responseJSON.directionTypeSave).addClass('text-danger');
                    $('#directionTypeSave').addClass('border border-danger')
                } else {
                    $('#directionTypeSave').removeClass('border border-danger');
                    $('#directionTypeSaveValid').html('');
                    $('#directionTypeSave').addClass('border border-success');
                }

                if (typeof response.responseJSON.sumProbability != "undefined" && response.responseJSON.sumProbability != null && response.responseJSON.sumProbability != "" && response.responseJSON.sumProbability != "undefined") {
                    $('#sumProbabilityValid').html(response.responseJSON.sumProbability).addClass('text-danger');
                    $('#sumProbability').addClass('border border-danger')
                } else {
                    $('#sumProbability').removeClass('border border-danger');
                    $('#sumProbabilityValid').html('');
                    $('#sumProbability').addClass('border border-success');
                }
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: '??????????????!',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }
    function reset(x) {
        // document.getElementById("userLocationCodeS1").value = '';
        document.getElementById("directionTypeCode").value = '';
        document.getElementById("sendReqCountryCodeS").value = '';
        document.getElementById("statusS").value = '';
        // document.getElementById("executiveTerritoryCodeS").value = '';
    }
    function resetS(x) {
        document.getElementById("userLocationCodeS1").value = '';
        document.getElementById("directionTypeCode").value = '';
        document.getElementById("sendReqCountryCodeS").value = '';
        document.getElementById("statusS").value = '';
        document.getElementById("executiveTerritoryCodeS").value = '';
    }
    function resetModal() {
        document.getElementById("xbbMailNum").value = '';
        document.getElementById("xbbMailDate").value = '';
        document.getElementById("orgName").value = '';
        document.getElementById("hsCode").value = '';
        document.getElementById("productName").value = '';
        document.getElementById("sendReqCountryCode").value = '';
    }
    function  resetFilterOoTable(x) {
        document.getElementById("userLocationCodeS").value = '';
        document.getElementById("savedUserFirstS").value = '';
        document.getElementById("xbbMailDateS").value = '';
        document.getElementById("xbbMailNumS").value = '';
        document.getElementById("orgNameS").value = '';
        document.getElementById("hsCodeS").value = '';
        document.getElementById("productNameS").value = '';
        document.getElementById("sendReqCountryCodeS").value = '';
        document.getElementById("sumProbabilityS").value = '';
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
        // document.getElementById("executiveTerritoryCode").value = '';
        // document.getElementById("status").value = '';
        document.getElementById("commentS").value = '';
        document.getElementById("fabulaS").value = '';
        searchResultTableIS();
    }
    function report(x){
        var Fs = $('#FromStart').val();
        var Te = $('#ToEnd').val();
        if (Fs === "undefined" && Fs == null && Fs === ""){
            Te = DateTime.date
        }
        if (Fs !== "undefined" && Fs != null && Fs !== "" && Fs !== "undefined") {
            window.location = "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/getReport/" + x + "/"+Fs + "/"+ Te;
            $('#FromStartValid').html('').removeClass('border border-danger');
        } else {
            $('#FromStartValid').html("?????????????????? ???????? ?????????????????????? ??????????!").addClass('text-danger');
            $('#FromStart').addClass('border border-danger')
        }

        <%--location.href = "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/getReport/" + x + "/"+Fs + "/"+ Te--%>


        <%--$.ajax({--%>
        <%--    type: "GET",--%>
        <%--    // data: dataS,--%>
        <%--    url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/getReport/" + x + "/"+Fs + "/"+ Te,--%>
        <%--    dataType: "html",--%>
        <%--    header: 'Content-type: text/html; charset=utf-8',--%>
        <%--    success: function (res) {--%>

        <%--        // $('div#ListCMTable').html(res);--%>
        <%--        // $('div#divRowCount').css({'display': ''});--%>
        <%--        // $('#loaderII').addClass('visually-hidden');--%>
        <%--    },--%>
        <%--    error: function (res) {--%>
        <%--        setTimeout(()=>{--%>
        <%--            $('#loaderII').addClass('visually-hidden')--%>
        <%--        },1000)--%>
        <%--    }--%>
        <%--});--%>
    }
</script>
<script src="<%=request.getContextPath()%>/resources/js/swalSweetalert.js"></script>
</body>