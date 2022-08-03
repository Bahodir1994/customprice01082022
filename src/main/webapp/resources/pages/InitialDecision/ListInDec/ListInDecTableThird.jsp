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
        <table id="records_table" class="table table-striped table-bordered table-responsive">
            <thead class="" style="border-style: dotted">
            <tr class="row100 head">
                <th class="column0" data-column="column1">
                    Т/р
                </th>
                <th class="column100 column1" data-column="column1">
                    Ариза рақами
                    <input style="min-width: 250px!important;" class="form-control" id="appNum" type="number" placeholder="Киритинг.."  onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxThird(0); return false;} "/>
                </th>
                <th class="column100 column2" data-column="column2">
                    Мақоми
                    <select style="min-width: 250px!important;" id="statusId" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxThird(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="stat" items="${statusGets}" varStatus="i">
                        <option value="${stat.id}">${stat.name}</option>
                        </c:forEach>
                    </select>
                </th>
                <th class="column100 column2" data-column="column2">
                    Тўлов холати
                    <select style="min-width: 150px!important;" id="paymentStatus" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxThird(0)">
                        <option value="">--Танланг--</option>
                        <option value="185" class="text-success">Ундирилган</option>
                        <option value="180" class="text-danger">Ундирилмаган</option>
                    </select>
                </th>
                <th class="column100 column3" data-column="column3">
                    Ариза Санаси
                    <form>
                        <input  id="demo-mobile-picker-input"  placeholder="Санани киритинг.." class="selector form-control" type="text"  value=""  data-input  onchange="ListInDecAppTAbleAjaxThird(0)"/>
                        <button onclick="clearDate(0)" class="text-white" type="button">&times;</button>
                    </form>
                </th>
                <th class="column100 column5" data-column="column5">
                    Ариза юборилган ХББ
                    <select style="min-width: 250px!important;" id="locationId" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxThird(0)">
                        <option value="">--Танланг--</option>
                        <c:forEach var="locs" items="${locations}" varStatus="i">
                            <button class="btn btn-outline-primary"><option value="${locs.id}">${locs.name1}</option></button>
                        </c:forEach>
                    </select>
                </th>
                <th class="column100 column5" data-column="column5">
                    Хужжат (Pdf)
                </th>
                <th class="column100 column4" data-column="column4">
                    Манфаатдор шахс
                    <input style="min-width: 250px!important;" id="personFIO" class="form-control" type="text" placeholder="Киритинг.."
                           onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxThird(0); return false;} "/>
                </th>
                <th class="column100 column5" data-column="column5">
                    Қарор рақами
                    <input style="min-width: 200px!important;" class="form-control" id="inDecNum" type="number" placeholder="Киритинг.."  onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxThird(0); return false;} "/>
                </th>
                <th class="column100 column3" data-column="column3">
                    Қарор Санаси
                    <form>
                        <input id="demo-mobile-picker-input2"  placeholder="Санани киритинг.." class="selector form-control" type="text"  value=""  data-input  onchange="ListInDecAppTAbleAjaxThird(0)"/>
                        <button onclick="clearDate(2)" class="text-white" type="button">&times;</button>
                    </form>
                </th>
                <th class="column100 column6" data-column="column6">
                    Етказиб бериш шарти
                    <select style="min-width: 150px!important;" id="termsNm" class="form-control form-select" type="text" placeholder="Киритинг.." onchange="ListInDecAppTAbleAjaxThird(0)">
                        <option value="">--Танланг--</option>
                        <option value="EXW">EXW</option>
                        <option value="FCA">FCA</option>
                        <option value="FAS">FAS</option>
                        <option value="FOB">FOB</option>
                        <option value="CFR">CFR</option>
                        <option value="CIF">CIF</option>
                        <option value="CPT">CPT</option>
                        <option value="CIP">CIP</option>
                        <option value="DAF">DAF</option>
                        <option value="DES">DES</option>
                        <option value="DEQ">DEQ</option>
                        <option value="DDU">DDU</option>
                        <option value="DDP">DDP</option>
                        <option value="DAР">DAР</option>
                        <option value="DAT">DAT</option>
                        <option value="***">***</option>
