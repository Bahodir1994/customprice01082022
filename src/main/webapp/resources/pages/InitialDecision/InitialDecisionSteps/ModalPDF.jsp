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
<html>
<%
    String docPath = "";
    String docId = "";
    String docNameEx = "";
%>
<body>

<div class="position-relative" id="pdf_area_2">
    <object
            data='https://pdfjs-express.s3-us-west-2.amazonaws.com/docs/choosing-a-pdf-viewer.pdf'
            type="application/pdf"
            width="100%"
            height="678">
        <p>This browser does not support PDF!</p>
    </object>
    <div class="position-absolute bg-white d-flex justify-content-center align-items-center" id="wrap_btn_2"
         style="cursor:pointer; top: 50%; left: 0; height: 40px; width: 30px; border-top-right-radius: 15px; border-bottom-right-radius: 15px;">
        <i class="fa-solid fa-caret-left f-20" id="caret_2"></i>
    </div>

</div>
</body>
</html>
