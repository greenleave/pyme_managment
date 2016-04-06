angular.module('pymeManagmentApp').controller('loginController', functionLoginController);

function functionLoginController($scope) {
    $scope.submit = function(){
    	var uname = $scope.username;
    	var pass = $scope.pass;
    	alert("Hola");
    }
  }
