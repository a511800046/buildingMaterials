<link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
<script src="../js/plugins/iCheck/icheck.min.js"></script>
<script>
    //页面加载所要进行的操作
    $(function () {
        //设置ajax当前状态(是否可以发送);
        ajaxStatus = true;
    });

    // ajax封装
    function ajax(url, data, success, alone, async, type, dataType, error) {
        // debugger;
        var type = type || 'post';//请求类型
        var dataType = dataType || 'json';//接收数据类型
        var async = async || false;//异步请求
        var alone = alone || false;//独立提交（一次有效的提交）
        var success = success;//成功回调函数
        var layerIndex;
        var error = error || function (data) {
            console.error('请求失败');
            /*data.status;//错误状态码*/
            if (data.status == 404) {
                layerIndex = layer.msg('请求失败，请求未找到');
            } else if (data.status == 500) {
                layerIndex = layer.msg('请求失败，服务器内部错误');
            } else {
                layerIndex = layer.msg('请求失败,状态码：' + data.status);
            }
            ajaxStatus = true;
        };
        /*判断是否可以发送请求*/
        if (!ajaxStatus) {
            return false;
        }
        ajaxStatus = false;//禁用ajax请求
        /*正常情况下1秒后可以再次多个异步请求，为true时只可以有一次有效请求（例如添加数据）*/
        if (!alone) {
            ajaxStatus = true;
        }
        $.ajax({
            'url': url,
            'data': data,
            'type': type,
            'dataType': dataType,
            'async': async,
            'success': success,
            'error': error,
            'scriptCharset': 'utf-8',
            'jsonpCallback': 'jsonp' + (new Date()).valueOf().toString().substr(-4),
            'beforeSend': function () {
                layerIndex = layer.msg('加载中', {//通过layer插件来进行提示正在加载
                    icon: 16,
                    shade: 0.01
                });
            },
            'complete': function () {
                layer.close(layerIndex);
            }
        });
    }

    // submitAjax(post方式提交)
    function submitAjax(form, success, alone) {
        var form = document.getElementById(form);
        var url = form.action;
        var data = serialize(form);
        ajax(url, data, success, alone, false, 'post', 'json');
    }


    // ajax提交(post方式提交)
    function post(url, data, success, alone) {
        ajax(url, data, success, alone, false, 'post', 'json');
    }

    // ajax提交(get方式提交)
    function get(url, success, alone) {
        ajax(url, {}, success, alone, false, 'get', 'json');
    }

    // jsonp跨域请求(get方式提交)
    function jsonp(url, success, alone) {
        ajax(url, {}, success, alone, false, 'get', 'jsonp');
    }

    //form序列化
    function serialize(form) {
        var parts = [],
            field = null,
            i,
            len,
            j,
            optLen,
            option,
            optValue;

        for (i = 0, len = form.elements.length; i < len; i++) {
            field = form.elements[i];

            switch (field.type) {
                case "select-one":
                case "select-multiple":

                    if (field.name.length) {
                        for (j = 0, optLen = field.options.length; j < optLen; j++) {
                            option = field.options[j];
                            if (option.selected) {
                                optValue = "";
                                if (option.hasAttribute) {
                                    optValue = (option.hasAttribute("value") ? option.value : option.text);
                                } else {
                                    optValue = (option.attributes["value"].specified ? option.value : option.text);
                                }
                                parts.push(encodeURIComponent(field.name) + "=" + encodeURIComponent(optValue));
                            }
                        }
                    }
                    break;

                case undefined: //fieldset
                case "file": //file input
                case "submit": //submit button
                case "reset": //reset button
                case "button": //custom button
                    break;

                case "radio": //radio button
                case "checkbox": //checkbox
                    if (!field.checked) {
                        break;
                    }
                /* falls through */

                default:
                    //don't include form fields without names
                    if (field.name.length) {
                        parts.push(encodeURIComponent(field.name) + "=" + encodeURIComponent(field.value));
                    }
            }
        }
        return parts.join("&");
    }

</script>