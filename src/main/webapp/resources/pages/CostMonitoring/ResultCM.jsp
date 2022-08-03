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
<head>
    <link href="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.css" rel="stylesheet"/>
</head>
<body>

<div class="table-responsive">
    <table id="example" class="display" style="width:100%">
        <thead>
        <tr>
            <th>т/р</th>
            <th>БЮД рўйхат рақами</th>
            <th>Божхона режими</th>
            <th>Товарларни олиб ўтиш хусусияти</th>
            <th>Юк жўнатувчи номи</th>
            <th>ТИФ ТН коди</th>
            <th>БЮДдаги товар рақами</th>
            <th>Товар номи</th>
            <th>Марка</th>
            <th>Нетто оғирлиги</th>
            <th>Брутто оғирлиги</th>
            <th>Божхона қиймати АҚШ долл</th>
            <th>Қўшимча ўлчов бирлиги</th>
            <th>Қўшимча ўлчов бирлигидаги миқдори</th>
            <th>Бир миқдори оғирлиги</th>
            <th>Келиб чиқиш мамлакати</th>
            <th>Юк жўнатувчи мамлакат</th>
            <th>Савдо қилувчи мамлакат</th>
            <th>Транспорт тури</th>
            <th>СТИР</th>
            <th>Божхона қиймати</th>
            <th>Етказиб бериш шарти</th>
            <th>Етказиб бериш манзили</th>
            <th>Шартнома валютаси</th>
            <th>Божхона қийматини аниқлаш усули</th>
            <th>Божхона қиймати бир бирлик учун валютада</th>
            <th>Божхона қиймати бир бирлик учун АҚШ долларида</th>
            <th>Божхона қиймати индекси валютада</th>
            <th>Божхона қиймати индекси АҚШ долларида</th>
            <th>Божхона чегарасаин кесиб ўтиш санаси</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>т/р</th>
            <th>БЮД рўйхат рақами</th>
            <th>Божхона режими</th>
            <th>Товарларни олиб ўтиш хусусияти</th>
            <th>Юк жўнатувчи номи</th>
            <th>ТИФ ТН коди</th>
            <th>БЮДдаги товар рақами</th>
            <th>Товар номи</th>
            <th>Марка</th>
            <th>Нетто оғирлиги</th>
            <th>Брутто оғирлиги</th>
            <th>Божхона қиймати АҚШ долл</th>
            <th>Қўшимча ўлчов бирлиги</th>
            <th>Қўшимча ўлчов бирлигидаги миқдори</th>
            <th>Бир миқдори оғирлиги</th>
            <th>Келиб чиқиш мамлакати</th>
            <th>Юк жўнатувчи мамлакат</th>
            <th>Савдо қилувчи мамлакат</th>
            <th>Транспорт тури</th>
            <th>СТИР</th>
            <th>Божхона қиймати</th>
            <th>Етказиб бериш шарти</th>
            <th>Етказиб бериш манзили</th>
            <th>Шартнома валютаси</th>
            <th>Божхона қийматини аниқлаш усули</th>
            <th>Божхона қиймати бир бирлик учун валютада</th>
            <th>Божхона қиймати бир бирлик учун АҚШ долларида</th>
            <th>Божхона қиймати индекси валютада</th>
            <th>Божхона қиймати индекси АҚШ долларида</th>
            <th>Божхона чегарасаин кесиб ўтиш санаси</th>
        </tr>
        </tfoot>
    </table>
</div>

<script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery.dataTables.min.js"></script>
<%--<script src="<%=request.getContextPath()%>/resources/assets2/data-table/jquery-3.5.1.js"></script>--%>
<script>

    $(document).ready(function () {
        m = 0;
        var cmT = $('#example').DataTable({
            "processing": true,
            "searching": true,
            "paging": true,
            "serverSide": true,
            "ajax": {
                "url": "<%=request.getContextPath()%>/costmonitoring/server_side/pagination",
                "data": function (d) {
                    d.locationId = $('#locationId').val();
                    d.postId = $('#postId').val();
                    d.gdvipdate1 = $('#gdvipdate1').val();
                    d.gdvipdate2 = $('#gdvipdate2').val();
                    d.g11 = $('#g11').val();
                    d.g15 = $('#g15').val();
                    d.g34 = $('#g34').val();
                    d.g33 = $('#g33').val();
                    d.g31name = $('#g31name').val();
                    d.g25 = $('#g25').val();
                    d.g8code2 = $('#g8code2').val();
                    d.metod_otc = $('#metod_otc').val();
                    d.g20b = $('#g20b').val();
                    d.g20name = $('#g20name').val();
                    d.g7c = $('#g7c').val();
                }
            },
            <%--ajax: '<%=request.getContextPath()%>/costmonitoring/server_side/pagination',--%>
            "columns": [
                // {"data": "g7a"},
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0,
                    render: function (data, type, row, meta) {
                        var info = cmT.page.info();
                        var len = cmT.page.len();
                        var n = info.page;
                        var k = len * n + m + 1;
                        m++;
                        return k;
                    },
                    "width": "3%"
                },
                {"data": "g7abc"},
                {"data": "g1a"},
                {"data": "g1b"},
                // {"data": "g2name"},
                {
                    data: 'g2name',
                    "targets": 4,
                    render: function (data) {
                        return "<textarea cols='40' rows='1' style='border: none; overflow-y:auto; font-size: 12px; font-family: Arial;' readonly='readonly'>" + data + "</textarea>";
                    }
                },
                {"data": "g33"},
                {"data": "g32"},
                // {"data": "g31name"},
                {
                    data: 'g31name',
                    "targets": 7,
                    render: function (data) {
                        return "<table style='width: 300px'><tr style='border-left: 0; border-right: 0; border-top: 0; border-bottom: 0;'><td style='border-left: 0; border-right: 0; border-top: 0; border-bottom: 0; margin: 0px;'><textarea rows='3' style='border:none; overflow-y:auto; font-size: 12px; font-family: Arial; width: 100%; margin: 0px;' readonly='readonly'>" + data + "</textarea></td></tr></table>";
                    }
                },
                {"data": "g31marka"},
                {"data": "g38"},
                {"data": "g35"},
                {"data": "g45_usd"},
                {"data": "g41name"},
                {"data": "g31amount"},
                {"data": "ves_edizm"},
                {"data": "g34name"},
                {"data": "g15name"},
                {"data": "g11name"},
                {"data": "g25"},
                {"data": "g8code2"},
                {"data": "g45_usd"},
                {"data": "g20b"},
                {"data": "g20name"},
                {"data": "g22a"},
                {"data": "metod_otc"},
                {"data": "g45_edizm_valkont"},
                {"data": "g45usd_edizm"},
                {"data": "g45_index_valkont"},
                {"data": "g45_index"},
                {"data": "gc3date"}
            ]
        });
        console.log("g33 : " + $("#g33").val());
    });
</script>
</body>


