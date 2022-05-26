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
  <table id="exampleLC" class="table table-striped table-bordered table-responsive" >
    <thead class="bg-light-primary" style="border-color: #0a58ca; border-style: dotted">
    <tr>
      <th style="border-style: dotted">т/р</th>
      <th style="border-style: dotted">Мантиқий назорат рақами</th>
      <th style="border-style: dotted">Файл</th>
      <th style="border-style: dotted; width: 20px!important;">Мантиқий назорат номи</th>
      <th style="border-style: dotted">Мантиқий назорат хуқукий асоси</th>
      <th style="border-style: dotted">Мантиқий назорат хабари</th>
      <th style="border-style: dotted">Киритилган вақти</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="logContrl" items="${logContrlList}" varStatus="i">
      <tr>
        <td>${i.index+1}</td>
        <td>${logContrl.flkNum}</td>
        <td><button class="btn btn-outline-primary btn-sm btn-block"  onclick="openNavLc('${logContrl.id}', ${logContrl.flkNum})"><i class="bx bxs-file-pdf"></i></button></td>
        <td><textarea cols="68" style="text-align: center">${logContrl.flkName}</textarea></td>
        <td nowrap   align="left" valign= "top">${logContrl.flkBase}</td>
        <td><textarea cols="82">${logContrl.flkMsg}</textarea></td>
        <td>${logContrl.flkDate}</td>

      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<style>
  div.dt-buttons {
    position: fixed;
    top: 0;
    right: 0;
  }
</style>
<script>

  $(document).ready(function () {
    $('#exampleLC').DataTable({
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
