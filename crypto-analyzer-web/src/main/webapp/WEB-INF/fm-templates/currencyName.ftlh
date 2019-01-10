<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" xmlns="http://java.sun.com/jsf/html">
    <h1>List currency name</h1>
<div>
           <#if currencyNameList??>
               <table class="table table-striped">
                   <thead>
                   <tr>
                       <th scope="col">File name</th>
                       <th scope="col">Currency name</th>
                   </tr>
                   </thead>
                   <tbody>
                <#list currencyNameList as currencyList>
                <tr>
                    <td>${currencyList.nameFile}</td>
                    <td>${currencyList.nameCurrency}</td>
                </tr>
                </#list>
                   </tbody>
                   <div>
                       <form action="/currency-name" method="post">
               </table>
               <table class="table table-striped">
                   <thead>
                   <tr>
                       <th scope="col">Insert file name</th>
                       <th scope="col">Insert currency name</th>
                   </tr>
                   </thead>
                   <tbody>
                   <tr>
                       <td><input type="text" name="fileName"></td>
                       <td><input type="text" name="currencyName"></td>
                   </tr>
                   </tbody>
               </table>
               <input type="submit">
           </form>
               </div>
           </#if>
    </div>

</main>
<#include "footer.ftlh"/>