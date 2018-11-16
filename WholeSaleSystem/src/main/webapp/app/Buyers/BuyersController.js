angular.module('wholeSaleApp').controller('buyerCtrl', [ '$rootScope' , '$scope' , function buyerCtrl($rootScope , $scope) {

    $scope.isAdmin = function () {
        if($rootScope.role === "ADMIN"){
            return true;
        }
        return false;
    }

}]);