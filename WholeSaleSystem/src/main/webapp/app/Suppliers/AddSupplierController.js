 angular.module('wholeSaleApp').controller('addSupplierCtrl' ,['$scope','$http', function ($scope,$http){

            $scope.submitSupplier = function(){
                $http.post('http://172.16.70.95:8080/suppliers/addSupplier?name='+$scope.supplierName+'&contact='+$scope.supplierContact)
                    .then(function onSuccess(success){
                        $scope.success = "New Supplier Added";
                    },function onError(error){
                        $scope.error = "Could Not Add Supplier";
                    });
            }
    }]);
