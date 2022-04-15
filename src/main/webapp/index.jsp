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
//    String userId = (String) request.getSession().getAttribute("userId");
//    Integer userRole = (Integer) request.getSession().getAttribute("userRole");
//    String userName = (String) request.getSession().getAttribute("userName");
//    String userRoleName = (String) request.getSession().getAttribute("userRoleName");
//    String userLocation = (String) request.getSession().getAttribute("userLocation");
//    String userLocationName = (String) request.getSession().getAttribute("userLocationName");
//    String userPost = (String) request.getSession().getAttribute("userPost");
//    userRole = 8;
//    request.getSession().setAttribute("userRole", userRole);
//    request.getSession().setAttribute("userId", userId);
%>

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
            session.setAttribute("userName", "0");
            session.setAttribute("userLocation", "0");
            session.setAttribute("userPost", "0");
//            userRole = 0;
        } else {
            session.setAttribute("role", user.getRole());
            session.setAttribute("userRole", user.getRole());
            session.setAttribute("userId", user.getUserid());
            session.setAttribute("userName", user.getFullname());
            session.setAttribute("userLocation", user.getLocation());
            session.setAttribute("userPost", user.getPost());
//            userRole = user.getRole();
        }
    }
    Integer roleI = (Integer) session.getAttribute("role");
    String roleN = "";
    for (Role role : roleList) {
        if (role.getCode().equals(roleI)) {
            roleN = role.getName();
            System.out.println(user.getRole() + " ===>> " + user.getUserid() + " ===>> " + user.getId());
            System.out.println(user.getFullname() + " ===>> " + roleN);
            break;
        }
    }
%>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--favicon-->
<%--    <link rel="icon" href="<%=request.getContextPath()%>/resources/assets2/images/favicon-32x32.png" type="image/png"/>--%>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/emblem.png" type="image/x-icon">
    <!--plugins-->
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/css/highcharts.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css"
          rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-2.0.2.css"
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css"/>
    <title>Божхона қиймати</title>
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
<script>
    function clickEffect(e) {
        var d = document.createElement("div");
        d.className = "clickEffect";
        d.style.top = e.clientY + "px";
        d.style.left = e.clientX + "px";
        document.body.appendChild(d);
        d.addEventListener('animationend', function () {
            d.parentElement.removeChild(d);
        }.bind(this));
    }

    document.addEventListener('click', clickEffect);

</script>
<!--wrapper-->
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
                            <h4 class="logo-text">Божхона қиймати назорати</h4>
                        </div>
                    </div>
                    <div class="mobile-toggle-menu"><i class='bx bx-menu'></i></div>
                    <div class="top-menu-left d-none d-lg-block ps-3">
<%--                        <ul class="nav">--%>
<%--                            <li class="nav-item">--%>
<%--                                <a class="nav-link" href="app-emailbox.html"><i class='bx bx-envelope'></i></a>--%>
<%--                            </li>--%>
<%--                            <li class="nav-item">--%>
<%--                                <a class="nav-link" href="app-chat-box.html"><i class='bx bx-message'></i></a>--%>
<%--                            </li>--%>
<%--                            <li class="nav-item">--%>
<%--                                <a class="nav-link" href="app-fullcalender.html"><i class='bx bx-calendar'></i></a>--%>
<%--                            </li>--%>
<%--                            <li class="nav-item">--%>
<%--                                <a class="nav-link" href="app-to-do.html"><i class='bx bx-check-square'></i></a>--%>
<%--                            </li>--%>
<%--                            <li class="nav-item" style="display: none;">--%>
<%--                                <span><span class="f-w-600" id="roleName"><%=roleN%></span>: <span class="border-bottom"--%>
<%--                                                                                                   id="fullName"><%=user.getFullname()%></span></span>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
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
                                <%--<a class="nav-link" href="#"> <i class='bx bx-search'></i>
                                </a>--%>
                            </li>
                            <li class="nav-item dropdown dropdown-large">
<%--                                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button"--%>
<%--                                   data-bs-toggle="dropdown" aria-expanded="false"> <i class='bx bx-category'></i>--%>
<%--                                </a>--%>
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
<%--                                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative" href="#"--%>
<%--                                   role="button" data-bs-toggle="dropdown" aria-expanded="false"> <span--%>
<%--                                        class="alert-count w-50">71</span>--%>
<%--                                    <i class='bx bx-bell'></i><i class='bx bxs-bell bx-tada'></i>--%>
<%--                                </a>--%>
                                <div class="dropdown-menu dropdown-menu-end">
