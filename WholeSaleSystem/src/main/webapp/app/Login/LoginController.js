angular.module('wholeSaleApp').controller('loginCtrl', ['$rootScope', '$scope', '$http', '$state', function ($rootScope, $scope, $http, $state) {

    $scope.login = function (user) {
        $http.post('http://172.16.70.95:8080/submitLoginForm?username=' + user.inputUser + "&password=" + user.inputPassword)
            .then(function onSuccess(response) {
                $scope.success = response.data;
                var role_id = response.data.role_id;
                $rootScope.user_id = response.data.user_id;
                if (role_id === 1) {
                    $rootScope.role = "ADMIN";
                } else if (role_id === 2) {
                    $rootScope.role = "BUYER";
                } else if (role_id === 3) {
                    $rootScope.role = "SUPPLIER";
                }
                if (role_id === 0) {
                    $scope.error = "Username or password Invalid";  //redirect to home after successful login
                } else {
                    $state.go('home')
                }
            }, function onError(error) {
                $scope.error = "Username or password Invalid"
            })
    }

    $scope.registerBuyer = function () {
        $state.go('register')
    }
}]);
