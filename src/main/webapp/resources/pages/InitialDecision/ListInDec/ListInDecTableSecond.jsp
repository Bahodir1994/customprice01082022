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
<style>
    .md-mobile-picker-header {
        font-size: 12px;
    }

    input.md-mobile-picker-input {
        color: initial;
        width: 100%;
        padding: 9px;
        margin: 0px 0 0px 0;
        border: 1px solid #ccc;

        font-family: arial, verdana, sans-serif;
        font-size: 12px;
        box-sizing: border-box;
        -webkit-appearance: none;
    }

    .md-mobile-picker-button.mbsc-button {
        font-size: 12px;
        padding: 0 5px;
        line-height: 20px;
        float: right;
        margin: 6px 0;
        width: 100%;
    }

    .mbsc-col-no-padding {
        padding-left: 0;
    }

    .md-mobile-picker-box-label.mbsc-textfield-wrapper-box,
    .md-mobile-picker-box-label .mbsc-textfield-wrapper-box,
    .md-mobile-picker-inline {
        margin: 6px 0 6px 0;
    }
</style>
<style>
    .pagination-outer {
        text-align: center;
    }

    .pagination {
        font-family: 'Poppins', sans-serif;
        display: inline-flex;
        position: relative;
    }

    .pagination li a.page-link {
        color: #0d75fe;
        background: #f5f5f5;
        font-size: 15px;
        font-weight: 333;
        line-height: 27px;
        height: 27px;
        width: 27px;
        padding: 0;
        margin: 0 5px;
        border: none;
        border-radius: 0;
        position: relative;
        z-index: 1;
        transition: all 0.3s ease 0s;
    }

    .pagination li a.page-link:hover,
    .pagination li a.page-link:focus,
    .pagination li.active a.page-link:hover,
    .pagination li.active a.page-link {
        color: #fff;
        background: transparent;
    }

    .pagination li a.page-link:before {
        content: '';
        background-color: #f5f5f5;
        height: 100%;
        width: 100%;
        position: absolute;
        left: 0;
        top: 0;
        z-index: -1;
        transition: all 0.3s ease 0s;
        clip-path: polygon(0 20%, 50% 20%, 100% 20%, 100% 80%, 50% 80%, 0 80%);
    }

    .pagination li a.page-link:hover:before,
    .pagination li a.page-link:focus:before,
    .pagination li.active a.page-link:hover:before,
    .pagination li.active a.page-link:before {
        background-color: #0d75fe;
        clip-path: polygon(0 20%, 50% 0, 100% 20%, 100% 80%, 50% 100%, 0 80%);
    }

    @media only screen and (max-width: 480px) {
        .pagination {
            font-size: 0;
            display: inline-block;
        }

        .pagination li {
            display: inline-block;
            vertical-align: top;
            margin: 10px 0;
        }
    }
</style>
<style>
    .optionGroup {
        /*font-weight: bold;*/
        font-style: italic;
        top: 5px!important;
        padding: 20px;
    }
    form {
        position: relative;
        width: 200px;
    }
    form input {
        width: 100%;
        padding-right: 20px;
        box-sizing: border-box;
        font-size: 13px!important;
        height: 37px!important;
    }

    form input:placeholder-shown+button {
        opacity: 0;
        pointer-events: none;
    }
    form button {
        position: absolute;
        border: 2px;
        border-color: #0d6efd;
        display: block;
        width: 15px;
        height: 15px;
        line-height: 16px;
        font-size: 12px;
        border-radius: 50%;
        top: 0;
        bottom: 0;
        right: 5px;
        margin: auto;
        background: #225e9e;
        padding: 0;
        outline: none;
        cursor: pointer;
        transition: .1s;
    }
