angular.module('ReporteApp').controller('MainController', myFunctionMainController);

function myFunctionMainController($scope, informeService) {
  var datos = informeService.getDatos();
  
  datos.then(function(data){
	var chart = {};
	chart.type = "ColumnChart";
    chart.displayed = false;
    
    chart.data = data;
    
	chart.options = {
      "title": "Sales per month",
      "isStacked": "true",
      "fill": 20,
      "displayExactValues": true,
      "vAxis": {
        "title": "Sales unit",
        "gridlines": {
          "count": 10
        }
      },
      "hAxis": {
        "title": "Date"
      }
    };
    
    $scope.info = chart;
  });
  
  
  $scope.nombre = informeService.getNombre();

  
};
