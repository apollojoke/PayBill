var paybillControllers = angular.module('paybillControllers', []);

paybillControllers.controller('BillListCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/showBills').success(function (data) {
            $scope.bills = data;
        });
        $scope.orderProp = 'id';
    }]);

paybillControllers.controller('BillCtrl', ['$scope', '$routeParams', '$http',
    function ($scope, $routeParams, $http) {
        $http.get('/billDetail?id=' + $routeParams.billId).success(function (data) {
            $scope.bill = data;
            $scope.members = $scope.bill.members;
        })
    }]);

paybillControllers.controller('CreateBillCtrl', ['$scope', '$http',
    function ($scope, $http) {
        var memberId = 0;
        $scope.list = [];
        $scope.new_member_name = 'nancy';
        $scope.addMember = function () {
            memberId += 1;
            if ($scope.new_member_name) {
                $scope.member = {
                    id: memberId,
                    name: $scope.new_member_name,
                    money: 0.0
                }
                $scope.list.push(this.member);
                $scope.new_member_name = '';
            }
        };
        $scope.createBill = function () {
            $scope.new_bill_name = this.new_bill_name;
            $scope.message = {
                name: $scope.new_bill_name,
                members: $scope.list};
            $http.post("/createBill", angular.toJson($scope.message)).success(function (data) {
                window.location = "/";
            });
        }
    }
]);

paybillControllers.controller('CreateRecordCtrl', ['$scope', '$routeParams','$http',
    function ($scope, $routeParams, $http) {
        $scope.member_name = $routeParams.member;
        $scope.member_id = $routeParams.memberId;
        $scope.bill_id = $routeParams.billId;
        $scope.save = function(){
            $scope.message = {
                billId: $scope.bill_id,
                payer: $scope.member_name,
                payerId:$scope.member_id,
                cost: $scope.cost,
                subject: $scope.subject
            };
            $http.post('/createRecord', angular.toJson($scope.message)).success(
                function(){
                    window.location = "#/billList/" + $scope.bill_id;
                }
            );
        }
    }
]);

