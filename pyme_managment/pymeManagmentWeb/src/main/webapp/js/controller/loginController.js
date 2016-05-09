angular.module('mainApp').controller('loginController', mainLoginController);
function mainLoginController($scope, loginService) {
	$scope.login = function(){
		// var datos = loginService.getDatos($scope.userName, $scope.password);
		var datos = loginService.loginUser('as','12345678a');
		console.log(datos);
		datos.then(function(data){
			if(data==""){
				alert("El usuario o el password es invalido");
			}
			else{
				$window.location.href="/dashboard";
			}
		});
		//Si da error en la conexiÃ³n lo redirijo a otro lugar del mundo

	}
}