<%--<!DOCTYPE html>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<%--%>
<%--    String userId = (String) request.getSession().getAttribute("userId");--%>
<%--    String userName = (String) request.getSession().getAttribute("userName");--%>
<%--    Integer userRole = (Integer) request.getSession().getAttribute("userRole");--%>
<%--    String userRoleName = (String) request.getSession().getAttribute("userRoleName");--%>
<%--    String userLocation = (String) request.getSession().getAttribute("userLocation");--%>
<%--    String userLocationName = (String) request.getSession().getAttribute("userLocationName");--%>
<%--    String userPost = (String) request.getSession().getAttribute("userPost");--%>
<%--%>--%>
<%--<head>--%>
<%--    <!-- Required meta tags -->--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <!--favicon-->--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/images/favicon-32x32.png" type="image/png"/>--%>
<%--    <!--plugins-->--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>--%>
<%--    <!-- loader-->--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/pace.min.css" rel="stylesheet"/>--%>
<%--    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>--%>
<%--    <!-- Bootstrap CSS -->--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/app.css" rel="stylesheet">--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/icons.css" rel="stylesheet">--%>
<%--    <!-- Theme Style CSS -->--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css"/>--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css"/>--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css"/>--%>

<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />--%>
<%--    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />--%>
<%--    <!-- loader-->--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">--%>
<%--</head>--%>

<%--<body>--%>


<%--<!--wrapper-->--%>

