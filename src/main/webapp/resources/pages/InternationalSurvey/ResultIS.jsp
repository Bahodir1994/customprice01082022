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
<style>
    .filterable {
        margin-top: 15px;
    }
    .filterable .panel-heading .pull-right {
        margin-top: -20px;
    }
    .filterable .filters input[disabled] {
        background-color: transparent;
        border: none;
        cursor: auto;
        box-shadow: none;
        padding: 0;
        height: auto;
    }
    .filterable .filters input[disabled]::-webkit-input-placeholder {
        color: #333;
    }
    .filterable .filters input[disabled]::-moz-placeholder {
        color: #333;
    }
    .filterable .filters input[disabled]:-ms-input-placeholder {
        color: #333;
    }

</style>
<script>
    $(document).ready(function(){
        $('.filterable .btn-filter').click(function(){
            var $panel = $(this).parents('.filterable'),
                $filters = $panel.find('.filters input'),
                $tbody = $panel.find('.table tbody');
            if ($filters.prop('disabled') == true) {
                $filters.prop('disabled', false);
                $filters.first().focus();
            } else {
                $filters.val('').prop('disabled', true);
                $tbody.find('.no-result').remove();
                $tbody.find('tr').show();
            }
        });

        $('.filterable .filters input').keyup(function(e){
            /* Ignore tab key */
            var code = e.keyCode || e.which;
            if (code == '9') return;
            /* Useful DOM data and selectors */
            var $input = $(this),
                inputContent = $input.val().toLowerCase(),
                $panel = $input.parents('.filterable'),
                column = $panel.find('.filters th').index($input.parents('th')),
                $table = $panel.find('.table'),
                $rows = $table.find('tbody tr');
            /* Dirtiest filter function ever ;) */
            var $filteredRows = $rows.filter(function(){
                var value = $(this).find('td').eq(column).text().toLowerCase();
                return value.indexOf(inputContent) === -1;
            });
            /* Clean previous no-result if exist */
            $table.find('tbody .no-result').remove();
            /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
            $rows.show();
            $filteredRows.hide();
            /* Prepend no-result row if all rows are filtered */
            if ($filteredRows.length === $rows.length) {
                $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="'+ $table.find('.filters th').length +'">Маълумот топилмади!</td></tr>'));
            }
        });
    });
</script>

