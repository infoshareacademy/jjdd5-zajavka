<#if isDateSelected??>
    <div class="alert alert-danger" role="alert">
        <strong>Please select date.</strong>
    </div>
</#if>
<#if isDateOutOfRange??>
    <div class="alert alert-warning" role="alert">
        <strong> Sorry, we do not have price for that date.</strong><br>
        Select date from ${firstDayWithPrice} to ${lastDayWithPrice}.
    </div>
</#if>
<#if !isCurrencyActive>
    <div class="alert alert-info" role="alert">
        <strong>First select the currency</strong>
    </div>
</#if>