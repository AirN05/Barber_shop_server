<!DOCTYPE html>
<html ng-app="underground">
	<head>
		<title>Underground</title>
		<meta content="text/html; charset=utf-8" http-equiv="content-type">
		<link rel= "stylesheet" type="text/css" href="/static/css/style.css">
		<link rel= "stylesheet" type="text/css" href="/static/css/stylescroll.css">
		<link rel="shortcut icon" href="/static/pic/logo3.png" type="image/png">
		<link href="https://fonts.googleapis.com/css?family=Lobster|Raleway" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Ribeye+Marrow|Rye" rel="stylesheet">
		<script src="/static/js/lib/angular.js"></script>
     	<script src="/static/js/lib/angular-resource.js"></script>
     	<script src="/static/js/lib/angular-route.js"></script>
		<script src="/static/js/app.js"></script>
		
	</head>
	<body>
	<div class="header_">
		<div>
		<a href="/#/page/0"><img class="header__logo" src="/static/pic/logo2.png"></a>
		</div>

		<ng-view></ng-view>
		
		
	</div>
	
	</body>
	<!-- <footer>footer</footer> -->
</html>

