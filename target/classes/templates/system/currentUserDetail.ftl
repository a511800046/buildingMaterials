<#include  "/common/pageCommon.ftl" />
<#include  "/common/pageForm.ftl" />
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
    <script src="../js/system/currentUserDetail.js"></script>

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
                    <!-- /currentUser/saveCurrentUserInfo-->
                    <form method="pose" class="form-horizontal" action="/currentUser/saveCurrentUserInfo"
                          id="CurrentUserInfoForm" name="CurrentUserInfoForm">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">登陆用户名</label>

                            <div class="col-sm-10">
                                <p class="form-control-static">${currentUser.getUser().getUserId()}</p>
                                <input type="hidden" name="userId" value="${currentUser.getUser().getUserId()}"/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="userName"
                                       value="${currentUser.getUser().getUserName()}"/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="passWord"
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
                                <#--<button class="btn btn-primary" type="submit">保存内容</button>-->
                                <input class="btn btn-primary" onclick="onClickTest1()" type="button" value="保存内容"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    /**
     * 页面初始化
     */
    function init() {
        //当不是系统管理员的权限的时候，不允许修改角色
        $("input[name='role'][value='${currentUser.getRole().getRoleType()}']").attr("checked", true);
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",});
        if ('${currentUser.getRole().getRoleType()}' != 'admin') {
            $("input[name='role']").attr("disabled", true);
        }
    }

    function onClickTest1() {
        // layer.prompt({title: '输入任何口令，并确认', formType: 1}, function(pass, index){
        //     layer.close(index);
        //     layer.prompt({title: '随便写点啥，并确认', formType: 2}, function(text, index){
        //         layer.close(index);
        //         layer.msg('演示完毕！您的口令：'+ pass +'<br>您最后写下了：'+text);
        //     });
        // });
        submitAjax("CurrentUserInfoForm", function (data) {
            //alert(data);
            for (var tempi = 1; tempi <= 1000; tempi++) {
                console.log(tempi);
            }

        }, false);

    }


    $(document).ready(function () {
        init();
    });
</script>
</body>


</html>
