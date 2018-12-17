<#include "header.ftlh"/>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="test2">
                    <span data-feather="download"></span>
                    Load files <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="chose">
                    <span data-feather="check-square"></span>
                    Chose curreny
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="current">
                    <span data-feather="dollar-sign"></span>
                    Current value
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="trending-up"></span>
                    Exchange rate history
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="crosshair"></span>
                    Value in selected day
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="maximize-2"></span>
                    Global extremes
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="minimize-2"></span>
                    Local extremes
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="info">
                    <span data-feather="info"></span>
                    Info
                </a>
            </li>
        </ul>
    </div>
</nav>
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