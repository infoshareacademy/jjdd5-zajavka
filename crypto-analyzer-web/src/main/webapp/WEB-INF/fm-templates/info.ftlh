<html lang="pl-PL">

<#include "header.ftlh"/>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="data-upload">
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
                <a class="nav-link active" href="info">
                    <span data-feather="info"></span>
                    Info
                </a>
            </li>
        </ul>
    </div>
</nav>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

    <head>
        <meta charset="UTF-8"/>
        <title>CryptoAnalyzer by zaJavka</title>
        <style>
            body {
                font-family: Helvetica DejaVu Sans Light;
                background-image: url("bg-info.jpg");
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }

            .names {
                font-size: 30px;
                color: whitesmoke;
                margin-top: 100px;
                width: 350px;
                margin-left: 55%;
            }

            .logo {
                background: whitesmoke;
                text-align: center;
                margin-top: 50px;
                margin-left: 55%;
               width: 250px;
                height: 250px;
            }

            .cooperation {
                color: whitesmoke;
                margin-left: 55%;
            }

        </style>

    </head>

    <body>

    <div class="logo">
        <img src="zajawka.jpg" alt="Zajavka logo" width="300" height="300">
    </div>

    <div class="names">

        <p lang="pl">${member1}</p>
        <p lang="pl">${member2}</p>
        <p lang="pl">${member3}</p>
        <p lang="pl">${member4}</p>

    </div>

    <div class="cooperation">
        <p> This project created at the classes
            <a href="https://infoshareacademy.com/" target="_blank">infoShare ACADEMY. </a>
        </p>
    </div>

    <body>

</main>
<#include "footer.ftlh"/>
</html>