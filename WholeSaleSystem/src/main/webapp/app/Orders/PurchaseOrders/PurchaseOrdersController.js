angular.module('wholeSaleApp').controller('purchaseorderCtrl', ['$rootScope', '$scope', function productCtrl($rootScope, $scope) {

    $scope.isAllowed = function () {
        if ($rootScope.role === "ADMIN") {
            return true;
        }
            return false;
    }

}]);