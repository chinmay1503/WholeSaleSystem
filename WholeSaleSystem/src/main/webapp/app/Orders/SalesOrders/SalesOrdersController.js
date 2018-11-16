angular.module('wholeSaleApp').controller('salesOrderCtrl', ['$rootScope', '$scope', function productCtrl($rootScope, $scope) {

    $scope.isAllowed = function () {
        if ($rootScope.role === "ADMIN") {
            return true;
        }
        return false;
    }

}]);