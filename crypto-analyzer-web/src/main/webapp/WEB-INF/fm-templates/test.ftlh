
<!doctype html>
<html>

<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.js"></script>

    <script src="../../utils.js"></script>
    <style>
        canvas {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }
    </style>
</head>

<body>
<div style="width:75%;">
    <canvas id="canvas"></canvas>
</div>
<script>
    var lineChartData = {
        labels: [
            <#if pricesOne??>
            <#list grafPricesOne as entry>
            "${entry.date}",
            </#list>
            </#if>
        ],
        datasets: [{
            label: '${chosenCurrencyOne}',
            borderColor: window.chartColors.red,
            backgroundColor: window.chartColors.red,
            fill: false,
            data: [
                <#if pricesOne??>
                <#list grafPricesOne as entry>
                "${entry.price}",
                </#list>
                </#if>
            ],
            yAxisID: 'y-axis-1',
        }, {
            label: '${chosenCurrencyTwo}',
            borderColor: window.chartColors.blue,
            backgroundColor: window.chartColors.blue,
            fill: false,
            data: [
                <#if pricesTwo??>
                <#list grafPricesTwo as entry>
                "${entry.price}",
                </#list>
                </#if>
            ],
            yAxisID: 'y-axis-2'
        }]
    };

    window.onload = function() {
        var ctx = document.getElementById('canvas').getContext('2d');
        window.myLine = Chart.Line(ctx, {
            data: lineChartData,
            options: {
                responsive: true,
                hoverMode: 'index',
                stacked: false,
                scales: {
                    yAxes: [{
                        type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                        display: true,
                        position: 'left',
                        id: 'y-axis-1',
                    }, {
                        type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                        display: true,
                        position: 'right',
                        id: 'y-axis-2',

                        // grid line settings
                        gridLines: {
                            drawOnChartArea: false, // only want the grid lines for one axis to show up
                        },
                    }],
                }
            }
        });
    };
</script>
</body>

</html>
