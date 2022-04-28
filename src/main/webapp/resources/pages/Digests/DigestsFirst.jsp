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

        <div class="col">
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
                                            <td>${val[5]} ${val[6]} ${val[7]} ${val[8]}</td>
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


        <!--start compose mail-->
        <div class="compose-mail-popup">
            <div class="card">
                <div class="card-header bg-dark text-white py-2 cursor-pointer">
                    <div class="d-flex align-items-center">
                        <div class="compose-mail-title">New Message</div>
                        <div class="compose-mail-close ms-auto">x</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="email-form">
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="To"/>
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Subject"/>
                        </div>
                        <div class="mb-3">
                            <textarea class="form-control" placeholder="Message" rows="10" cols="10"></textarea>
                        </div>
                        <div class="mb-0">
                            <div class="d-flex align-items-center">
                                <div class="">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary">Action</button>
                                        <button type="button"
                                                class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split"
                                                data-bs-toggle="dropdown"><span
                                                class="visually-hidden">Toggle Dropdown</span>
                                        </button>
                                        <div class="dropdown-menu"><a class="dropdown-item"
                                                                      href="javascript:;">Action</a>
                                            <a class="dropdown-item" href="javascript:;">Another action</a>
                                            <a class="dropdown-item" href="javascript:;">Something else here</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="javascript:;">Separated link</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="ms-2">
                                    <button type="button" class="btn border-0 btn-sm btn-white"><i
                                            class="lni lni-text-format"></i>
                                    </button>
                                    <button type="button" class="btn border-0 btn-sm btn-white"><i
                                            class='bx bx-link-alt'></i>
                                    </button>
                                    <button type="button" class="btn border-0 btn-sm btn-white"><i
                                            class="lni lni-emoji-tounge"></i>
                                    </button>
                                    <button type="button" class="btn border-0 btn-sm btn-white"><i
                                            class="lni lni-google-drive"></i>
                                    </button>
                                </div>
                                <div class="ms-auto">
                                    <button type="button" class="btn border-0 btn-sm btn-white"><i
                                            class="lni lni-trash"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
            <style>
                .bs-canvas-overlay {
                    opacity: 0.85;
                    z-index: 1100;
                }

                .bs-canvas {
                    top: 0;
                    z-index: 1110;
                    overflow-x: hidden;
                    overflow-y: auto;
                    width: 900px;
                    transition: margin .4s ease-out;
                    -webkit-transition: margin .4s ease-out;
                    -moz-transition: margin .4s ease-out;
                    -ms-transition: margin .4s ease-out;
                }

                .bs-canvas-left {
                    left: 0;
                    margin-left: -900px;
                }

                .bs-canvas-right {
                    right: 0;
                    margin-right: -900px;
                }

                /* Only for demo */
            </style>

            <div class="bs-canvas bs-canvas-right position-fixed bg-light h-100 border-5">
                <header class="bs-canvas-header p-3 bg-primary overflow-auto">
                    <button type="button" class="bs-canvas-close float-left close" aria-label="Close"><span aria-hidden="true" class="text-light">&times;</span></button>
                    <h4 class="d-inline-block text-light mb-0 float-right">Хужжатлар ойнаси</h4>
                </header>
                <div id="pdfViewer">
                    <!--pdf opener-->
                </div>
            </div>
<%--            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
<%--            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>--%>
<%--            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>--%>
            <script>
                jQuery(document).ready(function($){
                    $(document).on('click', '.pull-bs-canvas-right, .pull-bs-canvas-left', function(){
                        $('body').prepend('<div class="bs-canvas-overlay bg-dark position-fixed w-100 h-100"></div>');
                        if($(this).hasClass('pull-bs-canvas-right'))
                            $('.bs-canvas-right').addClass('mr-0');
                        else
                            $('.bs-canvas-left').addClass('ml-0');
                        return false;
                    });

                    $(document).on('click', '.bs-canvas-close, .bs-canvas-overlay', function(){
                        var elm = $(this).hasClass('bs-canvas-close') ? $(this).closest('.bs-canvas') : $('.bs-canvas');
                        elm.removeClass('mr-0 ml-0');
                        $('.bs-canvas-overlay').remove();
                        return false;
                    });
                });
            </script>
        </div>

        <!--end compose mail-->
        <!--start email overlay-->
<%--        <div class="overlay email-toggle-btn-mobile" id="pdfViewer"></div>--%>
        <!--end email overlay-->
    </div>
    <!--end email wrapper-->
</div>

<!--end page wrapper -->
<!--end wrapper -->
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
