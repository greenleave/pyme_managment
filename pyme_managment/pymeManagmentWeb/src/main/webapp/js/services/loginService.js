angular.module('mainApp').factory('loginService', loginService);
loginService.$inject = ['$http', '$rootScope'];
function loginService($http,$q){

	var service = 	{
						loginUser:loginUser,
						setCredentials: setCredentials,
						clearCredentials: clearCredentials
					}
	return service;

// a lo que esta declarado como .then o ,function(error) se lo llama promesas. Eso es lo que returna el deferred.promise
	function loginUser(userName, userPassword){
		alert(userName);
		alert(userPassword);
		var deferred = $q.defer();
		$http({
				method: 'POST',
				url: 'http://localhost:8080/pymeManagmentWeb/app/userCenter/login',
				data: "{'userName': 'as', 'password': '12345678a' }",
				headers: "{'Content-Type': 'application/json'}"
			}).then(function(success){
				deferred.resolve(success.data);
			},function(error){
				deferred.reject(error); 
			});
		return deferred.promise;		
	}

	function clearCredentials(){
		alert("clearCredentials");	
	}
	
	function setCredentials(){
		alert("setCredentials");
	}

}



// angular.module('mainApp').factory('loginService', loginService);

// function loginService($http,$q){

// 	var pp = 	{
// 					loginUser:loginUser
// 				}
// 	return pp;

// // a lo que esta declarado como .then o ,function(error) se lo llama promesas. Eso es lo que returna el deferred.promise
// 	function loginUser(){
// 		var deferred = $q.defer();
// 		$http({
// 				method: 'POST',
// 				url: 'http://localhost:8080/pymeManagmentWeb/app/userCenter/login',
// 				data: "{'userName': 'as', 'password': '12345678a' }",
// 				headers: "{'Content-Type': 'application/json'}"
// 			}).then(function(success){
// 				deferred.resolve(success.data);
// 			},function(error){
// 				deferred.reject(error); 
// 			});
// 		return deferred.promise;		
// 	}
// }