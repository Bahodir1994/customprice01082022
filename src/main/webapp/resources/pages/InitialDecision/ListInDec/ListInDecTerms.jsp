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
        <%--            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>--%>
    </div>
</div>
<div class="row mt-3">
    <div class="col-12 col-lg-12">
        <div class="table-responsive">
            <table id="example3" class="table table-striped table-bordered table-responsive">
                <thead class="bg-light-primary" style="border-color: #0a58ca; border-style: dotted">
                <tr>
                    <th style=" border-style: dotted">т/р</th>
                    <th style=" border-style: dotted">Ариза рақами</th>
                    <th style=" border-style: dotted">Холати</th>
                    <th style=" border-style: dotted">Тўлов холати</th>
                    <th style=" border-style: dotted">Ариза санаси</th>
                    <th style="border-style: dotted">Ариза юборилган ҲББ</th>
                    <th style=" border-style: dotted">Хужжат (Pdf2)</th>
                    <th style=" border-style: dotted">Манфаатдор шахс</th>
                    <th style=" border-style: dotted">Қарор рақами</th>
                    <th style=" border-style: dotted">Қарор санаси</th>
                    <th style=" border-style: dotted">Етказиб бериш шарти</th>
                    <th style=" border-style: dotted">Амал қилиш муддати</th>
                    <c:forEach var="termss" items="${termsList}" varStatus="i">
                        <c:if test="${termss[59] == 100 && userRole == 6}">
                            <th style="border-style: dotted">Бекор қилиш</th>
                        </c:if>
                        <c:if test="${termss[59] == 100 && userRole != 6}">
                        </c:if>
                        <c:if test="${termss[59] == 200}">
                            <th style="border-style: dotted">Бекор қилиш</th>
                        </c:if>
                    </c:forEach>
                    <th style=" border-style: dotted">Инспектор</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="terms" items="${termsList}" varStatus="i">
                    <tr style="vertical-align: center">
                        <td>${i.index+1}</td>
                        <td><a type="button" class="btn btn-primary btn-sm radius-30 px-4"
                               href="javascript:InitialDecisionView('${terms[0]}')"
                               class="text-primary font-weight-bold"><u>${terms[6]}</u></a></td>
                        <td>
                            <div class="badge rounded-pill text-warning bg-light-warning p-2 text-uppercase px-3"><i
                                    class='bx bxs-circle align-middle me-1'></i>${terms[28]}</div>
                        </td>
                        <td>
                            <%
                                String disabled = "";
                                if (userRole == 8) {
                                    disabled = "";
                                } else {
                                    disabled = "disabled";
                                }
                            %>

                            <c:if test="${terms[54] == 180}"><a data-bs-toggle="modal" class="btn btn-outline-danger <%=disabled%>" onclick="$('#inDecId').val('${terms[33]}');"
                                                                data-bs-target="#exampleModalPAY">${terms[55]}</a></c:if>
                            <c:if test="${terms[54] == 185}"><a class="btn btn-outline-success" onclick="javascript:resultTPO('<h6>${terms[60]}/${terms[61]}/${terms[62]}</h6>')">${terms[55]}</a
                            ></c:if>
                        </td>
                        <td>${terms[1]}</td>
                        <td>${terms[11]}</td>
                        <td>
                            <a type="button" onclick="openInDecPdf('${terms[32]}')"
                               class="btn btn-outline-warning">
                                <i class="bx bxs-file-pdf" style="font-size: 30px"></i>
                            </a>
                        </td>
                        <td>${terms[14]}</td>
                        <td>${terms[48]}</td>
                        <td>${terms[45]}</td>
                        <td>${terms[25]}</td>
                        <td>${terms[56]}</td>
                        <c:if test="${terms[59] == 100 && userRole == 6}">
                            <td>
                                <button class="btn btn-outline-primary" onclick="inDecCancelled('${terms[33]}')"><i
                                        class="bx bx-message-alt-x bx-sm"></i></button>
                            </td>
                        </c:if>
                        <c:if test="${terms[59] == 100 && userRole != 6}">
                        </c:if>
                        <c:if test="${terms[59] == 200}">
                            <td>Бекор қилинган</td>
                        </c:if>
                        <td>${terms[30]}</td>
                    </tr>
                </c:forEach>
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
    </div>
</div>

<script>
    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft = "0";
    }
</script>
<script>
    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: true
    }),
        $('.timepicker').pickatime()
</script>
<script>
    $(function () {
        $('#date-time').bootstrapMaterialDatePicker({
            format: 'DD-MM-YYYY',
            closeOnClear: false
        });
        $('#date').bootstrapMaterialDatePicker({
            time: false,
            closeOnClear: true
        });
        $('#date2').bootstrapMaterialDatePicker({
            time: false,


        });
        $('#time').bootstrapMaterialDatePicker({
            date: false,
            format: 'HH:mm',
            closeOnClear: false
        });
    });

</script>
<script>
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
                    ListInDecTermstTable('170');
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
                            $('div#ListInDecTable').html(res);
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

    function resultTPO(commentMarks) {

        <%--Swal.fire({--%>
        <%--    title: 'Тўлдирилган ТПО рақами ва санаси',--%>
        <%--    html:--%>
        <%--        '<input id="TPO_NUM" type="number" class="swal2-input" placeholder="ТПО рақами">' +--%>
        <%--        '<input id="TPO_DATE" type="date" class="swal2-input" placeholder="ТПО тўлдирилган санаси">',--%>
        <%--    showDenyButton: true,--%>
        <%--    showCancelButton: true,--%>
        <%--    confirmButtonText: 'Сақлаш',--%>
        <%--    denyButtonText: `Рад этиш`,--%>
        <%--}).then((result) => {--%>
        <%--    // alert($('#TPO_NUM').val() + ' / ' + $('#TPO_DATE').val());--%>
        <%--    var dataS = {--%>
        <%--        "inDecId": inDecId,--%>
        <%--        "TPO_NUM": $('#TPO_NUM').val(),--%>
        <%--        "TPO_DATE": $('#TPO_DATE').val()--%>
        <%--    }--%>
        <%--    /* Read more about isConfirmed, isDenied below */--%>
        <%--    if (result.isConfirmed) {--%>
        <%--        $.ajax({--%>
        <%--            type: "POST",--%>
        <%--            data: dataS,--%>
        <%--            dataType: "html",--%>
        <%--            url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionTPO",--%>
        <%--            header: 'Content-type: text/html; charset=utf-8',--%>
        <%--            success: function (res) {--%>
        <%--                $('div#ListInDecTable').html(res);--%>
        <%--            },--%>
        <%--            error: function (res) {--%>
        <%--            }--%>
        <%--        });--%>
        <%--        Swal.fire('Сақланди!', '', 'success')--%>
        <%--    } else if (result.isDenied) {--%>
        <%--        Swal.fire('Маълумотлар сақланмади', '', 'info')--%>
        <%--    }--%>
        <%--})--%>

        Swal.fire('' +
            '<h5>Божхона кирим ордери асосида дастлабки қарор учун тўлов қилинган</h5>'
            + '<h6>БКО рақами ва санаси:</h6>' + commentMarks);
    }

</script>
</body>
</html>