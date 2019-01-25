<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->

<!DOCTYPE html>
<html>


<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>登录</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script>if (window.top !== window.self) {
            window.top.location = window.location;
        }</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">诚信建材</h1>

        </div>
        <h3>欢迎使用</h3>

        <form class="m-t" action='/login' method='POST'>
            <div class="form-group">
                <input name='username' type="text" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input name='password' type="password" class="form-control" placeholder="密码">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <#if error??  && error.isPresent()>
                    <div class="clearfix">
                        <p>用户名或密码错误，请重试！</p>
                    </div>
                </#if>
        </form>
        </div>
    </div>
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>

</body>


</html>
