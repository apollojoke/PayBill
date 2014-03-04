var paybillControllers = angular.module('paybillControllers', []);

paybillControllers.controller('BillListCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/assets/bills/bills.json').success(function(data){
            $scope.bills = data;
        });

        $scope.orderProp = 'age';
    }]);

paybillControllers.controller('BillCtrl', ['$scope', '$routeParams', '$http',
    function($scope, $routeParams, $http) {
            $http.get('/assets/bills/' + $routeParams.billId + '.json').success(function(data){
        $scope.bill = data;
    })
    }]);


