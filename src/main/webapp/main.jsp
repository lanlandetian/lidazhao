<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset=utf-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" id="themeLink" />
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.slim.js"></script>
	<script type="text/javascript" src="bower_components/jquery.cookie/jquery.cookie.js"></script>
	<script type="text/javascript">
        if ($.cookie("bootstrapTheme")) {
            $("#themeLink").attr("href","bower_components/bootswatch/dist/"+$.cookie("bootstrapTheme")+"/bootstrap.css");

        } else {
            $("#themeLink").attr("href","bower_components/bootswatch/dist/cerulean/bootstrap.css");
        }
	</script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">

				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="img/2345_image_file_copy_15.jpg" style="height: 40px"></a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item active">
							<a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Link</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
							>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="#">Separated link</a>
							</div>
						</li>
					</ul>
					<form class="form-inline">
						<input class="form-control mr-sm-2" type="text" />
						<button class="btn btn-primary my-2 my-sm-0" type="submit">
							Search
						</button>

					</form>
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item active">
							<a class="nav-link" href="javascript:void(0)">
								<select id="themeSel" class="custom-select">
									<option>cerulean</option>
									<option>cosmo</option>
									<option>cyborg</option>
									<option>darkly</option>
									<option>litera</option>
									<option>lux</option>
								</select>
							</a></li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="#">Separated link</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="carousel slide" id="carousel-442819">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-442819" class="active"></li>
					<li data-slide-to="1" data-target="#carousel-442819"></li>
					<li data-slide-to="2" data-target="#carousel-442819"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" alt="Carousel Bootstrap First" src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg" />
						<div class="carousel-caption">
							<h4>First Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies
								vehicula ut id elit.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Second" src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies
								vehicula ut id elit.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Third" src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
						<div class="carousel-caption">
							<h4>Third Thumbnail label</h4>
							<p class="text-center">夏大爷爷版权所有&copy;</p>
							<p>
								<a class="btn" href="mailto:22222@qq.com">22222 》</a>
							</p>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carousel-442819" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a>
				<a class="carousel-control-next" href="#carousel-442819" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div id="card-356371">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse" data-parent="#card-356371" href="#card-element-237682">Collapsible Group Item #1</a>
					</div>
					<div id="card-element-237682" class="collapse show">
						<div class="card-body">Anim pariatur cliche...</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse" data-parent="#card-356371" href="#card-element-77804">Collapsible Group Item #2</a>
					</div>
					<div id="card-element-77804" class="collapse">
						<div class="card-body">Anim pariatur cliche...</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function() {
        $("#themeSel").val($.cookie("bootstrapTheme"));
        $("#themeSel").change(
            function (evt) {


           /// $("#themeLink").attr("href","bower_components/bootswatch/dist/"+$(evt.target).val()+"/bootstrap.css");
            $("#themeLink").attr("href",
			"bower_components/bootswatch/dist"
			+$(evt.target).val()
				+"/bootstrap.css");
				$.cookie("bootstrapTheme",$(evt.target).val(),{ expires: 30 });
        });

    });

</script>
</body>
</html>