<#--<#assign global_extremes="active">-->

<#include "header.ftlh"/>

<script>
    $(document).ready(function () {
        setInterval(function () {
            reload_page()
        }, 3000);
    });

    function reload_page() {
        window.location.reload(true);
    }
</script>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
<#--<div class="alert alert-info text-center" role="alert">Current currency: ${chosenCurrency}</div>-->
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">

            <h1 class="display-4 font-weight-normal">Dynamic Prices</h1>
            <p class="lead font-weight-normal">Presented prices at real time.</p>

        <#--<#if !isCurrencyActive>-->
        <#--<#include "alerts.ftlh"/>-->
        <#--</#if>-->

        </div>

    </div>

<#--<#if isCurrencyActive>-->
    <div class="card-deck mb-4 text-center">
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal"><strong>BitCoin</strong></h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$ ${btc}
                </h1>
            </div>
        </div>
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal"><strong>Ethereum</strong></h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$ ${eth}
                </h1>
            </div>
        </div>
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal"><strong>LiteCoin</strong></h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$ ${ltc}
                </h1>
            </div>
        </div>
    </div>
    <div class="card-deck mb-4 text-center">
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal"><strong>Xrp</strong></h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$ ${xrp}
                </h1>
            </div>
        </div>
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal"><strong>Eos</strong></h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$ ${eos}
                </h1>
            </div>
        </div>
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal"><strong>Tron</strong></h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$ ${trx}
                </h1>
            </div>
        </div>
    <#--</#if>-->

    </div>
    <div class="alert alert-info text-center" role="alert">
        Values are updated every 3 seconds *
    </div>

</main>
<#include "footer.ftlh"/>