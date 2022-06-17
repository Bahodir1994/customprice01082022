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
    <span><a style="cursor: pointer" class="text-success" href="#">БОШ САХИФА</a> / </span><span><a style="cursor: pointer;" class="text-success" href="#">Таснифлагич</a> / </span><span><b>БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ</b></span>
    <hr>
    <div class="col-12 col-lg-12 shadow">
        <div class="card">
            <div class="fm-search mt-2 mb-1 ml-3 mr-3">
                <div class="mb-0">
                    <div class="row m-3">
                        <div class="row">
                            <div class="col">
                                <label class="">ҲББ</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                              data-bs-placement="top" title="ҲББ"></i>
                                <select class="form-select shadow-sm" required="" id="locationId" name="locationId"
                                        onchange="changeLocation()">
                                    <option value="">--Танланг--</option>
                                    <c:forEach var="locations" items="${locationList}" varStatus="i">
                                        <option value="${locations.id}">${locations.id} - ${locations.name1}</option>
                                    </c:forEach>
                                </select>
                                <div id="locationIdValid"></div>
                                <%--                                <script>$('#locationId').val('1701');</script>--%>
                            </div>
                            <div class="col">
                                <label class="">Пост</label><i class="bx bx-info-circle"
                                                               data-bs-toggle="tooltip"
                                                               data-bs-placement="top"
                                                               title="Пост"></i>
                                <select class="form-select shadow-sm" id="g7a" name="g7a" required=""/>
                                <option value="">--Танланг--</option>
                                <%--                                <option value="26002">Тошкент товар ТИФ БП</option>--%>
                                </select>
                                <div id="g7aValid"></div>
                            </div>
                            <div class="col">
                                <label class="">Сана</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                               data-bs-placement="top" title="Сана"></i>
                                <input class="result form-control shadow-sm" type="date" id="g7b" name="g7b"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableBYDHistory(0); return false;}"
                                       value="<%=g7b%>" size="10" maxlength="10"/>
                                <div id="g7bValid"></div>
                            </div>
                            <div class="col">
                                <label class="">БЮД рақами</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                                     data-bs-placement="top" title="Номер ГТД"></i>
                                <input class="result form-control shadow-sm" type="number" id="g7c" name="g7c"
                                       value="0046613" size="7" maxlength="7"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableBYDHistory(0); return false;} "/>
                                <div id="g7cValid"></div>
                            </div>
                            <div class="col">
                                <label class="">СТИР</label><i class="bx bx-info-circle" data-bs-toggle="tooltip"
                                                               data-bs-placement="top" title="ИНН"></i>
                                <input class="result form-control shadow-sm" type="number" id="g8code2" name="g8code2" size="9" maxlength="9" onkeypress="if (event.keyCode == 13)
                                {searchResultTableBYDHistory(0); return false;} "/>
                                <div id="g8code2Valid"></div>
                            </div>
                            <div class="col">
                                <label class="">Режим</label><i class="bx bx-info-circle"
                                                                data-bs-toggle="tooltip"
                                                                data-bs-placement="top"
                                                                title="Сўровнома юборилган давлат"></i>
                                <select class="form-select shadow-sm" id="g1b" name="g1b" required=""/>
                                <option value="">--Танланг--</option>
                                <option value="10">ЭК - 10</option>
                                <option value="11">ЭК - 11</option>
                                <option value="12">ЭК - 12</option>
                                <option value="40">ИМ - 40</option>
                                <option value="41">ИМ - 41</option>
                                <option value="42">ИМ - 42</option>
                                <option value="51">ИМ - 51</option>
                                <option value="61">ИМ - 61</option>
                                <option value="70">ИМ - 70</option>
                                <option value="71">ИМ - 71</option>
                                <option value="72">ИМ - 72</option>
                                <option value="73">ИМ - 73</option>
                                <option value="74">ИМ - 74</option>
                                <option value="75">ИМ - 75</option>
                                <option value="76">ИМ - 76</option>
                                <option value="80">ТР - 80</option>
                                </select>
                                <div id="g1bValid"></div>
                            </div>
                            <div class="col mt-2">
                                <button type="button" id="izlash" class="btn btn-outline-primary btn-block mt-2"
                                        onclick="searchResultTableBYDHistory(0)"><i class='bx bx-refresh'></i>Излаш
                                </button>
                                <button type="reset" class="btn btn-outline-primary btn-block mt-2" onclick="resetGTDFilter(1)">
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
        if (root) root.preventDefault();
        // String g7a = "26002";
        // String g7b = "02.06.2022";
        // String g7c = "0046613";

        var log_f = true;
        var log_n = '';
        var arr = [];

        if ($('#locationId').val() == null || $('#locationId').val() == '') {
            $('#locationIdValid').html('ҲББни танланг').addClass('text-danger');
            $('#locationId').addClass('border border-danger')
            log_f = false;
        } else if ($('#locationId').val() == '1701') {
            $('#locationIdValid').html('ҲББ майдонига ДБҚ танланиши мумкин эмас').addClass('text-danger');
            $('#locationId').addClass('border border-danger')
            log_f = false;
        } else {
            $('#locationId').removeClass('border border-danger');
            $('#locationId').addClass('border border-success');
            $('#locationIdValid').html('');
        }

        if ($('#g7a').val() == null || $('#g7a').val() == '') {
            $('#g7aValid').html('Постни танланг').addClass('text-danger');
            $('#g7a').addClass('border border-danger')
            log_f = false;
        } else {
            $('#g7a').removeClass('border border-danger');
            $('#g7a').addClass('border border-success');
            $('#g7aValid').html('');
        }

        if ($('#g7b').val() == null || $('#g7b').val() == '') {
            $('#g7bValid').html('Сана киритинг').addClass('text-danger');
            $('#g7b').addClass('border border-danger')
            log_f = false;
        } else {
            $('#g7b').removeClass('border border-danger');
            $('#g7b').addClass('border border-success');
            $('#g7bValid').html('');
        }

        if ($.trim($('#g7c').val()) == null || $.trim($('#g7c').val()) == '') {
            $('#g7cValid').html('БЮД рақамини киритинг').addClass('text-danger');
            $('#g7c').addClass('border border-danger')
            log_f = false;
        } else if ($.trim($('#g7c').val()).length > 7 || $.trim($('#g7c').val()).length < 7) {
            $('#g7cValid').html('БЮД рақами 7 та сондан иборат бўлиши лозим').addClass('text-danger');
            $('#g7c').addClass('border border-danger')
            log_f = false;
        } else {
            $('#g7c').removeClass('border border-danger');
            $('#g7c').addClass('border border-success');
            $('#g7cValid').html('');
        }

        if ($.trim($('#g8code2').val()) != null && $.trim($('#g8code2').val()) != '') {
            if ($.trim($('#g8code2').val()).length != 9 && $.trim($('#g8code2').val()).length != 14) {
                $('#g8code2Valid').html('СТИР 9 та, ЖШШИР 14 та бўлиши лозим').addClass('text-danger');
                $('#g8code2').addClass('border border-danger')
                log_f = false;
            } else {
                $('#g8code2').removeClass('border border-danger');
                $('#g8code2').addClass('border border-success');
                $('#g8code2Valid').html('');
            }
        } else {
            $('#g8code2').removeClass('border border-danger');
            $('#g8code2').addClass('border border-success');
            $('#g8code2Valid').html('');
        }

        if (log_f) {
            $('#loaderII').removeClass('visually-hidden')
            var dataS = {
                "page": x,
                "size": $("#size").val(),
                "g7a": $("#g7a").val(),
                "g7b": $("#g7b").val(),
                "g7c": $("#g7c").val(),
                "g8code2": $("#g8code2").val(),
                "g1b": $("#g1b").val()
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
        } else return false;
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

    function resetGTDFilter(x) {
        document.getElementById("locationId").value = '';
        document.getElementById("g7a").value = '';
        document.getElementById("g7b").value = '';
        document.getElementById("g7c").value = '';
        document.getElementById("g8code2").value = '';
        document.getElementById("g1b").value = '';
    }
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>