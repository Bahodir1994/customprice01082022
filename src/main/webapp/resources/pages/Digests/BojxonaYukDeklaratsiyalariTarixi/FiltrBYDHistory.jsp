<%@ page import="uz.customs.customsprice.utils.Utils" %>
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
    String g7a = "26002";
//    String g7b = "02.06.2022";
    String g7c = "0046613";
    String g7b = Utils.tecDate00();
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
    <span ><a style="cursor: pointer" class="text-success" href="#">БОШ САХИФА</a> / </span><span><a style="cursor: pointer;" class="text-success" href="#">СПРАВОЧНИК</a> / </span><span><b>БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ</b></span>
    <hr>
    <div class="col-12 col-lg-12 shadow">
        <div class="card">
            <div class="fm-search mt-2 mb-1 ml-3 mr-3">
                <div class="mb-0">
                    <div class="row m-3">
                        <div class="row">
                            <div class="col">
                                <label class="">ХББ</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                              data-bs-placement="top" title="ХББ"></i>
                                <select class="form-select shadow-sm" required="" id="locationId" name="locationId"
                                        onchange="changeLocation()">
                                    <c:forEach var="locations" items="${locationList}" varStatus="i">
                                        <option value="${locations.id}">${locations.id} - ${locations.name1}</option>
                                    </c:forEach>
                                    <%--                                    <option value="1700">СТК Ташкент АЭРО</option>--%>
                                    <%--                                    <option value="1701">ГТК РУз</option>--%>
                                    <%--                                    <option value="1703">Андижанская обл</option>--%>
                                    <%--                                    <option value="1706">Бухарская обл</option>--%>
                                    <%--                                    <option value="1708">Джизакская обл</option>--%>
                                    <%--                                    <option value="1710">Кашкадарьинская обл</option>--%>
                                    <%--                                    <option value="1712">Навоийская обл</option>--%>
                                    <%--                                    <option value="1714">Наманганская обл</option>--%>
                                    <%--                                    <option value="1718">Самаркандская обл</option>--%>
                                    <%--                                    <option value="1722">Сурхандарьинская обл</option>--%>
                                    <%--                                    <option value="1724">Сырдарьинская обл</option>--%>
                                    <%--                                    <option value="1726">г.Ташкент</option>--%>
                                    <%--                                    <option value="1727">Ташкентская обл</option>--%>
                                    <%--                                    <option value="1730">Ферганская обл</option>--%>
                                    <%--                                    <option value="1733">Хорезмская обл</option>--%>
                                    <%--                                    <option value="1735">Республика Каракалпакистан</option>--%>
                                </select>
                                <script>$('#locationId').val('1701');</script>
                            </div>
                            <div class="col">
                                <label class="">Пост</label><i class="bx bx-info-circle"
                                                               data-bs-toggle="tooltip"
                                                               data-bs-placement="top"
                                                               title="Пост"></i>
                                <select class="form-select shadow-sm" id="g7a"
                                        name="g7a" required=""
                                        onkeypress="if (event.keyCode == 13) {searchResultTableBYDHistory(0); return false;} "/>
                                <option value="">--Танланг--</option>
<%--                                <option value="26002">Тошкент товар ТИФ БП</option>--%>
                                </select>
                            </div>
                            <div class="col">
                                <label class="">Сана</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                               data-bs-placement="top" title="Сана"></i>
                                <input class="result form-control shadow-sm" type="date" id="g7b" name="g7b"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableBYDHistory(0); return false;}"
                                       value="<%=g7b%>" size="10" maxlength="10"/>
                            </div>
                            <div class="col">
                                <label class="">Номер ГТД</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" title="Номер ГТД"></i>
                                <input class="result form-control shadow-sm" type="number" id="g7c" name="g7c"
                                       value="0046613" size="7" maxlength="7"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableBYDHistory(0); return false;} "/>
                            </div>
                            <div class="col">
                                <label class="">СТИР</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                               data-bs-placement="top" title="ИНН"></i>
                                <input class="result form-control shadow-sm" type="number" id="Inn" name="Inn" size="9"
                                       maxlength="9"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableBYDHistory(0); return false;} "/>
                            </div>
                            <div class="col">
                                <label class="">Режим</label><i class="bx bx-info-circle"
                                                                data-bs-toggle="tooltip"
                                                                data-bs-placement="top"
                                                                title="Сўровнома юборилган давлат"></i>
                                <select class="form-select shadow-sm" id="sendReqCountryCodeS"
                                        name="sendReqCountryCodeS" required=""
                                        onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} "/>
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
                                    <i class='bx bx-trash'></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div id="loaderII" class="col-md-12 position-absolute top-50 start-50 visually-hidden" role="status"
                 style="z-index: 999999">
                <div class="spinner-border" style="width: 3rem; height: 3rem;" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>
            <div class="card-body" id="ListCMTable"
                 style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important;">
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
        // String g7a = "26002";
        // String g7b = "02.06.2022";
        // String g7c = "0046613";
        var dataS = {
            "page": x,
            "size": $("#size").val(),
            "g7a": $("#g7a").val(),
            "g7b": $("#g7b").val(),
            "g7c": $("#g7c").val()
        }
        $.ajax({
            type: "GET",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/ResultBYDHistory",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                setTimeout(() => {
                    $('div#ListCMTable').html(res);
                    $('div#divRowCount').css({'display': ''});
                    $('#loaderII').addClass('visually-hidden');
                }, 1000)
            },
            error: function (res) {
                setTimeout(() => {
                    $('#loaderII').addClass('visually-hidden')
                }, 1000)
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
            for (var i = document.getElementById("g7a").options.length; i-- > 0;)
                document.getElementById("g7a").options[i] = null;
            $("#g7a").append('<option value="">--- Танланг ---</option>');
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
                    for (var i = document.getElementById("g7a").options.length; i-- > 0;)
                        document.getElementById("g7a").options[i] = null;
                    $("#g7a").append('<option value="">--- Танланг ---</option>');
                    $.each(res, function (index, value) {
                        console.log("value: " + value)
                        $("#g7a").append('<option value=' + value['code'] + '>' + value['code'] + ' - ' + value['cdNm'] + '</option>');
                    });
                },
                error: function (res) {
                }
            });
        }
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