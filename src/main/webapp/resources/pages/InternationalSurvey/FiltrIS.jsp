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
    <span style="cursor: pointer"><a href="#" class="text-success">БОШ САХИФА</a> / </span></span><span class=""><b>ХАЛҚАРО СЎРОВНОМА</b></span>
    <hr>
    <div class="col-12 col-lg-12 shadow">
        <div class="card">
            <div class="fm-search mt-2 mb-1 ml-3 mr-3">
                <div class="mb-0">
                    <div class="row m-3">
                        <div class="row">
                            <div class="col-md-3">
                                <label class="">Йўналиш</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Халқаро сўровнома йўналиш тури"></i>
                                <select class="form-select" type="text" id="directionTypeCode" name="directionTypeCode">
                                    <option class="font-italic" selected value="">--- Танланг ---</option>
                                    <c:forEach var="dirTyp" items="${directionType}" varStatus="i">
                                        <option value="${dirTyp.code}">${dirTyp.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>Cўровнома холати</label>
                                <select class="form-select" id="statusS" name="statusS"/>
                                <option value="">--Танланг--</option>
                                <option value="100">Янги</option>
                                <option value="200">Жараёнда</option>
                                <option value="300">Якунланган</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="">Сўровнома юборилган давлат</label><i class="bx bx-info-circle"
                                                                                     data-bs-toggle="tooltip"
                                                                                     data-bs-placement="top"
                                                                                     title="Сўровнома юборилган давлат"></i>
                                <select class="form-select shadow-sm" id="sendReqCountryCodeS"
                                        name="sendReqCountryCodeS" required=""/>
                                <option value="">--Танланг--</option>
                                <c:forEach var="countr" items="${countryList}">
                                    <option value="${countr.code}">${countr.cdNm}</option>
                                </c:forEach>
                                </select>
                            </div>
                            <c:if test="${userLocation == '1701'}">
                                <div class="col-md-3">
                                    <label class="">Таркибий тузилма</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Таркибий тузилмалар"></i>
                                    <select class="result form-select shadow-sm" type="text" id="userLocationCode" name="userLocationCode">
                                        <option class="font-italic" selected value="">--- Танланг ---</option>
                                        <c:forEach var="usrLoc" items="${location}" varStatus="i">
                                            <option value="${usrLoc.id}">${usrLoc.name1}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label class="">Маъсул худуд</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Маъсул худуд"></i>
                                    <select class="result form-select shadow-sm" type="text" id="executiveTerritoryCodeS" name="executiveTerritoryCodeS">
                                        <option class="font-italic" selected value="">--- Танланг ---</option>
                                        <c:forEach var="usrLoc" items="${location}" varStatus="i">
                                            <option value="${usrLoc.id}">${usrLoc.name1}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:if>
                            <div class="col-md-3">
                                <button type="button" class="btn btn-primary btn-block mt-3"
                                        onclick="searchResultTableISFirst(0)"><i class='bx bx-refresh'></i>Излаш
                                </button>
                                <button type="reset" class="btn btn-primary btn-block mt-3" onclick="reset(1)">
                                    <i class='bx bx-trash'></i>
                                </button>
                                <c:if test="${userRole == '8' || userRole == '7' || userRole == '6' || userRole == '4'}">
                                    <button type="button" class="btn btn-primary btn-block mt-3"
                                            class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                            onclick="resetModal()"><i class='bx bx-plus'></i>Киритиш
                                    </button>
                                </c:if>
                            </div>
                            <div id="target" name="target"></div>
                            <!--<div class="col">
                                <label class="">Хат рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ҲББ томонидан юбоирлган хат рақами"></i>
                                <input class="result form-control shadow-sm" type="text" id="xbbMailNumS" value="" name="xbbMailNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
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
                            </div>-->
                        </div>
                        <div class="row">
                            <!--<div class="col">
                                <label class="">Товар номи</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                                     data-bs-placement="top" title="Товар номи"></i>
                                <input class="result form-control shadow-sm" type="text" id="productNameS"
                                       name="productNameS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>-->
                            <!--<div class="col">
                                <div class="">
                                    <label class="">Юборилган сўровнома рақами</label><i class="bx bx-info-circle"
                                                                                         data-bs-toggle="tooltip"
                                                                                         data-bs-placement="top"
                                                                                         title="Юборилган сўровнома рақами"></i>
                                    <input class="result form-control shadow-sm" type="text" id="sendReqNumS"
                                           name="sendReqNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>
                            <div class="col">
                                <div class="">
                                    <label class="">Юборилган сўровнома санаси</label><i class="bx bx-info-circle"
                                                                                         data-bs-toggle="tooltip"
                                                                                         data-bs-placement="top"
                                                                                         title="Юборилган сўровнома санаси"></i>
                                    <input class="result form-control shadow-sm" type="date" id="reqDateS"
                                           name="reqDateS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>
                            <div class="col">
                                <label class="">Сўровномага олинган жавоб хати</label><i class="bx bx-info-circle"
                                                                                         data-bs-toggle="tooltip"
                                                                                         data-bs-placement="top"
                                                                                         title="Сўровномага олинган жавоб хати"></i>
                                <input class="result form-control shadow-sm" type="text" id="responseNumS"
                                       name="responseNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>-->
                        </div>
                        <div class="row">
                            <!--<div class="col">
                                <label class="">Олинган жавоб хати санаси</label><i class="bx bx-info-circle"
                                                                                    data-bs-toggle="tooltip"
                                                                                    data-bs-placement="top"
                                                                                    title="Сўровномага олинган жавоб хати санаси"></i>
                                <input class="result form-control shadow-sm" type="date" id="responseDateS"
                                       name="responseDateS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                            </div>
                            <div class="col">
                                <div class="">
                                    <label class="">ХББга юборилган хат рақами</label><i class="bx bx-info-circle"
                                                                                         data-bs-toggle="tooltip"
                                                                                         data-bs-placement="top"
                                                                                         title="Сўровномага олинган жавоб хатини ҲББга юборилган хат рақами"></i>
                                    <input class="result form-control shadow-sm" type="text" id="responseNumSendXbbNumS"
                                           name="responseNumSendXbbNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>
                            <div class="col">
                                <div class="">
                                    <label class="">ҲББга юборилган хат санаси</label><i class="bx bx-info-circle"
                                                                                         data-bs-toggle="tooltip"
                                                                                         data-bs-placement="top"
                                                                                         title="Сўровномага олинган жавоб хатини ҲББга юборилган хат санаси"></i>
                                    <input class="result form-control shadow-sm" type="date"
                                           id="responseNumSendXbbDateS" name="responseNumSendXbbDateS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>
                            <div class="col">
                                <div class="">
                                    <label class="">Натижаси бўйича жавоб хати рақами</label><i
                                        class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top"
                                        title="Сўровнома натижаси бўйича жавоб хати рақами"></i>
                                    <input class="result form-control shadow-sm" type="text" id="resultAnswerMailNumS"
                                           name="resultAnswerMailNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>
                            <div class="col">
                                <div class="">
                                    <label class="">Натижаси бўйича жавоб хати санаси</label><i
                                        class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top"
                                        title="Сўровнома натижаси бўйича жавоб хати санаси"></i>
                                    <input class="result form-control shadow-sm" type="date" id="resultAnswerMailDateS"
                                           name="resultAnswerMailDateS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>-->
                        </div>
                        <div class="row">
                            <!--<div class="col">
                                <div class="">
                                    <label class="">ҲББ хулоса рақами</label><i class="bx bx-info-circle"
                                                                                data-bs-toggle="tooltip"
                                                                                data-bs-placement="top"
                                                                                title="ҲББ хулоса рақами"></i>
                                    <input class="result form-control shadow-sm" type="text" id="xbbVerdictNumS"
                                           name="xbbVerdictNumS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>
                            <div class="col">
                                <div class="">
                                    <label>ҲББ хулоса санаси</label><i class="bx bx-info-circle"
                                                                       data-bs-toggle="tooltip" data-bs-placement="top"
                                                                       title="ҲББ хулоса санаси"></i>
                                    <input class="result form-control shadow-sm" type="date" id="xbbVerdictDateS"
                                           name="xbbVerdictDateS" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
                                </div>
                            </div>-->


                        </div>
                        <!-- Modal 1-qadam-->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-xl col-md-12">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Халқаро сўровнома киритиш</h5>
                                        <button type="button" class="btn-close" id="closeModalSave"
                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body row">
                                        <!--todo 1-bosqich-->
                                        <form class="row g-3 needs-validation">
                                            <c:if test="${userLocation != '1701'}">
                                                <div class="form-group col-md-3">
                                                    <label for="xbbMailNum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>ҲББ томонидан юбоирлган хат рақами:</label>
                                                    <input class="form-control" type="text" id="xbbMailNum" name="xbbMailNum">
                                                    <div class="valid-feedback">Текширилди</div>
                                                    <div class="" id="xbbMailNumValid"></div>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="xbbMailNum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>ҲББ томонидан юбоирлган хат санаси:</label>
                                                    <input class="form-control" type="date" id="xbbMailDate" name="xbbMailDate">
                                                    <div class="valid-feedback">Текширилди</div>
                                                    <div class="" id="xbbMailDateValid"></div>
                                                </div>
                                            </c:if>

                                            <div class="form-group col-md-3">
                                                <label for="orgName" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Ташкилот
                                                    номи:</label>
                                                <input class="form-control was-validated" type="text" id="orgName"
                                                       name="orgName">
                                                <div class="valid-feedback">Текширилди</div>
                                                <div class="" id="orgNameValid"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="hsCode" class="form-label text-primary"><span class="text-danger">&#x2734;</span>ТИФ ТН код:</label>
                                                <input class="form-control" type="text" id="hsCode" name="hsCode">
                                                <div class="valid-feedback">Текширилди</div>
                                                <div class="" id="hsCodeValid"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="productName" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Товар
                                                    номи:</label>
                                                <input class="form-control" type="text" id="productName"
                                                       name="productName">
                                                <div class="valid-feedback">Текширилди</div>
                                                <div class="" id="productNameValid"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="sendReqCountryCode" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Сўровнома юборилган давлат:</label>
                                                <select class="form-control" type="text" id="sendReqCountryCode" name="sendReqCountryCode">
                                                    <option class="font-italic" selected value="">--- Танланг ---</option>
                                                    <c:forEach var="vals" items="${countryList}" varStatus="i">
                                                        <option value="${vals.code}">${vals.code}- ${vals.cdNm}</option>
                                                    </c:forEach>
                                                </select>
                                                <div class="valid-feedback">Текширилди</div>
                                                <div class="" id="sendReqCountryCodeValid"></div>
                                            </div>

                                            <div class="form-group col-md-3">
                                                <label for="sendReqCountryCode" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Йўналиш:</label>
                                                <select class="form-control" type="text" id="directionTypeSave" name="sendReqCountryCode">
                                                    <option class="font-italic" selected value="">--- Танланг ---</option>
                                                    <c:forEach var="dirTyp" items="${directionType}" varStatus="i">
                                                        <option value="${dirTyp.code}">${dirTyp.name}</option>
                                                    </c:forEach>
                                                </select>
                                                <div class="valid-feedback">Текширилди</div>
                                                <div class="" id="directionTypeSaveValid"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="productName" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Эхтимол.қўшим хисобланган (cўмда):</label>
                                                <input class="form-control" type="text" id="sumProbability"
                                                       name="sumProbability">
                                                <div class="valid-feedback">Текширилди</div>
                                                <div class="" id="sumProbabilityValid"></div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary"
                                                        onclick="saveValueFromInputS()">Сақлаш
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
            <div class="card-body" id="ListCMTable" style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important; padding: 0rem 1rem!important;">
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
            // "userLocationCode": $("#userLocationCode").val(),
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
                setTimeout(()=>{
                    $('#loaderII').addClass('visually-hidden')
                },1000)
            }
        });

    }
    function searchResultTableIS(x, root = null) {
        $('#loaderII').removeClass('visually-hidden')
        if (root) root.preventDefault();
        var dataS = {
            "userLocationCode": $("#userLocationCode").val(),
            // "directionTypeCode": $("#directionTypeCode").val(),
            "xbbMailDate": $("#xbbMailDateS").val().toString(),
            "xbbMailNum": $("#xbbMailNumS").val(),
            "hsCode": $("#hsCodeS").val(),
            "productName": $("#productNameS").val(),
            "sendReqCountryCode": $("#sendReqCountryCodeS").val(),
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
                    title: 'Дастлабки маълумотлар сақланди',
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
                    title: 'Хатолик!',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }
    function reset(x) {
        document.getElementById("userLocationCode").value = '';
        document.getElementById("directionTypeCode").value = '';
        document.getElementById("sendReqCountryCodeS").value = '';
        document.getElementById("statusS").value = '';
        document.getElementById("executiveTerritoryCode").value = '';
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