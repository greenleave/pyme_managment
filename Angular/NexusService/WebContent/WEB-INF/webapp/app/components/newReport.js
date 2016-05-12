'use strict';

angular.element(document).ready(function() {
    angular.bootstrap(document, ['myApp']);
});

angular.module('myApp').controller('newReport', function($scope,$http) {		
	
	$scope.create = function(data){

		$scope.json = "{"+
						"\"settingId\":\""+data.setting+"\","+
						"\"reportDesc\":\""+data.desc+"\","+
						"\"stmt\":\""+data.query+"\","+
						"\"chartId\":\""+data.chart+"\","+
						"\"reportConfig\":["+data.reportConfig+"],"+
						"\"refreshTime\":\""+data.refreshTime+"\""+
					  "}";
		
		$http({
			method: 'POST',
			data: $scope.json,
			url:'http://localhost:8080/NexusService/user/setting/newReport',
			headers: {'Content-Type':'application/json'}
		}).then(function(response){
			$scope.$parent.estado = response.data;
		});				
			
	}

});