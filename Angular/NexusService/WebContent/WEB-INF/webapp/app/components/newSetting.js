'use strict';

angular.element(document).ready(function() {
    angular.bootstrap(document, ['myApp']);
});

angular.module('myApp').controller('newSetting', function($scope,$http) {		
	
	$scope.create = function(data){			
		
		$scope.json = "{\"settingId\":\""+data.setting+"\",\"description\":\""+data.desc+"\",\"userId\":\""+data.user+"\"}";
		
		$http({
			method: 'POST',
			data: $scope.json,
			url:'http://localhost:8080/NexusService/user/newSetting',
			headers: {'Content-Type':'application/json'}
		}).then(function(response){
			$scope.$parent.estado = response.data;
		});				
			
	}

});