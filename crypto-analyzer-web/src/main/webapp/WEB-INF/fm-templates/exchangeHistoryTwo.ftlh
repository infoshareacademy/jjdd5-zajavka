<#assign exchange_history_two="active">
<#include "header.ftlh"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4 text-center" >
    <div class="alert alert-info text-center" role="alert">First currency: ${chosenCurrencyOne} </div>
    <div class="alert alert-info text-center" role="alert">Second currency: ${chosenCurrencyTwo}</div>
    <canvas class="my-4 w-100" id="myChart" width="1541" height="650"
            style="display: block; width: 1541px; height: 650px;"></canvas>
    <div class="container">
        <div class="row">
            <div class="col">
    <#if pricesOne??>
        <table class="table table-striped">
            ${chosenCurrencyOne}
            <thead>
            <tr>
                <th scope="col">Data</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <#list pricesOne as entry>
                <tr>
                    <td>${entry.date}</td>
                    <td>
                        $${entry.price}
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
            </div>
            <div class="col">
    <#if pricesTwo??>
        <table class="table table-striped">
            ${chosenCurrencyTwo}
            <thead>
            <tr>
                <th scope="col">Data</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <#list pricesTwo as entry>
                <tr>
                    <td>${entry.date}</td>
                    <td>
                        $${entry.price}
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
            </div>
        </div>
    </div>


</main>

<#include "footerForChartTwo.ftlh">