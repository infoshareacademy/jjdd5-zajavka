<#assign exchange_rate_history="active">
<#include "header.ftlh"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4 text-center">
    <div class="alert alert-info" role="alert">Current currency: ${chosenCurrency}</div>
    <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

    <#if prices??>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Data</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <#list prices as entry>
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
</main>

<#include "footerForChart.ftlh">