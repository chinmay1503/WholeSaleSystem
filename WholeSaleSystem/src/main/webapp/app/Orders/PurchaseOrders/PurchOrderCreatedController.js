angular.module('wholeSaleApp').controller('purchOrderCtrl', ['$scope', '$http', '$timeout', '$state', 'dataService', 'Notification',
    function ($scope, $http, $timeout, $state, dataService, Notification) {

        dataService.getAllProducts()
            .then(getProductsSuccess);

        function getProductsSuccess(products) {
            $scope.displayProduct = products;
        }

        $http.get('http://172.16.70.95:8080/purchaseorders/displayPurchaseOrder')
            .then(function onSuccess(response) {
                $scope.displayPurchOrder = response.data;
            });

        $scope.add = function (displayPurchOrder, products, orders) {
            var item = {};
            $http.post('http://172.16.70.95:8080/purchaseitems/addItem?purchase_id=' + displayPurchOrder.purchaseord_id + '&item_id=' + products.product_id + '&quantity=' + orders.ordquantity + '&price=' + products.product_price);
            $scope.displayPurchOrder.purchprice = $scope.displayPurchOrder.purchprice +products.product_price;
            item.pi_purchase_id = displayPurchOrder.purchaseord_id;
            item.pi_product_id = products.product_id;
            item.pi_quantity = orders.ordquantity;
            item.pi_unit_price = products.product_price;
            Notification({message: 'Item Added To Order', title: 'Cart Details'});
            $scope.apply();
        };

        $scope.confirmOrder = function () {
            Notification({message: 'You can place a New Order', title: 'Order Placed'});
            $state.go('home.purchaseorders.addpurchaseorder');
        };

        $scope.cancel = function (displayPurchOrder) {
            $http.delete('http://172.16.70.95:8080/purchaseorders/deletePurchaseOrder?id=' + displayPurchOrder.purchaseord_id);
            $state.go('home.purchaseorders.addpurchaseorder');
            Notification.error({message: 'Order Cancelled , you can place a new one', title: 'Order Cancelled!'});
        };
    }]);