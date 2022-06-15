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
<body>
<div class="table-responsive">
    <table class="table align-middle mb-0 table-striped shadow-sm table-bordered w-100 mt-1" id="interSurveyTable">
        <thead>
        <tr class="text-dark bg-white">
            <th style="text-align: center; border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">т/р</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0"><i class="bx bx-edit"></i>Таҳрир</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Ходим</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Таркибий тузилма</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Йўналиш</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">ҲББ томонидан юбоирлган<br>хат рақами</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">ҲББ томонидан юбоирлган<br>хат санаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Ташкилот номи</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">ТИФ ТН код</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Товар номи</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровнома юборилган<br>давлат</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Эхтимолий қўшимча <br>хисобланган</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Юборилган сўровнома<br>рақами</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Юборилган сўровнома<br>санаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровномага олинган<br>жавоб хати</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровномага олинган жавоб<br>хати санаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровномага олинган жавоб хатини<br>ҲББга юборилган хат рақами</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровномага олинган жавоб хатини<br>ҲББга юборилган хат санаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Масъул ХББ</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровнома натижаси бўйича жавоб<br>хати рақами</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Сўровнома натижаси бўйича жавоб<br>хати санаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">ҲББ хулоса рақами</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">ҲББ хулоса санаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Камомад<br>суммаси</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Ундирилган<br>сумма</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Назоратдаги<br>сумма</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0  border-end-0">Фабула</th>
            <th style="text-align: center;border-style: dotted!important;" class="bg-light-primary border border-dark border-top-0 ">Изоҳ</th>
        </tr>
        <tr class="">
            <th></th>
            <th>
                <button class="btn btn-outline-primary btn-sm btn-block" onclick="resetFilterOoTable(1)">
                    <span class="glyphicon glyphicon-filter"></span>
                    <i class="bx bxs-trash"></i>
                </button>
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;"
                       class="result form-control" type="text" id="savedUserFirstS" name="savedUserFirstS" placeholder="Ходим" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <select style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" onchange="searchResultTableIS(0)"
                    class="result form-select" type="text" id="userLocationCodeS" name="userLocationCodeS">
                    <option class="font-italic" selected value="">--- Танланг ---</option>
                    <c:forEach var="usrLoc" items="${location}" varStatus="i">
                        <option value="${usrLoc.id}">${usrLoc.name1}</option>
                    </c:forEach>
                </select>
            </th>
            <th></th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="xbbMailNumS" name="xbbMailNumS" placeholder="Хат рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="date" id="xbbMailDateS"
                       name="xbbMailDateS"  onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" type="text" id="orgNameS" name="orgNameS" class="form-control" placeholder="Ташкилот номи" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} ">
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="hsCodeS" name="hsCodeS" placeholder="ТИФ ТН код" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="productNameS"
                       name="productNameS"  placeholder="Товар номи" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th></th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" id="sumProbabilityS" name="sumProbabilityS" type="text" class="form-control" placeholder="Эхтимолий қўшимча хисобланган" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="sendReqNumS"
                       name="sendReqNumS" placeholder="Юборилган сўровнома рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="date" id="reqDateS"
                       name="reqDateS" placeholder="Юборилган сўровнома санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="responseNumS"
                       name="responseNumS" placeholder="Сўровномага олинган жавоб хати" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="date" id="responseDateS"
                       name="responseDateS" placeholder="Олинган жавоб хати санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="responseNumSendXbbNumS"
                       name="responseNumSendXbbNumS" placeholder="ХББга юборилган хат рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="date"
                       id="responseNumSendXbbDateS" name="responseNumSendXbbDateS" placeholder="ҲББга юборилган хат санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th></th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="resultAnswerMailNumS"
                       name="resultAnswerMailNumS" placeholder="Натижаси бўйича жавоб хати рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="date" id="resultAnswerMailDateS"
                       name="resultAnswerMailDateS" placeholder="Натижаси бўйича жавоб хати санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="text" id="xbbVerdictNumS"
                       name="xbbVerdictNumS" placeholder="ҲББ хулоса рақами" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" class="result form-control" type="date" id="xbbVerdictDateS"
                       name="xbbVerdictDateS" placeholder="ҲББ хулоса санаси" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th></th>
            <th></th>
            <th></th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" id="fabulaS" name="fabulaS" type="text" class="form-control" placeholder="Фабула" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
            <th>
                <input style="box-shadow: rgb(204, 219, 232) 3px 3px 6px 0px inset, rgba(255, 255, 255, 0.5) -3px -3px 6px 1px inset;" id="commentS" name="commentS" type="text" class="form-control" placeholder="Изоҳ" onkeypress="if (event.keyCode == 13) {searchResultTableIS(0); return false;} " />
            </th>
        </tr>
        </thead>
        <style>
            .mess {
                display: inline-block; /* Строчно-блочный элемент */
                position: relative; /* Относительное позиционирование */
            }

            .mess:hover::after {
                content: attr(data-title); /* Выводим текст */
                position: absolute; /* Абсолютное позиционирование */
                left: 20%;
                top: 30%; /* Положение подсказки */
                z-index: 1; /* Отображаем подсказку поверх других элементов */
                background: rgb(9, 9, 9); /* Полупрозрачный цвет фона */
                font-family: Arial, sans-serif; /* Гарнитура шрифта */
                font-size: 11px; /* Размер текста подсказки */
                color: #f8f9fe !important;
                padding: 5px 10px; /* Поля */
                border: 1px solid #333; /* Параметры рамки */
                border-radius: 30px;
            }
        </style>
        <tbody class="">
        <c:if test="${tutorials.size() >= 1}">
            <c:forEach var="tut" items="${tutorials}" varStatus="i">
                <tr>
                    <td style="text-align: center">${((currentPage+1) * getPageSize - getPageSize + 1)+i.index}</td>
                    <c:if test="${tut.status == '100'}">
                        <c:if test="${userLocation == '1701'}">
                            <c:if test="${tut.userLocationCode != '1701'}">
                                <td>
                                    <button class="btn btn-primary btn-sm" data-title=""
                                            data-bs-toggle="modal" data-bs-target="#exampleModal2"
                                            onclick="('${tut.userLocationCode}' === '1701' ? $('#divLocDir').css({'display': ''}) : $('#divLocDir').css({'display': 'none'}));
                                            $('#interSurveyId2').val('${tut.id}');
                                            $('#interSurveyStatus2').val('${tut.status}');
                                            $('#interSurveyUserLocationCode').val('${tut.userLocationCode}');
                                            $('#sendReqNum').val('${tut.sendReqNum}');
                                            $('#reqDate').val('${tut.reqDate}');
                                            $('#responseNum').val('${tut.responseNum}');
                                            $('#responseDate').val('${tut.responseDate}');
                                            $('#responseNumSendXbbNum').val('${tut.responseNumSendXbbNum}');
                                            $('#responseNumSendXbbDate').val('${tut.responseNumSendXbbDate}');
                                            $('#executiveTerritoryCode').val('${tut.executiveTerritoryCode}');
                                                    ">
                                        <i class="bx bx-plus"></i></button>
                                </td>
                            </c:if>
                            <c:if test="${(tut.savedUserFirstId ==userId) && tut.userLocationCode == '1701'}">
                                <td>
                                    <button class="btn btn-primary btn-sm" data-title=""
                                            data-bs-toggle="modal" data-bs-target="#exampleModal2"
                                            onclick="('${tut.userLocationCode}' === '1701' ? $('#divLocDir').css({'display': ''}) : $('#divLocDir').css({'display': 'none'}));
                                            $('#interSurveyId2').val('${tut.id}');$('#interSurveyStatus2').val('${tut.status}');
                                            $('#interSurveyUserLocationCode').val('${tut.userLocationCode}');
                                            $('#sendReqNum').val('${tut.sendReqNum}');
                                            $('#reqDate').val('${tut.reqDate}');
                                            $('#responseNum').val('${tut.responseNum}');
                                            $('#responseDate').val('${tut.responseDate}');
                                            $('#responseNumSendXbbNum').val('${tut.responseNumSendXbbNum}');
                                            $('#responseNumSendXbbDate').val('${tut.responseNumSendXbbDate}');
                                            $('#executiveTerritoryCode').val('${tut.executiveTerritoryCode}');
                                                    ">
                                        <i class="bx bx-plus"></i></button>
                                </td>
                            </c:if>
                            <c:if test="${tut.userLocationCode == '1701' && (tut.savedUserFirstId != userId)}">
                                    <td>
                                        <button class="mess btn btn-primary btn-sm" data-title="Сиз учун тақиқланган!"><i
                                                class="bx bx-info-circle"></i></button>
                                    </td>
                            </c:if>
                        </c:if>
                        <c:if test="${userLocation != '1701'}">
                            <td>
                                <button class="mess btn btn-primary btn-sm" data-title="Сиз учун тақиқланган!"><i
                                        class="bx bx-info-circle"></i></button>
                            </td>
                        </c:if>
                    </c:if>
                    <c:if test="${tut.status == '200'}">
                        <c:if test="${tut.distributed == 'no'}">
                            <c:if test="${(tut.executiveTerritoryCode == userLocation && userId == tut.savedUserFirstId)}">
                                <td>
                                    <button class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal3"
                                            onclick="$('#interSurveyId3').val('${tut.id}');$('#interSurveyStatus3').val('${tut.status}')">
                                        <i class="bx bx-plus"></i></button>
                                </td>
                            </c:if>
                            <c:if test="${(tut.executiveTerritoryCode != userLocation || userId != tut.savedUserFirstId)}">
                                <td>
                                    <button class="mess btn btn-primary btn-sm" data-title="Сиз учун тақиқланган!"><i
                                            class="bx bx-info-circle"></i></button>
                                </td>
                            </c:if>
                        </c:if>
                        <c:if test="${tut.distributed == 'yes'}">
                            <c:if test="${(tut.executiveTerritoryCode == userLocation && userRole == 7)}">
                                <td>
                                    <button class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal3"
                                            onclick="$('#interSurveyId3').val('${tut.id}');$('#interSurveyStatus3').val('${tut.status}')">
                                        <i class="bx bx-plus"></i></button>
                                </td>
                            </c:if>
                            <c:if test="${(tut.executiveTerritoryCode != userLocation || userRole != 7)}">
                                <td>
                                    <button class="mess btn btn-primary btn-sm" data-title="Сиз учун тақиқланган!"><i
                                            class="bx bx-info-circle"></i></button>
                                </td>
                            </c:if>
                        </c:if>
                    </c:if>
                    <c:if test="${tut.status == '300'}">
                        <c:if test="${tut.sumOnControl != '0.00'}">
                            <div class="modal fade" id="modalAddSumApproved" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="header m-2 text-center">
                                            <h5 class="text-center" id="exampleModalLabel">Хат рақами
                                                №:${tut.xbbMailNum} бўлган сўровнома<br> бўйича ундирилган тўловни
                                                киритиш</h5>
                                        </div>
                                        <div class="modal-body">
                                            <form>
                                                <div class="mb-3">
                                                    <label for="sumApprovedAdd" class="col-form-label">Ундирилган сумма
                                                        миқдори:</label>
                                                    <input type="number" class="form-control" id="sumApprovedAdd">
                                                    <input hidden value="${tut.id}" id="IsId"/>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="fabulaAdd" class="col-form-label">Фабула:</label>
                                                    <textarea class="form-control" id="fabulaAdd"></textarea>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="commentAdd" class="col-form-label">Изох:</label>
                                                    <textarea class="form-control" id="commentAdd"></textarea>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal"
                                                    id="modalAddSumApprovedClose"><i class="bx bx-window-close"></i>
                                            </button>
                                            <button type="button" class="btn btn-primary"
                                                    onclick="saveSumApprovedAdd()">Сақлаш
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${userLocation == '1701'}">
                                <c:if test="${userId == tut.savedUserFirstId}">
                                    <td>
                                        <button class="mess btn btn-danger btn-sm" data-bs-toggle="modal"
                                                data-bs-target="#modalAddSumApproved" data-bs-whatever="@mdo"
                                                data-title="Назоратда"><i class="bx bxs-info-square"></i></button>
                                    </td>
                                </c:if>
                                <c:if test="${userId != tut.savedUserFirstId}">
                                    <td>
                                        <button class="mess btn btn-danger btn-sm" data-title="Назоратда, Сиз учун тақиқланган!"><i
                                                class="bx bxs-info-square"></i></button>
                                    </td>
                                </c:if>
                            </c:if>
                            <c:if test="${userLocation != '1701'}">
                                <c:if test="${tut.distributed == 'no'}">
                                    <c:if test="${userId == tut.savedUserFirstId}">
                                        <td>
                                            <button class="mess btn btn-danger btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#modalAddSumApproved" data-bs-whatever="@mdo"
                                                    data-title="Назоратда"><i class="bx bxs-info-square"></i></button>
                                        </td>
                                    </c:if>
                                    <c:if test="${userId != tut.savedUserFirstId}">
                                        <td>
                                            <button class="mess btn btn-danger btn-sm" data-title="Назоратда, Сиз учун тақиқланган!"><i
                                                    class="bx bxs-info-square"></i></button>
                                        </td>
                                    </c:if>
                                </c:if>
                                <c:if test="${tut.distributed == 'yes'}">
                                    <c:if test="${userRole == 7}">
                                        <td>
                                            <button class="mess btn btn-danger btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#modalAddSumApproved" data-bs-whatever="@mdo"
                                                    data-title="Назоратда"><i class="bx bxs-info-square"></i></button>
                                        </td>
                                    </c:if>
                                    <c:if test="${userRole != 7}">
                                        <td>
                                            <button class="mess btn btn-danger btn-sm" data-title="Назоратда, Сиз учун тақиқланган!"><i
                                                    class="bx bxs-info-square"></i></button>
                                        </td>
                                    </c:if>
                                </c:if>
                            </c:if>
                        </c:if>
                        <c:if test="${tut.sumOnControl == '0.00'}">
                            <td>
                                <button class="mess btn btn-success btn-sm" data-title="Якунланган"><i
                                        class="bx bx-check"></i></button>
                            </td>
                        </c:if>
                    </c:if>
                    <!-- 1 start-->
                    <td style="text-align: center;">${tut.savedUserFirst}</td>
                    <td style="text-align: center;">${tut.userLocationName}</td>
                    <td style="text-align: center;">${tut.directionTypeName}</td>
                    <td style="text-align: center;">${tut.xbbMailNum}</td>
                    <td style="text-align: center;">${tut.xbbMailDate}</td>
                    <td style="text-align: center;">${tut.orgName}</td>
                    <td style="text-align: center;">${tut.hsCode}</td>
                    <td style="text-align: center;">${tut.productName}</td>
                    <td style="text-align: center;">${tut.sendReqCountryNm}</td>
                    <td class="myDIV" style="text-align: center;">${tut.sumProbability}</td>
                    <!-- 2 start-->
                    <td style="text-align: center;">${tut.sendReqNum}</td>
                    <td style="text-align: center;">${tut.reqDate}</td>
                    <td style="text-align: center;">${tut.responseNum}</td>
                    <td style="text-align: center;">${tut.responseDate}</td>
                    <td style="text-align: center;">${tut.responseNumSendXbbNum}</td>
                    <td style="text-align: center;">${tut.responseNumSendXbbDate}</td>
                    <c:if test="${tut.status == '100'}">
                        <td style="text-align: center;"></td>
                    </c:if>
                    <c:if test="${tut.status != '100'}">
                        <td style="text-align: center;">${tut.executiveTerritoryName}</td>
                    </c:if>
                    <!-- 3 start-->
                    <td style="text-align: center;">${tut.resultAnswerMailNum}</td>
                    <td style="text-align: center;">${tut.resultAnswerMailDate}</td>
                    <td style="text-align: center;">${tut.xbbVerdictNum}</td>
                    <td style="text-align: center;">${tut.xbbVerdictDate}</td>
                    <td class="myDIV" style="text-align: center;">${tut.sum}</td>
                    <td class="myDIV" style="text-align: center;">${tut.sumАpproved}</td>
                    <c:if test="${tut.sumOnControl == '0.00'}">
                        <td class="myDIV text-success" style="text-align: center;">${tut.sumOnControl}</td>
                    </c:if>
                    <c:if test="${tut.sumOnControl != '0.00'}">
                        <td class="myDIV text-danger" style="text-align: center;">${tut.sumOnControl}</td>
                    </c:if>
                    <td style="text-align: center;"><textarea size="25" rows="2">${tut.fabula}</textarea></td>
                    <td style="text-align: center;">${tut.comment}</td>
                </tr>
                <!-- Modal 2-qadam-->
                <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-xl col-md-12">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel2">Халқаро сўровнома киритиш №-2</h5>
                                <button type="button" class="btn-close" id="closeModalSave2" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body row">
                                <!--todo 2-bosqich-->
                                <form class="row g-3 needs-validation2">
                                    <div class="form-group col-md-3 mb-2">
                                        <label for="sendReqNum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Юборилган сўровнома
                                            рақами:</label>
                                        <input class="form-control" type="hidden" id="interSurveyId2"
                                               name="interSurveyId2">
                                        <input class="form-control" type="hidden" id="interSurveyUserLocationCode"
                                               name="interSurveyUserLocationCode">
                                        <input class="form-control" type="hidden" id="interSurveyStatus2"
                                               name="interSurveyStatus2">
                                        <input class="form-control" type="text" id="sendReqNum" name="sendReqNum">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="sendReqNumValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mb-2">
                                        <label for="reqDate" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Юборилган сўровнома
                                            санаси:</label>
                                        <input class="form-control" type="date" id="reqDate" name="reqDate">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="reqDateValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mb-2">
                                        <label for="responseNum" class="form-label text-primary"><span class="text-danger"></span>Сўровномага олинган
                                            жавоб хати:</label>
                                        <input class="form-control" type="text" id="responseNum" name="responseNum">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="responseNumValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mb-2">
                                        <label for="responseDate" class="form-label text-primary"><span class="text-danger"></span>Сўровномага олинган
                                            жавоб хати санаси:</label>
                                        <input class="form-control" type="date" id="responseDate" name="responseDate">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="responseDateValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mb-2">
                                        <label for="responseNumSendXbbNum" class="form-label text-primary"><span class="text-danger"></span>Сўровномага
                                            олинган жавоб хатини<br> ҲББга юборилган хат рақами:</label>
                                        <input class="form-control" type="text" id="responseNumSendXbbNum"
                                               name="responseNumSendXbbNum">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="responseNumSendXbbNumValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mb-2">
                                        <label for="responseNumSendXbbDate" class="form-label text-primary"><span class="text-danger"></span>Сўровномага
                                            олинган жавоб хатини<br> ҲББга юборилган хат санаси:</label>
                                        <input class="form-control" type="date" id="responseNumSendXbbDate"
                                               name="responseNumSendXbbDate">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="responseNumSendXbbDateValid"></div>
                                    </div>
                                    <c:if test="${userLocation == '1701'}">
                                        <div class="form-group col-md-3 mb-2" id="divLocDir">
                                            <label for="executiveTerritoryCode"
                                                   class="form-label text-primary"><br><span class="text-danger">&#x2734;</span>Ижрочи Ҳудуд:</label>
                                            <select class="form-control" type="date" id="executiveTerritoryCode"
                                                    name="executiveTerritoryCode">
                                                <option class="font-italic" selected value="">--- Танланг ---</option>
                                                <c:forEach var="locDir" items="${locationDirectory}" varStatus="i">
                                                    <option value="${locDir.id}">${locDir.id}- ${locDir.name1}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="valid-feedback">Текширилди</div>
                                            <div class="" id="executiveTerritoryCodeValid"></div>
                                        </div>
                                    </c:if>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary"
                                                onclick="saveValueFromInputSStep2(event)">Сақлаш
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal 3-qadam-->
                <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-xl col-md-12">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel3">Халқаро сўровнома киритиш №-3</h5>
                                <button type="button" class="btn-close" id="closeModalSave3" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body row">
                                <!--todo 3-bosqich-->
                                <form class="row g-3 needs-validation3">
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="resultAnswerMailNum" class="mess form-label text-primary"
                                               data-title="Сўровнома натижаси бўйича жавоб хати рақами"><span class="text-danger">&#x2734;</span>Сўров.нат.бўй.жав.хат.рақами:</label>
                                        <input class="form-control" type="hidden" id="interSurveyId3"
                                               name="interSurveyId3">
                                        <input class="form-control" type="hidden" id="interSurveyStatus3"
                                               name="interSurveyStatus3">
                                        <input class="form-control" type="text" id="resultAnswerMailNum"
                                               name="resultAnswerMailNum">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="resultAnswerMailNumValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="resultAnswerMailDate" class="mess form-label text-primary"
                                               data-title="Сўровнома натижаси бўйича жавоб хати санаси">Сўров.нат.бўй.жав.хат.санаси:</label>
                                        <input class="form-control" type="date" id="resultAnswerMailDate"
                                               name="resultAnswerMailDate">
                                        <div class="valid-feedback"><span class="text-danger">&#x2734;</span>Текширилди</div>
                                        <div class="" id="resultAnswerMailDateValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="xbbVerdictNum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>ҲББ хулоса
                                            рақами:</label>
                                        <input class="form-control" type="text" id="xbbVerdictNum"
                                               name="xbbVerdictNum">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="xbbVerdictNumValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="xbbVerdictDate" class="form-label text-primary"><span class="text-danger">&#x2734;</span>ҲББ хулоса
                                            санаси:</label>
                                        <input class="form-control" type="date" id="xbbVerdictDate"
                                               name="xbbVerdictDate">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="xbbVerdictDateValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="sum" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Камомад суммаси:</label>
                                        <input class="form-control was-validated" type="text" id="sum" name="sum">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="sumValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="sum" class="form-label text-primary">Ундирилди:</label>
                                        <input class="form-control was-validated" type="text" id="sumАpproved"
                                               name="sumАpproved">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="sumАpprovedValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="fabula" class="form-label text-primary">Фабула:</label>
                                        <input class="form-control was-validated" type="text" id="fabula"
                                               name="comment">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="fabulaValid"></div>
                                    </div>
                                    <div class="form-group col-md-3 mt-2">
                                        <label for="comment" class="form-label text-primary"><span class="text-danger">&#x2734;</span>Изох:</label>
                                        <input class="form-control was-validated" type="text" id="comment"
                                               name="comment">
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="" id="commentValid"></div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary"
                                                onclick="saveValueFromInputSStep3()">Сақлаш
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${tutorials.size() < 1}">
            <tr>
                <td class="no-result text-center" style="text-align: center" colspan="38">Маълумотлар топилмади!</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<div class="position-relative">
    <div class="text-left">
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + tutorials.size()) >= 1}">
            <p class="text-muted">
                    ${(currentPage+1) * getPageSize - getPageSize + 1} дан
                    ${((currentPage+1) * getPageSize - getPageSize + tutorials.size())} гача;
                Жами:${totalItems} та маълумот
            </p>
        </c:if>
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + tutorials.size()) <= 0}">
            <span class="text-primary h5 mt-4">Маълумотлар топилмади!</span>
        </c:if>
    </div>
    <div class="position-absolute end-0 translate-middle-y">
        <nav class="" aria-label="Page navigation example">
            <ul class="pagination">
                <c:if test="${currentPage > 1}">
                    <li class="page-item"><a class="page-link" href="#" onclick="searchResultTableIS('${0}',event)">Дастлабки</a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 1}">
                    <li class="page-item"><a class="page-link" href="#" disabled="disabled" style="cursor: not-allowed">Дастлабки</a>
                    </li>
                </c:if>
                <c:if test="${currentPage > 0}">
                    <li class="page-item">
                        <a class="page-link" href="#" onclick="searchResultTableIS('${currentPage-1}',event)">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 0}">
                    <li class="page-item">
                        <a class="page-link" disabled="disabled" href="#" onclick="${currentPage-1}, event" style="cursor: not-allowed">
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
                        <a class="page-link" href="#" onclick="searchResultTableIS('${currentPage+1}',event)">
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
                                             onclick="searchResultTableIS('${totalPages-1}', event)">Охирги</a></li>
                </c:if>
                <c:if test="${currentPage >= (totalPages-2)}">
                    <li class="page-item"><a class="page-link" href="#" disabled="disabled" style="cursor: not-allowed">Охирги</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
