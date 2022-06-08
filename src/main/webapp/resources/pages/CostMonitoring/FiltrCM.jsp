<%@ page import="java.util.Date" %>
<%@ page import="uz.customs.customsprice.utils.Utils" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
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

    String gdvipdate1 = Utils.tecDate00();
    String gdvipdate2 = Utils.tecDate00();
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
    gdvipdate1 = Utils.toDate00(yesterday);

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
    <link href="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery-3.5.1.js"></script>
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
    <%--    <link rel="stylesheet" href="https://path/to/font-awesome/css/font-awesome.min.css">--%>
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
    <style>
        @-webkit-keyframes scroll {
            0% {
                -webkit-transform: translate(0, 0);
                transform: translate(0, 0);
            }
            100% {
                -webkit-transform: translate(-100%, 0);
                transform: translate(-100%, 0)
            }
        }

        @-moz-keyframes scroll {
            0% {
                -moz-transform: translate(0, 0);
                transform: translate(0, 0);
            }
            100% {
                -moz-transform: translate(-100%, 0);
                transform: translate(-100%, 0)
            }
        }


        @keyframes scroll {
            0% {
                transform: translate(0, 0);
            }
            100% {
                transform: translate(-100%, 0)
            }
        }


        .marquee {
            display: block;
            width: 100%;
            white-space: nowrap;
            overflow: hidden;
        }

        .marquee span {
            color: #0a58ca;
            display: inline-block;
            padding-left: 100%;
            -webkit-animation: scroll 5s infinite linear;
            -moz-animation: scroll 5s infinite linear;
            animation: scroll 35s infinite linear;
        }
    </style>
    <span style="cursor: pointer"><a href="#" class="text-success">БОШ САХИФА</a> / </span></span><span class=""><b>ҚИЙМАТ МОНИТОРИНГИ</b></span> <span>    <h6 class="marquee"><span>Ушбу ойнада акс этадиган маълумотлар Божхона қиймати учун асос сифатида фойдаланиладиган нарх маълумотлари тўпламига киради. Ушбу нархлардан божхона қийматини таққослаш мақсадида фойдаланиш мумкун.</span></h6>
