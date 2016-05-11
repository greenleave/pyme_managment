angular.module('mainApp').controller('loginController', loginUserController);
loginUserController.$inject['$scope','$location'];
function loginUserController($scope,$location, loginService) {



	$scope.login = function(){
		// var datos = loginService.getDatos($scope.userName, $scope.password);
		var datos = loginService.loginUser('as','12345678a');
		console.log(datos);
		datos.then(function(data){
			if(data==""){
				alert("El usuario o el password es invalido");
			}
			else{
				alert("Deberia funcionar");
				$location.path="/dashboard";
			}
		});
	}

	function initController(){
		loginService.clearCredentials;
	}
}