<%--                        <c:forEach var="country" items="${countries}" varStatus="i">--%>
<%--                            <option value="${country.code}">${country.code} - ${country.cdNm}</option>--%>
<%--                        </c:forEach>--%>
                    </select>
                </th>
                <th class="column100 column7" data-column="column7">
                    Амал қилиш муддати
                    <form>
                        <input id="demo-mobile-picker-input3"  placeholder="Санани киритинг.." class="selector form-control" type="text"  value=""  data-input  onchange="ListInDecAppTAbleAjaxThird(0)"/>
                        <button onclick="clearDate(3)" class="text-white" type="button">&times;</button>
                    </form>
                </th>
                <th class="column100 column7 text-center" data-column="column7">
                    Бекор қилиш
                </th>
                <th>
                    Инспектор
                    <input style="min-width: 250px!important;" class="form-control" id="sortedInspector" type="text" placeholder="Киритинг.."  onkeypress="if (event.keyCode == 13) {ListInDecAppTAbleAjaxThird(0); return false;} "/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <input type="hidden" id="inDecId" name="inDecId"/>
        <div class="col">
            <!-- Modal Pay -->
            <div class="modal fade" id="exampleModalPAY" tabindex="-1" aria-labelledby="exampleModalLabel11"
                 style="display: none;" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel11">Тўлдирилган БКО рақами ва санаси</h5>
                            <button id="btnCloseModalTPO" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="input-group mb-4">
                                <input id="g3a" type="number" size="5" maxlength="5" class="form-control" placeholder="Пост коди">
                                <span class="input-group-text">/</span>
                                <input id="g3b" type="date" class="form-control" placeholder="БКО тўлдирилган санаси">
                                <span class="input-group-text">/</span>
                                <input id="g3c" type="number" class="form-control" placeholder="БКО рақами">
                            </div>
                            <div id="g3aValid"></div>
                            <div id="g3bValid"></div>
                            <div id="g3cValid"></div>
                            <div id="validTPODiv" class=""></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ёпиш</button>
                            <button type="button" class="btn btn-primary" onclick="SaveTPO()">Сақлаш</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" class="selectedBarValue" value="${selectedBar}"/>
    <div class="m-3 border border-start-0 border-end-0 border-bottom-0 border-primary" id="paginationTerit">
        <!--for Pagination-->
    </div>
