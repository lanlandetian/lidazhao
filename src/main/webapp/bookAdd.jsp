<%--
	if(session.getAttribute("hasLogined")==null||!(Boolean)session.getAttribute("hasLogined")) {//没有登录
		response.sendRedirect("login.jsp");
		return;
	}
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>书籍添加</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="bower_components/bootswatch/dist/simplex/bootstrap.css" rel="stylesheet" type="text/css"/>
	<style type="text/css">
		.custom-file-label::after {
			content: "浏览"
		}
	</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<form method="post" autocomplete="off" action="bookAdd" enctype="multipart/form-data" id="bookAddFrom">
						<div class="form-group row">
							<label for="inputBid" class="col-sm-2 col-form-label text-right">大类</label>
							<div class="col-sm-10">
								<select name="bid" class="form-control" id="inputBid">
									<option>---请选择---</option>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<label for="inputSid" class="col-sm-2 col-form-label text-right">小类</label>
							<div class="col-sm-10">
								<select name="sid" class="form-control" id="inputSid">

								</select>
							</div>
						</div>

						<div class="form-group row">
							<label for="inputName" class="col-sm-2 col-form-label text-right">书名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputName" placeholder="书名" name="name" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPrice" class="col-sm-2 col-form-label text-right">价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputPrice" placeholder="价格" name="price" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputAuthor" class="col-sm-2 col-form-label text-right">作者</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputAuthor" placeholder="作者" name="author" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputCbs" class="col-sm-2 col-form-label text-right">出版社</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputCbs" placeholder="出版社" name="cbs" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputCbDate" class="col-sm-2 col-form-label text-right">出版日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputCbDate" placeholder="出版日期" name="cbDate" readonly="readonly" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputDescri" class="col-sm-2 col-form-label text-right">简介</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="inputDescri" placeholder="简介" name="descri"></textarea>
							</div>
						</div>

						<div class="form-group row">

							<label for="inputPhoto" class="col-sm-2 col-form-label text-right">头像</label>
							<div class="col-sm-10">
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="inputPhoto" aria-describedby="inputGroupFileAddon04"
										   name="photo"> <label class="custom-file-label" for="inputPhoto">请选择文件</label>
								</div>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">添加</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<script type="text/javascript">
    /*  var xhr = new XMLHttpRequest();
      xhr.open("GET","findAllBigType");//开启报号
      xhr.send();//点击拨打
      xhr.onreadystatechange = function() {
          if(xhr.readyState==4){//请求完全接收到了
            if(xhr.status==200){//请求成功了
              // console.dir(xhr.responseText);
                //让字符串中JavaScript代码执行
                eval(xhr.responseText);
             }
          }
      }*/

    function fillSel(types) {
        for (var i = 0; i < types.length; i++) {
            var op = new Option(types[i].name,types[i].id);
            document.getElementById("inputBid").appendChild(op);
        }
    }
    function fillSmallSel(types) {
        //添加之前清除以后
        document.getElementById("inputSid").innerHTML="";
        for (var i = 0; i < types.length; i++) {
            var op = new Option(types[i].name,types[i].id);
            document.getElementById("inputSid").appendChild(op);
        }
    }
    //动态创建Script
    /*var script = document.createElement("script");
        script.src = "findAllBigType";
        document.body.appendChild(script);*/
    /*console.dir($);*/
    console.dir($);
    $.ajax({
        url:"findAllBigType",
        dataType:"jsonp",
        jsonpCallback:"fillSel"
    });
    //给大类chang
    $("#inputBid").change(function() {
        $.ajax({
            url:"findAllSmallType",
            dataType:"jsonp",
            data:"bid="+$(this).val(),
            jsonpCallback:"fillSmallSel"
        });
    });
    //日历控件
    $('#inputCbDate').datepicker({
        language : 'zh-CN',//修改界面语言
        format : 'yyyy-mm-dd',//修改日期格式
        autoclose : true,//让自动关闭
        defaultViewDate : {
            year : new Date().getFullYear() - 18
        }
    });
</script>
<!-- <script type="text/javascript" src="findAllBigType"></script>-->
<!-- 一个Script只能拿一次 -->
<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
<!--加上文件验证，在他下面加上js-->
<script type="text/javascript" src="bower_components/jquery-validation/dist/additional-methods.js"></script>
<script type="text/javascript" src="bower_components/jquery-validation/src/localization/messages_zh.js"></script>
<script type="text/javascript">
    $(function () {
        $("#bookAddFrom").validate({
            rules: {//严重规则
                price: {
                    required: true,
                    number: true
                },
                descri: {
                    required: true,
                    maxlength: 120
                },
                photo:{
                    required: true,
                    accept:"image/*"
                }
            },
            messages:{//严重不同过，应该显示的消
                price:{
                    required:"价格必选",
                    number:"必须是数字"
                }
            },
            errorElement:"div",
            errorClass:"invalid-feedback",//错误消息的样式
            highlight: function(element, errorClass, validClass) {//高亮显示：如果输入框没有通过验证
                $(element).addClass("is-invalid").removeClass(validClass);
                //由于bootstrop4不支持lobel设置样式，因而下面不需要做
                //    $(element.form).find("label[for=" + element.id + "]")
                //         .addClass(errorClass);
            },
            unhighlight: function(element, errorClass, validClass) {//取消高亮：如果我们把错误纠正
                $(element).removeClass("is-invalid").addClass(validClass);
                //     $(element.form).find("label[for=" + element.id + "]")
                //        .removeClass(errorClass);
            },
            validClass:"is-valid"//制定纠正正确时候输入框的样式
        });
    });

</script>
</body>
</html>