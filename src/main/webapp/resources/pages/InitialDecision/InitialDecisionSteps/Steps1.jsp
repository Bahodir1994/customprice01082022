<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 22.02.2022
  Time: 16:56
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
<html>
<head>
    <title>Title</title>
    <%--    <%--%>
    <%--        System.out.println("Step1");--%>
    <%--    %>--%>
</head>
<body>

<div id="step1" class="shadow p-3 mb-5 bg-white rounded x_panel">
    <div class="x_title">
        <h2>Умумий маълумотлар <small>1-қадам</small></h2>
        <div class="clearfix"></div>
    </div>
    <fieldset class="border-primary" style="border-style: dashed solid">
        <!-- step1 -->
        <div class="x_content">
            <c:forEach var="var" items="${commodity}">
                <br>
                <div class="col-md-5 col-sm-5  form-group has-feedback">
                    <h6 style="border-bottom: 1px solid green; text-overflow: ellipsis; transition: .55s opacity, .55s visibility; white-space: nowrap;  overflow: hidden;">
                        <b>ТИФ ТН коди:</b><br>${var.hsCode}
                    </h6>
                </div>

                <div class="col-md-7 col-sm-7  form-group has-feedback">
                    <h6 class="hoveroverflowvisible"
                        style="border-bottom: 1px solid green; text-overflow: ellipsis; transition: .55s opacity, .55s visibility; white-space: nowrap;  overflow: hidden;">
                        </i><b>Товар номи:</b><br>${var.hsName}
                    </h6>
                </div>

                <div class="col-md-5 col-sm-5  form-group has-feedback mt-3">
                    <h6 style="border-bottom: 1px solid green">
                        <b>Ишлаб чиқарувчи:</b><br>${var.orignCountrNm}
                    </h6>
                </div>

                <div class="col-md-7 col-sm-7  form-group has-feedback mt-3">
                    <h6 style="border-bottom: 1px solid green">
                        <b>Ишлаб чиқарувчи номи:</b><br>${var.originOrg}
                    </h6>
                </div>

                <div class="col-md-5 col-sm-5  form-group has-feedback mt-4">
                    <h6 style="border-bottom: 1px solid green">
                        <b>Илгари берилган дастлабки қарор:</b><br>${var.inDecNum} / ${var.inDecDate}
                    </h6>
                </div>

                <div class="col-md-7 col-sm-7  form-group has-feedback mt-4">
                    <h6 style="border-bottom: 1px solid green">
                        <b>Илгари б.ТИФ ТН бўй.дастл.қарор:</b><br>${var.hsDecNum} / ${var.hsDecDate}
                    </h6>
                </div>
            </c:forEach>
        </div>
        <!-- step1; -->

        <!-- step2 -->
        <div class="x_content">
            <c:forEach var="var" items="${commodity}">
                <br>

                <div class="col-md-12">
                    <div class="col-md-3 col-sm-3  form-group has-feedback">
                        <h6 style="border-bottom: 1px solid green">
                            </i><b>Тижорат номи:</b><br>${var.tradeName}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Савдо белгиси:</b><br>${var.tradeMark}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Маркаси:</b><br>${var.mark}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Модели:</b><br>${var.model}
                        </h6>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Артикули:</b><br>${var.article}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Нави:</b><br>${var.sort}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Стандарти:</b><br>${var.standarts}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Фойдаланиш мақсади:</b><br>${var.functions}
                        </h6>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Тижорат хусусияти:</b><br>${var.comProp}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Техник хусусияти:</b><br>${var.techChar}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Ўрам тури:</b><br>${var.packTypeNm}
                        </h6>
                    </div>

                    <div class="col-md-3 col-sm-3  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Ўрамлар сони:</b><br>${var.packQty}
                        </h6>
                    </div>

                    <div class="col-md-6 col-sm-6  form-group has-feedback mt-3">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Юк жойлари сони:</b><br>${var.cargoSpace}
                        </h6>
                    </div>

                    <div class="col-md-6 col-sm-6  form-group has-feedback mt-2">
                        <h6 style="border-bottom: 1px solid green">
                            <b>Усул:</b><br>${var.methodNm}<img src="<%=request.getContextPath()%>/resources/images/info.gif"data-toggle="modal" data-target=".bd-example-modal-sm" style="cursor: pointer; background-color: #0b2e13" width="40" height="40">
                                <%--                        <i class="fa fa-info-circle ml-4 fa-lg" data-toggle="modal" data-target=".bd-example-modal-sm"></i>--%>
                        </h6>
                    </div>

                </div>


                <div class="col-md-12 col-sm-3  form-group has-feedback mt-3">
                    <textarea class="resizable_textarea form-control mt-1" placeholder="Қўшимча маълумот " rows="3" style="max-height: 300px; min-height: 100px; width:100%" readonly id="message" name="commentRollback">${var.extraInfo}</textarea>
                </div>

                <!-- Усул тури Modal -->
                <div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Танланган усулдан олдинги усулни қўлламаслик сабаблари</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="col-md-12">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Божхона қийматини аниқлаш усули</th>
                                                <th>Аввалги усулларни қўлламаслик сабаблари</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>Олиб кириладиган товарга доир битимнинг қиймати бўйича</td>
                                                <td>Жўнатувчи мамлакатнинг экспорт божхона юк декларацияси мавжуд эмас</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
                <!-- Усул тури Modal end -->
            </c:forEach>
        </div>
        <!-- step2; -->

        <!-- step3 -->
        <div class="x_content">
            <%--        <c:forEach var="var" items="${commodity}">--%>
            <div class="table-responsive">
                <div class="col-md-12">
                    <table id="example" class="table table-bordered border-primary table-sm" style="width:100%; border-style: dashed solid">
                        <thead class="bg-gradient text-black" style="background-color: #B5CAF9;">
                        <tr class="">
                            <th style="border-style: dotted" class="column-title">№</th>
                            <th style="border-style: dotted" class="column-title">Хужжат тури</th>
                            <th style="border-style: dotted" class="column-title">Хужжат рақами</th>
                            <th style="border-style: dotted" class="column-title">Хужжат санаси</th>
                            <th style="border-style: dotted" class="column-title">Хужжат файли</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="val" items="${docsList}" varStatus="i">
                            <tr class="even pointer">
                                <td class=" ">${i.index+1}</td>
                                <td class=" ">${val.docType}</td>
                                <td class=" ">${val.docNumber}<i class="success fa fa-long-arrow-up"></i></td>
                                <td class=" ">${val.docDate}</td>
                                <td class=" "><a href="<%=request.getContextPath()%>download?id=${val.id}" class="btn btn-primary btn-xs"><i class="fa fa-download">${ val.docName}</i></a></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
                <%--            <div class="col-md-6" style="border: 1px solid red" >--%>
                <%--                <div class="position-relative" id="pdf_area_2">--%>
                <%--                    <object--%>
                <%--                            data='https://pdfjs-express.s3-us-west-2.amazonaws.com/docs/choosing-a-pdf-viewer.pdf'--%>
                <%--&lt;%&ndash;                            data='file:///D:/IN_DEC_FILES/2022/03/16/220316000001/16032022142816734.pdf'&ndash;%&gt;--%>
                <%--                            type="application/pdf"--%>
                <%--                            width="100%"--%>
                <%--                            height="678">--%>
                <%--                        <p>This browser does not support PDF!</p>--%>
                <%--                    </object>--%>
                <%--                    <div class="position-absolute bg-white d-flex justify-content-center align-items-center" id="wrap_btn_2"--%>
                <%--                         style="cursor:pointer; top: 50%; left: 0; height: 40px; width: 30px; border-top-right-radius: 15px; border-bottom-right-radius: 15px;">--%>
                <%--                        <i class="fa-solid fa-caret-left f-20" id="caret_2"></i>--%>
                <%--                    </div>--%>

                <%--                </div>v--%>
                <%--            </div>--%>
                <script>
                    $(document).ready(function () {
                        $('#example').DataTable({
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
            </div>
            <%--        </c:forEach>--%>
        </div>
        <!-- step3; -->

        <!-- step4 -->
        <div>
            <ul id="myTab1" role="tablist" class="nav nav-tabs nav-pills with-arrow flex-column flex-sm-row text-center">
                <li class="nav-item flex-sm-fill">
                    <a id="home1-tab" data-toggle="tab" href="#home1" role="tab" aria-controls="home1" aria-selected="true"
                       class="nav-link text-uppercase font-weight-normal mr-sm-3 rounded-0 border active">Дастлабки қарор қабул
                        қилиш</a>
                </li>
                <li class="nav-item flex-sm-fill">
                    <a id="profile1-tab" data-toggle="tab" href="#profile1" role="tab" aria-controls="profile1"
                       aria-selected="false"
                       class="nav-link text-uppercase font-weight-normal mr-sm-3 rounded-0 border">Аризани қайтариш</a>
                </li>
                <li class="nav-item flex-sm-fill">
                    <a id="contact1-tab" data-toggle="tab" href="#contact1" role="tab" aria-controls="contact1"
                       aria-selected="false"
                       class="nav-link text-uppercase font-weight-normal rounded-0 border">Аризани тузатиш учун қайтариш</a>
                </li>
            </ul>
            <div id="myTab1Content" class="tab-content border-primary">
                <div id="home1" role="tabpanel" aria-labelledby="home-tab" class="tab-pane fade py-4 show active">
                    <h4 style="text-align: center">Божхона тўловлари ва йиғимлари тўғрисида маълумот<a class="btn btn-primary rounded-0 pull-right" id="insertRow" href="#">Қўшиш</a></h4>
                    <input type="hidden" id="cmdtId" name="cmdtId" value="<c:out value="${cmdtId}"/>"/>
                    <div class="table-responsive">
                        <table class="table tolovlar border-primary" style="border-style: dashed double none">
                            <thead>
                            <tr>
                                <td>
                                    <textarea rows="10" cols="80" class="form form-group" style="width: 50%" id="outputVal"></textarea>
                                </td>
                            </tr>
                            </thead>
                        </table>
                        <table class="table tolovlar border-primary" style="border-style: dashed double none">
                            <thead>
                            <tr>
                                <th scope="col">Тўлов тури</th>
                                <th scope="col">Хисоблаш асоси</th>
                                <th scope="col">Адвалор ставка</th>
                                <th scope="col">Хос ставка</th>
                                <th scope="col">Хос ставка миқдори</th>
                                <th scope="col">Доллар курси</th>
                                <th scope="col">Қўш.ўл.бир.миқ.</th>
                                <th scope="col">Қўш.ўл.бир</th>
                                <th scope="col">Ҳисобланган</th>
                                <th scope="col">Тўлов тури</th>
                                <th scope="col">Ўчириш</th>
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
                    <button type="button" class="btn btn-success ml-2" onclick="javascript:InDecConfirm('145')">Жўнатиш</button>
                    <!-- Add rows button-->
                    <!-- -->
                </div>
                <div id="profile1" role="tabpanel" aria-labelledby="profile-tab" class="tab-pane fade py-4">
                    <!-- Text editor -->
                    <h4 style="text-align: center">Аризани қайтариш сабаблари</h4>
                    <form method="post" class="border-primary" id="fm1" name="fm1">
                        <br>
                        <div class="col-md-9 col-sm-9  form-group has-feedback">
                            <div class="form-group pmd-textfield pmd-textfield-floating-label border border-primary">
                                <select placeholder="Сана: дан" class="form-control" type="text" name="HS_NM" id="HS_NM">
                                    <option></option>
                                    <c:forEach var="val" items="${rollbackInfo}" varStatus="i">
                                        <option value="${val.id}">${val.id} - ${val.rollbackName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="float: left; clear: none;">
                            <button class="btn btn-primary" style="padding: 5px 5px;" type="button"
                                    onclick="addT_HS_NM(/*$('#HS_NM').val() + ' - ' + */$('#HS_NM option:selected').text())">
                                <i class="fa fa-save icons" style="color:#ffffff;font-size:13px;"></i> <span class="lang">Сабабни Қўшиш</span>
                            </button>
                            <button class="btn btn-primary" style="padding: 5px 5px;" type="button"
                                    onclick="ClearT_HS_NM()">
                                <i class="fa fa-eraser icons" style="color:#ffffff;font-size:13px;"></i> <span class="lang">Тозалаш</span>
                            </button>
                            <button class="btn btn-danger" type="button" id="gtkXTButton" style=""><i
                                    class="fa fa-trash"></i></button>
                        </div>
                        <div class="form-group W100" style="margin-top:2px; display: none;">
                            <label class="sr-only" for="HS_NM_FULL">Страна-транзит</label>
                            <textarea class="form-control input-sm" rows="4" id="HS_NM_FULL" name="HS_NM_FULL" maxlength="150"
                                      style="width:85%"><%=HS_NM_FULL%></textarea>
                            <textarea class="form-control input-sm" rows="2" id="HS_CD_FULL" name="HS_CD_FULL" maxlength="150"
                                      style="width:85%"><%--<%=HS_CD_FULL%>--%></textarea>
                        </div>
                        <div class="col-md-6 border-primary" style="border-style: dashed double none">
                    <textarea class="form-control input-sm mt-1" rows="4" id="HS_NM_FULLS" name="HS_NM_FULLS" maxlength="150"
                              style="width:100%" readonly></textarea>
                        </div>
                        <div class="col-md-6 border-primary" style="border-style: dashed double none">
                    <textarea class="resizable_textarea form-control mt-1" placeholder="Қўшимча маълумот киритиш учун... " rows="4"
                              style="max-height: 300px;width:100%" id="commentRollback" name="commentRollback"></textarea>
                        </div>
                    </form>
                    <button type="button" class="btn btn-success mt-3" onclick="javascript:appRollback('120');">Жўнатиш</button>
                    <!-- Text editor end-->
                </div>
                <div id="contact1" role="tabpanel" aria-labelledby="contact-tab" class="tab-pane fade py-4">
                    <!-- Text editor -->
                    <h4 style="text-align: center">Аризани қайтариш сабаблари ва тузатиш киритиладиган бўлимлар</h4>
                    <form method="post" class="border-primary" id="fm2" name="fm2">
                        <br>
                        <div class="col-md-9 col-sm-9  form-group has-feedback">
                            <div class="form-group pmd-textfield pmd-textfield-floating-label border border-primary">
                                <select placeholder="Сана: дан" class="form-control" type="text" name="HS_NM" id="HS_NM2">
                                    <option></option>
                                    <c:forEach var="val" items="${rollbackInfo}" varStatus="i">
                                        <option value="${val.id}">${val.id} - ${val.rollbackName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="float: left; clear: none;">
                            <button class="btn btn-primary" style="padding: 5px 5px;" type="button"
                                    onclick="addT_HS_NM2(/*$('#HS_NM').val() + ' - ' + */$('#HS_NM2 option:selected').text())">
                                <i class="fa fa-save icons" style="color:#ffffff;font-size:13px;"></i> <span class="lang">Сабабни Қўшиш</span>
                            </button>
                            <button class="btn btn-primary" style="padding: 5px 5px;" type="button"
                                    onclick="ClearT_HS_NM2()">
                                <i class="fa fa-eraser icons" style="color:#ffffff;font-size:13px;"></i> <span class="lang">Тозалаш</span>
                            </button>
                            <button class="btn btn-danger" type="button" id="gtkXTButton2" style=""><i
                                    class="fa fa-trash"></i></button>
                        </div>
                        <div class="form-group W100" style="margin-top:2px; display: none;">
                            <label class="sr-only" for="HS_NM_FULL">Страна-транзит</label>
                            <textarea class="form-control input-sm" rows="4" id="HS_NM_FULL2" name="HS_NM_FULL" maxlength="150"
                                      style="width:85%"><%=HS_NM_FULL%></textarea>
                            <textarea class="form-control input-sm" rows="2" id="HS_CD_FULL2" name="HS_CD_FULL" maxlength="150"
                                      style="width:85%"><%--<%=HS_CD_FULL%>--%></textarea>
                        </div>
                        <div class="col-md-6 border-primary" style="border-style: dashed double none">
                        <textarea class="form-control input-sm mt-1" rows="4" id="HS_NM_FULLS2" name="HS_NM_FULLS" maxlength="150"
                                  style="width:100%" readonly></textarea>
                        </div>
                        <div class="col-md-6 border-primary" style="border-style: dashed double none">
                        <textarea class="resizable_textarea form-control mt-1" placeholder="Қўшимча маълумот киритиш учун... " rows="4"
                                  style="max-height: 300px;width:100%" id="commentRollback2" name="commentRollback"></textarea>
                        </div>
                    </form>
                    <button type="button" class="btn btn-success mt-3" onclick="javascript:appRollbackToFix('125');">Жўнатиш</button>
                    <!-- Text editor end-->
                </div>
            </div>
        </div>
        <!-- step4; -->
    </fieldset>
</div>
<link href="<%=request.getContextPath()%>/resources/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">

<script src="<%=request.getContextPath()%>/resources/vendors/pnotify/dist/pnotify.js"></script>
<script src="<%=request.getContextPath()%>/resources/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="<%=request.getContextPath()%>/resources/vendors/pnotify/dist/pnotify.nonblock.js"></script>

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


</script>
<script>
    function downloadManual(docId) {
        var dataS = {
            "docId": docId,
            // "state": state,
            // "uncodId": uncodId,
            // "autodeclId": autodeclId,
            // "autodeclDId": autodeclDId
        };
        $.ajax({
            <%--data: dataS,--%>
            <%--async: false,--%>
            <%--&lt;%&ndash;url: "..${pageContext.request.contextPath}/download/resources/pages/InitialDecision/InitialDecisionSteps/Steps3/" + docId,&ndash;%&gt;--%>
            <%--url: "<%=request.getContextPath()%>/download/resources/pages/InitialDecision/InitialDecisionSteps/Steps3",--%>
            <%--dataType: "html",--%>
            <%--header: 'Content-type: text/html; charset=utf-8',--%>
            <%--success: function (res) {--%>
            <%--    $('div#viedPdfDiv').html(res);--%>
            <%--},--%>
            <%--error: function (res) {--%>
            <%--}--%>
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/download/resources/pages/InitialDecision/InitialDecisionSteps/Steps3",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#MainContent').html(res);
            },
            error: function (res) {
            }
        });
    }
</script>
</body>
</html>
