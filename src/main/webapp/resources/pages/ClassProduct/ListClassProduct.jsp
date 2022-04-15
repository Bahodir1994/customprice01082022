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

<div class="col-md-12 col-sm-12">
    <div class="x_panel shadow">
        <div class="x_title ">
            <h2><i class="fa fa-bars"></i> Товарларни тоифалаш </h2>
            <div class="clearfix"></div>
        </div>
            <div class="col-md-9">
                <div class="x_content m-0">
                <form class="form-label-left input_mask mt-2">

                    <div class="col-md-10 col-sm-10  form-group has-feedback">
                        <select class="selectpicker" data-width="100%" title="Тоифалаш тури" data-size="5" data-style="border border-primary" data-live-search="true">
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>


                    <div class="form-group row">
                        <div class="col-md-9 col-sm-9  offset-md-3">
                            <button type="submit" class="btn btn-success btn-block">Излаш</button>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <select class="selectpicker" data-width="100%" title="ТИФ ТН код" data-size="5" data-style="border border-primary" data-live-search="true">
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <select class="selectpicker" data-width="100%" title="Ишлаб чиқарувчи мамлакат" data-style="border border-primary" data-size="5" data-live-search="true">
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <select class="selectpicker" data-width="100%"  title="Транспорт тури" data-style="border border-primary" data-size="5" data-live-search="true">
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <select class="selectpicker" multiple data-width="100%" title="Божхона режими" data-style="border border-primary" data-size="5" data-live-search="true">
                            <option data-content="<span class='badge badge-success p-1 text-white'>1) eksport</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>2) reeksport</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>3) vaqtincha olib chiqish</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>4) bojxona hududidan tashqarida qayta ishlash</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>5) erkin muomalaga chiqarish (import)</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>6) reimport</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>7) vaqtincha olib kirish</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>8) bojxona hududida qayta ishlash</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>9) vaqtincha saqlash</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>10) bojxona ombori</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>11) erkin ombor</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>12) erkin bojxona zonasi</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>13) boj olinmaydigan savdo</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>14) bojxona tranziti</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>15) yo‘q qilish</span>"></option>
                            <option data-content="<span class='badge badge-success p-1 text-white'>16) davlat foydasiga voz kechish</span>"></option>
                        </select>
                    </div>

                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <div class="form-group pmd-textfield pmd-textfield-floating-label border border-primary">
                            <input  placeholder="Сана: дан" class="form-control" min="2015-01-01T00:00" max="2025-01-01T00:00" type="text" onfocus="(this.type='datetime-local')" onblur="(this.type='text')" id="date1" />
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <div class="form-group pmd-textfield pmd-textfield-floating-label border border-primary">
                            <input placeholder="Сана: гача" class="form-control" min="2015-01-01T00:00" max="2025-01-01T00:00" type="text" onfocus="(this.type='datetime-local')" onblur="(this.type='text')" id="date2" />
                        </div>
                    </div>

                </form>
                <div class="clearfix"></div>
            </div>
                <div class="x_content m-0">
                <div class="d-inline-block x_panel shadow ">
                        <div class="x_content">
                            <ul class="nav nav-tabs bar_tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Line</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">Aria</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link " id="new-tab" data-toggle="tab" href="#new" role="tab" aria-controls="new" aria-selected="true">Mixed</a>
                                </li>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade p-3" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <canvas id="line-chart" width="800" height="350"></canvas>
                                    <script>
                                        new Chart(document.getElementById("line-chart"), {
                                            type: 'line',
                                            data: {
                                                labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
                                                datasets: [{
                                                    data: [86,114,106,106,107,111,133,221,783,2478],
                                                    label: "Africa",
                                                    borderColor: "#3e95cd",
                                                    fill: false
                                                }, {
                                                    data: [282,350,411,502,635,809,947,1402,3700,5267],
                                                    label: "Asia",
                                                    borderColor: "#8e5ea2",
                                                    fill: false
                                                }, {
                                                    data: [168,170,178,190,203,276,408,547,675,734],
                                                    label: "Europe",
                                                    borderColor: "#3cba9f",
                                                    fill: false
                                                }, {
                                                    data: [40,20,10,16,24,38,74,167,508,784],
                                                    label: "Latin America",
                                                    borderColor: "#e8c3b9",
                                                    fill: false
                                                }, {
                                                    data: [6,3,2,2,7,26,82,172,312,433],
                                                    label: "North America",
                                                    borderColor: "#c45850",
                                                    fill: false
                                                }
                                                ]
                                            },
                                            options: {
                                                title: {
                                                    display: true,
                                                    text: 'World population per region (in millions)'
                                                }
                                            }
                                        });
                                    </script>
                                </div>
                                <div class="tab-pane fade active show p-3" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    <canvas id="htmlLegendsChart" width="800" height="500"></canvas>
                                    <div id="myChartLegend"></div>
                                    <script>
                                        var htmlLegendsChart = document.getElementById('htmlLegendsChart').getContext('2d');

                                        // Chart with HTML Legends

                                        var gradientStroke = htmlLegendsChart.createLinearGradient(500, 0, 100, 0);
                                        gradientStroke.addColorStop(0, '#177dff');
                                        gradientStroke.addColorStop(1, '#80b6f4');

                                        var gradientFill = htmlLegendsChart.createLinearGradient(500, 0, 100, 0);
                                        gradientFill.addColorStop(0, "rgba(23, 125, 255, 0.7)");
                                        gradientFill.addColorStop(1, "rgba(128, 182, 244, 0.3)");

                                        var gradientStroke2 = htmlLegendsChart.createLinearGradient(500, 0, 100, 0);
                                        gradientStroke2.addColorStop(0, '#f3545d');
                                        gradientStroke2.addColorStop(1, '#ff8990');

                                        var gradientFill2 = htmlLegendsChart.createLinearGradient(500, 0, 100, 0);
                                        gradientFill2.addColorStop(0, "rgba(243, 84, 93, 0.7)");
                                        gradientFill2.addColorStop(1, "rgba(255, 137, 144, 0.3)");

                                        var gradientStroke3 = htmlLegendsChart.createLinearGradient(500, 0, 100, 0);
                                        gradientStroke3.addColorStop(0, '#fdaf4b');
                                        gradientStroke3.addColorStop(1, '#ffc478');

                                        var gradientFill3 = htmlLegendsChart.createLinearGradient(500, 0, 100, 0);
                                        gradientFill3.addColorStop(0, "rgba(253, 175, 75, 0.7)");
                                        gradientFill3.addColorStop(1, "rgba(255, 196, 120, 0.3)");

                                        var myHtmlLegendsChart = new Chart(htmlLegendsChart, {
                                            type: 'line',
                                            data: {
                                                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                                datasets: [ {
                                                    label: "Subscribers",
                                                    borderColor: gradientStroke2,
                                                    pointBackgroundColor: gradientStroke2,
                                                    pointRadius: 0,
                                                    backgroundColor: gradientFill2,
                                                    legendColor: '#f3545d',
                                                    fill: true,
                                                    borderWidth: 1,
                                                    data: [154, 184, 175, 203, 210, 231, 240, 278, 252, 312, 320, 374]
                                                }, {
                                                    label: "New Visitors",
                                                    borderColor: gradientStroke3,
                                                    pointBackgroundColor: gradientStroke3,
                                                    pointRadius: 0,
                                                    backgroundColor: gradientFill3,
                                                    legendColor: '#fdaf4b',
                                                    fill: true,
                                                    borderWidth: 1,
                                                    data: [256, 230, 245, 287, 240, 250, 230, 295, 331, 431, 456, 521]
                                                }, {
                                                    label: "Active Users",
                                                    borderColor: gradientStroke,
                                                    pointBackgroundColor: gradientStroke,
                                                    pointRadius: 0,
                                                    backgroundColor: gradientFill,
                                                    legendColor: '#177dff',
                                                    fill: true,
                                                    borderWidth: 1,
                                                    data: [542, 480, 430, 550, 530, 453, 380, 434, 568, 610, 700, 900]
                                                }]
                                            },
                                            options : {
                                                responsive: true,
                                                maintainAspectRatio: false,
                                                legend: {
                                                    display: false
                                                },
                                                tooltips: {
                                                    bodySpacing: 4,
                                                    mode:"nearest",
                                                    intersect: 0,
                                                    position:"nearest",
                                                    xPadding:10,
                                                    yPadding:10,
                                                    caretPadding:10
                                                },
                                                layout:{
                                                    padding:{left:15,right:15,top:15,bottom:15}
                                                },
                                                scales: {
                                                    yAxes: [{
                                                        ticks: {
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "500",
                                                            beginAtZero: false,
                                                            maxTicksLimit: 5,
                                                            padding: 20
                                                        },
                                                        gridLines: {
                                                            drawTicks: false,
                                                            display: false
                                                        }
                                                    }],
                                                    xAxes: [{
                                                        gridLines: {
                                                            zeroLineColor: "transparent"
                                                        },
                                                        ticks: {
                                                            padding: 20,
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "500"
                                                        }
                                                    }]
                                                },
                                                legendCallback: function(chart) {
                                                    var text = [];
                                                    text.push('');
                                                    for (var i = 0; i < chart.data.datasets.length; i++) {
                                                        text.push('');
                                                        if (chart.data.datasets[i].label) {
                                                            text.push(chart.data.datasets[i].label);
                                                        }
                                                        text.push('');
                                                    }
                                                    text.push('');
                                                    return text.join('');
                                                }
                                            }
                                        });

                                        var myLegendContainer = document.getElementById("myChartLegend");



                                        // bind onClick event to all LI-tags of the legend
                                        var legendItems = myLegendContainer.getElementsByTagName('li');
                                        for (var i = 0; i < legendItems.length; i += 1) {
                                            legendItems[i].addEventListener("click", legendClickCallback, false);
                                        }
                                    </script>
                                </div>
                                <div class="tab-pane fade p-3" id="new" role="tabpanel" aria-labelledby="new-tab">
                                    <canvas id="multipleBarChart"></canvas>
                                    <script>
                                        var multipleBarChart = document.getElementById('multipleBarChart').getContext('2d');

                                        var myMultipleBarChart = new Chart(multipleBarChart, {
                                            type: 'bar',
                                            data: {
                                                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                                datasets : [{
                                                    label: "First time visitors",
                                                    backgroundColor: '#59d05d',
                                                    borderColor: '#59d05d',
                                                    data: [95, 100, 112, 101, 144, 159, 178, 156, 188, 190, 210, 245],
                                                },{
                                                    label: "Visitors",
                                                    backgroundColor: '#fdaf4b',
                                                    borderColor: '#fdaf4b',
                                                    data: [145, 256, 244, 233, 210, 279, 287, 253, 287, 299, 312,356],
                                                }, {
                                                    label: "Pageview",
                                                    backgroundColor: '#177dff',
                                                    borderColor: '#177dff',
                                                    data: [185, 279, 273, 287, 234, 312, 322, 286, 301, 320, 346, 399],
                                                }],
                                            },
                                            options: {
                                                responsive: true,
                                                maintainAspectRatio: false,
                                                legend: {
                                                    position : 'bottom'
                                                },
                                                title: {
                                                    display: true,
                                                    text: 'Traffic Stats'
                                                },
                                                tooltips: {
                                                    mode: 'index',
                                                    intersect: false
                                                },
                                                responsive: true,
                                                scales: {
                                                    xAxes: [{
                                                        stacked: true,
                                                    }],
                                                    yAxes: [{
                                                        stacked: true
                                                    }]
                                                }
                                            }
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            </div>
            <div class="col-md-3 ">
                <div class="x_panel shadow">
                    <div class="x_title">
                        <h2>Қозоғистон<small>индекс -65%</small></h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <div class="table-responsive " style="height: 35vh">
                            <table class="table table-sm table-striped jambo_table bulk_action ">
                                <thead class="bg-gradient border-primary ">
                                <tr>
                                    <th class="column-title" colspan="3">
                                        Нарҳ пасайиши бўйича
                                        <span class='badge badge-danger p-1 text-white'>
                                            <i class="fa fa-caret-down fa-2x ml-2 mr-2"></i>
                                        </span>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class=" ">1</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">2</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">3</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">4</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">5</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">6</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">7</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">8</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">9</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">10</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">-75%<i class="fa fa-long-arrow-down" style="color:red"></i></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="x_title">
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <div class="table-responsive overflow-scroll" style="height: 35vh">
                            <table class="table table-sm table-striped jambo_table bulk_action ">
                                <thead class="bg-gradient border-primary">
                                <tr>
                                    <th class="column-title" colspan="3">
                                        Нарҳ кўтарилиши бўйича
                                        <span class='badge badge-success p-1 text-white'>
                                            <i class="fa fa-caret-up fa-2x ml-2 mr-2"></i>
                                        </span>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class=" ">1</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">2</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">3</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">4</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">5</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">6</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">7</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">8</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">9</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                <tr>
                                    <td class=" ">10</td>
                                    <td class=" ">26002/11.10.2021/0001177</td>
                                    <td class=" ">+65%<i class="fa fa-long-arrow-up" style="color:green"></i></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>

</body>