<%--                                    <a href="javascript:;">--%>
<%--                                        <div class="msg-header">--%>
<%--                                            <p class="msg-header-title">Notifications</p>--%>
<%--                                            <p class="msg-header-clear ms-auto">Marks all as read</p>--%>
<%--                                        </div>--%>
<%--                                    </a>--%>
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
<%--                                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative" href="#"--%>
<%--                                   role="button" data-bs-toggle="dropdown" aria-expanded="false"> <span--%>
<%--                                        class="alert-count">8</span>--%>
<%--                                    <i class='bx bx-comment'></i>--%>
<%--                                </a>--%>
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
                            <li class="nav-item dropdown dropdown-large">
                                <a type="button" class="btn btn-sm radius-30 text-white" style="cursor: pointer; background-color: #0a58ca; font-size: 24px" id="id_date"></a>
                                <a type="button" class="btn btn-sm radius-30 text-white" style="cursor: pointer; background-color: #0a58ca; font-size: 24px" id="id_clock"></a>
                                <script>
                                    function digitalClock() {
                                        var date = new Date();
                                        var hours = date.getHours();
                                        var minutes = date.getMinutes();
                                        var seconds = date.getSeconds();
                                        var day = date.getDate();
                                        var month = date.getMonth();
                                        var years = date.getFullYear()
                                        //* добавление ведущих нулей */
                                        if (hours < 10) hours = "0" + hours;
                                        if (minutes < 10) minutes = "0" + minutes;
                                        if (seconds < 10) seconds = "0" + seconds;
                                        document.getElementById("id_date").innerHTML = years + "/" + month + "/" + day;
                                        document.getElementById("id_clock").innerHTML =hours + ":" + minutes + ":" + seconds;

                                        setTimeout("digitalClock()", 1000);
                                    };
                                </script>
<%--                                <form id="form" method="post" action="">--%>

<%--                                    <div class="flex">--%>
<%--                                        <span class="currency">$</span>--%>
<%--                                        <input id="amount" name="amount" type="text" maxlength="40" />--%>
<%--                                    </div>--%>
<%--                                </form>--%>

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
                        <%--							<div style="overflow-y: auto; max-height: 70vh;">--%>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <%
                                int i = 1;
                                String selected = "", active = "", fw = "", fa = "";
                                for (Role role : roleList) {
                                    if (role.getCode().equals(user.getRole())) {
//                                    if (role.getCode().equals(8)) {
                                        selected = "selected";
                                        active = "active";
                                        fw = "f-w-600";
                                        fa = "fa-solid fa-user-check text-white";
                                    } else {
                                        selected = "";
                                        active = "";
                                        fw = "";
                                        fa = "fa-solid fa-user";
                                    }
                            %>
                            <li class="<%=selected%> <%=active%> <%=fw%>"
                                title="<%=role.getCode()%>. <%--<fmt:message key="rolUser" bundle="${resourceBundle}"/>--%>">
                                <a
                                        href="javascript:RoleF('<%=role.getCode()%>')"
                                        class="dropdown-item f-w-600"><i
                                        class="<%=fa%>" id="iconU<%=i%>"></i> <%=role.getName()%>
                                </a>
                            </li>
                            <% i++;
                            }%>
                            <hr>
                            <li class="text-c-red"
                                title="Тизимдан чиқиш<%--<fmt:message key="signOut" bundle="${resourceBundle}"/>--%>"><a
                                    href="${pageContext.request.contextPath}/exit.do" class="dropdown-item">
                                <i class="fa-solid fa-right-from-bracket text-c-red"></i> Чиқиш<%--<fmt:message key="logout" bundle="${resourceBundle}"/>--%>
                            </a>
                            </li>
                        </ul>
                        <%--							</div>--%>
                        <ul class="dropdown-menu dropdown-menu-end" style="display: none;">
                            <li><a class="dropdown-item" href="javascript:;"><i class="bx bx-user"></i><span>Фойдаланувчи</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i
                                    class="bx bx-cog"></i><span>Созламалар</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-home-circle'></i><span>Асосий ойна</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-dollar-circle'></i><span>Валюта курслари</span></a>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-download'></i><span>Юкланган хужжатлар</span></a>
                            </li>
                            <li>
                                <div class="dropdown-divider mb-0"></div>
                            </li>
                            <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-log-out-circle'></i><span>Чиқиш</span></a>
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
                    <h4 class="logo-text">Synadmin</h4>
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
                            <div class="menu-title">Товарларни тоифалаш</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="index.html"><i class="bx bx-right-arrow-alt"></i>Analytics</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="index2.html"><i class="bx bx-right-arrow-alt"></i>Sales</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="index3.html"><i class="bx bx-right-arrow-alt"></i>eCommerce</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="index4.html"><i class="bx bx-right-arrow-alt"></i>Alternate</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="index5.html"><i class="bx bx-right-arrow-alt"></i>Hospitality</a>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
                    <%
