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

app.controller('loginCtrl',function($scope, $location){
		$scope.submit = function(){
			$window.alert("HOla maldito mundo");
			var uname=$scope.username;
			var password = $scope.password;
			if( $uname == 'admin'  && $password == 'admin'){
				$location.path('/dashboard');
			}
	}
})