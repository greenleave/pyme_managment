var pymeManagmentApp = angular.module('pymeManagmentApp', [ 'ngRoute' ])
/*
var pymeManagmentApp = angular.module('pymeManagmentApp', [ 'ngRoute' ])
.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        when('/',{
		templateUrl: '../html/login.html'
		}).otherside({
			redirectTo: 'www.google.com.ar'
		});
});
*/
/*
var app = angular.module('pymeManagmentApp',[ 'ngRoute' ]);
app.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/',{
		templateUrl: 'login.html'
	}).otherside({
		redirectTo: '/'
	});
}]);
*/

/*
app.controller('loginController', function($scope){
    $scope.submit = function(){
    	var uname = $scope.username;
    	var pass = $scope.pass;
    	alert("Hola");
    });
  });
 */ 
/**
	Basicamente aca empiezo a definir la app y a donde iria cada cosa. 
	Es decir si llega un pedido sobre una pagina en especial primero angular
	va a  ver si ya tiene definida alguna accion para la misma
**/