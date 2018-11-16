angular.module('wholeSaleApp').controller('addPurchaseOrderCtrl', ['$scope', '$http', '$timeout', '$state', 'dataService', 'Notification',
    function ($scope, $http, $timeout, $state, dataService , Notification) {

        dataService.getAllProducts()
            .then(getProductsSuccess);

        function getProductsSuccess(products) {
            $scope.displayProduct = products;
        }

        $scope.isCreated = true;

        $scope.submitPurchOrder = function () {
            var day;
            var month;
            if(($scope.deliveryDate.getMonth()+1) < 10 || $scope.deliveryDate.getDate() < 10)
            {
                day =  "0"+ $scope.deliveryDate.getDate();
                month = "0"+ ($scope.deliveryDate.getMonth()+1);
            }
            else {
                month = ($scope.deliveryDate.getMonth()+1)
            }
            $scope.deliveryDate = day +"-" +month + "-" +$scope.deliveryDate.getFullYear();
            $http.post('http://172.16.70.95:8080/purchaseorders/addPurchaseOrder?id=' + $scope.supplierId + '&date=' + $scope.deliveryDate)
                .then(function onSuccess(response) {
                    $scope.displayPurchOrder = response.data;
                    $state.go('home.purchaseorders.purchordercreated')
                }, function onError(reason) {
                    $scope.error = "Could Not Display";
                });
        };


        $scope.add = function (displayPurchOrder, products, orders) {
            var item = {};
            $http.post('http://172.16.70.95:8080/purchaseitems/addItem?purchase_id=' + displayPurchOrder.purchaseord_id + '&item_id=' + products.product_id + '&quantity=' + orders.ordquantity + '&price=' + products.product_price);
            item.pi_purchase_id = displayPurchOrder.purchaseord_id;
            item.pi_product_id = products.product_id;
            item.pi_quantity = orders.ordquantity;
            item.pi_unit_price = products.product_price;
            Notification({message: 'Item Added To Order', title: 'Cart Details'});
        };

     $scope.confirmOrder = function() {
         Notification({message: 'You can place a New Order', title: 'Order Placed'});
         $timeout($state.reload() , 3000)
     }

        $scope.cancel = function (displayPurchOrder) {
            $http.delete('http://172.16.70.95:8080/purchaseorders/deletePurchaseOrder?id=' + displayPurchOrder.purchaseord_id);
            $state.reload();
            Notification.error({message: 'Order Cancelled , you can place a new one', title: 'Order Cancelled!'});
        };

    }]);
