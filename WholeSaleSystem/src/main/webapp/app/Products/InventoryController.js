angular.module('wholeSaleApp').controller('inventoryCtrl', ['$scope', '$http', '$state', '$log', 'dataService', 'Notification',
    function testBuyerCtrl($scope, $http, $state, $log, dataService, Notification) {
        dataService.getAllProducts()
            .then(getInvSuccess);

        function getInvSuccess(inv) {
            $scope.displayInv = inv;
            for (var i = 0; i < inv.length; i++) {
                if (inv[i].product_quantity < inv[i].min_stock_level) {
                    Notification({
                        message: 'Quantity For ' + inv[i].product_name + ' is Less Than Minimun Stock Required',
                        title: 'Quantity Alert'
                    });
                }
            }
        }

        $scope.orderByMe = function (x) {
            $scope.myOrderBy = x;
        };

        $scope.refresh = function () {
            $log.debug($state.current);
            $state.reload();
        };

        $scope.placeOrder = function () {
            $state.go("home.purchaseorders.addpurchaseorder")
        }


    }]);
