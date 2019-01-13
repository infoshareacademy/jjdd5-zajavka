<#assign choose_currency="active">

<#include "header.ftlh"/>
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" xmlns="http://www.w3.org/1999/html">
<div class="alert alert-info text-center" role="alert">Current currency: ${chosenCurrency}</div>

<#if Names??>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <form method="post">

                <select name="currency" class="custom-select custom-select-lg mb-3">
                    <option selected>Choose currency</option>
                    <#list Names as oneName>
                        <option value="${oneName}">${oneName}</option>
                    </#list>
                </select>
                <button type="submit" class="btn btn-secondary btn-lg">Confirm chose</button>
            </form>
        </div>
    </div>

</#if>
<#include "footer.ftlh"/>