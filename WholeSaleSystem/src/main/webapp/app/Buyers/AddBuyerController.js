 angular.module('wholeSaleApp').controller('addBuyerCtrl' ,['$scope','$http' , '$state','$timeout','Notification',
     function ($scope,$http,$state,$timeout,Notification){

            $scope.submitBuyer = function(){
                $http.post('http://172.16.70.95:8080/buyers/addBuyer?name='+$scope.buyerName+'&address='+$scope.buyerAddress+'&contact='+$scope.buyerContact+'&email='+$scope.buyerEmail+'&pass='+$scope.buyerPass)
                    .then(function onSuccess(success){
                        $scope.success = "New Buyer Added";
                        Notification('Thank you ! You may Login Now','Registration Complete');
                        $timeout($state.go('login'),3000);
                    },function onError(error){
                        $scope.error = "Could Not Add Buyer";
                    });
            }
    }]);
