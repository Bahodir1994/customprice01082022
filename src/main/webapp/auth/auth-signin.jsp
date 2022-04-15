<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Божхона қиймати</title>
    <!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 11]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="keywords" content="">
    <meta name="author" content="Phoenixcoded"/>
    <!-- Favicon icon -->
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/emblem.png" type="image/x-icon">

    <!-- vendor css -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css">
</head>
<body>
<!-- [ auth-signin ] start -->
<div class="auth-wrapper">
    <div class="auth-content">
        <div class="card">
            <div class="row align-items-center text-center">
                <div class="col-md-12">
                    <div class="card-body">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/emblem.png" alt=""
                             class="img-fluid mb-4" style="width: 80px; height: 80px">
                        <form:form modelAttribute="auth-signin" method="post" cssClass="win3PartInfPartF needs-validation"
                                   action="${pageContext.request.contextPath}/user/auth/auth-signin"
                                   id="signin" name="signin" novalidate="true">
                            <h4 class="mb-3 f-w-400">Тизимга кириш</h4>
                            <div class="form-group mb-3">
                                <label class="floating-label" for="Username">Логин</label>
                                <form:input type="text" path="username" name="username" id="username" placeholder=""
                                            cssClass="form-control"/>
                                <form:errors path="username" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <div class="form-group mb-4">
                                <label class="floating-label" for="Password">Парол</label>
                                <form:input type="password" path="password" name="password" id="password" placeholder=""
                                            cssClass="form-control"/>
                                <form:errors path="password" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <button class="btn btn-block btn-primary mb-4">Тизимга кириш</button>
<%--                            <p class="mb-0 text-muted f-12"><a href="${pageContext.servletContext.contextPath}/user/auth/auth-signup" class="f-w-400" onclick="signUp()">Рўйхатдан ўтиш</a></p>--%>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- [ auth-signin ] end -->

<!-- Required Js -->
<script src="${pageContext.servletContext.contextPath}/resources/js/vendor-all.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/ripple.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/pcoded.min.js"></script>
<script>
    function signUp() {
        signin.action = "..${pageContext.request.contextPath}/user/auth/authIn";
        signin.target = '_self';
        signin.submit();
    }

    function signIn() {
        let username = $('input#username').val();
        let password = $('input#password').val();
        var dataS = {}
        var tipform = "<%=request.getContextPath()%>/user/auth/auth-signin/" + username + "/" + password;
        $.ajax({
            type: "POST",
            url: tipform,
            data: dataS,
            dataType: "json",
            success: function (res) {
            },
            error: function (res) {
                alert('ERROR! \n ' + res.statusText);
            }
        });
    }
</script>

</body>

</html>