<div class="panel panel-primary filterable table-responsive">
    <table class="table table-striped table-bordered">
        <thead class="border border-radius-lg">
        <tr class="filters text-yellow" style="background-color: #357ebd">
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><button class="btn btn-default btn-xs btn-filter text-light"><span class="glyphicon glyphicon-filter"></span> Filter</button>
                <input type="hidden" class="form-control form-control-sm" placeholder="">
            </th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="hidden" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"><input type="text" class="form-control form-control-sm" placeholder=""></th>
            <th style="border-width: 1px; border-style: dotted; border-color: rgba(2,11,66,0.66)"></th>
        </tr>
        <tr class="filters bg-white text-dark">
            <th style="border-style: dotted; text-align: center;" class="">т/р</th>
            <th style="border-style: dotted; text-align: center;" class=""><i class="bx bx-edit"></i>Таҳрир</th>
            <th style="border-style: dotted; text-align: center;" class="">ҲББ томонидан юбоирлган<br>хат рақами</th>
            <th style="border-style: dotted; text-align: center;" class="">ҲББ томонидан юбоирлган<br>хат санаси</th>
            <th style="border-style: dotted; text-align: center;" class="">Ташкилот номи</th>
            <th style="border-style: dotted; text-align: center;" class="">ТИФ ТН код</th>
            <th style="border-style: dotted; text-align: center;" class="">Товар номи</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровнома юборилган<br>давлат</th>
            <th style="border-style: dotted; text-align: center;" class="">Юборилган сўровнома<br>рақами</th>
            <th style="border-style: dotted; text-align: center;" class="">Юборилган сўровнома<br>санаси</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровномага олинган<br>жавоб хати</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровномага олинган жавоб<br>хати санаси</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровномага олинган жавоб хатини<br>ҲББга юборилган хат рақами</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровномага олинган жавоб хатини<br>ҲББга юборилган хат санаси</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровнома натижаси бўйича жавоб<br>хати рақами</th>
            <th style="border-style: dotted; text-align: center;" class="">Сўровнома натижаси бўйича жавоб<br>хати санаси</th>
            <th style="border-style: dotted; text-align: center;" class="">ҲББ хулоса рақами</th>
            <th style="border-style: dotted; text-align: center;" class="">ҲББ хулоса санаси</th>
            <th style="border-style: dotted; text-align: center;" class="">Камомад суммаси</th>
            <th style="border-style: dotted; text-align: center;" class="">Изоҳ</th>
        </tr>
        </thead>
        <tbody class="">
        <c:if test="${tutorials.size() >= 1}">
            <c:forEach var="tut" items="${tutorials}" varStatus="i">
                <tr>
                    <td>${((currentPage+1) * getPageSize - getPageSize + 1)+i.index}</td>
                    <c:if test="${tut.status == '100'}">
                        <td><button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal2"><i class="bx bx-plus"></i></button></td>
                    </c:if>
                    <c:if test="${tut.status == '200'}">
                        <td><button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal3"><i class="bx bx-plus"></i></button></td>
                    </c:if>
                    <c:if test="${tut.status == '300'}">
                        <%--                    <td><button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="resetModal()"><i class="bx bx-edit"></i></button></td>--%>
                        <td>Comment</td>
                    </c:if>
                    <!-- 1 start-->
                    <td>${tut.xbbMailNum}</td>
                    <td>${tut.xbbMailDate}</td>
                    <td>${tut.orgName}</td>
                    <td>${tut.hsCode}</td>
                    <td>${tut.productName}</td>
                    <td>${tut.sendReqCountryNm}</td>
                    <!-- 2 start-->
                    <td>${tut.sendReqNum}</td>
                    <td>${tut.reqDate}</td>
                    <td>${tut.responseNum}</td>
                    <td>${tut.responseDate}</td>
                    <td>${tut.responseNumSendXbbNum}</td>
                    <td>${tut.responseNumSendXbbDate}</td>
                    <!-- 3 start-->
                    <td>${tut.resultAnswerMailNum}</td>
                    <td>${tut.resultAnswerMailDate}</td>
                    <td>${tut.xbbVerdictNum}</td>
                    <td>${tut.xbbVerdictDate}</td>
                    <td>${tut.sum}</td>
                    <td>${tut.comment}</td>
                </tr>
                <!-- Modal 2-qadam-->
                <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-xl col-md-12">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel2">Халқаро сўровнома киритиш №-2</h5>
                                <button type="button" class="btn-close" id="closeModalSave2" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body row">
                                <!--todo 2-bosqich-->
                                <form id="fm2" name="fm2" class="row g-3 needs-validation2" novalidate>
                                    <div class="form-group col-md-3">
                                        <label  for="sendReqNum" class="form-label text-primary">Юборилган сўровнома рақами:</label>
                                        <input class="form-control was-validated" type="number" id="sendReqNum"  name="sendReqNum" required>
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="invalid-feedback">Сўровнома рақамини киритинг!</div>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="reqDate" class="form-label text-primary">Юборилган сўровнома санаси:</label>
                                        <input  class="form-control was-validated" type="date" id="reqDate" name="reqDate" required>
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="invalid-feedback">Сўровнома санасини киритинг!</div>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="responseNum" class="form-label text-primary">Сўровномага олинган жавоб хати:</label>
                                        <input  class="form-control was-validated" type="number" id="responseNum"  name="responseNum" required>
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="invalid-feedback">Жавоб хати рақамини киритинг!</div>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="responseDate" class="form-label text-primary">Сўровномага олинган жавоб хати санаси:</label>
                                        <input class="form-control was-validated" type="date" id="responseDate"  name="responseDate" required>
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="invalid-feedback">Хат санасини киритинг!</div>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="responseNumSendXbbNum" class="form-label text-primary">Сўровномага олинган жавоб хатини<br> ҲББга юборилган хат рақами:</label>
                                        <input  class="form-control was-validated" type="number" id="responseNumSendXbbNum" name="responseNumSendXbbNum" required>
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="invalid-feedback">Хат рақамини киритинг!</div>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="responseNumSendXbbDate" class="form-label text-primary">Сўровномага олинган жавоб хатини<br> ҲББга юборилган хат санаси:</label>
                                        <input  class="form-control was-validated" type="date" id="responseNumSendXbbDate"  name="responseNumSendXbbDate" required>
                                        <div class="valid-feedback">Текширилди</div>
                                        <div class="invalid-feedback">Хат санасини киритинг!</div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary"
                                                onclick="saveValueFromInputSStep2('${tut.id}', '${tut.status}')">Сақлаш
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal 3-qadam-->
                <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-xl col-md-12">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel3">Халқаро сўровнома киритиш №-3</h5>
                                <button type="button" class="btn-close" id="closeModalSave3" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body row">
                                <!--todo 3-bosqich-->
                                <form class="row g-3 needs-validation3" novalidate>
                                    <div class="form-group col-md-3">
                                        <label for="resultAnswerMailNum" class="form-label text-primary">Сўровнома натижаси бўйича<br> жавоб хати рақами:</label>
                                        <input  class="form-control was-validated" type="number" id="resultAnswerMailNum" name="resultAnswerMailNum" required>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="resultAnswerMailDate" class="form-label text-primary">Сўровнома натижаси бўйича<br> жавоб хати санаси:</label>
                                        <input  class="form-control was-validated" type="date" id="resultAnswerMailDate"  name="resultAnswerMailDate" required>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="xbbVerdictNum" class="form-label text-primary">ҲББ хулоса рақами:</label>
                                        <input  class="form-control was-validated" type="number" id="xbbVerdictNum" name="xbbVerdictNum" required>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="xbbVerdictDate" class="form-label text-primary">ҲББ хулоса санаси:</label>
                                        <input  class="form-control was-validated" type="date" id="xbbVerdictDate"  name="xbbVerdictDate" required>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="sum" class="form-label text-primary">Камомад суммаси:</label>
                                        <input  class="form-control was-validated" type="number" id="sum"  name="sum" required>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="comment" class="form-label text-primary">Изох:</label>
                                        <input  class="form-control was-validated" type="text" id="comment"  name="comment" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary"
                                                onclick="saveValueFromInputSStep3('${tut.id}', '${tut.status}')">Сақлаш
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${tutorials.size() < 1}">
            <tr>
                <td class="no-result text-center" style="text-align: center" colspan="6">Маълумотлар топилмади!</td>
                <td class="no-result text-center" style="text-align: center" colspan="8">Маълумотлар топилмади!</td>
                <td class="no-result text-center" style="text-align: center" colspan="6">Маълумотлар топилмади!</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<div class="row mt-1">
    <div class="col-md-5 align-middle">
        <c:if test="${((currentPage+1) * getPageSize - getPageSize + tutorials.size()) > 1}">
            <span class="text-primary h5 mt-4">
                ${(currentPage+1) * getPageSize - getPageSize + 1} дан
                ${((currentPage+1) * getPageSize - getPageSize + tutorials.size())} гача;
                Жами:${totalItems} та маълумот
            </span>
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
                <li class="page-item"><a class="page-link bg-primary text-white" href="#">${currentPage+1}</a></li>
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
    function saveValueFromInputSStep2(id, status) {
        alert(id + '\n' + status);
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
            "id": id,
            "status": status
        }
        var forms = document.querySelectorAll('.needs-validation2')
        // var forms = document.getElementById('#fm2')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                // form.addEventListener('click', function (event) {
                if (!form.checkValidity()) {
                    // event.preventDefault()
                    // event.stopPropagation()
                    form.classList.add('was-validated')
                }
                if (form.checkValidity()) {
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
                        url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveIS",
                        dataType: "html",
                        header: 'Content-type: text/html; charset=utf-8',
                        success: function (data) {
                            $('#closeModalSave2').trigger('click');
                            Swal.fire({
                                position: 'top-end',
                                icon: 'success',
                                title: 'Иккиламчи маълумотлар сақланди',
                                showConfirmButton: false,
                                timer: 1500
                            })
                        },
                        error: function (request, status, error) {
                            console.log(request.responseText);
                            console.log(status)
                            $('#closeModalSave2').trigger('click');
                            Swal.fire({
                                position: 'top-end',
                                icon: 'error',
                                title: 'Хатолик!',
                                showConfirmButton: false,
                                timer: 1500
                            })
                            //do stuff
                        }
                    });
                }
                // }, false)
            })
    }
    function saveValueFromInputSStep3(id, status) {
        alert('lolo');
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
            "id": id,
            "status": status
        }

        var forms = document.querySelectorAll('.needs-validation3')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                // form.addEventListener('click', function (event) {
                if (!form.checkValidity()) {
                    // event.preventDefault()
                    // event.stopPropagation()
                    form.classList.add('was-validated')
                }
                if (form.checkValidity()) {
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
                        url: "<%=request.getContextPath()%>/inrenationalsurvaey/resources/pages/InternationalSurvay/SaveIS",
                        dataType: "html",
                        header: 'Content-type: text/html; charset=utf-8',
                        success: function (data) {
                            $('#closeModalSave3').trigger('click');
                            Swal.fire({
                                position: 'top-end',
                                icon: 'success',
                                title: 'Якуний маълумотлар сақланди',
                                showConfirmButton: false,
                                timer: 1500
                            })
                        },
                        error: function (request, status, error) {
                            console.log(request.responseText);
                            console.log(status)
                            $('#closeModalSave3').trigger('click');
                            Swal.fire({
                                position: 'top-end',
                                icon: 'error',
                                title: 'Хатолик!',
                                showConfirmButton: false,
                                timer: 1500
                            })
                            //do stuff
                        }
                    });
                }

            })
    }
</script>
</body>