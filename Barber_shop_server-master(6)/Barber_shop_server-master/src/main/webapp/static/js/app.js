var app = angular.module("undergroundAdmin", ["ngRoute", "ngResource"]);

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

    .controller("editController", function($scope,$http, $location, $log, $route, $filter){  

        $scope.date = new Date();


  /*for(i=$scope.minDate; i<$scope.maxDate; i++){
    $log.log(i);
    $scope.days=i; html
    $log.log($scope.days);
  }*/

  $scope.onlyWeekendsPredicate = function(date) {
    var day = date.getDay();
    return day === 0 || day === 6;
  };


  $scope.newDate=function(oldDate){
    date = $filter('date')(oldDate, "dd.MM.yyyy");
    $log.log(date);
     return date;
   }

         
        $scope.selectedDate = new Date($scope.selectedDate);
        $http.get('/schedule/get').success(function(data, status, headers, config){
        $scope.schedule = data;
        $log.log($scope.schedule);
        $log.log($scope.selectedDate);
        $log.log($scope.id_res);
            })

         /*$http.get('/res/get').success(function(data, status, headers, config){
        for(var i=0; i<)
        $scope.reserve = data;

         $log.log("res");
        $log.log($scope.reserve);
            })*/

    
    $scope.getDate=function(date){
      var newDate=date.split(" ", 1);
      return newDate;
    }


    $scope.changeSchedule=function(item){
      $log.log("set data");
      $http.post('/schedule/set', item)
        .success(function(data, status, headers, config){
          $log.log(status);
          $log.log($scope.schedule);
            })
            
             
        } 
    

    


        $scope.sendMessage=function(){
            // отправка отзыва на почту
        }

        $http.get('').success(function(data){
            $scope.contacts=data;

        })

        $http.get('/emp/get').success(function(data){
            $scope.employ=data.last;

        })

        $http.get('/shop/get').success(function(data){
            $scope.shop=data.last;

        })

        $http.get('/home/get').success(function(data){
            $scope.images=data.last;

        })


        $http.get('/price/get').success(function(data){
            $scope.price=data.last;

        })

        $scope.save=function(item){
            $scope.allData=item;
           
        }

        $scope.changePrice=function(){
            $log.log($scope.price);
            angular.forEach($scope.price, function(value, key){
               $http.post('/price/get', value)
            .success(function(data, status, headers, config){
            $log.log(status);
            })
            
        })
            $route.reload();  
        } 

        /*{name: $scope.item.name, price: $scope.item.price, options: $scope.item.options} */

        $scope.addPrice=function(){
                $log.log("hi");
                $http.post('/price/get', {name: $scope.newService, price: $scope.newPrice, options: $scope.newOption})
                 .success(function(data, status, headers, config){
                     $log.log(status);
                     $log.log(data);
                     $scope.newService=null;
                     $scope.newPrice=null;
                     $scope.newOption=null;
                     
                })
            }

          $scope.delPrice=function(id, item){
             $scope.delData=item;
            $http.post('/price/get/'+id, $scope.delData)
                 .success(function(data, status, headers, config){
                     $log.log(status);
                     $log.log(data);
          })
          
          }

        $scope.addEmploy=function(){
                $log.log("hi");
                $http.post('/emp/get', {name: $scope.newName,  city: $scope.newCity})
                 .success(function(data, status, headers, config){
                     $log.log(status);
                     $log.log($scope.newPhoto);
                     $scope.newName=null;
                     $scope.newPhoto=null;
                     $scope.newCity=null;
                     

                })
            }

            $scope.changeEmploy=function(){
               $log.log($scope.employ);
            angular.forEach($scope.employ, function(value, key){
               $http.post('/emp/get', value)
            .success(function(data, status, headers, config){
            $log.log(status);
            })
            
        })
            $route.reload();  
        } 
        

            



})

   
// 

    
.directive("menu", function(){
    return {
        templateUrl:"/static/assets/directives/menu.html",
        replace: true,
        restrict: 'E',
        

            controller: function($scope,$log,$http){

       /* $http.get('data/menu.json')
            .success(function(data, status, headers, config){
                 $scope.menu = data;})  */

            /* $http.get('data/shedule.json').success(function(data, status, headers, config){
        $scope.employ = data;
        $log.log($scope.selected);
        $log.log($scope.employ);
      
            })*/

        
}
}})

.directive("auth", function(){
    return {
        templateUrl:"/static/assets/directives/auth.html",
        replace: true,
        restrict: 'E',
        

            controller: function($scope,$log,$http, $rootScope, $location){

                if (!$rootScope.checkAdmin) $location.path('/page/0');


                $scope.auth=function(){

               // $scope.checkAdmin=false;
                $log.log($scope.login);
                $log.log($scope.password);
                $http.post('', {login: $scope.login, password: $scope.password})
                    .success(function(data){
                        $log.log("ok");

                    })

                    if ($scope.login=='admin' && $scope.password=='admin'){
                    $rootScope.checkAdmin=true;
                    $scope.control=true;
                    $log.log( $rootScope.checkAdmin);
                }
                    //$scope.login=null;
                   // $scope.password=null;
            }

            $scope.logout=function(){
                $rootScope.checkAdmin=false;
                $log.log("out");
                $location.path('/index.html');

            }

}
}})



.filter('unique', function () {

  return function (items, filterOn) {

    if (filterOn === false) {
      return items;
    }

    if ((filterOn || angular.isUndefined(filterOn)) && angular.isArray(items)) {
      var hashCheck = {}, newItems = [];

      var extractValueToCompare = function (item) {
        if (angular.isObject(item) && angular.isString(filterOn)) {
          return item[filterOn];
        } else {
          return item;
        }
      };

      angular.forEach(items, function (item) {
        var valueToCheck, isDuplicate = false;

        for (var i = 0; i < newItems.length; i++) {
          if (angular.equals(extractValueToCompare(newItems[i]), extractValueToCompare(item))) {
            isDuplicate = true;
            break;
          }
        }
        if (!isDuplicate) {
          newItems.push(item);
        }

      });
      items = newItems;
    }
    return items;
  };
})


.filter('timestampToDate', function () {
    return function (timestamp) {
        var date = new Date(timestamp * 1000);
        var dateObject = date.getFullYear() +'/'+ ('0' + (date.getMonth() + 1)).slice(-2) +'/'+ ('0' + date.getDate()).slice(-2);
        return dateObject;
    };
})

/*.filter('uniq', function() {
    return function(input, key) {
        var unique = {};
        var uniqueList = [];
        for(var i = 0; i < input.length; i++){
            if(typeof unique[input[i][key]] == "undefined"){
                unique[input[i][key]] = "";
                uniqueList.push(input[i]);
            }
        }
        return uniqueList;
    };
})*/