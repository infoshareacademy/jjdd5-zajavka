<#include "header.ftlh"/>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">

            <h1 class="display-4 font-weight-normal">Global extremes</h1>
            <p class="lead font-weight-normal">Presented minimum and maximum price in exchange history.</p>

        </div>

    </div>

    <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
    <div class="card-header">
        <h4 class="my-0 font-weight-normal">Max value</h4>
    </div>
    <div class="card-body">
    <h1 class="card-title pricing-card-title">$${globalMax.priceUSD}
    <small class="text-muted">/ ${globalMax.date}</small></h1>
    </div>
    </div>
    <div class="card mb-4 shadow-sm">
    <div class="card-header">
        <h4 class="my-0 font-weight-normal">Min value</h4>
    </div>
    <div class="card-body">
    <h1 class="card-title pricing-card-title">$${globalMin.priceUSD}
    <small class="text-muted">/ ${globalMin.date}</small></h1>
    </div>
    </div>



    </div>
    </main>
<#include "footer.ftlh"/>