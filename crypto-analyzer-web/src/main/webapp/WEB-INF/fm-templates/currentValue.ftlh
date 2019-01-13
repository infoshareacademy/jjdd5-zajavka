<#assign current_value="active">

<#include "header.ftlh"/>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
<div class="alert alert-info text-center" role="alert" >Current currency: ${chosenCurrency}</div>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
<div class="col-md-5 p-lg-5 mx-auto my-5">

    <h1 class="display-4 font-weight-normal">Current value</h1>
    <p class="lead font-weight-normal">Presented current price for crypto currency.</p>
    <#if !isCurrencyActive>
        <#include "alerts.ftlh"/>
    </#if>
</div>

<#if DailyDataDate??>
<div class="col-md-5 p-lg-5 mx-auto my-5">
<div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
        <div class="card-header">
            <h4 class="my-0 font-weight-normal">Price in: </h4>
        </div>
        <div class="card-body">
            <h1 class="card-title pricing-card-title">
                <small class="text-muted">from</small>${DailyDataDate}</h1>
            <h1 class="card-title pricing-card-title">
                <small class="text-muted">to</small>${DailyDataPrice}</h1>
        </div>
    </div>
</div>
<#--


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
    </table>-->
</#if>

<#include "footer.ftlh"/>