<html>
<body>
<h1>Edit configuration</h1>
<form method="post" action="configuration" enctype="multipart/form-data">
        <input type="radio" name="dateFormat" value="dd-MM-yyyy" checked> dd-MM-yyyy<br>
        <input type="radio" name="dateFormat" value="dd-MM-yy"> dd-MM-yy<br>
        <input type="radio" name="dateFormat" value="yyyy-MM-dd"> yyyy-MM-dd<br>
        <input type="radio" name="dateFormat" value="yy-MM-dd"> yy-MM-dd<br>
        <input type="radio" name="dateFormat" value="dd:MM:yyyy"> dd:MM:yyyy<br>
        <input type="radio" name="dateFormat" value="dd:MM:yy"> dd:MM:yy<br>
        <input type="radio" name="dateFormat" value="yy:MM:dd"> yy:MM:dd<br>
        <input type="radio" name="dateFormat" value="yyyy:MM:dd"> yyyy:MM:dd<br><br>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>

<form method="post" action="configuration" enctype="multipart/form-data">
        <input type="radio" name="afterSign" value="1" checked> 1<br>
        <input type="radio" name="afterSign" value="2"> 2<br>
        <input type="radio" name="afterSign" value="3"> 3<br>
        <input type="radio" name="afterSign" value="4"> 4<br>
        <input type="radio" name="afterSign" value="5"> 5<br>
        <input type="radio" name="afterSign" value="6"> 6<br>

    <input type="submit" name="save" value="save"/><br/><br/>
</form>
</body>
</html>