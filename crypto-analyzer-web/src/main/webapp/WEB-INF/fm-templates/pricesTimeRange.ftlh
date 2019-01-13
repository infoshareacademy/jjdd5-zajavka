<#assign selected_time_rege_prices="active">

<#include "header.ftlh"/>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <div class="alert alert-info text-center" role="alert" >Current currency: ${chosenCurrency}</div>
        <canvas class="my-4 chartjs-render-monitor" id="myChart" width="1541" height="650" style="display: block; width: 1541px; height: 650px;"></canvas>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
<#list prices as entry>
<tr>
    <td>${entry.date}</td>
    <td>${entry.price}</td>
</tr>
</#list>
                </tbody>
            </table>
        </div>
    </main>
<#include "footerForChart.ftlh"/>