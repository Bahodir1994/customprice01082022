<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.04.2022
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
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

<%
    String HS_NM_FULL = "";
%>

<div class="page-content">
    <input type="hidden" id="appId" name="appId" value="<c:out value="${appId}"/>"/>
    <!--breadcrumb-->
    <!--end breadcrumb-->
    <div class="row">
        <div class="col-12 col-lg-12">
            <div class="card shadow">
                <div class="card-body m-3" style="border-color: #0a58ca; border-style: dotted">
                    <div class="">
                        <table class="w-100">
                            <thead>
                            <tr>
                                <td>
                                    <div class="title">
                                        <c:if test="${appInfo[19] == '170' || appInfo[19] =='175'}">
                                            <h4 class="fw-bolder">ДАСТЛАБКИ ҚАРОР</h4>
                                        </c:if>
                                        <c:if test="${appInfo[19] != '170' && appInfo[19] !='175'}">
                                            <h4 class="fw-bolder">АРИЗА</h4>
                                        </c:if>
                                    </div>
                                    <style>
                                        @import url('https://fonts.googleapis.com/css?family=Cairo');

                                        h4 {
                                            background-image: url(https://media.giphy.com/media/26BROrSHlmyzzHf3i/giphy.gif);
                                            background-size: cover;
                                            color: transparent;
                                            -moz-background-clip: text;
                                            -webkit-background-clip: text;
                                            text-transform: uppercase;
                                            font-size: 30px;
                                            margin: 10px 0;
                                        }

                                        /* styling my button */

                                        .white-mode {
                                            text-decoration: none;
                                            padding: 7px 10px;
                                            background-color: #122;
                                            border-radius: 3px;
                                            color: #225e9e;
                                            transition: .50s ease-in-out;
                                            position: absolute;
                                            left: 15px;
                                            bottom: 15px;
                                            font-family: "Montserrat";
                                        }

                                        .white-mode:hover {
                                            background-color: #FFF;
                                            color: #122;
                                        }
                                    </style>
                                </td>
                                <td class="text-end">
                                    <h4 class="text-warning">
                                        <u>
                                            <c:set var="total" value="${0}"/>
                                            <c:forEach var="val" items="${appInfo}">
                                                <small>№: ${val[1]}/
                                                        <c:if test="${val[36] == null || val[36] =='' || val[36]=='null'}">
                                                            1
                                                        </c:if>
                                                        <c:if test="${val[36] != null && val[36] !='' && val[36]!='null'}">
                                                            ${val[36]}
                                                        </c:if>
                                                </small>
                                            </c:forEach>
                                        </u>
                                    </h4>
                                </td>
                            </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="row mt-3">
                        <div class="row invoice-info">
                            <div class="col-6 col-lg-6">
                                <div class="container">
                                    <div class="row row-cols-3">
                                        <c:set var="total" value="${0.0}"/>
                                        <c:forEach var="val" items="${transports}" varStatus="i">
                                            <c:set var="total" value="${total + val.transportPrice}"/>
                                        </c:forEach>
                                        <c:forEach var="val" items="${appInfo}" varStatus="i">
                                            <div class="col"></div>
                                            <div class="col h6">Аризачи:</div>
                                            <div class="col">${val[9]}</div>


                                            <div class="col"></div>
                                            <div class="col h6">Телефон рақами:</div>
                                            <div class="col">${val[11]}</div>


                                            <div class="col"></div>
                                            <div class="col h6">Юк жўнатувчи:</div>
                                            <div class="col">${val[17]} - "${val[18]}</div>


                                            <div class="col"></div>
                                            <div class="col h6">Сотувчи:</div>
                                            <div class="col">${val[3]} - "${val[15]}</div>

                                            <div class="col"></div>
                                            <div class="col h6">Импортёр номи:</div>
                                            <div class="col">${val[34]}</div>

                                            <div class="col"></div>
                                            <div class="col h6">Импортёр СТИРи:</div>
                                            <div class="col">${val[35]}</div>

                                            <div class="col"></div>
                                            <div class="col h6">Ваколатли шахс ЖШШИРи:</div>
                                            <div class="col">${val[37]} - ${val[38]}</div>

                                            <div class="col"></div>
                                            <div class="col h6">Ваколатини тасдиқловчи</br>хужжат:</div>
                                            <div class="col">${val[39]} - ${val[40]}</div>

                                            <div class="col"></div>

                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-lg-6">
                                <div class="container">
                                    <c:forEach var="val" items="${appInfo}" varStatus="i">
                                        <div class="row row-cols-3">
                                            <div class="col h6">Божхона қиймати:</div>
                                            <div class="col">
                                                    <%--                                                <a type="button" class="btn btn-outline-primary btn-sm radius-30" &lt;%&ndash;data-bs-toggle="modal" data-bs-target="#exampleModalfq"&ndash;%&gt; style="cursor: pointer;">--%>
                                                    ${val[30]} ${val[32]}
                                                    <%--                                                    <i class="bx bx-info-circle"></i>--%>
                                                    <%--                                                </a>--%>
                                            </div>
                                            <div class="col"></div>


                                            <div class="col h6">Фактура қиймати:</div>
                                            <div class="col">${val[29]} ${val[32]}</div>
                                            <div class="col"></div>

                                            <div class="col h6">Нетто оғирлиги:</div>
                                            <div class="col">${val[27]} кг</div>
                                            <div class="col"></div>

                                            <div class="col h6">Брутто оғирлиги:</div>
                                            <div class="col">${val[28]} кг</div>
                                            <div class="col"></div>

                                            <div class="col h6">Етказиб бериш шарти:</div>
                                            <div class="col">${val[22]} - ${val[23]}</div>
                                            <div class="col"></div>

                                            <div class="col h6">Хужжатлар:</div>
                                            <div class="col">
                                                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                    <i class="bx bx-folder-open"></i>
                                                </button>
                                            </div>
                                                <%--                                            <div class="col"></div>--%>


                                            <div class="col"></div>
                                            <br><br><br>
                                            <div class="col h6">Транспорт харажатлари:</div>
                                            <div class="col">
                                                <a type="button" class="btn btn-outline-primary btn-sm radius-30" type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                                                   data-bs-target="#exampleModal1" style="cursor: pointer;"> <c:out value="${total}"/>
                                                    <i class="bx bx-info-circle"></i>
                                                </a>
                                            </div>
                                            <div class="col"></div>


                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- Хужжатлар Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Аризага бириктирилган хужжатлар</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body m-3">
                                            <table id="example" class="table table-bordered border-primary table-sm" style="width:100%;">
                                                <thead class="bg-gradient text-black" style="background-color: #B5CAF9;">
                                                <tr class="">
                                                    <th style="border-style: dotted" class="column-title">№</th>
                                                    <th style="border-style: dotted" class="column-title">Хужжат тури</th>
                                                    <th style="border-style: dotted" class="column-title">Хужжат рақами</th>
                                                    <th style="border-style: dotted" class="column-title">Хужжат санаси</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="pepe" items="${earxivList}" varStatus="i">
                                                    <tr class="even pointer">
                                                        <td class=" ">${i.index+1}</td>
                                                        <td class=" ">${pepe.docType}-${pepe.docTypeName}</td>
                                                        <td class=" ">
                                                            <a href="<%=request.getContextPath()%>/download/${pepe.hash}/${pepe.fileId}/${pepe.id}" class="">
                                                                <i class="bx bxs-download bx-sm mt-2">${pepe.fileNum}</i>
                                                            </a>
                                                        </td>
                                                        <td class=" ">${pepe.fileDate}<i class="success fa fa-download"></i></td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Транспорт тури Modal start -->
                            <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                                <div class="modal-dialog modal-xl">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel1">Транспорт харакати
                                                йўналиши ва харажатлари</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>Бошлағич пункт</th>
                                                    <th>Тугаш пункти</th>
                                                    <th>Транспорт тури</th>
                                                    <th>Ҳаражатлар</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:set var="total" value="${0.0}"/>
                                                <c:forEach var="val" items="${transports}" varStatus="i">
                                                    <c:set var="total" value="${total + val.transportPrice}"/>
                                                    <tr>
                                                        <th>${val.finishCountry}</th>
                                                        <td>${val.endCountry}</td>
                                                        <td>
                                                            <i class="fa fa-subway fa-2x mr-3"></i>${val.tarnsportType}
                                                        </td>
                                                        <td>${val.transportPrice} сўм</td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td>Жами</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><c:out value="${total} сўм"/></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Транспорт тури Modal end -->
                            <!-- Фактура қиймати Modal -->
                            <div class="modal fade" id="exampleModalfq" tabindex="-1" aria-labelledby="exampleModalLabelfq" aria-hidden="true">
                                <div class="modal-dialog modal-xl" style="pointer-events: none; opacity: 0.8;">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 class="text-center text-warning" style="position	: absolute; top:300px; width: 100%;">Ушбу бўлим ишлаб чиқилмоқда</h3>
                                            <h5 class="modal-title" id="exampleModalLabelfq">Божхона қиймати индекси бўйича
                                                хавф даражаси</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-bordered table-sm">
                                                <thead class="text-center">
                                                <tr>
                                                    <th rowspan="2" style="vertical-align: middle">№</th>
                                                    <th rowspan="2" style="vertical-align: middle">Товар рақами</th>
                                                    <th rowspan="2" style="vertical-align: middle">Савдо қилувчи
                                                        мамлакат
                                                    </th>
                                                    <th rowspan="2" style="vertical-align: middle">Транспорт</th>
                                                    <th rowspan="2" style="vertical-align: middle">Жўнатувчи
                                                        мамлакат
                                                    </th>
                                                    <th rowspan="2" style="vertical-align: middle">ТИФ ТН коди</th>
                                                    <th rowspan="2" style="vertical-align: middle">Келиб чиқиш
                                                        мамлакати
                                                    </th>
                                                    <th rowspan="2" style="vertical-align: middle">Товар вазни</th>
                                                    <th rowspan="2" style="vertical-align: middle">Товар миқдори
                                                    </th>
                                                    <th rowspan="2" style="vertical-align: middle">Ўлчов бирлиги
                                                    </th>
                                                    <th rowspan="2" style="vertical-align: middle">Божхона
                                                        қиймати($)
                                                    </th>
                                                    <th rowspan="2" style="vertical-align: middle">Божхона
                                                        қиймати(кг $)
                                                    </th>
                                                    <th colspan="3" style="vertical-align: middle">Божхона қиймати
                                                        индекси($)
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th class="bg-success">Минимал</th>
                                                    <th class="bg-warning">Ўрта</th>
                                                    <th class="bg-danger">Максимал</th>
                                                </tr>

                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <th scope="row">1</th>
                                                    <td>1</td>
                                                    <td>410</td>
                                                    <td>410</td>
                                                    <td>30</td>
                                                    <td>8431492000</td>
                                                    <td>000</td>
                                                    <td>210.00</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td>653.10</td>
                                                    <td>3.11</td>
                                                    <td>3.11</td>
                                                    <td>3.49</td>
                                                    <td>4.97</td>

                                                </tr>
                                                <tr>
                                                    <th scope="row">1</th>
                                                    <td>4</td>
                                                    <td>792</td>
                                                    <td>792</td>
                                                    <td>40</td>
                                                    <td>8431472000</td>
                                                    <td>000</td>
                                                    <td>130.00</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td>640.10</td>
                                                    <td>2.55</td>
                                                    <td>2.55</td>
                                                    <td>3.22</td>
                                                    <td>4.22</td>

                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- endmodal-->
                        </div>
                    </div>
                    <!--end row-->
                    <div class="row">
                        <div class="col-md-6">
                            Тўлов: <i class='bx bxs-message-square bx-sm text-primary'></i>-хисобланмаган;
                            <i class='bx bxs-message-square bx-sm text-success'></i>-хисобланган;
                        </div>
                        <div class="col-md-6 text-end">
                            <c:if test="${userRole == 8 && (appStatus == 110 || appStatus == 111 || appStatus == 115 || appStatus == 135)}">
                                <button type="button" class="btn btn-outline-danger btn-block" data-bs-toggle="modal"
                                        data-bs-target="#exampleExtraLargeModal4">Аризани қайтариш <i class="bx bx-undo"></i>
                                </button>
                            </c:if>
                            <c:if test="${userRole == 8 && appStatus != 110 && appStatus != 111 && appStatus != 115 && appStatus != 135}">
                                <button type="button" class="btn btn-outline-info btn-block" onclick="appsHistoryModal('${appId}')" data-bs-toggle="modal"
                                        data-bs-target="#exampleExtraLargeModal5">Ариза тарихи <i class="bx bx-history"></i>
                                </button>
                            </c:if>
                            <c:if test="${userRole != 8}">
                                <button type="button" class="btn btn-outline-info btn-block" onclick="appsHistoryModal('${appId}')" data-bs-toggle="modal"
                                        data-bs-target="#exampleExtraLargeModal5">Ариза тарихи <i class="bx bx-history"></i>
                                </button>
                            </c:if>

                        </div>
                    </div>
                    <div class="table-responsive mt-3">
                        <table class="table table-bordered table-striped">
                            <thead class="bg-light-primary" style="border-color: #0a58ca; border-style: dotted">
                            <tr>
                                <th style="position: -webkit-sticky; position: sticky; top: 0;z-index: 2;">ТИФ ТН коди:</th>
                                <th>Товар номи:</th>
                                <th>Ишлаб чиқарувчи давлат:</th>
                                <th>Ишлаб чиқарувчи номи:</th>
                                <th>Божхона қиймати:</th>
                                <th>Фактура қиймати:</th>
                                <th>Брутто:</th>
                                <th>Нетто:</th>
                                <th>Тижорат номи:</th>
                                <th>Савдо белгиси:</th>
                                <th>Маркаси:</th>
                                <th>Модели:</th>
                                <th>Артикули:</th>
                                <th>Нави:</th>
                                <th>Стандарти:</th>
                                <th>Фойдаланиш мақсади:</th>
                                <th>Тижорат хусусияти:</th>
                                <th>Техник хусусияти:</th>
                                <th>Ўрам тури:</th>
                                <th>Ўрамлар сони:</th>
                                <th>Юк жойлари сони:</th>
                                <th>Илгари берилган дастлабки қарор:</th>
                                <th>Илгари б.ТИФ ТН бўй.дастл.қарор:</th>
                                <th>Усул:</th>
                                <th>Тўл.хис/Қайтариш</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="var" items="${allCommodityFor}" varStatus="i">
                                <tr>
                                    <td>
                                        <c:if test="${var.paymentYN=='YES'}">
                                            <a type="button" class="btn btn-success btn-sm radius-30" style="cursor: pointer;" onclick="Calculating('${var.id}')">${var.hsCode}</a>
                                        </c:if>
                                        <c:if test="${var.paymentYN=='NO'}">
                                            <a type="button" class="btn btn-primary btn-sm radius-30" style="cursor: pointer;" onclick="Calculating('${var.id}')">${var.hsCode}</a>
                                        </c:if>
                                    </td>
                                    <td><textarea style="resize: horizontal" readonly>${var.hsName}</textarea></td>
                                    <td>${var.orignCountrNm}</td>
                                    <td>${var.originOrg}</td>
                                    <td>${var.customsPrice}</td>
                                    <td>${var.price}</td>
                                    <td>${var.brutto}</td>
                                    <td>${var.netto}</td>
                                    <td>${var.tradeName}</td>
                                    <td>${var.tradeMark}</td>
                                    <td>${var.mark}</td>
                                    <td>${var.model}</td>
                                    <td>${var.article}</td>
                                    <td>${var.sort}</td>
                                    <td>${var.standarts}</td>
                                    <td>${var.functions}</td>
                                    <td>${var.comProp}</td>
                                    <td>${var.techChar}</td>
                                    <td>${var.packTypeNm}</td>
                                    <td>${var.packQty}</td>
                                    <td>${var.cargoSpace}</td>
                                    <td>${var.inDecNum} / ${var.inDecDate}</td>
                                    <td>${var.hsDecNum} / ${var.hsDecDate}</td>
                                    <td>
                                            ${var.methodNm}
                                        <i class="bx bx-info-circle bx-sm" data-bs-toggle="modal"
                                           data-bs-target="#exampleExtraLargeModal3" style="cursor: pointer;"
                                           onclick="check_methodDesc('${i.index+1}', '${var.methodNm}', '${var.methodDescription}')"></i>
                                        <textarea id="methodDesc" style="display: none;">${var.methodDescription}</textarea>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-block"
                                                onclick="Calculating('${var.id}')">
                                            <i class="bx bx-calculator"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!-- Усул тури Modal -->

                        <div class="modal fade" id="exampleExtraLargeModal3" tabindex="-1" style="display: none;"
                             aria-hidden="true">
                            <div class="modal-dialog modal-xl">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Танланган усулдан олдинги
                                            усулни қўлламаслик сабаблари</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="col-md-12">
                                            <div class="table-responsive">
                                                <table class="table tableMethodDesc">
                                                    <thead>
                                                    <tr>
                                                        <th>Божхона қийматини аниқлаш усули</th>
                                                        <th>Аввалги усулларни қўлламаслик сабаблари</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%--                                                    <tr>--%>
                                                    <%--                                                        <td>Олиб кириладиган товарга доир битимнинг қиймати бўйича</td>--%>
                                                    <%--                                                        <td>Жўнатувчи мамлакатнинг экспорт божхона юк декларацияси--%>
                                                    <%--                                                            мавжуд эмас--%>
                                                    <%--                                                        </td>--%>
                                                    <%--                                                    </tr>--%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- Усул тури Modal end -->
                        <!-- Аризани қайтариш Modal -->
                        <div class="modal fade" id="exampleExtraLargeModal4" tabindex="-1" aria-hidden="true"
                             style="display: none;">
                            <c:forEach var="its" items="${appInfo}">
                            <input class="appIdForm" type="hidden" value="${its[0]}">
                            </c:forEach>
                            <div class="modal-dialog modal-xl">
                                <div class="modal-content">
                                    <div class="modal-header bg-primary">
                                        <h5 class="modal-title text-white">
                                            Аризани қайтариш тури ва сабаблари
                                        </h5>
                                    </div>
                                    <div class="modal-body">
                                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                                            <li class="nav-item border border-success w-50" role="presentation">
                                                <button onclick="clickl(1)" class="nav-link thisbtn1 active btn btn-outline-success bg-success text-dark w-100" id="home-tab"
                                                        data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Аризани кўриб чиқишни рад этиш
                                                </button>
                                            </li>
                                            <li class="nav-item border border-success w-50" role="presentation">
                                                <button onclick="clickl(2)" class="nav-link thisbtn2 btn btn-outline-success text-dark w-100" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">
                                                    Рад этишга тайёрлаш
                                                </button>
                                            </li>
                                        </ul>
                                        <div class="tab-content" id="myTabContent">
                                            <div class="tab-pane fade show active mt-4" id="home" role="tabpanel" aria-labelledby="home-tab">
                                                <form method="post" class="" id="fm1" name="fm1">
                                                    <table class="table table-responsive">
                                                        <thead>
                                                        <tr>
                                                            <th scope="col">#</th>
                                                            <th scope="col">Сабаб</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach var="vals1" items="${rollbackInfoForFirst}" varStatus="i">
                                                        <tr>
                                                            <td><input class="form-check-input" type="checkbox" value="${vals1.id}" id="${vals1.id}"></td>
                                                            <td scope="row">${vals1.rollbackName}</td>
                                                        </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                    <div class="ExceptionSpravochnik"></div>

                                                    <table class="table table-responsive mt-3">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="2" scope="col">Изох киритинг</th>

                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td scope="row">
                                                                <textarea class="form-control" id="textareaFor1" rows="3"></textarea>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                    <div class="ExceptionComment"></div>
                                                </form>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary btnCloseModalRollback" data-bs-dismiss="modal">Ёпиш</button>
                                                    <button type="button" title="Манфаатдор шахсга аризага тузатиш</br> ва қўшимчалар киритиш учун юбориш" class="btn btn-primary" onclick="javascript:appRollback(1);">Жўнатиш</button>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade mt-4" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                                <form method="post" class="" id="fm2" name="fm2">
                                                    <table class="table table-responsive">
                                                        <thead>
                                                        <tr>
                                                            <th scope="col">#</th>
                                                            <th scope="col">Сабаб</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach var="vals2" items="${rollbackInfoForSecond}" varStatus="i">
                                                            <tr>
                                                                <td><input class="form-check-input" type="checkbox" value="${vals2.id}" id="${vals2.id}"></td>
                                                                <td scope="row">${vals2.rollbackName}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                    <div class="ExceptionSpravochnik2"></div>
                                                    <table class="table table-responsive mt-3">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="2" scope="col">Изох киритинг</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td scope="row">
                                                                <textarea class="form-control" id="textareaFor2" rows="3"></textarea>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                    <div class="ExceptionComment2"></div>
                                                </form>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ёпиш</button>
                                                    <button type="button" class="btn btn-primary"  onclick="javascript:appRollback(2);">Рад этишга киритиш</button>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <style>
                            .modal-xl {
                                max-width: 80%!important;
                            }
                            .modal-body {
                                position: relative!important;
                                flex: 1 1 auto!important;
                                padding: 0 2rem!important;
                            }
                        </style>
                        <div class="modal fade" id="exampleExtraLargeModal5" tabindex="-1" aria-hidden="true"
                             style="display: none;">
                            <div class="modal-dialog modal-dialog-scrollable modal-xl" >
                                <div class="modal-content">
                                    <div class="modal-header bg-primary">
                                        <h5 class="modal-title text-white">
                                            Ариза мақоми бўйича тарихи
                                        </h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрывать"></button>
                                    </div>
                                    <div class="modal-body">
                                        <table id="records_table" class="table table-responsive table-sm table-bordered">
                                            <thead style="position:sticky; top: 0" class="bg-info">
                                                <tr>
                                                    <th style="position:sticky; top: 0" class="text-center">T/p</th>
                                                    <th style="position:sticky; top: 0" class="text-center">Мақоми</th>
                                                    <th style="position:sticky; top: 0" class="text-center">Вақти</th>
                                                    <th style="position:sticky; top: 0" class="text-center">Ходим</th>
                                                    <th style="position:sticky; top: 0" class="text-center">Тақсимланган ходим</th>
                                                    <th style="position:sticky; top: 0" class="text-center">Изоҳ</th>
                                                </tr>
                                            </thead>
                                            <tbody class="tbodyForAppHistory">

                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary btnCloseModalStatusHistory" data-bs-dismiss="modal">Ёпиш</button>
                                   </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" class="cmdtFirsId" value="${cmdtIdFirst}">
        <div id="divcalculate">
        </div>
    </div>
</div>

<script>
    $(document).ready(function (){
        var cmdtId = $('.cmdtFirsId').val();
        Calculating(cmdtId);
    });
    function appsHistoryModal(appId) {
        var dataS = {
            "appIdForHistory": appId,
        }
        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/AppsHistoryModal",
            dataType: "json",
            async: true,
            contentType: 'application/json',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');
                mutedBody(1);
            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
                mutedBody(0);
            },
            success: function (response) {
                var indexing = '', trHTML= '', x = 1;
                $('.tbodyForAppHistory').html('')
                statisticsBar(response.barFirst, response.barSecond, response.barThird, response.barFourth, response.barFifth, response.barSixth,)
                if (typeof response.statusH != 'undefined') {
                    response.statusH.forEach(function (appeal, key) {
                        indexing = response.statusH.length-(response.statusH.length-x)
                        var pdfIcon = '';
                        let comments = appeal[7], sortingIns = appeal[4], reacts = appeal[6];
                        if (appeal[7] === undefined || appeal[7] === null || appeal[7] === 'null'){
                            comments = ""
                        }
                        if (appeal[6] === undefined || appeal[6] === null || appeal[6] === 'null'){
                            reacts = "автоматик"
                        }
                        if (appeal[4] === undefined || appeal[4] === null || appeal[4] === 'null'){
                            sortingIns = ""
                        }
                        if (appeal[8] === "125" || appeal[8] === 125){
                            pdfIcon = '<a href="<%=request.getContextPath()%>/decisionPdfDownloadRollback?stId='+ appeal[0]+'&status='+appeal[8]+'" class="spinnerOrIcon"></a>';
                        }
                        if (appeal[8] === "120" || appeal[8] === 120){
                            pdfIcon = '<a href="<%=request.getContextPath()%>/decisionPdfDownloadRollback?stId='+ appeal[0]+'&status='+appeal[8]+'" class="spinnerOrIcon"></a>';
                        }
                        if (appeal[8] === "110" || appeal[8] === 110){
                            pdfIcon = '<a href="<%=request.getContextPath()%>/decisionPdfDownloadRollback?stId='+ appeal[0]+'&status='+appeal[8]+'" class="spinnerOrIcon"></a>';
                        }
                        trHTML =
                            '<tr class="">' +
                            '<td class="column0 font-weight-bold text-center" data-column="">' + indexing + '<i class="bx bxs-downvote text-success"></i></td>' +
                            '<td class="column1" style="vertical-align: center">' +
                            '<a type="button" class="btn btn-outline-info btn-sm radius-30 px-4"  href="#" onclick="doubleRollbackProject(' + "'" + appeal[0] + "'" + ', ' + "'" + indexing + "'" + ')" class="text-primary font-weight-bold"><u>' + appeal[1] + '</u></a>' +
                            '<a>'+pdfIcon+'</a>'+
                            '</td>' +
                            '<td class="column0 font-weight-bold text-center" data-column="">' + appeal[2].substr(0, 10)+"  ("+appeal[2].substr(11, 8) +")"+'</td>' +
                            '<td class="column0 font-weight-bold text-center" data-column="">' + reacts +'</td>' +
                            '<td class="column0 font-weight-bold text-center" data-column="">' + sortingIns +'</td>' +
                            '<td class="column0 font-weight-bold text-center" data-column="">' + comments +'</td>' +
                            '</tr>'+
                            '<tr><td colspan="7">' +
                            '<div class="clearDiv w-100 container '+indexing+'"></div>' +
                            '</td</tr>';

                        $('#records_table').append(trHTML);
                        x++;
                    });
                }
                if (typeof response.statusH == 'undefined' || response.statusH === '' || response.statusH === 'empty'){
                    trHTML = '<tr class="">' +
                        '<td colspan="11" class="column0 font-weight-bold text-center" data-column="">Маълумотлар топилмади</td>' +
                        '</tr>';
                    $('#records_table').append(trHTML);
                }
                $('.spinnerOrIcon').html('<button class="btn btn-outline-warning"><i class="bx bxs-file-pdf bx-sm" onclick="spinOIco(0)"></i></button>');
            },
            error: function (response) {
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Ноъмалум хатолик!\n Тизм Администраторига хабар беринг',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }
    function spinOIco(x){
       if (x===1){
            $('.spinnerOrIcon').html('');
            $('.spinnerOrIcon').append('<button class="btn btn-outline-warning" type="button" disabled><span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>Юкланмоқда...</button>');
            setTimeout(function() {
                $('.spinnerOrIcon').html('');
                $('.spinnerOrIcon').append('<button class="btn btn-outline-warning"><i class="bx bxs-file-pdf bx-sm" onclick="spinOIco(0)"></i></button>');
            }, 3000);
       }else {
           $('.spinnerOrIcon').html('');
           $('.spinnerOrIcon').append('<button class="btn btn-outline-warning" type="button" disabled><span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>Юкланмоқда...</button>');
           setTimeout(function() {
               $('.spinnerOrIcon').html('');
               $('.spinnerOrIcon').append('<button class="btn btn-outline-warning"><i class="bx bxs-file-pdf bx-sm" onclick="spinOIco(0)"></i></button>');
           }, 3000);
       }
    }
    function generatePdfRollback(stId, status){
        var dataS = {
            "stId": stId,
            "status" : status
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/download/resources/pages/InitialDecision/InitialDecisionSteps/Steps3",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }
    function doubleRollbackProject(stId, index) {
        var dataS = {
            "stId": stId,
            "index": index,
        }
        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/doubleRollBackProject",
            dataType: "json",
            async: true,
            contentType: 'application/json',
            beforeSend: function () {
                $('#preloader').removeClass('visually-hidden');

            },
            complete: function () {
                $('#preloader').addClass('visually-hidden');
            },
            success: function (response) {
                $('.clearDiv ').html('');
                $('.'+response.indexing+'').html('');
                var trHTML = '', putInput = '', x = 1, if160 = '', if170 = '<div class="col-md-2 text-start mt-2"><button class="btn btn-outline-danger" onclick="rollbackToInspectorOrXbbb(1, '+"'"+response.stId+"'"+')"><i class="bx bxs-arrow-from-right bg-outline-danger"></i>Қайтариш</button></div>';
                if (typeof response.rollBackApp != 'undefined') {
                    if (response.statusWork === "116" || response.statusWork === "117" || response.statusWork === "160" || response.statusWork === "170" || response.statusWork === "145"){
                        if (response.statusWork === "160"){
                            if160 = ''
                        }else {
                            if160 = '<div class="col-md-2 text-end mt-2"><button class="btn btn-outline-success max-width-100" onclick="rollbackToInspectorOrXbbb(2, '+"'"+response.stId+"'"+')">Имзога  <i class="bx bxs-arrow-from-left bg-outline-success"></i></button></div>';
                        }
                        if (response.statusWork === "170"){
                            if170 = '<div class="col-md-2 text-start mt-2"><button class="btn btn-outline-danger" onclick="rollbackToInspectorOrXbbb(3, '+"'"+response.stId+"'"+')"><i class="bx bxs-arrow-from-right bg-outline-danger"></i>Ўзгартиришга</button></div>';
                            if160 = ''
                        }
                        if(response.statusWork === "145"){
                            if160 = '';
                        }
                        putInput =
                            '<div class="row border border-dark border-bottom-0 border-start-0 border-end-0">' +
                            ''+if170+'' +
                            '<div class="col-md-8 text-center mt-2"><textarea style="width: 100%" class="form-control text-center doubleRollbackCommentTextarea" placeholder="Изох киритинг....."></textarea><div class="currentTextareaMessage"></div></div>' +
                            ''+if160+'' +
                            '</div>';
                    }
                    response.rollBackApp.forEach(function (appeal, key) {
                        trHTML =
                            '<tr class="m-5">' +
                            '<td class="h6 m-5"><i class="bx bx-check text-success"></i>'+appeal.rollbackName+'</td>' +
                            '</tr>';
                        $('.'+response.indexing+'').append(trHTML);
                        x++;
                    });
                    $('.'+response.indexing+'').append(putInput);
                }else if(response.statusWork === "none") {
                    response.rollBackApp.forEach(function (appeal, key) {
                        trHTML =
                            '<tr class="m-5">' +
                            '<td class="h6 m-5"><i class="bx bx-check text-success"></i>'+appeal.rollbackName+'</td>' +
                            '</tr>';
                        $('.'+response.indexing+'').append(trHTML);
                        x++;
                    });
                };

            },
            error: function (response) {
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Ноъмалум хатолик!\n Тизм Администраторига хабар беринг',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }
    function rollbackToInspectorOrXbbb(x, stId){
        var currentTextarea = false;
        $('.doubleRollbackCommentTextarea').removeClass('border border-danger');
        $('.currentTextareaMessage').html('');
        var toGo ='';
        if ($('.doubleRollbackCommentTextarea').val() === "" || $('.doubleRollbackCommentTextarea').val() === "null" || $('.doubleRollbackCommentTextarea').val() === "undefined"){
            $('.doubleRollbackCommentTextarea').addClass('border border-danger')
            $('.currentTextareaMessage').html('<p class="text-danger">Изох майдони бўш бўлиши мумкин эмас!</p>')

        }else {
            $('.doubleRollbackCommentTextarea').addClass('border border-success');
            $('.currentTextareaMessage').html('<p class="text-success">Текширилди!</p>');
            currentTextarea = true
        }
        if (x===1){
           toGo = "toInspector";
        }
        if (x===2){
            toGo = "toXbbb";
        }
        if (x===3){
            toGo = "toDublicate";
        }
        var dataS = {
            "stId": stId,
            "statusGetSaveRollbackType": toGo,
            "doubleRollbackCommentTextarea": $('.doubleRollbackCommentTextarea').val()
        }
        if (currentTextarea === true){
            $.ajax({
                type: "POST",
                data: JSON.stringify(dataS),
                url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/saveDoubleRollBackProject",
                dataType: "json",
                async: true,
                contentType: 'application/json',
                beforeSend: function () {
                    $('#preloader').removeClass('visually-hidden');

                },
                complete: function () {
                    $('#preloader').addClass('visually-hidden');
                    // mutedBody(0);
                },
                success: function (response) {
                    $('.btnCloseModalStatusHistory').click();
                    ListInDec('koribChiqilmoqda');
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: 'Бажарилди!',
                        showConfirmButton: false,
                        timer: 1500
                    });
                },
                error: function (response) {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Ноъмалум хатолик!\n Тизм Администраторига хабар беринг',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            });
        }
    }

    function Calculating(cmdtId) {
        // var inspectorName = $('#userIdF_' + rowNum + ' option:selected').text();
        var dataS = {
            "cmdt_id": cmdtId,
            "appId": $('#appId').val()
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/commodity/resources/pages/InitialDecision/InitialDecisionSteps/Steps4",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#divcalculate').html(res);
            },
            error: function (res) {
            }
        });
    }
    function appRollback(x) {
        var currectCheck = false, currectComment = false;
        let forId1 = "", forId2 = "", forId3 = "", forId4 = "", forId5 = "", forId6 = "";
        if ( $('#1').is(":checked") === true){
            forId1 = "1"
        }
        if ( $('#2').is(":checked") === true){
            forId2 = "2"
        }
        if ( $('#3').is(":checked") === true){
            forId3 = "3"
        }
        if ( $('#4').is(":checked") === true){
            forId4 = "4"
        }
        if ( $('#5').is(":checked") === true){
            forId5 = "5"
        }
        if ( $('#6').is(":checked") === true){
            forId6 = "6"
        }
        if (x===1) {
            $('.ExceptionSpravochnik').html('');
            $('.ExceptionComment').html('');
            if ($('#1').is(":checked") === false && $('#2').is(":checked") === false && $('#3').is(":checked") === false && $('#4').is(":checked") === false){
                currectCheck = false;
                $('.ExceptionSpravochnik').append('<p class="text-danger">Камида битта сабаб танланиши лозим!</p>');
            } else {
                $('.ExceptionSpravochnik').append('<p class="text-success">Текширилди!</p>');
                currectCheck = true
            }
            if ($('#textareaFor1').val() === "" || $('#textareaFor1').val() === null || $('#textareaFor1').val() === "null"){
                currectComment = false;
                $('.ExceptionComment').append('<p class="text-danger">Изох майдони бўш бўлиши мумкун эмас!</p>');
            }else {
                $('.ExceptionComment').append('<p class="text-success">Текширилди!</p>');
                currectComment = true}
            var dataS = {
                "id1": forId1,
                "id2": forId2,
                "id3": forId3,
                "id4": forId4,
                "textareaFor1": $('#textareaFor1').val(),
                "appId": $('.appIdForm').val(),
                "entirely" : "false",
                "correction" : "true"
            }
        } else if (x===2){
            $('.ExceptionSpravochnik2').html('');
            $('.ExceptionComment2').html('');
            if ($('#5').is(":checked") === false && $('#6').is(":checked") === false){
                currectCheck = false;
                $('.ExceptionSpravochnik2').append('<p class="text-danger">Камида битта сабаб танланиши лозим!</p>');
            }else {
                $('.ExceptionSpravochnik2').append('<p class="text-success">Текширилди!</p>');
                currectCheck = true;
            }
            if ($('#textareaFor2').val() === "" || $('#textareaFor2').val() === null || $('#textareaFor2').val() === "null"){
                currectCheck = false;
                $('.ExceptionComment2').append('<p class="text-danger">Изох майдони бўш бўлиши мумкун эмас!</p>');
            }else {
                $('.ExceptionComment2').append('<p class="text-success">Текширилди!</p>');
                currectComment = true
            }
            var dataS = {
                "id5": forId5,
                "id6": forId6,
                "textareaFor2": $('#textareaFor2').val(),
                "appId": $('.appIdForm').val(),
                "entirely" : "true",
                "correction" : "false"
            }
        }
        if (currectComment === true && currectCheck === true){
            $.ajax({
                type: "POST",
                data: JSON.stringify(dataS),
                url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRollBack",
                dataType: "json",
                async: true,
                contentType: 'application/json',
                beforeSend: function () {
                    $('#preloader').removeClass('visually-hidden');
                    mutedBody(1);
                },
                complete: function () {
                    $('#preloader').addClass('visually-hidden');
                    mutedBody(0);
                },
                success: function (response) {
                    if (x === 1) {
                        $('.btnCloseModalRollback').click();
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Аризани кўриб чиқиш рад этилди!',
                            showConfirmButton: false,
                            timer: 1500
                        })
                        ListInDec("radEtilganlar")

                    } else if (x === 2) {
                        $('.btnCloseModalRollback').click();
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Рад этишга тайёрланди!',
                            showConfirmButton: false,
                            timer: 1500
                        })
                        ListInDec("koribChiqilmoqda")
                    }
                },
                error: function (response) {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Ноъмалум хатолик!\n Тизм Администраторига хабар беринг',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            });
        }else if (currectCheck === false || currectComment === false){
            Swal.fire({
                position: 'top-end',
                icon: 'error',
                title: 'Маълумотлар тўлдирилмаган!',
                showConfirmButton: false,
                timer: 1500
            })
        }
    }
    function appRollbackToFix(statusApp) {
        var log_f = true;
        var log_n = '';
        var arr = [];
        var vN = '';

        if ($.trim($('#HS_NM_FULLS2').val()) == null || $.trim($('#HS_NM_FULLS2').val()) == '') {
            $('#HS_NM_FULLS2').css({'border': '1px solid #FF0000'});
            arr[0] = ' Аризани қайтариш сабабини рўйхатдан танланг ! ';
            log_f = false;
        } else {
            $('#HS_NM_FULLS2').css({'border': '1px solid #a6c9e2'});
            arr[0] = '';
        }

        if ($.trim($('#commentRollback2').val()) == null || $.trim($('#commentRollback2').val()) == '') {
            $('#commentRollback2').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш бўйича қўшимча маълумот киритилмаган, илтимос майдонни тўлдиринг ! ';
            log_f = false;
        } else if ($.trim($('#commentRollback2').val()).length > 200) {
            $('#commentRollback2').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш сабаби майдонининг узунлиги 250 та белгидан ошмаслиги лозим ! ';
            log_f = false;
        } else {
            $('#commentRollback2').css({'border': '1px solid #a6c9e2'});
            arr[1] = '';
        }


        for (var i = 0; i <= 1; i++) {
            if (arr[i] != '' && !log_f) {
                log_n = log_n + arr[i] + '\n\n';
            }
        }

        if (log_n != '') {
            alert(log_n + '');
        }

        if (log_f) {

            var dataS = {
                "appId": $('#appId').val(),
                "commentRollback": $.trim($('#commentRollback2').val()),
                "rollback_ids": $.trim($('#HS_CD_FULL2').val()),
                "rollback_names": $.trim($('#HS_NM_FULL2').val()),
                "statusApp": statusApp
            }

            /*-------------------------------*/

            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
            })

            swalWithBootstrapButtons.fire({
                title: 'Аризани қайтаришни хоҳлайсизми?',
                text: "Сиз ушбу ариза бўйича қарор қабул қилмоқдасиз!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Ха, ариза қайтарилади!',
                cancelButtonText: 'Йўқ, қайта кўриб чиқаман!',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    swalWithBootstrapButtons.fire(
                        'Ариза қайтарилди!',
                        'Ушбу ариза божхона қонуни талабларига мос эмас деб топилди',
                        'success'
                    )
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRollBack",
                        dataType: "html",
                        header: 'Content-type: text/html; charset=utf-8',
                        success: function (res) {
                            $('div#MainContent').html(res);
                        },
                        error: function (res) {
                        }
                    });
                } else if (
                    /* Read more about handling dismissals below */
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire(
                        'Амал рад этилди!',
                        'Сақлаш амалга оширилмади',
                        'error'
                    )
                }
            })

        } else return false;

        /*------------------------------*/
    }
    /*------------------------------*/
    function check_methodDesc(rowNum, methodNm, methodDesc) {
        var newRow = $("table.tableMethodDesc tbody");
        var cols = '<tr class="trMethodDesc">';

        // var row = document.getElementsByClassName(".trMethodDesc");
        // row.parentNode.removeChild(row);

        let list_methodDesc = [];
        list_methodDesc = methodDesc.split("~~~~~");

        for (let i = 0; i < list_methodDesc.length - 1; i++) {
            cols += '<td>' + methodNm + '</td>';
            cols += '<td>' + list_methodDesc[i] + '</td>';
            cols += '</tr>';
        }
        newRow.append(cols);
    }
    $(document).ready(function () {
        $('#tableDecView').DataTable({
            scrollX: true
        });
    });
    function clickl(x){
        if (x === 1) {
        $('.thisbtn1').removeClass('bg-success text-white')
        $('.thisbtn2').removeClass('bg-success text-white')
        $('.thisbtn1').addClass('bg-success text-white')
    }
        if (x === 2) {
        $('.thisbtn1').removeClass('bg-success text-white')
        $('.thisbtn2').removeClass('bg-success text-white')
        $('.thisbtn2').addClass('bg-success text-white')
    }
    }
</script>
<script src="<%=request.getContextPath()%>/resources/js/swalSweetalert.js"></script>
