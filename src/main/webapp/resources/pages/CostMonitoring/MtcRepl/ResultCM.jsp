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
    System.out.println(" userRole(ListInDecTable) ===> " + userRole);
    System.out.println(" userId(ListInDecTable) ===> " + userId);
%>
<head>
    <%--    <link href="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.css" rel="stylesheet"/>--%>
</head>
<%--<style>--%>
<%--    th {--%>
<%--        text-align: center; --%>
<%--        border-style: dotted!important;--%>
<%--        bg-light-primary: border border-dark border-top-0  border-end-0--%>
<%--    }--%>
<%--</style>--%>
<body>

<div class="table-responsive">
    <%--    <table class="display table table-sm table-stripped" style="width:100%">--%>
    <table class="table align-middle mb-0 table-striped shadow-sm table-bordered w-100 mt-1">
        <thead>
        <tr class="text-dark bg-white">
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">т/р</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">БЮД рўйхат рақами</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона режими</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Товарларни олиб ўтиш хусусияти</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Юк жўнатувчи номи</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">ТИФ ТН коди</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">БЮДдаги товар рақами</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Товар номи</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Марка</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Нетто оғирлиги</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Брутто оғирлиги</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қиймати АҚШ долл</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Қўшимча ўлчов бирлиги</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Қўшимча ўлчов бирлигидаги миқдори</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Бир миқдори оғирлиги</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Келиб чиқиш мамлакати</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Юк жўнатувчи мамлакат</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Савдо қилувчи мамлакат</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Транспорт тури</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">СТИР</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қиймати</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Етказиб бериш шарти</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Етказиб бериш манзили</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Шартнома валютаси</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қийматини аниқлаш усули</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қиймати бир бирлик учун валютада</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қиймати бир бирлик учун АҚШ долларида</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қиймати индекси валютада</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона қиймати индекси АҚШ долларида</th>
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Божхона чегарасаин кесиб ўтиш санаси</th>
        </tr>
        <%--        <tr class="">--%>
        <%--            <th colspan="2">--%>
        <%--                <button class="btn btn-outline-primary btn-sm"><span--%>
        <%--                        class="glyphicon glyphicon-filter"></span><i class="bx bxs-trash">Филтр</i>--%>
        <%--                </button>--%>
        <%--            </th>--%>
        <%--            <th><input type="text" class="form-control form-control" placeholder="Ходим"></th>--%>
        <%--            <th><input type="text" class="form-control form-control" placeholder="Таркибий тузилма"></th>--%>
        <%--            <th>--%>
        <%--                &lt;%&ndash;                <select class="result form-select form-control-sm shadow-sm" type="text" id="directionTypeCode" name="directionTypeCode" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} ">&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                    <option class="font-italic text-muted" selected value="">--- Танланг ---</option>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                    <c:forEach var="dirTyp" items="${directionType}" varStatus="i">&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                        <option value="${dirTyp.code}">${dirTyp.name}</option>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                    </c:forEach>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                </select>&ndash;%&gt;--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="xbbMailNumS" name="xbbMailNumS" placeholder="Хат рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="date" id="xbbMailDateS"--%>
        <%--                       name="xbbMailDateS"  onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input type="text" class="form-control" placeholder="">--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="hsCodeS" name="hsCodeS" placeholder="ТИФ ТН код" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="productNameS"--%>
        <%--                       name="productNameS"  placeholder="Товар номи" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <select class="form-select shadow-sm" id="sendReqCountryCodeS"--%>
        <%--                        name="sendReqCountryCodeS" required="" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input type="text" class="form-control" placeholder="">--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="sendReqNumS"--%>
        <%--                       name="sendReqNumS" placeholder="Юборилган сўровнома рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="date" id="reqDateS"--%>
        <%--                       name="reqDateS" placeholder="Юборилган сўровнома санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="responseNumS"--%>
        <%--                       name="responseNumS" placeholder="Сўровномага олинган жавоб хати" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="date" id="responseDateS"--%>
        <%--                       name="responseDateS" placeholder="Олинган жавоб хати санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="responseNumSendXbbNumS"--%>
        <%--                       name="responseNumSendXbbNumS" placeholder="ХББга юборилган хат рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="date"--%>
        <%--                       id="responseNumSendXbbDateS" name="responseNumSendXbbDateS" placeholder="ҲББга юборилган хат санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>

        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="resultAnswerMailNumS"--%>
        <%--                       name="resultAnswerMailNumS" placeholder="Натижаси бўйича жавоб хати рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="date" id="resultAnswerMailDateS"--%>
        <%--                       name="resultAnswerMailDateS" placeholder="Натижаси бўйича жавоб хати санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="text" id="xbbVerdictNumS"--%>
        <%--                       name="xbbVerdictNumS" placeholder="ҲББ хулоса рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input class="result form-control shadow-sm" type="date" id="xbbVerdictDateS"--%>
        <%--                       name="xbbVerdictDateS" placeholder="ҲББ хулоса санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                &lt;%&ndash;                <input type="text" class="form-control form-control-sm" placeholder="">&ndash;%&gt;--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                &lt;%&ndash;                <input type="text" class="form-control form-control-sm" placeholder="">&ndash;%&gt;--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                &lt;%&ndash;                <input type="text" class="form-control form-control-sm" placeholder="">&ndash;%&gt;--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input type="text" class="form-control" placeholder="Фабула">--%>
        <%--            </th>--%>
        <%--            <th>--%>
        <%--                <input type="text" class="form-control" placeholder="Изоҳ">--%>
        <%--            </th>--%>
        <%--        </tr>--%>
        </thead>
        <tbody class="">
        <c:if test="${mtcReplList.size() >= 1}">
            <c:forEach var="mtcVal" items="${mtcReplList}" varStatus="i">
                <tr>
                    <td style="text-align: center">${((currentPage+1) * getPageSize - getPageSize + 1)+i.index}</td>
                    <!-- 1 start-->
                    <td align="center">${mtcVal.g7A}/${mtcVal.g7B}/${mtcVal.g7C}</td>
                    <td align="center">${mtcVal.g1A} ${mtcVal.g1B}</td>
                    <td align="center">${mtcVal.g1B} ${mtcVal.g37B} ${mtcVal.g37C}</td>
                    <td align="center"><textarea cols="40" rows="1" style="border: none; overflow-y:auto; font-size: 12px; font-family: Arial;" readonly="readonly">${mtcVal.g2Name}</textarea></td>
                    <td align="center">${mtcVal.g33}</td>
                    <td align="center">${mtcVal.g32}</td>
                    <td width="300px" align="right">
                        <table style="width: 300px">
                            <tr style="border-left: 0; border-right: 0; border-top: 0; border-bottom: 0;">
                                <td style="border-left: 0; border-right: 0; border-top: 0; border-bottom: 0;">
                                    <textarea rows="3" style="border:none; overflow-y:auto; font-size: 12px; font-family: Arial; width: 100%" readonly="readonly">${mtcVal.g31Name}</textarea>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td align="center">${mtcVal.g31Marka}</td>
                    <td align="center">${mtcVal.g38}</td>
                    <td align="center">${mtcVal.g35}</td>
                    <td align="center">${mtcVal.g45Usd}</td>
                    <td align="center">${mtcVal.g41Nm}</td>
                    <td align="center">${mtcVal.g31Amount}</td>
                    <td align="center">${mtcVal.vesEdizm}</td>
                    <td align="center">${mtcVal.g34Nm}</td>
                    <td align="center">${mtcVal.g15Nm}</td>
                    <td align="center">${mtcVal.g11Nm}</td>
                    <td align="center">${mtcVal.g25}</td>
                    <td align="center">${mtcVal.g8Code2}</td>
                    <td align="center">${mtcVal.g45Usd2}</td>
                    <td align="center">${mtcVal.g20B}</td>
                    <td align="center">${mtcVal.g20Name}</td>
                    <td align="center">${mtcVal.g22A}</td>
                    <td align="center">${mtcVal.metodOtc}</td>
                    <td align="center">${mtcVal.g45EdizmValkont}</td>
                    <td align="center">${mtcVal.g45UsdEdizm}</td>
                    <td align="center">${mtcVal.g45IndexValkont}</td>
                    <td align="center">${mtcVal.g45Index}</td>
                    <td align="center">${mtcVal.gc3Date}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${mtcReplList.size() < 1}">
            <tr>
                <td class="no-result text-center" style="text-align: center" colspan="38">Маълумотлар топилмади!</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<div class="position-relative">
    <div class="text-left">
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + mtcReplList.size()) >= 1}">
            <p class="text-muted">
                    ${(currentPage+1) * getPageSize - getPageSize + 1} дан
                    ${((currentPage+1) * getPageSize - getPageSize + mtcReplList.size())} гача;
                Жами:${totalItems} та маълумот
            </p>
        </c:if>
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + mtcReplList.size()) <= 0}">
            <span class="text-primary h5 mt-4">Маълумотлар топилмади!</span>
        </c:if>
    </div>

    <div class="position-absolute end-0 translate-middle-y mt-5">
        <ul>
            <li class="page-item"><a class="page-link act" href="#">${currentPage+1}</a></li>
