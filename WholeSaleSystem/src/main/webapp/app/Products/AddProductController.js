angular.module('wholeSaleApp').controller('addProductCtrl' ,['$scope' , '$http' , function ($scope,$http) {

        $scope.submitProduct = function(){
            $http.post('http://172.16.70.95:8080/products/addProduct?name='+$scope.productName+'&desc='+$scope.productDesc+'&price='+$scope.productPrice+'&img='+$scope.productImg+'&type='+$scope.productType+'&margin='+$scope.productMargin)
                .then(function onSuccess(success){
                    $scope.success = "New Product Added";
                },function onError(error){
                    $scope.error = "Could Not Add Product";
                });
        }
    }]);