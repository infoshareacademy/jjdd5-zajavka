<#include "header.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">


<h1>Edit configuration</h1>
<div>
Actual fomrat date: ${dateFormat}<br>
Amount number after sign:  ${afterSign}<br>

</div>


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

        </main>
<#include "footer.ftlh"/>