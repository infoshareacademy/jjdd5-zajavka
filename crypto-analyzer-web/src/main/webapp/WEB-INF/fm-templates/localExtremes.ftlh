<#assign local_extremes="active">

<#include "header.ftlh"/>
<#if isDateCorrect>
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <div class="alert alert-info text-center" role="alert">Current currency: ${chosenCurrency}</div>
        <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
            <div class="col-md-5 p-lg-5 mx-auto my-5">

                <h1 class="display-4 font-weight-normal">Local extremes</h1>
                <p class="lead font-weight-normal">Presented minimum and maximum price in selected period.</p>

            </div>
        </div>

        <div class="card-deck mb-3 text-center">
            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Time Range</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">
                        <small class="text-muted">from</small>${startDate}</h1>
                    <h1 class="card-title pricing-card-title">
                        <small class="text-muted">to</small>${endDate}</h1>
                </div>
            </div>

            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Minimum value</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">$${localMinPrice}
                        <small class="text-muted">/ ${formattedLocalMinDate}</small>
                    </h1>
                </div>
            </div>
            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Maximum value</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">$${localMaxPrice}
                        <small class="text-muted">/ ${formattedLocalMaxDate}</small>
                    </h1>
                </div>
            </div>

        </div>
        </div>
    </main>
<#else>
    <#include "selectDayLocal.ftlh"/>
</#if>
<#include "footer.ftlh"/>