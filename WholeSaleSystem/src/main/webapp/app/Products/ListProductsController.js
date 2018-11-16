angular.module('wholeSaleApp').controller('listProductCtrl', ['$rootScope','$scope', '$http' ,'dataService',
    function ($rootScope,$scope, $http , dataService) {

    dataService.getAllProducts()
        .then(getProductsSuccess);

    function getProductsSuccess(products) {
        $scope.displayProduct = products;
    }

    $scope.edit = function (products) {
        $scope.selected = angular.copy(products);
    };

    $scope.updateProduct = function (products) {
        $http({
            method: 'PUT',
            url: 'http://172.16.70.95:8080/products/updateProduct?id=' + products.product_id + '&name=' + products.product_name + '&desc=' + products.product_desc + '' +'&price=' + products.product_price
        }).then(function onSuccess(update) {
            $scope.update = "Product Updated";
            $scope.selected = {};
        }, function onError(error) {
            $scope.error = "Could Not Update Product";
        });
    };

    $scope.reset = function () {
        $scope.selected = {};
    };

    $scope.delete = function (products) {
        $http({
            method: 'DELETE',
            url: 'http://172.16.70.95:8080/products/deleteProduct?id=' + products.product_id
        }).then(console.log("Product Deleted"));
    };


    //Only allow Operation to Admin
    $scope.isAllowed = function () {
        if ($rootScope.role === "ADMIN") {
            return true;
        }
        return false;
    }

}]);