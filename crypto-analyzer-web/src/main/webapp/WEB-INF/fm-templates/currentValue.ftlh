<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">


            <div class="p-3 mb-2 bg-info text-white">${chosenCurrency}</div>

<#if DailyData??>
    <div class="p-3 mb-2 bg-info text-white">${DailyData}</div>
</#if>
<#include "footer.ftlh"/>