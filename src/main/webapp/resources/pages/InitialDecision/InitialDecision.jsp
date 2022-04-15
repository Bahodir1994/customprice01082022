<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06.02.2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<body>
<div >
    <div class="clearfix"></div>
    <div class="row">
        <div class="col-md-12">
            <div class="x_panel" style="min-height: 850px">

                <div class="x_content">
                    <ul class="nav nav-tabs bar_tabs" id="myTab" role="tablist">
                        <li class="nav-item ml-4" style="width: 47%">
                            <a class="nav-link active h4" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"><i class="fa fa-folder-open mr-3"></i>Мурожаатлар</a>
                        </li>
                        <li class="nav-item" style="width: 47%">
                            <a class="nav-link h4" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"><i class="fa fa-folder-open mr-3"></i>Дастлабки
                                қарор реестри</a>
                        </li>
                    </ul>
                    <div class="x_title">

                        <div class="clearfix"></div>
                    </div>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive mt-4">
                                            <!--<p class="text-muted font-13 m-b-30">
                                            The Buttons extension for DataTables provides a common set of options, API methods and styling to display buttons on a page that will interact with a DataTable. The core library provides the based framework upon which plug-ins can built.
                                            </p>-->
                                            <table id="example1" class="table table-striped table-bordered border-primary table-sm" style="width:100%; border-style: dashed solid">
                                                <thead class="bg-gradient text-black" style="background-color: #0d81fe;">
                                                <tr>
                                                    <th style="border-style: dotted">т/р</th>
                                                    <th style="border-style: dotted">Ариза рақами</th>
                                                    <th style="border-style: dotted">Мақоми</th>
                                                    <th style="border-style: dotted">Ариза санаси</th>
                                                    <th style="border-style: dotted">Мафаатдор шахс</th>
                                                    <th style="border-style: dotted">Савдо қилувчи</th>
                                                    <th style="border-style: dotted">Сотувчи мамлакат</th>
                                                    <th style="border-style: dotted">Кимга тақсимланган</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="appInsp" items="${appsForInspector}" varStatus="i">
                                                    <tr>
                                                        <td>${i.index+1}</td>
                                                        <td><a href="javascript:InitialDecisionView('${appInsp[0]}')"
                                                               class="text-primary font-weight-bold"><u>${appInsp[6]}</u></a></td>
                                                        <td>${appInsp[28]}</td>
                                                        <td>${appInsp[1]}</td>
                                                        <td>${appInsp[14]}</td>
                                                        <td>${appInsp[9]}-${appInsp[8]}</td>
                                                        <td>${appInsp[21]}-${appInsp[22]}</td>
                                                        <td>${appInsp[30]}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <script>
                                                $(document).ready(function () {
                                                    $('#example1').DataTable({
                                                        "language": {
                                                            "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",
                                                            "infoFiltered": "(_MAX_ та маълумот сараланди)",
                                                            "infoEmpty": "Маълумотлар топилмади",
                                                            "info": "Жами _PAGES_ та, _PAGE_-сахифа ",
                                                            "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",
                                                            "Show": "Кўрсатилмоқда",
                                                            "search": "Излаш",
                                                            "paginate": {
                                                                "next": "Кейинги",
                                                                "previous": "Олдинги",
                                                            }
                                                        }
                                                    });
                                                });
                                                $(document).ready(function () {
                                                    $('#example2').DataTable({
                                                        "language": {
                                                            "zeroRecords": "Сиз излаган маълумот мавжуд эмас!",
                                                            "infoFiltered": "(_MAX_ та маълумот сараланди)",
                                                            "infoEmpty": "Маълумотлар топилмади",
                                                            "info": "Жами _PAGES_ та, _PAGE_-сахифа ",
                                                            "lengthMenu": "Кўрсатилмоқда _MENU_ та ариза",
                                                            "Show": "Кўрсатилмоқда",
                                                            "search": "Излаш",
                                                            "paginate": {
                                                                "next": "Кейинги",
                                                                "previous": "Олдинги",
                                                            }
                                                        }
                                                    });
                                                });
                                            </script>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive mt-4">
                                            <!--<p class="text-muted font-13 m-b-30">
                                            KeyTable provides Excel like cell navigation on any table. Events (focus, blur, action etc) can be assigned to individual cells, columns, rows or all cells.
                                            </p>-->
                                            <table id="example2" class="table table-striped table-bordered border-primary table-sm" style="width:100%; border-style: dashed solid">
                                                <thead class="bg-gradient text-white text-lg-center" style="background-color: #0d81fe;">
                                                <tr>
                                                    <th style=" border-style: dotted">т/р</th>
                                                    <th style=" border-style: dotted">Ариза рақами</th>
                                                    <th style=" border-style: dotted">Холати</th>
                                                    <th style=" border-style: dotted">Ариза санаси</th>
                                                    <th style=" border-style: dotted">Манфаатдор шахс</th>
                                                    <th style=" border-style: dotted">Қарор рақами</th>
                                                    <th style=" border-style: dotted">Қарор санаси</th>
                                                    <th style=" border-style: dotted">Амал қилиш муддати</th>
                                                    <th style=" border-style: dotted">Шартнома ёки товарни етказиб бериш асоси</th>
                                                    <th style=" border-style: dotted">Товар коди ТИФ ТН</th>
                                                    <th style=" border-style: dotted">Товар қисқача номи</th>
                                                    <th style=" border-style: dotted">Усул</th>
                                                    <th style=" border-style: dotted">Бекор қилиш санаси</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td><a href="#" class="text-primary font-weight-bold"><u>00012457</u></a></td>
                                                    <td class="text-success font-weight-bold">Амалда</td>
                                                    <td>29.11.2021</td>
                                                    <td>"BEST TRADE" МЧЖ</td>
                                                    <td>26/0001</td>
                                                    <td>30.02.2022</td>
                                                    <td>30.05.2022</td>
                                                    <td>200197141300121555120200001</td>
                                                    <td>4011100000</td>
                                                    <td>Michelin автомабил шиналари</td>
                                                    <td>1</td>
                                                    <td>-</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td><a href="#" class="text-primary font-weight-bold"><u>00012457</u></a></td>
                                                    <td class="text-success font-weight-bold">Бекор қилинган</td>
                                                    <td>29.11.2021</td>
                                                    <td>"BEST TRADE" МЧЖ</td>
                                                    <td>26/0001</td>
                                                    <td>30.02.2022</td>
                                                    <td>30.02.2022</td>
                                                    <td>200197141300121555120200001</td>
                                                    <td>4011100000</td>
                                                    <td>Michelin автомабил шиналари</td>
                                                    <td>1</td>
                                                    <td>-</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td><a href="#" class="text-primary font-weight-bold"><u>00012457</u></a></td>
                                                    <td class="text-success font-weight-bold">Муддати тугаган</td>
                                                    <td>29.11.2021</td>
                                                    <td>"BEST TRADE" МЧЖ</td>
                                                    <td>26/0001</td>
                                                    <td>30.02.2022</td>
                                                    <td>30.02.2022</td>
                                                    <td>200197141300121555120200001</td>
                                                    <td>4011100000</td>
                                                    <td>Michelin автомабил шиналари</td>
                                                    <td>1</td>
                                                    <td>-</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>