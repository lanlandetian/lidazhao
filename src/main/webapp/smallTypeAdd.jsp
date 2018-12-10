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
	<title>小类添加</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="bower_components/bootswatch/dist/sketchy/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<form method="post" autocomplete="off" action="smallTypeAdd">
						<div class="form-group row">
							<label for="inputBid" class="col-sm-2 col-form-label text-right">大类</label>
							<div class="col-sm-10">
								<select name="bid" class="form-control" id="inputTid">

								</select>
							</div>
						</div>

						<div class="form-group row">
							<label for="inputName" class="col-sm-2 col-form-label text-right">小类名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputName" placeholder="小类名" name="name" >
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
            document.getElementById("inputTid").appendChild(op);
        }
    }
    //动态创建Script
    /*var script = document.createElement("script");
        script.src = "findAllBigType";
        document.body.appendChild(script);*/
    /*console.dir($);*/
    $.ajax({
        url:"findAllBigType",
        dataType:"jsonp",
        jsonpCallback:"fillSel"
    });
</script>


<!-- <script type="text/javascript" src="findAllBigType"></script>-->
<!-- 一个Script只能拿一次 -->
</body>
</html>