<%--            <c:forEach></c:forEach>--%>
        </ul>
    </div>

    <div class="position-absolute end-0 translate-middle-y">
        <nav class="" aria-label="Page navigation example">
            <ul class="pagination">
                <c:if test="${currentPage > 1}">
                    <li class="page-item"><a class="page-link" href="#" onclick="searchResultTableMtcRepl('${0}',event)">Дастлабки</a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 1}">
                    <li class="page-item"><a class="page-link" href="#" disabled="disabled" style="cursor: not-allowed">Дастлабки</a>
                    </li>
                </c:if>
                <c:if test="${currentPage > 0}">
                    <li class="page-item">
                        <a class="page-link" href="#" onclick="searchResultTableMtcRepl('${currentPage-1}',event)">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 0}">
                    <li class="page-item">
                        <a class="page-link" disabled="disabled" href="#" onclick="searchResultTableMtcRepl('${currentPage-1}', event)" style="cursor: not-allowed">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <%--                    <li class="page-item"><a class="page-link" href="#">...</a></li>--%>
                <%--                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
                <li class="page-item"><a class="page-link act" href="#">${currentPage+1}</a></li>
                <%--                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                <%--                    <li class="page-item"><a class="page-link" href="#">...</a></li>--%>
                <c:if test="${currentPage < (totalPages-1)}">
                    <li class="page-item">
                        <a class="page-link" href="#" onclick="searchResultTableMtcRepl('${currentPage+1}',event)">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${currentPage == (totalPages-1)}">
                    <li class="page-item">
                        <a class="page-link" disabled="disabled" href="#" onclick="${currentPage+1}" style="cursor: not-allowed">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${currentPage < (totalPages-2)}">
                    <li class="page-item"><a class="page-link" href="#"
                                             onclick="searchResultTableMtcRepl('${totalPages-1}', event)">Охирги</a></li>
                </c:if>
                <c:if test="${currentPage >= (totalPages-2)}">
                    <li class="page-item"><a class="page-link" href="#" disabled="disabled" style="cursor: not-allowed">Охирги</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>

<script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.js"></script>
<%--<script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery-3.5.1.js"></script>--%>

</body>


