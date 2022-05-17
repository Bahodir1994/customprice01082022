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
    <link rel="stylesheet" href="https://path/to/font-awesome/css/font-awesome.min.css">
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
    <h6 class="mb-0 text-uppercase">Қиймат мониторинги</h6>
    <hr>
    <!--start email wrapper-->

    <!--end email wrapper-->
    <div class="col-12 col-lg-12 shadow">

        <div class="card">
            <div class="fm-search m-3">
                <div class="mb-0">
                    <div class="row">
                        <div class="col-md-2 m-2">
                            <label class="">ХББ</label>
                            <select class="form-select shadow-sm" required="" id="locationId" name="locationId" onchange="changeLocation()">
                                <%-- todo                                <option selected="" disabled="disabled" value=""><p class="text-muted">Ариза мақоми</p></option>--%>
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="locations" items="${locationList}" varStatus="i">
                                    <option value="${locations.id}">${locations.id} - ${locations.name1}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Пост</label>
                            <select class="form-select shadow-sm" required="" id="postId" name="postId">
                                <option value="">--- Танланг ---</option>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Юук жўнатувчи мамлакат</label>
                            <select class="form-select shadow-sm" required="" id="g15" name="g15">
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="vals" items="${countryList}" varStatus="i">
                                    <option value="${vals.code}">${vals.code} - ${vals.cdNm}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Келиб чиқиш мамлакати</label>
                            <select class="form-select shadow-sm" required="" id="g34" name="g34">
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="vals" items="${countryList}" varStatus="i">
                                    <option value="${vals.code}">${vals.code} - ${vals.cdNm}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Савдо қилувчи мамлакат</label>
                            <select class="form-select shadow-sm" required="" id="g11" name="g11">
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="vals" items="${countryList}" varStatus="i">
                                    <option value="${vals.code}">${vals.code} - ${vals.cdNm}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">ТИФ ТН коди</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди" id="g33" name="g33">
                            </div>
                        </div>

                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Рўйхат рақами</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Рўйхат рақами">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Божхона қиймати усули</label>
                            <select class="form-select shadow-sm" required="" style="font-style: italic">
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="vals" items="${methodList}" varStatus="i">
                                    <option value="${vals.id}">${i.index+1}-усул (${vals.name})</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Транспорт тури</label>
                            <select class="form-select shadow-sm" required="" id="">
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="vals" items="${transportTypeSList}" varStatus="i">
                                    <option value="${vals.code}">${vals.cdDesc} ${vals.cdNm}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">СТИР</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="СТИР">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Етказиб бериш шарти</label>
                                <select class="form-select shadow-sm" id="validationTooltip05" required="">
                                    <option value="">--- Танланг ---</option>
                                    <c:forEach var="vals" items="${termsList}" varStatus="i">
                                        <option value="${vals.raqam}">${vals.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Етказиб бериш манзили</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Етказиб бериш манзили">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Товар номи</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар номи">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Сана(дан)</label>
                                <input class="result form-control shadow-sm" type="date" id="gdvipdate1" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label>Сана(гача)</label>
                                <input class="result form-control shadow-sm" type="date" id="gdvipdate2" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <button type="button" class="btn btn-primary btn-block mt-3" onclick="searchResultTableCM(0)"><i class='bx bx-refresh'></i>Излаш</button>
                            <button type="reset" class="btn btn-primary btn-block mt-3"><i class='bx bx-refresh'></i>Янгилаш</button>
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

    function searchResultTableCM(x) {
        var dataS = {
            "locationId": $('#locationId').val(),
            "postId": $('#postId').val(),
            "gdvipdate1": $('#gdvipdate1').val(),
            "gdvipdate2": $('#gdvipdate2').val()
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/costmonitoring/resources/pages/CostMonitoring/ResultCM",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListCMTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function changeLocation() {
        // $("#post").clear();
        var log_f = true;
        var log_n = '';
        var arr = [];
        var arr2 = [];
        var locationId = $('#locationId').val().substr(2, 2);
        // alert(' locationId := ' + locationId);

        var dataS = {
            "locationId": locationId
        }

        if (locationId == null || locationId == '') {
            for (var i = document.getElementById("postId").options.length; i-- > 0;)
                document.getElementById("postId").options[i] = null;
            $("#postId").append('<option value="">--- Танланг ---</option>');
            log_f = false;
        }

        if (log_f) {
            $.ajax({
                type: "POST",
                data: dataS,
                url: "<%=request.getContextPath()%>/costmonitoring/resources/pages/CostMonitoring/FiltrCMPost",
                // dataType: "json",
                header: 'Content-type: application/json; charset=utf-8',
                success: function (res) {
                    // $("#breeds").attr('disabled', false);
                    for (var i = document.getElementById("postId").options.length; i-- > 0;)
                        document.getElementById("postId").options[i] = null;
                    $("#postId").append('<option value="">--- Танланг ---</option>');
                    $.each(res, function (index, value) {
                        console.log("value: " + value)
                        $("#postId").append('<option value=' + value['code'] + '>' + value['code'] + ' - ' + value['cdNm'] + '</option>');
                    });
                },
                error: function (res) {
                }
            });
        }
    }

</script>
</body>
