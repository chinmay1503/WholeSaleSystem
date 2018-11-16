(function(){

    angular.module('wholeSaleApp')
        .factory('dataService' , function ($q , $http){
            return{
                getAllBuyers : getAllBuyers,
                getAllProducts : getAllProducts,
                getAllSuppliers : getAllSuppliers,
                getAllPurchOrders : getAllPurchOrders,
                getAllSalesOrders : getAllSalesOrders,
                getAllPending : getAllPending
            };

            function getAllBuyers() {
                return $http({
                    method: 'GET',
                    url: 'http://172.16.70.95:8080/buyers/displayAllBuyers'
                }).then(sendResponseData)
                    .catch(sendGetBuyersError);
            }

            function sendResponseData(response) {
                return response.data;
            }

            function sendGetBuyersError(response){
                return $q.reject('Error returning Buyers. (HTTP status : ' + response.status + ')');
            }

            function getAllProducts() {
                return $http({
                    method: 'GET',
                    url: 'http://172.16.70.95:8080/products/displayAllDetails'
                }).then(sendResponseData)
                    .catch(sendGetProductsError);
            }


            function sendGetProductsError(response){
                return $q.reject('Error returning Products. (HTTP status : ' + response.status + ')');
            }

            function getAllSuppliers() {
                return $http({
                    method: 'GET',
                    url: 'http://172.16.70.95:8080/suppliers/displayAllSuppliers'
                }).then(sendResponseData)
                    .catch(sendGetSuppliersError);
            }


            function sendGetSuppliersError(response){
                return $q.reject('Error returning Suppliers. (HTTP status : ' + response.status + ')');
            }

            function getAllSalesOrders() {
                return $http({
                    method: 'GET',
                    url: 'http://172.16.70.95:8080/salesorder/displayAllSalesOrders'
                }).then(sendResponseData)
                    .catch(sendGetOrdersError);
            }

            function getAllPurchOrders() {
                return $http({
                    method: 'GET',
                    url: 'http://172.16.70.95:8080/purchaseorders/displayAllPurchaseOrders'
                }).then(sendResponseData)
                    .catch(sendGetOrdersError);
            }


            function sendGetOrdersError(response){
                return $q.reject('Error returning Purchase Orders. (HTTP status : ' + response.status + ')');
            }

            function getAllPending() {
                return $http({
                    method: 'GET',
                    url: 'http://172.16.70.95:8080/salesorder/displayAllPaymentDetails'
                }).then(sendResponseData)
                    .catch(sendGetPendingError);
            }


            function sendGetPendingError(response){
                return $q.reject('Error returning Purchase Orders. (HTTP status : ' + response.status + ')');
            }


        });
}());
