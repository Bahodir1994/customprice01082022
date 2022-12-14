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
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
</head>
<body>
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
        border-right: #0a58ca;
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
        color: #090909;
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
<div id="modalPdfLC" class="sidenav border border-bottom-0 border-top-0 border-primary mr-3">
    <div id="openInPdfLC">
        <!--PDF open here-->
    </div>
</div>

<div id="bodyLc" class="page-content">
    <span style="cursor: pointer"><a href="#" class="text-success">?????? ????????????</a> / </span></span><span class=""><b>???????????????? ??????????????</b></span>
    <hr>
    <div class="col-12 col-lg-12 shadow">

        <div class="card">
            <div class="fm-search m-3">
                <div class="mb-0">
                    <div class="row">
                        <div class="col-md-2 mt-2 mb-2">
                            <div class="col">
                                <label class="">????????????</label>
                                <input class="result form-control shadow-sm" type="text" id="flkNum" name="flkNum"
                                       placeholder="???????????????? ?????????????? ????????????"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableLC(0); return false;} "/>
                            </div>
                        </div>
                        <div class="col-md-4 mt-2 mb-2">
                            <div class="col">
                                <label class="">????????</label>
                                <input class="result form-control shadow-sm" type="text" id="flkName" name="flkName"
                                       placeholder="???????????????? ?????????????? ????????"
                                       onkeypress="if (event.keyCode == 13) {searchResultTableLC(0); return false;} ">
                            </div>
                        </div>
                        <div class="col-md-2 mt-2 mb-2">
                            <div class="col">
                                <label class="">????????(??????)</label>
                                <input class="result form-control shadow-sm" type="date" id="Dfrom" name="Dfrom"
                                       placeholder="??????-????-??????">
                            </div>
                        </div>
                        <div class="col-md-2 mt-2 mb-2">
                            <div class="col">
                                <label>????????(????????)</label>
                                <input class="result form-control shadow-sm" type="date" id="Dtoo" name="Dtoo" placeholder="??????-????-??????">
                            </div>
                        </div>
                        <div class="col-md-2 mt-2 mb-2">
                            <button type="button" class="btn btn-primary mt-3 btn-block" onclick="searchResultTableLC(0)"><i class='bx bx-refresh'></i>??????????</button>
                            <button type="button" class="btn btn-primary mt-3 btn-block" onclick="clearForm(0)"><i class='bx bx-trash'></i>??????????????</button>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div id="loaderII" class="col-md-12 position-absolute top-50 start-50 visually-hidden" role="status" style="z-index: 999999">
                <div class="spinner-border" style="width: 3rem; height: 3rem;" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>
            <div class="card-body" id="ListLCTable" style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important;">

            </div>
        </div>
    </div>
</div>
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
    function searchResultTableLC(x) {
        $('#loaderII').removeClass('visually-hidden')
        var dataS = {
            "flkNum": $("#flkNum").val(),
            "flkName": $("#flkName").val(),
            "Dfrom": $("#Dfrom").val(),
            "Dtoo": $("#Dtoo").val()
        }
        $.ajax({
            type: "GET",
            data: dataS,
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/ResultLC",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListLCTable').html(res);
                $('#loaderII').addClass('visually-hidden')
            },
            error: function (res) {
                setTimeout(()=>{
                    $('#loaderII').addClass('visually-hidden')
                },1000)
            }
        });
    }
    function clearForm(x) {
        document.getElementById("flkNum").value = '';
        document.getElementById("flkName").value = '';
        document.getElementById("Dfrom").value = '';
        document.getElementById("Dtoo").value = '';
    }
    function openNavLc(id, flkNum) {
        var dataS = {
            "id": id,
            "flkNum": flkNum,
        }
        document.getElementById("modalPdfLC").style.width = "600px";
        document.getElementById("bodyLc").style.marginLeft = "500px";
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/pdfModalLC",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#openInPdfLC').html(res);
            },
            error: function (res) {
            }
        });

    }
    function EditOrDeletePdf(id, flkNum) {
        var dataS = {
            "id": id,
            "flkNum": flkNum,
        }
        document.getElementById("modalPdfLC").style.width = "600px";
        document.getElementById("bodyLc").style.marginLeft = "500px";
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/EditOrDeletePdf",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#openInPdfLC').html(res);
            },
            error: function (res) {
            }
        });

    }
    function closeNavLc() {
        document.getElementById("modalPdfLC").style.width = "0";
        document.getElementById("bodyLc").style.marginLeft = "0";
    }
</script>
<script src="<%=request.getContextPath()%>/resources/js/swalSweetalert.js"></script>
</body>
