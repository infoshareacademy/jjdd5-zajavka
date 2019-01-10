<#assign value_in_selected_day="active">

<#include "header.ftlh"/>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
            <div class="col-md-5 p-lg-5 mx-auto my-5">
                <h1 class="display-4 font-weight-normal">Select date</h1>
                <p class="lead font-weight-normal">Pick up the date from calendar to see price for selected day.</p>


                <form ACTION="select-day" METHOD="POST" class= needs-validation" novalidate="">
                <div class="row">
                    <div class="col-md-6 mb-3 mx-auto">
                        <input type="date" name="date" class="form-control" placeholder="" value="" required="">
                    </div>
                </div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>

                </form>
            </div>
        </div>
    </main>

<#include "footer.ftlh"/>