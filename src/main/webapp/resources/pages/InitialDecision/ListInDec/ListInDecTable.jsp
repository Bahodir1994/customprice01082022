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

<div class="fm-search">
    <div class="mb-0">
        <div class="d-flex justify-content-center">
            <div class="col-md-3 m-2">
                <label class="">Мақоми</label>
                <select class="form-select shadow-sm" id="validationTooltip04" required="">
                    <option selected="" disabled="disabled" value=""><p class="text-muted">Ариза мақоми</p></option>
                    <option value="100">Янги</option>
                    <option value="110">Кўриб чиқиш учун тақсимланган</option>
                    <option value="145">Тасдиқлашга тайрланган</option>
                </select>
            </div>
            <div class="col-md-2 m-2">
                <div class="">
                    <label class="">ТИФ ТН коди</label>
                    <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                </div>
            </div>
            <div class="col-md-2 m-2">
                <div class="">
                    <label class="">Шахс тури</label>
                    <select class="form-select shadow-sm" id="validationTooltip05" required="">
                        <option selected="" disabled="disabled" value=""><p class="text-muted">Барчаси</p></option>
                        <option value="100">Жисмоний шахс</option>
                        <option value="110">Юридик шахс</option>
                    </select>
                </div>
            </div>
            <div class="col-md-1 m-2">
                <div class="">
                    <label class="">Сана</label>
                    <input class="result form-control shadow-sm" type="date" id="date" placeholder="йил-ой-кун">
                </div>
            </div>
            <div class="">
                <p class="mt-5">дан</p>
            </div>
            <div class="col-md-1 m-2">
                <div class="">
                    <label></label>
                    <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                </div>
            </div>
            <div class="">
                <p class="mt-5">гача</p>
            </div>
            <div class="col-md-2 m-2">
                <div class="">
                    <button type="button" class="btn btn-primary mt-3"><i class='bx bx-refresh'></i>Янгилаш</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row mt-3">
    <div class="col-12 col-lg-12">
        <div class="table-responsive">
            <table id="example1" class="table table-striped table-bordered table-responsive">
                <thead class="bg-light-primary" style="border-color: #0a58ca; border-style: dotted">
                <tr>
                    <th style="border-style: dotted">т/р</th>
                    <th style="border-style: dotted">Ариза рақами</th>
                    <th style="border-style: dotted">Мақоми</th>
                    <th style="border-style: dotted">Ариза санаси</th>
                    <th style="border-style: dotted">Мафаатдор шахс</th>
                    <th style="border-style: dotted">Савдо қилувчи</th>
                    <th style="border-style: dotted">Ишлаб чиқарувчи</th>
                    <th style="border-style: dotted">Сотувчи мамлакат</th>
                    <%if (userRole == 7) {%>
                    <th style="border-style: dotted">Ходим</th>
                    <th style="border-style: dotted">Тақсимлаш</th>
                    <%}%>
                </tr>
                </thead>
                <tbody>
                <c:set var="appId"/>
                <c:forEach var="notSorted" items="${notSortedList}" varStatus="i">
                    <c:set var="appId" value="${notSorted.id}"/>
                    <c:set var="rowCount" value="${0}"/>
                    <tr>
                        <td>${i.index + 1}</td>
                        <td id="appIdF"><a type="button" class="btn btn-primary btn-sm radius-30 px-4"
                                           href="javascript:InitialDecisionView('${notSorted.id}')"
                                           class="text-primary font-weight-bold"><u>${notSorted.appNum}</u></a>
                        </td>
                        <td>
                            <div class="badge rounded-pill text-success bg-light-success p-2 text-uppercase px-3"><i
                                    class='bx bxs-circle me-1'></i>${notSorted.statusNm}</div>
                        </td>
                        <td>${notSorted.insTime.toLocaleString()}</td>
                        <td>${notSorted.personFio}</td>
                        <td>${notSorted.customerCountry}-${notSorted.customerCountryNm}</td>
                        <td>${notSorted.customerCountry}-${notSorted.customerCountryNm}</td>
                        <td>${notSorted.senderCountry}-${notSorted.senderCountryNm}</td>
                        <%if (userRole == 7) {%>
                        <td>
                            <select class="form-select shadow-sm" required="" id="userIdF_${i.index + 1}"
                                    name="userId_${i.index + 1}">
                                <option value="notSelected"></option>
                                <c:forEach var="userSelect" items="${userSelectList}" varStatus="iUser">
                                    <option value="${userSelect.id}"><u>${userSelect.fullname}</u></option>
                                </c:forEach>
                            </select>
                        </td>
                        <td style="border-style: dotted">

                            <button type="button" class="btn btn-success btn-block"
                                    onclick="saveInDecRaspIns('${notSorted.id}', $('#userIdF_${i.index + 1}').val(), ${i.index + 1})">
                                <i class='bx bxs-edit'></i>
                            </button>

                        </td>
                        <%}%>
                    </tr>
                </c:forEach>
                <%--                                        <td><div class="badge rounded-pill text-success bg-light-success p-2 text-uppercase px-3"><i class='bx bxs-circle me-1'></i>FulFilled</div></td>--%>
                <%--                                        <td><div class="badge rounded-pill text-info bg-light-info p-2 text-uppercase px-3"><i class='bx bxs-circle align-middle me-1'></i>Confirmed</div></td>--%>
                <%--                                        <td><div class="badge rounded-pill text-warning bg-light-warning p-2 text-uppercase px-3"><i class='bx bxs-circle align-middle me-1'></i>Partially shipped</div></td>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>

    function saveInDecRaspIns(appId, inspectorId, rowNum) {
        var inspectorName = $('#userIdF_' + rowNum + ' option:selected').text();
        alert(' rowNum ===> ' + rowNum + '\n appId ===> ' + appId + '\n inspectorId ===> ' + inspectorId + '\n inspectorName ===> ' + inspectorName);
        var dataS = {
            "appId": appId,
            "inspectorId": inspectorId,
            "inspectorName": inspectorName
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp1",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                var typeMessage = '';
                var titletexts = '';
                var textText = '';
                if (inspectorId == 'notSelected') {
                    typeMessage = 'error';
                    titletexts = 'Ариза тақсиманишида хатолик!';
                    textText = 'Тақсимлаш учун ходим танланмаган';
                } else {
                    typeMessage = 'success';
                    titletexts = 'Ариза мувофақиятли сақланди!';
                    textText = 'Ариза ' +inspectorName+' га тақсимланди';
                }
                $('div#MainContent').html(res);
                // $('button#messageSucces').css({'display': ''});
                // $('button#messageSucces').click();
                new PNotify({
                    title: titletexts,
                    text: textText,
                    type: typeMessage,
                    styling: 'bootstrap3'
                });
            },
            error: function (res) {
            }
        });
    }

    $(document).ready(function () {
        $('#example1').DataTable({
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
    $(document).ready(function () {
        $('#example2').DataTable({
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
    $(document).ready(function () {
        $('#example3').DataTable({
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
</html>