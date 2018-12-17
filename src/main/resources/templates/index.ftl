<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>建材ERP </title>

    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <link href="/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/" class="site_title"><i class="fa fa-paw"></i> <span>诚信建材</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_info">
                        <span>欢迎,</span>
                        <#if currentUser??>
                            <h1>${currentUser.getUser().getUserName()}</h1>
                        </#if>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>菜单</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> 进货管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="index.html">采购入库</a></li>
                                    <li><a href="index2.html">采购退库</a></li>
                                    <li><a href="index3.html">供应商往来账务</a></li>
                                    <li><a href="index3.html">库存查询</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bus"></i> 销售管理 <span class="fa fa-chevron-down"></span><span
                                            class="label label-danger pull-right">开发中...</span></a>
                                <ul class="nav child_menu">
                                    <li><a href="form.html">商品销售</a></li>
                                    <li><a href="form_advanced.html">商品退货</a></li>
                                    <li><a href="form_validation.html">客户往来账务</a></li>
                                    <li><a href="form_wizards.html">销售单据查询</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i> 库存管理 <span
                                            class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="general_elements.html">库存查询</a></li>
                                    <li><a href="media_gallery.html">报损报溢</a></li>
                                    <li><a href="typography.html">库存报警</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> 往来账款 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="tables.html">对客户应收款登记</a></li>
                                    <li><a href="tables_dynamic.html">收款登记</a></li>
                                    <li><a href="tables_dynamic.html">应收明细账</a></li>
                                    <li><a href="tables.html">对供应商应付款登记</a></li>
                                    <li><a href="tables_dynamic.html">付款登记</a></li>
                                    <li><a href="tables_dynamic.html">应付款明细账</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> 统计报表 <span
                                            class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="chartjs.html">采购统计</a></li>
                                    <li><a href="chartjs2.html">销售统计</a></li>
                                    <li><a href="morisjs.html">客户统计</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-clone"></i>日常管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="fixed_sidebar.html">商品信息</a></li>
                                    <li><a href="fixed_footer.html">供货商</a></li>
                                    <li><a href="fixed_footer.html">客户</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bug"></i> 系统维护 <span
                                            class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="projects.html">权限管理</a></li>
                                    <li><a href="e_commerce.html">修改密码</a></li>
                                    <li><a href="projects.html">查看日志</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->


            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                ${currentUser.getUser().getUserName()}
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li>
                                    <a href="javascript:">
                                        <span>修改密码</span>
                                    </a>
                                </li>
                                <li><a onclick="logout();"><i class="fa fa-sign-out pull-right"></i> 退出系统 </a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="row top_tiles" style="margin: 10px 0;">
                    <div class="col-md-3 col-sm-3 col-xs-6 tile">
                        <span>近七天进货量</span>
                        <h2>231,809</h2>
                        <span class="sparkline_one" style="height: 160px;">
                      <canvas width="200" height="60"
                              style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
                    </div>

                    <div class="col-md-3 col-sm-3 col-xs-6 tile">
                        <span>近七天出货量</span>
                        <h2>231,809</h2>
                        <span class="sparkline_one" style="height: 160px;">
                      <canvas width="200" height="60"
                              style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
                    </div>

                    <div class="col-md-3 col-sm-3 col-xs-6 tile">
                        <span>近七天销售额</span>
                        <h2>231,809</h2>
                        <span class="sparkline_one" style="height: 160px;">
                      <canvas width="200" height="60"
                              style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
                    </div>
                </div>
                <br/>


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="dashboard_graph x_panel">
                            <div class="row x_title">
                                <div class="col-md-6">
                                    <h3>Network Activities
                                        <small>Graph title sub-title</small>
                                    </h3>
                                </div>
                                <div class="col-md-6">
                                    <div id="reportrange" class="pull-right"
                                         style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                        <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                                    </div>
                                </div>
                            </div>
                            <div class="x_content">
                                <div class="demo-container" style="height:250px">
                                    <div id="chart_plot_03" class="demo-placeholder"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



            </div>

        </div>
        <!-- /page content -->
        <footer>
            <div class="pull-right">
                Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- footer content -->

        <!-- /footer content -->
        <form action="/logout" method="post" id="logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    </div>
</div>

<!-- jQuery -->
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick 从点击屏幕上的元素到触发元素的 click 事件，移动浏览器会有大约 300 毫秒的等待时间，消除延迟插件-->
<script src="/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress 进度条-->
<script src="/vendors/nprogress/nprogress.js"></script>
<!-- jQuery Sparklines -->
<script src="/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- Flot -->
<script src="/vendors/Flot/jquery.flot.js"></script>
<script src="/vendors/Flot/jquery.flot.pie.js"></script>
<script src="/vendors/Flot/jquery.flot.time.js"></script>
<script src="/vendors/Flot/jquery.flot.stack.js"></script>
<script src="/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="/vendors/DateJS/build/date.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/vendors/moment/min/moment.min.js"></script>
<script src="/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- Custom Theme Scripts -->
<script src="/build/js/custom.min.js"></script>

<script language="JavaScript">
    function logout() {
        console.log("111");
        var form = document.getElementById('logout');
        form.submit();
    }
</script>
</body>
</html>