<#assign currencyName="active">
<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <h1 class="display-4 font-weight-normal">Currency you want add is exist</h1>
        </div>
    </div>

    <h1>List currency name</h1>
    <div>
        <form name="insertCurrency" onsubmit="return checkIsEmpty()" action="/currency-name" method="post">
            </table>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Insert file name</th>
                    <th scope="col">Insert currency name</th>
                    <th scope="col">Is promotion</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" name="fileName"></td>
                    <td><input type="text" name="currencyName"></td>
                    <td>
                        <input type="radio" name="promotion" value="Yes">Yes<br>
                        <input type="radio" name="promotion" value="No" checked>No<br></td>
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
                <th scope="col">Is promoted</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list currencyNameList as currencyList>
            <tr>
                <td>${currencyList.nameFile}</td>
                <td>${currencyList.nameCurrency}</td>
                <td>${currencyList.promote}</td>
                <td><a href="/currency-name-edit?name=${currencyList.nameFile}"> Edit </a> <a
                            href="/currency-name-delete?name=${currencyList.nameFile}"> Delete </a></td>
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