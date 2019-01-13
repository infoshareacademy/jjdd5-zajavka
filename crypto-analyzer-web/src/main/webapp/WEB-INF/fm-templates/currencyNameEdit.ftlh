<#assign currencyName="active">
<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <h1 class="display-4 font-weight-normal">Edit currency</h1>
        </div>
    </div>
    <div>
        <form name="editCurrencyName" onsubmit="return checkIsEmpty()" action="/currency-name-edit" method="post"
              value="${editCurrencyName1.nameFile}">
            <input type="hidden" name="fileName" value="${editCurrencyName1.nameFile}">
            </table>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">File name</th>
                    <th scope="col">Edited currency name</th>
                    <th scope="col">Is promoted</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${editCurrencyName1.nameFile}</td>
                    <td><input type="text" name="currencyName" value="${editCurrencyName1.nameCurrency}"></td>
                    <td>
                        <input type="radio" name="promotion" value="Yes">Yes<br>
                        <input type="radio" name="promotion" value="No" checked>No<br></td>
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