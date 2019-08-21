/**
 * Created by jora on 2019/6/19.
 */

function loginBtn() {
    var name=$("#name").val();
    var password=$("#password").val();
    var reg=/^[a-z0-9_-]{6,18}$/;
    if(name==""||password==""){
        alert("用户名或密码不能为空");
    }else if(!reg.test(password)){
        alert("密码长度不少于6位");
    }else {
        $.post("isLogin.do", { "name": name,"password":password },
            function(data){
                if(data.trim()=="loginOk"){
                    window.location="main.html";
                }else {
                    alert(data);
                }
            });
    }

}