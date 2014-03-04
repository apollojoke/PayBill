/* App Module */

var billApp = angular.module('billApp', [
    'ngRoute',
    'paybillControllers'
]);

billApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/billList', {
                templateUrl: "assets/bill_list.html",
                controller: 'BillListCtrl'
            }).
            when('/billList/:billId', {
                templateUrl: "assets/bill_page.html",
                controller: 'BillCtrl'
            }).
            otherwise({
                redirectTo: '/billList'
            });
    }]);