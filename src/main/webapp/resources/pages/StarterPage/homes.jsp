<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.03.2022
  Time: 11:27
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
    <link rel="icon" href="<%=request.getContextPath()%>/resources/assets2/images/favicon-32x32.png" type="image/png" />
    <!--plugins-->
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/highcharts/css/highcharts.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets2/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
    <!-- loader-->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/pace.min.css" rel="stylesheet" />
    <script src="<%=request.getContextPath()%>/resources/assets2/js/pace.min.js"></script>
    <!-- Bootstrap CSS -->
    <link href="<%=request.getContextPath()%>/resources/assets2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/app.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets2/css/icons.css" rel="stylesheet">
    <!-- Theme Style CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/dark-theme.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/semi-dark.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets2/css/header-colors.css" />
    <style>
        .highcharts-figure,
        .highcharts-data-table table {
            min-width: 320px;
            max-width: 800px;
            margin: 1em auto;
        }

        .highcharts-title{
            "color": "#333333", "fontSize": "18px"
        }

        .highcharts-data-table table {
            font-family: Verdana, sans-serif;
            border-collapse: collapse;
            border: 1px solid #ebebeb;
            margin: 10px auto;
            text-align: center;
            width: 100%;
            max-width: 500px;
        }

        .highcharts-data-table caption {
            padding: 1em 0;
            font-size: 1.2em;
            color: #ffffff;
        }

        .highcharts-data-table th {
            font-weight: 600;
            padding: 0.5em;
        }

        .highcharts-data-table td,
        .highcharts-data-table th,
        .highcharts-data-table caption {
            padding: 0.5em;
        }

        .highcharts-data-table thead tr,
        .highcharts-data-table tr:nth-child(even) {
            background: #eeeeee;
        }

        .highcharts-data-table tr:hover {
            background: #f1f7ff;
        }

        input[type="number"] {
            min-width: 50px;
        }
    </style>
    <style>
        #containerValyut {
            height: 400px;
            min-width: 310px;
        }

        #container {
            height: 400px;
        }

        .highcharts-figure,
        .highcharts-data-table table {
            min-width: 310px;
            max-width: 800px;
            margin: 1em auto;
        }

        .highcharts-data-table table {
            font-family: Verdana, sans-serif;
            border-collapse: collapse;
            border: 1px solid #ebebeb;
            margin: 10px auto;
            text-align: center;
            width: 100%;
            max-width: 500px;
        }

        .highcharts-data-table caption {
            padding: 1em 0;
            font-size: 1.2em;
            color: #555;
        }

        .highcharts-data-table th {
            font-weight: 600;
            padding: 0.5em;
        }

        .highcharts-data-table td,
        .highcharts-data-table th,
        .highcharts-data-table caption {
            padding: 0.5em;
        }

        .highcharts-data-table thead tr,
        .highcharts-data-table tr:nth-child(even) {
            background: #f8f8f8;
        }

        .highcharts-data-table tr:hover {
            background: #f1f7ff;
        }
    </style>
    <style>
        #containerMini {
            height: 400px;
        }

        .highcharts-figure,
        .highcharts-data-table table {
            min-width: 310px;
            max-width: 800px;
            margin: 1em auto;
        }

        #sliders td input[type="range"] {
            display: inline;
        }

        #sliders td {
            padding-right: 1em;
            white-space: nowrap;
        }
    </style>
