<!DOCTYPE html>
<html ng-app="undergroundAdmin">
	<head>
		<title>Underground</title>
		<meta content="text/html; charset=utf-8" http-equiv="content-type">
		<link rel= "stylesheet" type="text/css" href="/static/css/stylescroll.css">
		<link rel= "stylesheet" type="text/css" href="/static/css/style.css">
		<link href="https://fonts.googleapis.com/css?family=Lobster|Raleway" rel="stylesheet">
		<script src="/static/js/lib/angular.js"></script>
     	<script src="/static/js/lib/angular-resource.js"></script>
     	<script src="/static/js/lib/angular-route.js"></script>
		<script src="/static/js/app.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-filter/0.5.14/angular-filter.js"></script>
	</head>
	<body>
	<div class="header_">
		<div>
		<a href="/#/page/0"><img class="header__logo" src="/static/pic/logo.png"></a>
		</div>
		<auth></auth>
		<ng-view></ng-view>
		
		
	</div>
	
	</body>
</html>

