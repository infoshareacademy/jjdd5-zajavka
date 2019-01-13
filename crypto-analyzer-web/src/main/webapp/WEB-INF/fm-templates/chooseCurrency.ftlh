<#assign choose_currency="active">

<#include "header.ftlh"/>
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" xmlns="http://www.w3.org/1999/html">
<div class="alert alert-info text-center" role="alert">Current currency: ${chosenCurrency}</div>

<#if newListCurrencyStandard??>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <form method="post">

                <select name="currencyFullName" class="custom-select custom-select-lg mb-3">
                    <option selected>Select currency</option>
                    <#list newListCurrencyPromote?keys as key>
                        <option style="background: rgba(106,211,52,0.53); font-weight: 900"
                                value="${key}">&bull; ${newListCurrencyPromote[key]}</option>
                    </#list>
                    <#list newListCurrencyStandard?keys as key>
                        <option value="${key}">${newListCurrencyStandard[key]}</option>
                    </#list>
                </select>
                <#if isCurrencySelected??>
                    <div class="alert alert-success" role="alert">
                        Currency selected <strong>successfully !</strong>
                    </div>
                </#if>
                <button type="submit" class="btn btn-secondary btn-lg">Confirm choice</button>
            </form>
        </div>
    </div>

</#if>
<#include "footer.ftlh"/>