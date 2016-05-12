angular.module('ReporteApp').factory('informeService', informeService);

function informeService($http,$q){
	var pp = {
		getDatos:getDatos,
		nombre: "leti",
		apellido:"arce",
		getNombre : getNombre
	}
	//lo agrego a propósito para poder hacer referencia a self, desde las funciones (metodos)
	var self = pp;
	
	var flag =true;
	
	return pp;
	
	//tus metodos
	function getDatos(){
		 var deferred = $q.defer();
		$http.get('http://localhost:8080/informeWS/service/json/getDatos') 
			.success(function(data) { 
				deferred.resolve(data); 
			})
        	.error(function(err) { 
				deferred.reject(err); 
			});
		 return deferred.promise;
	}

	function getNombre(){
		//return pp.nombre;
		//return self.nombre;
	}
	function hola(){
		flag = false;
		return "hola";
	}
}

