<#assign global_extremes="active">

<#include "header.ftlh"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="alert alert-info text-center" role="alert" >Current currency: ${chosenCurrency}</div>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">

            <h1 class="display-4 font-weight-normal">Global extremes</h1>
            <p class="lead font-weight-normal">Presented minimum and maximum price in exchange history.</p>
            <#if !isCurrencyActive>

                <#include "alerts.ftlh"/>
            </#if>
        </div>

    </div>
    <#if isCurrencyActive>
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Max value</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$${globalMaxPrice}
                    <small class="text-muted">/ ${globalMaxDate}</small>
                </h1>
            </div>
        </div>
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Min value</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$${globalMinPrice}
                    <small class="text-muted">/ ${globalMinDate}</small>
                </h1>
            </div>
        </div>
        </#if>


    </div>
</main>
<#include "footer.ftlh"/>