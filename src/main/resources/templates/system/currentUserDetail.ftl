<#-- @ftlvariable name="currentUser" type="com.business.system.model.CurrentUser" -->
<!DOCTYPE html>
<html>


<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户详细信息</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>登陆用户基本信息</h5>
                </div>
                <div class="ibox-content">
                    <form method="pose" class="form-horizontal" action="">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">登陆用户名</label>

                            <div class="col-sm-10">
                                <p class="form-control-static">${currentUser.getUser().getUserId()}</p>
                                <input type="hidden" value="${currentUser.getUser().getUserId()}"/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${currentUser.getUser().getUserName()}"/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password"
                                       value="${currentUser.getUser().getPassWord()}"/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">角色</label>

                            <div class="col-sm-10">
                                <div class="radio-inline i-checks">
                                    <label>
                                        <input type="radio" value="admin" name="role" id="role_admin"> 管理员</label>
                                </div>
                                <div class="radio-inline i-checks">
                                    <label>
                                        <input type="radio" value="ordinary" name="role" id="role_ordinary">
                                        普通用户</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../js/jquery.min.js?v=2.1.4"></script>
<script src="../js/bootstrap.min.js?v=3.3.6"></script>
<script src="../js/content.min.js?v=1.0.0"></script>
<script src="../js/plugins/iCheck/icheck.min.js"></script>
<script src="../js/system/index.js"></script>
<script src="../js/system/currentUserDetail.js"></script>
<script>
    $(document).ready(function () {
        init();
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });

    /**
     * 页面初始化
     */
    function init() {
        $("input[name='role'][value='${currentUser.getRole().getRoleType()}']").attr("checked", true);
        if ('${currentUser.getRole().getRoleType()}' != 'admin') {
            $("input[name='role']").attr("disabled", true);
        }
    }
</script>
</body>


</html>
