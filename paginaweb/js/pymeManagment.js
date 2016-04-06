/**
	Basicamente aca empiezo a definir la app y a donde iria cada cosa. 
	Es decir si llega un pedido sobre una pagina en especial primero angular
	va a  ver si ya tiene definida alguna accion para la misma
**/
var app = angular.module('pymeManagmentApp');
app.config(function($routeProvider){
	$routeProvider.when('/',{
		templateUrl: 'login.html'
	}).otherside({
		redirectTo: '/'
	});
});

app.controller('loginController', function($scope){
    $scope.submit = function(){
    	var uname = $scope.username;
    	var pass = $scope.pass;
    	alert("Hola");
    });
  });
