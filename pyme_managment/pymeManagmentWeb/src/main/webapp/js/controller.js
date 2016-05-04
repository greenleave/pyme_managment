var app = angular.module('mainApp', ['ngRoute']);

app.config(function($routeProvider){
	$routeProvider.when('/',{
		templateUrl: 'login.html'
	}).when('/dashboard', {
		templateUrl: 'main.html'
	})
	.otherwise({
		redirectTo: '/'
	});
});


app.controller('loginController',['$scope','$location', '$http', function($scope, $location, $http){
			$scope.login = function(){
			var user = {User: {"userName": $scope.userName, "password": $scope.password} };
			var response =  $http.post('http://localhost:8080/pymeManagmentController/login', user);
			response.success(function(){
				alert("hola");
				$location.path('/dashboard');
			});
			response.error(function(){
				alert("Todo una cagada");
				$location.href= 'www.google.com';
			})
	};
}]);
/*

app.controller('loginController', ['$scope', function($scope) {
    $scope.count = 0;
    $scope.myFunc = function() {
      alert("hola")
    };
  }]);*/