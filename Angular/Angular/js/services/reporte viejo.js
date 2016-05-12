app.factory('informeService', ['$http', function($http) { 
  return $http.get('http://localhost:8080/informeWS/service/json/getDatos') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);
