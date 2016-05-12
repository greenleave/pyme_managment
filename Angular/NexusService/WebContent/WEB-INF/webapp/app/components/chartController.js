'use strict';
    
	angular.module('myApp').controller('chartController', function($scope,$http) {
		
		$scope.chart;
		
		$scope.query = function(data){
			
			$scope.chartTitle = "Cantidad Transacciones por Estado"; //Z_Reports.report_title o nuevo campo
			$scope.chartWidth = 700; //Z_Reference_Report_Chart.chart_width campo con tamaño definido
			$scope.chartHeight = 400; //Z_Reference_Report_Chart.chart_height campo con tamaño definido	
			
			$scope.url = "http://localhost:8080/NexusService/user="+data.user+"&setting="+data.setting+"&report="+data.report+"&chart="+data.chart+"";
			
			$http.get($scope.url).then(function(response){
				
				var data = new google.visualization.DataTable(response.data);
		        
		        var options = {'title': $scope.chartTitle,
		                		'width': $scope.chartWidth,
		                		'height': $scope.chartHeight};
		        
		        //aca tiene que ir un if, para que se grafique según la opción elegida
		        $scope.$parent.chart = new google.charts.Bar(document.getElementById('chart'));
		        
		        $scope.$parent.chart.draw(data, options);
		        
			});
			
		}
	    
/*		$scope.chartTitle = "Cantidad Transacciones por Estado";
		$scope.chartWidth = 900;
		$scope.chartHeight = 600;		
		
		$http.get("http://localhost:8080/NexusService/user=1&setting=1&report=2&chart=1").success(function(response){		
			
			var data = new google.visualization.DataTable(response);
	        
	        var options = {'title': $scope.chartTitle,
	                		'width': $scope.chartWidth,
	                		'height': $scope.chartHeight};
	        
	        var chart = new google.charts.Bar(document.getElementById('chart'));
	        
	        chart.draw(data, options);
	        
		});*/

	});	
	
    google.setOnLoadCallback(function() {
        angular.bootstrap(document.body, ['myApp']);
    });
    google.load("visualization", "1.1", {packages:["bar"]});
