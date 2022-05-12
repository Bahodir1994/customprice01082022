<!DOCTYPE html>
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
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--favicon-->
    <link href="<%=request.getContextPath()%>/resources/assets2/images/favicon-32x32.png" type="image/png"/>
    <!--plugins-->
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>
    <!-- loader-->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/pace.min.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>
    <!-- Bootstrap CSS -->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/app.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/icons.css" rel="stylesheet">
    <!-- Theme Style CSS -->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css"/>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet"/>
    <!-- loader-->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
</head>

<body>
<!--wrapper-->
<style>
    .sidenav {
        height: 100%;
        width: 0;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: #111;
        overflow-x: hidden;
        transition: 0.5s;
        padding-top: 120px;
    }

    .sidenav a {
        padding: 8px 80px 8px 32px;
        text-decoration: none;
        font-size: 25px;
        color: #818181;
        display: block;
        transition: 0.3s;
    }

    .sidenav a:hover {
        color: #f1f1f1;
    }

    .sidenav .closebtn {
        position: absolute;
        top: 0;
        right: 25px;
        font-size: 36px;
        margin-left: 50px;
    }

    #main {
        transition: margin-left .5s;
        padding: 16px;
    }

    @media screen and (max-height: 450px) {
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 18px;}
    }
</style>
<div id="mySidenav" class="sidenav">
    <div id="openInPdf">
        <!--PDF open here-->
    </div>
</div>
<!--start page wrapper -->
<div id="main" class="page-content">
    <h6 class="mb-0 text-uppercase">Мантиқий назорат</h6>
    <hr>
    <!--start email wrapper-->

    <!--end email wrapper-->
    <div class="col-12 col-lg-12 shadow">

        <div class="card">
            <div class="fm-search m-3">
                <div class="mb-0">
                    <div class="row">
                        <div class="col-md-2 mt-2 mb-2">
                            <div class="">
                                <label class="">Номи</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                            </div>
                        </div>
                        <div class="col-md-3 mt-2 mb-2">
                            <div class="">
                                <label class="">Хабари</label>
                                <input class="result form-control shadow-sm" type="text" placeholder="Товар ТИФ ТН коди">
                            </div>
                        </div>
                        <div class="col-md-2 mt-2 mb-2">
                            <div class="">
                                <label class="">Сана(дан)</label>
                                <input class="result form-control shadow-sm" type="date" id="date" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-2 mt-2 mb-2">
                            <div class="">
                                <label>Сана(гача)</label>
                                <input class="result form-control shadow-sm" type="date" id="date2" placeholder="йил-ой-кун">
                            </div>
                        </div>
                        <div class="col-md-3 mt-2 mb-2">
                            <button type="button" class="btn btn-primary mt-3" onclick="searchResultTableLC(0)"><i class='bx bx-refresh'></i>Излаш</button>
                            <button type="reset" class="btn btn-primary  mt-3"><i class='bx bx-refresh'></i>Янгилаш</button>
                            <button type="reset" class="btn btn-primary  mt-3" data-bs-toggle="modal" data-bs-target="#exampleModal" ><i class='bx bx-plus'></i>Қўшиш</button>
