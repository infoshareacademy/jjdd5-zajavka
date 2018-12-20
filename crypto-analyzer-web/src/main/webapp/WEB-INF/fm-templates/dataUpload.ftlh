<#include "header.ftlh"/>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link  active" href="data-upload">
                    <span data-feather="download"></span>
                    Load files <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="choose">
                    <span data-feather="check-square"></span>
                    Choose currency
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="current">
                    <span data-feather="dollar-sign"></span>
                    Current value
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="rateHistory">
                    <span data-feather="trending-up"></span>
                    Exchange rate history
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="select-time-range">
                    <span data-feather="trending-up"></span>
                    Selected time range prices
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="select-day">
                    <span data-feather="crosshair"></span>
                    Value in selected day
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="global-extremes">
                    <span data-feather="maximize-2"></span>
                    Global extremes
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="select-day-local">
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

<head>
    <meta charset="UTF-8" />
    <title>CryptoAnalyzer by zaJavkar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        body{
            font-family: Helvetica DejaVu Sans Light;
            background-image: url("bg-upload.jpg");
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .content {
            width: 100%;
            height: 50%;
            padding: 20%;
            border: 1px;
        }
        .custom-file{
            width: 300px;
            float: right;
        }
        .send{
            margin-top: 20px;
            float: right;
        }

        .loadingCurr {
            margin-top: 100px;
            width: 300px;
            float: right;
        }

        h3{
            font-family: opensuns, roboto, monospace;
            color: whitesmoke;
                }
    </style>

</head>

<body>

<div class="content">

    <form method="post" enctype="multipart/form-data">
        <div class="custom-file">
            <input type="file" name="multiPartServlet" class="custom-file-input" id="customFile">
            <label class="custom-file-label" for="customFile">Choose file</label>
            <input type="submit" class="btn btn-success send"value="Upload"/>

        </div>

        <div class="send">
        </div>

        <div class="loadingCurr" >
        <p>
            <b>
                    <#if Currency??>
                        <ul>
                            <li style="color: whitesmoke" >Loading currencies : </li>
                        <#list Currency as oneCurrency>
                            <li class="list-group-item list-group-item-success">${oneCurrency}</li>
                        </#list>
                        </ul>
                    </#if>
            </b>
        </p>
        </div>

    </form>
    </div>
</body>
        </main>
<#include "footer.ftlh"/>