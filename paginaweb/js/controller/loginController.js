var app = angular.module('mainApp');
app.controller('loginController',['$scope','$location', '$http', function($scope, $location, $http){
			$scope.login = function(){

			console.log("paso por el controlador")
			
			$http.post("app/userCenter/login",{
				userName:'seeb',
				password:'seeb143'
			}).success(function(){
				console.log("hola");
			});	

	};
}]);	

// $http({
// 	method: 'POST',
// 	url: 'http://localhost:8080/pymeManagmentController/userCenter/login',

// 	data: "{'userName': 'seeb', 'password': 'seeb143' }",
// 	headers: "{'Content-Type': 'application/json'}"
// }).then(function(success){
// 	alert("anduvo")
// },function(error){
// 	console.error(" Error al invocar el ws: " + JSON.stringify(error));
// });



// 			var user = { "userName": $scope.userName, "password": $scope.password } ;
// 			var response =  $http.post('http://localhost:8080/pymeManagmentController/userCenter/login', user);
// 			response.success(function(){
// 				alert("hola");
// 				$location.path('/dashboard');
// 			});
// 			response.error(function(){
// 				alert("Todo una cagada");
// 				$location.href= 'www.google.com';
// 			})
// 			var uname = $scope.userName;
// 			var password = $scope.password;
// 			if( uname == 'admin'  && password == 'admin'){
// 				alert("entro al if");
// 				$location.path('/dashboard');
// 			}else{
// 				alert ("todos putos y cagones");
// 				$location.path('/dashboard');
// 			}
// 	};
// }]);