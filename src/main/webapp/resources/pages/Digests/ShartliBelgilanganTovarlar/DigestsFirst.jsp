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
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />
    <!-- loader-->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
</head>

<body>
<!--wrapper-->

<!--start page wrapper -->
<div id="ModalSentMess" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLiveLabel" aria-hidden="true"></div>
<div class="page-content">
    <!--start email wrapper-->
    <div class="">

        <div id="main" class="col">
            <h6 class="mb-0 text-uppercase">Шартли белгиланган товарлар</h6>
            <hr>
            <div class="card">
                <div class="card-body">
                    <ul class="nav nav-tabs nav-primary" role="tablist">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link active" data-bs-toggle="tab" href="#primaryhome" role="tab" aria-selected="false">
                                <div class="d-flex align-items-center">
                                    <div class="tab-icon"><i class="bx bxs-home font-18 me-1"></i>
                                    </div>
                                    <div class="tab-title">Рад этилган БЮД</div>
                                </div>
                            </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-bs-toggle="tab" href="#primaryprofile" role="tab" aria-selected="true">
                                <div class="d-flex align-items-center">
                                    <div class="tab-icon"><i class="bx bxs-user-pin font-18 me-1"></i>
                                    </div>
                                    <div class="tab-title">Маслахатлашув</div>
                                </div>
                            </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-bs-toggle="tab" href="#primarycontact" role="tab" aria-selected="false">
                                <div class="d-flex align-items-center">
                                    <div class="tab-icon"><i class="bx bxs-microphone font-18 me-1"></i>
                                    </div>
                                    <div class="tab-title">Шартли чиқарилган товарлар</div>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <div class="tab-content py-3">
                        <div class="tab-pane fade active show" id="primaryhome" role="tabpanel">
                            <div class="table-responsive">
                                <div class="d-xl-flex align-items-center mb-4">
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <div class="">
                                            <input class="result form-control" type="date"  placeholder="Сана ...дан">
                                        </div>
                                    </div>
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <div class="">
                                            <input class="result form-control" type="date"  placeholder="Сана ...гача">
                                        </div>
                                    </div>
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <select class="form-select" id="validationTooltip041" required="">
                                            <option selected="" disabled="disabled" value="" ><p class="text-muted">Ариза мақоми</p></option>
                                            <option value="100">Янги</option>
                                            <option value="110">Кўриб чиқиш учун тақсимланган</option>
                                            <option value="145">Тасдиқлашга тайрланган</option>
                                        </select>
                                    </div>
                                    <div class="ms-auto d-flex align-items-center">
                                        <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-left me-0'></i>
                                        </button>
                                        <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-right me-0'></i>
                                        </button>
                                    </div>
                                    <div class="d-flex align-items-center">
                                        <div class="email-toggle-btn"><i class='bx bx-menu'></i>
                                        </div>

                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-refresh me-0'></i>
                                            </button>
                                        </div>
                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-downvote me-0'></i>
                                            </button>
                                        </div>
                                        <div class="d-none d-md-flex">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-file me-0'></i>
                                            </button>
                                        </div>
                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-trash me-0'></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <table id="example1"  class="table table-striped table-bordered table-sm">
                                    <thead class="table-light">
                                    <tr>
                                        <th style="border-style: dotted">т/р</th>
                                        <th style="border-style: dotted">БЮД рақами</th>
                                        <th style="border-style: dotted">PDF</th>
                                        <th style="border-style: dotted">Қарор рақами</th>
                                        <th style="border-style: dotted">Сана</th>
                                        <th style="border-style: dotted">Товарлар сони</th>
                                        <th style="border-style: dotted">Товарлар бруттоси(кг)</th>
                                        <th style="border-style: dotted">Рад этиш сабаблари</th>
                                        <th style="border-style: dotted">Инспектор</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="val" items="${qiymatReject}" varStatus="i">
                                        <c:set var = "timefm1" value = "${val[3]}"/>
                                        <c:set var = "brutto1" value = "${val[12]}"/>
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td><a type="button" class="btn btn-primary btn-sm radius-30 px-4" href="#" class="text-primary font-weight-bold"><u>${val[0]}</u></a></td>
                                            <td><button class="btn btn-outline-danger pull-bs-canvas-right" onclick="javascript:openPDF('${val[15]}', 'rad etish qarori')"><i class="bx bxs-file-pdf bx-sm"></i></button></td>
                                            <td>${val[1]}</td>
                                            <td><fmt:formatDate pattern = "yyyy-MM-dd"  value = "${timefm1}" /></td>
                                            <td>
                                                <button type="button" class="btn btn-success" onclick="javascript:QiymatRejects('${val[15]}')">
                                                        ${val[14]}   <i class='bx bx-detail'></i>
                                                </button>
                                            </td>
                                            <td><fmt:formatNumber value = "${brutto1}"  pattern="#.##"/></td>
                                            <td>
                                                <c:if test="${val[5] == 0}"></c:if>

                                                <c:if test="${val[5] == 1}">
                                                    <i class="bx bx-comment-dots bx-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Хужжатлар ва маълумотлар мавжуд эмас"></i>
                                                </c:if>

                                                <c:if test="${val[6] == 0}"></c:if>

                                                <c:if test="${val[6] == 1}">
                                                    <i class="bx bx-comment-dots bx-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Хужжатлардаги маълумотларнинг номувофиқлиги"></i>
                                                </c:if>

                                                <c:if test="${val[7] == 0}"></c:if>

                                                <c:if test="${val[7] == 1}">
                                                    <i class="bx bx-comment-dots bx-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Товарларнинг нархи паст белгиланганлиги"></i>
                                                </c:if>

                                                <c:if test="${val[8] == 0}"></c:if>

                                                <c:if test="${val[8] == 1}">
                                                    <i class="bx bx-comment-dots bx-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="ХБТ аниқланган хавф"></i>
                                                </c:if>
                                            </td>
                                            <td>Инс.ид-${val[4]}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="primaryprofile" role="tabpanel">
                            <div class="table-responsive">
                                <div class="d-xl-flex align-items-center mb-4">
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <div class="">
                                            <input class="result form-control" type="date" placeholder="Сана ...дан">
                                        </div>
                                    </div>
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <div class="">
                                            <input class="result form-control" type="date" placeholder="Сана ...гача">
                                        </div>
                                    </div>
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <select class="form-select" id="validationTooltip042" required="">
                                            <option selected="" disabled="disabled" value="" ><p class="text-muted">Ариза мақоми</p></option>
                                            <option value="100">Янги</option>
                                            <option value="110">Кўриб чиқиш учун тақсимланган</option>
                                            <option value="145">Тасдиқлашга тайрланган</option>
                                        </select>
                                    </div>
                                    <div class="ms-auto d-flex align-items-center">
                                        <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-left me-0'></i>
                                        </button>
                                        <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-right me-0'></i>
                                        </button>
                                    </div>
                                    <div class="d-flex align-items-center">
                                        <div class="email-toggle-btn"><i class='bx bx-menu'></i>
                                        </div>

                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-refresh me-0'></i>
                                            </button>
                                        </div>
                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-downvote me-0'></i>
                                            </button>
                                        </div>
                                        <div class="d-none d-md-flex">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-file me-0'></i>
                                            </button>
                                        </div>
                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-trash me-0'></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <table id="example2"  class="table table-striped table-bordered table-sm">
                                    <thead class="table-light">
                                    <tr>
                                        <th style="border-style: dotted">т/р</th>
                                        <th style="border-style: dotted">БЮД рақами</th>
                                        <th style="border-style: dotted">PDF</th>
                                        <th style="border-style: dotted">Қарор рақами</th>
                                        <th style="border-style: dotted">Сана</th>
                                        <th style="border-style: dotted">Товарлар сони</th>
                                        <th style="border-style: dotted">БЮД да ҳисобланган бож. тўл.(млн. сўмда)</th>
                                        <th style="border-style: dotted">Жами ҳисобланган бож. тўл.(млн. сўмда)</th>
                                        <th style="border-style: dotted">Қўшимча ҳисобланган бож. тўл.(млн. сўмда)</th>
                                        <th style="border-style: dotted">Товарлар бруттоси(кг)</th>
                                        <th style="border-style: dotted">Инспектор</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="val" items="${qiymatconsult}" varStatus="i">
                                        <c:set var="total2" value="${val[5]-val[6]}"/>
                                        <c:set var = "timefm2" value = "${val[3]}"/>
                                        <c:set var = "sum3" value = "${val[6]}"/>
                                        <c:set var = "sum4" value = "${val[5]}"/>
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td><a type="button" class="btn btn-primary btn-sm radius-30 px-4" href="#" class="text-primary font-weight-bold"><u>${val[0]}</u></a></td>
                                            <td><button class="btn btn-outline-danger pull-bs-canvas-right" onclick="javascript:openPDF('${val[10]}', 'maslahatlashuv qarori')"><i class="bx bxs-file-pdf bx-sm"></i></button></td>
                                            <td>${val[1]}</td>
                                            <td><fmt:formatDate pattern = "yyyy-MM-dd"  value = "${timefm2}" /></td>
                                            <td>
                                                <button type="button" class="btn btn-success" onclick="javascript:QiymatRejects('${val[10]}')">
                                                        ${val[9]}   <i class='bx bx-detail'></i>
                                                </button>
                                            </td>
                                            <td><fmt:formatNumber value = "${sum3}" maxFractionDigits="3" /></td>
                                            <td><fmt:formatNumber value = "${sum4}" maxFractionDigits="3" /></td>
                                            <td><fmt:formatNumber value = "${total2}" maxFractionDigits="3" /></td>
                                            <td><fmt:formatNumber value = "${val[8]}"  pattern="#.##"/></td>
                                            <td>(${val[4]})</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="primarycontact" role="tabpanel">
                            <div class="table-responsive">
                                <div class="d-xl-flex align-items-center mb-4">
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <div class="">
                                            <input class="result form-control" type="date"  placeholder="Сана ...дан">
                                        </div>
                                    </div>
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <div class="">
                                            <input class="result form-control" type="date"  placeholder="Сана ...гача">
                                        </div>
                                    </div>
                                    <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                        <select class="form-select" id="validationTooltip043" required="">
                                            <option selected="" disabled="disabled" value="" ><p class="text-muted">Ариза мақоми</p></option>
                                            <option value="100">Янги</option>
                                            <option value="110">Кўриб чиқиш учун тақсимланган</option>
                                            <option value="145">Тасдиқлашга тайрланган</option>
                                        </select>
                                    </div>
                                    <div class="ms-auto d-flex align-items-center">
                                        <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-left me-0'></i>
                                        </button>
                                        <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-right me-0'></i>
                                        </button>
                                    </div>
                                    <div class="d-flex align-items-center">
                                        <div class="email-toggle-btn"><i class='bx bx-menu'></i>
                                        </div>

                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-refresh me-0'></i>
                                            </button>
                                        </div>
                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-downvote me-0'></i>
                                            </button>
                                        </div>
                                        <div class="d-none d-md-flex">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-file me-0'></i>
                                            </button>
                                        </div>
                                        <div class="">
                                            <button type="button" class="btn btn-white ms-2"><i class='bx bx-trash me-0'></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <table id="example3" class="table table-striped table-bordered table-sm">
                                    <thead class="table-light">
                                    <tr>
                                        <th style="border-style: dotted">т/р</th>
                                        <th style="border-style: dotted">БЮД рақами</th>
                                        <th style="border-style: dotted">PDF</th>
                                        <th style="border-style: dotted">Қарор рақами</th>
                                        <th style="border-style: dotted">Сана</th>
                                        <th style="border-style: dotted">Товарлар сони</th>
                                        <th style="border-style: dotted">БЮД да ҳисобланган бож. тўл.(млн. сўмда)</th>
                                        <th style="border-style: dotted">Жами ҳисобланган бож. тўл.(млн. сўмда)</th>
                                        <th style="border-style: dotted">Қўшимча ҳисобланган бож. тўл.(млн. сўмда)</th>
                                        <th style="border-style: dotted">Товарлар бруттоси(кг)</th>
                                        <th style="border-style: dotted">Амал қилиш санаси</th>
                                        <th style="border-style: dotted">Амал қилиш муддати</th>
                                        <th style="border-style: dotted">Инспектор</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="val" items="${qiymatshartli}" varStatus="i">
                                        <c:set var="total" value="${val[5]-val[6]}"/>
                                        <c:set var = "timefm3" value = "${val[3]}"/>
                                        <c:set var = "timefm4" value = "${val[10]}"/>
                                        <c:set var = "num" value = "${val[8]}"/>
                                        <c:set var = "sum" value = "${val[6]}"/>
                                        <c:set var = "sum2" value = "${val[5]}"/>
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td><a type="button" class="btn btn-primary btn-sm radius-30 px-4" href="#" class="text-primary font-weight-bold"><u>${val[0]}</u></a></td>
                                            <td><button class="btn btn-outline-danger pull-bs-canvas-right" onclick="javascript:openPDF('${val[12]}', 'shartli belgilash qarori')"><i class="bx bxs-file-pdf bx-sm"></i></button></td>
                                            <td>${val[1]}</td>
                                            <td><fmt:formatDate pattern = "yyyy-MM-dd"  value = "${timefm3}" /></td>
                                            <td>
                                                <button type="button" class="btn btn-success" onclick="javascript:QiymatRejects('${val[12]}')">
                                                        ${val[9]}   <i class='bx bx-detail'></i>
                                                </button>

                                            </td>
                                            <td><fmt:formatNumber value = "${sum}" maxFractionDigits="3" /></td>
                                            <td><fmt:formatNumber value = "${sum2}" maxFractionDigits="3" /></td>
                                            <td><fmt:formatNumber value = "${total}" maxFractionDigits="3" /></td>
                                            <td><fmt:formatNumber value = "${num}"  pattern="#.##"/></td>
                                            <td><fmt:formatDate pattern = "yyyy-mm-dd"  value = "${timefm4}" /></td>
                                            <td>${val[11]} кун</td>
                                            <td>Инс.ид-(${val[4]})</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div>
