<!doctype html>
<html lang="pl-PL">
    <head>
        <#include "head1.ftlh"/>
            <meta name="google-signin-scope" content="profile email">
            <meta name="google-signin-client_id" content="738989560971-cbgka85jgvbd3mju5r9i9i4r6uj3blnm.apps.googleusercontent.com">
            <script src="https://apis.google.com/js/platform.js" async defer></script>
    </head>

<body>
<#assign login="active">
<#include "navbarTop1.ftlh"/>

<div class="container-fluid">
    <div class="row">
        <#include "sidebar1.ftlh"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">

                <div class="jumbotron jumbotron-opacity jumbotron-login">
                    <h1 class="display-4">Loging</h1>
                    <p class="lead">Log to use full options.</p>
                    <hr class="my-4">
                    <div class="card-deck">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Log by Google</h5>
                                <a class="btn btn-lg g-signin2 lead" data-onsuccess="onSignIn"></a>
                                <br><br>
                                <a href="https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.pl%2F&hl=en&flowName=GlifWebSignIn&flowEntry=SignUp" class="card-link add-user-link">Register</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </main>
    </div>
</div>

<#include "jScripts.ftlh" />
<script>
    //google callback. This function will redirect to our login servlet
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        console.log('id_token: ' + googleUser.getAuthResponse().id_token);

        //do not post all above info to the server because that is not secure.
        //just send the id_token

        var redirectUrl = 'login';

        //using jquery to post data dynamically
        var form = $('<form action="' + redirectUrl + '" method="post">' +
                '<input type="text" name="id_token" value="' +
                googleUser.getAuthResponse().id_token + '" />' +
                '</form>');
        $('body').append(form);
        form.submit();
    }

</script>

</body>
</html>
