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
                <div id="myTab1Content" class="tab-content border-primary">
                    <div id="home1" role="tabpanel" aria-labelledby="home-tab" class="tab-pane fade py-4 show active">
                        <h5 style="text-align: center">
                            ТИФ ТН коди:
                            <u class="text-primary">
                                ${commodity}
                            </u>
                            бўлган товар учун божхона тўловлари ва йиғимлари тўғрисида маълумот&nbsp
                        </h5>
                        <input type="hidden" id="cmdtId" name="cmdtId" value="<c:out value="${cmdtId}"/>"/>
                        <%--            <input type="hidden" id="appId" name="appId" value="<c:out value="${appId}"/>"/>--%>
                        <input type="hidden" id="rowCount" name="rowCount" value="0"/>
                        <div class="table-responsive">
                            <table class="table tolovlar border-primary" style="border-style: dashed double none">
                                <thead>
                                <tr>
                                    <th scope="col">Тўлов тури</th>
                                    <th scope="col">Хисоблаш асоси</th>
                                    <th scope="col">Адвалор ставка</th>
                                    <th scope="col">Хос ставка</th>
                                    <th scope="col">Хос ставка миқдори</th>
                                    <th scope="col">Доллар курси</th>
<%--                                    <th scope="col">Қўш.ўл.бир.миқ.</th>--%>
                                    <th scope="col">Қўш.ўл.бир</th>
                                    <th scope="col">Ҳисобланган</th>
                                    <th scope="col">Тўлов усули</th>
                                    <th scope="col">Ўчириш</th>
                                    <th scope="col">
                                        <a class="btn btn-primary" id="insertRow" href="#">
                                            <i class="bx bx-plus"></i>
                                        </a>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class='12'>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <select class="d-none myselect">
                            <option value=""></option>
                            <c:forEach var="val" items="${paymenttype}" varStatus="i">
                                <option value="${val.id}">${val.id}</option>
                                ${val.name}
                            </c:forEach>
                        </select>
                        <select class="d-none myselect2">
                            <option value=""></option>
                            <c:forEach var="val" items="${paymttype}" varStatus="i">
                                <option value="${val.id}">${val.id}</option>
                                ${val.spname}
                            </c:forEach>
                        </select>
                        <div class="text-end">
                            <button type="button" class="btn btn-success position-relative" onclick="javascript:saveCalcInDec()">
                                Сақлаш
                            </button>
                        </div>
                        <!-- Add rows button-->
                        <script>
                            $(function () {
                                // Start counting from the third row
                                var counter = 1;
                                $("#insertRow,#insertRow29BN,#insertRow29OO").on("click", function (event) {
                                    event.preventDefault();
                                    var newRow = $("table.tolovlar tbody");
                                    var cols = '<tr>';
                                    // Table columns
                                    cols +=
                                        '<td><select style="width:110%;" id="paymentType' + counter + '" class="form-select rounded-0" onchange="changePaymentType(' + counter + ')" type="text" placeholder="Тўлов турини танланг">' +
                                        $(".myselect").html()
                                        + '</select></td>';
                                    cols += '<td><input id="g47Base' + counter + '" type="number" class="form-control rounded-0" placeholder="Хисоблаш асоси"></td>';
                                    cols += '<td><input id="g47AltBase' + counter + '" type="number" class="form-control rounded-0" placeholder="Адвалор ставка"></td>';
                                    cols += '<td><input id="g47Rate' + counter + '" type="number" class="form-control rounded-0" placeholder="Хос ставка" ></td>';
                                    cols += '<td><input id="g47AltRate' + counter + '" type="number" class="form-control rounded-0" placeholder="Хос ставка миқдори"></td>';
                                    cols += '<td><input id="currRate' + counter + '" type="number" class="form-control rounded-0" placeholder="Доллар курси" readonly>' +
                                        '<input id="typeRate' + counter + '" type="hidden" class="form-control rounded-0" placeholder="Ҳисоблаш шакли">' +
                                        '<input id="g47Type' + counter + '" type="hidden" class="form-control rounded-0" placeholder="Тўлов тури">' +
                                        '<input id="g47ClcType' + counter + '" type="hidden" class="form-control rounded-0" placeholder="Ҳисоблаш шакли">' +
                                        '<input id="g47AltBaseCurrKod' + counter + '" type="hidden" class="form-control rounded-0" placeholder="Алтернатив ставка валютаси коди">' +
                                        '</td>';
                                    // cols += '<td><input id="g47Rate' + counter + '" type="number" class="form-control rounded-0" placeholder="Қўш.ўл.бир.миқ."></td>';
                                    // cols += '<td><input id="typeRate' + counter + '" type="hidden" class="form-control rounded-0" placeholder="Ҳисоблаш шакли"></td>';
                                    cols += '<td><input id="g47AltBaseEdIzm' + counter + '" size="3" maxlength="3" class="form-control rounded-0 w-75" type="number" placeholder="Қўш.ўл.бир." ></td>';
                                    cols += '<td><input id="g47Sum' + counter + '" class="form-control rounded-0 bg-orange" type="number" placeholder="Ҳисобланган бож.тўл" ></td>';
                                    cols += '<td><select style="width:120%;" id="g47Sp' + counter + '" class="form-select rounded-0" type="text" placeholder="Тўлов усулини танланг" required>' +
                                        $(".myselect2").html()
                                        + '</select></td>';
                                    cols += '<td>' +
                                        '<button class="btn btn-danger rounded-0" id ="deleteRow"><i class="bx bx-trash"></i></button ' +
                                        '</td>';
                                    cols += '<td><input id="rowCount_' + counter + '" type="hidden" class="form-control rounded-0 counter" value="' + counter + '"></td>';
                                    cols += '<tr>';
                                    newRow.append(cols);
                                    $('#rowCount').val(counter);
                                    counter++;
                                });
                                $("table").on("click", "#deleteRow", function (event) {
                                    table = $(this).closest("table");
                                    $(this).closest("tr").remove();
                                    var cc = 0;
                                    table.find(".counter").each(function (counter) {
                                        cc++;
                                        $(".counter").eq(counter).attr('value', cc);
                                        $('#rowCount').val(cc);
                                    });
                                    counter -= 1
                                    // counter --;
                                });
                            });
                        </script>
                        <!-- -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    function appRollback(statusApp) {
        // alert($('#appId').val() + ', \n ' + $.trim($('#commentRollback').val()));

        var log_f = true;
        var log_n = '';
        var arr = [];
        var vN = '';

        if ($.trim($('#HS_NM_FULLS').val()) == null || $.trim($('#HS_NM_FULLS').val()) == '') {
            $('#HS_NM_FULLS').css({'border': '1px solid #FF0000'});
            arr[0] = ' Аризани қайтариш сабабини рўйхатдан танланг ! ';
            log_f = false;
        } else {
            $('#HS_NM_FULLS').css({'border': '1px solid #a6c9e2'});
            arr[0] = '';
        }

        if ($.trim($('#commentRollback').val()) == null || $.trim($('#commentRollback').val()) == '') {
            $('#commentRollback').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш бўйича қўшимча маълумот киритилмаган, илтимос майдонни тўлдиринг ! ';
            log_f = false;
        } else if ($.trim($('#commentRollback').val()).length > 200) {
            $('#commentRollback').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш сабаби майдонининг узунлиги 250 та белгидан ошмаслиги лозим ! ';
            log_f = false;
        } else {
            $('#commentRollback').css({'border': '1px solid #a6c9e2'});
            arr[1] = '';
        }


        for (var i = 0; i <= 1; i++) {
            if (arr[i] != '' && !log_f) {
                log_n = log_n + arr[i] + '\n\n';
            }
        }

        if (log_n != '') {
            alert(log_n + '');
        }

        if (log_f) {

            var dataS = {
                "appId": $('#appId').val(),
                "commentRollback": $.trim($('#commentRollback').val()),
                "rollback_ids": $.trim($('#HS_CD_FULL').val()),
                "rollback_names": $.trim($('#HS_NM_FULL').val()),
                "statusApp": statusApp
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
                title: 'Аризани қайтаришни хоҳлайсизми?',
                text: "Сиз ушбу ариза бўйича қарор қабул қилмоқдасиз!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Ха, ариза қайтарилади!',
                cancelButtonText: 'Йўқ, қайта кўриб чиқаман!',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    swalWithBootstrapButtons.fire(
                        'Ариза қайтарилди!',
                        'Ушбу ариза божхона қонуни талабларига мос эмас деб топилди',
                        'success'
                    )
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRollBack",
                        dataType: "html",
                        header: 'Content-type: text/html; charset=utf-8',
                        success: function (res) {
                            var typeMessage = '';
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

        } else return false;

        /*------------------------------*/
    }

    function appRollbackToFix(statusApp) {
        // alert($('#appId').val() + ', \n ' + $.trim($('#commentRollback').val()));

        var log_f = true;
        var log_n = '';
        var arr = [];
        var vN = '';

        if ($.trim($('#HS_NM_FULLS2').val()) == null || $.trim($('#HS_NM_FULLS2').val()) == '') {
            $('#HS_NM_FULLS2').css({'border': '1px solid #FF0000'});
            arr[0] = ' Аризани қайтариш сабабини рўйхатдан танланг ! ';
            log_f = false;
        } else {
            $('#HS_NM_FULLS2').css({'border': '1px solid #a6c9e2'});
            arr[0] = '';
        }

        if ($.trim($('#commentRollback2').val()) == null || $.trim($('#commentRollback2').val()) == '') {
            $('#commentRollback2').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш бўйича қўшимча маълумот киритилмаган, илтимос майдонни тўлдиринг ! ';
            log_f = false;
        } else if ($.trim($('#commentRollback2').val()).length > 200) {
            $('#commentRollback2').css({'border': '1px solid #FF0000'});
            arr[1] = ' Аризани қайтариш сабаби майдонининг узунлиги 250 та белгидан ошмаслиги лозим ! ';
            log_f = false;
        } else {
            $('#commentRollback2').css({'border': '1px solid #a6c9e2'});
            arr[1] = '';
        }


        for (var i = 0; i <= 1; i++) {
            if (arr[i] != '' && !log_f) {
                log_n = log_n + arr[i] + '\n\n';
            }
        }

        if (log_n != '') {
            alert(log_n + '');
        }

        if (log_f) {

            var dataS = {
                "appId": $('#appId').val(),
                "commentRollback": $.trim($('#commentRollback2').val()),
                "rollback_ids": $.trim($('#HS_CD_FULL2').val()),
                "rollback_names": $.trim($('#HS_NM_FULL2').val()),
                "statusApp": statusApp
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
                title: 'Аризани қайтаришни хоҳлайсизми?',
                text: "Сиз ушбу ариза бўйича қарор қабул қилмоқдасиз!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Ха, ариза қайтарилади!',
                cancelButtonText: 'Йўқ, қайта кўриб чиқаман!',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    swalWithBootstrapButtons.fire(
                        'Ариза қайтарилди!',
                        'Ушбу ариза божхона қонуни талабларига мос эмас деб топилди',
                        'success'
                    )
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRollBack",
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

        } else return false;

        /*------------------------------*/
    }


    var HS_NM_FULL_C = "";

    function addT_HS_NM(x) {
        // alert(x);
        var y = x.replaceAll(' ', '');
        var ta = document.getElementById('HS_NM_FULL').value;
        var ta2 = document.getElementById('HS_NM_FULLS').value;
        var tacd = document.getElementById('HS_CD_FULL').value;
        if (ta.length > 2) {
            if (ta.indexOf(x.substring(0, 2)) < 0) {
                document.getElementById('HS_NM_FULL').value = ta + '~' + x;
                document.getElementById('HS_NM_FULLS').value = ta2 + '\n' + x;
                HS_NM_FULL_C = y.substring('~', y.indexOf('-'));
                if (document.getElementById('HS_CD_FULL').value == null || document.getElementById('HS_CD_FULL').value == '') {
                    document.getElementById('HS_CD_FULL').value = HS_NM_FULL_C;
                } else {
                    document.getElementById('HS_CD_FULL').value = tacd + '~' + HS_NM_FULL_C;
                    // document.getElementById('HS_CD_FULL').value = tacd + '\n' + HS_NM_FULL_C;
                }
            }
        } else {
            document.getElementById('HS_NM_FULL').value = x;
            document.getElementById('HS_NM_FULLS').value = x;
            HS_NM_FULL_C = y.substring(0, y.indexOf('-'));
            if (document.getElementById('HS_CD_FULL').value == null || document.getElementById('HS_CD_FULL').value == '') {
                document.getElementById('HS_CD_FULL').value = HS_NM_FULL_C;
            } else {
                document.getElementById('HS_CD_FULL').value = tacd + '~' + HS_NM_FULL_C;
            }
        }
        document.getElementById('HS_NM').value = '';
    }

    function addT_HS_NM2(x) {
        // alert(x);
        var y = x.replaceAll(' ', '');
        var ta = document.getElementById('HS_NM_FULL2').value;
        var ta2 = document.getElementById('HS_NM_FULLS2').value;
        var tacd = document.getElementById('HS_CD_FULL2').value;
        if (ta.length > 2) {
            if (ta.indexOf(x.substring(0, 2)) < 0) {
                document.getElementById('HS_NM_FULL2').value = ta + '~' + x;
                document.getElementById('HS_NM_FULLS2').value = ta2 + '\n' + x;
                HS_NM_FULL_C = y.substring('~', y.indexOf('-'));
                if (document.getElementById('HS_CD_FULL2').value == null || document.getElementById('HS_CD_FULL2').value == '') {
                    document.getElementById('HS_CD_FULL2').value = HS_NM_FULL_C;
                } else {
                    document.getElementById('HS_CD_FULL2').value = tacd + '~' + HS_NM_FULL_C;
                    // document.getElementById('HS_CD_FULL').value = tacd + '\n' + HS_NM_FULL_C;
                }
            }
        } else {
            document.getElementById('HS_NM_FULL2').value = x;
            document.getElementById('HS_NM_FULLS2').value = x;
            HS_NM_FULL_C = y.substring(0, y.indexOf('-'));
            if (document.getElementById('HS_CD_FULL2').value == null || document.getElementById('HS_CD_FULL2').value == '') {
                document.getElementById('HS_CD_FULL2').value = HS_NM_FULL_C;
            } else {
                document.getElementById('HS_CD_FULL2').value = tacd + '~' + HS_NM_FULL_C;
            }
        }
        document.getElementById('HS_NM2').value = '';
    }

    function ClearT_HS_NM() {
        document.getElementById("HS_NM").value = "";
    }

    function ClearT_HS_NM2() {
        document.getElementById("HS_NM2").value = "";
    }

    var gtkXTButton = document.querySelector("#gtkXTButton");
    var HS_NM_FULL = document.querySelector("#HS_NM_FULL");
    var HS_NM_FULLS = document.querySelector("#HS_NM_FULLS");
    var HS_CD_FULL = document.querySelector("#HS_CD_FULL");
    gtkXTButton.onclick = function () {
        HS_NM_FULL.value = "";
        HS_NM_FULLS.value = "";
        HS_CD_FULL.value = "";
    };

    var gtkXTButton2 = document.querySelector("#gtkXTButton2");
    var HS_NM_FULL2 = document.querySelector("#HS_NM_FULL2");
    var HS_NM_FULLS2 = document.querySelector("#HS_NM_FULLS2");
    var HS_CD_FULL2 = document.querySelector("#HS_CD_FULL2");
    gtkXTButton2.onclick = function () {
        HS_NM_FULL2.value = "";
        HS_NM_FULLS2.value = "";
        HS_CD_FULL2.value = "";
    };

    /*------------------------------*/
    /* Ариза тафсилоти */
    function InDecConfirm(status) {
        var dataS = {
            "cmdtId": $('#cmdtId').val(),
            "appId": $('#appId').val(),
            "status": status
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
                    url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionConfirm",
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

    function changePaymentType(rowNum) {

        var log_f = true;
        var log_n = '';
        var arr = [];
        var arr2 = [];
        var paymentType = $('#paymentType' + rowNum).val();
        var rowCount = parseInt($('#rowCount').val());

        // alert(rowCount + ',\n ' + paymentType)
        // if (paymentType == '29') {
        //     for (let i = 1; i <= rowCount; i++) {
        //         if ($('#paymentType' + i).val() == null || $('#paymentType' + i).val() == '') {
        //             alert(' 29 - тўлов турини ҳисоблаш учун тўлов турлари танланмаган ! ');
        //         } else if ($('#paymentType' + i).val() != '20' && $('#paymentType' + i).val() != '27') {
        //             alert(' 29 - тўлов турини ҳисоблаш учун 20 ёки 27 тўлов турлари ҳисобланмаган ! ');
        //         }
        //     }
        // }

        // if (log_f) {
        // } else return false;

        var dataS = {
            "x": '4',
            "cmdt_id": $('#cmdtId').val(),
            "appId": $('#appId').val(),
            "paymentType": paymentType
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/commodity/resources/pages/InitialDecision/InitialDecisionSteps/Steps44",
            // dataType: "json",
            header: 'Content-type: application/json; charset=utf-8',
            success: function (res) {
                console.log(res);
                // $('#g47Base' + rowNum).val((res.g47Base).toLocaleString());
                $('#currRate' + rowNum).val(res.currRate);
                $('#g47Type' + rowNum).val(res.g47Type);
                $('#g47ClcType' + rowNum).val(res.g47ClcType);
                $('#g47AltBaseCurrKod' + rowNum).val(res.g47AltBaseCurrKod);
                // $('#g47AltBaseEdIzm' + rowNum).val(res.g47AltBaseEdIzm);
                // $('#g47Rate' + rowNum).val(res.g47Rate);
                // $('#outputVal').val(
                //     ' g47Base (Хисоблаш асоси) ===> ' + res.g47Base.toLocaleString() +
                //     '\n g47AltBase (Адвалор ставка) ===> ' + res.advRate +
                //     '\n g47Rate (Хос ставка) ===> ' + res.g47Rate +
                //     '\n g47AltRate (Хос ставка миқдори) ===> ' + res.g47AltRate +
                //     '\n g47AltBaseEdIzm (Қўшимча ўлчов бирлиги коди) ===> ' + res.unitRate +
                //     '\n rate840 (Ақш доллар суммаси) ===> ' + res.rate840 +
                //     '\n typeRate (Ҳисоблаш шакли) ===> ' + res.typeRate +
                //     '\n unitRate (Хос ставканинг Қўшимча ўлчов бирлигидаги коди) ===> ' + res.unitRate +
                //     '\n altRate (Хос ставка миқдорининг бирлик (1 - лик) миқдори) ===> ' + res.altRate +
                //     '\n advRate (Адвалор ставка фоиздаги миқдори) ===> ' + res.advRate +
                //     '\n g47Sum (Ҳисобланган тўловлар) ===> ' + res.g47Sum
                // );

            },
            error: function (res) {
            }
        });
    }

    function changePaymentTypeOld(rowNum) {
        // alert($('#appId').val() + '\n, ' + $('#cmdtId').val());
        var log_f = true;
        var log_n = '';
        var arr = [];
        var arr2 = [];
        var paymentType = $('#paymentType' + rowNum).val();
        var rowCount = parseInt($('#rowCount').val());


        // if (log_f) {
        // } else return false;

        var dataS = {
            "x": '4',
            "cmdt_id": $('#cmdtId').val(),
            "appId": $('#appId').val(),
            "paymentType": paymentType
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/commodity/resources/pages/InitialDecision/InitialDecisionSteps/Steps44",
            // dataType: "json",
            header: 'Content-type: application/json; charset=utf-8',
            success: function (res) {
                console.log(res);
                $('#g47Base' + rowNum).val((res.g47Base).toLocaleString());
                $('#g47AltBase' + rowNum).val(res.advRate);
                // alert(res.altRate);
                $('#altRate' + rowNum).val(res.altRate);
                $('#g47Rate' + rowNum).val(res.g47Rate);
                $('#g47AltRate' + rowNum).val(res.g47AltRate);
                $('#g47AltBaseEdIzm' + rowNum).val(res.unitRate);
                $('#rate840' + rowNum).val(res.rate840);
                $('#typeRate' + rowNum).val(res.typeRate);

                var typeRate = parseInt(res.typeRate);
                var g47Rate = res.g47Rate;

                // alert(paymentType);
                // alert(typeRate);
                if (paymentType == 20) {
                    if (typeRate == 0) {
                        $('#g47Sum' + rowNum).val(res.g47Sum);
                        $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).val('');
                        $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).attr('placeholder', '---');
                        $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).attr('readonly', true);
                    }

                    if (typeRate == 1 || typeRate == 2) {
                        if (g47Rate == '0.0') {
                            $('#g47Sum' + rowNum).val('Қўш.ўл.бир.миқ.киритинг!');
                            $('#g47Rate' + rowNum).attr('readonly', false);
                        } else {
                            $('#g47Sum' + rowNum).val(res.g47Sum);
                            $('#g47Rate' + rowNum).attr('readonly', true);
                            $('#g47Rate' + rowNum).val('');
                            $('#g47Rate' + rowNum).attr('placeholder', '---');
                        }
                    }
                } else if (paymentType == 27) {
                    $('#rate840' + rowNum).attr('readonly', true);
                    $('#g47Rate' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum + ',#g47AltBase' + rowNum).attr('readonly', false);
                } else if (paymentType == 29) {
                    $('#g47Sum' + rowNum).val(res.g47Sum);
                    $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).val('');
                    $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).attr('placeholder', '---');
                    $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).attr('readonly', true);

                    var g47Sum = res.g47Sum;

                } else {
                    $('#g47Sum' + rowNum).val(res.g47Sum);
                    $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).val('');
                    $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).attr('placeholder', '---');
                    $('#g47Rate' + rowNum + ',#rate840' + rowNum + ',#g47AltRate' + rowNum + ',#altRate' + rowNum + ',#unitRate' + rowNum + ',#g47AltBaseEdIzm' + rowNum).attr('readonly', true);
                }


                // $('#outputVal').val(
                //     ' g47Base (Хисоблаш асоси) ===> ' + res.g47Base.toLocaleString() +
                //     '\n g47AltBase (Адвалор ставка) ===> ' + res.advRate +
                //     '\n g47Rate (Хос ставка) ===> ' + res.g47Rate +
                //     '\n g47AltRate (Хос ставка миқдори) ===> ' + res.g47AltRate +
                //     '\n g47AltBaseEdIzm (Қўшимча ўлчов бирлиги коди) ===> ' + res.unitRate +
                //     '\n rate840 (Ақш доллар суммаси) ===> ' + res.rate840 +
                //     '\n typeRate (Ҳисоблаш шакли) ===> ' + res.typeRate +
                //     '\n unitRate (Хос ставканинг Қўшимча ўлчов бирлигидаги коди) ===> ' + res.unitRate +
                //     '\n altRate (Хос ставка миқдорининг бирлик (1 - лик) миқдори) ===> ' + res.altRate +
                //     '\n advRate (Адвалор ставка фоиздаги миқдори) ===> ' + res.advRate +
                //     '\n g47Sum (Ҳисобланган тўловлар) ===> ' + res.g47Sum
                // );

            },
            error: function (res) {
            }
        });
    }

    function calculate2(rowNum) {
        // if (event.keyCode === 13) {// } else return false;

        var sum = 0.0;
        var sum1 = 0.0;
        var sum2 = 0.0;
        var g47Base = $('#g47Base' + rowNum).val();
        var g47AltBase = $('#g47AltBase' + rowNum).val();

        var g47Rate = $('#g47Rate' + rowNum).val();
        var g47AltRate = $('#g47AltRate' + rowNum).val();
        var rate840 = $('#rate840' + rowNum).val();
        var altRate = $('#altRate' + rowNum).val();

        var typeRate = parseInt($('#typeRate' + rowNum).val());
        var paymentType = $('#paymentType' + rowNum).val();
        var g47AltBaseEdIzm = $('#g47AltBaseEdIzm' + rowNum).val();

        if (paymentType != '27') {
            if (typeRate === 1) {
                sum1 = (g47Base * g47AltBase) / 100;
                sum2 = g47Rate * g47AltRate * rate840 * altRate;
                if (sum1 > sum2) sum = sum1;
                else sum = sum2;
            }

            if (typeRate === 2) {
                sum1 = (g47Base * g47AltBase) / 100;
                sum2 = g47Rate * g47AltRate * rate840 * altRate;
                sum = sum1 + sum2;
            }

        } else {
            if (typeRate === 0) {
                sum = (g47Base * g47AltBase) / 100;
            }
            if (typeRate === 1) {
                if (g47AltBaseEdIzm != null && g47AltBaseEdIzm != '' && g47AltBaseEdIzm.length == 3) {
                    sum1 = (g47Base * g47AltBase) / 100;
                    sum2 = g47Rate * g47AltRate * rate840 * altRate;
                } else {
                    sum1 = (g47Base * g47AltBase) / 100;
                    sum2 = g47Rate * g47AltRate * rate840;
                }
                if (sum1 > sum2) sum = sum1;
                else sum = sum2;
            }
            if (typeRate === 2) {
                if (g47AltBaseEdIzm != null && g47AltBaseEdIzm != '' && g47AltBaseEdIzm.length == 3) {
                    sum1 = (g47Base * g47AltBase) / 100;
                    sum2 = g47Rate * g47AltRate * rate840 * altRate;
                } else {
                    sum1 = (g47Base * g47AltBase) / 100;
                    sum2 = g47Rate * g47AltRate * rate840;
                }
                sum = sum1 + sum2;
            }
        }

        var g47Sum = sum;
        $('#g47Sum' + rowNum).val(g47Sum);

    }

    function calculate29BN(paymentType, g47Sp) {
        alert(' paymentType ==> ' + paymentType + g47Sp);
    }

    function calculate29OO(paymentType, g47Sp) {
        alert(' paymentType ==> ' + paymentType + g47Sp);
    }

