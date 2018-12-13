<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>建材ERP</title>
    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/vendors/animate.css/animate.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signin"></a>
    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form id="subform" action='/login' method='POST'>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <h1>登录</h1>
                    <div>
                        <input name='username' type="text" class="form-control" placeholder="用户名" required=""/>
                    </div>
                    <div>
                        <input name='password' type="password" class="form-control" placeholder="密码" required=""/>
                    </div>
                <#if error.isPresent()>
                    <div class="clearfix">
                        <p>用户名或密码错误，请重试！</p>
                    </div>
                </#if>
                    <div>
                        <a class="btn btn-default submit" onclick="document.getElementById('subform').submit();">登录</a>
                    </div>

                    <div class="separator">
                        <div>
                            <h1><i class="fa fa-paw"></i>建材账务系统软件</h1>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>

