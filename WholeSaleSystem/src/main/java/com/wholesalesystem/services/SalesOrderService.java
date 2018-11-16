package com.wholesalesystem.services;

import com.wholesalesystem.data.SalesOrder;

import java.time.LocalDate;
import java.util.List;

public interface SalesOrderService {

    List<SalesOrder> listAllSalesOrders();

    SalesOrder get();

    void addSalesOrder(int so_buyer_id);

    void updateSalesOrderDeliveryDate(int salesord_id, LocalDate delivery_date);

    void orderStatus(String payment_status , String order_status);

    SalesOrder salesProfit(LocalDate start_Date , LocalDate end_Date);

    void deleteSalesOrder(int salesord_id);

}