</head>
<body>
<div class="page-wrapper">
    <div class="page-content">

        <div class="dash-wrapper bg-gradient-moonlit">
            <div class="row row-cols-1 row-cols-md-2 row-cols-xl-5 row-cols-xxl-5">
                <div class="col border-end border-light-2">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-white">Халқаро сўровномалар (Камомад суммаси)</p>
                            <h3 class="mb-3 text-white">14.72 $</h3>
                            <p class="font-13 text-white"><span class="text-success"><i class="lni lni-arrow-up"></i>2.1%</span> охирги 7 кунда</p>
                            <div id="chart1"></div>
                        </div>
                    </div>
                </div>
                <div class="col border-end border-light-2">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-white">Дастлабки қарорлар сони</p>
                            <h3 class="mb-3 text-white">2 та</h3>
                            <p class="font-13 text-white"><span class="text-success"><i class="lni lni-arrow-up"></i> 4.2% </span> охирги 7 кунда</p>
                            <div id="chart2"></div>
                        </div>
                    </div>
                </div>
                <div class="col border-end border-light-2">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-white">Фойдаланувчилар сони</p>
                            <h3 class="mb-3 text-white">48 та</h3>
                            <p class="font-13 text-white"><span class="text-danger"><i class="lni lni-arrow-down"></i> 3.6%</span> охирги 7 кунда</p>
                            <div id="chart3"></div>
                        </div>
                    </div>
                </div>
                <div class="col border-end border-light-2">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-white">Шартли белгиланган товарлар</p>
                            <h3 class="font-22 mb-3 text-white">408 729 503,39 сўм</h3>
                            <p class="font-13 text-white"><span class="text-success"><i class="lni lni-arrow-up"></i> 2.5%</span> охирги 7 кунда</p>
                            <div id="chart4"></div>
                        </div>
                    </div>
                </div>
                <div class="col col-md-12">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-white">Дастурдан фойдаланиш вақтингиз</p>
                            <h3 class="mb-3 text-white">00:04:60</h3>
                            <p class="font-13 text-white"><span class="text-danger"><i class=""></i> Эслатма</span> Фойдаланиш вақти 10 дақиқа</p>
                            <%--                            <div id="chart5"></div>--%>
                        </div>
                    </div>
                </div>
            </div> <!-- end row-->
        </div>

        <div class="row row-cols-1 row-cols-xl-2">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="col d-flex">
                            <div class="card radius-10 w-100" >
                                <div class="card-body">
                                    <div id="container"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="col d-flex">
                            <div class="card radius-10 w-100">
                                <div class="card-body">
                                    <div id="container2"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="position-absolute top-50 start-0 translate-middle-y btn btn-outline-primary btn-sm m-2" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <i class="bx bx-chevron-left"></i>
                </button>
                <button class="position-absolute top-50 end-0 translate-middle-y btn btn-outline-primary btn-sm m-2" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <i class="bx bx-chevron-right"></i>
                </button>
            </div>
            <div id="carouselExampleControls2" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                        <div class="col d-flex">
                            <div class="card radius-10 w-100" >
                                <div class="card-body">
                                    <div id="container3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="20000">
                        <div class="col d-flex">
                            <div class="card radius-10 w-100">
                                <div class="card-body">
                                    <div id="container4"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="position-absolute top-50 start-0 translate-middle-y btn btn-outline-primary btn-sm m-2" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="prev">
                    <i class="bx bx-chevron-left"></i>
                </button>
                <button class="position-absolute top-50 end-0 translate-middle-y btn btn-outline-primary btn-sm m-2" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="next">
                    <i class="bx bx-chevron-right"></i>
                </button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 d-flex">
                <div class="card radius-10 p-0 w-100 bg-transparent shadow-none">
                    <div class="card radius-10">
                        <div class="card-body">
                            <div id="containerValyut"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    Highcharts.chart('container', {
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45
            }
        },
        title: {
            text: 'Contents of Highsoft\'s weekly fruit delivery'
        },
        subtitle: {
            text: '3D donut in Highcharts'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            name: 'Delivered amount',
            data: [
                ['Bananas', 8],
                ['Kiwi', 3],
                ['Mixed nuts', 1],
                ['Oranges', 6],
                ['Apples', 8],
                ['Pears', 4],
                ['Clementines', 4],
                ['Reddish (bag)', 1],
                ['Grapes (bunch)', 1]
            ]
        }]
    });
