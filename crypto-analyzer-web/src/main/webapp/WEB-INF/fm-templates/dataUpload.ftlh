<html>

<head>
    <meta charset="UTF-8" />
    <title>Zajavka-crypto_analyzer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        div {
            width: 100%;
            height: 50%;
            padding: 20%;
            border: 2px solid cadetblue;
            margin: 50, 50, 50, 50px;
            background-image: url("fot/bit.jpg");
        }

        h3{
            color: cadetblue;
        }
    </style>

</head>

<body>



<div>

    <form method="post" enctype="multipart/form-data">
        <h3>Choose a zip file:</h3><input type="file" name ="multiPartServlet"/>
        <input type="submit" class="btn btn-outline-success"value="Upload"/>
    <#--<input type="submit" value="Upload"/>-->
    </form>