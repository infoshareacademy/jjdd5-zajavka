<#assign choose_currency="active">

<#include "header.ftlh"/>
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">


<div class="p-3 mb-2 bg-info text-white">${chosenCurrency}</div>

<#if newListCurrencyStandard??>
    <form method="post">
        <select name="currencyFullName" class="custom-select custom-select-lg mb-3">
            <option selected>Choose currency</option>
            <#list newListCurrencyStandard?keys as key>
                <option value="${key}">${newListCurrencyStandard[key]}</option>
            </#list>
            <#list newListCurrencyPromote?keys as key>
                <option style="background: green; font-weight: 900"
                        value="${key}">${newListCurrencyPromote[key]}</option>
            </#list>
        </select>
        <button type="submit" class="btn btn-secondary btn-lg">Confirm chose</button>
    </form>
</#if>




<#include "footer.ftlh"/>