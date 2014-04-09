/* App Module */

var billApp = angular.module('billApp', [
    'ngRoute',
    'ngTouch',
    'paybillControllers'
]);

billApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/billList', {
                templateUrl: "assets/templetes/bill_list.html",
                controller: 'BillListCtrl'
            }).
            when('/billList/:billId', {
                templateUrl: "assets/templetes/bill_page.html",
                controller: 'BillCtrl'
            }).
            when('/newBill', {
                templateUrl: "assets/templetes/new_bill.html",
                controller: 'CreateBillCtrl'
            }).
            when('/createRecord', {
                templateUrl: "assets/templetes/new_record.html",
                controller: 'CreateRecordCtrl'
            }).
            otherwise({
                redirectTo: '/billList'
            });
    }]);