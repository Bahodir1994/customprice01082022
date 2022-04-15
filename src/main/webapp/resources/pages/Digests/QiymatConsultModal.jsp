<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.03.2022
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<body>

<div class="modal-dialog bg-warning" role="document" style="max-width:80% !important;">
    <div class="modal-content shadow-lg">
        <div class="modal-header bg-primary">
            <h5 class="modal-title text-center text-white" id="exampleModalLiveLabel">
            <c:forEach var="val" items="${qiymatConsult}" varStatus="i">
            <tr>
                <th>${val[14]}</th>
                <th>${val[15]}</th>
                <th>${val[16]}</th>
            </tr>
            </c:forEach>
            </h5>
<%--            <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>--%>
        </div>
        <div class="modal-body p-2">
            <fieldset class="form-group fieldsetC mb-0">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-sm">
                                <thead>
                                <tr>
                                    <th scope="col">т/р</th>
                                    <th scope="col">ТИФ ТН коди</th>
                                    <th scope="col">Товар рақами</th>
                                    <th scope="col">Бирлик нархи</th>
                                    <th scope="col">Валюта коди</th>
                                    <th scope="col">Валюта миқдори</th>
                                    <th scope="col">Методи</th>
                                    <th scope="col">Нетто</th>
                                    <th scope="col">Сабаб</th>
                                    <th scope="col">Шартли белгилаш</th>
                                    <th scope="col">Товар номи</th>
                                    <th scope="col">Хабар</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="val" items="${qiymatConsult}" varStatus="i">
                                <tr>
                                    <th scope="row">${i.index+1}</th>
                                    <td>${val[0]}</td>
                                    <td>${val[1]}</td>
                                    <td>${val[2]}</td>
                                    <th scope="row">${val[3]}</th>
                                    <td>${val[4]}</td>
                                    <td>${val[5]}</td>
                                    <td>${val[6]}</td>
                                    <th>${val[7]} ${val[8]} ${val[9]}${val[10]}</th>
                                    <td>${val[11]}</td>
                                    <td>
                                        <textarea rows="3"  cols="250" class="form-control" id="validationTextarea1" placeholder="" required>${val[12]}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="3"  cols="250" class="form-control" id="validationTextarea2" placeholder="" required>${val[13]}</textarea>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </fieldset>
        </div>
        <div class="modal-footer bg-light p-1">
            <button type="button" class="btn btn-icon" data-dismiss="modal" aria-label="Close" title="Saqlash">
                <i class="fa-duotone fa-floppy-disk fa-xl"></i>
                <span class="ripple ripple-animate"></span>
            </button>
        </div>
    </div>
</div>
</body>
</html>