<%--<!--start page wrapper -->--%>
<%--<div class="page-content">--%>
<%--    <!--start email wrapper-->--%>
<%--    <div class="row">--%>
<%--        <div class="col" style="opacity: 0.8" onclick="javascript:ListInDecApp('100')">--%>
<%--            <div class="card bg-light-danger">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-danger">--%>
<%--                        <h4 class="my-1 text-danger">30</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-danger ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-danger rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ЯНГИ</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card bg-light-success">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-success">--%>
<%--                        <h4 class="my-1 text-success">29</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-success ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-success rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ТАҚСИМЛАНГАН</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card bg-light-warning">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-warning">--%>
<%--                        <h4 class="my-1 text-warning">145</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-warning text-warning ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-warning rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ЖАРАЁНДА</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-secondary">--%>
<%--                        <h4 class="my-1 text-secondary">500</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-success ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-secondary rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ИМЗОГА КИРИТИЛГАН</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card bg-light-danger">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-danger">--%>
<%--                        <h4 class="my-1 text-danger">30</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-danger ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-danger rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ИМЗОЛАНГАН</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card bg-light-success">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-success">--%>
<%--                        <h4 class="my-1 text-success">29</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-success ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-success rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ТУЗАТИШ УЧУН ҚАЙТАРИЛГАН</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card bg-light-warning">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-warning">--%>
<%--                        <h4 class="my-1 text-warning">145</h4>--%>
<%--                        <p class="mb-0 font-13 ">та ариза</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-warning text-warning ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-warning rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">БЕКОР ҚИЛИНГАН</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col" style="opacity: 0.8">--%>
<%--            <div class="card">--%>
<%--                <div class="d-flex align-items-center m-2 rounded-top">--%>
<%--                    <div class="text-secondary">--%>
<%--                        <h4 class="my-1 text-secondary">500</h4>--%>
<%--                        <p class="mb-0 font-13 ">та қарор</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-success ms-auto "><i class="bx bxs-file-blank"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-center  bg-secondary rounded-bottom">--%>
<%--                    <div class="">--%>
<%--                        <p class="mb-0 font-13 text-light m-2">ДАСТЛАБКИ ҚАРОР</p>--%>
<%--                    </div>--%>
<%--                    <div class="widgets-icons bg-light-success text-light ms-auto m-2"><i class="bx bx-info-circle"></i>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--    <!--end email wrapper-->--%>
<%--    <div class="col-12 col-lg-12">--%>
<%--        <div class="card">--%>
<%--            <div class="card-body">--%>
<%--                <div class="fm-search">--%>
<%--                    <div class="mb-0">--%>
<%--                        <div class="d-flex justify-content-center">--%>
<%--                                <div class="col-md-3 m-2">--%>
<%--                                    <label class="text-dark">Мақоми</label>--%>
<%--                                    <select class="form-select shadow-sm" id="validationTooltip04" required="">--%>
<%--                                        <option selected="" disabled="disabled" value="" ><p class="text-muted">Ариза мақоми</p></option>--%>
<%--                                        <option value="100">Янги</option>--%>
<%--                                        <option value="110">Кўриб чиқиш учун тақсимланган</option>--%>
<%--                                        <option value="145">Тасдиқлашга тайрланган</option>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-2 m-2">--%>
<%--                                    <div class="">--%>
<%--                                        <label class="text-dark">ТИФ ТН коди</label>--%>
<%--                                        <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-2 m-2">--%>
<%--                                    <div class="">--%>
<%--                                        <label class="text-dark">Шахс тури</label>--%>
<%--                                        <select class="form-select shadow-sm" id="validationTooltip05" required="" >--%>
<%--                                            <option selected="" disabled="disabled" value="" ><p class="text-muted">Барчаси</p></option>--%>
<%--                                            <option value="100">Жисмоний шахс</option>--%>
<%--                                            <option value="110">Юридик шахс</option>--%>
<%--                                        </select>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-1 m-2">--%>
<%--                                    <div class="">--%>
<%--                                        <label class="text-dark">Сана</label>--%>
<%--                                        <input class="result form-control shadow-sm" type="date" id="date" placeholder="йил-ой-кун">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="">--%>
<%--                                    <p class="mt-5 text-dark">дан</p>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-1 m-2">--%>
<%--                                    <div class="">--%>
<%--                                        <label></label>--%>
<%--                                        <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="">--%>
<%--                                    <p class="mt-5 text-dark">гача</p>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-2 m-2">--%>
<%--                                    <div class="">--%>
<%--                                        <button type="button" class="btn btn-primary mt-3"><i class='bx bx-refresh'></i>Янгилаш</button>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="row mt-3">--%>
<%--                    <div class="col-12 col-lg-12">--%>
<%--                        <div class="table-responsive">--%>
<%--                            <table id="example1"  class="table table-striped table-bordered table-sm table-responsive">--%>
<%--                                <thead class="table-light">--%>
<%--                                <tr>--%>
<%--                                    <th style="border-style: dotted">т/р</th>--%>
<%--                                    <th style="border-style: dotted">Ариза рақами</th>--%>
<%--                                    <th style="border-style: dotted">Мақоми</th>--%>
<%--                                    <th style="border-style: dotted">Ариза санаси</th>--%>
<%--                                    <th style="border-style: dotted">Мафаатдор шахс</th>--%>
<%--                                    <th style="border-style: dotted">Савдо қилувчи</th>--%>
<%--                                    <th style="border-style: dotted">Ишлаб чиқарувчи</th>--%>
<%--                                    <th style="border-style: dotted">Сотувчи мамлакат</th>--%>
<%--                                    <%if (userRole == 7) {%>--%>
<%--                                    <th style="border-style: dotted">Ходим</th>--%>
<%--                                    <th style="border-style: dotted">Тақсимлаш</th>--%>
<%--                                    <%}%>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
<%--                                <tbody>--%>
<%--                                <c:set var="appId"/>--%>
<%--                                <c:forEach var="notSorted" items="${notSortedList}" varStatus="i">--%>
<%--                                    <c:set var="appId" value="${notSorted.id}"/>--%>
<%--                                    <c:set var="rowCount" value="${0}"/>--%>
<%--                                    <tr>--%>
<%--                                        <td>${i.index + 1}</td>--%>
<%--                                        <td id="appIdF"><a type="button" class="btn btn-primary btn-sm radius-30 px-4" href="javascript:InitialDecisionView('${notSorted.id}')"--%>
<%--                                                           class="text-primary font-weight-bold"><u>${notSorted.appNum}</u></a>--%>
<%--                                        </td>--%>
<%--                                        <td><div class="badge rounded-pill text-success bg-light-success p-2 text-uppercase px-3"><i class='bx bxs-circle me-1'></i>${notSorted.statusNm}</div></td>--%>
<%--                                        <td>${notSorted.insTime.toLocaleString()}</td>--%>
<%--                                        <td>${notSorted.personFio}</td>--%>
<%--                                        <td>${notSorted.customerCountry}-${notSorted.customerCountryNm}</td>--%>
<%--                                        <td>${notSorted.customerCountry}-${notSorted.customerCountryNm}</td>--%>
<%--                                        <td>${notSorted.senderCountry}-${notSorted.senderCountryNm}</td>--%>
<%--                                        <%if (userRole == 7) {%>--%>
<%--                                        <td>--%>
<%--                                            <select class="form-select shadow-sm" required="" id="userIdF_${i.index + 1}"--%>
<%--                                                    name="userId_${i.index + 1}">--%>
<%--                                                <option value="notSelected"></option>--%>
<%--                                                <c:forEach var="userSelect" items="${userSelectList}" varStatus="i">--%>
<%--                                                    varStatus="iUser">--%>
<%--                                                    <option value="${userSelect.id}"><u--%>
<%--                                                    >${i.index + 1} - ${userSelect.userName}</u></option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                        </td>--%>
<%--                                        <td style="border-style: dotted">--%>

<%--                                            <button type="button" class="btn btn-success btn-block"--%>
<%--                                                    onclick="saveInDecRaspIns('${notSorted.id}', $('#userIdF_${i.index + 1}').val(), ${i.index + 1})">--%>
<%--                                                <i class='bx bxs-edit'></i>--%>
<%--                                            </button>--%>

<%--                                        </td>--%>
<%--                                        <%}%>--%>
<%--                                    </tr>--%>
<%--                                </c:forEach>--%>
<%--                                &lt;%&ndash;                                        <td><div class="badge rounded-pill text-success bg-light-success p-2 text-uppercase px-3"><i class='bx bxs-circle me-1'></i>FulFilled</div></td>&ndash;%&gt;--%>
<%--                                &lt;%&ndash;                                        <td><div class="badge rounded-pill text-info bg-light-info p-2 text-uppercase px-3"><i class='bx bxs-circle align-middle me-1'></i>Confirmed</div></td>&ndash;%&gt;--%>
<%--                                &lt;%&ndash;                                        <td><div class="badge rounded-pill text-warning bg-light-warning p-2 text-uppercase px-3"><i class='bx bxs-circle align-middle me-1'></i>Partially shipped</div></td>&ndash;%&gt;--%>
<%--                                </tbody>--%>
<%--                            </table>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="col-12 col-lg-12">--%>
<%--                        <div class="table-responsive">--%>
<%--                            <table id="example2"  class="table table-striped table-bordered table-sm table-responsive">--%>
<%--                                <thead class="table-light">--%>
<%--                                <tr>--%>
<%--                                    <th style="border-style: dotted">т/р</th>--%>
<%--                                    <th style="border-style: dotted">Ариза рақами</th>--%>
<%--                                    <th style="border-style: dotted">Мақоми</th>--%>
<%--                                    <th style="border-style: dotted">Ариза санаси</th>--%>
<%--                                    <th style="border-style: dotted">Мафаатдор шахс</th>--%>
<%--                                    <th style="border-style: dotted">Савдо қилувчи</th>--%>
<%--                                    <th style="border-style: dotted">Сотувчи мамлакат</th>--%>
<%--                                    <th style="border-style: dotted">Кимга тақсимланган</th>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
<%--                                <tbody>--%>
<%--                                <c:forEach var="sorted" items="${sortedList}" varStatus="i">--%>
<%--                                    <tr>--%>
<%--                                        <td>${i.index+1}</td>--%>
<%--                                        <td><a type="button" class="btn btn-primary btn-sm radius-30 px-4" href="javascript:InitialDecisionView('${sorted[0]}')"--%>
<%--                                               class="text-primary font-weight-bold"><u>${sorted[6]}</u></a></td>--%>
<%--                                        <td><div class="badge rounded-pill text-info bg-light-info p-2 text-uppercase px-3"><i class='bx bxs-circle align-middle me-1'></i>${sorted[25]}</div></td>--%>
<%--                                        <td>${sorted[1]}</td>--%>
<%--                                        <td>${sorted[14]}</td>--%>
<%--                                        <td>${sorted[9]}-${sorted[8]}</td>--%>
<%--                                        <td>${sorted[21]}-${sorted[22]}</td>--%>
<%--                                        <td>${sorted[31]}</td>--%>
<%--                                    </tr>--%>
<%--                                </c:forEach>--%>
<%--                                </tbody>--%>
<%--                            </table>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="col-12 col-lg-12">--%>
<%--                        <div class="table-responsive">--%>
<%--                            <table id="example3"  class="table table-striped table-bordered table-sm table-responsive">--%>
<%--                                <thead class="table-light">--%>
<%--                                <tr>--%>
<%--                                    <th style=" border-style: dotted">т/р</th>--%>
<%--                                    <th style=" border-style: dotted">Ариза рақами</th>--%>
<%--                                    <th style=" border-style: dotted">Холати</th>--%>
<%--                                    <th style=" border-style: dotted">Ариза санаси</th>--%>
<%--                                    <th style=" border-style: dotted">Манфаатдор шахс</th>--%>
<%--                                    <th style=" border-style: dotted">Қарор рақами</th>--%>
<%--                                    <th style=" border-style: dotted">Қарор санаси</th>--%>
<%--                                    <th style=" border-style: dotted">Амал қилиш муддати</th>--%>
<%--                                    <th style=" border-style: dotted">Етказиб бериш шарти</th>--%>
<%--                                    <th style=" border-style: dotted">Бекор қилиш санаси</th>--%>
<%--                                    <th style=" border-style: dotted">Инспектор</th>--%>
<%--                                    <th style=" border-style: dotted">Pdf</th>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
<%--                                <tbody>--%>
<%--                                <c:forEach var="terms" items="${termsList}" varStatus="i">--%>
<%--                                    <tr>--%>
<%--                                        <td>${i.index+1}</td>--%>
<%--                                        <td><a type="button" class="btn btn-primary btn-sm radius-30 px-4" href="javascript:InitialDecisionView('${terms[0]}')"--%>
<%--                                               class="text-primary font-weight-bold"><u>${terms[6]}</u></a></td>--%>
<%--                                        <td><div class="badge rounded-pill text-warning bg-light-warning p-2 text-uppercase px-3"><i class='bx bxs-circle align-middle me-1'></i>${terms[28]}</div></td>--%>
<%--                                        <td>${terms[1]}</td>--%>
<%--                                        <td>${terms[14]}</td>--%>
<%--                                        <td>${terms[9]}-${terms[8]}</td>--%>
<%--                                        <td>${terms[9]}-${terms[8]}</td>--%>
<%--                                        <td>${terms[9]}-${terms[8]}</td>--%>
<%--                                        <td>${terms[9]}-${terms[8]}</td>--%>
<%--                                        <td>${terms[9]}-${terms[8]}</td>--%>
<%--                                        <td>${terms[30]}</td>--%>
<%--                                        <td class=" "><a--%>
<%--                                                href="<%=request.getContextPath()%>/decisionPdfDownload?appId=${terms[0]}&cmdtId=${terms[32]}"--%>
<%--                                                class="btn btn-primary btn-xs"><i class="fa fa-file-pdf-o"></i></a></td>--%>
<%--                                    </tr>--%>
<%--                                </c:forEach>--%>
<%--                                </tbody>--%>
<%--                            </table>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <!--end row-->--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<!--end page wrapper -->--%>
<%--<!--end wrapper -->--%>
<%--<script>--%>
<%--    $('.datepicker').pickadate({--%>
<%--        selectMonths: true,--%>
<%--        selectYears: true--%>
<%--    }),--%>
<%--        $('.timepicker').pickatime()--%>
<%--</script>--%>
<%--<script>--%>
<%--    $(function () {--%>
<%--        $('#date-time').bootstrapMaterialDatePicker({--%>
<%--            format: 'DD-MM-YYYY',--%>
<%--            closeOnClear: false--%>
<%--        });--%>
<%--        $('#date').bootstrapMaterialDatePicker({--%>
<%--            time: false,--%>
<%--            closeOnClear: true--%>
<%--        });--%>
<%--        $('#date2').bootstrapMaterialDatePicker({--%>
<%--            time: false,--%>


<%--        });--%>
<%--        $('#time').bootstrapMaterialDatePicker({--%>
<%--            date: false,--%>
<%--            format: 'HH:mm',--%>
<%--            closeOnClear: false--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%--<script>--%>

<%--    function saveInDecRaspIns(appId, inspectorId, rowNum) {--%>
<%--        var inspectorName = $('#userIdF_' + rowNum + ' option:selected').text();--%>
<%--        alert(appId + ', ' + inspectorId + ', ' + inspectorName);--%>
<%--        var dataS = {--%>
<%--            "appId": appId,--%>
<%--            "inspectorId": inspectorId,--%>
<%--            "inspectorName": inspectorName--%>
<%--        }--%>
<%--        $.ajax({--%>
<%--            type: "POST",--%>
<%--            data: dataS,--%>
<%--            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp1",--%>
<%--            dataType: "html",--%>
<%--            header: 'Content-type: text/html; charset=utf-8',--%>
<%--            success: function (res) {--%>
<%--                var typeMessage = '';--%>
<%--                var titletexts = '';--%>
<%--                var textText = '';--%>
<%--                if (inspectorId == 'notSelected') {--%>
<%--                    typeMessage = 'error';--%>
<%--                    titletexts = 'Ариза тақсиманишида хатолик!';--%>
<%--                    textText = 'Тақсимлаш учун ходим танланмаган';--%>
<%--                } else {--%>
<%--                    typeMessage = 'success';--%>
<%--                    titletexts = 'Ариза мувофақиятли сақланди!';--%>
<%--                    textText = 'Ариза ' +inspectorName+' га тақсимланди';--%>
<%--                }--%>
<%--                $('div#MainContent').html(res);--%>
<%--                // $('button#messageSucces').css({'display': ''});--%>
<%--                // $('button#messageSucces').click();--%>
<%--                new PNotify({--%>
<%--                    title: titletexts,--%>
<%--                    text: textText,--%>
<%--                    type: typeMessage,--%>
<%--                    styling: 'bootstrap3'--%>
<%--                });--%>
<%--            },--%>
<%--            error: function (res) {--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>

<%--    $(document).ready(function () {--%>
<%--        $('#example1').DataTable({--%>
<%--            "language": {--%>
<%--                "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",--%>
<%--                "infoFiltered": "(_MAX_ та маълумот сараланди)",--%>
<%--                "infoEmpty": "Маълумотлар топилмади",--%>
<%--                "info": "Жами _PAGES_ та, _PAGE_-сахифа ",--%>
<%--                "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",--%>
<%--                "Show": "Кўрсатилмоқда",--%>
<%--                "search": "Излаш",--%>
<%--                "paginate": {--%>
<%--                    "next": "Кейинги",--%>
<%--                    "previous": "Олдинги",--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--    $(document).ready(function () {--%>
<%--        $('#example2').DataTable({--%>
<%--            "language": {--%>
<%--                "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",--%>
<%--                "infoFiltered": "(_MAX_ та маълумот сараланди)",--%>
<%--                "infoEmpty": "Маълумотлар топилмади",--%>
<%--                "info": "Жами _PAGES_ та, _PAGE_-сахифа ",--%>
<%--                "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",--%>
<%--                "Show": "Кўрсатилмоқда",--%>
<%--                "search": "Излаш",--%>
<%--                "paginate": {--%>
<%--                    "next": "Кейинги",--%>
<%--                    "previous": "Олдинги",--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--    $(document).ready(function () {--%>
<%--        $('#example3').DataTable({--%>
<%--            "language": {--%>
<%--                "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",--%>
<%--                "infoFiltered": "(_MAX_ та маълумот сараланди)",--%>
<%--                "infoEmpty": "Маълумотлар топилмади",--%>
<%--                "info": "Жами _PAGES_ та, _PAGE_-сахифа ",--%>
<%--                "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",--%>
<%--                "Show": "Кўрсатилмоқда",--%>
<%--                "search": "Излаш",--%>
<%--                "paginate": {--%>
<%--                    "next": "Кейинги",--%>
<%--                    "previous": "Олдинги",--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%--</body>--%>