<%--            <button style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</button>--%>
            <style>

                .sidenav {
                    height: 100%;
                    width: 0;
                    position: fixed;
                    z-index: 1;
                    top: 0;
                    left: 0;
                    background-color: rgba(255, 255, 255, 0.93);
                    overflow-x: hidden;
                    transition: 0.5s;
                    padding-top: 90px;
                }

                .sidenav a {
                    padding: 8px 8px 8px 32px;
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
                    padding: 0px;
                }

                @media screen and (max-height: 450px) {
                    .sidenav {padding-top: 15px;}
                    .sidenav a {font-size: 18px;}
                }
            </style>
            <div id="mySidenav" class="sidenav">
                <button class="btn-outline-primary" href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</button>
                <div id="pdfViewer">
                    <!--pdf opener-->
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: true
    }),
        $('.timepicker').pickatime()
</script>
<script>
    $(function () {
        $('#date-time').bootstrapMaterialDatePicker({
            format: 'DD-MM-YYYY',
            closeOnClear: false
        });
        $('#date').bootstrapMaterialDatePicker({
            time: false,
            closeOnClear: true
        });
        $('#date2').bootstrapMaterialDatePicker({
            time: false,


        });
        $('#time').bootstrapMaterialDatePicker({
            date: false,
            format: 'HH:mm',
            closeOnClear: false
        });
    });
