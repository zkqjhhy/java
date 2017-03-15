var http= "http://www.zkh267.xin:8080/";
$(function () {
    if(navigator.appName="Microsoft Internet Explorer"){
        jQuery.support.cors = true;
    }
    $("#send").click(function () {
        send();
    })
});
function send() {
    var number = $("#number").val();
    var pwd = $("#pwd").val();
    var sex = $("#sex").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var state = parseInt(1);
    $(".body input").each(function () {
        if ($(this).val() == "") {
            alert("请填写必要信息");
            return false;
        }
    });
   /* var msg = new Object();
    msg.uName = number;
    msg.uPwd = pwd;
    msg.sex = parseInt(sex);
    msg.state = parseInt(1);
    msg.uPhone = phone;
    msg.uEmail = email;
    var str = JSON.stringify(msg);*/
    var reg1 = /^\d{11}$/;
    if (!reg1.test(phone)) {
        alert("手机号码格式不正确");
        return;
    }
    var reg2 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!reg2.test(email)) {
        alert("请输入正确是邮箱格式");
        return;
    }
    $.ajax({
//        url: http+"zkq/teacher/register",
        url: "/teacher/register",
        type: "post",
        dataType: "json",
        data: {"tPhone":phone,"tName":number,"tEmail":email,"password":pwd,"tState":state,"gender":sex},
//        contentType: "application/json",
        success: function (data) {
            if (data.code == 0) {
                alert(data.message);
               window.location.href = "../login.html";
            }else{
            	  alert(data.message);
                return;
            }
        }
    });
}
