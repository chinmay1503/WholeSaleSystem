package com.wholesalesystem.controllers;

import com.wholesalesystem.data.OrderDetails;
import com.wholesalesystem.data.PaymentDetails;
import com.wholesalesystem.data.SalesOrder;
import com.wholesalesystem.services.SalesOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

/**
 * SalesOrderController.java - Handles all api requests related to SalesOrders */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "salesorder")
public class SalesOrderController {

    @Autowired
    SalesOrderServiceImpl salesOrderService;

    @RequestMapping(value = "/displayAllSalesOrders" , method = RequestMethod.GET)
    @ResponseBody
    public List<SalesOrder> listAllSalesOrders(){
        List<SalesOrder> salesOrders;
        salesOrders = salesOrderService.listAllSalesOrders();
        return salesOrders;
    }

    @RequestMapping(value = "/displaySalesOrder" , method = RequestMethod.GET)
    @ResponseBody
    public SalesOrder listSalesOrder(){
        SalesOrder salesOrder;
        salesOrder = salesOrderService.get();
        return salesOrder;
    }

    @RequestMapping(value = "/addSalesOrder" , method = RequestMethod.POST)
    @ResponseBody
    public void addSalesOrder(@RequestParam(value = "buyer_id") String buyer_id){
        Integer id = Integer.parseInt(buyer_id);
        salesOrderService.addSalesOrder(id);
    }

    @RequestMapping(value = "/updateSalesOrder" , method = RequestMethod.PUT)
    @ResponseBody
    public void updateSalesOrder(@RequestParam(value = "id") String salesord_id,
                                 @RequestParam(value = "id") String delivery_date) {
        Integer id = Integer.parseInt(salesord_id);
        DateTimeFormatter DATE_FORMAT =  new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy").toFormatter();
        LocalDate expdeldate = LocalDate.parse(delivery_date,DATE_FORMAT);
       // LocalDate expdeldate = LocalDate.of(2018,07,15);
        salesOrderService.updateSalesOrderDeliveryDate(id,expdeldate);
    }




    @RequestMapping(value = "/deleteSalesOrder" , method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSalesOrder(@RequestParam(value = "id") String salesord_id){
        Integer id = Integer.parseInt(salesord_id);
        salesOrderService.deleteSalesOrder(id);
    }

    //--------------------------------------------------BUYER AND ORDER RELATED API-------------------------------------------------------


    @RequestMapping(value="/displayAllOrderDetails", method=RequestMethod.GET)
    @ResponseBody
    public List<OrderDetails> listAllProductsAndType(){
        List<OrderDetails> orders;
        orders = salesOrderService.listAllOrderDetails();
        return orders;
    }

    //To Dispay Buyer Name and Payment Details
    @RequestMapping(value="/displayAllPaymentDetails", method=RequestMethod.GET)
    @ResponseBody
    public List<PaymentDetails> listAllPaymentDetails(){
        List<PaymentDetails> payments;
        payments = salesOrderService.paymentDetails();
        return payments;
    }

    //To Update Payment and order Status After User Payment
    @RequestMapping(value = "/statusSalesOrder" , method = RequestMethod.PUT)
    @ResponseBody
    public void salesOrderStatus(@RequestParam(value = "pay_status") String payment_status,
                                 @RequestParam(value = "ord_status") String order_status) {
        String payment = payment_status.toUpperCase();
        String order = order_status.toUpperCase();
        salesOrderService.orderStatus(payment,order);
    }

    //For Profit Calculation Between Certain Dates
    @RequestMapping(value = "/salesProfit" , method = RequestMethod.GET)
    @ResponseBody
    public SalesOrder salesProfit(@RequestParam(value = "start") String start_date,
                            @RequestParam(value = "end") String end_date) {
        SalesOrder salesOrder;
        DateTimeFormatter DATE_FORMAT =  new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy").toFormatter();
        LocalDate start_Date = LocalDate.parse(start_date,DATE_FORMAT);
        LocalDate end_Date = LocalDate.parse(end_date,DATE_FORMAT);
        salesOrder = salesOrderService.salesProfit(start_Date,end_Date);
        return salesOrder;
    }

}
