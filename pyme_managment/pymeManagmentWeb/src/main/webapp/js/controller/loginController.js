var app = angular.module('mainApp');
app.controller('loginController',['$scope','$location', '$http', function($scope, $location, $http){
			$scope.login = function(){
			console.log("paso por el controlador")
			$http({
				method: 'POST',
				url: 'http://localhost:8080/pymeManagmentWeb/app/userCenter/login',
				data: "{'userName': 'as', 'password': '12345678a' }",
				headers: "{'Content-Type': 'application/json'}"
			}).then(function(success){
				json=success.data;
				if(json==""){
					alert("Usuario o password invalido");
				}else{
					alert("Sos un fucking genio");
				}
			},function(error){
				console.error(" Error al invocar el ws: " + JSON.stringify(error));
				$window.location.href="/error";
			});
	};
}])