</script>
<script>
    Highcharts.chart('container2', {
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45
            }
        },
        title: {
            text: 'Contents of Highsoft\'s weekly fruit delivery'
        },
        subtitle: {
            text: '3D donut in Highcharts'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            name: 'Delivered amount',
            data: [
                ['Bananas', 8],
                ['Kiwi', 3],
                ['Mixed nuts', 1],
                ['Oranges', 6],
                ['Apples', 8],
                ['Pears', 4],
                ['Clementines', 4],
                ['Reddish (bag)', 1],
                ['Grapes (bunch)', 1]
            ]
        }]
    });
</script>
<script>
    Highcharts.chart('container3', {
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45
            }
        },
        title: {
            text: 'Contents of Highsoft\'s weekly fruit delivery'
        },
        subtitle: {
            text: '3D donut in Highcharts'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            name: 'Delivered amount',
            data: [
                ['Bananas', 8],
                ['Kiwi', 3],
                ['Mixed nuts', 1],
                ['Oranges', 6],
                ['Apples', 8],
                ['Pears', 4],
                ['Clementines', 4],
                ['Reddish (bag)', 1],
                ['Grapes (bunch)', 1]
            ]
        }]
    });
</script>
<script>
    Highcharts.chart('container4', {
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45
            }
        },
        title: {
            text: 'Contents of Highsoft\'s weekly fruit delivery'
        },
        subtitle: {
            text: '3D donut in Highcharts'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            name: 'Delivered amount',
            data: [
                ['Bananas', 8],
                ['Kiwi', 3],
                ['Mixed nuts', 1],
                ['Oranges', 6],
                ['Apples', 8],
                ['Pears', 4],
                ['Clementines', 4],
                ['Reddish (bag)', 1],
                ['Grapes (bunch)', 1]
            ]
        }]
    });
</script>
<script>
    Highcharts.chart('containerValyut', {

        title: {
            text: 'Solar Employment Growth by Sector, 2010-2016'
        },

        subtitle: {
            text: 'Source: thesolarfoundation.com'
        },

        yAxis: {
            title: {
                text: 'Number of Employees'
            }
        },

        xAxis: {
            accessibility: {
                rangeDescription: 'Range: 2020 to 2021'
            }
        },

        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },

        plotOptions: {
            series: {
                label: {
                    connectorAllowed: false
                },
                pointStart: 2020
            }
        },

        series: [{
            name: 'Dollar $',
            data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
        }, {
            name: 'Manufacturing',
            data: [10500, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
        }, {
            name: 'Sales & Distribution',
            data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
        }, {
            name: 'Project Development',
            data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
        }, {
            name: 'Other',
            data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
        }],

        responsive: {
            rules: [{
                condition: {
                    maxWidth: 5
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }

    });
</script>
<script>
    // Set up the chart
    const chart = new Highcharts.Chart({
        chart: {
            renderTo: 'containerMini',
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 15,
                beta: 15,
                depth: 50,
                viewDistance: 25
            }
        },
        title: {
            text: 'Chart rotation demo'
        },
        subtitle: {
            text: 'Test options by dragging the sliders below'
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        series: [{
            data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }]
    });

    function showValues() {
        document.getElementById('alpha-value').innerHTML = chart.options.chart.options3d.alpha;
        document.getElementById('beta-value').innerHTML = chart.options.chart.options3d.beta;
        document.getElementById('depth-value').innerHTML = chart.options.chart.options3d.depth;
    }

    // Activate the sliders
    document.querySelectorAll('#sliders input').forEach(input => input.addEventListener('input', e => {
        chart.options.chart.options3d[e.target.id] = parseFloat(e.target.value);
        showValues();
        chart.redraw(false);
    }));

    showValues();
</script>
<script src="<%=request.getContextPath()%>/resources/assets2/js/index.js"></script>
</body>
</html>
