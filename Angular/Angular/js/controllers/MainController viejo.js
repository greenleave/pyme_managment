angular.module('ReporteApp').controller('MainController', ['$scope', 'informeService', function($scope, informeService) {
  informeService.success(function(data) {
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
}]);
