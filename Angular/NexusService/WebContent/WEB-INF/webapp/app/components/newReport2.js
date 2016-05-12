'use strict';

function change(){
	var elem = document.getElementById("settingButton");
	if (elem.value=="Agregar Setting"){
		elem.value = "Cerrar Panel";
	}else{
		elem.value = "Agregar Setting";
	}
}

angular.element(document).ready(function() {
    angular.bootstrap(document, ['myApp']);
});

angular.module('myApp').factory('Data', function(){
    return { userId: '',     		 
    		 settingId: '',    		 
    		 chartId: '',    		 
    		 query: '',
    		 reportConfig: '',
    		 refreshTime: '',
    		 reportDesc: ''};
});

angular.module('myApp').controller('userSettingController', function($scope,$http,Data) {

	//Obtengo todos los usuarios
	$scope.url = "http://localhost:8080/NexusService/users";	
	
	$http.get($scope.url).then(function(response){		
		$scope.$parent.userData = response.data;		
	});
	
	//Escucho la seleccion de "user" para buscar todos los settings de ese usuario
	$scope.$watch('userSelectedOption',function() {			
			if($scope.userSelectedOption !== undefined) {
				Data.userId = $scope.userSelectedOption;
				$scope.url2 = "http://localhost:8080/NexusService/user="+$scope.userSelectedOption+"/settings";
				$http.get($scope.url2).then(function(response){		
					$scope.$parent.settingData = response.data;					
				});
			};
		}
	);
	
	$scope.$watch('settingSelectedOption',function() {
		if($scope.settingSelectedOption !== undefined){
			Data.settingId = $scope.settingSelectedOption;
		};
	});	
});

angular.module('myApp').controller('chartController', function($scope,$http,Data) {
	
	//Obtengo todos los graficos/charts disponibles
	$scope.url = "http://localhost:8080/NexusService/charts";
	
	$http.get($scope.url).then(function(response){		
		$scope.$parent.chartData = response.data;		
	});
	
	$scope.$watch('chartSelectedOption',function(){
		if($scope.chartSelectedOption !== undefined){
			Data.chartId = $scope.chartSelectedOption;
		};
	});
});

angular.module('myApp').controller('queryController', function($scope,$http,Data) {
	

	//Con las selecciones hechas por el usuario, valido query en BD y obtengo las columnas
	$scope.create = function(data) {
		
		$scope.json = "{"+						
						"\"stmt\":\""+data.query+"\""+
					  "}";
		
		Data.query = data.query;
		
		$scope.url = 'http://localhost:8080/NexusService/user/setting/executeQuery';
		
		$http({
			method: 'POST',
			data: $scope.json,
			url: $scope.url,
			headers: {'Content-Type':'application/json'}
		}).then(function(response){
			$scope.$parent.columns = response.data.rows;
			Data.reportConfig = response.data;
		});
				
	};

});

angular.module('myApp').controller('timeController', function($scope,Data){
	$scope.Data = Data;
});

angular.module('myApp').controller('submitController', function($scope,$http,Data) {
	$scope.create = function(){
		$scope.$parent.userId = Data.userId;
		$scope.$parent.settingId = Data.settingId;
		$scope.$parent.chartId = Data.chartId;
		$scope.$parent.reportConfig = Data.reportConfig;
		$scope.$parent.refreshTime = Data.refreshTime;
		$scope.$parent.query = Data.query;
		$scope.$parent.reportDesc = Data.reportDesc;
		
		$scope.json = "{"+
						"\"settingId\":\""+Data.settingId+"\","+
						"\"reportDesc\":\""+Data.reportDesc+"\","+
						"\"stmt\":\""+Data.query+"\","+
						"\"chartId\":\""+Data.chartId+"\","+
						"\"reportConfig\":"+Data.reportConfig+","+
						"\"refreshTime\":\""+Data.refreshTime+"\""+
					  "}";

		$scope.url = 'http://localhost:8080/NexusService/user/setting/newReport';
		
/*		$http({
			method: 'POST',
			data: $scope.json,
			url: $scope.url,
			headers: {'Content-Type':'application/json'}
		}).then(function(response){
			$scope.$parent.estado = response.data;			
		});*/
	};
});

/*	BACK UP

'use strict';

function change(){
	var elem = document.getElementById("settingButton");
	if (elem.value=="Agregar Setting"){
		elem.value = "Cerrar Panel";
	}else{
		elem.value = "Agregar Setting";
	}
}

angular.element(document).ready(function() {
    angular.bootstrap(document, ['myApp']);
});

angular.module('myApp').controller('userSettingController', function($scope,$http) {

	//Obtengo todos los usuarios
	$scope.url = "http://localhost:8080/NexusService/users";	
	
	$http.get($scope.url).then(function(response){		
		$scope.$parent.userData = response.data;		
	});
	
	//Escucho la seleccion de "user" para buscar todos los settings de ese usuario
	$scope.$watch('userSelectedOption',function() {
			if($scope.userSelectedOption !== undefined){
				$scope.url2 = "http://localhost:8080/NexusService/user="+$scope.userSelectedOption+"/settings";
				$http.get($scope.url2).then(function(response){		
					$scope.$parent.settingData = response.data;
				});
			}			
		}
	);
});

angular.module('myApp').controller('chartController', function($scope,$http) {
	
	//Obtengo todos los graficos/charts disponibles
	$scope.url = "http://localhost:8080/NexusService/charts";
	
	$http.get($scope.url).then(function(response){		
		$scope.$parent.chartData = response.data;		
	});
});

angular.module('myApp').controller('queryController', function($scope,$http) {
	

	//Con las selecciones hechas por el usuario, valido query en BD y obtengo las columnas
	$scope.create = function(data){
		
		$scope.json = "{"+
						"\"settingId\":\"1\","+
						"\"reportDesc\":\"obtener columnas\","+
						"\"stmt\":\""+data.query+"\","+
						"\"chartId\":\"1\","+
						"\"reportConfig\":[{\"name\":\"nada\"}],"+
						"\"refreshTime\":\"10\""+
					  "}";
		
		$scope.url = 'http://localhost:8080/NexusService/user/setting/newReport2';
		
		$http({
			method: 'POST',
			data: $scope.json,
			url: $scope.url,
			headers: {'Content-Type':'application/json'}
		}).then(function(response){
			$scope.$parent.columns = response.data.rows;
		});				
			
	}

});


*/