</span>
    <hr class="mt-0"><!--start email wrapper-->

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
<%--                                <option value="">--- Танланг ---</option>--%>
                                <c:forEach var="locations" items="${locationList}" varStatus="i">
                                    <option value="${locations.id}">${locations.id} - ${locations.name1}</option>
                                </c:forEach>
                                <%--                                    <c:if test="${locations.id == '1701'}">selected="selected"</c:if>--%>
                            </select>
                            <script>
                                // if ($('#locationId').val() == '1701') {
                                //     alert($('#locationId').val());
                                //     $('#locationId').attr('selected', true);
                                // }
                                $('#locationId').val('1701');
                            </script>
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
                                <label class="">БЮД рақами</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Рўйхат рақами" id="g7c">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Божхона қиймати усули</label>
                            <select class="form-select shadow-sm" required="" style="font-style: italic" id="metod_otc">
                                <option value="">--- Танланг ---</option>
                                <%--                                <c:forEach var="vals" items="${methodList}" varStatus="i">--%>
                                <%--                                    <option value="${vals.id}">${i.index+1}-усул (${vals.name})</option>--%>
                                <%--                                </c:forEach>--%>
                                <%--                                <option value="0">Все</option>--%>
                                <option value="1">1-усул</option>
                                <option value="4">4-усул</option>
                                <option value="5">5-усул</option>
                                <option value="6.1">6.1-усул</option>
                                <%--                                <option value="6.2">6.2</option>--%>
                                <%--                                <option value="6.3">6.3</option>--%>
                                                                <option value="6.4">6.4-усул</option>
                                                                <option value="6.5">6.5-усул</option>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <label class="">Транспорт тури</label>
                            <select class="form-select shadow-sm" required="" id="g25">
                                <option value="">--- Танланг ---</option>
                                <c:forEach var="vals" items="${transportSList}" varStatus="i">
                                    <option value="${vals.code}">${vals.code} - ${vals.cdShortNm}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">СТИР(Импортёр)</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="СТИР(Импортёр)" id="g8code2">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Етказиб бериш шарти</label>
                                <select class="form-select shadow-sm" id="g20b" required="">
                                    <option value="">--- Танланг ---</option>
                                    <c:forEach var="vals" items="${termsList}" varStatus="i">
                                        <option value="${vals.raqam}">${vals.raqam} - ${vals.sign}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Етказиб бериш географик пункти</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Етказиб бериш географик пункти" id="g20name">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Товар номи</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар номи" id="g31name">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label class="">Сана(дан)</label>
                                <input class="result form-control shadow-sm" type="date" id="gdvipdate1" value="<%=gdvipdate1%>">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <div class="">
                                <label>Сана(гача)</label>
                                <input class="result form-control shadow-sm" type="date" id="gdvipdate2" value="<%=gdvipdate2%>">
                            </div>
                        </div>
                        <div class="col-md-2 m-2">
                            <button type="button" class="btn btn-primary btn-block mt-3" onclick="searchResultTableCM(0)"><i class='bx bx-refresh'></i>Излаш</button>
                            <button type="reset" class="btn btn-primary btn-block mt-3"><i class='bx bx-eraser'></i>Тозалаш</button>
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

    function searchResultTableCM(x) {
        var log_f = true;
        var log_n = '';
        var arr = [];
        var gtk = 0, err = 1;

        // if ($('#locationId').val() != "1701" && $('#postId').val() != "" && $('#g7c').val() != "") {
        //     err = 0;
        // }
        if (err != 0 && (
            ($.trim($('#g33').val()) == null || $.trim($('#g33').val()) == "" || $.trim($('#g33').val()).length < 4) &&
            ($.trim($('#g31name').val()) == null || $.trim($('#g31name').val()) == "" || $.trim($('#g31name').val()).length < 5)
        )) {
            gtk = 0;
            $('#g33').css({'border': '3px solid red'});
            $('#g31name').css({'border': '3px solid red'});
        } else {
            gtk = 1;
            $('#g33').css({'border': '1px solid black'});
            $('#g31name').css({'border': '1px solid black'});
        }

        var dataS = {
            "locationId": $('#locationId').val(),
            "postId": $('#postId').val(),
            "gdvipdate1": $('#gdvipdate1').val(),
            "gdvipdate2": $('#gdvipdate2').val(),
            "g11": $('#g11').val(),
            "g15": $('#g15').val(),
            "g34": $('#g34').val(),
            "g33": $('#g33').val(),
            "g31name": $('#g31name').val(),
            "g25": $('#g25').val(),
            "g8code2": $('#g8code2').val(),
            "metod_otc": $('#metod_otc').val(),
            "g20b": $('#g20b').val(),
            "g20name": $('#g20name').val(),
            "g7c": $('#g7c').val()
        }

        if (gtk === 1) {
            <%--$.ajax({--%>
            <%--    // type: "POST",--%>
            <%--    // type: "POST",--%>
            <%--    // type: "POST",--%>
            <%--    type: "GET",--%>
            <%--    data: dataS,--%>
            <%--    &lt;%&ndash;url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",&ndash;%&gt;--%>
            <%--    &lt;%&ndash;url: "<%=request.getContextPath()%>/costmonitoring/resources/pages/CostMonitoring/ResultCM",&ndash;%&gt;--%>
            <%--    &lt;%&ndash;url: "<%=request.getContextPath()%>/costmonitoring/resources/pages/CostMonitoring/ResultCM",&ndash;%&gt;--%>
            <%--    &lt;%&ndash;url: "<%=request.getContextPath()%>/costmonitoring/resources/pages/CostMonitoring/ResultCM",&ndash;%&gt;--%>
            <%--    url: "<%=request.getContextPath()%>/costmonitoring/server_side/pagination",--%>
            <%--    dataType: "html",--%>
            <%--    header: 'Content-type: text/html; charset=utf-8',--%>
            <%--    success: function (res) {--%>
            <%--        $('div#ListCMTable').html(res);--%>
            <%--    },--%>
            <%--    error: function (res) {--%>
            <%--    }--%>
            <%--});--%>
            $.ajax({
                type: "GET",
                url: "<%=request.getContextPath()%>/costmonitoring/resultCM",
                dataType: "html",
                header: 'Content-type: text/html; charset=utf-8',
                success: function (res) {
                    $('div#ListCMTable').html(res);

                },
                error: function (res) {
                }
            });
        }
    }

</script>
</body>




