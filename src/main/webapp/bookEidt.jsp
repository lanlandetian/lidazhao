<%--
	if(session.getAttribute("hasLogined")==null||!(Boolean)session.getAttribute("hasLogined")) {//没有登录
		response.sendRedirect("login.jsp");
		return;
	}
--%>
<%@ page import="com.oraclewdp.ddbookmarket.model.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>书籍编辑</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="bower_components/bootswatch/dist/sketchy/bootstrap.css" rel="stylesheet" type="text/css"/>
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
					<form method="post" autocomplete="off" action="doBookEdit" enctype="multipart/form-data">
						<%
							Book book = (Book)request.getAttribute("book");
						%>
						<input type="hidden" name="id" value="<%=book.getId()%>">
						<div class="form-group row">
							<label for="inputBid" class="col-sm-2 col-form-label text-right">大类</label>
							<div class="col-sm-10">
								<select name="bid" class="form-control" id="inputBid">
									<option value="-1">---请选择---</option>
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
								<input type="text" class="form-control" id="inputName" placeholder="书名" name="name" value="<%=book.getName()%>" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPrice" class="col-sm-2 col-form-label text-right">价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputPrice" placeholder="价格" name="price" value="<%=book.getPrice()%>" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputAuthor" class="col-sm-2 col-form-label text-right">作者</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputAuthor" placeholder="作者" name="author" value="<%=book.getAuthor()%>" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputCbs" class="col-sm-2 col-form-label text-right">出版社</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputCbs" placeholder="出版社" name="cbs" value="<%=book.getCbs()%>">
							</div>
						</div>

						<div class="form-group row">
							<label for="inputCbDate" class="col-sm-2 col-form-label text-right">出版日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputCbDate" placeholder="出版日期" name="cbDate" readonly="readonly" value="<%=book.getCbDate()%>" >
							</div>
						</div>

						<div class="form-group row">
							<label for="inputDescri" class="col-sm-2 col-form-label text-right">简介</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="inputDescri" placeholder="出版社" name="descri"><%=book.getDescri()%></textarea>
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPhoto" class="col-sm-2 col-form-label text-right">图片</label>
							<div class="col-sm-10">
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="inputPhoto" aria-describedby="inputGroupFileAddon04" name="photo"> <label
										class="custom-file-label" for="inputGroupFile04">请选择文件</label>
								</div>
								<img src="upload/<%=book.getPhoto()%>">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">修改</button>
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
        $("#inputBid").val('<%=request.getAttribute("bid")%>');
        //因为你产生该四件，让小类填充
        $("#inputBid").trigger("change");
    }
    function fillSmallSel(types) {
        //添加之前清除以后
        document.getElementById("inputSid").innerHTML = "";
        for (var i = 0; i < types.length; i++) {
            var op = new Option(types[i].name, types[i].id);
            document.getElementById("inputSid").appendChild(op);
        }
        $("#inputSid").val('<%=book.getSid()%>');
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

</body>
</html>