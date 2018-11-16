<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WholeSale System</title>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script type="text/javascript" src="app/assets/bootstrap/bootstrap.js"></script>


    <!-- Bootstrap.css-->
    <link rel="stylesheet" href="app/assets/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="app/assets/css/header.css">
    <link rel="stylesheet" href="app/assets/css/signin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-notification/0.3.6/angular-ui-notification.css">

    <script type="text/javascript" src="app/assets/redirect.js"></script>
</head>

<body ng-app="wholeSaleApp" style="background-color: #343a40">
<div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" id="logo" ui-sref="login">WSS</a>
</nav>

<div class="container">
    <div ui-view=""></div>
</div>
</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular-resource.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.19/angular-ui-router.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-notification/0.3.6/angular-ui-notification.js"></script>

<script type="text/javascript" src="https://rawgit.com/betsol/angular-input-date/master/src/angular-input-date.js"></script>

<!--Importing & Declaring Global Module & Routing Logic -->
<script type="text/javascript" src="app/assets/app.js"></script>
<script type="text/javascript" src="app/assets/dataService.js"></script>

<!--Importing Buyer Controllers -->
<script type="text/javascript" src="app/Buyers/BuyersController.js"></script>
<script type="text/javascript" src="app/Buyers/AddBuyerController.js"></script>
<script type="text/javascript" src="app/Buyers/ListBuyersController.js"></script>

<!--Importing Supplier Controllers -->
<script type="text/javascript" src="app/Suppliers/SuppliersController.js"></script>
<script type="text/javascript" src="app/Suppliers/AddSupplierController.js"></script>
<script type="text/javascript" src="app/Suppliers/ListSuppliersController.js"></script>

<!--Importing Products Controllers -->
<script type="text/javascript" src="app/Products/ProductController.js"></script>
<script type="text/javascript" src="app/Products/AddProductController.js"></script>
<script type="text/javascript" src="app/Products/ListProductsController.js"></script>
<script type="text/javascript" src="app/Products/InventoryController.js"></script>

<!--Importing PurchaseOrder Controllers -->
<script type="text/javascript" src="app/Orders/PurchaseOrders/PurchaseOrdersController.js"></script>
<script type="text/javascript" src="app/Orders/PurchaseOrders/AddPurchaseOrderController.js"></script>
<script type="text/javascript" src="app/Orders/PurchaseOrders/ListPurchOrdersController.js"></script>
<script type="text/javascript" src="app/Orders/PurchaseOrders/PurchOrderCreatedController.js"></script>


<!--Importing SalesOrders Controllers -->
<script type="text/javascript" src="app/Orders/SalesOrders/SalesOrdersController.js"></script>
<script type="text/javascript" src="app/Orders/SalesOrders/AddSalesOrderController.js"></script>
<script type="text/javascript" src="app/Orders/SalesOrders/ListSalesOrdersController.js"></script>
<script type="text/javascript" src="app/Orders/SalesOrders/PaymentController.js"></script>
<script type="text/javascript" src="app/Orders/SalesOrders/ListPendingOrderController.js"></script>

<!-- Importing Login Controller -->
<script type="text/javascript" src="app/Login/LoginController.js"></script>

<!-- Importing Home/Main Page Controller -->
<script type="text/javascript" src="app/Home/HomeController.js"></script>


</body>
</html>
