<#assign configuration="active">
<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <h1 class="display-4 font-weight-normal">Edit configuration</h1>
        </div>
    </div>


    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Actual format date:</h4>
                <h4 class="my-0 font-weight-normal">${dateFormat}</h4>
            </div>
            <div class="card-body">
                <form action="configuration" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="nameConfig" value="dateFormat">
                    <input type="radio" name="value" value="dd-MM-yyyy" checked> dd-MM-yyyy<br>
                    <input type="radio" name="value" value="dd-MM-yy"> dd-MM-yy<br>
                    <input type="radio" name="value" value="yyyy-MM-dd"> yyyy-MM-dd<br>
                    <input type="radio" name="value" value="yy-MM-dd"> yy-MM-dd<br>
                    <input type="radio" name="value" value="dd:MM:yyyy"> dd:MM:yyyy<br>
                    <input type="radio" name="value" value="dd:MM:yy"> dd:MM:yy<br>
                    <input type="radio" name="value" value="yy:MM:dd"> yy:MM:dd<br>
                    <input type="radio" name="value" value="yyyy:MM:dd"> yyyy:MM:dd<br><br>
                    <input type="submit">
                </form>
            </div>
        </div>

        <div class="card mb-4 shadow-sm">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Amount number after sign:</h4>
                <h4 class="my-0 font-weight-normal">${afterSign}</h4>
            </div>
            <div class="card-body">
                <form action="configuration" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="nameConfig" value="afterSign">
                    <input type="radio" name="value" value="2" checked> 2<br>
                    <input type="radio" name="value" value="3"> 3<br>
                    <input type="radio" name="value" value="4"> 4<br>
                    <input type="radio" name="value" value="5"> 5<br>
                    <input type="radio" name="value" value="6"> 6<br><br>
                    <input type="submit">
                </form>
            </div>
        </div>

    </div>
</main>
<#include "footer.ftlh"/>