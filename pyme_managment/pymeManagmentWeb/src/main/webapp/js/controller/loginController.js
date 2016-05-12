angular.module('mainApp').controller('loginController', ['$scope', '$window',function($scope, $window){
	$scope.login = function(){
		var datos = loginService.loginUser('as','12345678a');
		console.log(datos);
		datos.then(function(data){
			if(data==""){
				alert("El usuario o el password es invalido");
			}
			else{
				alert("Deberia funcionar");
				console.err("Este es el scope");
				console.log($scope);
				console.err("Este es el window");
				console.log($window);
				//$window.location.href='/dashboard';
			}
		});
	}
	function initController(){
		loginService.clearCredentials;
	}
}]);
//Estoy inyectando scope que es donde tengo todo el entorno
//Y window que es lo que me permite cambiar de ventana

// function loginUserController($scope,$window, loginService) {
// }







// angular.module('mainApp').controller('loginController', loginUserController);
// loginUserController.$inject['$scope','$location'];
// function loginUserController($scope,$location, loginService) {



// 	$scope.login = function(){
// 		// var datos = loginService.getDatos($scope.userName, $scope.password);
// 		var datos = loginService.loginUser('as','12345678a');
// 		console.log(datos);
// 		datos.then(function(data){
// 			if(data==""){
// 				alert("El usuario o el password es invalido");
// 			}
// 			else{
// 				alert("Deberia funcionar");
// 				$location.path="/dashboard";
// 			}
// 		});
// 	}

// 	function initController(){
// 		loginService.clearCredentials;
// 	}
// }