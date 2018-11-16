angular.module('wholeSaleApp').controller('pendingCtrl', ['$scope','$state', '$http', '$timeout' , 'dataService' , function ($scope,$state, $http, $timeout , dataService) {

    dataService.getAllPending()
        .then(getPendingSuccess);

    function getPendingSuccess(orders) {
        $scope.displayPending = orders;
    }

    $scope.selected = {};
    $scope.getTemplate = function (orders) {
        if (orders.buyer_id === $scope.selected.buyer_id) {
            return 'edit';
        }
        else return 'display';
    };

    $scope.edit = function (orders) {
        $scope.selected = angular.copy(orders);
    };

    $scope.updateOrders = function (orders) {
        $http({
            method: 'PUT',
            url: 'http://172.16.70.95:8080/salesorder/statusSalesOrder?pay_status=' + orders.payment_status + '&ord_status=' + orders.order_status
        }).then(function onSuccess(update) {
            $scope.update = "Pending Order Updated";
            $scope.selected = {};
        }, function onError(error) {
            $scope.error = "Could Not Update Pending Order";
        });
    };

    $scope.reset = function () {
        $scope.selected = {};
    };

    $scope.refresh = function () {
        $state.reload();
    };
}]);
