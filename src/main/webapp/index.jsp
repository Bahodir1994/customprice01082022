<!DOCTYPE html>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="uz.customs.customsprice.entity.users.User" %>
<%@ page import="uz.customs.customsprice.entity.users.Role" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    Integer userRole;
    String userId = "";
    String userName = "";
    String userRoleName = "";
    String userLocation = "";
    String userLocationName = "";
    String userPost = "";

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = (User) authentication.getPrincipal();
    Set<Role> roles = user.getRoles();
    List<Role> roleList = new ArrayList<>(roles);
    roleList.sort((o1, o2) -> o1.getCode().compareTo(o2.getCode()));
    if (session.getAttribute("role") == null) {
        if (user.getRole() == null) {
            session.setAttribute("role", "0");
            session.setAttribute("userRole", "0");
            session.setAttribute("userId", "0");
            session.setAttribute("userIdS", user.getId());
            session.setAttribute("userName", "0");
            session.setAttribute("userLocation", "0");
            session.setAttribute("userPost", "0");
            session.setAttribute("userLocationName", "0");
        } else {
            session.setAttribute("role", user.getRole());
            session.setAttribute("userRole", user.getRole());
            session.setAttribute("userId", user.getUserid());
            session.setAttribute("userIdS", user.getId());
            session.setAttribute("userName", user.getFullname());
            session.setAttribute("userLocation", user.getLocation());
            session.setAttribute("userLocationName", user.getLocationname());
            session.setAttribute("userPost", user.getPost());
        }
    }
    Integer roleI = (Integer) session.getAttribute("role");
    session.setAttribute("role", roleI);
    session.setAttribute("userRole", roleI);
    session.setAttribute("userId", user.getUserid());
    session.setAttribute("userIdS", user.getId());
    session.setAttribute("userName", user.getFullname());
    session.setAttribute("userLocation", user.getLocation());
    session.setAttribute("userLocationName", user.getLocationname());
    session.setAttribute("userPost", user.getPost());
    String roleN = "";
    for (Role role : roleList) {
        if (role.getCode().equals(roleI)) {
            roleN = role.getName();
            break;
        }
    }
%>

<head>
    <meta charset="utf-8">
    <link href="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.css" rel="stylesheet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/emblem.png" type="image/x-icon">
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/css/highcharts.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-2.0.2.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/pace.min.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/app.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/icons.css" rel="stylesheet">
    <!-- Theme Style CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/plugins/select2.min.css">
    <title>?????????????? ??????????????</title>
</head>

<body style="zoom: 100%;">
<style>
    div.clickEffect {
        position: absolute;
        box-sizing: border-box;
        border-style: solid;
        border-color: #111a57;
        border-radius: 50%;
        animation: clickEffect 0.4s ease-out;
        z-index: 99999;
    }

    @keyframes clickEffect {
        0% {
            opacity: 1;
            width: 0.5em;
            height: 0.5em;
            margin: 0em;
            border-width: 0.5em;
        }
        100% {
            opacity: 0.2;
            width: 15em;
            height: 15em;
            margin: -7.5em;
            border-width: 0.03em;
        }

    }
</style>
<div class="wrapper">
    <!-- start header wrapper-->
    <div class="header-wrapper">
        <!-- start header -->
        <header>
            <div class="topbar d-flex align-items-center">
                <nav class="navbar navbar-expand">
                    <div class="topbar-logo-header">
                        <div class="">
                            <img src="<%=request.getContextPath()%>/resources/assets2/images/icons/gtk.jpg" class=""
                                 style="width: 45px;">
                        </div>
                        <div class="">
                            <a class="logo-text h4" style="font-size: 18px!important;" href="/CUSTOMSPRICE">?????????????? ??????????????  ????????????????</a>
                        </div>
                    </div>
                    <div class="mobile-toggle-menu"><i class='bx bx-menu'></i></div>
                    <div class="top-menu-left d-none d-lg-block ps-3">
                    </div>
                    <div class="search-bar flex-grow-1">
                        <div class="position-relative search-bar-box">
                            <input type="text" class="form-control search-control" placeholder="Type to search...">
                            <span class="position-absolute top-50 search-show translate-middle-y"><i
                                    class='bx bx-search'></i></span>
                            <span class="position-absolute top-50 search-close translate-middle-y"><i
                                    class='bx bx-x'></i></span>
                        </div>
                    </div>
                    <div class="top-menu ms-auto">
                        <ul class="navbar-nav align-items-center">
                            <li class="nav-item mobile-search-icon">
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
                            </li>
