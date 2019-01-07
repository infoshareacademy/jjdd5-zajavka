<#assign exchange_rate_history="active">
<#include "header.ftlh"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">


    <div class="p-3 mb-2 bg-info text-white">${chosenCurrency}</div>

    <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

<#if DailyDatas??>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Data</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <#list DailyDatas as DailyData>
        <tr>
            <td>${DailyData.date}</td>
            <td >
            ${DailyData.strPriceUSD}
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

</#if>
</main>

<#include "footerForChart.ftlh">