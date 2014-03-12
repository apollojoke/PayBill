var paybillControllers = angular.module('paybillControllers', []);

paybillControllers.controller('BillListCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/assets/bills/bills.json').success(function (data) {
            $scope.bills = data;
        });

        $scope.orderProp = 'age';
    }]);

paybillControllers.controller('BillCtrl', ['$scope', '$routeParams', '$http',
    function ($scope, $routeParams, $http) {
        $http.get('/assets/bills/' + $routeParams.billId + '.json').success(function (data) {
            $scope.bill = data;
        })
    }]);

paybillControllers.controller('CreateBillCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $scope.list = [];
        $scope.new_member_name = 'member';
        $scope.addMember = function () {
            if ($scope.new_member_name) {
                $scope.list.push(this.new_member_name);
                $scope.new_member_name = '';
            }
        };
        $scope.createBill = function () {
            $scope.new_bill_name = this.new_bill_name;
            $scope.message = {age: 2,
                name: $scope.new_bill_name,
                id: $scope.new_bill_name,
                member: $scope.list};
            $http.post("/createBill", angular.toJson($scope.message)).success(function (data) {
                window.location = "/";

            });
        }
    }
]);