//                        if (userRole == 1 || userRole == 6 || userRole == 7 || userRole == 8) {
//                            System.out.println("userRole212132323==" + userRole);
                    %> <%--todo (ҲББ Тўловлар бошлиғи ҳамда ҲББ Тўловлар ходими менюси)--%>
                    <li>
                        <%--							<a href="javascript:InitialDecisionRasp(0)" class="has-arrow">--%>
                        <a href="javascript:ListInDec(0)" class="has-arrow">
                            <div class="parent-icon"><i class="bx bx-category"></i>
                            </div>
                            <div class="menu-title">Дастлабки қарор</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="app-emailbox.html"><i class="bx bx-right-arrow-alt"></i>Email</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="app-chat-box.html"><i class="bx bx-right-arrow-alt"></i>Chat Box</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="app-file-manager.html"><i class="bx bx-right-arrow-alt"></i>File Manager</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="app-contact-list.html"><i class="bx bx-right-arrow-alt"></i>Contatcs</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="app-to-do.html"><i class="bx bx-right-arrow-alt"></i>Todo List</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="app-invoice.html"><i class="bx bx-right-arrow-alt"></i>Invoice</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="app-fullcalender.html"><i class="bx bx-right-arrow-alt"></i>Calendar</a>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
<%--                    <%}%>--%>
                    <li>
                        <a class="has-arrow" href="javascript:ErrorMessage(0);">
                            <div class="parent-icon"><i class="bx bx-line-chart"></i>
                            </div>
                            <div class="menu-title">Қиймат мониторинги</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="charts-apex-chart.html"><i class="bx bx-right-arrow-alt"></i>Apex</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="charts-chartjs.html"><i class="bx bx-right-arrow-alt"></i>Chartjs</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="charts-highcharts.html"><i class="bx bx-right-arrow-alt"></i>Highcharts</a>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:ErrorMessage(0);">
                            <div class="parent-icon"><i class='bx bx-bookmark-heart'></i>
                            </div>
                            <div class="menu-title">Мантиқий назорат</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="widgets.html"><i class="bx bx-right-arrow-alt"></i>Widgets</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-alerts.html"><i class="bx bx-right-arrow-alt"></i>Alerts</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-accordions.html"><i class="bx bx-right-arrow-alt"></i>Accordions</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-buttons.html"><i class="bx bx-right-arrow-alt"></i>Buttons</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-cards.html"><i class="bx bx-right-arrow-alt"></i>Cards</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-list-groups.html"><i class="bx bx-right-arrow-alt"></i>List Groups</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-media-object.html"><i class="bx bx-right-arrow-alt"></i>Media Objects</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-modals.html"><i class="bx bx-right-arrow-alt"></i>Modals</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-navs-tabs.html"><i class="bx bx-right-arrow-alt"></i>Navs & Tabs</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-navbar.html"><i class="bx bx-right-arrow-alt"></i>Navbar</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-popovers-tooltips.html"><i class="bx bx-right-arrow-alt"></i>Popovers & Tooltips</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-progress-bars.html"><i class="bx bx-right-arrow-alt"></i>Progress</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-spinners.html"><i class="bx bx-right-arrow-alt"></i>Spinners</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-notifications.html"><i class="bx bx-right-arrow-alt"></i>Notifications</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="component-avtars-chips.html"><i class="bx bx-right-arrow-alt"></i>Avatrs & Chips</a>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:ErrorMessage(0);">
                            <div class="parent-icon"><i class="bx bx-lock"></i>
                            </div>
                            <div class="menu-title">Халқаро сўровнома</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="authentication-signin.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign In</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="authentication-signup.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign Up</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="authentication-signin-with-header-footer.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign In with Header & Footer</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="authentication-signup-with-header-footer.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign Up with Header & Footer</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="authentication-forgot-password.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Forgot Password</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="authentication-reset-password.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Reset Password</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="authentication-lock-screen.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Lock Screen</a>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:ErrorMessage(0);">
                            <div class="parent-icon icon-color-6"><i class="bx bx-donate-blood"></i>
                            </div>
                            <div class="menu-title">Кўрсатма хатлар</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="user-profile.html"><i class="bx bx-right-arrow-alt"></i>User Profile</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="timeline.html"><i class="bx bx-right-arrow-alt"></i>Timeline</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="pricing-table.html"><i class="bx bx-right-arrow-alt"></i>Pricing</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a class="has-arrow" href="javascript:;"><i class="bx bx-right-arrow-alt"></i>Errors</a>--%>
                        <%--									<ul>--%>
                        <%--										<li> <a href="errors-404-error.html"><i class="bx bx-right-arrow-alt"></i>404 Error</a>--%>
                        <%--										</li>--%>
                        <%--										<li> <a href="errors-500-error.html"><i class="bx bx-right-arrow-alt"></i>500 Error</a>--%>
                        <%--										</li>--%>
                        <%--										<li> <a href="errors-coming-soon.html"><i class="bx bx-right-arrow-alt"></i>Coming Soon</a>--%>
                        <%--										</li>--%>
                        <%--									</ul>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:Digests(0);">
                            <div class="parent-icon"><i class='bx bx-message-square-edit'></i>
                            </div>
                            <div class="menu-title">Справочник</div>
                        </a>
                        <%--							<ul>--%>
                        <%--								<li> <a href="form-elements.html"><i class="bx bx-right-arrow-alt"></i>Form Elements</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-input-group.html"><i class="bx bx-right-arrow-alt"></i>Input Groups</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-layouts.html"><i class="bx bx-right-arrow-alt"></i>Forms Layouts</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-validations.html"><i class="bx bx-right-arrow-alt"></i>Form Validation</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-wizard.html"><i class="bx bx-right-arrow-alt"></i>Form Wizard</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-text-editor.html"><i class="bx bx-right-arrow-alt"></i>Text Editor</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-file-upload.html"><i class="bx bx-right-arrow-alt"></i>File Upload</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-date-time-pickes.html"><i class="bx bx-right-arrow-alt"></i>Date Pickers</a>--%>
                        <%--								</li>--%>
                        <%--								<li> <a href="form-select2.html"><i class="bx bx-right-arrow-alt"></i>Select2</a>--%>
                        <%--								</li>--%>
                        <%--							</ul>--%>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- end navigation-->
    </div>
    <!-- end header wrapper-->
    <!-- start page wrapper -->
    <%--todo Асосий----------------------------------------------------қисми------------------------дан--%>
    <div class="page-wrapper" id="MainContent" role="main" style="min-height: 850px!important;">
        <%--todo страницаларни чақириш жойи--%>
    </div>
    <%--todo Асосий----------------------------------------------------қисми------------------------гача--%>
    <!-- end page wrapper -->
    <!-- start overlay-->
    <div class="search-overlay"></div>
    <div class="overlay toggle-icon"></div>
    <!-- end overlay-->
    <!-- Start Back To Top Button --> <a href="javaScript:;" class="back-to-top"><i class='bx bxs-up-arrow-alt'></i></a>
    <!-- End Back To Top Button -->
    <%--		<footer class="page-footer">--%>
    <%--			<p class="mb-0">Copyright © 2021. All right reserved.</p>--%>
    <%--		</footer>--%>
