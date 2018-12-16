
<html>

<#include "header.ftlh"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

<head>
    <meta charset="UTF-8" />
    <title>CryptoAnalyzer by zaJavkar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        body{
            font-family: Helvetica DejaVu Sans Light;
            background-image: url("bg-upload.jpg");
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .content {
            width: 100%;
            height: 50%;
            padding: 20%;
            border: 1px;
        }
        .custom-file{
            width: 300px;
            float: right;
        }
        .send{
            margin-top: 20px;
            float: right;
        }

        h3{
            font-family: opensuns, roboto, monospace;
            color: whitesmoke;
                }
    </style>

</head>

<body>

<div class="content">

    <form method="post" enctype="multipart/form-data">
        <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile">
            <label class="custom-file-label" for="customFile">Choose file</label>
            <input type="submit" class="btn btn-success send"value="Upload"/>

        </div>

        <div class="send">
        </div>

    </form>
    </div>
</body>
        </main>
<#include "footer.ftlh"/>

</html>