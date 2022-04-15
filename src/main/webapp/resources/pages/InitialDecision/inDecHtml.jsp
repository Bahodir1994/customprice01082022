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

<html>
<head>
    <style>
        #ModalWin5DeclPart .positionImg {
            background-repeat: no-repeat;
            background-position: 100% 100%;
            background-size: 50% 50%;
        }

        div.transbox {
            background-color: #ffffff;
            opacity: 0.92;
            color: black;
        }

        .fa-print {
            filter: drop-shadow(6px 6px 1px #e2ebf3);
            cursor: pointer;
        }

        .fa-circle-question {
            filter: drop-shadow(6px 6px 1px #cfdce7);
            cursor: pointer;
        }

        .gradus2q-90 {
            transform: translate(30px, 20px) rotate(270deg);
            width: 500px;
            height: 30px;
            margin-top: 200px;
            margin-left: -240px;
            margin-right: -250px;
            /*transform: rotate(0.75turn);*/
            /*-ms-transform: rotate(270deg); !* IE 9 *!*/
            /*-webkit-transform: rotate(270deg); !* Chrome, Safari, Opera *!*/
            /*transform: rotate(270deg);*/
            /*width: 100%;*/
            /*margin-top: 20px;*/
        }
    </style>
</head>
<body>
<form>
    <ul class="nav nav-pills navP5">
        <li class="nav-item border-right shadow-lg f-w-600" style="width: 35%; text-align: center; margin-left: 1px"
            id="step5Tab1">
            <a href="#tabDecl" class="nav-link rounded-0 has-ripple active" data-toggle="tab">

                <span class="ripple ripple-animate"
                      style="height: 74.2812px; width: 74.2812px; animation-duration: 0.7s; animation-timing-function: linear;  opacity: 0.4; top: -13.5078px; left: 19.8672px;"></span>
            </a>
        </li>
        <li class="nav-item border-right shadow-lg f-w-600" style="width: 35%; text-align: center; margin-left: 1px"
            id="step5Tab2">
            <a href="#tabDeclTovar" onclick="getAllCommodityDNew()" class="nav-link rounded-0 has-ripple" data-toggle="tab">
                <span class="ripple ripple-animate"
                      style="height: 74.2812px; width: 74.2812px; animation-duration: 0.7s; animation-timing-function: linear;  opacity: 0.4; top: -13.5078px; left: 19.8672px;"></span>
            </a>
        </li>
    </ul>
    <div class="pt-1 bg-primary"></div>
    <div class="tab-content card shadow-none p-t-5 p-l-5 p-r-5 p-b-5 rounded">
        <div class="tab-pane pt-1 show active" id="tabDecl">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10 col-sm-12 col-xs-10 invoice-client-info">
                    <fieldset class="form-group fieldsetC p-3 shadow">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 text-muted f-20 f-w-600">
                                <i class="fa-duotone fa-barcode-scan fa-1x"></i>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-10">
                                <p class="text-center ml-5" style="font-size: 22px">
                                    Ўзбекистон Республикасига олиб кириладиган товарлар бўйича тўланиши лозим бўлган божхона тўловлари миқдорини аниқлаш бўйича<br>ДАСТЛАБКИ ҚАРОР
                                </p>
                            </div>
                            <div class="col-md-2">
                                <img src="data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 448 512'%3e%3cpath fill='%23000000' d='M0 224h192V32H0v192zM64 96h64v64H64V96zm192-64v192h192V32H256zm128 128h-64V96h64v64zM0 480h192V288H0v192zm64-128h64v64H64v-64zm352-64h32v128h-96v-32h-32v96h-64V288h96v32h64v-32zm0 160h32v32h-32v-32zm-64 0h32v32h-32v-32z'/%3e%3c/svg%3e" alt="qr" width="100" height="100">
                            </div>
                            <div class="col-md-12 col-sm-12" style="min-width:300px; overflow-x: auto">
                                <style type="text/css">
                                    .tg  {border-collapse:collapse;border-color:#ccc;border-spacing:0;}
                                    .tg td{background-color:#fff;border-color:#ccc;border-style:solid;border-width:1px;color:#333;
                                        font-family:Arial, sans-serif;font-size:12px;overflow:hidden;padding:10px 5px;word-break:normal;}
                                    .tg th{background-color:#f0f0f0;border-color:#ccc;border-style:solid;border-width:1px;color:#333;
                                        font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
                                    .tg .tg-oi4f{background-color:#efefef;border-color:inherit;font-family:"Times New Roman", Times, serif !important;font-size:16px;
                                        text-align:left;vertical-align:top}
                                    .tg .tg-aboz{border-color:inherit;font-family:"Times New Roman", Times, serif !important;font-size:16px;text-align:left;
                                        vertical-align:top}
                                    .tg .tg-pias{background-color:#ffffff;border-color:inherit;font-family:"Times New Roman", Times, serif !important;font-size:16px;
                                        text-align:left;vertical-align:top}
                                </style>
                                <table class="tg table-sm table-responsive" style="undefined; table-layout: fixed; width: 100%">
                                    <colgroup>
                                        <col style="width: 50%">
                                        <col style="width: 70%">
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th scope="col">1. Дастлабки қарорни рўйхатга олиш рақами ва санаси</th>
                                        <th scope="col">авқвпавпақв</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td class="tg-oi4f">2. Дастлабки қарорни қабул қилган божхона органининг номи</td>
                                        <td class="tg-aboz">авқпқвапқавп</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">3. Манфаатдор шахс</td>
                                        <td class="tg-aboz">вақпавқпқавп</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">4. Дастлабки қарорнинг амал қилиш муддати</td>
                                        <td class="tg-aboz">авқпвақпқав</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">5. Товарнинг ТИФ ТН коди</td>
                                        <td class="tg-aboz">авқпвқапавп</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f" colspan="2">
                                            6. Товарлар номи ва тавсифи
                                            <br>
                                            <span style="font-style:italic">
                                            1. Тижорат номи</span><br><span style="font-style:italic">
                                            2. Савдо белгиси</span><br><span style="font-style:italic">
                                            3. Маркаси</span><br><span style="font-style:italic">
                                            4. Модели</span><br><span style="font-style:italic">
                                            5. Артикули</span><br><span style="font-style:italic">
                                            6. Нави</span><br><span style="font-style:italic">
                                            7. Стандарти</span><br><span style="font-style:italic">
                                            8. Ранги</span><br><span style="font-style:italic">
                                            9. Фойдаланиш мақсади</span><br><span style="font-style:italic">
                                            10. Тижорат хцусусияти</span><br><span style="font-style:italic">
                                            11. Техник хусусияти</span><br><span style="font-style:italic">
                                            12. Юк жойларининг умумий сони</span><br><span style="font-style:italic">
                                            13. Ўрам тури</span><br><span style="font-style:italic">
                                            14. Урамлар сони</span><br><span style="font-style:italic">
                                            15. Қўшимча маълумотлар</span><br><span style="font-style:italic">
                                            16. Илгари қабул қилинган дастлабки қарор</span><br><span style="font-style:italic">
                                            17. Товарнинг етказиб бериш шарти</span><br><span style="font-style:italic">
                                            18. Транспорт тури</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">7. Товарларнинг божхона қийматини аниқлаш усули ва уни асослаш</td>
                                        <td class="tg-aboz">қвақвақвавфа</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">8. Товарларнингкелиб чиқиш мамлакати ва уни асослаш</td>
                                        <td class="tg-aboz">фқвақвфафқвақвфақва</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-pias" colspan="2">
                                            9. Божхона тўловлари ва йиғимлари тўғрисида маълумот
                                            <br>
                                            <div class="row justify-content-center">
                                                <span style="font-style:italic; margin-left: auto; margin-right: auto">
                                                    Божхона тўловлари ставкаси
                                                    <table class="tg">
                                                        <thead>
                                                              <tr>
                                                                <th class="tg-kftd">Божхона тўловлари тури</th>
                                                                <th class="tg-kftd">Ставкаси</th>
                                                                <th class="tg-kftd">Хуқуқий асоси</th>
                                                              </tr>
                                                        </thead>
                                                        <tbody>
                                                              <tr>
                                                                <td class="tg-0lax">10- Йиғими</td>
                                                                <td class="tg-0lax">БҲМ - 1.5</td>
                                                                <td class="tg-0lax">ПКМ №700 от 09.11.2020 г</td>
                                                              </tr>
                                                              <tr>
                                                                <td class="tg-0lax">20-Божхона божи</td>
                                                                <td class="tg-0lax">5%</td>
                                                                <td class="tg-0lax">29.06.2018 г. № ПП-3818</td>
                                                              </tr>
                                                              <tr>
                                                                <td class="tg-0lax">27-Аксиз</td>
                                                                <td class="tg-0lax">12%</td>
                                                                <td class="tg-kftd">29.06.2018 г. № ПП-3818 </td>
                                                              </tr>
                                                        </tbody>
                                                        </table>
                                                </span>
                                            </div>
                                            <br>
                                            <span style="font-style:italic">
                                                <div class="col-md-6">
                                                    Божхона тўловлари миқдори
                                                    <table class="tg">
                                            <thead>
                                                  <tr>
                                                    <th class="tg-kftd">Божхона тўловлари тури</th>
                                                    <th class="tg-kftd">Хисоблаш учун асос</th>
                                                    <th class="tg-kftd">Хисобланди</th>
                                                  </tr>
                                            </thead>
                                            <tbody>
                                                  <tr>
                                                    <td class="tg-ycr8">10- Йиғими</td>
                                                    <td class="tg-ycr8">123 123 120,10</td>
                                                    <td class="tg-ycr8"></td>
                                                  </tr>
                                                  <tr>
                                                    <td class="tg-ycr8">20-Божхона божи</td>
                                                    <td class="tg-ycr8"></td>
                                                    <td class="tg-ycr8"></td>
                                                  </tr>
                                                  <tr>
                                                    <td class="tg-ycr8">27-Аксиз</td>
                                                    <td class="tg-ycr8"></td>
                                                    <td class="tg-ycr8"></td>
                                                  </tr>
                                                  <tr>
                                                    <td class="tg-ycr8" colspan="2">Жами</td>
                                                    <td class="tg-ycr8">236 325 652 сўм</td>
                                                  </tr>
                                            </tbody>
                                            </table>
                                                </div>
                                                <div class="col-md-6">
                                                    Божхона тўловлари имтиёзли (преференсия) миқдори
                                                    <table class="tg">
                                                    <thead>
                                                          <tr>
                                                            <th class="tg-kftd">Божхона тўлов. тури</th>
                                                            <th class="tg-kftd">Хисоблаш асоси</th>
                                                            <th class="tg-kftd">Хисобланди</th>
                                                            <th class="tg-0lax">Хуқуқий асос</th>
                                                          </tr>
                                                    </thead>
                                                    <tbody>
                                                          <tr>
                                                            <td class="tg-ycr8">10- Йиғими</td>
                                                            <td class="tg-ycr8">123 123 120,10</td>
                                                            <td class="tg-ycr8"></td>
                                                            <td class="tg-0lax"></td>
                                                          </tr>
                                                          <tr>
                                                            <td class="tg-ycr8">20-Божхона божи</td>
                                                            <td class="tg-ycr8"></td>
                                                            <td class="tg-ycr8"></td>
                                                            <td class="tg-0lax"></td>
                                                          </tr>
                                                          <tr>
                                                            <td class="tg-ycr8">27-Аксиз</td>
                                                            <td class="tg-ycr8"></td>
                                                            <td class="tg-ycr8"></td>
                                                            <td class="tg-0lax"></td>
                                                          </tr>
                                                          <tr>
                                                            <td class="tg-ycr8" colspan="3">Жами</td>
                                                            <td class="tg-ktyi">236 325 652 сўм</td>
                                                          </tr>
                                                    </tbody>
                                                </table>
                                                </div>
                                            </span>
                                            <br><br><br><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">10. Дастлабки қарорни қабул қилиш асослари</td>
                                        <td class="tg-aboz">қвавқавқфақвфақвфақв</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-pias" colspan="2">
                                            11. Манфаатдор шахс томонидан тақдим қилинган маълумотлар ва хужжатлар рўйхати
                                            <table class="tg">
                                                <thead>
                                                <tr>
                                                    <th class="tg-yj5y">Тартиб рақами</th>
                                                    <th class="tg-yj5y">Хужжат тури</th>
                                                    <th class="tg-yj5y">ХисобландиХужжат рақами</th>
                                                    <th class="tg-c3ow">Хужжат санаси</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td class="tg-3xi5">1</td>
                                                    <td class="tg-3xi5">220-ИНВ</td>
                                                    <td class="tg-3xi5">ИН-6534</td>
                                                    <td class="tg-c3ow">02.02.2022й</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">12. Қўшимча маълумотлар</td>
                                        <td class="tg-aboz">фқвақфвавқфақвфавқфа</td>
                                    </tr>
                                    <tr>
                                        <td class="tg-oi4f">13. Божхона органининг мансабдор шахси                                                                                                     <br><br>      <span style="font-weight:bold">Бошқарма бошлиғи:</span>  А. А. Абдуллаев<br></td>
                                        <td class="tg-aboz"><img src="data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 448 512'%3e%3cpath fill='%23000000' d='M0 224h192V32H0v192zM64 96h64v64H64V96zm192-64v192h192V32H256zm128 128h-64V96h64v64zM0 480h192V288H0v192zm64-128h64v64H64v-64zm352-64h32v128h-96v-32h-32v96h-64V288h96v32h64v-32zm0 160h32v32h-32v-32zm-64 0h32v32h-32v-32z'/%3e%3c/svg%3e" alt="qr" width="100" height="100"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="col-md-1">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 f-20 text-right">
                            <a href="../railway/declaration/pdf/generationGtd/" target="_blank">
                                <i class="fa-solid fa-print text-info f-24"></i>
                            </a>&nbsp;&nbsp;
                            <%--                            <i class="fa-solid fa-print text-info f-24" onclick="win5DeclPdfNew('1', 'cd835170-9b71-4e39-b0a0-4fe745a438df', 'eee6daf7-68ef-4e5a-b818-8edec2b553da')" ></i>&nbsp;&nbsp;--%>
                            <i class="fa-solid fa-circle-question text-info f-24"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane pt-1" id="tabDeclTovar">
            <fieldset class="form-group fieldsetC mb-0 p-2 pb-3">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="row">
                            <div class="col-md-6 col-sm-12 text-muted f-20 f-w-600">

                            </div>
                            <div class="col-md-6 col-sm-12 f-20 text-right">
                                <i class="fa-solid fa-print text-info f-24"
                                   onclick=""></i>&nbsp;&nbsp;
                                <i class="fa-solid fa-circle-question text-info f-24"></i>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col-sm-12">
                                <div class="dt-responsive table-responsive">
                                </div>
                            </div>
                        </div>



                    </div>
                </div>
            </fieldset>
        </div>
    </div>
    <div class="modal fade" id="ModalWin5DeclPart" tabindex="-1" role="dialog" aria-labelledby="ModalWin5DeclPartLabel" aria-hidden="true"></div>
</form>
</body>

</html>