</div>
<!--end wrapper-->
<!--start switcher-->
<div class="switcher-wrapper">
    <div class="switcher-btn"><i class='bx bx-cog bx-spin'></i>
    </div>
    <div class="switcher-body">
        <div class="d-flex align-items-center">
            <h5 class="mb-0 text-uppercase">Theme Customizer</h5>
            <button type="button" class="btn-close ms-auto close-switcher" aria-label="Close"></button>
        </div>
        <hr/>
        <h6 class="mb-0">Theme Styles</h6>
        <hr/>
        <div class="d-flex align-items-center justify-content-between">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="lightmode" checked>
                <label class="form-check-label" for="lightmode">Ёрқин ранг</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="darkmode">
                <label class="form-check-label" for="darkmode">Қора ранг</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="semidark">
                <label class="form-check-label" for="semidark">Ярим қора ранг</label>
            </div>
        </div>
        <hr/>
        <div class="form-check">
            <input class="form-check-input" type="radio" id="minimaltheme" name="flexRadioDefault">
            <label class="form-check-label" for="minimaltheme">Дастлабки холат</label>
        </div>
        <hr/>
        <h6 class="mb-0">Ранглар</h6>
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
<!-- end switcher -->
<!-- Bootstrap JS -->
<script src="<%=request.getContextPath()%>/resources/assets2/js/bootstrap.bundle.min.js"></script>
<!-- plugins -->
<script src="<%=request.getContextPath()%>/resources/assets2/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/js/simplebar.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/js/metisMenu.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/exporting.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/variable-pie.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/export-data.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/js/accessibility.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
<script>
    new PerfectScrollbar('.dashboard-top-countries');