</style>
<div class="fm-search">

    <div class="border border-top-0 border-start-0 border-end-0 border-primary">
        <div class="row align-items-center">
            <div class="col-md-1 m-2" id="viewElementNumber"></div>
            <div class="col-md-1 d-flex align-items-center badge rounded-pill text-success bg-light-success p-2 text-uppercase d-flex align-items-center px-3 numberApps h2"></div>
        </div>
    </div>
    <div class="table100 ver1 m-b-110 mt-3 table-responsive">
        <style>
            .table-fixed thead {
                width: 97%;
            }
            .table-fixed tbody {
                height: 230px;
                overflow-y: auto;
                width: 100%;
            }
            .table-fixed thead, .table-fixed tbody, .table-fixed tr, .table-fixed td, .table-fixed th {
                display: block;
            }
            .table-fixed tbody td, .table-fixed thead > tr> th {
                float: left;
                border-bottom-width: 0;
            }
        </style>
        <table id="records_table" class="table table-striped table-bordered table-responsive">
            <thead class="" style="">
            <tr class="row100 head">
                <th class="column0" data-column="column1">
                    Т/р
                </th>
                <th class="column100 column1" data-column="column1">
                    Ариза рақами
                    <input style="min-width: 250px!important;" class="form-control" id="appNum" type="number" placeholder="Киритинг.."  onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxSecond(0); return false;} "/>
                </th>
                <th class="column100 column2" data-column="column2">
                    Мақоми
                    <select style="min-width: 250px!important;" id="statusId" class="form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxSecond(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="stat" items="${statusGets}" varStatus="i">
                            <option class="optionGroup" value="${stat.id}">${stat.name}</option>
                        </c:forEach>
                    </select>
                </th>
                <th class="column100 column3" data-column="column3">
                    Ариза Санаси
                    <form>
                        <input id="demo-mobile-picker-input"  placeholder="Санани киритинг.." class="selector form-control" type="text"  value=""  data-input  onchange="ListInDecAppTAbleAjaxSecond(0)"/>
                        <button onclick="clearDate(0)" class="text-white" type="button">&times;</button>
                    </form>
                </th>
                <th class="column100 column5" data-column="column5">
                    Ариза юборилган ХББ
                    <select style="min-width: 250px!important;" id="locationId" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxSecond(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="locs" items="${locations}" varStatus="i">
                            <option value="${locs.id}">${locs.name1}</option>
                        </c:forEach>
                    </select>
                </th>
                <th class="column100 column4" data-column="column4">
                    Манфаатдор шахс
                    <input style="min-width: 250px!important;" id="personFIO" class="form-control" type="text" placeholder="Киритинг.."
                           onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxSecond(0); return false;} "/>
                </th>
                <th class="column100 column5" data-column="column5">
                    Савдо қилувчи
                    <select style="min-width: 250px!important;" id="sellerOrg" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxSecond(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="country" items="${countries}" varStatus="i">
                            <option value="${country.code}">${country.code} - ${country.cdNm}</option>
                        </c:forEach>
                    </select>
                </th>
                <th class="column100 column6" data-column="column6">
                    Ишлаб чиқарувчи
                    <select style="min-width: 250px!important;" id="orignOrg" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxSecond(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="country" items="${countries}" varStatus="i">
                            <option value="${country.code}">${country.code} - ${country.cdNm}</option>
                        </c:forEach>
                    </select>
                </th>
                <th class="column100 column7" data-column="column7">
                    Сотувчи мамлакат
                    <select style="min-width: 250px!important;" id="senderOrg" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxSecond(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="country" items="${countries}" varStatus="i">
                            <option value="${country.code}">${country.code} - ${country.cdNm}</option>
                        </c:forEach>
                    </select>
                </th>
                <th>
                    Кимга тақсимланган
                    <input style="min-width: 250px!important;" class="form-control" id="sortedInspector" type="text" placeholder="Киритинг.."  onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxSecond(0); return false;} "/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <input type="hidden" class="selectedBarValue" value="${selectedBar}"/>
    <div class="m-3 border border-start-0 border-end-0 border-bottom-0 border-primary" id="paginationTerit">
        <!--for Pagination-->
    </div>
</div>
<script>
    $(document).ready(function () {
        ListInDecAppTAbleAjaxSecond(0);
    });
    function ListInDecAppTAbleAjaxSecond(x) {
        let selectedBar = $('.selectedBarValue').val();
        selectedBarColor(selectedBar);
        if (selectedBar === 0 || selectedBar === "0" || selectedBar === ""){
            selectedBar = $('.selectedBarValue').val();
        }
        var dataS = {
            "status": $('#statusId').val(),
            "appDateStart": $('#demo-mobile-picker-input').val().substr(0, 10),
            "appDateEnd": $('#demo-mobile-picker-input').val().substr(14, 21),
            "appNum" : $('#appNum').val(),
            "locationId" : $('#locationId').val(),
            "personFio" : $('#personFIO').val(),
            "sellerOrg" : $('#sellerOrg').val(),
            "orignOrg" : $('#orignOrg').val(),
            "senderOrg" : $('#senderOrg').val(),
            "sortedInspector" : $('#sortedInspector').val(),
            "page": x,
            "size": $("#currentSizeItems").val(),
            "selectedBar": selectedBar
        }

        $.ajax({
            type: "POST",
            data: JSON.stringify(dataS),
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/ListInDec/ListInDecTableAJAX",
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
                $('tbody').html('')
                $('#paginationTerit').html('')
                $('#viewElementNumber').html('')
                $('.spanTotalItems').html('')
                $('.numberApps').html('')
                let trHTML = '', PageHtml = '', viewElements = '', totalItmesValue = '', versionNum = '';
                let indexing = (response.currentPage+1) * response.ItemsSize - response.ItemsSize + 1;
                var selectOpt;
                statisticsBar(response.barFirst, response.barSecond, response.barThird, response.barFourth, response.barFifth, response.barSixth,)
                if (typeof response.tutorials != 'undefined')
                {
                    response.tutorials.forEach(function (appeal, key) {
                        var indxx = document.getElementById('userIdF_'+indexing+'');
                        if (appeal[31] === null || appeal[31] === "null" || appeal[31] === "" || appeal[31] === undefined || appeal[31] === "undefined"){
                            versionNum = 1;
                        }else {
                            versionNum = appeal[31]
                        }
                        trHTML =
                            '<tr class="">' +
                            '<td class="column0 font-weight-bold text-center" data-column="">' + indexing + '</td>' +
                            '<td class="column1">' +
                            '<a type="button" class="btn btn-primary btn-sm radius-30 px-4"  href="#" onclick="InitialDecisionView('+"'"+appeal[0]+"'"+')" class="text-primary font-weight-bold"><u>'+ appeal[2]+"/"+versionNum+'</u></a>' +
                            '</td>' +
                            '<td class="column100 column2 text-center" data-column="column2">' +
                            '<div class="badge rounded-pill text-success bg-light-success p-2 text-uppercase px-3"><i class="bx bxs-circle me-1"></i>'+ appeal[25] +'</div>' +
                            '</td>' +
                            '<td class="column3 text-center" data-column="column3">' + appeal[29].substr(0, 10)+"  ("+appeal[29].substr(11, 8)+")"+ '</td>' +
                            '<td class="column4" data-column="column7">' + appeal[22] + '</td>' +
                            '<td class="column5" data-column="column8">' + appeal[13] + '</td>' +
                            '<td class="column6" data-column="column4">' + appeal[4] + "-" + appeal[5] +'</td>' +
                            '<td class="column7" data-column="column4">' + appeal[4] + "-" + appeal[5] +'</td>' +
                            '<td class="column8" data-column="column4">' + appeal[6] + "-" + appeal[7] +'</td>' +
                            '<td style="" class="column9" data-column="column5">'+ appeal[30] +'</td>' +
                            '</tr>';
                        $('#records_table').append(trHTML);
                        indexing ++;
                    });

                    let current_page = response.currentPage;
                    let total_items = "Жами: " +response.totalItems+ " та";
                    let totalPages = response.totalPages;
                    let aLeft = '', aRight = '', currentLeft = '', currentRight = '', havingEnd = '', havingStart = '', selected10 = '', selected30 = '', selected50 = '', selected100 = '', selectedAll = '';

                    if (current_page < 1) {
                        aLeft = '<a href="#" class="page-link" aria-label="Previous" style="cursor: not-allowed"><span aria-hidden="true">«</span></a>'
                    }
                    else{
                        aLeft = '<a href="#" class="page-link" aria-label="Previous" onclick="ListInDecAppTAbleAjaxSecond(0, '+(current_page-1)+')"><span aria-hidden="true">«</span></a>'
                    }
                    if (current_page < totalPages-1) {
                        aRight = '<a href="#" class="page-link" aria-label="Previous" onclick="ListInDecAppTAbleAjaxSecond(0, '+(current_page+1)+')"><span aria-hidden="true">»</span></a>'
                    }
                    else{
                        aRight = '<a href="#" class="page-link" aria-label="Previous" style="cursor: not-allowed"><span aria-hidden="true">»</span></a>'
                    }
                    if (current_page > 1) {
                        havingStart = '<li class="page-item"><a href="#" class="page-link" aria-label="Previous" ><span aria-hidden="true">...</span></a></li>'
                        currentLeft = '<li class="page-item"><a class="page-link" href="#">' + (current_page-1) + '</a>' +
                            '</li><li class="page-item"><a class="page-link" href="#">' + (current_page-0) + '</a></li>'
                    }
                    if (current_page < totalPages-2) {
                        havingEnd = '<li class="page-item"><a href="#" class="page-link" aria-label="Previous" ><span aria-hidden="true">...</span></a></li>'
                        currentRight = '<li class="page-item"><a class="page-link" href="#">' + (current_page+2) + '</a>' +
                            '</li><li class="page-item"><a class="page-link" href="#">' + (current_page+3) + '</a></li>'
                    }
                    if (response.ItemsSize === 10){
                        selected10 = 'selected="selected"';
                    }
                    if (response.ItemsSize === 30){
                        selected30 = 'selected="selected"';
                    }
                    if (response.ItemsSize === 50){
                        selected50 = 'selected="selected"';
                    }
                    if (response.ItemsSize === 100){
                        selected100 = 'selected="selected"';
                    }
                    if (response.ItemsSize === 100){
                        selectedAll = 'selected="selected"';
                    }

                    viewElements =
                    '<select type="number" id="currentSizeItems" onchange="ListInDecAppTAbleAjaxSecond(0)" class="form-select rounded">' +
                    '<option '+selected10+' class="m-2 text-dark" value="10">10 та</option>' +
                    '<option '+selected30+' class="m-2 text-dark" value="30">30 та</option>' +
                    '<option '+selected50+' class="m-2 text-dark" value="50">50 та</option>' +
                    '<option '+selected100+' class="m-2 text-dark" value="100">100 та</option>' +
                    '<option '+selected100+' class="m-2 text-dark" value="999999">Барчаси</option>' +
                    '</select>';
                    $('#viewElementNumber').append(viewElements);

                    PageHtml = '<div class="demo m-2">' +
                        '<nav class="pagination-outer" aria-label="Page navigation">' +
                        '<ul class="pagination">' +
                        '<li class="page-item mr-2">'+

                        '</li>'+
                        '<li class="page-item">' +
                        ''+ aLeft +'' +
                        '</li>' +
                        ''+havingStart+''+
                        ''+ currentLeft +'' +
                        '<li class="page-item active"><a class="page-link" href="#">' + (current_page+1) + '</a></li>' +
                        ''+ currentRight +'' +
                        ''+havingEnd+''+
                        '<li class="page-item">' +
                        ''+ aRight +'' +
                        '</li>' +
                        '<li class="page-item m-1">'+
                        '</li>'+
                        '</ul>' +
                        '</nav>' +
                        '</div>';
                    $('#paginationTerit').append(PageHtml);
                    totalItmesValue = '<span class="text-center text-dark">'+total_items+'</span>';
                    $('.numberApps').append(totalItmesValue)
                }
                if (typeof response.tutorials == 'undefined' || response.tutorials == '' || response.tutorials == 'empty'){
                    trHTML = '<tr class="">' +
                        '<td colspan="11" class="column0 font-weight-bold text-center" data-column="">Маълумотлар топилмади</td>' +
                        '</tr>';
                    $('#records_table').append(trHTML);
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
    }
</script>
<script>
    $(".selector").flatpickr();
    flatpickr('.selector', {
        "mode": "range",
        locale: {
            rangeSeparator: '/--/',
            firstDayOfWeek: 1,
            weekdays: {
                shorthand: ['Як', 'Душ', 'Сеш', 'Чор', 'Пай', 'Жум', 'Шан'],
                longhand: ['Якшанба', 'Душанба', 'Сешанба', 'Чоршанба', 'Пайшанба', 'Жума', 'Шанба'],
            },
            months: {
                shorthand: ['Янв', 'Фев', 'Март', 'Апр', 'Май', 'Июнь', 'Июль', 'Авг', 'Сен', 'Окт', 'Ноя', 'Дек'],
                longhand: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
            },
        },
    });
    function clearDate(x){
        $('#demo-mobile-picker-input').val('');
        ListInDecAppTAbleAjaxSecond(0)
    }
</script>
<script src="<%=request.getContextPath()%>/resources/js/swalSweetalert.js"></script>
</body>
</html>