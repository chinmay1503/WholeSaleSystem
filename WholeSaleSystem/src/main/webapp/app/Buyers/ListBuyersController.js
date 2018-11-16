angular.module('wholeSaleApp').controller('listBuyerCtrl', ['$scope', '$http', '$state', '$log', 'dataService' ,
    function testBuyerCtrl($scope, $http, $state, $log, dataService) {
    dataService.getAllBuyers()
        .then(getBuyersSuccess);

        $scope.formSubmit = function () {
           alert("submit clicked");
        }
        

    function getBuyersSuccess(buyers) {
        $scope.displayBuyer = buyers;
    }


    $scope.orderByMe = function (x) {
        $scope.myOrderBy = x;
    };

    $scope.selected = {};
    $scope.getTemplate = function (buyers) {
        if (buyers.buyerId === $scope.selected.buyerId) {
            return 'edit';
        }
        else return 'display';
    };

    $scope.edit = function (buyers) {
        $scope.selected = angular.copy(buyers);
    };

    $scope.updateBuyer = function (buyers) {
        $http({
            method: 'PUT',
            url: 'http://172.16.70.95:8080/buyers/updateBuyer?id=' + buyers.buyerId + '&name=' + buyers.buyer_name + '&address=' + buyers.buyer_address + '' +
            '&contact=' + buyers.buyer_phone_no + '&email=' + buyers.buyer_email_id
        }).then(function onSuccess(update) {
            $scope.update = "Buyer Updated";
            $scope.selected = {};
        }, function onError(error) {
            $scope.error = "Could Not Update Buyer";
        });
    };

    $scope.reset = function () {
        $scope.selected = {};
    };

    $scope.delete = function (buyers) {
        $http({
            method: 'DELETE',
            url: 'http://172.16.70.95:8080/buyers/deleteBuyer?id=' + buyers.buyerId
        }).then(console.log("Buyer Deleted"));
    };

    $scope.refresh = function () {
        $log.debug($state.current);
        $state.reload();
    };
}]);
