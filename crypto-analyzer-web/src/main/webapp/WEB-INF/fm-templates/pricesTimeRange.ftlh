<#include "header.ftlh"/>

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