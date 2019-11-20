var contextnum;
// var path=$("#path").val();
$(function(){
    ax(1);
    //添加按钮事件
    $("#add").click(function () {

        selectajax();
        $('#adminModal').modal({
            backdrop:"static"
        });
    });

    //添加模块，点击保存事件
    $("#submit").click(function () {

        if ($("#inputEmail3").val()=="") {
            $("#empname").addClass("has-error");
            $("#helpBlock2").text("姓名不能为空");
            return;
        }
        if ($(this).attr("aj")!="success"&&$(this).attr("aj")!="EmailFormat"){
            $("#empname").addClass("has-error");
            $("#helpBlock2").text($(this).attr("aj"));
            return;
        }
        if ($("#inputPassword3").val()=="") {
            $("#empemail").addClass("has-error");
            $("#helpBlock3").text("邮箱不能为空");
            return;
        }
        if ($(this).attr("aj")=="EmailFormat"){
            $("#empemail").addClass("has-error");
            $("#helpBlock3").text("邮箱格式不正确");
            return;
        }
        $.ajax({
                    url:"emps/add",
                    data:$("#adminModal form").serialize(),
                    type:"POST",
                    success:function (result) {
                        alert(result.msg);
                        $('#adminModal').modal("hide");
                        ax(9999);
                    }
                });
    });

    //校验用户名是否重复,是否规范
    $("#inputEmail3").change(function () {

        var inputEmail3=$("#inputEmail3").val();
        var name=/^[\u4E00-\u9FA5A-Za-z]{2,10}$/;
        if (!name.test(inputEmail3)){
            $("#empname").addClass("has-error");
            $("#helpBlock2").text("用户名只能为2至10位的中文或英文");
            $("#submit").attr("aj","用户名只能为2至10位的中文或英文");
            return;
        }else {
            $("#empname").removeClass("has-error");
            $("#empname").addClass("has-success");
            $("#helpBlock2").text("");
            $("#submit").attr("aj","success");
        }

        $.ajax({
            url:"emps/prove",
            data:"empname="+$("#inputEmail3").val(),
            type:"GET",
            success:function (result) {
                if (result.code==200){
                    $("#empname").removeClass("has-error");
                    $("#empname").addClass("has-success");
                    $("#helpBlock2").text("用户名可以用");
                    $("#submit").attr("aj","success");
                }else {
                    $("#empname").addClass("has-error");
                    $("#helpBlock2").text("用户名重复");
                    $("#submit").attr("aj","用户名重复");
                }

            }
        });
    });
    //校验添加模块邮箱是否规范
    $("#inputPassword3").change(function () {
        var inputPassword3=$("#inputPassword3").val();
        var email=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!email.test(inputPassword3))
        {
            $("#empemail").addClass("has-error");
            $("#helpBlock3").text("邮箱格式不正确");
            $("#submit").attr("aj","EmailFormat");
            return false;
        }else {
            $("#empemail").removeClass("has-error");
            $("#empemail").addClass("has-success");
            $("#helpBlock3").text("");
            $("#submit").attr("aj","success");
        }
    });
    //校验编辑模块邮箱是否规范
    $("#edit_email").change(function () {
        var inputPassword3=$("#edit_email").val();
        var email=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!email.test(inputPassword3))
        {
            $("#edit_empemail").removeClass("has-success");
            $("#edit_empemail").addClass("has-error");
            $("#edit_hint_email").text("邮箱格式不正确");
            $("#modification").attr("aj","EmailFormat");
        }else {
            $("#edit_empemail").removeClass("has-error");
            $("#edit_empemail").addClass("has-success");
            $("#edit_hint_email").text("");
            $("#modification").attr("aj","success");
        }
    });
    //点击编辑按钮事件
    $(document).on("click",".edit",function () {

        $("#edit_empemail").removeClass("has-error");
        $("#edit_empemail").removeClass("has-success");
        $("#edit_hint_email").text("");

        $("#editModal form")[0].reset();

        $("#edit_select select").empty();
        $.ajax({
            url:"emp/getDepartment",
            data:"",
            asyn:"false",
            type:"GET",
            success:function (result) {
                getdepart(result,"#edit_select select");
            }
        });

        $.ajax({
            url:"emps/selectedit",
            data:"id="+$(this).attr("id"),
            asyn:"false",
            type:"GET",
            success:function (result) {
                var empss=result.extend.emp;

                var deptName=empss.department.deptId
                var gender=empss.gender;
                $("#editModal form input[name=empId]").val(empss.empId);
                $("#editname strong").text(empss.empName);
                $("#edit_email").val(empss.email);
                $("#editModal input[name=gender]").val([gender]);
                $("#editselect").val([deptName]);
            }
        });

        $('#editModal').modal({
            backdrop:"static"
        });
    });

    //编辑模块修改按钮
    $("#modification").click(function () {

        if ($("#edit_email")=="") {
            $("#edit_empemail").addClass("has-error");
            $("#edit_hint_email").text("邮箱不能为空!");
            return;
        }
        if ($("#modification").attr("aj")!="success") {

            $("#edit_empemail").addClass("has-error");
            $("#edit_hint_email").text("邮箱格式不正确");

            return;
        }
        $.ajax({
            url:"emps/update",
            data:$("#editModal form").serialize(),
            type:"POST",
            success:function (result) {
                alert(result.msg);
                $('#editModal').modal("hide");
                ax(contextnum);
            }
        });
    });

    $(document).on("click",".editdelet",function () {

        var empname=$(this).parents("tr").find("td:eq(2)").text();
        var empid=$(this).attr("editdelet_id");
        if (confirm("确认删除'"+empname+"'吗?")){
            $.ajax({
                url:"emps/edit_delet/"+empid,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    ax(contextnum);
                }
            });
        }
    });

    $("#check_all").click(function () {

        $(".check_item").prop("checked",$(this).prop("checked"));

    });

    $(document).on("click",".check_item",function () {

        var flag=$(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);

    });

    $("#deleteAll").click(function () {

        var s="";
        var ids="";
        $.each($(".check_item:checked"),function () {
            s+=$(this).parents("tr").find("td:eq(2)").text()+",";
            ids+=$(this).parents("tr").find("td:eq(1)").text()+"-";
        });

        s=s.substring(0,s.length-1);
        ids=ids.substring(0,ids.length-1);
        if (confirm("确定删除'"+s+"'吗？")){
            $.ajax({
                url:"emps/edit_delet/"+ids,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    ax(contextnum);
                }
                
            });
        }


    });

});


