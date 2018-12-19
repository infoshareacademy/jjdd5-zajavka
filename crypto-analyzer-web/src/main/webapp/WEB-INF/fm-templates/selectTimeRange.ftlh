<#assign selected_time_range_prices="active">

<#include "header.ftlh"/>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <form ACTION="http://localhost:8080/crypto-analyzer/time-range" METHOD="POST" class="needs-validation"
              novalidate="">
            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
                <div class="col-md-5 p-lg-5 mx-auto my-5">
                    <h1 class="display-4 font-weight-normal">Selected time range history</h1>
                    <p class="lead font-weight-normal">Pick up the dates from calendar to see all prices in this period.</p>
                    <div class="row">
                        <div class="col-md-6 mb-3 mx-auto">
                            <label for="firstName"><span style="font-size: x-large; ">Start date</span></label>
                            <input type="date" name="startDate" class="form-control"  placeholder="" value="" required="">
                        </div>
                        <div class="col-md-6 mb-3 mx-auto">
                            <label for="lastName"><span style="font-size: x-large; ">End date</span></label>
                            <input name="endDate" type="date" class="form-control"  placeholder="" value="" required="">
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>

                </div>
            </div>
        </form>

    </main>
<#include "footer.ftlh"/>