<html>
<body>
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
    <input type="radio" name="value" value="dd:MM:yyyy"> dd:MM:yyyy<br>
    <input type="radio" name="value" value="dd:MM:yy"> dd:MM:yy<br><br>
    <input type="submit">
</form>
<form action="configuration" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="nameConfig" value="afterSign">
    <input type="radio" name="value" value="1" checked> 1<br>
    <input type="radio" name="value" value="2"> 2<br>
    <input type="radio" name="value" value="3"> 3<br>
    <input type="radio" name="value" value="4"> 4<br><br>

    <input type="submit">
</form>

</body>
</html>