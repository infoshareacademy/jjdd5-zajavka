<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <h1>currencyList</h1>
            <div>
                <ul>
    <#list currencyList as oneCurrency>
        <li>
            <form action="editCurrencyName" method="POST">
                <input type="text" value="${oneCurrency.key}" name="key"/>
                <input type="text" value="${oneCurrency.value}" name="value"/>
                <input type="submit" value="Edit">

                <a href="/deleteCurrencyName?name=${oneCurrency.key}">Delete</a>
            </form>
        </li>
    </#list>
                    <form action="addCurrencyName" method="get">
                        <input type="submit" value="Add">
                    </form>

                </ul>
            </div>
        </main>
<#include "footer.ftlh"/>