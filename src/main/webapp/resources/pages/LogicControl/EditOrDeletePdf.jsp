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
<!-- Modal SaveNewLC -->
<div class="m-5">

    <h5>Файл Мавжуд:</h5>
    <%--    <c:if test="${userId == '18990' || userId == 'AB170110000063971'}">--%>
    <form method="POST"
          action="/spring-mvc-java/uploadFileWithAddtionalData"
          enctype="multipart/form-data">
        <div class="mb-3">
            <p>Мантиқий назорат рақами ва файл номи:</p>
            <input hidden id="flkNum" name="flkNum" value="${flkNum}">
            <input hidden id="flkId" name="flkId" value="${id}">
            <input class="form-control" disabled="disabled" value="${flkNum} / ${originalName}">
        </div>
        <div class="modal-footer text-end">
            <button type="button" class="btn btn-danger" onclick="DeleteLCPdf()"><i class="bx bx-trash-alt"></i>Ўчириш</button>
        </div>
        <hr>
        <h5>Файлни ўзгартириш</h5>
        <p>Файлни бириктиринг:</p>
        <div class="input-group text-end">
            <input type="file" class="form-control" id="fileVal" name="fileVal" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
        </div>
    </form>
    <%--    </c:if>--%>

    <div class="modal-footer">
        <button type="button" class="btn btn-secondary justify-content-center" data-bs-dismiss="modal" onclick="closeNavLc()"><i class="bx bx-window-close"></i>Ёпиш</button>
        <%--        <c:if test="${userId == '18990' || userId == 'AB170110000063971'}">--%>
        <button type="button" class="btn btn-primary" onclick="SaveNewLCPdf()"><i class="bx bx-save"></i>Сақлаш</button>

        <%--        </c:if>--%>
    </div>

    <div>
        <p style="font-style: italic">Эслатма: Агар файл мавжуд бўлса, янги фал бириктирилганда олдинги файл ўчирилиб, янги файл ёзилади. Ўчириш тугмаси босилганда фай фақат ўчирилади.</p>
    </div>
</div>


<script>
    function SaveNewLCPdf() {
        let flkId = $('#flkId').val();
        let files = fileVal.files[0];

        let dataSS = new FormData();
        dataSS.append('flkId', flkId);
        dataSS.append('file', files);
        $.ajax({
            type: 'POST',
            contentType: false,
            data: dataSS,
            dataType: 'json',
            processData: false,
            cache: false,
            async: true,
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/savePdfFile",
            success: function (res) {
                closeNavLc()
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Бажарилди!',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (res) {
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Хатолик!',
                    showConfirmButton: false,
                    timer: 2000
                })
            }
        });
    }

    function DeleteLCPdf() {
        var dataS = {
            "flkId": $('#flkId').val(),
        }
        $.ajax({
            type: "POST",
            data: dataS,
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/DeleteLCPdf",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                closeNavLc()
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Бажарилди!',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (res) {
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Хатолик!',
                    showConfirmButton: false,
                    timer: 2000
                })
            }
        });

    }

</script>

<script src="<%=request.getContextPath()%>/resources/js/swalSweetalert.js"></script>
</body>
