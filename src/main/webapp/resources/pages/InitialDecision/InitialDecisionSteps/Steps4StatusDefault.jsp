<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 22.02.2022
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String HS_NM_FULL = "";
%>

<body>
<div class="page-content">
    <div class="col-12 col-lg-12 shadow">
        <div class="card">
            <div class="card-body">
                <div class="w-100">
                    <div class="row">
                        <div class="col text-start">
                            <h5>${cmdtTnved} - ТИФ ТН кодли товар бўйича хисобланган тўловлар</h5>
                        </div>
                        <div class="col text-end">
                            <c:if test="${userRole == 8}">
                                <c:if test="${appStatus == 110}">
                                    <button onclick="javascript:sendCalcInDec()" class="btn btn-success">Жўнатиш</button>
                                </c:if>
                                <c:if test="${appStatus != 110}">
                                    <h5>Ариза мақоми: ${appStatusName}</h5>
                                </c:if>
                            </c:if>
                            <c:if test="${userRole == 7}">
                                <c:if test="${appStatus == 145}">
                                    <button onclick="javascript:InDecConfirmToXBB()" class="btn btn-success">Имзолашга жўнатиш</button>
                                </c:if>
                                <c:if test="${appStatus != 145}">
                                    <h5>Ариза мақоми: ${appStatusName}</h5>
                                </c:if>
                            </c:if>
                            <c:if test="${userRole == 6}">
                                <c:if test="${appStatus == 160}">
                                    <button onclick="javascript:InDecConfirmXBBFinish()" class="btn btn-success">Қарорни имзолаш</button>
                                </c:if>
                                <c:if test="${appStatus != 160}">
                                    <h5>Ариза мақоми: ${appStatusName}</h5>
                                </c:if>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="table-responsive mt-3">
                    <table class="table table-bordered table-striped">
                        <thead class="bg-light-primary" style="border-color: #0a58ca; border-style: dotted">
                        <tr>
                            <th style="position: -webkit-sticky; position: sticky; top: 0;z-index: 2;">Т/р</th>
                            <th>Тўлов Коди</th>
                            <th>Хисоблаш асоси</th>
                            <th>Адвалор ставка</th>
                            <th>Хос ставка</th>
                            <th>Хос ставка миқдори</th>
                            <th>Доллар курси</th>
                            <th>Қўш.ўл.бир</th>
                            <th>Ҳисобланган</th>
                            <th>Тўлов тури</th>
                            <c:if test="${appStatus == 110}">
                                <th>Тозалаш</th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="val" items="${CmdtPayments}" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${val.g47Type}</td>
                                <td>${val.g47Base}</td>
                                <td>${val.g47Rate}</td>
                                <td>${val.g47AltRate}</td>
                                <td>${val.g47AltBase}</td>
                                <td>${rate}</td>
                                <td>${val.g47AltBaseEdIzm}</td>
                                <td>${val.g47Sum}</td>
                                <td>${val.g47Sp}</td>
                                <c:if test="${appStatus == 110}">
                                    <td>
                                        <button type="button" class="btn btn-danger btn-block" data-bs-toggle="modal"
                                                data-bs-target="#exampleExtraLargeModal4">
                                            <i class="bx bx-trash-alt"></i>
                                        </button>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <input type="hidden" id="cmdtId" name="cmdtId" value="<c:out value="${cmdtId}"/>"/>
                <input type="hidden" id="appId" name="appId" value="<c:out value="${appId}"/>"/>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    function sendCalcInDec() {
    var dataS = {
        "cmdtId": $("#cmdtId").val(),
        "appId": $("#appId").val(),

    }
    /*-------------------------------*/

    const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
    title: 'Аризани тасдиқлаш учун жўнатишни хоҳлайсизми?',
    text: "Сиз ушбу ариза бўйича қарор қабул қилмоқдасиз!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Ха, жўнатишни тасдиқлайман!',
    cancelButtonText: 'Йўқ, қайта кўриб чиқаман!',
    reverseButtons: true
    }).then((result) => {
    if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
    'Ариза тасдиқлаш учун жўнатилди!',
    'Ушбу ариза худудий бошқарма тўловлар бўлими бошлиғига тасдиқлаш учун юборилди',
    'success'
    )
    $.ajax({
        type: "POST",
        data: dataS,
        dataType: "json",
        url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionConfirm",
        dataType: "html",
        header: 'Content-type: text/html; charset=utf-8',
        success: function (res) {
        $('div#MainContent').html(res);
    },
    error: function (res) {
        }
        });
    }
    else if (
    /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
        )
    {
    swalWithBootstrapButtons.fire(
    'Амал рад этилди!',
    'Сақлаш амалга оширилмади',
    'error')}
    })

    }
    function InDecConfirmToXBB() {
        var dataS = {
            "cmdtId": $('#cmdtId').val(),
            "appId": $('#appId').val(),
        }

        /*-------------------------------*/

        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Аризани имзолаш учун жўнатишни хоҳлайсизми?',
            text: "Сиз ушбу ариза бўйича қарор қабул қилмоқдасиз!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Ха, жўнатишни тасдиқлайман!',
            cancelButtonText: 'Йўқ, қайта кўриб чиқаман!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                swalWithBootstrapButtons.fire(
                    'Ариза имзолаш учун жўнатилди!',
                    'Ушбу ариза худудий бошқарма бошлиғига имзолаш учун юборилди',
                    'success'
                )
                $.ajax({
                    type: "POST",
                    data: dataS,
                    url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionConfirToXBB",
                    dataType: "html",
                    header: 'Content-type: text/html; charset=utf-8',
                    success: function (res) {
                        $('div#MainContent').html(res);
                    },
                    error: function (res) {
                    }
                });
            } else if (
                /* Read more about handling dismissals below */
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    'Амал рад этилди!',
                    'Сақлаш амалга оширилмади',
                    'error'
                )
            }
        })

    }
    function InDecConfirmXBBFinish() {
        var dataS = {
            "cmdtId": $('#cmdtId').val(),
            "appId": $('#appId').val()
        }

        /*-------------------------------*/

        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Аризани бўйича дастлабки қарорни имзолашни хоҳлайсизми?',
            text: "Сиз ушбу ариза бўйича дастлабки қарор қабул қилмоқдасиз!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Ха, имзолашни тасдиқлайман!',
            cancelButtonText: 'Йўқ, қайта кўриб чиқаман!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                swalWithBootstrapButtons.fire(
                    'Дастлабки қарор шакиллантирилди!',
                    'Ушбу ариза бўйича дастлабки қарор қабул қилинди',
                    'success'
                )
                $.ajax({
                    type: "POST",
                    data: dataS,
                    url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionConfirXBBFinish",
                    dataType: "html",
                    header: 'Content-type: text/html; charset=utf-8',
                    success: function (res) {
                        $('div#MainContent').html(res);
                    },
                    error: function (res) {
                    }
                });
            } else if (
                /* Read more about handling dismissals below */
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    'Амал рад этилди!',
                    'Сақлаш амалга оширилмади',
                    'error'
                )
            }
        })

    }
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js" integrity="sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
