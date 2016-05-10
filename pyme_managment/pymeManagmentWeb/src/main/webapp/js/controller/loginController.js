angular.module('mainApp').controller('loginController', mainLoginController);
//Le inyecto como dependencia $location y loginService (es mi servicio)
mainLoginController.$inject = ['$location', 'loginService'];
function mainLoginController($scope, $location, loginService) {
	var objectJs=this;	
	objectJs.login = function(){
		// var datos = loginService.getDatos($scope.userName, $scope.password);
		var datos = loginService.loginUser(objectJs.userName,objectJs.password);
		console.log(datos);
		datos.then(function(data){
			if(data==""){
				alert("El usuario o el password es invalido");
			}
			else{
				alert("El usuario es valido y no se por que");
			}
		}),datos.error(function(error){
			alert("Se a producido un error al conectarse con el server");
		});
		//Si da error en la conexiÃƒÂ³n lo redirijo a otro lugar del mundo
	}
}


// angular.module('mainApp').controller('loginController', mainLoginController);
// function mainLoginController($scope, loginService) {
// 	$scope.login = function(){
// 		// var datos = loginService.getDatos($scope.userName, $scope.password);
// 		var datos = loginService.loginUser('as','12345678a');
// 		console.log(datos);
// 		datos.then(function(data){
// 			if(data==""){
// 				alert("El usuario o el password es invalido");
// 			}
// 			else{
// 				$window.location.href="/dashboard";
// 			}
// 		});
// 		//Si da error en la conexiÃ³n lo redirijo a otro lugar del mundo

// 	}
// }