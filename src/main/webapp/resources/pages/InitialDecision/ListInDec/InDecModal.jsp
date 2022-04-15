<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06.02.2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%--<div class="modal fade" id="exampleFullScreenModal" tabindex="-1" aria-hidden="true">--%>
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row-fluid">
                    <div class="row">

                        <div class="col-md-12 col-sm-12 ">
                            <div class="x_panel border rounded mt-4" style="background: rgba(23, 101, 185, 0.08);">
                                <div>
                                    <h4>
                                        <c:set var="total" value="${0}"/>
                                        <c:forEach var="val" items="${appInfo}">
                                            <i class="fa fa-edit"></i>АРИЗА
                                            <small>№: ${val[1]}</small>
                                            <c:set var="total" value="${val[0]}"/>
                                            <input type="hidden" id="appId" name="appId" value="<c:out value="${total}"/>"/>
                                        </c:forEach>

                                    </h4>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <!-- Smart Wizard -->

                                    <div id="wizard" class="form_wizard wizard_horizontal">
                                        <div class="shadow p-3 mb-5 bg-white rounded x_panel">
                                            <div class="x_title collapse-link">
                                                <h2 style="text-align: center">Ариза бўйича дастлабки маълумот</h2>
                                                <ul class="nav navbar-right panel_toolbox">
                                                    <li><a class="ml-5"><i class="fa fa-chevron-up"></i></a>
                                                    </li>
                                                </ul>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div class="x_content " style="display: none;">
                                                <section class="content invoice">
                                                    <!-- info row -->
                                                    <div class="row invoice-info">
                                                        <div class="col-sm-3 invoice-col border-blue border-left">
                                                            <address>
                                                                <strong><i class="fa fa-user mr-2"></i>Аризачи:</strong>
                                                                <br><strong><i class="fa fa-phone mr-2"></i>Телефон рақами:</strong>
                                                                <br><strong><i class="fa fa-barcode mr-2"></i>Юк жўнатувчи:</strong>
                                                                <br><strong><i class="fa fa-money mr-2"></i>Сотувчи</strong>
                                                                <br><strong><i class="fa fa-money mr-2"></i>Транспорт харажатлари</strong>
                                                            </address>
                                                        </div>
                                                        <!-- /.col -->
                                                        <div class="col-sm-2">
                                                            <address>
                                                                <i>
                                                                    <c:set var="total" value="${0.0}"/>
                                                                    <c:forEach var="val" items="${transports}" varStatus="i">
                                                                        <c:set var="total" value="${total + val.transportPrice}"/>
                                                                    </c:forEach>
                                                                    <c:forEach var="val" items="${appInfo}" varStatus="i">
                                                                        ${val[9]}<%--todo Аризачи:  --%>
                                                                        <br>${val[11]} <%--todo Телефон рақами:  --%>
                                                                        <br>${val[16]} - "${val[18]}" <%--todo Юк жўнатувчи: (sender_country_nm + senderOrg)  --%>
                                                                        <br>${val[3]} - "${val[15]}" <%--todo >Сотувчи (customer_country_nm) --%>
                                                                        <br><c:out value="${total}"/> сўм<%--todo >Транспорт харажати (TRAN_EXP) --%>
                                                                    </c:forEach>
                                                                </i>
                                                            </address>
                                                        </div>
                                                        <div class="col-sm-1">
                                                            <img src="<%=request.getContextPath()%>/resources/images/info.gif" data-toggle="modal"
                                                                 data-target="#exampleModalCenter" style="cursor: pointer; background-color: #0b2e13" width="50" height="50">
                                                        </div>

                                                        <!-- /.col -->
                                                        <div class="col-sm-3 invoice-col border-blue border-left">
                                                            <address>
                                                                <strong><i class="fa fa-money mr-2"></i>Фактура қиймати</strong>
                                                                <br><strong><i class="fa fa-balance-scale mr-2"></i>Нетто оғирлиги:</strong>
                                                                <br><strong><i class="fa fa-balance-scale mr-2"></i>Брутто оғирлиги:</strong>
                                                                <br><strong><i class="fa fa-money mr-2"></i>Етказиб бериш шарти:</strong>
                                                            </address>
                                                        </div>
                                                        <!-- /.col -->
                                                        <div class="col-sm-1">
                                                            <address>
                                                                <i>
                                                                    <c:forEach var="val" items="${appInfo}" varStatus="i">
                                                                        ${val[29]} АҚШ</strong>
                                                                        <br>${val[27]} кг
                                                                        <br>${val[28]} кг
                                                                        <br>${val[22]} - ${val[23]}
                                                                        <br>
                                                                    </c:forEach>
                                                                </i>
                                                            </address>
                                                        </div>
                                                        <div class="col-sm-1 invoice-col border-blue border-right">
                                                            <img src="<%=request.getContextPath()%>/resources/images/info.gif" data-toggle="modal" data-target="#exampleModal12"
                                                                 style="cursor: pointer; background-color: #0b2e13" width="50" height="50">
                                                        </div>
                                                    </div>

                                                    <!-- Транспорт тури Modal -->
                                                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                                        <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLongTitle1">Транспорт харакати йўналиши ва харажатлари</h5>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">

                                                                    <div class="col-md-12">

                                                                        <div class="">
                                                                            <table class="table">
                                                                                <thead>
                                                                                <tr>
                                                                                    <th>Бошлағич пункт</th>
                                                                                    <th>Тугаш пункти</th>
                                                                                    <th>Транспорт тури</th>
                                                                                    <th>Ҳаражатлар</th>
                                                                                </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                <c:set var="total" value="${0.0}"/>
                                                                                <c:forEach var="val" items="${transports}" varStatus="i">
                                                                                    <c:set var="total" value="${total + val.transportPrice}"/>
                                                                                    <tr>
                                                                                        <th>${val.finishCountry}</th>
                                                                                        <td>${val.endCountry}</td>
                                                                                        <td><i class="fa fa-subway fa-2x mr-3"></i>${val.tarnsportType}</td>
                                                                                        <td>${val.transportPrice}</td>
                                                                                    </tr>
                                                                                </c:forEach>
                                                                                <tr>
                                                                                    <td>Жами</td>
                                                                                    <td></td>
                                                                                    <td></td>
                                                                                    <td><c:out value="${total}"/></td>
                                                                                </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Ёпиш</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- Транспорт тури Modal end -->

                                                    <!-- Modal -->
                                                    <div class="modal fade bd-example-modal-lg" id="exampleModal12" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog modal-dialog-centered" style="min-width: 85%;" role="document">

                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModal123">Божхона қиймати индекси бўйича хавф даражаси</h5>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="col-md-12">
                                                                        <table class="table table-bordered table-sm">
                                                                            <thead class="text-center">
                                                                            <tr>
                                                                                <th rowspan="2" style="vertical-align: middle">№</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Товар рақами</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Савдо қилувчи мамлакат</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Транспорт</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Жўнатувчи мамлакат</th>
                                                                                <th rowspan="2" style="vertical-align: middle">ТИФ ТН коди</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Келиб чиқиш мамлакати</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Товар вазни</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Товар миқдори</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Ўлчов бирлиги</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Божхона қиймати($)</th>
                                                                                <th rowspan="2" style="vertical-align: middle">Божхона қиймати(кг $)</th>
                                                                                <th colspan="3" style="vertical-align: middle">Божхона қиймати индекси($)</th>
                                                                            </tr>
                                                                            <tr>
                                                                                <th class="bg-success">Минимал</th>
                                                                                <th class="bg-warning">Ўрта</th>
                                                                                <th class="bg-danger">Максимал</th>
                                                                            </tr>

                                                                            </thead>
                                                                            <tbody>
                                                                            <tr>
                                                                                <th scope="row">1</th>
                                                                                <td>1</td>
                                                                                <td>410</td>
                                                                                <td>410</td>
                                                                                <td>30</td>
                                                                                <td>8431492000</td>
                                                                                <td>000</td>
                                                                                <td>210.00</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td>653.10</td>
                                                                                <td>3.11</td>
                                                                                <td class="bg-success">3.11</td>
                                                                                <td class="bg-warning">3.49</td>
                                                                                <td class="bg-danger">4.97</td>

                                                                            </tr>
                                                                            <tr>
                                                                                <th scope="row">1</th>
                                                                                <td>4</td>
                                                                                <td>792</td>
                                                                                <td>792</td>
                                                                                <td>40</td>
                                                                                <td>8431472000</td>
                                                                                <td>000</td>
                                                                                <td>130.00</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td>640.10</td>
                                                                                <td>2.55</td>
                                                                                <td class="bg-success">2.55</td>
                                                                                <td class="bg-warning">3.22</td>
                                                                                <td class="bg-danger">4.22</td>

                                                                            </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Ёпиш</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- endmodal-->
                                                </section>
                                            </div>
                                        </div>
                                        <ul class="wizard_steps">
                                            <li done>
                                                <a href="#step-1" class="done">
                                                    <span class="step_no">1</span>
                                                    <span class="step_descr"></span>
                                                </a>
                                            </li>
                                            <li done>
                                                <a href="#step-2" class="done">
                                                    <span class="step_no">2</span>
                                                    <span class="step_descr"></span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-3" class="done">
                                                    <span class="step_no">3</span>
                                                    <span class="step_descr"></span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-4" class="done">
                                                    <span class="step_no">4</span>
                                                    <span class="step_descr"></span>
                                                </a>
                                            </li>
                                        </ul>
                                        <div class="row">

                                            <%--todo Товарлар рўйхати кўриш DIV ойнаси  --- begin  --%>
                                            <div class="col-md-1" style="max-height: 400px; width: 80px; overflow: auto;" id="div_CmdtList">
                                                <table>
                                                    <tbody>
                                                    <c:forEach var="val" items="${allCommodityFor}" varStatus="i">
                                                        <tr>
                                                            <td>
                                                                <button class="btn btn-outline-dark btn-sm btn-block border-green" id="btnCmdt_${i.index+1}"
                                                                        onclick="checkCmdt('${val.id}',1, '${val.appId}')">${i.index+1}: ${val.hsCode}</button>
                                                            </td>
                                                            <script>
                                                                $('.btn').click(function () {
                                                                    $(this).toggleClass('btn-primary').toggleClass('btn-success text-white');
                                                                });
                                                            </script>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <style>
                                                ::-webkit-scrollbar {
                                                    width: 0;
                                                }
                                            </style>
                                            <%--todo Товарлар рўйхати кўриш DIV ойнаси  --- end  --%>

                                            <%--todo Товарлар учун қадамлар кетма - кетлигини кўриш DIV ойнаси  --- begin  --%>
                                            <div class="col-md-11" id="div_CmdtStep">
                                                <div id="step-1">
                                                    <div class="col-md-12" id="div_CmdtStep_1">
                                                        <!-- -->
                                                    </div>
                                                </div>
                                                <div id="step-2">
                                                    <div class="col-md-12" id="div_CmdtStep_2">
                                                        <!-- -->
                                                    </div>
                                                </div>
                                                <div id="step-3">
                                                    <div class="col-md-12" id="div_CmdtStep_3">
                                                        <!-- -->
                                                    </div>
                                                </div>
                                                <div id="step-4">
                                                    <div class="col-md-12" id="div_CmdtStep_4">
                                                        <!-- -->
                                                    </div>
                                                </div>
                                            </div>
                                            <%--todo Товарлар учун қадамлар кетма - кетлигини кўриш DIV ойнаси  --- end  --%>

                                        </div>
                                    </div>
                                    <!-- End SmartWizard Content -->
                                </div>
                            </div>

                        </div>
                    </div>

                    <script>
                        var tNum = 0;
                        $(document).ready(function () {
                            $(".collapse-link").on("click", function () {
                                var e = $(this).closest(".x_panel"),
                                    a = $(this).find("i"),
                                    t = e.find(".x_content");
                                e.attr("style") ? t.slideToggle(200, function () {
                                    e.removeAttr("style")
                                }) : (t.slideToggle(200), e.css("height", "auto")), a.toggleClass("fa-chevron-up fa-chevron-down")
                            }), $(".close-link").click(function () {
                                $(this).closest(".x_panel").remove()
                            })
                        });

                        function checkCmdt(cmdt_id, x, appId) {
                            var dataS = {
                                "cmdt_id": cmdt_id,
                                "x": x,
                                "appId": appId
                            }
                            var urlForm = '';
                            $.ajax({
                                type: "POST",
                                data: dataS,
                                url: "<%=request.getContextPath()%>/commodity/resources/pages/InitialDecision/InitialDecisionSteps/Steps",
                                dataType: "html",
                                header: 'Content-type: text/html; charset=utf-8',
                                success: function (res) {
                                    console.log(res);
                                    switch (x) {
                                        case 1:
                                            $('div#div_CmdtStep_1').html(res);
                                            $('#wizard').smartWizard('goToStep', 1);
                                            break;
                                        case 2:
                                            $('div#div_CmdtStep_2').html(res);
                                            break;
                                        case 3:
                                            $('div#div_CmdtStep_3').html(res);
                                            break;
                                        case 4:
                                            $('div#div_CmdtStep_4').html(res);
                                            break;
                                        default:
                                    }
                                    // $("#wizard").smartWizard("disableStep","1");
                                    // $("#wizard").smartWizard("disableStep","2");
                                    // $("#wizard").smartWizard("disableStep","3");
                                    // $("#wizard").smartWizard("disableStep","4");
                                    init_SmartWizard();
                                    // $("#wizard").smartWizard("disableStep","1");

                                },
                                error: function (res) {
                                }
                            });
                        }

                        $(document).ready(function () {
                            $('#btnCmdt_1').click();
                            // init_SmartWizard();
                            $('#wizard').smartWizard({
                                onLeaveStep: leaveAStepCallback,
                                onFinish: onFinishCallback
                            });

                            function leaveAStepCallback(obj, context) {
                                // alert("Leaving step " + context.fromStep + " to go to step " + context.toStep);
                                if (context.toStep !== 1)
                                    checkCmdt('', context.toStep, '');
                                return true;
                                // return validateSteps(context.fromStep);
                            }

                            function onFinishCallback(objs, context) {
                                if (validateAllSteps()) {
                                    // $('form').submit();
                                    return true;
                                }
                            }

                            function validateSteps(stepnumber) {
                                var isStepValid = true;
                                if (stepnumber === 1) {
                                    // isStepValid=false;
                                }
                                return isStepValid;
                            }

                            function validateAllSteps() {
                                var isStepValid = true;
                                // all step validation logic
                                return isStepValid;
                            }
                        });
                    </script>


                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
<%--</div>--%>