</div>
<script>
    var x, i, j, l, ll, selElmnt, a, b, c;
    x = document.getElementsByClassName("custom-select");
    l = x.length;
    for (i = 0; i < l; i++) {
        selElmnt = x[i].getElementsByTagName("select")[0];
        ll = selElmnt.length;
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("DIV");
        a.setAttribute("class", "select-selected");
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 1; j < ll; j++) {
            /*for each option in the original select element,
            create a new DIV that will act as an option item:*/
            c = document.createElement("DIV");
            c.innerHTML = selElmnt.options[j].innerHTML;
            c.addEventListener("click", function(e) {
                /*when an item is clicked, update the original select box,
                and the selected item:*/
                var y, i, k, s, h, sl, yl;
                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                sl = s.length;
                h = this.parentNode.previousSibling;
                for (i = 0; i < sl; i++) {
                    if (s.options[i].innerHTML == this.innerHTML) {
                        s.selectedIndex = i;
                        h.innerHTML = this.innerHTML;
                        y = this.parentNode.getElementsByClassName("same-as-selected");
                        yl = y.length;
                        for (k = 0; k < yl; k++) {
                            y[k].removeAttribute("class");
                        }
                        this.setAttribute("class", "same-as-selected");
                        break;
                    }
                }
                h.click();
            });
            b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function(e) {
            /*when the select box is clicked, close any other select boxes,
            and open/close the current select box:*/
            e.stopPropagation();
            closeAllSelect(this);
            this.nextSibling.classList.toggle("select-hide");
            this.classList.toggle("select-arrow-active");
        });
    }
    function closeAllSelect(elmnt) {
        /*a function that will close all select boxes in the document,
        except the current select box:*/
        var x, y, i, xl, yl, arrNo = [];
        x = document.getElementsByClassName("select-items");
        y = document.getElementsByClassName("select-selected");
        xl = x.length;
        yl = y.length;
        for (i = 0; i < yl; i++) {
            if (elmnt == y[i]) {
                arrNo.push(i)
            } else {
                y[i].classList.remove("select-arrow-active");
            }
        }
        for (i = 0; i < xl; i++) {
            if (arrNo.indexOf(i)) {
                x[i].classList.add("select-hide");
            }
        }
    }
    document.addEventListener("click", closeAllSelect);
    $(document).ready(function () {
        ListInDecAppTAbleAjaxThird(0);
    });
    function ListInDecAppTAbleAjaxThird(x) {
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
            "statusPay" : $('#paymentStatus').val(),
            "inDecNum" : $('#inDecNum').val(),
            "inDecStarts" : $('#demo-mobile-picker-input2').val().substr(0, 10),
            "inDecEnds" : $('#demo-mobile-picker-input2').val().substr(14, 21),
            "termsNm" : $('#termsNm').val().toString(),
            "inDecEndDateStarts" : $('#demo-mobile-picker-input3').val().substr(0, 10),
            "inDecEndDateEnds" : $('#demo-mobile-picker-input3').val().substr(0, 10),
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
                let trHTML = '', PageHtml = '', viewElements = '', totalItmesValue = '';
                let indexing = (response.currentPage+1) * response.ItemsSize - response.ItemsSize + 1;
                var selectOpt;
                statisticsBar(response.barFirst, response.barSecond, response.barThird, response.barFourth, response.barFifth, response.barSixth,)
                if (typeof response.tutorials != 'undefined')
                {
                    response.tutorials.forEach(function (appeal, key) {
                        let paymentStatus = '', rolled = '', versionNum = '';
                        if (appeal[52] === 180){
                            if (response.userRole === 8 ) {
                                paymentStatus = '' +
                                    '<a data-bs-toggle="modal" class="btn btn-outline-danger" onclick="' + $('#inDecId').val('' + appeal[31] + '') + '" data-bs-target="#exampleModalPAY">' + appeal[53] + '</a>';
                            }
                            if (response.userRole !== 8 ) {
                                paymentStatus = '' +
                                    '<a data-bs-toggle="modal" class="btn btn-outline-danger disabled" onclick="' + $('#inDecId').val('' + appeal[31] + '') + '" data-bs-target="#exampleModalPAY">' + appeal[53] + '</a>';
                            }
                        }
                        if (appeal[52] === 185){
                            paymentStatus = '<a class="btn btn-outline-success" onclick="resultTPO('+"'"+appeal[58]+"'"+', '+"'"+appeal[59]+"'"+', '+"'"+appeal[60]+"'"+')">'+ appeal[53] +'</a>';
                        }
                        if (appeal[57] === 100 && response.userRole === 3){
                            rolled = '<button class="btn btn-outline-primary" onclick="inDecCancelled('+appeal[31]+')"><i class="bx bx-message-alt-x bx-sm"></i></button>';
                        }
                        if (appeal[57] === 100 && response.userRole === 3){
                            rolled = '<td class="column8" data-column="column4"><button class="btn btn-outline-primary" onclick="inDecCancelled('+"'"+appeal[31]+"'"+')"><i class="bx bx-message-alt-x bx-sm"></i></button></td>';
                        }
                        if (appeal[57] === 100 && response.userRole !== 3){
                            rolled = '<td><button class="btn btn-outline-success">Амалда</button></td>';
                        }
                        if (appeal[57] === 200){
                            rolled = '<td class="column8" data-column="column4"><button class="btn btn-danger" onclick="resultCenceled('+"'"+appeal[56]+"'"+')">Бекор қилинган</button></td>';
                        }
                        if (appeal[64] === null || appeal[64] === "null" || appeal[64] === "" || appeal[64] === undefined || appeal[64] === "undefined"){
                            versionNum = 1;
                        }else {
                            versionNum = appeal[64]
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
                            '<td>'+paymentStatus+'</td>'+
                            '<td class="column3 text-center" data-column="column3">' + appeal[29].substr(0, 10)+ '</td>' +
                            '<td class="column4 text-center" data-column="column7">' + appeal[22] + '</td>' +
                            '<td class="column5 text-center" data-column="column8">' +
                            '<a type="button" onclick="openInDecPdf('+"'"+appeal[63]+"'"+')" class="btn btn-outline-warning">' +
                            '<i class="bx bxs-file-pdf" style="font-size: 30px"></i>' +
                            '</a>' +
                            '</td>' +
                            '<td class="column6 text-center" data-column="column4">' + appeal[13] + '</td>' +
                            '<td class="column7 text-center" data-column="column4">' + appeal[46]+"/"+appeal[65]+'</td>' +
                            '<td class="column8 text-center" data-column="column4">' + appeal[43].substr(0, 10) +'</td>' +
                            '<td class="column8 text-center" data-column="column4">' + appeal[11] +'</td>' +
                            '<td class="column8 text-center" data-column="column4">' + appeal[54] +'</td>' +
                            ''+rolled+''+
                            '<td style="" class="column9 text-center" data-column="column5">'+ appeal[30] +'</td>' +
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
                        aLeft = '<a href="#" class="page-link" aria-label="Previous" onclick="ListInDecAppTAbleAjaxThird(0, '+(current_page-1)+')"><span aria-hidden="true">«</span></a>'
                    }
                    if (current_page < totalPages-1) {
                        aRight = '<a href="#" class="page-link" aria-label="Previous" onclick="ListInDecAppTAbleAjaxThird(0, '+(current_page+1)+')"><span aria-hidden="true">»</span></a>'
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
                    '<select type="number" id="currentSizeItems" onchange="ListInDecAppTAbleAjaxThird(0)" class="form-select rounded">' +
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
                        '<td colspan="14" class="column0 font-weight-bold text-center" data-column="">Маълумотлар топилмади</td>' +
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
    function clearDate(y){
        var x = y;
        if (x === 0){
            $('#demo-mobile-picker-input').val('');
        }
        if (x === 2){
            $('#demo-mobile-picker-input2').val('');
        }
        if (x === 3){
            $('#demo-mobile-picker-input3').val('');
        }
        ListInDecAppTAbleAjaxThird(0)
    }
    function SaveTPO() {
        var log_f = true;
        var log_n = '';
        var arr = [];

        if ($('#g3a').val() == null || $('#g3a').val() == '') {
            $('#g3aValid').html('Пост кодини киритинг!').addClass('text-danger');
            $('#g3a').addClass('border border-danger')
            log_f = false;
        } else if ($.trim($('#g3a').val()).length > 5 || $.trim($('#g3a').val()).length < 5) {
            $('#g3aValid').html('Пост коди 5 та сондан иборат бўлиши лозим!').addClass('text-danger');
            $('#g3a').addClass('border border-danger')
            log_f = false;
        } else {
            $('#g3a').removeClass('border border-danger');
            $('#g3a').addClass('border border-success');
            $('#g3aValid').html('');
        }

        if ($('#g3b').val() == null || $('#g3b').val() == '') {
            $('#g3bValid').html('Санани киритинг!').addClass('text-danger');
            $('#g3b').addClass('border border-danger')
            log_f = false;
        } else {
            $('#g3b').removeClass('border border-danger');
            $('#g3b').addClass('border border-success');
            $('#g3bValid').html('');
        }

        if ($.trim($('#g3c').val()) == null || $.trim($('#g3c').val()) == '') {
            $('#g3cValid').html('БКО рақамини киритинг!').addClass('text-danger');
            $('#g3c').addClass('border border-danger')
            log_f = false;
        } else if ($.trim($('#g3c').val()).length > 7 || $.trim($('#g3c').val()).length < 7) {
            $('#g3cValid').html('БКО рақами 7 та сондан иборат бўлиши лозим!').addClass('text-danger');
            $('#g3c').addClass('border border-danger')
            log_f = false;
        } else {
            $('#g3c').removeClass('border border-danger');
            $('#g3c').addClass('border border-success');
            $('#g3cValid').html('');
        }

        if (log_f) {

            var dataS = {
                "inDecId": $('#inDecId').val(),
                "g3a": $('#g3a').val(),
                "g3b": $('#g3b').val(),
                "g3c": $('#g3c').val()
            }
            $.ajax({
                type: "POST",
                data: JSON.stringify(dataS),
                url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionTPO",
                dataType: "json",
                async: true,
                contentType: 'application/json',
                success: function (response) {
                    $('#btnCloseModalTPO').trigger('click');
                    ListInDecAppTAbleAjaxThird(0);
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: 'Дастлабки қарор учун йиғим муваффақиятли киритилди',
                        showConfirmButton: false,
                        timer: 1500
                    })
                },
                error: function (response) {
                    if (typeof response.responseJSON.message != "undefined" && response.responseJSON.message != null && response.responseJSON.message != "" && response.responseJSON.message != "undefined") {
                        $('#validTPODiv').html(response.responseJSON.message).addClass('text-danger');
                        $('#g3a').addClass('border border-danger')
                        $('#g3b').addClass('border border-danger')
                        $('#g3c').addClass('border border-danger')
                    } else {
                        $('#g3a,#g3b,#g3c').removeClass('border border-danger');
                        $('#g3a,#g3b,#g3c').addClass('border border-success');
                        $('#validTPODiv').html('');
                    }
                }
            });
        } else return false;
    }
    function openInDecPdf(cmdtId) {
        document.getElementById("mySidenav").style.width = "650px";
        document.getElementById("main").style.marginLeft = "570px";
        document.getElementById("preloaderGenerating")
        $('#preloaderGenerating').removeClass('visually-hidden');
        var dataS = {
            "cmdtId": cmdtId,
        }
        $.ajax({
            type: "POST",
            data: dataS,
            dataType: "html",
            url: "<%=request.getContextPath()%>/openInDecPdf/resources/openInDecPdfOne",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#openInPdf').html(res);
                $('#preloaderGenerating').addClass('visually-hidden');
            },
            error: function (res) {
            }
        });
    }
    function inDecCancelled(inDecId) {
        Swal.fire({
            title: 'Бекор қилиш сабабини киритинг',
            html:
                '<textarea id="TPO_NUM" type="number" class="swal2-input m-0 w-100" placeholder="Изох учун"/>',
            showDenyButton: true,
            confirmButtonText: 'Сақлаш',
            denyButtonText: `Рад этиш`,
        }).then((result) => {
            var dataS = {
                "inDecId": inDecId,
                "TPO_NUM": $('#TPO_NUM').val(),
            }
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {

                if ($('#TPO_NUM').val() === "") {
                    Swal.fire(
                        '<i class="fa fa-info-circle"></i> Маълумотлар тўлдирилмаган!'
                    )
                } else {
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        dataType: "html",
                        url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionCancelled",
                        header: 'Content-type: text/html; charset=utf-8',
                        success: function (res) {
                            ListInDecAppTAbleAjaxThird(0);
                        },
                        error: function (res) {
                        }
                    });
                    Swal.fire('Сақланди!', '', 'success')
                }

            } else if (result.isDenied) {
                Swal.fire('Маълумотлар сақланмади', '', 'info')
            }
        })
    }
    function resultTPO(x, y, z) {
        let results = '';
        results = '' +
            '<div class="input-group mb-4">' +
            '<input id="g3a" type="number" size="5" maxlength="5" class="form-control disabled" disabled value="'+x+'" placeholder="Пост коди">' +
            '<span class="input-group-text">/</span>' +
            '<input id="g3b" type="date" class="form-control " disabled value="'+y+'" placeholder="БКО тўлдирилган санаси">' +
            '<span class="input-group-text">/</span>' +
            '<input id="g3c" type="number" class="form-control" disabled value="'+z+'" placeholder="БКО рақами">' +
            '</div>';
        Swal.fire('' +
            '<h5>Божхона кирим ордери асосида дастлабки қарор учун тўлов қилинган</h5>'
            + '<h6>БКО рақами ва санаси:</h6>' + results);
    }
    function resultCenceled(commentEnded) {
        Swal.fire('' +
            '<h5>Бекор қилиш сабаби</h5>'
            + '<textarea class="border border-primary text-left m-1 text-capitalize" style="font-size: 14px; height: 60%; width: 100%; border-style: dotted!important;">'+commentEnded+'</textarea>');
    }
    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft = "0";
    }
</script>
<script src="<%=request.getContextPath()%>/resources/js/swalSweetalert.js"></script>
</body>
</html>