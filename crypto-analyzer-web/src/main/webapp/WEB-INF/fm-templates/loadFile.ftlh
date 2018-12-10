<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

            <FORM ACTION="http://localhost:8080/crypto-analyzer/load"
                  METHOD="POST">
                <button type="button" class="btn btn-primary btn-lg btn-block">Load File</button>
            </FORM>

            <p> Grades:
                <b>
                    <#if Currency??>
                    <ul>
                    <#list Currency as oneCurrency>
                        <li>Waluta wczytana : ${oneCurrency.name}</li>
                        <#list oneCurrency.dailyDataList as oneData>
                            <li class="list-group-item list-group-item-success">${oneData.date} : ${oneData.priceUsd}</li>
                        </#list>

                    </#list>
                    </ul>
                    </#if>
                </b>
            </p>

        </main>
<#include "footer.ftlh"/>