<%--                            onclick="SaveNewLC(0)"--%>
                            <!-- Modal SaveNewLC -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <div class="p-4 border rounded">
                                                                <form class="was-validated">
                                                                    <div class="mb-3">
                                                                        <label for="validationTextarea" class="form-label">Textarea</label>
                                                                        <textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required></textarea>
                                                                        <div class="invalid-feedback">Please enter a message in the textarea.</div>
                                                                    </div>
                                                                    <div class="form-check mb-3">
                                                                        <input type="checkbox" class="form-check-input" id="validationFormCheck1" required>
                                                                        <label class="form-check-label" for="validationFormCheck1">Check this checkbox</label>
                                                                        <div class="invalid-feedback">Example invalid feedback text</div>
                                                                    </div>
                                                                    <div class="form-check">
                                                                        <input type="radio" class="form-check-input" id="validationFormCheck2" name="radio-stacked" required>
                                                                        <label class="form-check-label" for="validationFormCheck2">Toggle this radio</label>
                                                                    </div>
                                                                    <div class="form-check mb-3">
                                                                        <input type="radio" class="form-check-input" id="validationFormCheck3" name="radio-stacked" required>
                                                                        <label class="form-check-label" for="validationFormCheck3">Or toggle this other radio</label>
                                                                        <div class="invalid-feedback">More example invalid feedback text</div>
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <select class="form-select" required aria-label="select example">
                                                                            <option value="">Open this select menu</option>
                                                                            <option value="1">One</option>
                                                                            <option value="2">Two</option>
                                                                            <option value="3">Three</option>
                                                                        </select>
                                                                        <div class="invalid-feedback">Example invalid select feedback</div>
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <input type="file" class="form-control" aria-label="file example" required>
                                                                        <div class="invalid-feedback">Example invalid form file feedback</div>
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <button class="btn btn-primary" onclick="" type="button" disabled>Сақлаш</button>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
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
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>--%>
                </div>
            </div>
            <hr>
            <div class="card-body" id="ListLCTable" style="min-height: 740px!important; max-height: 5000px!important; height: 100%!important;">
            </div>
        </div>
    </div>
</div>
<!--end page wrapper -->
<!--end wrapper -->
<script src="<%=request.getContextPath()%>/resources/assets2/js/bootstrap.bundle.min.js"></script>
<!--plugins-->
<script src="<%=request.getContextPath()%>/resources/assets2/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/js/simplebar.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/js/metisMenu.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>

<script>
    (function ($) {
        function getTimer(obj) {
            return obj.data('swd_timer');
        }

        function setTimer(obj, timer) {
            obj.data('swd_timer', timer);
        }

        $.fn.showWithDelay = function (delay) {
            var self = this;
            if (getTimer(this)) {
                window.clearTimeout(getTimer(this)); // prevents duplicate timers
            }
            setTimer(this, window.setTimeout(function () {
                setTimer(self, false);
                $(self).show();
            }, delay));
        };
        $.fn.hideWithDelay = function () {

            if (getTimer(this)) {
                window.clearTimeout(getTimer(this));
                setTimer(this, false);
            }
            $(this).hide();
        }
    })(jQuery);

    function searchResultTableLC(x) {
        var dataS = {
            "x": x,
        }
        $.ajax({
            type: "POST",
            data: dataS,
            <%--url: "<%=request.getContextPath()%>/apps/resources/pages/InitialDecision/InitialDecisionRasp",--%>
            url: "<%=request.getContextPath()%>/logicalcontrolss/resources/pages/LogicalControl/ResultLC",
            dataType: "html",
            header: 'Content-type: text/html; charset=utf-8',
            success: function (res) {
                $('div#ListLCTable').html(res);
            },
            error: function (res) {
            }
        });
    }

    function SaveNewLC(x) {
        alert("sweeet")
        Swal.fire({
            title: 'Тўлдирилган ТПО рақами ва санаси',
            html:
                '<input id="TPO_NUM" type="number" class="swal2-input" placeholder="ТПО рақами">' +
                '<input id="TPO_DATE" type="date" class="swal2-input" placeholder="ТПО тўлдирилган санаси">',
            showDenyButton: true,
            confirmButtonText: 'Сақлаш',
            denyButtonText: `Рад этиш`,
        }).then((result) => {
            // alert($('#TPO_NUM').val() + ' / ' + $('#TPO_DATE').val());
            var dataS = {
                "inDecId": inDecId,
                "TPO_NUM": $('#TPO_NUM').val(),
                "TPO_DATE": $('#TPO_DATE').val()
            }


            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {

                if ($('#TPO_NUM').val() === "" || $('#TPO_DATE').val() ==="") {
                    Swal.fire(
                        '<i class="fa fa-info-circle"></i> Маълумотлар тўлдирилмаган!'
                    )
                } else {
                    $.ajax({
                        type: "POST",
                        data: dataS,
                        dataType: "html",
                        url: "<%=request.getContextPath()%>/saveInDec/resources/pages/InitialDecision/InitialDecisionTPO",
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

</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
