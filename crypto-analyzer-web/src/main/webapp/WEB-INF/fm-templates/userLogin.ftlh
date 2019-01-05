<!doctype html>
<html lang="en">
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
                    <h1 class="display-4"></h1>
                    <p class="lead">You are logged as:</p>
                    <hr class="my-4">
                    <div class="card-deck">
                        <div class="card">
                            <div class="card-body">
                                <p class="card-text">Full name: <b>${sessionName}</b></p>

                                <p class="card-text">Your email: <b>${sessionEmail}</b></p>

                                <div class="card-body">
                                <a href="/logout" class="card-link" onclick="signOut();">Sing out</a>
                                </div>
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
    function signOut() {
        console.log("logging out ...");
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            console.log('User signed out.');
        });
        console.log("redirecting to logout servlet");
        window.location.href = '/logout';
    }
</script>


</body>
</html>
