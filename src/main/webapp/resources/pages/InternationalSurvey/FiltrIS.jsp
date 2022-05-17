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
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 18px;}
    }
</style>
<div id="mySidenav" class="sidenav">
    <div id="openInPdf">
        <!--PDF open here-->
    </div>
</div>
<!--start page wrapper -->
<div id="main" class="page-content">
    <h6 class="mb-0 text-uppercase">ХАЛҚАРО СЎРОВНОМА</h6>
    <hr>
    <!--start email wrapper-->

    <!--end email wrapper-->
    <div class="col-12 col-lg-12 shadow">

        <div class="card">
            <div class="fm-search m-3">
                <div class="mb-0">
                    <div class="row">
                        <div class="col-md-2 m-2">
                            <label class="">Хат рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ҲББ томонидан юбоирлган хат рақами"></i>
                            <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ҲББ томонидан юбоирлган хат санаси"></i>
                            <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">ТИФ ТН код</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ТИФ ТН код"></i>
                            <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Товар номи</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Товар номи"></i>
                            <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Сўровнома юборилган давлат</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровнома юборилган давлат"></i>
                            <select class="form-select shadow-sm" required="">
                                <option selected="" disabled="disabled" value=""><p class="text-muted">Ариза мақоми</p></option>
                                <option value="100">1701 ГТК Руз</option>
                                <option value="110">1726 Тошкент шахар</option>
                                <option value="145">1756 Андижон</option>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Юборилган сўровнома рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Юборилган сўровнома рақами"></i>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                            </div>
                        </div>

                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Юборилган сўровнома санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Юборилган сўровнома санаси"></i>
                                <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Сўровномага олинган жавоб хати</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровномага олинган жавоб хати"></i>
                            <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Олинган жавоб хати санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровномага олинган жавоб хати санаси"></i>
                            <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">ХББга юборилган хат рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровномага олинган жавоб хатини ҲББга юборилган хат рақами"></i>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">ҲББга юборилган хат санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровномага олинган жавоб хатини ҲББга юборилган хат санаси"></i>
                                <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Натижаси бўйича жавоб хати рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровнома натижаси бўйича жавоб хати рақами"></i>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Натижаси бўйича жавоб хати санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="Сўровнома натижаси бўйича жавоб хати санаси"></i>
                                <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">ҲББ хулоса рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ҲББ хулоса рақами"></i>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label>ҲББ хулоса санаси</label><i class="bx bx-info-circle" data-bs-toggle="tooltip" data-bs-placement="top" title="ҲББ хулоса санаси"></i>
                                <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-3 m-3">
                            <button type="button" class="btn btn-primary btn-block mt-3" onclick="searchResultTableIS(0)"><i class='bx bx-refresh'></i>Излаш</button>
                            <button type="reset" class="btn btn-primary btn-block mt-3"><i class='bx bx-trash'></i>Янгилаш</button>
                            <button type="button" class="btn btn-primary btn-block mt-3" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class='bx bx-plus'></i>Киритиш</button>
                        </div>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-xl col-md-12">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Халқаро сўровнома киритиш</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body row">
                                        <!--todo 1-bosqich-->
                                        <div class="form-group col-md-3">
                                            <label  class="col-form-label text-primary">ҲББ томонидан юбоирлган хат рақами:</label>
                                            <input  class="form-control was-validated" type="number"  id="xbbMailNum"  name="xbbMailNum">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label  class="col-form-label text-primary">ҲББ томонидан юбоирлган хат санаси:</label>
                                            <input  class="form-control was-validated" type="date" id="xbbMailDate"  name="xbbMailDate">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label  class="col-form-label text-primary">Ташкилот номи:</label>
                                            <input  class="form-control was-validated" type="text" id="orgName"  name="orgName">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label  class="col-form-label text-primary">ТИФ ТН код:</label>
                                            <input  class="form-control was-validated" type="number" id="hsCode"  name="hsCode">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label  class="col-form-label text-primary">Товар номи:</label>
                                            <input  class="form-control was-validated" type="text" id="productName"  name="productName">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label  class="col-form-label text-primary">Сўровнома юборилган давлат:</label>
                                            <select  class="form-control was-validated" type="text" id="sendReqCountryCode"  name="sendReqCountryCode">
                                                <option value="">--- Танланг ---</option>
                                                <c:forEach var="vals" items="${countryList}" varStatus="i">
                                                    <option value="${vals.code}">${vals.code} - ${vals.cdNm}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
