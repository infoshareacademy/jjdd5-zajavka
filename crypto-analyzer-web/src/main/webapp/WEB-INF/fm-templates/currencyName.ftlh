<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" xmlns="http://java.sun.com/jsf/html">
    <h1>List currency name</h1>
    <div>
        <form name="insertCurrency" onsubmit="return checkIsEmpty()" action="/currency-name" method="post">
            </table>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Insert file name</th>
                    <th scope="col">Insert currency name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" name="fileName"></td>
                    <td><input type="text" name="currencyName"></td>
                    <td><input type="submit"></td>
                </tr>
                </tbody>
            </table>

        </form>
    </div>
    <div>
        <#if currencyNameList??>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">File name</th>
                <th scope="col">Currency name</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list currencyNameList as currencyList>
                <tr>
                    <td>${currencyList.nameFile}</td>
                    <td>${currencyList.nameCurrency}</td>
                    <td><a href="/currency-name-edit?name=${currencyList.nameFile}"> Edit </a> <a href="/currency-name-delete?name=${currencyList.nameFile}" > Delete </a></td>
            </#list>
            </tbody>
    </#if>
    </div>

</main>
<script>
    function checkIsEmpty() {
        var x = document.forms["insertCurrency"]["fileName"].value;
        var y = document.forms["insertCurrency"]["currencyName"].value;
        if (x.trim() == "" | y.trim() == "") {
            alert("Please input correct value or no empty input");
            return false;
        }
    }
</script>
<#include "footer.ftlh"/>