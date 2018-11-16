angular.module('wholeSaleApp').controller('listPurchOrderCtrl', ['$scope', '$http', '$state', '$log', 'dataService' ,
    function testBuyerCtrl($scope, $http, $state, $log, dataService) {
    dataService.getAllPurchOrders()
        .then(getOrdersSuccess);

    function getOrdersSuccess(orders) {
        $scope.displayOrders = orders;
    }

    $scope.orderByMe = function (x) {
        $scope.myOrderBy = x;
    };

/* Some Issue which is not displaying record properly
    $http.get('http://172.16.70.95:8080/purchaseorders/displayPurchaseOrder')
        .then(function onSuccess(response){
        $scope.displaySingleOrders = response.data;
    });
*/

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
        }).then(function (value) {
            console.log("Order Deleted");
            $state.reload()
            Notification({message: 'Order Has Been Deleted', title: 'Order Deleted!'});
        });
    };

    $scope.refresh = function () {
        $log.debug($state.current);
        $state.reload();
    };
}]);
