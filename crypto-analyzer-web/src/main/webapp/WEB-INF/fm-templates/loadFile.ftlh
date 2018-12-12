<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

            <FORM ACTION="http://localhost:8080/crypto-analyzer/load2" METHOD="POST">
                <button type="submit" class="btn btn-primary btn-lg btn-block" formaction="http://localhost:8080/crypto-analyzer/load">Load File</button>
            </FORM>

            <p>
                <b>
                    <#if Currency??>
                    <ul>
                        <li>Loading currencies : </li>
                        <#list Currency as oneCurrency>
                            <li class="list-group-item list-group-item-success">${oneCurrency}</li>
                        </#list>
                    </ul>
                    </#if>
                </b>
            </p>

        </main>
<#include "footer.ftlh"/>