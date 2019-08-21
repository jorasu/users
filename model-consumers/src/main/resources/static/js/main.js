/**
 * Created by jora on 2019/6/19.
 */
$(function () {
    $.post("queryByName.do",
        function(data){
           $("#name").text(data.name);
           $("#type").text(data.tname);
        }, "json");

});
var pNo=1;
function searchInfo(pNo){
  /* $("#wel").css().hide();*/
    var info1=`  <p>会员管理</p>
             <p>用户名：<input type="text" id="tname" name="tname">
                       <input type="button" onclick="searc()" value="查询"></p>
               <table>
                   <tr>
                       <th>序号</th>
                       <th>用户名</th>
                       <th>用户类别</th>
                       <th>用户状态</th>
                       <th>最后修改时间</th>
                   </tr>  
               </table>
                <div id="page">
               
                </div>
`;
    $("#content_right").html(info1);
    var name=$("#tname").val();
    $.post("query.do", { "name": name ,"pNo":pNo},
        function(data){
            var info1="";
            if(data!=null){
                $(".tr").remove();
                $(data.list).each(function () {
                    info1+=`  <tr class="tr">
                       <td>${this.id}</td>
                       <td>${this.name}</td>
                       <td>${this.tname}</td>
                       <td>${this.status==0?"冻结":"正常"}</td>
                       <td>${this.last_modify_time}</td>
                   </tr>`;
                });
            }else {
                info1=`<span>抱歉暂无数据！</span>`;
                }

            $("table").append(info1);

            var pageInfo=`<a href="javascript:;" onclick="pageAjax(1)">首页</a>
                   <a href="javascript:;" onclick="pageAjax(${data.prePage})">上一页</a>
                   <a href="javascript:;" onclick="pageAjax(${data.nextPage})">下一页</a>
                   <a href="javascript:;" onclick="pageAjax(${data.pages})">尾页</a>
                     第<span>${data.pageNum}</span>页/共<span>${data.pages}</span>页(${data.total})条`;
                    $("#page").html(pageInfo);
        }, "json");
}
function searc() {
    var name=$("#tname").val();
    alert(name);
    $.post("query.do", { "name": name ,"pNo":pNo},
        function(data){
            var info1="";
            if(data!=null){
                $(".tr").remove();
                $(data.list).each(function () {
                    info1+=`  <tr class="tr">
                       <td>${this.id}</td>
                       <td>${this.name}</td>
                       <td>${this.tname}</td>
                       <td>${this.status==0?"冻结":"正常"}</td>
                       <td>${this.last_modify_time}</td>
                   </tr>`;
                });
            }else {
                info1=`<span>抱歉暂无数据！</span>`;
            }

            $("table").append(info1);

            var pageInfo=`<a href="javascript:;" onclick="pageAjax(1)">首页</a>
                   <a href="javascript:;" onclick="pageAjax(${data.prePage})">上一页</a>
                   <a href="javascript:;" onclick="pageAjax(${data.nextPage})">下一页</a>
                   <a href="javascript:;" onclick="pageAjax(${data.pages})">尾页</a>
                     第<span>${data.pageNum}</span>页/共<span>${data.pages}</span>页(${data.total})条`;
            $("#page").html(pageInfo);
        }, "json");
}
function pageAjax(pNo) {
    if(pNo=='0'){
        alert("不能翻页");
        return;
    }else {
        searchInfo(pNo);
    }
}

function pwd() {
     var info=` <h3>修改密码</h3>
             <p> 原始密码： <input type="password" id="oldPwd" name="oldPwd"></p>
             <p> 新密码： <input type="password" id="newPwd" name="newPwd"></p>
             <p> 确认密码： <input type="password" id="renewPwd" name="renewPwd"></p>
              <p><input type="button" onclick="update()" value="修改">
                  <input type="button" onclick="javascript:history.back(-1)" value="返回"></p>`;
    $("#content_right").html(info);

}

function update(){
    var oldPwd=$("#oldPwd").val();
    var newPwd=$("#newPwd").val();
    var name=$("#name").text();
   var renewPwd=$("#renewPwd").val();
    if(oldPwd==""||newPwd==""||renewPwd==""){
        alert("密码不能为空");
    }else if(newPwd!=renewPwd){
        alert("密码不一致");
    }else {
        $.post("updPwd.do", { "oldPwd": oldPwd,"newPwd":newPwd,"name":name },
            function(data){
                alert(data);
            });
    }
}

