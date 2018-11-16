angular.module('wholeSaleApp').controller('productCtrl', ['$rootScope', '$scope', function productCtrl($rootScope, $scope) {

    $scope.isAllowed = function () {
        if ($rootScope.role === "ADMIN") {
            return true;
        } else if ($rootScope.role === "SUPPLIER") {
            return true;
        } else {
            return false;
        }
    }

}]);