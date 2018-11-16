angular.module('wholeSaleApp').controller('listSalesOrderCtrl', ['$scope', '$http', '$state', '$log', 'dataService' ,
    function testBuyerCtrl($scope, $http, $state, $log, dataService) {
    dataService.getAllSalesOrders()
        .then(getOrdersSuccess);

    function getOrdersSuccess(orders) {
        $scope.orderDetails = orders;
    }

    $scope.orderByMe = function (x) {
        $scope.myOrderBy = x;
    };


    $scope.isCreated = true;

    $scope.calculateProfit = function() {
        var start_date;
        var end_date;
        var start_month;
        var end_month;
        if(($scope.startDate.getMonth()+1) < 10 || $scope.startDate.getDate() < 10)
        {
            start_date = "0"+ $scope.startDate.getDate;
            start_month = "0"+ ($scope.startDate.getMonth()+1)
        }
        else {
            start_month = ($scope.startDate.getMonth()+1)
        }
        if(($scope.endDate.getMonth()+1) < 10 || $scope.endDate.getDate() < 10 )
        {
            end_date = "0"+ $scope.endDate.getDate;
            end_month = "0"+ ($scope.endDate.getMonth()+1)
        }
        else {
            end_month = ($scope.endDate.getMonth()+1)
        }
        $scope.startDate = start_date +"-" +start_month + "-" +$scope.startDate.getFullYear();
        $scope.endDate = end_date +"-" +end_month + "-" +$scope.endDate.getFullYear();
    $http.get('http://172.16.70.95:8080/salesorder/salesProfit?start='+$scope.startDate+'&end='+$scope.endDate)
        .then(function onSuccess(response){
        $scope.profit = response.data;
    });
    };

/* $scope.updateBuyer = function (buyers) {
        $http({
            method: 'PUT',
            url: 'http://172.16.70.95:8080/buyers/updateBuyer?id=' + buyers.buyerId + '&name=' + buyers.buyer_name + '&address=' + buyers.buyer_address + '' +
            '&contact=' + buyers.buyer_phone_no + '&email=' + buyers.buyer_email_id
        }).then(function onSuccess(update) {
            $scope.update = "Buyer Updated";
            $scope.selected = {};
        }, function onError(error) {
            $scope.error = "Could Not Update Buyer";
        });
    };*/


    $scope.reset = function () {
        $scope.selected = {};
    };

    $scope.delete = function (orders) {
        $http({
            method: 'DELETE',
            url: 'http://172.16.70.95:8080/purchaseorders/deletePurchaseOrder?id=' + orders.purchaseord_id
        }).then(console.log("Order Deleted"));
    };

    $scope.refresh = function () {
        $log.debug($state.current);
        $state.reload();
    };
}]);
