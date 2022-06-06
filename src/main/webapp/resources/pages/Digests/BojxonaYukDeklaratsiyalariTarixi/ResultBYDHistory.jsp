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

<div class="">
    <table class="table align-middle mb-0 shadow-sm table-bordered" style="border-style: dotted; border-width: 0.2px">
        <thead class="table-light">
        <tr class="bg-white text-dark">
            <th style="text-align: center;" class="" colspan="3">БЮД рақами</th>
            <th style="text-align: center;" class="" colspan="2">Режим</th>
            <th style="text-align: center;" class="">СТИР</th>
            <th style="text-align: center;" class="" colspan="3">Аввалги хужжат</th>
            <th style="text-align: center;" class="" colspan="5">Аввалги ҳужжат бўйича бошқа ҳужжатлар (БЮД ЮЕБНК)</th>
        </tr>
        </thead>
        <style>
            .table-responsive-stack tr {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-orient: horizontal;
                -webkit-box-direction: normal;
                -ms-flex-direction: row;
                flex-direction: row;
            }


            .table-responsive-stack td,
            .table-responsive-stack th {
                display: block;
                /*
                   flex-grow | flex-shrink | flex-basis   */
                -ms-flex: 1 1 auto;
                flex: 1 1 auto;
            }

            .table-responsive-stack .table-responsive-stack-thead {
                font-weight: bold;
            }

            @media screen and (max-width: 768px) {
                .table-responsive-stack tr {
                    -webkit-box-orient: vertical;
                    -webkit-box-direction: normal;
                    -ms-flex-direction: column;
                    flex-direction: column;
                    border-bottom: 3px solid #ccc;
                    display: block;

                }

                /*  IE9 FIX   */
                .table-responsive-stack td {
                    float: left \9;
                    width: 100%;
                }
            }

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
        <c:forEach var="declList" items="${declList}" varStatus="i">
            <tr>
                <td style="text-align: center;">${declList[0]}</td>
                <td style="text-align: center;">${declList[1]}</td>
                <td style="text-align: center;">${declList[2]}</td>
                <td style="text-align: center;">${declList[3]}</td>
                <td style="text-align: center;">${declList[4]}</td>
                <td style="text-align: center;">${declList[5]}</td>
                <td style="text-align: center;">${declList[7]}</td>
                <td style="text-align: center;">${declList[8]}</td>
                <td style="text-align: center;">${declList[9]}</td>
                <td style="text-align: center;">
                    <table class="table table-bordered">
                        <thead class="table-light">
                        <tr class="bg-white text-dark">
                            <th style="text-align: center;" class="">т/р</th>
                            <th style="text-align: center;" class="" colspan="3">БЮД рақами</th>
                            <th style="text-align: center;" class="" colspan="2">Режим</th>
                            <th style="text-align: center;" class="">СТИР</th>
                            <th style="text-align: center;" class="">Мақоми</th>
                            <th style="text-align: center;" class="">Сана ва вақти</th>
                            <th style="text-align: center;" class="">Бекор қилиш сабаби ва<br> (ёки)мантиқий назоратлар
                                бўйича огохлантиришлар
                            </th>
                        </tr>
                        </thead>
                        <tbody class="">
                        <c:forEach var="declDetailsList" items="${declDetailsList}" varStatus="i">
                            <tr>
                                <td style="text-align: center;">${i.index+1}</td>
                                <td style="text-align: center;">${declDetailsList[1]}</td>
                                <td style="text-align: center;">${declDetailsList[2]}</td>
                                <td style="text-align: center;">${declDetailsList[3]}</td>
                                <td style="text-align: center;">${declDetailsList[4]}</td>
                                <td style="text-align: center;">${declDetailsList[5]}</td>
                                <td style="text-align: center;">${declDetailsList[6]}</td>
                                <td style="text-align: center;">${declDetailsList[7]}</td>
                                <td style="text-align: center;">${declDetailsList[9]}</td>
                                <td style="text-align: center;">${declDetailsList[0]}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${declDetailsList == null}">
            <tr>
                <td class="no-result text-center" style="text-align: center" colspan="12">Маълумотлар топилмади!</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script>
    function saveValueFromInputSStep2(e = null) {
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
                if (typeof response.responseJSON.comment != "undefined" && response.responseJSON.comment != null && response.responseJSON.comment != "" && response.responseJSON.comment != "undefined") {
                    $('#commentValid').html(response.responseJSON.comment).addClass('text-danger mb-2')
                    $('#comment').addClass('border border-danger')
                } else {
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

    $(document).ready(function () {
        // inspired by http://jsfiddle.net/arunpjohny/564Lxosz/1/
        $('.table-responsive-stack').each(function (i) {
            var id = $(this).attr('id');
            //alert(id);
            $(this).find("th").each(function (i) {
                $('#' + id + ' td:nth-child(' + (i + 1) + ')').prepend('<span class="table-responsive-stack-thead">' + $(this).text() + ':</span> ');
                $('.table-responsive-stack-thead').hide();
            });
        });
        $('.table-responsive-stack').each(function () {
            var thCount = $(this).find("th").length;
            var rowGrow = 100 / thCount + '%';
            //console.log(rowGrow);
            $(this).find("th, td").css('flex-basis', rowGrow);
        });

        function flexTable() {
            if ($(window).width() < 768) {

                $(".table-responsive-stack").each(function (i) {
                    $(this).find(".table-responsive-stack-thead").show();
                    $(this).find('thead').hide();
                });


                // window is less than 768px
            } else {


                $(".table-responsive-stack").each(function (i) {
                    $(this).find(".table-responsive-stack-thead").hide();
                    $(this).find('thead').show();
                });
            }
// flextable
        }

        flexTable();
        window.onresize = function (event) {
            flexTable();
        };
// document ready
    });

</script>
</body>