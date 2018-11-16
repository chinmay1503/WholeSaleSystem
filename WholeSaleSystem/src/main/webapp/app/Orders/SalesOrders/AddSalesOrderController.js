angular.module('wholeSaleApp').controller('addSalesOrderCtrl', ['$rootScope', '$scope', '$state', '$http', '$timeout', 'dataService', 'Notification',
    function ($rootScope, $scope, $state, $http, $timeout, dataService, Notification) {

        dataService.getAllProducts()
            .then(getProductsSuccess);

        function getProductsSuccess(products) {
            $scope.displayProduct = products;
        }


        //To Create Sales Order (This is Autocreated as the state loads)
        $http.post('http://172.16.70.95:8080/salesorder/addSalesOrder?buyer_id=' + $rootScope.user_id);


        $timeout(orderCreated, 1000);

        function orderCreated() {
            $http.get('http://172.16.70.95:8080/salesorder/displaySalesOrder')
                .then(function onSuccess(response) {
                    $scope.displaySalesOrder = response.data;
                }, function onError(error) {
                    $scope.error = "Could Not Display"
                });

            //To Add Items To The Order
            $scope.add = function (displaySalesOrder, products, orders) {
                if (orders.ordquantity <= products.product_quantity) {
                    $http.post('http://172.16.70.95:8080/salesitem/addItem?order_id='
                        + displaySalesOrder.salesord_id + '&product_id='
                        + products.product_id + '&quantity='
                        + orders.ordquantity + '&price=' + products.product_price)
                    Notification({message: 'Item Added To Order', title: 'Cart Details'});
                } else {
                    Notification.error({message:'Quantity not in Stock' , title: 'ORDER WARNING!'})
                }
            }
        }

        $scope.confirmOrder = function () {
            Notification({message: 'Order placed. Please Checkout', title: 'Order Placed'});
            $timeout($state.go('home.salesorders.payment'), 3000)
        }

        $scope.cancel = function (displaySalesOrder) {
            $http.delete('http://172.16.70.95:8080/salesorder/deleteSalesOrder?id=' + displaySalesOrder.salesord_id)
            $state.go('home.salesorders');
            Notification.error({message: 'Order Cancelled , you can place a new one', title: 'Order Cancelled!'});
        };
    }]);