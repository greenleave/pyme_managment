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