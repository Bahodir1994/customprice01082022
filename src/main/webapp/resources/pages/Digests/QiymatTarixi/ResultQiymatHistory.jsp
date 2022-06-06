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

<div class="panel panel-primary filterable table-responsive">
    <table class="table align-middle mb-0 table-striped shadow-sm" style="border-style: dotted; border-width: 0.2px">
        <thead class="table-light">
        <tr class="bg-white text-dark">
            <th style="text-align: center;" class="">т/р</th>
            <th style="text-align: center;" class=""><i class="bx bx-edit"></i>Номер ГТД</th>
            <th style="text-align: center;" class="">Дата</th>
            <th style="text-align: center;" class="">ИНН</th>
            <th style="text-align: center;" class="">Режим</th>
            <th style="text-align: center;" class="">Номер предшествующего документа</th>
            <th style="text-align: center;" class="">Другие документы с данным предшествующем документом</th>
            <th style="text-align: center;" class="" colspan="5">БЮД тарихи</th>
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
                left: 20%; top: 30%; /* Положение подсказки */
                z-index: 1; /* Отображаем подсказку поверх других элементов */
                background: rgb(9, 9, 9); /* Полупрозрачный цвет фона */
                font-family: Arial, sans-serif; /* Гарнитура шрифта */
                font-size: 11px; /* Размер текста подсказки */
                color: #f8f9fe!important;
                padding: 5px 10px; /* Поля */
                border: 1px solid #333; /* Параметры рамки */
                border-radius: 30px;
            }
        </style>
        <tbody class="">
            <tr>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">фффф</td>
                <td style="text-align: center;">
                    <table>
                        <thead class="table-light">
                        <tr class="bg-white text-dark">
                            <th style="text-align: center;" class=""><i class="bx bx-edit"></i>Номер ГТД</th>
                            <th style="text-align: center;" class="">Дата</th>
                            <th style="text-align: center;" class="">ИНН</th>
                            <th style="text-align: center;" class="">Статус</th>
                            <th style="text-align: center;" class="">Режим</th>
                            <th style="text-align: center;" class="" colspan="3">БЮД тарихи</th>
                        </tr>
                        </thead>
                        <tbody class="">
                        <tr>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                            <td style="text-align: center;">цкцйкцйк</td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="no-result text-center" style="text-align: center" colspan="5">Маълумотлар топилмади!</td>
                <td class="no-result text-center" style="text-align: center" colspan="5">Маълумотлар топилмади!</td>

            </tr>
        </tbody>
    </table>
</div>
<div class="row mt-1">
    <div class="col-md-5 align-middle">
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + tutorials.size()) > 1}">
            <p class="text-primary mt-4">
                ${(currentPage+1) * getPageSize - getPageSize + 1} дан
                ${((currentPage+1) * getPageSize - getPageSize + tutorials.size())} гача;
                Жами:${totalItems} та маълумот
            </p>
        </c:if>
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + tutorials.size()) <= 0}">
            <span class="text-primary h5 mt-4">Маълумотлар топилмади!</span>
        </c:if>
    </div>
    <div class="col-md-7">
        <nav class="" aria-label="Page navigation example">
            <ul class="pagination">
                <c:if test="${currentPage > 1}">
                    <li class="page-item"><a class="page-link" href="#" onclick="searchResultTableIS('${0}',event)">Дастлабки</a></li>
                </c:if>
                <c:if test="${currentPage <= 1}">
                    <li class="page-item"><a class="page-link" href="#" disabled="disabled" style="cursor: not-allowed">Дастлабки</a></li>
                </c:if>
                <c:if test="${currentPage > 0}">
                    <li class="page-item"><a class="page-link" href="#" onclick="searchResultTableIS('${currentPage-1}',event)"><i class="bx bxs-chevron-left"></i></a></li>
                </c:if>
                <c:if test="${currentPage <= 0}">
                    <li class="page-item"><a class="page-link" disabled="disabled" href="#" onclick="${currentPage-1}, event" style="cursor: not-allowed"><i class="bx bxs-chevron-left"></i></a></li>
                </c:if>
                <%--                    <li class="page-item"><a class="page-link" href="#">...</a></li>--%>
                <%--                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
                <li class="page-item"><a class="page-link text-dark" href="#">${currentPage+1}</a></li>
                <%--                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                <%--                    <li class="page-item"><a class="page-link" href="#">...</a></li>--%>
                <c:if test="${currentPage < (totalPages-1)}">
                    <li class="page-item"><a class="page-link" href="#"  onclick="searchResultTableIS('${currentPage+1}',event)"><i class="bx bxs-chevron-right"></i></a></li>
                </c:if>
                <c:if test="${currentPage == (totalPages-1)}">
                    <li class="page-item"><a class="page-link" disabled="disabled" href="#" onclick="${currentPage+1}" style="cursor: not-allowed"><i class="bx bxs-chevron-right"></i></a></li>
                </c:if>
                <c:if test="${currentPage < (totalPages-2)}">
                    <li class="page-item"><a class="page-link" href="#" onclick="searchResultTableIS('${totalPages-1}', event)">Охирги</a></li>
                </c:if>
                <c:if test="${currentPage >= (totalPages-2)}">
                    <li class="page-item"><a class="page-link" href="#" disabled="disabled" style="cursor: not-allowed">Охирги</a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