<script>
    function saveSumApprovedAdd() {
        var dataS = {
            "sumApprovedAdd": $('#sumApprovedAdd').val(),
            "commentAdd": $('#commentAdd').val(),
            "IsId": $('#IsId').val(),
            "fabulaAdd": $('#fabulaAdd').val(),
        }
        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveSumApprovedAdd",
            dataType: "json",
            async: true,
            contentType: 'application/json',
            success: function (res) {
                $('#modalAddSumApprovedClose').trigger('click');
                searchResultTableIS();
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Сақланди',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (response) {
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Маълумотлар Бўш бўлиши мумкин эмас!',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });

    }
    function saveValueFromInputSStep2(e = null) {
        let userLocation = '<%=userLocation%>';
        let userLocationCode = $('#interSurveyUserLocationCode').val();
        if (userLocation != "1701" || userLocationCode != "1701") {
            resultExecuTerritoryCode = userLocationCode;
            resultDistributed = "no"
        } else {
            resultExecuTerritoryCode = $('#executiveTerritoryCode').val();
            resultDistributed = "yes"
        }
        console.log(userLocation + userLocationCode)
        var dataS = {
            /*"xbbMailNum": $('#xbbMailNum').val(),
            "xbbMailDate": $('#xbbMailDate').val(),
            "orgName": $('#orgName').val(),
            "hsCode": $('#hsCode').val(),
            "productName": $('#productName').val(),
            "sendReqCountryCode": $('#sendReqCountryCode').val(),*/
            "sendReqNum": $('#sendReqNum').val(),
            "reqDate": $('#reqDate').val(),
            "responseNum": $('#responseNum').val(),
            "responseDate": $('#responseDate').val(),
            "responseNumSendXbbNum": $('#responseNumSendXbbNum').val(),
            "responseNumSendXbbDate": $('#responseNumSendXbbDate').val(),
            "executiveTerritoryCode": resultExecuTerritoryCode,
            "distributed": resultDistributed,
            /*,
            "resultAnswerMailNum": $('#resultAnswerMailNum').val(),
            "resultAnswerMailDate": $('#resultAnswerMailDate').val(),
            "xbbVerdictNum": $('#xbbVerdictNum').val(),
            "xbbVerdictDate": $('#xbbVerdictDate').val(),
            "sum": $('#sum').val(),
            "comment": $('#comment').val()*/
            /******************************/
            "id": $('#interSurveyId2').val(),
            "status": $('#interSurveyStatus2').val()
        }
        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveIS2",
            dataType: "json",
            async: true,
            contentType: 'application/json',
            success: function (res) {
                $('#closeModalSave2').trigger('click');
                searchResultTableIS();
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Дастлабки маълумотлар сақланди',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (response) {
                if (typeof response.responseJSON.sendReqNum != "undefined" && response.responseJSON.sendReqNum != null && response.responseJSON.sendReqNum != "" && response.responseJSON.sendReqNum != "undefined") {
                    $('#sendReqNumValid').html(response.responseJSON.sendReqNum).addClass('text-danger mb-2');
                    $('#sendReqNum').addClass('border border-danger');
                } else {
                    $('#sendReqNum').removeClass('border border-danger');
                    $('#sendReqNumValid').html('');
                    $('#sendReqNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.reqDate != "undefined" && response.responseJSON.reqDate != null && response.responseJSON.reqDate != "" && response.responseJSON.reqDate != "undefined") {
                    $('#reqDateValid').html(response.responseJSON.reqDate).addClass('text-danger');
                    $('#reqDate').addClass('border border-danger');
                } else {
                    $('#reqDate').removeClass('border border-danger');
                    $('#reqDateValid').html('');
                    $('#reqDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseNum != "undefined" && response.responseJSON.responseNum != null && response.responseJSON.responseNum != "" && response.responseJSON.responseNum != "undefined") {
                    $('#responseNumValid').html(response.responseJSON.responseNum).addClass('text-danger');
                    $('#responseNum').addClass('border border-danger');
                } else {
                    $('#responseNum').removeClass('border border-danger');
                    $('#responseNumValid').html('');
                    $('#responseNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseDate != "undefined" && response.responseJSON.responseDate != null && response.responseJSON.responseDate != "" && response.responseJSON.responseDate != "undefined") {
                    $('#responseDateValid').html(response.responseJSON.responseDate).addClass('text-danger');
                    $('#responseDate').addClass('border border-danger');
                } else {
                    $('#responseDate').removeClass('border border-danger');
                    $('#responseDateValid').html('');
                    $('#responseDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseNumSendXbbNum != "undefined" && response.responseJSON.responseNumSendXbbNum != null && response.responseJSON.responseNumSendXbbNum != "" && response.responseJSON.responseNumSendXbbNum != "undefined") {
                    $('#responseNumSendXbbNumValid').html(response.responseJSON.responseNumSendXbbNum).addClass('text-danger');
                    $('#responseNumSendXbbNum').addClass('border border-danger');
                } else {
                    $('#responseNumSendXbbNum').removeClass('border border-danger');
                    $('#responseNumSendXbbNumValid').html('');
                    $('#responseNumSendXbbNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseNumSendXbbDate != "undefined" && response.responseJSON.responseNumSendXbbDate != null && response.responseJSON.responseNumSendXbbDate != "" && response.responseJSON.responseNumSendXbbDate != "undefined") {
                    $('#responseNumSendXbbDateValid').html(response.responseJSON.responseNumSendXbbDate).addClass('text-danger');
                    $('#responseNumSendXbbDate').addClass('border border-danger');
                } else {
                    $('#responseNumSendXbbDate').removeClass('border border-danger');
                    $('#responseNumSendXbbDateValid').html('');
                    $('#responseNumSendXbbDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.executiveTerritoryCode != "undefined" && response.responseJSON.executiveTerritoryCode != null && response.responseJSON.executiveTerritoryCode != "" && response.responseJSON.executiveTerritoryCode != "undefined") {
                    $('#executiveTerritoryCodeValid').html(response.responseJSON.executiveTerritoryCode).addClass('text-danger');
                    $('#executiveTerritoryCode').addClass('border border-danger');
                } else {
                    $('#executiveTerritoryCode').removeClass('border border-danger');
                    $('#executiveTerritoryCodeValid').html('');
                    $('#executiveTerritoryCode').addClass('border border-success');
                }
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Хатолик!',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }
    function saveValueFromInputSStep3() {
        var dataS = {
            /*"xbbMailNum": $('#xbbMailNum').val(),
            "xbbMailDate": $('#xbbMailDate').val(),
            "orgName": $('#orgName').val(),
            "hsCode": $('#hsCode').val(),
            "productName": $('#productName').val(),
            "sendReqCountryCode": $('#sendReqCountryCode').val(),
            "sendReqNum": $('#sendReqNum').val(),
            "reqDate": $('#reqDate').val(),
            "responseNum": $('#responseNum').val(),
            "responseDate": $('#responseDate').val(),
            "responseNumSendXbbNum": $('#responseNumSendXbbNum').val(),
            "responseNumSendXbbDate": $('#responseNumSendXbbDate').val(),*/
            "resultAnswerMailNum": $('#resultAnswerMailNum').val(),
            "resultAnswerMailDate": $('#resultAnswerMailDate').val(),
            "xbbVerdictNum": $('#xbbVerdictNum').val(),
            "xbbVerdictDate": $('#xbbVerdictDate').val(),
            "sum": $('#sum').val(),
            "sumАpproved": $('#sumАpproved').val(),
            "fabula": $('#fabula').val(),
            "comment": $('#comment').val(),
            /******************************/
            "id": $('#interSurveyId3').val(),
            "status": $('#interSurveyStatus3').val()
        }
        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveIS3",
            dataType: "json",
            async: true,
            contentType: 'application/json',
            success: function (res) {
                $('#closeModalSave3').trigger('click');
                searchResultTableIS();
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Дастлабки маълумотлар сақланди',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (response) {
                if (typeof response.responseJSON.resultAnswerMailNum != "undefined" && response.responseJSON.resultAnswerMailNum != null && response.responseJSON.resultAnswerMailNum != "" && response.responseJSON.resultAnswerMailNum != "undefined") {
                    $('#resultAnswerMailNumValid').html(response.responseJSON.resultAnswerMailNum).addClass('text-danger mb-2')
                    $('#resultAnswerMailNum').addClass('border border-danger')
                } else {
                    $('#resultAnswerMailNum').removeClass('border border-danger');
                    $('#resultAnswerMailNumValid').html('');
                    $('#resultAnswerMailNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.resultAnswerMailDate != "undefined" && response.responseJSON.resultAnswerMailDate != null && response.responseJSON.resultAnswerMailDate != "" && response.responseJSON.resultAnswerMailDate != "undefined") {
                    $('#resultAnswerMailDateValid').html(response.responseJSON.resultAnswerMailDate).addClass('text-danger mb-2')
                    $('#resultAnswerMailDate').addClass('border border-danger')
                } else {
                    $('#resultAnswerMailDate').removeClass('border border-danger');
                    $('#resultAnswerMailDateValid').html('');
                    $('#resultAnswerMailDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.xbbVerdictNum != "undefined" && response.responseJSON.xbbVerdictNum != null && response.responseJSON.xbbVerdictNum != "" && response.responseJSON.xbbVerdictNum != "undefined") {
                    $('#xbbVerdictNumValid').html(response.responseJSON.xbbVerdictNum).addClass('text-danger mb-2')
                    $('#xbbVerdictNum').addClass('border border-danger')
                } else {
                    $('#xbbVerdictNum').removeClass('border border-danger');
                    $('#xbbVerdictNumValid').html('');
                    $('#xbbVerdictNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.xbbVerdictDate != "undefined" && response.responseJSON.xbbVerdictDate != null && response.responseJSON.xbbVerdictDate != "" && response.responseJSON.xbbVerdictDate != "undefined") {
                    $('#xbbVerdictDateValid').html(response.responseJSON.xbbVerdictDate).addClass('text-danger mb-2')
                    $('#xbbVerdictDate').addClass('border border-danger')
                } else {
                    $('#xbbVerdictDate').removeClass('border border-danger');
                    $('#xbbVerdictDateValid').html('');
                    $('#xbbVerdictDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.sum != "undefined" && response.responseJSON.sum != null && response.responseJSON.sum != "" && response.responseJSON.sum != "undefined") {
                    $('#sumValid').html(response.responseJSON.sum).addClass('text-danger mb-2')
                    $('#sum').addClass('border border-danger')
                } else {
                    $('#sum').removeClass('border border-danger');
                    $('#sumValid').html('');
                    $('#sum').addClass('border border-success');
                }
                if (typeof response.responseJSON.sumАpproved != "undefined" && response.responseJSON.sumАpproved != null && response.responseJSON.sumАpproved != "" && response.responseJSON.sumАpproved != "undefined") {
                    $('#sumАpprovedValid').html(response.responseJSON.sumАpproved).addClass('text-danger');
                    $('#sumАpproved').addClass('border border-danger');
                } else {
                    $('#sumАpproved').removeClass('border border-danger');
                    $('#sumАpprovedValid').html('');
                    $('#sumАpproved').addClass('border border-success');
                }
                if (typeof response.responseJSON.comment != "undefined" && response.responseJSON.comment != null && response.responseJSON.comment != "" && response.responseJSON.comment != "undefined") {
                    $('#commentValid').html(response.responseJSON.comment).addClass('text-danger mb-2')
                    $('#comment').addClass('border border-danger')
                } else {
                    $('#comment').removeClass('border border-danger');
                    $('#commentValid').html('');
                    $('#comment').addClass('border border-success');
                }
                if (typeof response.responseJSON.fabula != "undefined" && response.responseJSON.fabula != null && response.responseJSON.fabula != "" && response.responseJSON.fabula != "undefined") {
                    $('#fabulaValid').html(response.responseJSON.fabula).addClass('text-danger mb-2')
                    $('#fabula').addClass('border border-danger')
                } else {
                    $('#fabula').removeClass('border border-danger');
                    $('#fabulaValid').html('');
                    $('#fabula').addClass('border border-success');
                }
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Хатолик!',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }
</script>
<%--<script src="<%=request.getContextPath()%>/resources/js/colResizable/colresizable/samples/rangeSlider.Demo2/js/jquery.js"></script>--%>
<%--<link href="<%=request.getContextPath()%>/resources/js/colResizable/colresizable/samples/rangeSlider.Demo2/css/main.css" rel="stylesheet">--%>
<%--<script src="<%=request.getContextPath()%>/resources/js/colResizable/colresizable/colResizable-1.6.min.js"></script>--%>
<%--<script>--%>
<%--    $(function(){--%>
<%--        $("#interSurveyTable").colResizable('{fixed:false,liveDrag:true}');--%>
<%--    });--%>
<%--</script>--%>
</body>