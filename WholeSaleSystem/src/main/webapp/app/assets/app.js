'use strict';
var wholeSaleApp = angular.module('wholeSaleApp',['ui.router' , 'ui-notification']);
wholeSaleApp.config(['$stateProvider', function($stateProvider) {

            $stateProvider
                .state('login' , {
                    url : '/login',
                    templateUrl : 'app/Login/Login.html',
                    controller : 'loginCtrl'
                })
                .state('register', {
                    url : '/register',
                    templateUrl: 'app/Buyers/AddBuyer.html',
                    controller: 'addBuyerCtrl'
                })
                .state('home' , {
                    url : '/home',
                    templateUrl : 'app/Home/Home.html',
                    controller: 'homeCtrl'
                })
                .state('home.buyers', {
                    url: '/buyers',
                    templateUrl: 'app/Buyers/Buyers.html',
                    controller : 'buyerCtrl'
                })
                .state('home.buyers.addbuyer', {
                    url: '/addbuyer',
                    templateUrl: 'app/Buyers/AddBuyer.html',
                    controller: 'addBuyerCtrl'
                })
                .state('home.buyers.listbuyers', {
                    url: '/listbuyers',
                    templateUrl: 'app/Buyers/ListBuyers.html',
                    controller: 'listBuyerCtrl'
                })
                .state('home.suppliers', {
                    url: '/suppliers',
                    templateUrl: 'app/Suppliers/Suppliers.html',
                    controller : 'supplierCtrl'
                })
                .state('home.suppliers.addsupplier', {
                    url: '/addsupplier',
                    templateUrl: 'app/Suppliers/AddSupplier.html',
                    controller: 'addSupplierCtrl'
                })
                .state('home.suppliers.listsuppliers', {
                    url: '/listsuppliers',
                    templateUrl: 'app/Suppliers/ListSuppliers.html',
                    controller: 'listSupplierCtrl'
                })
                .state('home.products', {
                    url: '/products',
                    templateUrl: 'app/Products/Products.html',
                    controller: 'productCtrl'
                })
                .state('home.products.addproduct', {
                    url: '/addproduct',
                    templateUrl: 'app/Products/AddProduct.html',
                    controller: 'addProductCtrl'
                })
                .state('home.products.listproducts', {
                    url: '/listproducts',
                    templateUrl: 'app/Products/ListProducts.html',
                    controller: 'listProductCtrl'
                })
                .state('home.products.inventory', {
                    url : '/inventory',
                    templateUrl : 'app/Products/Inventory.html',
                    controller : 'inventoryCtrl'
                })
                .state('home.purchaseorders', {
                    url: '/purchaseorders',
                    templateUrl: 'app/Orders/PurchaseOrders/PurchaseOrders.html',
                    controller : 'purchaseorderCtrl'
                })
                .state('home.purchaseorders.addpurchaseorder', {
                    url: '/addpurchaseorder',
                    templateUrl: 'app/Orders/PurchaseOrders/AddPurchaseOrder.html',
                    controller: 'addPurchaseOrderCtrl'
                })
                .state('home.purchaseorders.purchordercreated', {
                    url: '/NewOrder',
                    templateUrl: 'app/Orders/PurchaseOrders/PurchOrderCreated.html',
                    controller: 'purchOrderCtrl'
                })
                .state('home.purchaseorders.listpurchaseorders', {
                    url: '/listpurchaseorders',
                    templateUrl: 'app/Orders/PurchaseOrders/ListPurchOrders.html',
                    controller: 'listPurchOrderCtrl'
                })
                .state('home.salesorders', {
                    url: '/salesorders',
                    templateUrl: 'app/Orders/SalesOrders/SalesOrders.html',
                    controller : 'salesOrderCtrl'
                })
                .state('home.salesorders.addsalesorder', {
                    url: '/addsalesorder',
                    templateUrl: 'app/Orders/SalesOrders/AddSalesOrder.html',
                    controller : 'addSalesOrderCtrl'
                })
                .state('home.salesorders.payment', {
                    url: '/payment',
                    templateUrl: 'app/Orders/SalesOrders/Payment.html',
                    controller : 'paymentCtrl'
                })
                .state('home.salesorders.pendingorders' , {
                    url : '/pendingorders',
                    templateUrl : 'app/Orders/SalesOrders/ListPendingOrders.html',
                    controller : 'pendingCtrl'
                })
                .state('home.salesorders.listsalesorders' , {
                    url : '/listsalesorders',
                    templateUrl : 'app/Orders/SalesOrders/ListSalesOrders.html',
                    controller : 'listSalesOrderCtrl'
                });

}]);