<%--                            <h6 class="marquee text-white"><span class="text-white" style="color: #ffffff">?????????????? ???????????????? ?????????????????????????????? ???????????? ???????? ????????????????????, ???? ?????????????? ???????????????? ?????????????????? ???????????? ????????????...</span></h6>--%>

                            <li class="nav-item dropdown dropdown-large">
                                <div class="dropdown-menu dropdown-menu-end">
                                    <div class="row row-cols-3 g-3 p-3">
                                        <div class="col text-center">
                                            <div class="app-box mx-auto bg-gradient-cosmic text-white"><i
                                                    class='bx bx-group'></i>
                                            </div>
                                            <div class="app-title">Teams</div>
                                        </div>
                                        <div class="col text-center">
                                            <div class="app-box mx-auto bg-gradient-burning text-white"><i
                                                    class='bx bx-atom'></i>
                                            </div>
                                            <div class="app-title">Projects</div>
                                        </div>
                                        <div class="col text-center">
                                            <div class="app-box mx-auto bg-gradient-lush text-white"><i
                                                    class='bx bx-shield'></i>
                                            </div>
                                            <div class="app-title">Tasks</div>
                                        </div>
                                        <div class="col text-center">
                                            <div class="app-box mx-auto bg-gradient-kyoto text-dark"><i
                                                    class='bx bx-notification'></i>
                                            </div>
                                            <div class="app-title">Feeds</div>
                                        </div>
                                        <div class="col text-center">
                                            <div class="app-box mx-auto bg-gradient-blues text-dark"><i
                                                    class='bx bx-file'></i>
                                            </div>
                                            <div class="app-title">Files</div>
                                        </div>
                                        <div class="col text-center">
                                            <div class="app-box mx-auto bg-gradient-moonlit text-white"><i
                                                    class='bx bx-filter-alt'></i>
                                            </div>
                                            <div class="app-title">Alerts</div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown dropdown-large">
                                <div class="dropdown-menu dropdown-menu-end">
                                    <div class="header-notifications-list">
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-primary text-primary"><i
                                                        class="bx bx-group"></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Customers<span class="msg-time float-end">14 Sec
													ago</span></h6>
                                                    <p class="msg-info">5 new user registered</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-danger text-danger"><i
                                                        class="bx bx-cart-alt"></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Orders <span class="msg-time float-end">2 min
													ago</span></h6>
                                                    <p class="msg-info">You have recived new orders</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-success text-success"><i
                                                        class="bx bx-file"></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">24 PDF File<span class="msg-time float-end">19 min
													ago</span></h6>
                                                    <p class="msg-info">The pdf files generated</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-warning text-warning"><i
                                                        class="bx bx-send"></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Time Response <span class="msg-time float-end">28 min
													ago</span></h6>
                                                    <p class="msg-info">5.1 min avarage time response</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-info text-info"><i
                                                        class="bx bx-home-circle"></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Product Approved <span
                                                            class="msg-time float-end">2 hrs ago</span></h6>
                                                    <p class="msg-info">Your new product has approved</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-danger text-danger"><i
                                                        class="bx bx-message-detail"></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Comments <span class="msg-time float-end">4 hrs
													ago</span></h6>
                                                    <p class="msg-info">New customer comments recived</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-success text-success"><i
                                                        class='bx bx-check-square'></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Your item is shipped <span
                                                            class="msg-time float-end">5 hrs
													ago</span></h6>
                                                    <p class="msg-info">Successfully shipped your item</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-primary text-primary"><i
                                                        class='bx bx-user-pin'></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New 24 authors<span class="msg-time float-end">1 day
													ago</span></h6>
                                                    <p class="msg-info">24 new authors joined last week</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify bg-light-warning text-warning"><i
                                                        class='bx bx-door-open'></i>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Defense Alerts <span
                                                            class="msg-time float-end">2 weeks
													ago</span></h6>
                                                    <p class="msg-info">45% less alerts last 4 weeks</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <a href="javascript:;">
                                        <div class="text-center msg-footer">View All Notifications</div>
                                    </a>
                                </div>
                            </li>
                            <li class="nav-item dropdown dropdown-large">
                                <div class="dropdown-menu dropdown-menu-end">
                                    <a href="javascript:;">
                                        <div class="msg-header">
                                            <p class="msg-header-title">Messages</p>
                                            <p class="msg-header-clear ms-auto">Marks all as read</p>
                                        </div>
                                    </a>
                                    <div class="header-message-list">
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-1.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Daisy Anderson <span
                                                            class="msg-time float-end">5 sec
													ago</span></h6>
                                                    <p class="msg-info">The standard chunk of lorem</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-2.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Althea Cabardo <span
                                                            class="msg-time float-end">14
													sec ago</span></h6>
                                                    <p class="msg-info">Many desktop publishing packages</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-3.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Oscar Garner <span class="msg-time float-end">8 min
													ago</span></h6>
                                                    <p class="msg-info">Various versions have evolved over</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-4.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Katherine Pechon <span
                                                            class="msg-time float-end">15
													min ago</span></h6>
                                                    <p class="msg-info">Making this the first true generator</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-5.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Amelia Doe <span class="msg-time float-end">22 min
													ago</span></h6>
                                                    <p class="msg-info">Duis aute irure dolor in reprehenderit</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-6.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Cristina Jhons <span
                                                            class="msg-time float-end">2 hrs
													ago</span></h6>
                                                    <p class="msg-info">The passage is attributed to an unknown</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-7.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">James Caviness <span
                                                            class="msg-time float-end">4 hrs
													ago</span></h6>
                                                    <p class="msg-info">The point of using Lorem</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-8.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Peter Costanzo <span
                                                            class="msg-time float-end">6 hrs
													ago</span></h6>
                                                    <p class="msg-info">It was popularised in the 1960s</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-9.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">David Buckley <span class="msg-time float-end">2 hrs
													ago</span></h6>
                                                    <p class="msg-info">Various versions have evolved over</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-10.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Thomas Wheeler <span
                                                            class="msg-time float-end">2 days
													ago</span></h6>
                                                    <p class="msg-info">If you are going to use a passage</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="user-online">
                                                    <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/avatar-11.png"
                                                         class="msg-avatar" alt="user avatar">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Johnny Seitz <span class="msg-time float-end">5 days
													ago</span></h6>
                                                    <p class="msg-info">All the Lorem Ipsum generators</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <a href="javascript:;">
                                        <div class="text-center msg-footer">View All Messages</div>
                                    </a>
                                </div>
                            </li>
                            <li class="">
                                <%--                                <a type="button" class="btn btn-sm radius-30 text-white" style="cursor: pointer; background-color: #0a58ca; font-size: 24px" id="id_date"></a>--%>
                                <h6 type="button" class="btn btn-sm radius-15 bg-outline-primary text-success" style="font-size: 24px" id="id_clock"></h6>
                                <script>
                                    function digitalClock() {
                                        var date = new Date();
                                        var hours = date.getHours();
                                        var minutes = date.getMinutes();
                                        var seconds = date.getSeconds();
                                        var day = date.getDate();
                                        var month = date.getMonth();
                                        var years = date.getFullYear()
                                        //* ???????????????????? ?????????????? ?????????? */
                                        if (hours < 10) hours = "0" + hours;
                                        if (minutes < 10) minutes = "0" + minutes;
                                        if (seconds < 10) seconds = "0" + seconds;
                                        // document.getElementById("id_date").innerHTML = years + "/" + month + "/" + day;
                                        document.getElementById("id_clock").innerHTML =hours + ":" + minutes + ":" + seconds;

                                        setTimeout("digitalClock()", 1000);
                                    };
                                </script>
                            </li>
                        </ul>
                    </div>
                    <div class="user-box dropdown">
                        <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="<%=request.getContextPath()%>/resources/assets2/images/avatars/customers-icon.png"
                                 class="user-img" alt="user avatar">
                            <div class="user-info ps-3">
                                <p class="user-name mb-0"><%=user.getFullname()%>
                                </p>
                                <p class="designattion mb-0"><%=roleN%></p>
                            </div>
                            <div class="user-info ps-3">
                                <i class='bx bx-log-in-circle bx-lg'></i>
                            </div>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <%
                                int i = 1;
                                String selected = "", active = "", fw = "", fa = "", fl = "";
                                for (Role role : roleList) {
                                    if (role.getCode().equals(user.getRole())) {
                                        selected = "selected";
                                        active = "active";
                                        fw = "fw-bold";
                                        fa = "bx bxs-user text-white";
                                        fl = "btn btn-success w-100 text-start";
                                    } else {
                                        selected = "";
                                        active = "";
                                        fw = "fw-normal";
                                        fa = "bx bx-user";
                                        fl = "btn btn-outline-success w-100 text-start";
                                    }
                            %>
                            <li class="<%=selected%> <%=active%> <%=fw%> m-1" title="<%=role.getCode()%>">
                                <a href="javascript:RoleF('<%=role.getCode()%>')" class="<%=fl%>">
                                    <i class="<%=fa%>" id="iconU<%=i%>"></i> <%=role.getName()%>
                                </a>
                            </li>
                            <% i++;
                            }%>
                            <hr>
                            <li class="text-c-red"
                                title="???????????????? ??????????"><a
                                    href="${pageContext.request.contextPath}/exit.do" class="dropdown-item link-danger">
                                <i class="bx bx-log-out bx-sm text-danger"></i> ??????????
                            </a>
                            </li>
                        </ul>
                        <ul class="dropdown-menu dropdown-menu-end" style="display: none;">
                            <li><a class="dropdown-item" href="javascript:;"><i class="bx bx-user"></i><span>????????????????????????</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i
                                    class="bx bx-cog"></i><span>????????????????????</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-home-circle'></i><span>???????????? ????????</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-dollar-circle'></i><span>???????????? ????????????????</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-download'></i><span>???????????????? ??????????????????</span></a>
                            </li>
                            <li>
                                <div class="dropdown-divider mb-0"></div>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-log-out-circle'></i><span>??????????</span></a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <!-- end header -->
        <!-- navigation-->
        <div class="nav-container">
            <div class="mobile-topbar-header">
                <div>
                    <img src="<%=request.getContextPath()%>/resources/assets2/images/logo-icon.png" class="logo-icon"
                         alt="logo icon">
                </div>
                <div>
                    <h4 class="logo-text">?????????????? ??????????????</h4>
                </div>
                <div class="toggle-icon ms-auto"><i class='bx bx-first-page'></i>
                </div>
            </div>
            <nav class="topbar-nav">
                <ul class="metismenu" id="menu" style="font-size: 14px">
                    <li>
                        <a href="javascript:ErrorMessage(0);" class="has-arrow ">
                            <div class="parent-icon"><i class='bx bx-bar-chart-alt-2'></i>
                            </div>
                            <div class="menu-title">???????????????????? ????????????????</div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:ListInDec()" class="has-arrow">
                            <div class="parent-icon"><i class="bx bx-category"></i>
                            </div>
                            <div class="menu-title">?????????????????? ??????????</div>
                        </a>
                    </li>

                    <li>
                        <a class="has-arrow" href="javascript:ErrorMessage(0);">
                            <div class="parent-icon icon-color-6"><i class="bx bx-donate-blood"></i>
                            </div>
                            <div class="menu-title">?????????????????????????? ????????????</div>
                        </a>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:CostMonitoring(0);">
                            <div class="parent-icon"><i class="bx bx-line-chart"></i>
                            </div>
                            <div class="menu-title">???????????? ??????????????????????</div>
                        </a>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:LogicalControl(0);">
                            <div class="parent-icon"><i class='bx bx-bookmark-heart'></i>
                            </div>
                            <div class="menu-title">???????????????? ??????????????</div>
                        </a>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:InternationalSurvay(0);">
                            <div class="parent-icon"><i class="bx bx-lock"></i>
                            </div>
                            <div class="menu-title">?????????????? ??????????????????</div>
                        </a>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:Digests(0);">
                            <div class="parent-icon"><i class='bx bx-message-square-edit'></i>
                            </div>
                            <div class="menu-title">??????????????????????</div>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <style>
        #preloader {
            z-index: 99999;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }
        #loader {
            z-index: 99999;
            display: block;
            position: absolute;
            left: 50%;
            top: 50%;
            width: 150px;
            height: 150px;
            margin: -75px 0 0 -75px;
            border-radius: 50%;
            border: 3px solid transparent;
            border-top-color: #9370DB;
            -webkit-animation: spin 2s linear infinite;
            animation: spin 2s linear infinite;
        }
        #loader:before {
            content: "";
            position: absolute;
            top: 5px;
            left: 5px;
            right: 5px;
            bottom: 5px;
            border-radius: 50%;
            border: 3px solid transparent;
            border-top-color: #BA55D3;
            -webkit-animation: spin 3s linear infinite;
            animation: spin 3s linear infinite;
        }
        #loader:after {
            content: "";
            position: absolute;
            top: 15px;
            left: 15px;
            right: 15px;
            bottom: 15px;
            border-radius: 50%;
            border: 3px solid transparent;
            border-top-color: #FF00FF;
            -webkit-animation: spin 1.5s linear infinite;
            animation: spin 1.5s linear infinite;
        }
        @-webkit-keyframes spin {
            0%   {
                -webkit-transform: rotate(0deg);
                -ms-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
                -ms-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
        @keyframes spin {
            0%   {
                -webkit-transform: rotate(0deg);
                -ms-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
                -ms-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
    </style>
    <div id="preloader" class="visually-hidden">
        <div id="loader"></div>
    </div>
    <%--todo ????????????----------------------------------------------------??????????------------------------??????--%>
    <div class="page-wrapper" id="MainContent" role="main" style="min-height: 850px!important;">
        <%--todo ?????????????????????????? ?????????????? ????????--%>
    </div>
    <%--todo ????????????----------------------------------------------------??????????------------------------????????--%>
</div>
<div class="switcher-wrapper">
    <div class="switcher-btn"><i class='bx bx-cog bx-spin'></i>
    </div>
    <div class="switcher-body">
        <div class="d-flex align-items-center">
            <h5 class="mb-0 text-uppercase">????????????????</h5>
            <button type="button" class="btn-close ms-auto close-switcher" aria-label="Close"></button>
        </div>
        <hr/>
        <h6 class="mb-0">?????? ????????????????</h6>
        <hr/>
        <div class="d-flex align-items-center justify-content-between">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="lightmode" checked>
                <label class="form-check-label" for="lightmode">?????????? ????????</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="darkmode">
                <label class="form-check-label" for="darkmode">???????? ????????</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="semidark">
                <label class="form-check-label" for="semidark">???????? ???????? ????????</label>
            </div>
        </div>
        <hr/>
        <div class="form-check">
            <input class="form-check-input" type="radio" id="minimaltheme" name="flexRadioDefault">
            <label class="form-check-label" for="minimaltheme">?????????????????? ??????????</label>
        </div>
        <hr/>
        <h6 class="mb-0">??????????????</h6>
        <hr/>
        <div class="header-colors-indigators">
            <div class="row row-cols-auto g-3">
                <div class="col">
                    <div class="indigator headercolor1" id="headercolor1"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor2" id="headercolor2"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor3" id="headercolor3"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor4" id="headercolor4"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor5" id="headercolor5"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor6" id="headercolor6"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor7" id="headercolor7"></div>
                </div>
                <div class="col">
                    <div class="indigator headercolor8" id="headercolor8"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/resources/assets2/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/js/simplebar.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/js/metisMenu.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/highchart-3d.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/highstock.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/exporting.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/variable-pie.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/export-data.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/data.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/accessibility.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/select2/js/select2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/js/index.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/js/app.js"></script>
<script>
    new PerfectScrollbar('.email-navigation');
    new PerfectScrollbar('.email-list');
</script>
<script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.js"></script>
<script>
    $("#headercolor1").ready(function () {
        $("html").addClass("color-header headercolor1");
        $("html").removeClass("headercolor2 headercolor3 headercolor4 headercolor5 headercolor6 headercolor7 headercolor8");
    });
    $(document).ready(function () {
        $('#example').DataTable();
    });
    $(document).ready(digitalClock());
    (function($, undefined) {
        "use strict";
        $(function() {
            var $form = $( "#form" );
            var $input = $form.find( "input" );
            $input.on( "keyup", function( event ) {
                var selection = window.getSelection().toString();
                if ( selection !== '' ) {
                    return;
                }
                if ( $.inArray( event.keyCode, [38,40,37,39] ) !== -1 ) {
                    return;
                }
                var $this = $( this );
                var input = $this.val();
                var input = input.replace(/[\D\s\._\-]+/g, "");
                input = input ? parseInt( input, 10 ) : 0;
                $this.val( function() {
                    return ( input === 0 ) ? "" : input.toLocaleString( "en-US" );
                } );
            } );
            $form.on( "submit", function( event ) {
                var $this = $( this );
                var arr = $this.serializeArray();
                for (var i = 0; i < arr.length; i++) {
                    arr[i].value = arr[i].value.replace(/[($)\s\._\-]+/g, ''); // Sanitize the values.
                };
                console.log( arr );
                event.preventDefault();
            });
        });
    })(jQuery);
</script>
<script>
    $(document).ready(function () {
        var dataS = {
            "x": '0',
        };
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/resources/pages/StarterPage/homes",
            data: dataS,
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#MainContent').html(res);
                // document.body.style.cursor = 'default';
            },
            error: function (res) {
                if (res.status == 401) {
                    $(".logOutForm").submit();
                }
            }
        });

    });
    /*Tovarlarni toifalash */
    function ListClassProduct(x) {
        var dataS = {
            "id": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/main/resources/pages/ClassProduct/ListClassProduct",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }
    /* ?????????????????????????? ?????????????????? */
    function InitialDecisionRasp(x) {
        var dataS = {
            "id": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('#preloader').addClass('visually-hidden');
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ?????????????????????????? ?????????????????? */
    function ListInDec(selectedBar) {
        var dataS = {
            "selectedBar":selectedBar
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }

    /* ?????????????????????????????? ?????????????????? ?????????? */
    function InitialDecision(x) {
        alert(x)
        var dataS = {
            "id": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecision1",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ?????????? ?????????????????? */
    function InitialDecisionView(appId) {
        var dataS = {
            "appId": appId
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionView",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ???????????????????? */
    function Digests(x) {
        var dataS = {
            "x": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/DigestsPage",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);

            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ???????????????????? ?????? ???????? modal */
    function QiymatRejects(tov_id) {
        var dataS = {
            "tov_id": tov_id
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/QiymatRejectModal",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                console.log('clicked');
                $('#ModalSentMess').html(res);
                $modal = $('#ModalSentMess');
                $modal.modal('show');
            },
            error: function () {
                console.log("error");
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ???????????????????? ?????????????? modal */
    function QiymatConsult(tov_id) {
        var dataS = {
            "tov_id": tov_id
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/QiymatConsultModal",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                console.log('clicked');
                $('#ModalSentMess').html(res);
                $modal = $('#ModalSentMess');
                $modal.modal('show');
            },
            error: function () {
                console.log("error");
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ???????????????????? shartli modal */
    function QiymatShartli(tov_id) {
        var dataS = {
            "tov_id": tov_id
        }
        $.ajax({
            type: "GET",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/QiymatShartliModal",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                console.log('clicked');
                $('#ModalSentMess').html(res);
                $modal = $('#ModalSentMess');
                $modal.modal('show');
            },
            error: function () {
                console.log("error");
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* Error message */
    function ErrorMessage(x) {
        var dataS = {
            "x": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/resources/pages/ErrorPage/ErrorMessage.jsp",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    function RoleF(roleCode) {
        // alert(' roleCode --> ' + roleCode);
        var dataS = {
            "role": roleCode
        };
        $.post({
            <%--url: "${pageContext.servletContext.contextPath}/roleT/roleT",--%>
            url: "${pageContext.servletContext.contextPath}/checkRole/checkRole",
            async: false,
            data: dataS,
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                window.location.reload();
                $('#roleName').html(res.roleName);
                $('#fullName').html(res.fullName);
            },
            error: function (res) {
                if (res.status == 401) {
                    $(".logOutForm").submit();
                }
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ???????????? ?????????????????????? */
    function CostMonitoring(x) {
        var dataS = {
            "x": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/costmonitoring/resources/pages/CostMonitoring/MtcRepl/FiltrCM",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#MainContent').html(res);

            },
            error: function (res) {
            }
        });
    }
    /* ???????????????? ?????????????? */
    function LogicalControl(x) {
        var dataS = {
            "x": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/FilterLC",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
    /* ?????????????? ?????????????????? */
    function InternationalSurvay(x) {
        var dataS = {
            "x": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/FilterIS",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
                $('#preloader').addClass('visually-hidden');
            }
        });
    }
</script>
</body>