<script>
    function saveValueFromInputSStep2(e=null) {

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
            "responseNumSendXbbDate": $('#responseNumSendXbbDate').val(),/*,
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
                }else {
                    $('#sendReqNum').removeClass('border border-danger');
                    $('#sendReqNumValid').html('');
                    $('#sendReqNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.reqDate != "undefined" && response.responseJSON.reqDate != null && response.responseJSON.reqDate != "" && response.responseJSON.reqDate != "undefined") {
                    $('#reqDateValid').html(response.responseJSON.reqDate).addClass('text-danger');
                    $('#reqDate').addClass('border border-danger');
                }else {
                    $('#reqDate').removeClass('border border-danger');
                    $('#reqDateValid').html('');
                    $('#reqDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseNum != "undefined" && response.responseJSON.responseNum != null && response.responseJSON.responseNum != "" && response.responseJSON.responseNum != "undefined") {
                    $('#responseNumValid').html(response.responseJSON.responseNum).addClass('text-danger');
                    $('#responseNum').addClass('border border-danger');
                }else {
                    $('#responseNum').removeClass('border border-danger');
                    $('#responseNumValid').html('');
                    $('#responseNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseDate != "undefined" && response.responseJSON.responseDate != null && response.responseJSON.responseDate != "" && response.responseJSON.responseDate != "undefined") {
                    $('#responseDateValid').html(response.responseJSON.responseDate).addClass('text-danger');
                    $('#responseDate').addClass('border border-danger');
                }else {
                    $('#responseDate').removeClass('border border-danger');
                    $('#responseDateValid').html('');
                    $('#responseDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseNumSendXbbNum != "undefined" && response.responseJSON.responseNumSendXbbNum != null && response.responseJSON.responseNumSendXbbNum != "" && response.responseJSON.responseNumSendXbbNum != "undefined") {
                    $('#responseNumSendXbbNumValid').html(response.responseJSON.responseNumSendXbbNum).addClass('text-danger');
                    $('#responseNumSendXbbNum').addClass('border border-danger');
                }else {
                    $('#responseNumSendXbbNum').removeClass('border border-danger');
                    $('#responseNumSendXbbNumValid').html('');
                    $('#responseNumSendXbbNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.responseNumSendXbbDate != "undefined" && response.responseJSON.responseNumSendXbbDate != null && response.responseJSON.responseNumSendXbbDate != "" && response.responseJSON.responseNumSendXbbDate != "undefined") {
                    $('#responseNumSendXbbDateValid').html(response.responseJSON.responseNumSendXbbDate).addClass('text-danger');
                    $('#responseNumSendXbbDate').addClass('border border-danger');
                }else {
                    $('#responseNumSendXbbDate').removeClass('border border-danger');
                    $('#responseNumSendXbbDateValid').html('');
                    $('#responseNumSendXbbDate').addClass('border border-success');
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
                }else {
                    $('#resultAnswerMailNum').removeClass('border border-danger');
                    $('#resultAnswerMailNumValid').html('');
                    $('#resultAnswerMailNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.resultAnswerMailDate != "undefined" && response.responseJSON.resultAnswerMailDate != null && response.responseJSON.resultAnswerMailDate != "" && response.responseJSON.resultAnswerMailDate != "undefined") {
                    $('#resultAnswerMailDateValid').html(response.responseJSON.resultAnswerMailDate).addClass('text-danger mb-2')
                    $('#resultAnswerMailDate').addClass('border border-danger')
                }else {
                    $('#resultAnswerMailDate').removeClass('border border-danger');
                    $('#resultAnswerMailDateValid').html('');
                    $('#resultAnswerMailDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.xbbVerdictNum != "undefined" && response.responseJSON.xbbVerdictNum != null && response.responseJSON.xbbVerdictNum != "" && response.responseJSON.xbbVerdictNum != "undefined") {
                    $('#xbbVerdictNumValid').html(response.responseJSON.xbbVerdictNum).addClass('text-danger mb-2')
                    $('#xbbVerdictNum').addClass('border border-danger')
                }else {
                    $('#xbbVerdictNum').removeClass('border border-danger');
                    $('#xbbVerdictNumValid').html('');
                    $('#xbbVerdictNum').addClass('border border-success');
                }
                if (typeof response.responseJSON.xbbVerdictDate != "undefined" && response.responseJSON.xbbVerdictDate != null && response.responseJSON.xbbVerdictDate != "" && response.responseJSON.xbbVerdictDate != "undefined") {
                    $('#xbbVerdictDateValid').html(response.responseJSON.xbbVerdictDate).addClass('text-danger mb-2')
                    $('#xbbVerdictDate').addClass('border border-danger')
                }else {
                    $('#xbbVerdictDate').removeClass('border border-danger');
                    $('#xbbVerdictDateValid').html('');
                    $('#xbbVerdictDate').addClass('border border-success');
                }
                if (typeof response.responseJSON.sum != "undefined" && response.responseJSON.sum != null && response.responseJSON.sum != "" && response.responseJSON.sum != "undefined") {
                    $('#sumValid').html(response.responseJSON.sum).addClass('text-danger mb-2')
                    $('#sum').addClass('border border-danger')
                }else {
                    $('#sum').removeClass('border border-danger');
                    $('#sumValid').html('');
                    $('#sum').addClass('border border-success');
                }
                if (typeof response.responseJSON.comment != "undefined" && response.responseJSON.comment != null && response.responseJSON.comment != "" && response.responseJSON.comment != "undefined") {
                    $('#commentValid').html(response.responseJSON.comment).addClass('text-danger mb-2')
                    $('#comment').addClass('border border-danger')
                }else {
                    $('#comment').removeClass('border border-danger');
                    $('#commentValid').html('');
                    $('#comment').addClass('border border-success');
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
</body>