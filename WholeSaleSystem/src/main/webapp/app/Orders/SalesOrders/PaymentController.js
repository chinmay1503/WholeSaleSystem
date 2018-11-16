angular.module('wholeSaleApp').controller('paymentCtrl', ['$rootScope', '$scope', '$http', '$state','$interval', 'Notification',
    function productCtrl($rootScope, $scope, $http, $state,$interval, Notification) {

        $scope.orderPlaced = true;

        $http.get('http://172.16.70.95:8080/salesorder/displaySalesOrder')
            .then(function onSuccess(response) {
                $scope.placedOrder = response.data;
            });

        $scope.confirmPayment = function (placedOrder, pay) {
            if (placedOrder.saleprice == pay.payment || placedOrder.saleprice <= pay.payment) {
                $http.put('http://172.16.70.95:8080/salesorder/statusSalesOrder?pay_status=PAID&ord_status=OUT FOR DELIVERY').then(
                    function (value) {
                        $http.get('http://172.16.70.95:8080/salesorder/displaySalesOrder')
                        .then(function onSuccess(response) {
                            $scope.placedOrder = response.data;
                            $scope.apply();
                        });  }
                )
                $scope.orderPlaced = false;
                Notification({
                    message: 'Thank you for placing the Order. You may place a new Order or Logout ',
                    title: 'Payment Confirmed'
                });
            } else {
                Notification({
                    message: 'Thank you for placing the Order. Please pay the full amount',
                    title: 'Payment Notification!'
                });
            }
        }

        $scope.cancelPayment = function (placedOrder) {
            $http.delete('http://172.16.70.95:8080/salesorder/deleteSalesOrder?id=' + placedOrder.salesord_id)
            $state.go('home.salesorders');
            Notification.error({message: 'Order cancelled , You can place a new one', title: 'Order Cancelled!'});
        }

        $scope.newOrder = function () {
            $state.go('home.salesorders.addsalesorder');
        }
    }]);
