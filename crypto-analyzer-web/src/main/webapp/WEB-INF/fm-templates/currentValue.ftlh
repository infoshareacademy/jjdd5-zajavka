<#assign current_value="active">

<#include "header.ftlh"/>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">


            <div class="p-3 mb-2 bg-info text-white">${chosenCurrency}</div>

<#if DailyDataDate??>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Data</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${DailyDataDate}</td>
                    <td>${DailyDataPrice}</td>
                </tr>
                </tbody>
            </table>
</#if>

<#include "footer.ftlh"/>