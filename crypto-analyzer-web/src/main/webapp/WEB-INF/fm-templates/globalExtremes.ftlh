<#include "header.ftlh"/>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="data-upload">
                    <span data-feather="download"></span>
                    Load files <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="chose">
                    <span data-feather="check-square"></span>
                    Choose currency
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="current">
                    <span data-feather="dollar-sign"></span>
                    Current value
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="rateHistory">
                    <span data-feather="trending-up"></span>
                    Exchange rate history
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="select-time-range">
                    <span data-feather="trending-up"></span>
                    Selected time range prices
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="select-day">
                    <span data-feather="crosshair"></span>
                    Value in selected day
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="global-extremes">
                    <span data-feather="maximize-2"></span>
                    Global extremes
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="select-day-local">
                    <span data-feather="minimize-2"></span>
                    Local extremes
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="info">
                    <span data-feather="info"></span>
                    Info
                </a>
            </li>
        </ul>
    </div>
</nav>

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
    <h1 class="card-title pricing-card-title">$${globalMax.strPriceUSD}
    <small class="text-muted">/ ${globalMax.date}</small></h1>
    </div>
    </div>
    <div class="card mb-4 shadow-sm">
    <div class="card-header">
        <h4 class="my-0 font-weight-normal">Min value</h4>
    </div>
    <div class="card-body">
    <h1 class="card-title pricing-card-title">$${globalMin.strPriceUSD}
    <small class="text-muted">/ ${globalMin.date}</small></h1>
    </div>
    </div>



    </div>
    </main>
<#include "footer.ftlh"/>