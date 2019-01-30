        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link <#if login??>active</#if>" href="login">
                            <span data-feather="log-in"></span>
                            Login <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if choose_currency??>active</#if>" href="choose">
                            <span data-feather="check-square"></span>
                            Select currency
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if current_value??>active</#if>" href="current">
                            <span data-feather="dollar-sign"></span>
                            Current value
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if exchange_rate_history??>active</#if>" href="rateHistory">
                            <span data-feather="trending-up"></span>
                            Exchange rate history
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if selected_time_range_prices??>active</#if>" href="time-range">
                            <span data-feather="trending-up"></span>
                            Selected time range prices
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if value_in_selected_day??>active</#if>" href="select-day">
                            <span data-feather="crosshair"></span>
                            Value in selected day
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if global_extremes??>active</#if>" href="global-extremes">
                            <span data-feather="maximize-2"></span>
                            Global extremes
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if local_extremes??>active</#if>" href="local-extremes">
                            <span data-feather="minimize-2"></span>
                            Local extremes
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if info??>active</#if>" href="info">
                            <span data-feather="info"></span>
                            Info
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if apiDemo??>active</#if>" href="api-demo">
                            <span data-feather="refresh-ccw"></span>
                            Real Time Prices
                        </a>
                    </li>

                    <#if sessionRole??>
                        <li class="nav-item">
                            <a class="nav-link <#if load_files??>active</#if>" href="data-upload">
                                <span data-feather="download"></span>
                                Load files <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <#if configuration??>active</#if>" href="configuration">
                                <span data-feather="settings"></span>
                                Configuration
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <#if currencyName??>active</#if>" href="currency-name">
                                <span data-feather="settings"></span>
                                Currency Name
                            </a>
                        </li>
                    </#if>
                    <hr>
                    <li class="nav-item">
                        <a class="nav-link <#if choice_two_currency??>active</#if>" href="choice-two">
                            <span data-feather="refresh-ccw"></span>
                            Choice two currency
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if exchange_history_two??>active</#if>" href="exchange-history-two">
                            <span data-feather="refresh-ccw"></span>
                            Exchange history for two cuurency
                        </a>
                    </li>
                </ul>
            </div>
        </nav>