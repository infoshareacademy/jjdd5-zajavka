<#assign info="active">

<html lang="pl-PL">

<#include "header.ftlh"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

    <head>
        <#--<meta charset="UTF-8"/>-->
        <title>CryptoAnalyzer by zaJavka</title>
        <style>
            body {
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
                font-family: Helvetica DejaVu Sans Light;
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
                font-family: Helvetica DejaVu Sans Light;
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