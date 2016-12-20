var app = angular.module("underground", ["ngRoute", "ngResource"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/page/:id", {
                templateUrl : function(page){
                    
        	return "/static/assets/page-"+page.id+".html"
        },
        controller: "pagesController"
    })
    .otherwise("/page/0")
   
})

    .controller("pagesController",function($scope,$http,$rootScope,$routeParams, $location, $log){
        $scope.page=parseInt($routeParams.id) || 0;
         

    })

    .controller("contentController", function($scope,$http, $log){

       
         $log.log("here");
        
        $scope.sendMessage=function(){
            // отправка отзыва на почту
        }

        $http.get('').success(function(data){
            $scope.contacts=data;

        })

        $http.get('/emp/get/').success(function(data){
            $scope.employ=data.last;
            $log.log($scope.employ);

        })

        $http.get('/shop/get/').success(function(data){
            $scope.shop=data.last;
            $log.log($scope.shop);

        })

        $http.get('/home/get/').success(function(data){
            $scope.images=data.last;
            $log.log($scope.images);

        })


        $http.get('/price/get/').success(function(data){
            $scope.price=data.last;
            $log.log("hi");
        })




    })

.directive("menu", function(){
    return {
        templateUrl:"/static/assets/directives/menu.html",
        replace: true,
        restrict: 'E',
        

            controller: function($scope,$log,$http){

       /* $http.get('/static/data/menu.json')
            .success(function(data, status, headers, config){
                 $scope.menu = data;})  */
}
}})







