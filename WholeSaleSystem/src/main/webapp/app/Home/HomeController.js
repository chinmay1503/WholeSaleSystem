angular.module('wholeSaleApp').controller('homeCtrl', ['$scope', '$rootScope',
    function ($scope, $rootScope) {

        $scope.user = $rootScope.userName;


        $scope.isAllowed = function () {
            if ($rootScope.role === "ADMIN") {
                return true;
            }
                return false;
        }

        $scope.isBuyer = function () {
            if ($rootScope.role === "ADMIN") {
                return true;
            } else if ($rootScope.role === "BUYER") {
                return true;
            } else {
            return false;
            }
        }

        $scope.isSupplier = function () {
            if ($rootScope.role === "ADMIN") {
                return true;
            } else if ($rootScope.role === "SUPPLIER") {
                return true;
            } else {
                return false;
            }
        }

    }]);

