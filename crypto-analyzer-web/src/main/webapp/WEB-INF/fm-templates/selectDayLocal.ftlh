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
                    Chose curreny
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
                <a class="nav-link" href="global-extremes">
                    <span data-feather="maximize-2"></span>
                    Global extremes
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="select-day-local">
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

        <form ACTION="http://localhost:8080/crypto-analyzer/local-extremes" METHOD="POST" class="needs-validation" novalidate="">
            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
                <div class="col-md-5 p-lg-5 mx-auto my-5">
                    <h1 class="display-4 font-weight-normal">Local extremes</h1>
                    <p class="lead font-weight-normal">Pick up the dates from calendar to see minimum and maximum price for this time range.</p>
            <div class="row">
                <div class="col-md-6 mb-3 mx-auto">
                    <label for="firstName"><span style="font-size: x-large; ">Start date</span></label>
                    <input type="date" name="startDate" class="form-control"  placeholder="" value="" required="">
                </div>
                <div class="col-md-6 mb-3 mx-auto">
                    <label for="lastName"><span style="font-size: x-large; ">End date</span></label>
                    <input name="endDate" type="date" class="form-control"  placeholder="" value="" required="">
                    <div class="invalid-feedback">
                        Valid last name is required.
                    </div>
                </div>
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
        </form>
        </div>
        </div>
    </main>
<#include "footer.ftlh"/>