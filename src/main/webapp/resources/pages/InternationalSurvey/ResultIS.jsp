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
            <th style="border-style: dotted; background-color: #f8d7da;">т/р</th>
            <th style="border-style: dotted; background-color: #f8d7da;"><i class="bx bx-edit"></i>Таҳрир</th>
            <th style="border-style: dotted; background-color: #f8d7da;">ҲББ томонидан юбоирлган хат рақами</th>
            <th style="border-style: dotted; background-color: #f8d7da;">ҲББ томонидан юбоирлган хат санаси</th>
            <th style="border-style: dotted; background-color: #f8d7da;">Ташкилот номи</th>
            <th style="border-style: dotted; background-color: #f8d7da;">ТИФ ТН код</th>
            <th style="border-style: dotted; background-color: #f8d7da;">Товар номи</th>
            <th style="border-style: dotted; background-color: #f8d7da;">Сўровнома юборилган давлат</th>
            <th style="border-style: dotted; background-color: #FBD38D;">Юборилган сўровнома рақами</th>
            <th style="border-style: dotted; background-color: #FBD38D;">Юборилган сўровнома санаси</th>
            <th style="border-style: dotted; background-color: #FBD38D;">Сўровномага олинган жавоб хати</th>
            <th style="border-style: dotted; background-color: #FBD38D;">Сўровномага олинган жавоб хати санаси</th>
            <th style="border-style: dotted; background-color: #FBD38D;">Сўровномага олинган жавоб хатини ҲББга юборилган хат рақами</th>
            <th style="border-style: dotted; background-color: #FBD38D;">Сўровномага олинган жавоб хатини ҲББга юборилган хат санаси</th>
            <th style="border-style: dotted; background-color: #f8f9fe;">Сўровнома натижаси бўйича жавоб хати рақами</th>
            <th style="border-style: dotted; background-color: #f8f9fe;">Сўровнома натижаси бўйича жавоб хати санаси</th>
            <th style="border-style: dotted; background-color: #f8f9fe;">ҲББ хулоса рақами</th>
            <th style="border-style: dotted; background-color: #f8f9fe;">ҲББ хулоса санаси</th>
            <th style="border-style: dotted; background-color: #f8f9fe;">Камомад суммаси</th>
            <th style="border-style: dotted; background-color: #f8f9fe;">Изоҳ</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>11</td>
                <td><button class="btn btn-outline-primary"><i class="bx bx-edit"></i></button></td>
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
