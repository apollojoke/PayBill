/**
 * Created by twer on 2/27/14.
 */

function BillListCtrl($scope, $http) {
    $http.get('/assets/bills/bills.json').success(function(data){
        $scope.bills = data;
    })

    $scope.orderProp = 'age';
}

