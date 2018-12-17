<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>CryptoAnalyzer by zaJavka</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->

    <link href="dashboard.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">CryptoAnalyzer</a>
<#--<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">zaJavka</a>-->
<#--<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">-->
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
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
                        <a class="nav-link" href="select-day-local">
                            <span data-feather="minimize-2"></span>
                            Local extremes
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="global-extremes">
                            <span data-feather="maximize-2"></span>
                            Global extremes
                        </a>
                    </li>

                </ul>
            </div>
        </nav>