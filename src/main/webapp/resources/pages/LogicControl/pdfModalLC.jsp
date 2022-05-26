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
<!-- Modal SaveNewLC -->
        <div class="m-5">
            <h5>Файл бириктирилмаган</h5>
            <hr>
            <form method="POST"
                       action="/spring-mvc-java/uploadFileWithAddtionalData"
                       enctype="multipart/form-data">
                <div class="mb-3">
                    <h6>Мантиқий назорат рақами: ${flkNum}</h6>
                    <input hidden id="flkNum"  name="flkNum" value="${flkNum}">
                    <input hidden id="flkId" name="flkId" value="${id}">
                </div>
                <hr>
                <h6>Файлни бириктиринг:</h6>
                <div class="input-group">

                    <input type="file" class="form-control" id="fileVal" name="fileVal" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                </div>
            </form>
            <script>
                const usernameEl = document.querySelector('#username');
                const emailEl = document.querySelector('#email');
                const passwordEl = document.querySelector('#password');
                const confirmPasswordEl = document.querySelector('#confirm-password');

                const form = document.querySelector('#signup');


                const checkUsername = () => {

                    let valid = false;

                    const min = 3,
                        max = 25;

                    const username = usernameEl.value.trim();

                    if (!isRequired(username)) {
                        showError(usernameEl, 'Username cannot be blank.');
                    } else if (!isBetween(username.length, min, max)) {
                        showError(usernameEl, `Username must be between ${min} and ${max} characters.`)
                    } else {
                        showSuccess(usernameEl);
                        valid = true;
                    }
                    return valid;
                };


                const checkEmail = () => {
                    let valid = false;
                    const email = emailEl.value.trim();
                    if (!isRequired(email)) {
                        showError(emailEl, 'Email cannot be blank.');
                    } else if (!isEmailValid(email)) {
                        showError(emailEl, 'Email is not valid.')
                    } else {
                        showSuccess(emailEl);
                        valid = true;
                    }
                    return valid;
                };

                const checkPassword = () => {
                    let valid = false;


                    const password = passwordEl.value.trim();

                    if (!isRequired(password)) {
                        showError(passwordEl, 'Password cannot be blank.');
                    } else if (!isPasswordSecure(password)) {
                        showError(passwordEl, 'Password must has at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)');
                    } else {
                        showSuccess(passwordEl);
                        valid = true;
                    }

                    return valid;
                };

                const checkConfirmPassword = () => {
                    let valid = false;
                    // check confirm password
                    const confirmPassword = confirmPasswordEl.value.trim();
                    const password = passwordEl.value.trim();

                    if (!isRequired(confirmPassword)) {
                        showError(confirmPasswordEl, 'Please enter the password again');
                    } else if (password !== confirmPassword) {
                        showError(confirmPasswordEl, 'The password does not match');
                    } else {
                        showSuccess(confirmPasswordEl);
                        valid = true;
                    }

                    return valid;
                };

                const isEmailValid = (email) => {
                    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                    return re.test(email);
                };

                const isPasswordSecure = (password) => {
                    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
                    return re.test(password);
                };

                const isRequired = value => value === '' ? false : true;
                const isBetween = (length, min, max) => length < min || length > max ? false : true;


                const showError = (input, message) => {
                    // get the form-field element
                    const formField = input.parentElement;
                    // add the error class
                    formField.classList.remove('success');
                    formField.classList.add('error');

                    // show the error message
                    const error = formField.querySelector('small');
                    error.textContent = message;
                };

                const showSuccess = (input) => {
                    // get the form-field element
                    const formField = input.parentElement;

                    // remove the error class
                    formField.classList.remove('error');
                    formField.classList.add('success');

                    // hide the error message
                    const error = formField.querySelector('small');
                    error.textContent = '';
                }


                form.addEventListener('submit', function (e) {
                    // prevent the form from submitting
                    e.preventDefault();

                    // validate fields
                    let isUsernameValid = checkUsername(),
                        isEmailValid = checkEmail(),
                        isPasswordValid = checkPassword(),
                        isConfirmPasswordValid = checkConfirmPassword();

                    let isFormValid = isUsernameValid &&
                        isEmailValid &&
                        isPasswordValid &&
                        isConfirmPasswordValid;

                    // submit to the server if the form is valid
                    if (isFormValid) {

                    }
                });


                const debounce = (fn, delay = 500) => {
                    let timeoutId;
                    return (...args) => {
                        // cancel the previous timer
                        if (timeoutId) {
                            clearTimeout(timeoutId);
                        }
                        // setup a new timer
                        timeoutId = setTimeout(() => {
                            fn.apply(null, args)
                        }, delay);
                    };
                };

                form.addEventListener('input', debounce(function (e) {
                    switch (e.target.id) {
                        case 'username':
                            checkUsername();
                            break;
                        case 'email':
                            checkEmail();
                            break;
                        case 'password':
                            checkPassword();
                            break;
                        case 'confirm-password':
                            checkConfirmPassword();
                            break;
                    }
                }));
            </script>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="closeNavLc()">Ёпиш</button>
                <button type="button" class="btn btn-primary" onclick="SaveNewLCPdf()">Сақлаш</button>
            </div>
        </div>


<script>
    function SaveNewLCPdf(flkIdPdf, ) {
        let flkId =$('#flkId').val();
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
