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
            <tr>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>

                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>

                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
      </tbody>
    </table>
</div>

</body>