<%--                                        <!--todo 2-bosqich-->--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Юборилган сўровнома рақами:</label>--%>
<%--                                            <input  class="form-control was-validated" type="number" id="sendReqNum"  name="sendReqNum">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Юборилган сўровнома санаси:</label>--%>
<%--                                            <input  class="form-control was-validated" type="date" id="reqDate" name="reqDate">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Сўровномага олинган жавоб хати	:</label>--%>
<%--                                            <input  class="form-control was-validated" type="number" id="responseNum"  name="responseNum">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Сўровномага олинган жавоб хати санаси:</label>--%>
<%--                                            <input  class="form-control was-validated" type="date" id="responseDate"  name="responseDate">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Сўровномага олинган жавоб хатини ҲББга юборилган хат рақами:</label>--%>
<%--                                            <input  class="form-control was-validated" type="number" id="responseNumSendXbbNum" name="responseNumSendXbbNum">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Сўровномага олинган жавоб хатини ҲББга юборилган хат санаси:</label>--%>
<%--                                            <input  class="form-control was-validated" type="date" id="responseNumSendXbbDate"  name="responseNumSendXbbDate">--%>
<%--                                        </div>--%>
<%--                                        <!--todo 3-bosqich-->--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Сўровнома натижаси бўйича жавоб хати рақами:</label>--%>
<%--                                            <input  class="form-control was-validated" type="number" id="resultAnswerMailNum" name="resultAnswerMailNum">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Сўровнома натижаси бўйича жавоб хати санаси:</label>--%>
<%--                                            <input  class="form-control was-validated" type="date" id="resultAnswerMailDate"  name="resultAnswerMailDate">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">ҲББ хулоса рақами:</label>--%>
<%--                                            <input  class="form-control was-validated" type="number" id="xbbVerdictNum" name="xbbVerdictNum">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">ҲББ хулоса санаси:</label>--%>
<%--                                            <input  class="form-control was-validated" type="date" id="xbbVerdictDate"  name="xbbVerdictDate">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Камомад суммаси:</label>--%>
<%--                                            <input  class="form-control was-validated" type="number" id="sum"  name="sum">--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group col-md-3">--%>
<%--                                            <label  class="col-form-label text-primary">Изох:</label>--%>
<%--                                            <input  class="form-control was-validated" type="text" id="comment"  name="comment">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" onclick="saveValueFromInput()">Сақлаш</button>
                                    </div>

                                </div>
                            </div>
                        </div>
<%--                        <div class="col-md-2 m-2">--%>
<%--                            <button type="button" class="btn btn-primary btn-block mt-3" onclick="searchResultTable(0)"><i class='bx bx-refresh'></i>Янгилаш</button>--%>
<%--                        </div>--%>
                    </div>
<%--                    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>--%>
                </div>
            </div>
            <hr>
            <div class="card-body" id="ListCMTable" style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important;">
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

    function searchResultTableIS(x) {
        var dataS = {
            "x": x,
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/ResultIS",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListCMTable').html(res);
            },
            error: function (res) {
            }
        });
    }



    function saveValueFromInput() {
        alert("sdsdsdad")
        var dataS = {
            "xbbMailNum": $('#xbbMailNum').val(),
            "xbbMailDate": $('#xbbMailDate').val(),
            "orgName": $('#orgName').val(),
            "hsCode": $('#hsCode').val(),
            "productName": $('#productName').val(),
            "sendReqCountryCode": $('#sendReqCountryCode').val()/*,
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
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveIS",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListCMTable').html(res);
            },
            error: function (res) {
            }
        });
    }

</script>
</body>
