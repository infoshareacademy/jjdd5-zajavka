<#assign value_in_selected_day="active">

<#include "header.ftlh"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4 text-center">
    <div class="alert alert-info" role="alert" >Current currency: ${chosenCurrency}</div>

        <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <h1 class="display-4 font-weight-normal">Day price</h1>
            <p class="lead font-weight-normal">Presented value for selected day.</p>
        </div>
    </div>
    <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
    <div class="card-header">
        <h4 class="my-0 font-weight-normal"></h4>
    </div>
    <div class="card-body">
    <h1 class="card-title pricing-card-title">
    <small class="text-muted">price </small>${formattedDailyDataPrice}</h1>
    <h1 class="card-title pricing-card-title">
<small class="text-muted">in </small>${dailyDataDate}</h1>
    </div>
    </div>
    </main>
<#include "footer.ftlh"/>