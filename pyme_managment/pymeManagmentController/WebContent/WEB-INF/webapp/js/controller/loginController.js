var app = angular.module('mainApp');
app.controller('loginController',['$scope','$location', '$http', function($scope, $location, $http){
			$scope.login = function(){
			console.log("paso por el controlador");
			$http({
			    url: 'http://localhost:8080/pymeManagmentController/userCenter/login',
			    method: 'POST',
			    data: "{'userName': 'seeb', 'password': 'seeb143' }",
			    transformRequest: false,
			    headers: {
                "Authorization": "Basic " + $scope.encoded,
                "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
            	},
			}).then(function(success){
				alert("anduvo")
			},function(error){
				console.error(" Error al invocar el ws: " + JSON.stringify(error))
			});
	};
}]);



// $http.post('http://localhost:8080/pymeManagmentController/userCenter/login');