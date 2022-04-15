<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 22.02.2022
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="step2" class="shadow p-3 mb-5 bg-white rounded x_panel">
    <div class="x_title ">
        <h2>Товар таснифи<small>2-қадам</small></h2>
        <div class="clearfix"></div>
    </div>
    <fieldset class="border-primary" style="border-style: dashed solid">
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
    </fieldset>

</div>

</body>
</html>
