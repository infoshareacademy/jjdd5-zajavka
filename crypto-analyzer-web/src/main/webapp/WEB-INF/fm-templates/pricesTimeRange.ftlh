<#include "header.ftlh"/>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="test2">
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
                <a class="nav-link" href="rateHistory">
                    <span data-feather="trending-up"></span>
                    Exchange rate history
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="select-time-range">
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
    <canvas class="my-4 chartjs-render-monitor" id="myChart" width="1541" height="650" style="display: block; width: 1541px; height: 650px;"></canvas>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
    <script>
        var ctx = document.getElementById("myChart");
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
                datasets: [{
                    data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                    lineTension: 0,
                    backgroundColor: 'transparent',
                    borderColor: '#007bff',
                    borderWidth: 4,
                    pointBackgroundColor: '#007bff'
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: false
                        }
                    }]
                },
                legend: {
                    display: false,
                }
            }
        });
    </script>






    <div class="table-responsive">
    <table class="table table-striped table-sm">
    <thead>
    <tr>
        <th>Date</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
<#list prices as onePrice>
    <tr>
    <td>${onePrice.date}</td>
    <td>${onePrice.strPriceUSD}</td>
    </tr>
</#list>
    </tbody>
    </table>
    </div>

    </main>
<#include "footer.ftlh"/>