</script>

<script>
    class A {
        constructor(paymentType, g47Base, g47AltBase, g47Rate, g47AltRate, g47AltBaseCurrKod, currRate, g47AltBaseEdIzm, g47Sum, g47Sp, g47Type, g47ClcType) {
            this.paymentType = paymentType;
            this.g47Base = g47Base;
            this.g47AltBase = g47AltBase;
            this.g47Rate = g47Rate;
            this.g47AltRate = g47AltRate;
            this.g47AltBaseCurrKod = g47AltBaseCurrKod;
            this.currRate = currRate;
            this.g47AltBaseEdIzm = g47AltBaseEdIzm;
            this.g47Sum = g47Sum;
            this.g47Sp = g47Sp;
            this.g47Type = g47Type;
            this.g47ClcType = g47ClcType;
        }
    }

    function saveCalcInDec() {
        var log_f = true;
        var log_n = '';
        var arr = [];
        var rowCount = parseInt($("#rowCount").val());
        var listObject = [];
        for (let i = 1; i <= rowCount; i++) {
            listObject.push(new A(
                $("#paymentType" + i).val(),
                $("#g47Base" + i).val(),
                $("#g47AltBase" + i).val(),
                $("#g47Rate" + i).val(),
                $("#g47AltRate" + i).val(),
                $("#g47AltBaseCurrKod" + i).val(),
                $("#currRate" + i).val(),
                $("#g47AltBaseEdIzm" + i).val(),
                $("#g47Sum" + i).val(),
                $("#g47Sp" + i).val(),
                $("#g47Type" + i).val(),
                $("#g47ClcType" + i).val()
            ));
        }
        console.log(JSON.stringify(listObject));
        // alert(rowCount + ",\n" + $("#cmdtId").val() + ',\n' + $("#appId").val());
        var dataS = {
            "x": "4",
            "cmdtId": $("#cmdtId").val(),
            "appId": $("#appId").val(),
            "status": "145",
            "listObject": JSON.stringify(listObject)
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
            title: 'Товар бўйича тўловни сақлаш',
            text: "Сиз ушбу ариза бўйича қарор қабул қилмоқдасиз!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Сақлашни тасдиқлаш!',
            cancelButtonText: 'Қайта кўриб чиқиш!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                swalWithBootstrapButtons.fire(
                    'Товар бўйича тўловни сақланди!',
                    'Ушбу аризанинг товари бўйича маълумотлар сақланди',
                    'success'
                )
                $.ajax({
                    type: "POST",
                    data: dataS,
                    dataType: "json",
                    url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionCalc",
                    dataType: "html",
                    header: 'Content-type: text/html; charset=utf-8',
                    success: function (res) {
                        $('div#divcalculate').html(res);
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

<%--<script src="<%=request.getContextPath()%>/resources/build/js/alertMessages.js"></script>--%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