//刷新添加模块，并动态添加模块中下拉框的数据
function selectajax() {

    alert("selectajax");
    $("#adminModal form")[0].reset();
    $("#empname").removeClass("has-error").removeClass("has-success");
    $("#helpBlock2").text("");
    $("#empemail").removeClass("has-error").removeClass("has-success");
    $("#helpBlock3").text("");
    $("#dep_select select").empty();
    $.ajax({
        url:"emp/getDepartment",
        data:"",
        type:"GET",
        success:function (result) {
            getdepart(result,"#dep_select select");
        }
    });
}
//页面初始化
function ax(pn) {

    $("#check_all").prop("checked",false);

    $.ajax({
        url:"emps/All",
        data:"pn="+pn,
        type:"GET",
        success:function (result) {
            build_emps_table(result);
            build_page_info(result);
            build_page_nav(result);
        }
    });
}
//获取并设置表单数据
function build_emps_table(result) {
    $("#ssm_table tbody").empty();
    var emps=result.extend.pageInfo.list;
    $.each(emps,function (index,item) {
        var checkbox=$("<td><input type='checkbox' class='check_item'/></td>");
        var empid=$("<td></td>").append(item.empId);
        var empname=$("<td></td>").append(item.empName);
        var gender=$("<td></td>").append(item.gender);
        var email=$("<td></td>").append(item.email);
        var deptname=$("<td></td>").append(item.department.deptName);
        var button1=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
                    .append("编辑").addClass("btn btn-primary btn-sm edit").attr("id",item.empId);
        var button2=$("<button></button>")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
            .append("删除").addClass("btn btn-warning btn-sm editdelet").attr("editdelet_id",item.empId);
        var operation=$("<td></td>").append(button1).append(button2);
        var tr=$("<tr></tr>").append(checkbox)
                             .append(empid)
                             .append(empname)
                             .append(gender)
                             .append(email)
                             .append(deptname)
                             .append(operation)
            .appendTo("#ssm_table tbody");
    });
}

//分页记录
function build_page_info(result) {
    $("#page_info_area").empty();
    var emps=result.extend.pageInfo;
    var pagenum=emps.pageNum;
    var pages=emps.pages;
    var total=emps.total;
    var pageSize=emps.pageSize;

    $("#page_info_area").append("当前第"+pagenum+"页,")
                        .append("总"+pages+"页,")
                        .append("总记录"+total+"条,")
                        .append("每页"+pageSize+"条记录");
}

//导航栏
function build_page_nav(result) {
    $("#page_nav_area").empty();
    var emps=result.extend.pageInfo;
    var pagenum=emps.pageNum;
    contextnum=emps.pageNum;
    var pages=emps.pages;
    var navigatepageNums=emps.navigatepageNums;
    var fist=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
    fist.click(function () {
        ax(1);
    });
    var last=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
    last.click(function () {
        ax(pages);
    });
    var laquo=$("<li></li>").append($("<a></a>")
                                        .attr("href","#")
                                        .append($("<span></span>")
                                        .append("&laquo;")));
    laquo.click(function () {
        ax(pagenum-1);
    });
    var raquo=$("<li></li>").append($("<a></a>")
                                        .attr("href","#")
                                        .append($("<span></span>")
                                        .append("&raquo;")));
    raquo.click(function () {
        ax(pagenum+1);
    });

    var ul=$("<ul></ul>").addClass("pagination pagination-sm");
    var nav=$("<nav></nav>");
    if (emps.hasPreviousPage){
        ul.append(fist).append(laquo);
    }

    $.each(navigatepageNums,function (index,item) {
        var li=$("<li></li>").append($("<a></a>").append(item).attr("href","#"))
        if(pagenum==item){
            li.addClass("active");
        }
        li.click(function () {
            ax(item);
        });
        ul.append(li);
    });
    if (emps.hasNextPage){
        ul.append(raquo).append(last)
    }

    nav.append(ul).appendTo("#page_nav_area");
}

//为添加模块中的下拉框动态添加数据
function getdepart(result,id) {
    $.each(result,function (index,item) {
        $("<option></option>").append(item.deptName).appendTo(id).attr("value",item.deptId);
    });
}

