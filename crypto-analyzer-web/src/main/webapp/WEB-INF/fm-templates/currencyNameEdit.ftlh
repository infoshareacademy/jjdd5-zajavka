<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" xmlns="http://java.sun.com/jsf/html">
    <h1>Edit currency name</h1>

    <div>
        <form name="editCurrencyName" onsubmit="return checkIsEmpty()" action="/currency-name-edit" method="post" value="${editCurrencyName1.nameFile}">
            <input type="hidden" name="fileName" value="${editCurrencyName1.nameFile}">
            </table>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">File name</th>
                    <th scope="col">Edited currency name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${editCurrencyName1.nameFile}</td>
                    <td><input type="text" name="currencyName" value="${editCurrencyName1.nameCurrency}"></td>
                    <td><input type="submit"></td>
                </tr>
                </tbody>
            </table>

        </form>
    </div>
</main>
<script>
    function checkIsEmpty() {
        var y = document.forms["insertCurrency"]["currencyName"].value;
        if (y.trim() == "") {
            alert("Please input correct value or no empty input");
            return false;
        }
    }
</script>
<#include "footer.ftlh"/>