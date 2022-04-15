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
    <div class="email-wrapper">
        <div class="email-sidebar">
            <div class="email-sidebar-header d-grid"><a href="javascript:;" class="btn btn-primary compose-mail-btn"><i
                    class='bx bx-list-check me-2'></i>Товарлар</a>
            </div>
            <div class="email-sidebar-content">
                <div class="email-navigation">
                    <div class="list-group list-group-flush" id="myTab" role="tablist">
                        <a class="list-group-item d-flex align-items-center active" data-bs-toggle="tab" href="#successhome" role="tab" aria-selected="true">
                            <i class='bx bxs-alarm-snooze me-3 font-20'></i>
                            <span>Рад этилган БЮД</span>
                            <span class="badge bg-primary rounded-pill ms-auto">2</span>
                        </a>
                        <a class="list-group-item d-flex align-items-center" data-bs-toggle="tab" href="#successprofile" role="tab" aria-selected="false">
                            <i class='bx bxs-inbox me-3 font-20'></i>
                            <span>Маслахатлашув</span>
                            <span class="badge bg-primary rounded-pill ms-auto">1</span>
                        </a>
                        <a class="list-group-item d-flex align-items-center" data-bs-toggle="tab" href="#successcontact" role="tab" aria-selected="false">
                            <i class="bx bxs-star me-3 font-20 nav-item"></i>
                            <span>Шартли чиқарилган товарлар</span>
                            <span class="badge bg-primary rounded-pill ms-auto">2</span>
                        </a>
                    </div>
                </div>
                <div class="email-meeting">
