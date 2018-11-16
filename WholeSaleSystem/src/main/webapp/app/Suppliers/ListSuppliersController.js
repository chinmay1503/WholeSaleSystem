angular.module('wholeSaleApp').controller('listSupplierCtrl', ['$rootScope','$scope', '$http', '$state', '$log', 'dataService',
    function testBuyerCtrl($rootScope,$scope, $http, $state, $log, dataService) {
        dataService.getAllSuppliers()
            .then(getSuppliersSuccess);

        function getSuppliersSuccess(suppliers) {
            $scope.displaySupplier = suppliers;
        }


        $scope.orderByMe = function (x) {
            $scope.myOrderBy = x;
        };

        $scope.selected = {};
        $scope.getTemplate = function (suppliers) {
            if (suppliers.supplier_id === $scope.selected.supplier_id) {
                return 'edit';
            }
            else return 'display';
        };

        $scope.edit = function (suppliers) {
            $scope.selected = angular.copy(suppliers);
        };

        $scope.updateSupplier = function (suppliers) {
            $http({
                method: 'PUT',
                url: 'http://172.16.70.95:8080/suppliers/updateSupplier?id=' + suppliers.supplier_id + '&name=' + suppliers.supplier_name + '&contact=' + suppliers.supplier_phone_no
            }).then(function onSuccess(update) {
                $scope.update = "Supplier Updated";
                $scope.selected = {};
            }, function onError(error) {
                $scope.error = "Could Not Update Supplier";
            });
        };

        $scope.reset = function () {
            $scope.selected = {};
        };

        $scope.delete = function (suppliers) {
            $http({
                method: 'DELETE',
                url: 'http://172.16.70.95:8080/suppliers/deleteSupplier?id=' + suppliers.supplier_id
            }).then(console.log("Supplier Deleted"));
        };

        $scope.refresh = function () {
            $log.debug($state.current);
            $state.reload();
        };

        //To Only Allow Admins to perform edit & delete Operations
        $scope.isAllowed = function () {
            if ($rootScope.role === "ADMIN") {
                return true;
            }
            return false;
        }

    }]);
