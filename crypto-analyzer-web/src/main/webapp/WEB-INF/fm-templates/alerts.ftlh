<#if isDateSelected??>
    <div class="alert alert-danger" role="alert">
        <strong>Please select date.</strong>
    </div>
</#if>

<#if !isCurrencyActive>
    <div class="alert alert-info" role="alert">
        <strong>First select the currency</strong>
    </div>
<#else>
    <#if !isDateCorrect>
        <div class="alert alert-warning" role="alert">
            <strong> Sorry, we do not have price for that date.</strong><br>
            Select date from <strong>${firstDay}</strong> to <strong>${lastDay}.</strong>
        </div>
    </#if>
</#if>