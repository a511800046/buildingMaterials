/**
 * description: 退出系统
 * author: chengy
 * create: 2019-01-25 13:02
 **/
function system_logout() {
    var form = document.createElement('form');
    form.action = 'logout';
    form.method = 'post';
    $(document.body).append(form);
    form.submit();

}


/**
 * description: 时间显示
 * author: chengy
 * create: 2019-01-25 13:02
 **/
function showTime() {
    nowtime = new Date();
    year = nowtime.getFullYear();
    month = nowtime.getMonth() + 1;
    date = nowtime.getDate();
    document.getElementById("mytime").innerText = year + "年" + month + "月" + date + "日  " + nowtime.toLocaleTimeString();
}