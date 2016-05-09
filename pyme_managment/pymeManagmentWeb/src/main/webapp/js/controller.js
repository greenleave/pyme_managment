var app = angular.module('mainApp', ['ngRoute']);

app.config(function($routeProvider){
	$routeProvider.when('/',{
		//Le indico a donde tiene que ir o mejor dicho, que templeate tiene que usar.
		templateUrl: 'login.html'
	}).when('/dashboard', {
		//Le indico a que pagina tiene que ir
		templateUrl: 'main.html'
	}).when('/Error',{
		templateUrl: 'error.html'
	})
	.otherwise({
		redirectTo: 'notFound.html'
	});
});