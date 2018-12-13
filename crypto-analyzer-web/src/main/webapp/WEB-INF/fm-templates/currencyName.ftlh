<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <h1>currencyList</h1>
            <div method="post">
                <ul>
    <#list currencyList as oneCurrency>
        <li>
            ${oneCurrency.key} - ${oneCurrency.value}
            <button type="button" action="edit" name="/editCurrencyName" value="${oneCurrency.key}">Edit</button>
        </li>
    </#list>
                </ul>
            </div>
        </main>
<#include "footer.ftlh"/>