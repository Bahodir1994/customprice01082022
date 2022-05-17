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
<body>

<div class="table-responsive">
    <table id="example1" class="table table-striped table-bordered table-responsive">
        <thead class="bg-light-primary" style="border-color: #0a58ca; border-style: dotted">
        <tr>
            <th style="border-style: dotted">т/р</th>
            <th style="border-style: dotted">БЮД рўйхат рақами</th>
            <th style="border-style: dotted">Божхона режими</th>
            <th style="border-style: dotted">Товарларни олиб ўтиш хусусияти</th>
            <th style="border-style: dotted">Юк жўнатувчи номи</th>
            <th style="border-style: dotted">ТИФ ТН коди</th>
            <th style="border-style: dotted">БЮДдаги товар рақами</th>
            <th style="border-style: dotted">Товар номи</th>
            <th style="border-style: dotted">Нетто оғирлиги</th>
            <th style="border-style: dotted">Брутто оғирлиги</th>

            <th style="border-style: dotted">Божхона қиймати АҚШ долл</th>
            <th style="border-style: dotted">Қўшимча ўлчов бирлиги</th>
            <th style="border-style: dotted">Қўшимча ўлчов бирлигидаги миқдори</th>
            <th style="border-style: dotted">Бир миқдори оғирлиги</th>
            <th style="border-style: dotted">Келиб чиқиш мамлакати</th>
            <th style="border-style: dotted">Юк жўнатувчи мамлакат</th>
            <th style="border-style: dotted">Савдо қилувчи мамлакат</th>
            <th style="border-style: dotted">Транспорт тури</th>
            <th style="border-style: dotted">СТИР</th>
            <th style="border-style: dotted">Божхона қиймати</th>

            <th style="border-style: dotted">Етказиб бериш шарти</th>
            <th style="border-style: dotted">Етказиб бериш манзили</th>
            <th style="border-style: dotted">Валюта</th>
            <th style="border-style: dotted">Божхона қийматини аниқлаш усули</th>
            <th style="border-style: dotted">Божхона қиймати бир бирлик учун валютада</th>
            <th style="border-style: dotted">Божхона қиймати бир бирлик учун АҚШ долларида</th>
            <th style="border-style: dotted">Божхона қиймати индекси валютада</th>
            <th style="border-style: dotted">Божхона қиймати индекси АҚШ долларида</th>
            <th style="border-style: dotted">Божхона чегарасаин кесиб ўтиш санаси</th>
            <th style="border-style: dotted">БДТ қилинган ёки қилинмаган</th>
        </tr>
        </thead>
        <tbody>
        <%--        <tr>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>

        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>

        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--            <td>11</td>--%>
        <%--        </tr>--%>

        <c:forEach var="mtcVal" items="${mtcReplList}" varStatus="i">
            <tr>
                <td align="center"><b>${i.index+1}</b></td>
                <td align="center">${mtcVal.g7a}/${mtcVal.g7b}/${mtcVal.g7c}</td>
                <td align="center">${mtcVal.g1a} ${mtcVal.g1b}</td>
                <td align="center">${mtcVal.g1b} ${mtcVal.g37b} ${mtcVal.g37c}</td>
                <td align="center"><textarea cols="40" rows="1" style="border: none; overflow-y:auto; font-size: 12px; font-family: Arial;" readonly="readonly">${mtcVal.g2name}</textarea></td>
                <td align="center">${mtcVal.g33}</td>
                <td align="center">${mtcVal.g32}</td>
                <td width="300px" align="right">
                    <table style="width: 300px">
                        <tr style="border-left: 0; border-right: 0; border-top: 0; border-bottom: 0;">
                            <td style="border-left: 0; border-right: 0; border-top: 0; border-bottom: 0;">
                                <textarea rows="3" style="border:none; overflow-y:auto; font-size: 12px; font-family: Arial; width: 100%" readonly="readonly">${mtcVal.g31name}</textarea>
                            </td>
                        </tr>
                    </table>
                </td>
                <td align="center">${mtcVal.g31marka}</td>
                <td align="center">${mtcVal.g38}</td>
                <td align="center">${mtcVal.g35}</td>
                <td align="center">${mtcVal.g45_usd}</td>
                <td align="center">${mtcVal.g41name}</td>
                <td align="center">${mtcVal.g31amount}</td>
                <td align="center">${mtcVal.ves_edizm}</td>
                <td align="center">${mtcVal.g34name}</td>
                <td align="center">${mtcVal.g15name}</td>
                <td align="center">${mtcVal.g11name}</td>
                <td align="center">${mtcVal.g25}</td>
                <td align="center">${mtcVal.g22a}</td>
                <td align="center">${mtcVal.g23}</td>
                <td align="center">${mtcVal.g13}</td>
                <td align="center">${mtcVal.metod_otc}</td>
                <td align="center">${mtcVal.g45_edizm_valkont}</td>
                <td align="center">${mtcVal.g45usd_edizm}</td>
                <td align="center">${mtcVal.g45_index_valkont}</td>
                <td align="center">${mtcVal.g45_index}</td>
                <td align="center">${mtcVal.gc3date}</td>
                <td align="center">${mtcVal.vid_tulov == 1 ? "1-Облагаемый" : "2-Необлагаемый"}</td>
                <td align="center">${mtcVal.doc_type == 2 ? "КТС" : mtcVal.doc_type == 3 ? "КТД" : "Нет"}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
