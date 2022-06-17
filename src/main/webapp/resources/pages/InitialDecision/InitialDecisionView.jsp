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
                                                <small>№: ${val[1]}</small>
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
                                            <div class="col">(+998) ${val[11]}</div>


                                            <div class="col"></div>
                                            <div class="col h6">Юк жўнатувчи:</div>
                                            <div class="col">${val[17]} - "${val[18]}</div>


                                            <div class="col"></div>
                                            <div class="col h6">Сотувчи:</div>
                                            <div class="col">${val[3]} - "${val[15]}</div>


                                            <div class="col"></div>
                                            <div class="col h6">Транспорт харажатлари:</div>
                                            <div class="col">
                                                <a type="button" class="btn btn-outline-primary btn-sm radius-30" type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                                                   data-bs-target="#exampleModal1" style="cursor: pointer;"> <c:out value="${total}"/>
                                                    <i class="bx bx-info-circle"></i>
                                                </a>
                                            </div>
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
                                            <a type="button" <%--class="btn btn-outline-primary btn-sm radius-30" data-bs-toggle="modal" data-bs-target="#exampleModalfq"--%> style="cursor: pointer;">
                                                    ${val[30]} ${val[32]}
                                                            <%--<i class="bx bx-info-circle"></i>--%>
                                                        </a>
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
                                                    <div class="modal-body">
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
                                Тўлов: <i class='bx bxs-message-square bx-sm text-primary'></i>-хисобланмаган;
                                <i class='bx bxs-message-square bx-sm text-success'></i>-хисобланган;
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

                                                    <%if (userRole == 8){%>
                                                    <c:if test="${appStatus != 120 && appStatus != 125 && appStatus != 170 && appStatus != 175}">
                                                        <button type="button" class="btn btn-danger btn-block" data-bs-toggle="modal"
                                                                data-bs-target="#exampleExtraLargeModal4">
                                                            <i class="bx bx-undo"></i>
                                                        </button>
                                                    </c:if>
                                                    <%}%>

                                                        <%--                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleExtraLargeModal"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Очень большой</font></font></button>--%>
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
                            <div class="modal-dialog modal-xl">
                                <div class="modal-content">
                                    <div class="modal-header bg-primary">
                                        <h5 class="modal-title text-white">
                                            Аризани қайтариш тури ва сабаблари
                                        </h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрывать"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form method="post" class="" id="fm1" name="fm1">

                                            <div class="form-group mr-4" style="float: left; clear: none;">
                                                <div class="form-group pmd-textfield pmd-textfield-floating-label mr-4" style="">
                                                    <select style="width: 100%;" class="form-select shadow-sm" type="text" name="HS_NM" id="HS_NM">
                                                        <option></option>
                                                        <c:forEach var="vals" items="${rollbackInfo}" varStatus="i">
                                                            <option value="${vals.id}">${vals.id} - ${vals.rollbackName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group ml-4 mb-4" style="float: left; clear: none;">
                                                <button class="btn btn-primary ml-4" style="padding: 5px 5px;" type="button"
                                                        onclick="addT_HS_NM(/*$('#HS_NM').val() + ' - ' + */$('#HS_NM option:selected').text())">
                                                    <i class="bx bx-save" style="color:#ffffff;font-size:13px;"></i>
                                                    <span class="lang">Сабабни Қўшиш</span>
                                                </button>
                                                <button class="btn btn-primary" style="padding: 5px 5px;" type="button"
                                                        onclick="ClearT_HS_NM()">
                                                    <i class="bx bx-trash-alt"
                                                       style="color:#ffffff;font-size:13px;"></i>
                                                    <span class="lang">Тозалаш</span>
                                                </button>
                                                <button class="btn btn-danger" type="button" id="gtkXTButton" style="">
                                                    <i class="bx bx-trash"></i>
                                                </button>
                                            </div>
                                            <div class="form-group W100" style="margin-top:2px; display: none;">
                                                <label class="sr-only" for="HS_NM_FULL">Страна-транзит</label>
                                                <textarea class="form-control input-sm" rows="4" id="HS_NM_FULL" name="HS_NM_FULL" maxlength="150" style="width:85%"><%=HS_NM_FULL%></textarea>
                                                <textarea class="form-control input-sm" rows="2" id="HS_CD_FULL" name="HS_CD_FULL" maxlength="150" style="width:85%"></textarea>
                                            </div>
                                            <div class="border-primary" style="">
                                                <textarea class="form-control input-sm mt-1" rows="4" id="HS_NM_FULLS" name="HS_NM_FULLS" maxlength="150" style="width:100%" readonly></textarea>
                                            </div>
                                            <div class="border-primary" style="">
                                                    <textarea class="resizable_textarea form-control mt-1" placeholder="Қўшимча маълумот киритиш учун... " rows="4"
                                                              style="max-height: 300px;width:100%" id="commentRollback" name="commentRollback"></textarea>
                                            </div>
                                        </form>
                                        <div class="form-check form-check-inline form-control-lg">
                                            <input style="cursor: pointer;" checked class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="120">
                                            <label style="cursor: pointer;" class="form-check-label" for="inlineRadio1">Тўлиқ қайтариш</label>
                                        </div>
                                        <div class="form-check form-check-inline form-control-lg">
                                            <input style="cursor: pointer;" class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="125">
                                            <label style="cursor: pointer;" class="form-check-label" for="inlineRadio2">Тузатиш учун қайтариш</label>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><font
                                                style="vertical-align: inherit;"><font style="vertical-align: inherit;">Ёпиш</font></font>
                                        </button>
                                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onclick="javascript:appRollback();"><font
                                                style="vertical-align: inherit;"><font style="vertical-align: inherit;">Сақлаш</font></font></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="divcalculate">
        </div>
    </div>
</div>

<script>
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
    function appRollback() {
        // alert($('#appId').val() + ', \n ' + $.trim($('#commentRollback').val()));

        var log_f = true;
        var log_n = '';
        var arr = [];
        var vN = '';

        var statusApp = '';
        if ($('#inlineRadio1').is(':checked')) statusApp = $('#inlineRadio1').val();
        if ($('#inlineRadio2').is(':checked')) statusApp = $('#inlineRadio2').val();
        // alert(' statusApp --> ' + statusApp);

        if ($.trim($('#HS_NM_FULLS').val()) == null || $.trim($('#HS_NM_FULLS').val()) == '') {
            $('#HS_NM_FULLS').css({'border': '1px solid #FF0000'});
            arr[0] = ' Аризани қайтариш сабабини рўйхатдан танланг ! ';
            log_f = false;
        } else {
            $('#HS_NM_FULLS').css({'border': '1px solid #a6c9e2'});
            arr[0] = '';
        }

        if ($.trim($('#commentRollback').val()) == null || $.trim($('#commentRollback').val()) == '') {
            $('#commentRollback').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш бўйича қўшимча маълумот киритилмаган, илтимос майдонни тўлдиринг ! ';
            log_f = false;
        } else if ($.trim($('#commentRollback').val()).length > 200) {
            $('#commentRollback').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш сабаби майдонининг узунлиги 250 та белгидан ошмаслиги лозим ! ';
            log_f = false;
        } else {
            $('#commentRollback').css({'border': '1px solid #a6c9e2'});
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
                "commentRollback": $.trim($('#commentRollback').val()),
                "rollback_ids": $.trim($('#HS_CD_FULL').val()),
                "rollback_names": $.trim($('#HS_NM_FULL').val()),
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
                            var typeMessage = '';
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
    function appRollbackToFix(statusApp) {
        // alert($('#appId').val() + ', \n ' + $.trim($('#commentRollback').val()));

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
    var HS_NM_FULL_C = "";
    function addT_HS_NM(x) {
        // alert(x);
        var y = x.replaceAll(' ', '');
        var ta = document.getElementById('HS_NM_FULL').value;
        var ta2 = document.getElementById('HS_NM_FULLS').value;
        var tacd = document.getElementById('HS_CD_FULL').value;
        if (ta.length > 2) {
            if (ta.indexOf(x.substring(0, 2)) < 0) {
                document.getElementById('HS_NM_FULL').value = ta + '~' + x;
                document.getElementById('HS_NM_FULLS').value = ta2 + '\n' + x;
                HS_NM_FULL_C = y.substring('~', y.indexOf('-'));
                if (document.getElementById('HS_CD_FULL').value == null || document.getElementById('HS_CD_FULL').value == '') {
                    document.getElementById('HS_CD_FULL').value = HS_NM_FULL_C;
                } else {
                    document.getElementById('HS_CD_FULL').value = tacd + '~' + HS_NM_FULL_C;
                    // document.getElementById('HS_CD_FULL').value = tacd + '\n' + HS_NM_FULL_C;
                }
            }
        } else {
            document.getElementById('HS_NM_FULL').value = x;
            document.getElementById('HS_NM_FULLS').value = x;
            HS_NM_FULL_C = y.substring(0, y.indexOf('-'));
            if (document.getElementById('HS_CD_FULL').value == null || document.getElementById('HS_CD_FULL').value == '') {
                document.getElementById('HS_CD_FULL').value = HS_NM_FULL_C;
            } else {
                document.getElementById('HS_CD_FULL').value = tacd + '~' + HS_NM_FULL_C;
            }
        }
        document.getElementById('HS_NM').value = '';
    }
    function addT_HS_NM2(x) {
        // alert(x);
        var y = x.replaceAll(' ', '');
        var ta = document.getElementById('HS_NM_FULL2').value;
        var ta2 = document.getElementById('HS_NM_FULLS2').value;
        var tacd = document.getElementById('HS_CD_FULL2').value;
        if (ta.length > 2) {
            if (ta.indexOf(x.substring(0, 2)) < 0) {
                document.getElementById('HS_NM_FULL2').value = ta + '~' + x;
                document.getElementById('HS_NM_FULLS2').value = ta2 + '\n' + x;
                HS_NM_FULL_C = y.substring('~', y.indexOf('-'));
                if (document.getElementById('HS_CD_FULL2').value == null || document.getElementById('HS_CD_FULL2').value == '') {
                    document.getElementById('HS_CD_FULL2').value = HS_NM_FULL_C;
                } else {
                    document.getElementById('HS_CD_FULL2').value = tacd + '~' + HS_NM_FULL_C;
                    // document.getElementById('HS_CD_FULL').value = tacd + '\n' + HS_NM_FULL_C;
                }
            }
        } else {
            document.getElementById('HS_NM_FULL2').value = x;
            document.getElementById('HS_NM_FULLS2').value = x;
            HS_NM_FULL_C = y.substring(0, y.indexOf('-'));
            if (document.getElementById('HS_CD_FULL2').value == null || document.getElementById('HS_CD_FULL2').value == '') {
                document.getElementById('HS_CD_FULL2').value = HS_NM_FULL_C;
            } else {
                document.getElementById('HS_CD_FULL2').value = tacd + '~' + HS_NM_FULL_C;
            }
        }
        document.getElementById('HS_NM2').value = '';
    }
    function ClearT_HS_NM() {
        document.getElementById("HS_NM").value = "";
    }
    function ClearT_HS_NM2() {
        document.getElementById("HS_NM2").value = "";
    }

    var gtkXTButton = document.querySelector("#gtkXTButton");
    var HS_NM_FULL = document.querySelector("#HS_NM_FULL");
    var HS_NM_FULLS = document.querySelector("#HS_NM_FULLS");
    var HS_CD_FULL = document.querySelector("#HS_CD_FULL");
    gtkXTButton.onclick = function () {
        HS_NM_FULL.value = "";
        HS_NM_FULLS.value = "";
        HS_CD_FULL.value = "";
    };

    var gtkXTButton2 = document.querySelector("#gtkXTButton2");
    var HS_NM_FULL2 = document.querySelector("#HS_NM_FULL2");
    var HS_NM_FULLS2 = document.querySelector("#HS_NM_FULLS2");
    var HS_CD_FULL2 = document.querySelector("#HS_CD_FULL2");
    gtkXTButton2.onclick = function () {
        HS_NM_FULL2.value = "";
        HS_NM_FULLS2.value = "";
        HS_CD_FULL2.value = "";
    };
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
    $(document).ready( function () {
        $('#tableDecView').DataTable({
            scrollX: true
        });
    });

</script>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>