</script>
<script>
    /* PDF open */
    function openPDF(declId, docType) {
        var dataS = {
            "declId": declId,
            "docType": docType
        }
        document.getElementById("mySidenav").style.width = "650px";
        document.getElementById("main").style.marginLeft = "550px";
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/Pcabinet",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#pdfViewer').html(res);
                window.location.href('#pdfViewer');

            },
            error: function (res) {
            }
        });
    }
    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
    }
    $(document).ready(function () {
        $('#example1').DataTable({
            "language": {
                "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",
                "infoFiltered": "(_MAX_ та маълумот сараланди)",
                "infoEmpty": "Маълумотлар топилмади",
                "info": "Жами _PAGES_ та, _PAGE_-сахифа ",
                "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",
                "Show": "Кўрсатилмоқда",
                "search": "Излаш",
                "paginate": {
                    "next": "Кейинги",
                    "previous": "Олдинги",
                }
            }
        });
    });
    $(document).ready(function () {
        $('#example2').DataTable({
            "language": {
                "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",
                "infoFiltered": "(_MAX_ та маълумот сараланди)",
                "infoEmpty": "Маълумотлар топилмади",
                "info": "Жами _PAGES_ та, _PAGE_-сахифа ",
                "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",
                "Show": "Кўрсатилмоқда",
                "search": "Излаш",
                "paginate": {
                    "next": "Кейинги",
                    "previous": "Олдинги",
                }
            }
        });
    });
    $(document).ready(function () {
        $('#example3').DataTable({
            "language": {
                "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",
                "infoFiltered": "(_MAX_ та маълумот сараланди)",
                "infoEmpty": "Маълумотлар топилмади",
                "info": "Жами _PAGES_ та, _PAGE_-сахифа ",
                "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",
                "Show": "Кўрсатилмоқда",
                "search": "Излаш",
                "paginate": {
                    "next": "Кейинги",
                    "previous": "Олдинги",
                }
            }
        });
    });
</script>

</body>