<%--                    <div class="list-group list-group-flush">--%>
<%--                        <div class="list-group-item"><span>Meet</span>--%>
<%--                        </div>--%>
<%--                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i--%>
<%--                                class='bx bxs-video me-3 font-20'></i><span>Start a meeting</span></a>--%>
<%--                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i--%>
<%--                                class='bx bxs-group me-3 font-20'></i><span>Join a meeting</span></a>--%>
<%--                        <div class="list-group-item email-hangout cursor-pointer border-top">--%>
<%--                            <div class="d-flex align-items-center">--%>
<%--                                <div class="chat-user-online">--%>
<%--                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-1.png"--%>
<%--                                         width="42" height="42" class="rounded-circle" alt=""/>--%>
<%--                                </div>--%>
<%--                                <div class="flex-grow-1 ms-2">--%>
<%--                                    <p class="mb-0">Jessica Doe</p>--%>
<%--                                </div>--%>
<%--                                <div class="dropdown">--%>
<%--                                    <div class="font-24 dropdown-toggle dropdown-toggle-nocaret"--%>
<%--                                         data-bs-toggle="dropdown"><i class='bx bx-plus'></i>--%>
<%--                                    </div>--%>
<%--                                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item"--%>
<%--                                                                                    href="javascript:;">Settings</a>--%>
<%--                                        <div class="dropdown-divider"></div>--%>
<%--                                        <a class="dropdown-item" href="javascript:;">Help & Feedback</a>--%>
<%--                                        <a class="dropdown-item" href="javascript:;">Enable Split View Mode</a>--%>
<%--                                        <a class="dropdown-item" href="javascript:;">Keyboard Shortcuts</a>--%>
<%--                                        <div class="dropdown-divider"></div>--%>
<%--                                        <a class="dropdown-item" href="javascript:;">Sign Out</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
        <div class="email-header d-xl-flex align-items-center">
            <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                <div class="">
                    <input class="result form-control" type="date" id="date" placeholder="Сана ...дан">
                </div>
            </div>
            <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                <div class="">
                    <input class="result form-control" type="date" id="date2" placeholder="Сана ...гача">
                </div>
            </div>
            <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                <select class="form-select" id="validationTooltip04" required="">
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
        <div class="email-content" id="myTabContent">
            <div class="card">
                <div class="card-body">
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="successhome" role="tabpanel">
                            <div class="table-responsive">
                                <table id="example1"  class="table table-striped table-bordered table-sm">
                                    <thead class="table-light">
                                    <tr>
                                        <th style="border-style: dotted">т/р</th>
                                        <th style="border-style: dotted">БЮД рақами</th>
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
                        <div class="tab-pane fade" id="successprofile" role="tabpanel">
                            <div class="table-responsive">
                                <table id="example2"  class="table table-striped table-bordered table-sm">
                                    <thead class="table-light">
                                    <tr>
                                        <th style="border-style: dotted">т/р</th>
                                        <th style="border-style: dotted">БЮД рақами</th>
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
                                            <td>Машарипов Жамшид(${val[4]})</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="successcontact" role="tabpanel">
                            <div class="table-responsive">
                                <table id="example3" class="table table-striped table-bordered table-sm">
                                    <thead class="table-light">
                                    <tr>
                                        <th style="border-style: dotted">т/р</th>
                                        <th style="border-style: dotted">БЮД рақами</th>
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
                    <!-- dsfsfds -->
                </div>
            </div>
            <!--
            <div class="email-list">
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Wordpress</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">It is a long established fact that a reader will be distracted by the readable...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">5:56 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Locanto</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">The point of using Lorem Ipsum is that it has a more-or-less normal...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">5:45 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Facebook</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">There are many variations of passages of Lorem Ipsum available, majority suffered...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">4:32 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Alex Xender</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">4:25 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Alisha Mastana</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">4:18 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Synergy Technology</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">If you are going to use a passage of Lorem Ipsum, you need to be sure there...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">3:56 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Robina Consultant</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">3:43 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>HCl Technologies</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Bonorum et Malorum" by Cicero are also reproduced in their exact original form...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">2:25 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Tata India</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">But I must explain to you how all this mistaken idea of denouncing pleasure...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">2:14 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Jessica Jhons</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">At vero eos et accusamus et iusto odio dignissimos ducimus...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">1:30 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Anaxa Marvel</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">1:15 PM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Maxwell Linga</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">On the other hand, we denounce with righteous indignation and dislike...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">12:45 AM</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Cricket India</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Oct 25</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Start Sports Australia</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Excepteur sint occaecat cupidatat non proident, sunt in culpa...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Oct 22</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Diana Dating Services</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Nor again is there anyone who loves or pursues or desires to obtain pain...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Oct 18</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Himalaya India</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Oct 10</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>NASA USA</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">All the Lorem Ipsum generators on the Internet tend to repeat predefined...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Sep 28</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Indeed Jobs</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Content here, content here', making it look like readable English...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Sep 22</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Wordfence</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Various versions have evolved over the years, sometimes by accident...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Sep 18</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>DocsApp India</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">But I must explain to you how all this mistaken idea of denouncing pleasure...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Sep 12</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Alex ReliableSoft</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Sep 02</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Ryan Robinson</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Business it will frequently occur that pleasures have to be repudiated...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Aug 22</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>TechGig Job Alert</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Aug 18</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Paytm India</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">All the Lorem Ipsum generators on the Internet tend to repeat predefined...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Jul 27</p>
                        </div>
                    </div>
                </a>
                <a href="app-emailread.html">
                    <div class="d-md-flex align-items-center email-message px-3 py-1">
                        <div class="d-flex align-items-center email-actions">
                            <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                            <p class="mb-0"><b>Uber America</b>
                            </p>
                        </div>
                        <div class="">
                            <p class="mb-0">Chunks as necessary, making this the first true generator on the Internet...</p>
                        </div>
                        <div class="ms-auto">
                            <p class="mb-0 email-time">Jul 24</p>
                        </div>
                    </div>
                </a>
            </div>
            -->
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
        <!--end compose mail-->
        <!--start email overlay-->
        <div class="overlay email-toggle-btn-mobile"></div>
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
