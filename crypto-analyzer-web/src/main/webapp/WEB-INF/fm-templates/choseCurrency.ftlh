<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

<#if Names??>
    <form method="post">
        <select name="currency" class="custom-select custom-select-lg mb-3">
            <option selected>Chose currency</option>
                <#list Names as oneName>
                <option value="${oneName}">${oneName}</option>
                </#list>
        </select>
    </form>

</#if>

        </main>
<#include "footer.ftlh"/>