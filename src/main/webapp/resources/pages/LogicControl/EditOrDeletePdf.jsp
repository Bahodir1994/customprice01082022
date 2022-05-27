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
    <h5>Мавжуд: ${originalName}</h5>
    <%--    <c:if test="${userId == '18990' || userId == 'AB170110000063971'}">--%>
    <hr>
    <form method="POST"
          action="/spring-mvc-java/uploadFileWithAddtionalData"
          enctype="multipart/form-data">
        <div class="mb-3">
            <p>Мантиқий назорат рақами: ${flkNum}</p>
            <input hidden id="flkNum" name="flkNum" value="${flkNum}">
            <input hidden id="flkId" name="flkId" value="${id}">
        </div>
        <hr>
        <h5>Файлни ўзгартириш</h5>
        <p>Файлни бириктиринг:</p>
        <div class="input-group">

            <input type="file" class="form-control" id="fileVal" name="fileVal"
                   aria-describedby="inputGroupFileAddon04" aria-label="Upload">
        </div>
    </form>
    <%--    </c:if>--%>

    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="closeNavLc()">Ёпиш</button>
        <%--        <c:if test="${userId == '18990' || userId == 'AB170110000063971'}">--%>
        <button type="button" class="btn btn-primary" onclick="SaveNewLCPdf()">Сақлаш</button>
        <%--        </c:if>--%>
    </div>
</div>


<script>
    function SaveNewLCPdf(flkIdPdf,) {
        let flkId = $('#flkId').val();
        let files = fileVal.files[0];

        let dataSS = new FormData();
        dataSS.append('flkId', flkId);
        dataSS.append('file', files)

        // var dataS = {
        //     "file" : $('#file').val(),
        //     "flkId": $('#flkId').val(),
        //     "flkNum": $('#flkNum').val()
        // }
        alert($('#fileVal').val() + $('#flkId').val() + $('#flkNum').val())
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
                console.log(res)
                closeNavLc()
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Файл сақланди',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
            error: function (res) {
                console.log(res)
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Хатолик! Файл хажми катталиги 5Mb дан катта!',
                    showConfirmButton: false,
                    timer: 2000
                })
            }
        });
    }


    <%--function oformitDiedPerson(){--%>
    <%--    let id =$('#id_pochta').val();--%>
    <%--    let myfile = document.getElementById("file1");--%>
    <%--    let files = myfile.files;--%>

    <%--    let data = new FormData();--%>

    <%--    for (let i = 0; i < files.length; i++) {--%>
    <%--        data.append('file' + i, files[i]);--%>
    <%--    }--%>
    <%--    data.append('id_prof', id);--%>
    <%--    data.append('title', $('#title').val());--%>

    <%--    $.ajax({--%>
    <%--        url: '<%=request.getContextPath()%>/oformitDiedPerson',--%>
    <%--        type: 'POST',--%>
    <%--        contentType: false,--%>
    <%--        data: data,--%>
    <%--        dataType: 'json',--%>
    <%--        processData: false,--%>
    <%--        cache: false,--%>
    <%--        success: function (res) {--%>
    <%--            if (res.status === '200'){--%>
    <%--                console.log('succes')--%>
    <%--                $('#close-modal').click();--%>
    <%--                // setTimeout($('#close-modal').click(), 300)--%>
    <%--                SearchNewByDecl($('#ps').val());--%>
    <%--                toastr.success('Операция выполнена успешно');--%>
    <%--            }else if(res.status === '202' ){--%>
    <%--                toastr.error('Ошибка файл уже существует');--%>
    <%--            }else {--%>
    <%--                toastr.error('Ошибка при выполнении операции');--%>
    <%--            }--%>

    <%--        },--%>
    <%--        error: function (res) {--%>
    <%--            console.log('error')--%>
    <%--            toastr.error('Ошибка при выполнении операции');--%>
    <%--        }--%>
    <%--    })--%>
    <%--};--%>

</script>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
