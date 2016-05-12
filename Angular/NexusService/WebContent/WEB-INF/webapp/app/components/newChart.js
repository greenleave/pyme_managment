'use strict';

angular.element(document).ready(function() {
    angular.bootstrap(document, ['myApp']);
});

angular.module('myApp').controller('newChart', function($scope,$http) {		
	
	$scope.create = function(data){			
		
		$scope.json = "{\"chartId\":\""+data.chart+"\",\"description\":\""+data.desc+"\"}";
		
		$http({
			method: 'POST',
			data: $scope.json,
			url:'http://localhost:8080/NexusService/user/newChart',
			headers: {'Content-Type':'application/json'}
		}).then(function(response){
			$scope.$parent.estado = response.data;
		});				
			
	}

});