</script>
<script src="<%=request.getContextPath()%>/resources/assets2/js/index.js"></script>
<!-- app JS-->
<script src="<%=request.getContextPath()%>/resources/assets2/js/app.js"></script>


<!--   -->
<script>
    new PerfectScrollbar('.email-navigation');
    new PerfectScrollbar('.email-list');
</script>
<%--<script src="<%=request.getContextPath()%>/resources/assets2/js/bootstrap.bundle.min.js"></script>--%>
<!--plugins-->
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/datatable/js/jquery.dataTables.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/resources/assets2/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>--%>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
    $(document).ready(digitalClock());
    (function($, undefined) {

        "use strict";

        // When ready.
        $(function() {

            var $form = $( "#form" );
            var $input = $form.find( "input" );

            $input.on( "keyup", function( event ) {


                // When user select text in the document, also abort.
                var selection = window.getSelection().toString();
                if ( selection !== '' ) {
                    return;
                }

                // When the arrow keys are pressed, abort.
                if ( $.inArray( event.keyCode, [38,40,37,39] ) !== -1 ) {
                    return;
                }


                var $this = $( this );

                // Get the value.
                var input = $this.val();

                var input = input.replace(/[\D\s\._\-]+/g, "");
                input = input ? parseInt( input, 10 ) : 0;

                $this.val( function() {
                    return ( input === 0 ) ? "" : input.toLocaleString( "en-US" );
                } );
            } );

            /**
             * ==================================
             * When Form Submitted
             * ==================================
             */
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


<!--   -->


<script>
    $(document).ready(function () {
        var dataS = {
            "x": '0',
        };
        var tipform = "<%=request.getContextPath()%>/resources/pages/StarterPage/homes.jsp";
        $.post({
            async: false,
            url: tipform,
            data: dataS,
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#MainContent').html(res);
                document.body.style.cursor = 'default';
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
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }


    /* Маълумотларни твқсимлаш */
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
                $("#loading").show();
            },
            complete: function () {
                $("#loading").hide();
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }

    /* Маълумотларни твқсимлаш */
    function ListInDec(x) {
        var dataS = {
            "id": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            beforeSend: function () {
                $("#loading").show();
            },
            complete: function () {
                $("#loading").hide();
            },
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }

    /* Маълумотларнинг инспектор қисми */
    function InitialDecision(x) {
        var dataS = {
            "id": x
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecision1",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }

    /* Ариза тафсилоти */
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
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }

    /* Справочник */
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
            success: function (res) {
                $('div#MainContent').html(res);

            },
            error: function (res) {
            }
        });
    }

    /* Справочник рад этиш modal */
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
            success: function (res) {
                console.log('clicked');
                $('#ModalSentMess').html(res);
                $modal = $('#ModalSentMess');
                $modal.modal('show');
            },
            error: function () {
                console.log("error");
            }
        });
    }

    /* Справочник консалт modal */
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
            success: function (res) {
                console.log('clicked');
                $('#ModalSentMess').html(res);
                $modal = $('#ModalSentMess');
                $modal.modal('show');
            },
            error: function () {
                console.log("error");
            }
        });
    }

    /* Справочник shartli modal */
    function QiymatShartli(tov_id) {
        var dataS = {
            "tov_id": tov_id
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/digests/resources/pages/Digests/QiymatShartliModal",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                console.log('clicked');
                $('#ModalSentMess').html(res);
                $modal = $('#ModalSentMess');
                $modal.modal('show');
            },
            error: function () {
                console.log("error");
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
            success: function (res) {
                $('div#MainContent').html(res);

            },
            error: function (res) {
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
            success: function (res) {
                window.location.reload();
                $('#roleName').html(res.roleName);
                $('#fullName').html(res.fullName);
            },
            error: function (res) {
                if (res.status == 401) {
                    $(".logOutForm").submit();
                }
            }
        });
    }

</script>
</body>

